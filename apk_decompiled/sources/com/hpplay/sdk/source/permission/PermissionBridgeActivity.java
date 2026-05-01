package com.hpplay.sdk.source.permission;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.Window;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.Feature;

/* loaded from: classes3.dex */
public class PermissionBridgeActivity extends Activity {
    private static final int CODE_OVERLAY_PERMISSION = 1234;
    private static final int CODE_RECORD_AUDIO = 10;
    public static final String KEY_HAS_SYSTEM_WINDOW_PERMISS = "key_has_window_permiss";
    public static final String KEY_MIRROR_AUDIO_TYPE = "mirror_audio_type";
    public static final String KEY_PERMISSION_TYPE = "permission_type";
    private static final int PERMISSION_MIRROR = 1;
    public static final int PERMISSION_READ_SDCARD = 2;
    public static final int PERMISSION_RECORD_AUDIO = 3;
    private static final String TAG = "PermissionBridgeActivity";
    private static Handler handler;
    private long start;
    private int mPermissionType = 0;
    private int mMirrorAudioType = -1;
    private boolean isNewCreate = true;
    private boolean isCheck = false;
    private boolean hasSystemWindowPermission = false;
    private boolean isRequestSystemWindow = false;

    private boolean requestWindowPermission() {
        return Preference.getInstance().get(Constant.KEY_REQUEST_SYSTEM_WINDOW_PERMISS, Build.VERSION.SDK_INT < 28);
    }

    private void setStyle() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
            setTitle((CharSequence) null);
            SourceLog.i(TAG, "change status bar style to trans");
        }
    }

    private void showPermission() {
        this.isCheck = true;
        if (this.mPermissionType == 2) {
            SourceLog.i(TAG, "start get sdcard permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
        } else {
            SourceLog.i(TAG, "start get audio permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        finishBridgeAct("dispatchTouchEvent");
        return true;
    }

    public void finishBridgeAct(String str) {
        SourceLog.i(TAG, "finish bridge act:" + str);
        SourceLog.i("ptime", (System.currentTimeMillis() - this.start) + "  s");
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        SourceLog.i(TAG, "onActivityResult requestCode:" + i10 + " resultCode:" + i11);
        if (i10 == 1) {
            if (-1 == i11) {
                if (LelinkSdkManager.getInstance().mPermissionListener != null) {
                    LelinkSdkManager.getInstance().mPermissionListener.onNotifyCast(intent);
                }
            } else if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, 211002);
            }
        } else if (i10 == CODE_OVERLAY_PERMISSION) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.permission.PermissionBridgeActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    PermissionBridgeActivity.this.registerMediaProjectionPermission(1);
                }
            }, 100L);
            return;
        }
        finishBridgeAct("onActivityResult");
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        handler = new Handler(getMainLooper());
        setStyle();
        this.start = System.currentTimeMillis();
        Intent intent = getIntent();
        if (intent == null) {
            SourceLog.e(TAG, "onCreate intent == null");
            finish();
            return;
        }
        this.mPermissionType = intent.getIntExtra(KEY_PERMISSION_TYPE, 0);
        this.mMirrorAudioType = intent.getIntExtra(KEY_MIRROR_AUDIO_TYPE, -1);
        SourceLog.i(TAG, "onCreate " + this.mPermissionType);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SourceLog.i(TAG, "PermissionBridgeActivity  onNewIntent ");
    }

    @Override // android.app.Activity
    public void onResume() {
        boolean canDrawOverlays;
        super.onResume();
        SourceLog.i(TAG, "PermissionBridgeActivity  onResume " + this.mPermissionType);
        try {
            int i10 = this.mPermissionType;
            if (i10 != 3 && this.isCheck) {
                if (i10 == 2) {
                    SourceLog.i(TAG, "send local media");
                    if (LelinkSdkManager.getInstance().mPermissionListener != null) {
                        LelinkSdkManager.getInstance().mPermissionListener.onNotifyCast(null);
                    }
                }
                finishBridgeAct("onResume again");
                return;
            }
            if (i10 == 2) {
                showPermission();
                return;
            }
            if (this.isNewCreate && !this.isRequestSystemWindow) {
                SourceLog.i(TAG, "PermissionBridgeActivity  onResume  isNewCreate:" + this.isNewCreate);
                if (!this.isCheck && this.mMirrorAudioType != 0 && ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == -1) {
                    SourceLog.i(TAG, "not audio permission ");
                    showPermission();
                    return;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    this.hasSystemWindowPermission = Preference.getInstance().get(KEY_HAS_SYSTEM_WINDOW_PERMISS, false);
                    SourceLog.i(TAG, "PermissionBridgeActivity  onResume  hasSystemWindowPermission:" + this.hasSystemWindowPermission);
                    if (!this.hasSystemWindowPermission && !Feature.isMirrorCustomMode() && requestWindowPermission()) {
                        this.isRequestSystemWindow = true;
                        SourceLog.i(TAG, " -------------- > " + this.isRequestSystemWindow);
                        canDrawOverlays = Settings.canDrawOverlays(this);
                        if (!canDrawOverlays) {
                            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), CODE_OVERLAY_PERMISSION);
                            return;
                        }
                        Preference.getInstance().put(KEY_HAS_SYSTEM_WINDOW_PERMISS, true);
                    }
                }
                registerMediaProjectionPermission(2);
            }
            this.isNewCreate = false;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            finishBridgeAct("onResume error");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.isRequestSystemWindow) {
            return;
        }
        finishBridgeAct("onStop");
    }

    public void registerMediaProjectionPermission(int i10) {
        Intent createScreenCaptureIntent;
        try {
            MediaProjectionManager a10 = d.a(getSystemService("media_projection"));
            SourceLog.i(TAG, "registerMediaProjectionPermission " + i10);
            createScreenCaptureIntent = a10.createScreenCaptureIntent();
            startActivityForResult(createScreenCaptureIntent, 1);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError(null, 211000, 211001);
            }
        }
    }
}
