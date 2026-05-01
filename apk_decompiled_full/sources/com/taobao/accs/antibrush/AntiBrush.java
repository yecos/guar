package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.g;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost = null;
    private static volatile boolean mIsInCheckCodeActivity = false;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    public static class AntiReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                try {
                    String stringExtra = intent.getStringExtra("Result");
                    ALog.e(AntiBrush.TAG, "anti onReceive result: " + stringExtra, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), stringExtra.equalsIgnoreCase("success"));
                } catch (Exception e10) {
                    ALog.e(AntiBrush.TAG, "anti onReceive", e10, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                }
            } catch (Throwable th) {
                AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                throw th;
            }
        }
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void handleAntiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleAntiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION), 4);
            } else {
                this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
            }
        } catch (Throwable th) {
            ALog.e(TAG, "handleAntiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z10) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z10);
        g.a().b(context, intent);
        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            mTimeoutTask = null;
        }
        String str = mHost;
        if (str != null) {
            UtilityImpl.b(context, b.a(str));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(3:15|16|(4:18|(1:20)(1:34)|21|(2:23|(9:25|(1:27)|28|(1:30)(1:33)|31|4|5|(1:9)|11))))|3|4|5|(2:7|9)|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a8, code lost:
    
        r8 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkAntiBrush(URL url, Map<Integer, String> map) {
        boolean z10;
        if (map != null) {
            try {
            } catch (Throwable th) {
                th = th;
                z10 = false;
                ALog.e(TAG, "checkAntiBrush error", th, new Object[0]);
                return z10;
            }
            if (UtilityImpl.a()) {
                String str = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                if ((TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue()) == 419) {
                    String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_LOCATION.ordinal()));
                    if (!TextUtils.isEmpty(str2)) {
                        ALog.e(TAG, "start anti bursh location:" + str2, new Object[0]);
                        handleAntiBrush(str2);
                        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
                        String str3 = null;
                        z10 = true;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                            mTimeoutTask = null;
                        }
                        mTimeoutTask = ThreadPoolExecutorFactory.schedule(new a(this), 60000L, TimeUnit.MILLISECONDS);
                        if (url != null) {
                            str3 = url.getHost();
                        }
                        mHost = str3;
                        if (!TextUtils.isEmpty(GlobalClientInfo.f9033c) && TextUtils.isEmpty(b.a(mHost))) {
                            ALog.e(TAG, "cookie invalid, clear", new Object[0]);
                            UtilityImpl.n(this.mContext);
                        }
                        return z10;
                    }
                }
            }
        }
        z10 = false;
        if (!TextUtils.isEmpty(GlobalClientInfo.f9033c)) {
            ALog.e(TAG, "cookie invalid, clear", new Object[0]);
            UtilityImpl.n(this.mContext);
        }
        return z10;
    }
}
