package com.mobile.brasiltv.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.mobile.brasiltv.bean.event.ExitScanPageEvent;
import com.mobile.brasiltv.mine.activity.ScanLoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.zxing.view.ViewfinderView;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import e7.g;
import e7.h;
import f5.c;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import xa.j;

/* loaded from: classes.dex */
public class ScanLoginActivity extends c implements SurfaceHolder.Callback {

    /* renamed from: k, reason: collision with root package name */
    public e7.a f8066k;

    /* renamed from: l, reason: collision with root package name */
    public ViewfinderView f8067l;

    /* renamed from: m, reason: collision with root package name */
    public TitleView f8068m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8069n;

    /* renamed from: o, reason: collision with root package name */
    public Vector f8070o;

    /* renamed from: p, reason: collision with root package name */
    public String f8071p;

    /* renamed from: q, reason: collision with root package name */
    public g f8072q;

    /* renamed from: r, reason: collision with root package name */
    public MediaPlayer f8073r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8074s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8075t;

    /* renamed from: u, reason: collision with root package name */
    public ProgressDialog f8076u;

    /* renamed from: v, reason: collision with root package name */
    public String f8077v;

    /* renamed from: w, reason: collision with root package name */
    public Bitmap f8078w;

    /* renamed from: x, reason: collision with root package name */
    public final MediaPlayer.OnCompletionListener f8079x = new b();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanLoginActivity scanLoginActivity = ScanLoginActivity.this;
            Result a32 = scanLoginActivity.a3(scanLoginActivity.f8077v);
            if (a32 == null) {
                Message obtainMessage = ScanLoginActivity.this.f8066k.obtainMessage();
                obtainMessage.what = R.id.decode_failed;
                obtainMessage.obj = "Scan failed!";
                ScanLoginActivity.this.f8066k.sendMessage(obtainMessage);
                return;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("qr_scan_result", a32.getText());
            intent.putExtras(bundle);
            ScanLoginActivity.this.setResult(161, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    public void T2() {
        this.f8067l.g();
    }

    public Handler U2() {
        return this.f8066k;
    }

    public ViewfinderView V2() {
        return this.f8067l;
    }

    public void W2(Result result, Bitmap bitmap) {
        this.f8072q.b();
        Z2();
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            if (isFinishing()) {
                return;
            }
            f1.f8649a.x("Scan failed!");
            return;
        }
        if (text != null && text.contains("qrtoken") && text.contains("userId")) {
            int indexOf = text.indexOf("qrtoken=");
            int indexOf2 = text.indexOf("&userId=");
            int indexOf3 = text.indexOf(DispatchConstants.SIGN_SPLIT_SYMBOL, indexOf2 + 1);
            String substring = indexOf3 == -1 ? text.substring(indexOf2 + 8) : text.substring(indexOf2 + 8, indexOf3);
            Intent intent = new Intent(this, (Class<?>) ScanLoginAty.class);
            ScanLoginAty.a aVar = ScanLoginAty.f8429o;
            intent.putExtra(aVar.a(), text.substring(indexOf + 8, indexOf2));
            intent.putExtra(aVar.b(), substring);
            startActivity(intent);
            return;
        }
        if (text != null && (text.startsWith(HttpConstant.HTTP) || text.startsWith("https"))) {
            b0.h0(this, text, true, true, false, false);
            return;
        }
        if (isFinishing()) {
            return;
        }
        f1.f8649a.w(R.string.scan_recognition_failed);
        Message obtainMessage = this.f8066k.obtainMessage();
        obtainMessage.what = R.id.restart_preview;
        obtainMessage.obj = "Restart Preview!";
        this.f8066k.sendMessageDelayed(obtainMessage, 3000L);
    }

    public final void X2() {
        if (this.f8074s && this.f8073r == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f8073r = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f8073r.setOnCompletionListener(this.f8079x);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.f8073r.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f8073r.setVolume(0.1f, 0.1f);
                this.f8073r.prepare();
            } catch (IOException unused) {
                this.f8073r = null;
            }
        }
    }

    public final void Y2(SurfaceHolder surfaceHolder) {
        try {
            d7.c.c().g(surfaceHolder);
            if (this.f8066k == null) {
                this.f8066k = new e7.a(this, this.f8070o, this.f8071p);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }

    public final void Z2() {
        MediaPlayer mediaPlayer;
        if (this.f8074s && (mediaPlayer = this.f8073r) != null) {
            mediaPlayer.start();
        }
        if (this.f8075t) {
            ((Vibrator) getSystemService("vibrator")).vibrate(200L);
        }
    }

    public Result a3(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF8");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        this.f8078w = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i10 = (int) (options.outHeight / 200.0f);
        options.inSampleSize = i10 > 0 ? i10 : 1;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        this.f8078w = decodeFile;
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new h(decodeFile))), hashtable);
        } catch (ChecksumException e10) {
            e10.printStackTrace();
            return null;
        } catch (FormatException e11) {
            e11.printStackTrace();
            return null;
        } catch (NotFoundException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    @j
    public void exitScanPage(ExitScanPageEvent exitScanPageEvent) {
        finish();
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // androidx.fragment.app.e, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == -1 && i10 == 100) {
            Cursor query = getContentResolver().query(intent.getData(), null, null, null, null);
            if (query.moveToFirst()) {
                this.f8077v = query.getString(query.getColumnIndex("_data"));
            }
            query.close();
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f8076u = progressDialog;
            progressDialog.setMessage("正在扫描...");
            this.f8076u.setCancelable(false);
            this.f8076u.show();
            new Thread(new a()).start();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scan_login);
        d7.c.f(getApplication());
        this.f8067l = (ViewfinderView) findViewById(R.id.viewfinder_content);
        this.f8068m = (TitleView) findViewById(R.id.mTitleTop);
        this.f8069n = false;
        this.f8072q = new g(this);
        this.f8068m.setLayoutBackground(R.color.transparent);
    }

    @Override // f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        this.f8072q.c();
        MediaPlayer mediaPlayer = this.f8073r;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
        e7.a aVar = this.f8066k;
        if (aVar != null) {
            aVar.a();
            this.f8066k = null;
        }
        d7.c.c().b();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.scanner_view)).getHolder();
        if (this.f8069n) {
            Y2(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f8070o = null;
        this.f8071p = null;
        this.f8074s = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.f8074s = false;
        }
        X2();
        this.f8075t = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f8069n) {
            return;
        }
        this.f8069n = true;
        Y2(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f8069n = false;
    }
}
