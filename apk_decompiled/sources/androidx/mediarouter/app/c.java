package androidx.mediarouter.app;

import android.R;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.mediarouter.app.OverlayListView;
import com.google.common.primitives.Ints;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class c extends androidx.appcompat.app.c {

    /* renamed from: v0, reason: collision with root package name */
    public static final boolean f2766v0 = Log.isLoggable("MediaRouteCtrlDialog", 3);

    /* renamed from: w0, reason: collision with root package name */
    public static final int f2767w0 = (int) TimeUnit.SECONDS.toMillis(30);
    public OverlayListView A;
    public r B;
    public List C;
    public Set D;
    public Set E;
    public Set F;
    public SeekBar G;
    public q H;
    public t0.i I;
    public int J;
    public int K;
    public int L;
    public final int M;
    public Map N;
    public MediaControllerCompat O;
    public o Q;
    public PlaybackStateCompat S;
    public MediaDescriptionCompat V;
    public n W;
    public Bitmap X;
    public Uri Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2768a;

    /* renamed from: b, reason: collision with root package name */
    public final p f2769b;

    /* renamed from: c, reason: collision with root package name */
    public final t0.i f2770c;

    /* renamed from: d, reason: collision with root package name */
    public Context f2771d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2772e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2773f;

    /* renamed from: f0, reason: collision with root package name */
    public Bitmap f2774f0;

    /* renamed from: g, reason: collision with root package name */
    public int f2775g;

    /* renamed from: g0, reason: collision with root package name */
    public int f2776g0;

    /* renamed from: h, reason: collision with root package name */
    public View f2777h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f2778h0;

    /* renamed from: i, reason: collision with root package name */
    public Button f2779i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f2780i0;

    /* renamed from: j, reason: collision with root package name */
    public Button f2781j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f2782j0;

    /* renamed from: k, reason: collision with root package name */
    public ImageButton f2783k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f2784k0;

    /* renamed from: l, reason: collision with root package name */
    public ImageButton f2785l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f2786l0;

    /* renamed from: m, reason: collision with root package name */
    public MediaRouteExpandCollapseButton f2787m;

    /* renamed from: m0, reason: collision with root package name */
    public int f2788m0;

    /* renamed from: n, reason: collision with root package name */
    public FrameLayout f2789n;

    /* renamed from: n0, reason: collision with root package name */
    public int f2790n0;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f2791o;

    /* renamed from: o0, reason: collision with root package name */
    public int f2792o0;

    /* renamed from: p, reason: collision with root package name */
    public FrameLayout f2793p;

    /* renamed from: p0, reason: collision with root package name */
    public Interpolator f2794p0;

    /* renamed from: q, reason: collision with root package name */
    public FrameLayout f2795q;

    /* renamed from: q0, reason: collision with root package name */
    public Interpolator f2796q0;

    /* renamed from: r, reason: collision with root package name */
    public ImageView f2797r;

    /* renamed from: r0, reason: collision with root package name */
    public Interpolator f2798r0;

    /* renamed from: s, reason: collision with root package name */
    public TextView f2799s;

    /* renamed from: s0, reason: collision with root package name */
    public Interpolator f2800s0;

    /* renamed from: t, reason: collision with root package name */
    public TextView f2801t;

    /* renamed from: t0, reason: collision with root package name */
    public final AccessibilityManager f2802t0;

    /* renamed from: u, reason: collision with root package name */
    public TextView f2803u;

    /* renamed from: u0, reason: collision with root package name */
    public Runnable f2804u0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2805v;

    /* renamed from: w, reason: collision with root package name */
    public LinearLayout f2806w;

    /* renamed from: x, reason: collision with root package name */
    public RelativeLayout f2807x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f2808y;

    /* renamed from: z, reason: collision with root package name */
    public View f2809z;

    public class a implements OverlayListView.a.InterfaceC0038a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t0.i f2810a;

        public a(t0.i iVar) {
            this.f2810a = iVar;
        }

        @Override // androidx.mediarouter.app.OverlayListView.a.InterfaceC0038a
        public void onAnimationEnd() {
            c.this.F.remove(this.f2810a);
            c.this.B.notifyDataSetChanged();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.A.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.x();
        }
    }

    /* renamed from: androidx.mediarouter.app.c$c, reason: collision with other inner class name */
    public class AnimationAnimationListenerC0040c implements Animation.AnimationListener {
        public AnimationAnimationListenerC0040c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.h(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.w();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PendingIntent c10;
            MediaControllerCompat mediaControllerCompat = c.this.O;
            if (mediaControllerCompat == null || (c10 = mediaControllerCompat.c()) == null) {
                return;
            }
            try {
                c10.send();
                c.this.dismiss();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("MediaRouteCtrlDialog", c10 + " was not sent, it had been canceled.");
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            boolean z10 = !cVar.f2782j0;
            cVar.f2782j0 = z10;
            if (z10) {
                cVar.A.setVisibility(0);
            }
            c.this.r();
            c.this.B(true);
        }
    }

    public class i implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2819a;

        public i(boolean z10) {
            this.f2819a = z10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.f2793p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c cVar = c.this;
            if (cVar.f2784k0) {
                cVar.f2786l0 = true;
            } else {
                cVar.C(this.f2819a);
            }
        }
    }

    public class j extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2821a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2822b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2823c;

        public j(int i10, int i11, View view) {
            this.f2821a = i10;
            this.f2822b = i11;
            this.f2823c = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            c.u(this.f2823c, this.f2821a - ((int) ((r3 - this.f2822b) * f10)));
        }
    }

    public class k implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f2825a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f2826b;

        public k(Map map, Map map2) {
            this.f2825a = map;
            this.f2826b = map2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.this.A.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.b(this.f2825a, this.f2826b);
        }
    }

    public class l implements Animation.AnimationListener {
        public l() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            c.this.A.b();
            c cVar = c.this;
            cVar.A.postDelayed(cVar.f2804u0, cVar.f2788m0);
        }
    }

    public final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlaybackStateCompat playbackStateCompat;
            int id = view.getId();
            if (id == 16908313 || id == 16908314) {
                if (c.this.f2770c.C()) {
                    c.this.f2768a.x(id == 16908313 ? 2 : 1);
                }
                c.this.dismiss();
                return;
            }
            if (id != R$id.mr_control_playback_ctrl) {
                if (id == R$id.mr_close) {
                    c.this.dismiss();
                    return;
                }
                return;
            }
            c cVar = c.this;
            if (cVar.O == null || (playbackStateCompat = cVar.S) == null) {
                return;
            }
            int i10 = 0;
            int i11 = playbackStateCompat.g() != 3 ? 0 : 1;
            if (i11 != 0 && c.this.n()) {
                c.this.O.d().a();
                i10 = R$string.mr_controller_pause;
            } else if (i11 != 0 && c.this.p()) {
                c.this.O.d().c();
                i10 = R$string.mr_controller_stop;
            } else if (i11 == 0 && c.this.o()) {
                c.this.O.d().b();
                i10 = R$string.mr_controller_play;
            }
            AccessibilityManager accessibilityManager = c.this.f2802t0;
            if (accessibilityManager == null || !accessibilityManager.isEnabled() || i10 == 0) {
                return;
            }
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.setPackageName(c.this.f2771d.getPackageName());
            obtain.setClassName(m.class.getName());
            obtain.getText().add(c.this.f2771d.getString(i10));
            c.this.f2802t0.sendAccessibilityEvent(obtain);
        }
    }

    public class n extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f2830a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f2831b;

        /* renamed from: c, reason: collision with root package name */
        public int f2832c;

        /* renamed from: d, reason: collision with root package name */
        public long f2833d;

        public n() {
            MediaDescriptionCompat mediaDescriptionCompat = c.this.V;
            Bitmap b10 = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.b();
            this.f2830a = c.l(b10) ? null : b10;
            MediaDescriptionCompat mediaDescriptionCompat2 = c.this.V;
            this.f2831b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c4  */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r9) {
            /*
                Method dump skipped, instructions count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.n.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.f2830a;
        }

        public Uri c() {
            return this.f2831b;
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            c cVar = c.this;
            cVar.W = null;
            if (a0.c.a(cVar.X, this.f2830a) && a0.c.a(c.this.Y, this.f2831b)) {
                return;
            }
            c cVar2 = c.this;
            cVar2.X = this.f2830a;
            cVar2.f2774f0 = bitmap;
            cVar2.Y = this.f2831b;
            cVar2.f2776g0 = this.f2832c;
            cVar2.Z = true;
            c.this.y(SystemClock.uptimeMillis() - this.f2833d > 120);
        }

        public final InputStream e(Uri uri) {
            InputStream openInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                openInputStream = c.this.f2771d.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                int i10 = c.f2767w0;
                openConnection.setConnectTimeout(i10);
                openConnection.setReadTimeout(i10);
                openInputStream = openConnection.getInputStream();
            }
            if (openInputStream == null) {
                return null;
            }
            return new BufferedInputStream(openInputStream);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f2833d = SystemClock.uptimeMillis();
            c.this.f();
        }
    }

    public final class o extends MediaControllerCompat.a {
        public o() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void d(MediaMetadataCompat mediaMetadataCompat) {
            c.this.V = mediaMetadataCompat == null ? null : mediaMetadataCompat.e();
            c.this.z();
            c.this.y(false);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void e(PlaybackStateCompat playbackStateCompat) {
            c cVar = c.this;
            cVar.S = playbackStateCompat;
            cVar.y(false);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void i() {
            c cVar = c.this;
            MediaControllerCompat mediaControllerCompat = cVar.O;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.g(cVar.Q);
                c.this.O = null;
            }
        }
    }

    public final class p extends t0.b {
        public p() {
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            c.this.y(true);
        }

        @Override // n0.t0.b
        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            c.this.y(false);
        }

        @Override // n0.t0.b
        public void onRouteVolumeChanged(t0 t0Var, t0.i iVar) {
            SeekBar seekBar = (SeekBar) c.this.N.get(iVar);
            int s10 = iVar.s();
            if (c.f2766v0) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRouteVolumeChanged(), route.getVolume:");
                sb.append(s10);
            }
            if (seekBar == null || c.this.I == iVar) {
                return;
            }
            seekBar.setProgress(s10);
        }
    }

    public class q implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f2837a = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                if (cVar.I != null) {
                    cVar.I = null;
                    if (cVar.f2778h0) {
                        cVar.y(cVar.f2780i0);
                    }
                }
            }
        }

        public q() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                t0.i iVar = (t0.i) seekBar.getTag();
                if (c.f2766v0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onProgressChanged(): calling MediaRouter.RouteInfo.requestSetVolume(");
                    sb.append(i10);
                    sb.append(")");
                }
                iVar.G(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            if (cVar.I != null) {
                cVar.G.removeCallbacks(this.f2837a);
            }
            c.this.I = (t0.i) seekBar.getTag();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            c.this.G.postDelayed(this.f2837a, 500L);
        }
    }

    public class r extends ArrayAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final float f2840a;

        public r(Context context, List list) {
            super(context, 0, list);
            this.f2840a = androidx.mediarouter.app.i.h(context);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mr_controller_volume_item, viewGroup, false);
            } else {
                c.this.G(view);
            }
            t0.i iVar = (t0.i) getItem(i10);
            if (iVar != null) {
                boolean x10 = iVar.x();
                TextView textView = (TextView) view.findViewById(R$id.mr_name);
                textView.setEnabled(x10);
                textView.setText(iVar.m());
                MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) view.findViewById(R$id.mr_volume_slider);
                androidx.mediarouter.app.i.w(viewGroup.getContext(), mediaRouteVolumeSlider, c.this.A);
                mediaRouteVolumeSlider.setTag(iVar);
                c.this.N.put(iVar, mediaRouteVolumeSlider);
                mediaRouteVolumeSlider.c(!x10);
                mediaRouteVolumeSlider.setEnabled(x10);
                if (x10) {
                    if (c.this.q(iVar)) {
                        mediaRouteVolumeSlider.setMax(iVar.u());
                        mediaRouteVolumeSlider.setProgress(iVar.s());
                        mediaRouteVolumeSlider.setOnSeekBarChangeListener(c.this.H);
                    } else {
                        mediaRouteVolumeSlider.setMax(100);
                        mediaRouteVolumeSlider.setProgress(100);
                        mediaRouteVolumeSlider.setEnabled(false);
                    }
                }
                ((ImageView) view.findViewById(R$id.mr_volume_item_icon)).setAlpha(x10 ? 255 : (int) (this.f2840a * 255.0f));
                ((LinearLayout) view.findViewById(R$id.volume_item_container)).setVisibility(c.this.F.contains(iVar) ? 4 : 0);
                Set set = c.this.D;
                if (set != null && set.contains(iVar)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration(0L);
                    alphaAnimation.setFillEnabled(true);
                    alphaAnimation.setFillAfter(true);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            return false;
        }
    }

    public c(Context context) {
        this(context, 0);
    }

    public static boolean H(Uri uri, Uri uri2) {
        if (uri == null || !uri.equals(uri2)) {
            return uri == null && uri2 == null;
        }
        return true;
    }

    public static int j(View view) {
        return view.getLayoutParams().height;
    }

    public static boolean l(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    public static void u(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public void A() {
        int b10 = androidx.mediarouter.app.f.b(this.f2771d);
        getWindow().setLayout(b10, -2);
        View decorView = getWindow().getDecorView();
        this.f2775g = (b10 - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = this.f2771d.getResources();
        this.J = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_icon_size);
        this.K = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_height);
        this.L = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_max_height);
        this.X = null;
        this.Y = null;
        z();
        y(false);
    }

    public void B(boolean z10) {
        this.f2793p.requestLayout();
        this.f2793p.getViewTreeObserver().addOnGlobalLayoutListener(new i(z10));
    }

    public void C(boolean z10) {
        int i10;
        Bitmap bitmap;
        int j10 = j(this.f2806w);
        u(this.f2806w, -1);
        D(d());
        View decorView = getWindow().getDecorView();
        decorView.measure(View.MeasureSpec.makeMeasureSpec(getWindow().getAttributes().width, Ints.MAX_POWER_OF_TWO), 0);
        u(this.f2806w, j10);
        if (this.f2777h == null && (this.f2797r.getDrawable() instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) this.f2797r.getDrawable()).getBitmap()) != null) {
            i10 = i(bitmap.getWidth(), bitmap.getHeight());
            this.f2797r.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
        } else {
            i10 = 0;
        }
        int k10 = k(d());
        int size = this.C.size();
        int size2 = this.f2770c.y() ? this.K * this.f2770c.l().size() : 0;
        if (size > 0) {
            size2 += this.M;
        }
        int min = Math.min(size2, this.L);
        if (!this.f2782j0) {
            min = 0;
        }
        int max = Math.max(i10, min) + k10;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - (this.f2791o.getMeasuredHeight() - this.f2793p.getMeasuredHeight());
        if (this.f2777h != null || i10 <= 0 || max > height) {
            if (j(this.A) + this.f2806w.getMeasuredHeight() >= this.f2793p.getMeasuredHeight()) {
                this.f2797r.setVisibility(8);
            }
            max = min + k10;
            i10 = 0;
        } else {
            this.f2797r.setVisibility(0);
            u(this.f2797r, i10);
        }
        if (!d() || max > height) {
            this.f2807x.setVisibility(8);
        } else {
            this.f2807x.setVisibility(0);
        }
        D(this.f2807x.getVisibility() == 0);
        int k11 = k(this.f2807x.getVisibility() == 0);
        int max2 = Math.max(i10, min) + k11;
        if (max2 > height) {
            min -= max2 - height;
        } else {
            height = max2;
        }
        this.f2806w.clearAnimation();
        this.A.clearAnimation();
        this.f2793p.clearAnimation();
        if (z10) {
            c(this.f2806w, k11);
            c(this.A, min);
            c(this.f2793p, height);
        } else {
            u(this.f2806w, k11);
            u(this.A, min);
            u(this.f2793p, height);
        }
        u(this.f2789n, rect.height());
        t(z10);
    }

    public final void D(boolean z10) {
        int i10 = 0;
        this.f2809z.setVisibility((this.f2808y.getVisibility() == 0 && z10) ? 0 : 8);
        LinearLayout linearLayout = this.f2806w;
        if (this.f2808y.getVisibility() == 8 && !z10) {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.E():void");
    }

    public final void F() {
        if (!q(this.f2770c)) {
            this.f2808y.setVisibility(8);
        } else if (this.f2808y.getVisibility() == 8) {
            this.f2808y.setVisibility(0);
            this.G.setMax(this.f2770c.u());
            this.G.setProgress(this.f2770c.s());
            this.f2787m.setVisibility(this.f2770c.y() ? 0 : 8);
        }
    }

    public void G(View view) {
        u((LinearLayout) view.findViewById(R$id.volume_item_container), this.K);
        View findViewById = view.findViewById(R$id.mr_volume_item_icon);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int i10 = this.J;
        layoutParams.width = i10;
        layoutParams.height = i10;
        findViewById.setLayoutParams(layoutParams);
    }

    public final void a(Map map, Map map2) {
        this.A.setEnabled(false);
        this.A.requestLayout();
        this.f2784k0 = true;
        this.A.getViewTreeObserver().addOnGlobalLayoutListener(new k(map, map2));
    }

    public void b(Map map, Map map2) {
        OverlayListView.a d10;
        Set set = this.D;
        if (set == null || this.E == null) {
            return;
        }
        int size = set.size() - this.E.size();
        l lVar = new l();
        int firstVisiblePosition = this.A.getFirstVisiblePosition();
        boolean z10 = false;
        for (int i10 = 0; i10 < this.A.getChildCount(); i10++) {
            View childAt = this.A.getChildAt(i10);
            Object obj = (t0.i) this.B.getItem(firstVisiblePosition + i10);
            Rect rect = (Rect) map.get(obj);
            int top = childAt.getTop();
            int i11 = rect != null ? rect.top : (this.K * size) + top;
            AnimationSet animationSet = new AnimationSet(true);
            Set set2 = this.D;
            if (set2 != null && set2.contains(obj)) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                alphaAnimation.setDuration(this.f2790n0);
                animationSet.addAnimation(alphaAnimation);
                i11 = top;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i11 - top, 0.0f);
            translateAnimation.setDuration(this.f2788m0);
            animationSet.addAnimation(translateAnimation);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setInterpolator(this.f2794p0);
            if (!z10) {
                animationSet.setAnimationListener(lVar);
                z10 = true;
            }
            childAt.clearAnimation();
            childAt.startAnimation(animationSet);
            map.remove(obj);
            map2.remove(obj);
        }
        for (Map.Entry entry : map2.entrySet()) {
            t0.i iVar = (t0.i) entry.getKey();
            BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
            Rect rect2 = (Rect) map.get(iVar);
            if (this.E.contains(iVar)) {
                d10 = new OverlayListView.a(bitmapDrawable, rect2).c(1.0f, 0.0f).e(this.f2792o0).f(this.f2794p0);
            } else {
                d10 = new OverlayListView.a(bitmapDrawable, rect2).g(this.K * size).e(this.f2788m0).f(this.f2794p0).d(new a(iVar));
                this.F.add(iVar);
            }
            this.A.a(d10);
        }
    }

    public final void c(View view, int i10) {
        j jVar = new j(j(view), i10, view);
        jVar.setDuration(this.f2788m0);
        if (Build.VERSION.SDK_INT >= 21) {
            jVar.setInterpolator(this.f2794p0);
        }
        view.startAnimation(jVar);
    }

    public final boolean d() {
        return this.f2777h == null && !(this.V == null && this.S == null);
    }

    public void e(boolean z10) {
        Set set;
        int firstVisiblePosition = this.A.getFirstVisiblePosition();
        for (int i10 = 0; i10 < this.A.getChildCount(); i10++) {
            View childAt = this.A.getChildAt(i10);
            t0.i iVar = (t0.i) this.B.getItem(firstVisiblePosition + i10);
            if (!z10 || (set = this.D) == null || !set.contains(iVar)) {
                ((LinearLayout) childAt.findViewById(R$id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0L);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        this.A.c();
        if (z10) {
            return;
        }
        h(false);
    }

    public void f() {
        this.Z = false;
        this.f2774f0 = null;
        this.f2776g0 = 0;
    }

    public final void g() {
        AnimationAnimationListenerC0040c animationAnimationListenerC0040c = new AnimationAnimationListenerC0040c();
        int firstVisiblePosition = this.A.getFirstVisiblePosition();
        boolean z10 = false;
        for (int i10 = 0; i10 < this.A.getChildCount(); i10++) {
            View childAt = this.A.getChildAt(i10);
            if (this.D.contains((t0.i) this.B.getItem(firstVisiblePosition + i10))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(this.f2790n0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z10) {
                    alphaAnimation.setAnimationListener(animationAnimationListenerC0040c);
                    z10 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }

    public void h(boolean z10) {
        this.D = null;
        this.E = null;
        this.f2784k0 = false;
        if (this.f2786l0) {
            this.f2786l0 = false;
            B(z10);
        }
        this.A.setEnabled(true);
    }

    public int i(int i10, int i11) {
        return i10 >= i11 ? (int) (((this.f2775g * i11) / i10) + 0.5f) : (int) (((this.f2775g * 9.0f) / 16.0f) + 0.5f);
    }

    public final int k(boolean z10) {
        if (!z10 && this.f2808y.getVisibility() != 0) {
            return 0;
        }
        int paddingTop = 0 + this.f2806w.getPaddingTop() + this.f2806w.getPaddingBottom();
        if (z10) {
            paddingTop += this.f2807x.getMeasuredHeight();
        }
        if (this.f2808y.getVisibility() == 0) {
            paddingTop += this.f2808y.getMeasuredHeight();
        }
        return (z10 && this.f2808y.getVisibility() == 0) ? paddingTop + this.f2809z.getMeasuredHeight() : paddingTop;
    }

    public final boolean m() {
        MediaDescriptionCompat mediaDescriptionCompat = this.V;
        Bitmap b10 = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.b();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.V;
        Uri c10 = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : null;
        n nVar = this.W;
        Bitmap b11 = nVar == null ? this.X : nVar.b();
        n nVar2 = this.W;
        Uri c11 = nVar2 == null ? this.Y : nVar2.c();
        if (b11 != b10) {
            return true;
        }
        return b11 == null && !H(c11, c10);
    }

    public boolean n() {
        return (this.S.b() & 514) != 0;
    }

    public boolean o() {
        return (this.S.b() & 516) != 0;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2773f = true;
        this.f2768a.b(s0.f17005c, this.f2769b, 2);
        v(this.f2768a.j());
    }

    @Override // androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setContentView(R$layout.mr_controller_material_dialog_b);
        findViewById(R.id.button3).setVisibility(8);
        m mVar = new m();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.mr_expandable_area);
        this.f2789n = frameLayout;
        frameLayout.setOnClickListener(new e());
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.mr_dialog_area);
        this.f2791o = linearLayout;
        linearLayout.setOnClickListener(new f());
        int d10 = androidx.mediarouter.app.i.d(this.f2771d);
        Button button = (Button) findViewById(R.id.button2);
        this.f2779i = button;
        button.setText(R$string.mr_controller_disconnect);
        this.f2779i.setTextColor(d10);
        this.f2779i.setOnClickListener(mVar);
        Button button2 = (Button) findViewById(R.id.button1);
        this.f2781j = button2;
        button2.setText(R$string.mr_controller_stop_casting);
        this.f2781j.setTextColor(d10);
        this.f2781j.setOnClickListener(mVar);
        this.f2803u = (TextView) findViewById(R$id.mr_name);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_close);
        this.f2785l = imageButton;
        imageButton.setOnClickListener(mVar);
        this.f2795q = (FrameLayout) findViewById(R$id.mr_custom_control);
        this.f2793p = (FrameLayout) findViewById(R$id.mr_default_control);
        g gVar = new g();
        ImageView imageView = (ImageView) findViewById(R$id.mr_art);
        this.f2797r = imageView;
        imageView.setOnClickListener(gVar);
        findViewById(R$id.mr_control_title_container).setOnClickListener(gVar);
        this.f2806w = (LinearLayout) findViewById(R$id.mr_media_main_control);
        this.f2809z = findViewById(R$id.mr_control_divider);
        this.f2807x = (RelativeLayout) findViewById(R$id.mr_playback_control);
        this.f2799s = (TextView) findViewById(R$id.mr_control_title);
        this.f2801t = (TextView) findViewById(R$id.mr_control_subtitle);
        ImageButton imageButton2 = (ImageButton) findViewById(R$id.mr_control_playback_ctrl);
        this.f2783k = imageButton2;
        imageButton2.setOnClickListener(mVar);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R$id.mr_volume_control);
        this.f2808y = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R$id.mr_volume_slider);
        this.G = seekBar;
        seekBar.setTag(this.f2770c);
        q qVar = new q();
        this.H = qVar;
        this.G.setOnSeekBarChangeListener(qVar);
        this.A = (OverlayListView) findViewById(R$id.mr_volume_group_list);
        this.C = new ArrayList();
        r rVar = new r(this.A.getContext(), this.C);
        this.B = rVar;
        this.A.setAdapter((ListAdapter) rVar);
        this.F = new HashSet();
        androidx.mediarouter.app.i.u(this.f2771d, this.f2806w, this.A, this.f2770c.y());
        androidx.mediarouter.app.i.w(this.f2771d, (MediaRouteVolumeSlider) this.G, this.f2806w);
        HashMap hashMap = new HashMap();
        this.N = hashMap;
        hashMap.put(this.f2770c, this.G);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R$id.mr_group_expand_collapse);
        this.f2787m = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.setOnClickListener(new h());
        r();
        this.f2788m0 = this.f2771d.getResources().getInteger(R$integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f2790n0 = this.f2771d.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f2792o0 = this.f2771d.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_out_duration_ms);
        View s10 = s(bundle);
        this.f2777h = s10;
        if (s10 != null) {
            this.f2795q.addView(s10);
            this.f2795q.setVisibility(0);
        }
        this.f2772e = true;
        A();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f2768a.q(this.f2769b);
        v(null);
        this.f2773f = false;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.app.c, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 25 && i10 != 24) {
            return super.onKeyDown(i10, keyEvent);
        }
        this.f2770c.H(i10 == 25 ? -1 : 1);
        return true;
    }

    @Override // androidx.appcompat.app.c, android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 25 || i10 == 24) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public boolean p() {
        return (this.S.b() & 1) != 0;
    }

    public boolean q(t0.i iVar) {
        return this.f2805v && iVar.t() == 1;
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2794p0 = this.f2782j0 ? this.f2796q0 : this.f2798r0;
        } else {
            this.f2794p0 = this.f2800s0;
        }
    }

    public View s(Bundle bundle) {
        return null;
    }

    public final void t(boolean z10) {
        List l10 = this.f2770c.l();
        if (l10.isEmpty()) {
            this.C.clear();
            this.B.notifyDataSetChanged();
            return;
        }
        if (androidx.mediarouter.app.f.i(this.C, l10)) {
            this.B.notifyDataSetChanged();
            return;
        }
        HashMap e10 = z10 ? androidx.mediarouter.app.f.e(this.A, this.B) : null;
        HashMap d10 = z10 ? androidx.mediarouter.app.f.d(this.f2771d, this.A, this.B) : null;
        this.D = androidx.mediarouter.app.f.f(this.C, l10);
        this.E = androidx.mediarouter.app.f.g(this.C, l10);
        this.C.addAll(0, this.D);
        this.C.removeAll(this.E);
        this.B.notifyDataSetChanged();
        if (z10 && this.f2782j0 && this.D.size() + this.E.size() > 0) {
            a(e10, d10);
        } else {
            this.D = null;
            this.E = null;
        }
    }

    public final void v(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.O;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.g(this.Q);
            this.O = null;
        }
        if (token != null && this.f2773f) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f2771d, token);
            this.O = mediaControllerCompat2;
            mediaControllerCompat2.e(this.Q);
            MediaMetadataCompat a10 = this.O.a();
            this.V = a10 != null ? a10.e() : null;
            this.S = this.O.b();
            z();
            y(false);
        }
    }

    public void w() {
        e(true);
        this.A.requestLayout();
        this.A.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void x() {
        Set set = this.D;
        if (set == null || set.size() == 0) {
            h(true);
        } else {
            g();
        }
    }

    public void y(boolean z10) {
        if (this.I != null) {
            this.f2778h0 = true;
            this.f2780i0 = z10 | this.f2780i0;
            return;
        }
        this.f2778h0 = false;
        this.f2780i0 = false;
        if (!this.f2770c.C() || this.f2770c.w()) {
            dismiss();
            return;
        }
        if (this.f2772e) {
            this.f2803u.setText(this.f2770c.m());
            this.f2779i.setVisibility(this.f2770c.a() ? 0 : 8);
            if (this.f2777h == null && this.Z) {
                if (l(this.f2774f0)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't set artwork image with recycled bitmap: ");
                    sb.append(this.f2774f0);
                } else {
                    this.f2797r.setImageBitmap(this.f2774f0);
                    this.f2797r.setBackgroundColor(this.f2776g0);
                }
                f();
            }
            F();
            E();
            B(z10);
        }
    }

    public void z() {
        if (this.f2777h == null && m()) {
            n nVar = this.W;
            if (nVar != null) {
                nVar.cancel(true);
            }
            n nVar2 = new n();
            this.W = nVar2;
            nVar2.execute(new Void[0]);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 1
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            r1.f2805v = r0
            androidx.mediarouter.app.c$d r3 = new androidx.mediarouter.app.c$d
            r3.<init>()
            r1.f2804u0 = r3
            android.content.Context r3 = r1.getContext()
            r1.f2771d = r3
            androidx.mediarouter.app.c$o r3 = new androidx.mediarouter.app.c$o
            r3.<init>()
            r1.Q = r3
            android.content.Context r3 = r1.f2771d
            n0.t0 r3 = n0.t0.i(r3)
            r1.f2768a = r3
            androidx.mediarouter.app.c$p r0 = new androidx.mediarouter.app.c$p
            r0.<init>()
            r1.f2769b = r0
            n0.t0$i r0 = r3.m()
            r1.f2770c = r0
            android.support.v4.media.session.MediaSessionCompat$Token r3 = r3.j()
            r1.v(r3)
            android.content.Context r3 = r1.f2771d
            android.content.res.Resources r3 = r3.getResources()
            int r0 = androidx.mediarouter.R$dimen.mr_controller_volume_group_list_padding_top
            int r3 = r3.getDimensionPixelSize(r0)
            r1.M = r3
            android.content.Context r3 = r1.f2771d
            java.lang.String r0 = "accessibility"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r3 = (android.view.accessibility.AccessibilityManager) r3
            r1.f2802t0 = r3
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r3 < r0) goto L6e
            int r3 = androidx.mediarouter.R$interpolator.mr_linear_out_slow_in
            android.view.animation.Interpolator r3 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f2796q0 = r3
            int r3 = androidx.mediarouter.R$interpolator.mr_fast_out_slow_in
            android.view.animation.Interpolator r2 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f2798r0 = r2
        L6e:
            android.view.animation.AccelerateDecelerateInterpolator r2 = new android.view.animation.AccelerateDecelerateInterpolator
            r2.<init>()
            r1.f2800s0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.<init>(android.content.Context, int):void");
    }
}
