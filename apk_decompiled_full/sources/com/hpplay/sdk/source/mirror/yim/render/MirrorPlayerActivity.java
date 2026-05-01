package com.hpplay.sdk.source.mirror.yim.render;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.sdk.source.api.MirrorFrameCallback;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.cloud.mirror.youme.OnCloudMirrorListener;
import com.hpplay.sdk.source.cloud.mirror.youme.YimConfigBean;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.youme.voiceengine.api;
import com.youme.voiceengine.video.EglBase;
import com.youme.voiceengine.video.RendererCommon;
import com.youme.voiceengine.video.SurfaceViewRenderer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes3.dex */
public class MirrorPlayerActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7703a = "session";

    /* renamed from: b, reason: collision with root package name */
    public static final String f7704b = "uri";

    /* renamed from: c, reason: collision with root package name */
    public static final String f7705c = "room_id_key";

    /* renamed from: d, reason: collision with root package name */
    public static final String f7706d = "uid_key";

    /* renamed from: e, reason: collision with root package name */
    private static final String f7707e = "MirrorPlayerActivity";

    /* renamed from: f, reason: collision with root package name */
    private SurfaceViewRenderer f7708f;

    /* renamed from: g, reason: collision with root package name */
    private YimMirror f7709g;

    /* renamed from: h, reason: collision with root package name */
    private b f7710h;

    /* renamed from: i, reason: collision with root package name */
    private String f7711i;

    /* renamed from: j, reason: collision with root package name */
    private OutParameter f7712j;

    /* renamed from: k, reason: collision with root package name */
    private String f7713k;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f7714l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f7715m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f7716n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7717o = true;

    /* renamed from: p, reason: collision with root package name */
    private View.OnClickListener f7718p = new View.OnClickListener() { // from class: com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MirrorPlayerActivity.this.finish();
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private MirrorFrameCallback f7719q = new MirrorFrameCallback() { // from class: com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity.2
        @Override // com.hpplay.sdk.source.api.MirrorFrameCallback
        public void onVideoFrameCallback(String str, byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f7710h != null) {
                if (MirrorPlayerActivity.this.f7708f.getVisibility() == 4) {
                    MirrorPlayerActivity.this.runOnUiThread(new Runnable() { // from class: com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MirrorPlayerActivity.this.f7708f.setVisibility(0);
                            MirrorPlayerActivity.this.f7714l.setBackgroundColor(0);
                        }
                    });
                }
                MirrorPlayerActivity.this.f7710h.a(str, bArr, i10, i11, i12, i13, j10);
                if (MirrorPlayerActivity.this.f7717o) {
                    MirrorPlayerActivity.this.f7717o = false;
                    SourceDataReport.getInstance().onStartPullYoumeStream(MirrorPlayerActivity.this.f7712j);
                }
            }
        }

        @Override // com.hpplay.sdk.source.api.MirrorFrameCallback
        public void onVideoFrameCallbackGLES(String str, int i10, int i11, float[] fArr, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f7710h != null) {
                MirrorPlayerActivity.this.f7710h.a(str, i10, i11, fArr, i12, i13, j10);
            }
        }

        @Override // com.hpplay.sdk.source.api.MirrorFrameCallback
        public void onVideoFrameMixed(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f7710h != null) {
                MirrorPlayerActivity.this.f7710h.a(bArr, i10, i11, i12, i13, j10);
            }
        }

        @Override // com.hpplay.sdk.source.api.MirrorFrameCallback
        public void onVideoFrameMixedGLES(int i10, int i11, float[] fArr, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f7710h != null) {
                MirrorPlayerActivity.this.f7710h.a(i10, i11, fArr, i12, i13, j10);
            }
        }

        @Override // com.hpplay.sdk.source.api.MirrorFrameCallback
        public int onVideoRenderFilterCallback(int i10, int i11, int i12, int i13, int i14) {
            return 0;
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private Animator.AnimatorListener f7720r = new Animator.AnimatorListener() { // from class: com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity.3
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MirrorPlayerActivity.this.f7716n != null) {
                MirrorPlayerActivity.this.f7716n.setVisibility(4);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a(this);
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) findViewById(R.id.content)).getLayoutParams();
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
        this.f7715m = relativeLayout2;
        layoutParams.width = -1;
        layoutParams.height = -1;
        relativeLayout2.setBackgroundColor(-1);
        this.f7715m.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f7715m);
        this.f7714l = new RelativeLayout(getApplicationContext());
        this.f7714l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.f7714l);
        setContentView(relativeLayout);
        SurfaceViewRenderer surfaceViewRenderer = new SurfaceViewRenderer(getApplicationContext());
        this.f7708f = surfaceViewRenderer;
        surfaceViewRenderer.init(EglBase.createContext(api.sharedEGLContext()), (RendererCommon.RendererEvents) null);
        this.f7708f.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        this.f7708f.setMirror(false);
        this.f7708f.setVisibility(4);
        this.f7715m.addView((View) this.f7708f, (ViewGroup.LayoutParams) new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SurfaceViewRenderer surfaceViewRenderer = this.f7708f;
        if (surfaceViewRenderer != null) {
            surfaceViewRenderer.release();
        }
        YimMirror yimMirror = this.f7709g;
        if (yimMirror != null) {
            yimMirror.release();
            this.f7709g.setVideoFrameCallback(null);
        }
        SourceDataReport.getInstance().onStopPullYoumeStream(this.f7712j);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f7716n == null) {
            Drawable a10 = a.a(this, "cm_bg");
            if (a10 != null) {
                this.f7715m.setBackground(a10);
            }
            b();
            return;
        }
        if (TextUtils.isEmpty(this.f7713k) || this.f7709g == null) {
            return;
        }
        if (this.f7713k.contains(Operator.Operation.MINUS)) {
            this.f7713k = this.f7713k.replace(Operator.Operation.MINUS, "n");
        }
        this.f7709g.maskVideoByUserId(this.f7713k, false);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (TextUtils.isEmpty(this.f7713k) || this.f7709g == null) {
            return;
        }
        if (this.f7713k.contains(Operator.Operation.MINUS)) {
            this.f7713k = this.f7713k.replace(Operator.Operation.MINUS, "n");
        }
        this.f7709g.maskVideoByUserId(this.f7713k, true);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        c();
        return true;
    }

    private void b() {
        Drawable a10 = a.a(this, "mirror_off");
        this.f7716n = new LinearLayout(this);
        a.a(RoundedDrawable.DEFAULT_BORDER_COLOR, 30);
        this.f7716n.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.a(1080), a.a(450));
        layoutParams.addRule(12);
        layoutParams.setMargins(a.a(8), 0, a.a(8), 0);
        this.f7716n.setLayoutParams(layoutParams);
        this.f7716n.setBackground(a.a(RoundedDrawable.DEFAULT_BORDER_COLOR, 30));
        View button = new Button(getApplicationContext());
        if (a10 != null) {
            button.setBackground(a10);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a.a(180), a.a(180));
        layoutParams2.topMargin = a.b(60);
        layoutParams2.gravity = 1;
        button.setLayoutParams(layoutParams2);
        button.setOnClickListener(this.f7718p);
        this.f7716n.addView(button);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getApplicationContext());
        textView.setText("结束投屏");
        textView.setTextSize(a.a(12));
        textView.setTextColor(-1);
        layoutParams3.topMargin = a.a(10);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        this.f7716n.addView(textView);
        this.f7716n.setVisibility(4);
        this.f7714l.addView(this.f7716n);
    }

    private void c() {
        int a10 = a.a(450);
        LinearLayout linearLayout = this.f7716n;
        if (linearLayout == null) {
            b();
        } else {
            if (linearLayout.getVisibility() == 0) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.f7716n, "translationY", 0.0f, a10).setDuration(300L);
                duration.addListener(this.f7720r);
                duration.start();
                return;
            }
            this.f7716n.setVisibility(0);
        }
        ObjectAnimator.ofFloat(this.f7716n, "translationY", a10, 0.0f).setDuration(300L).start();
    }

    private void a() {
        this.f7709g = YimMirror.getInstance();
        this.f7711i = getIntent().getStringExtra(f7705c);
        this.f7713k = getIntent().getStringExtra(f7706d);
        String stringExtra = getIntent().getStringExtra("session");
        String stringExtra2 = getIntent().getStringExtra("uri");
        OutParameter outParameter = new OutParameter();
        this.f7712j = outParameter;
        outParameter.roomID = this.f7711i;
        outParameter.castType = 2;
        outParameter.mimeType = 102;
        outParameter.session = stringExtra;
        outParameter.urlID = stringExtra2;
        outParameter.protocol = 4;
        ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(this.f7713k);
        if (connectBridge != null && connectBridge.getServiceInfo() != null) {
            this.f7712j.connectSession = connectBridge.getConnectSession();
            this.f7712j.serviceInfo = connectBridge.getServiceInfo();
            OutParameter outParameter2 = this.f7712j;
            outParameter2.currentBrowserInfo = CastUtil.getBrowserInfo(outParameter2.serviceInfo, 4);
        }
        if (this.f7709g.isInitOK()) {
            this.f7709g.release();
        }
        YimConfigBean yimConfigBean = new YimConfigBean();
        yimConfigBean.roomID = this.f7711i;
        yimConfigBean.userID = CreateUtil.createYimUserID();
        this.f7709g.initSink(getApplicationContext());
        this.f7709g.login(yimConfigBean);
        this.f7710h = new b(this.f7708f);
        this.f7709g.setVideoFrameCallback(this.f7719q);
        this.f7709g.addCloudMirrorListener(new OnCloudMirrorListener() { // from class: com.hpplay.sdk.source.mirror.yim.render.MirrorPlayerActivity.4
            public void a(int i10, Object... objArr) {
                if (i10 == 1) {
                    int intValue = Integer.valueOf(objArr[0].toString()).intValue();
                    if (intValue == -1) {
                        MirrorPlayerActivity.this.finish();
                    }
                    SourceDataReport.getInstance().onYimInit(IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, MirrorPlayerActivity.this.f7712j, intValue == 1, null, null);
                    return;
                }
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                    MirrorPlayerActivity.this.finish();
                } else if (Integer.valueOf(objArr[0].toString()).intValue() == -1) {
                    MirrorPlayerActivity.this.finish();
                }
            }
        });
    }
}
