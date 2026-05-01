package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n0.p0;
import n0.s0;
import n0.t0;
import p0.b;

/* loaded from: classes.dex */
public class h extends androidx.appcompat.app.j {
    public static final boolean O = Log.isLoggable("MediaRouteCtrlDialog", 3);
    public View A;
    public ImageView B;
    public TextView C;
    public TextView D;
    public String E;
    public MediaControllerCompat F;
    public e G;
    public MediaDescriptionCompat H;
    public d I;
    public Bitmap J;
    public Uri K;
    public boolean L;
    public Bitmap M;
    public int N;

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2882a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2883b;

    /* renamed from: c, reason: collision with root package name */
    public s0 f2884c;

    /* renamed from: d, reason: collision with root package name */
    public t0.i f2885d;

    /* renamed from: e, reason: collision with root package name */
    public final List f2886e;

    /* renamed from: f, reason: collision with root package name */
    public final List f2887f;

    /* renamed from: g, reason: collision with root package name */
    public final List f2888g;

    /* renamed from: h, reason: collision with root package name */
    public final List f2889h;

    /* renamed from: i, reason: collision with root package name */
    public Context f2890i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2891j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2892k;

    /* renamed from: l, reason: collision with root package name */
    public long f2893l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f2894m;

    /* renamed from: n, reason: collision with root package name */
    public RecyclerView f2895n;

    /* renamed from: o, reason: collision with root package name */
    public C0041h f2896o;

    /* renamed from: p, reason: collision with root package name */
    public j f2897p;

    /* renamed from: q, reason: collision with root package name */
    public Map f2898q;

    /* renamed from: r, reason: collision with root package name */
    public t0.i f2899r;

    /* renamed from: s, reason: collision with root package name */
    public Map f2900s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2901t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2902u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2903v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f2904w;

    /* renamed from: x, reason: collision with root package name */
    public ImageButton f2905x;

    /* renamed from: y, reason: collision with root package name */
    public Button f2906y;

    /* renamed from: z, reason: collision with root package name */
    public ImageView f2907z;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                h.this.o();
                return;
            }
            if (i10 != 2) {
                return;
            }
            h hVar = h.this;
            if (hVar.f2899r != null) {
                hVar.f2899r = null;
                hVar.p();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f2885d.C()) {
                h.this.f2882a.x(2);
            }
            h.this.dismiss();
        }
    }

    public class d extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f2911a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f2912b;

        /* renamed from: c, reason: collision with root package name */
        public int f2913c;

        public d() {
            MediaDescriptionCompat mediaDescriptionCompat = h.this.H;
            Bitmap b10 = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.b();
            this.f2911a = h.d(b10) ? null : b10;
            MediaDescriptionCompat mediaDescriptionCompat2 = h.this.H;
            this.f2912b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00c8  */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Bitmap doInBackground(Void... voidArr) {
            InputStream inputStream;
            Bitmap bitmap = this.f2911a;
            ?? r32 = 0;
            if (bitmap == null) {
                Uri uri = this.f2912b;
                try {
                    if (uri != null) {
                        try {
                            inputStream = e(uri);
                            try {
                                if (inputStream == null) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Unable to open: ");
                                    sb.append(this.f2912b);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    return null;
                                }
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(inputStream, null, options);
                                if (options.outWidth == 0 || options.outHeight == 0) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    return null;
                                }
                                try {
                                    inputStream.reset();
                                } catch (IOException unused3) {
                                    inputStream.close();
                                    inputStream = e(this.f2912b);
                                    if (inputStream == null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Unable to open: ");
                                        sb2.append(this.f2912b);
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException unused4) {
                                            }
                                        }
                                        return null;
                                    }
                                }
                                options.inJustDecodeBounds = false;
                                options.inSampleSize = Math.max(1, Integer.highestOneBit(options.outHeight / h.this.f2890i.getResources().getDimensionPixelSize(R$dimen.mr_cast_meta_art_size)));
                                if (isCancelled()) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                    return null;
                                }
                                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                                try {
                                    inputStream.close();
                                } catch (IOException unused6) {
                                }
                                bitmap = decodeStream;
                            } catch (IOException unused7) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Unable to open: ");
                                sb3.append(this.f2912b);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                bitmap = null;
                                if (!h.d(bitmap)) {
                                }
                            }
                        } catch (IOException unused9) {
                            inputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (r32 != 0) {
                                try {
                                    r32.close();
                                } catch (IOException unused10) {
                                }
                            }
                            throw th;
                        }
                    }
                    bitmap = null;
                } catch (Throwable th2) {
                    th = th2;
                    r32 = uri;
                }
            }
            if (!h.d(bitmap)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't use recycled bitmap: ");
                sb4.append(bitmap);
                return null;
            }
            if (bitmap != null && bitmap.getWidth() < bitmap.getHeight()) {
                p0.b a10 = new b.C0309b(bitmap).c(1).a();
                this.f2913c = a10.f().isEmpty() ? 0 : ((b.d) a10.f().get(0)).e();
            }
            return bitmap;
        }

        public Bitmap b() {
            return this.f2911a;
        }

        public Uri c() {
            return this.f2912b;
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            h hVar = h.this;
            hVar.I = null;
            if (a0.c.a(hVar.J, this.f2911a) && a0.c.a(h.this.K, this.f2912b)) {
                return;
            }
            h hVar2 = h.this;
            hVar2.J = this.f2911a;
            hVar2.M = bitmap;
            hVar2.K = this.f2912b;
            hVar2.N = this.f2913c;
            hVar2.L = true;
            hVar2.m();
        }

        public final InputStream e(Uri uri) {
            InputStream openInputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                openInputStream = h.this.f2890i.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                openConnection.setConnectTimeout(30000);
                openConnection.setReadTimeout(30000);
                openInputStream = openConnection.getInputStream();
            }
            if (openInputStream == null) {
                return null;
            }
            return new BufferedInputStream(openInputStream);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            h.this.b();
        }
    }

    public final class e extends MediaControllerCompat.a {
        public e() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void d(MediaMetadataCompat mediaMetadataCompat) {
            h.this.H = mediaMetadataCompat == null ? null : mediaMetadataCompat.e();
            h.this.g();
            h.this.m();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void i() {
            h hVar = h.this;
            MediaControllerCompat mediaControllerCompat = hVar.F;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.g(hVar.G);
                h.this.F = null;
            }
        }
    }

    public abstract class f extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public t0.i f2916a;

        /* renamed from: b, reason: collision with root package name */
        public final ImageButton f2917b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaRouteVolumeSlider f2918c;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h hVar = h.this;
                if (hVar.f2899r != null) {
                    hVar.f2894m.removeMessages(2);
                }
                f fVar = f.this;
                h.this.f2899r = fVar.f2916a;
                boolean z10 = !view.isActivated();
                int c10 = z10 ? 0 : f.this.c();
                f.this.d(z10);
                f.this.f2918c.setProgress(c10);
                f.this.f2916a.G(c10);
                h.this.f2894m.sendEmptyMessageDelayed(2, 500L);
            }
        }

        public f(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            super(view);
            this.f2917b = imageButton;
            this.f2918c = mediaRouteVolumeSlider;
            imageButton.setImageDrawable(androidx.mediarouter.app.i.k(h.this.f2890i));
            androidx.mediarouter.app.i.v(h.this.f2890i, mediaRouteVolumeSlider);
        }

        public void b(t0.i iVar) {
            this.f2916a = iVar;
            int s10 = iVar.s();
            this.f2917b.setActivated(s10 == 0);
            this.f2917b.setOnClickListener(new a());
            this.f2918c.setTag(this.f2916a);
            this.f2918c.setMax(iVar.u());
            this.f2918c.setProgress(s10);
            this.f2918c.setOnSeekBarChangeListener(h.this.f2897p);
        }

        public int c() {
            Integer num = (Integer) h.this.f2900s.get(this.f2916a.k());
            if (num == null) {
                return 1;
            }
            return Math.max(1, num.intValue());
        }

        public void d(boolean z10) {
            if (this.f2917b.isActivated() == z10) {
                return;
            }
            this.f2917b.setActivated(z10);
            if (z10) {
                h.this.f2900s.put(this.f2916a.k(), Integer.valueOf(this.f2918c.getProgress()));
            } else {
                h.this.f2900s.remove(this.f2916a.k());
            }
        }

        public void e() {
            int s10 = this.f2916a.s();
            d(s10 == 0);
            this.f2918c.setProgress(s10);
        }
    }

    public final class g extends t0.b {
        public g() {
        }

        @Override // n0.t0.b
        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            boolean z10;
            t0.i.a h10;
            if (iVar == h.this.f2885d && iVar.g() != null) {
                for (t0.i iVar2 : iVar.q().f()) {
                    if (!h.this.f2885d.l().contains(iVar2) && (h10 = h.this.f2885d.h(iVar2)) != null && h10.b() && !h.this.f2887f.contains(iVar2)) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            if (!z10) {
                h.this.o();
            } else {
                h.this.p();
                h.this.n();
            }
        }

        @Override // n0.t0.b
        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        @Override // n0.t0.b
        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            h hVar = h.this;
            hVar.f2885d = iVar;
            hVar.f2901t = false;
            hVar.p();
            h.this.n();
        }

        @Override // n0.t0.b
        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        @Override // n0.t0.b
        public void onRouteVolumeChanged(t0 t0Var, t0.i iVar) {
            f fVar;
            int s10 = iVar.s();
            if (h.O) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRouteVolumeChanged(), route.getVolume:");
                sb.append(s10);
            }
            h hVar = h.this;
            if (hVar.f2899r == iVar || (fVar = (f) hVar.f2898q.get(iVar.k())) == null) {
                return;
            }
            fVar.e();
        }
    }

    /* renamed from: androidx.mediarouter.app.h$h, reason: collision with other inner class name */
    public final class C0041h extends RecyclerView.g {

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2923b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable f2924c;

        /* renamed from: d, reason: collision with root package name */
        public final Drawable f2925d;

        /* renamed from: e, reason: collision with root package name */
        public final Drawable f2926e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable f2927f;

        /* renamed from: g, reason: collision with root package name */
        public f f2928g;

        /* renamed from: h, reason: collision with root package name */
        public final int f2929h;

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f2922a = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public final Interpolator f2930i = new AccelerateDecelerateInterpolator();

        /* renamed from: androidx.mediarouter.app.h$h$a */
        public class a extends Animation {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f2932a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f2933b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f2934c;

            public a(int i10, int i11, View view) {
                this.f2932a = i10;
                this.f2933b = i11;
                this.f2934c = view;
            }

            @Override // android.view.animation.Animation
            public void applyTransformation(float f10, Transformation transformation) {
                int i10 = this.f2932a;
                h.h(this.f2934c, this.f2933b + ((int) ((i10 - r0) * f10)));
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$b */
        public class b implements Animation.AnimationListener {
            public b() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                h hVar = h.this;
                hVar.f2902u = false;
                hVar.p();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                h.this.f2902u = true;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$c */
        public class c extends RecyclerView.d0 {

            /* renamed from: a, reason: collision with root package name */
            public final View f2937a;

            /* renamed from: b, reason: collision with root package name */
            public final ImageView f2938b;

            /* renamed from: c, reason: collision with root package name */
            public final ProgressBar f2939c;

            /* renamed from: d, reason: collision with root package name */
            public final TextView f2940d;

            /* renamed from: e, reason: collision with root package name */
            public final float f2941e;

            /* renamed from: f, reason: collision with root package name */
            public t0.i f2942f;

            /* renamed from: androidx.mediarouter.app.h$h$c$a */
            public class a implements View.OnClickListener {
                public a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c cVar = c.this;
                    h.this.f2882a.w(cVar.f2942f);
                    c.this.f2938b.setVisibility(4);
                    c.this.f2939c.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.f2937a = view;
                this.f2938b = (ImageView) view.findViewById(R$id.mr_cast_group_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_group_progress_bar);
                this.f2939c = progressBar;
                this.f2940d = (TextView) view.findViewById(R$id.mr_cast_group_name);
                this.f2941e = androidx.mediarouter.app.i.h(h.this.f2890i);
                androidx.mediarouter.app.i.t(h.this.f2890i, progressBar);
            }

            public void b(f fVar) {
                t0.i iVar = (t0.i) fVar.a();
                this.f2942f = iVar;
                this.f2938b.setVisibility(0);
                this.f2939c.setVisibility(4);
                this.f2937a.setAlpha(c(iVar) ? 1.0f : this.f2941e);
                this.f2937a.setOnClickListener(new a());
                this.f2938b.setImageDrawable(C0041h.this.c(iVar));
                this.f2940d.setText(iVar.m());
            }

            public final boolean c(t0.i iVar) {
                List l10 = h.this.f2885d.l();
                return (l10.size() == 1 && l10.get(0) == iVar) ? false : true;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$d */
        public class d extends f {

            /* renamed from: e, reason: collision with root package name */
            public final TextView f2945e;

            /* renamed from: f, reason: collision with root package name */
            public final int f2946f;

            public d(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f2945e = (TextView) view.findViewById(R$id.mr_group_volume_route_name);
                Resources resources = h.this.f2890i.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
                this.f2946f = (int) typedValue.getDimension(displayMetrics);
            }

            public void f(f fVar) {
                h.h(this.itemView, C0041h.this.e() ? this.f2946f : 0);
                t0.i iVar = (t0.i) fVar.a();
                super.b(iVar);
                this.f2945e.setText(iVar.m());
            }

            public int g() {
                return this.f2946f;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$e */
        public class e extends RecyclerView.d0 {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f2948a;

            public e(View view) {
                super(view);
                this.f2948a = (TextView) view.findViewById(R$id.mr_cast_header_name);
            }

            public void b(f fVar) {
                this.f2948a.setText(fVar.a().toString());
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$f */
        public class f {

            /* renamed from: a, reason: collision with root package name */
            public final Object f2950a;

            /* renamed from: b, reason: collision with root package name */
            public final int f2951b;

            public f(Object obj, int i10) {
                this.f2950a = obj;
                this.f2951b = i10;
            }

            public Object a() {
                return this.f2950a;
            }

            public int b() {
                return this.f2951b;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$g */
        public class g extends f {

            /* renamed from: e, reason: collision with root package name */
            public final View f2953e;

            /* renamed from: f, reason: collision with root package name */
            public final ImageView f2954f;

            /* renamed from: g, reason: collision with root package name */
            public final ProgressBar f2955g;

            /* renamed from: h, reason: collision with root package name */
            public final TextView f2956h;

            /* renamed from: i, reason: collision with root package name */
            public final RelativeLayout f2957i;

            /* renamed from: j, reason: collision with root package name */
            public final CheckBox f2958j;

            /* renamed from: k, reason: collision with root package name */
            public final float f2959k;

            /* renamed from: l, reason: collision with root package name */
            public final int f2960l;

            /* renamed from: m, reason: collision with root package name */
            public final int f2961m;

            /* renamed from: n, reason: collision with root package name */
            public final View.OnClickListener f2962n;

            /* renamed from: androidx.mediarouter.app.h$h$g$a */
            public class a implements View.OnClickListener {
                public a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g gVar = g.this;
                    boolean z10 = !gVar.h(gVar.f2916a);
                    boolean y10 = g.this.f2916a.y();
                    if (z10) {
                        g gVar2 = g.this;
                        h.this.f2882a.c(gVar2.f2916a);
                    } else {
                        g gVar3 = g.this;
                        h.this.f2882a.r(gVar3.f2916a);
                    }
                    g.this.i(z10, !y10);
                    if (y10) {
                        List l10 = h.this.f2885d.l();
                        for (t0.i iVar : g.this.f2916a.l()) {
                            if (l10.contains(iVar) != z10) {
                                f fVar = (f) h.this.f2898q.get(iVar.k());
                                if (fVar instanceof g) {
                                    ((g) fVar).i(z10, true);
                                }
                            }
                        }
                    }
                    g gVar4 = g.this;
                    C0041h.this.f(gVar4.f2916a, z10);
                }
            }

            public g(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f2962n = new a();
                this.f2953e = view;
                this.f2954f = (ImageView) view.findViewById(R$id.mr_cast_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_route_progress_bar);
                this.f2955g = progressBar;
                this.f2956h = (TextView) view.findViewById(R$id.mr_cast_route_name);
                this.f2957i = (RelativeLayout) view.findViewById(R$id.mr_cast_volume_layout);
                CheckBox checkBox = (CheckBox) view.findViewById(R$id.mr_cast_checkbox);
                this.f2958j = checkBox;
                checkBox.setButtonDrawable(androidx.mediarouter.app.i.e(h.this.f2890i));
                androidx.mediarouter.app.i.t(h.this.f2890i, progressBar);
                this.f2959k = androidx.mediarouter.app.i.h(h.this.f2890i);
                Resources resources = h.this.f2890i.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_dialog_row_height, typedValue, true);
                this.f2960l = (int) typedValue.getDimension(displayMetrics);
                this.f2961m = 0;
            }

            public void f(f fVar) {
                t0.i iVar = (t0.i) fVar.a();
                if (iVar == h.this.f2885d && iVar.l().size() > 0) {
                    Iterator it = iVar.l().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        t0.i iVar2 = (t0.i) it.next();
                        if (!h.this.f2887f.contains(iVar2)) {
                            iVar = iVar2;
                            break;
                        }
                    }
                }
                b(iVar);
                this.f2954f.setImageDrawable(C0041h.this.c(iVar));
                this.f2956h.setText(iVar.m());
                this.f2958j.setVisibility(0);
                boolean h10 = h(iVar);
                boolean g10 = g(iVar);
                this.f2958j.setChecked(h10);
                this.f2955g.setVisibility(4);
                this.f2954f.setVisibility(0);
                this.f2953e.setEnabled(g10);
                this.f2958j.setEnabled(g10);
                this.f2917b.setEnabled(g10 || h10);
                this.f2918c.setEnabled(g10 || h10);
                this.f2953e.setOnClickListener(this.f2962n);
                this.f2958j.setOnClickListener(this.f2962n);
                h.h(this.f2957i, (!h10 || this.f2916a.y()) ? this.f2961m : this.f2960l);
                float f10 = 1.0f;
                this.f2953e.setAlpha((g10 || h10) ? 1.0f : this.f2959k);
                CheckBox checkBox = this.f2958j;
                if (!g10 && h10) {
                    f10 = this.f2959k;
                }
                checkBox.setAlpha(f10);
            }

            public final boolean g(t0.i iVar) {
                if (h.this.f2889h.contains(iVar)) {
                    return false;
                }
                if (h(iVar) && h.this.f2885d.l().size() < 2) {
                    return false;
                }
                if (!h(iVar)) {
                    return true;
                }
                t0.i.a h10 = h.this.f2885d.h(iVar);
                return h10 != null && h10.d();
            }

            public boolean h(t0.i iVar) {
                if (iVar.C()) {
                    return true;
                }
                t0.i.a h10 = h.this.f2885d.h(iVar);
                return h10 != null && h10.a() == 3;
            }

            public void i(boolean z10, boolean z11) {
                this.f2958j.setEnabled(false);
                this.f2953e.setEnabled(false);
                this.f2958j.setChecked(z10);
                if (z10) {
                    this.f2954f.setVisibility(4);
                    this.f2955g.setVisibility(0);
                }
                if (z11) {
                    C0041h.this.a(this.f2957i, z10 ? this.f2960l : this.f2961m);
                }
            }
        }

        public C0041h() {
            this.f2923b = LayoutInflater.from(h.this.f2890i);
            this.f2924c = androidx.mediarouter.app.i.g(h.this.f2890i);
            this.f2925d = androidx.mediarouter.app.i.q(h.this.f2890i);
            this.f2926e = androidx.mediarouter.app.i.m(h.this.f2890i);
            this.f2927f = androidx.mediarouter.app.i.n(h.this.f2890i);
            this.f2929h = h.this.f2890i.getResources().getInteger(R$integer.mr_cast_volume_slider_layout_animation_duration_ms);
            h();
        }

        public void a(View view, int i10) {
            a aVar = new a(i10, view.getLayoutParams().height, view);
            aVar.setAnimationListener(new b());
            aVar.setDuration(this.f2929h);
            aVar.setInterpolator(this.f2930i);
            view.startAnimation(aVar);
        }

        public final Drawable b(t0.i iVar) {
            int f10 = iVar.f();
            return f10 != 1 ? f10 != 2 ? iVar.y() ? this.f2927f : this.f2924c : this.f2926e : this.f2925d;
        }

        public Drawable c(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(h.this.f2890i.getContentResolver().openInputStream(j10), null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ");
                    sb.append(j10);
                }
            }
            return b(iVar);
        }

        public f d(int i10) {
            return i10 == 0 ? this.f2928g : (f) this.f2922a.get(i10 - 1);
        }

        public boolean e() {
            return h.this.f2885d.l().size() > 1;
        }

        public void f(t0.i iVar, boolean z10) {
            List l10 = h.this.f2885d.l();
            int max = Math.max(1, l10.size());
            if (iVar.y()) {
                Iterator it = iVar.l().iterator();
                while (it.hasNext()) {
                    if (l10.contains((t0.i) it.next()) != z10) {
                        max += z10 ? 1 : -1;
                    }
                }
            } else {
                max += z10 ? 1 : -1;
            }
            boolean e10 = e();
            boolean z11 = max >= 2;
            if (e10 != z11) {
                RecyclerView.d0 findViewHolderForAdapterPosition = h.this.f2895n.findViewHolderForAdapterPosition(0);
                if (findViewHolderForAdapterPosition instanceof d) {
                    d dVar = (d) findViewHolderForAdapterPosition;
                    a(dVar.itemView, z11 ? dVar.g() : 0);
                }
            }
        }

        public void g() {
            h.this.f2889h.clear();
            h hVar = h.this;
            hVar.f2889h.addAll(androidx.mediarouter.app.f.g(hVar.f2887f, hVar.c()));
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f2922a.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemViewType(int i10) {
            return d(i10).b();
        }

        public void h() {
            this.f2922a.clear();
            this.f2928g = new f(h.this.f2885d, 1);
            if (h.this.f2886e.isEmpty()) {
                this.f2922a.add(new f(h.this.f2885d, 3));
            } else {
                Iterator it = h.this.f2886e.iterator();
                while (it.hasNext()) {
                    this.f2922a.add(new f((t0.i) it.next(), 3));
                }
            }
            boolean z10 = false;
            if (!h.this.f2887f.isEmpty()) {
                boolean z11 = false;
                for (t0.i iVar : h.this.f2887f) {
                    if (!h.this.f2886e.contains(iVar)) {
                        if (!z11) {
                            p0.b g10 = h.this.f2885d.g();
                            String j10 = g10 != null ? g10.j() : null;
                            if (TextUtils.isEmpty(j10)) {
                                j10 = h.this.f2890i.getString(R$string.mr_dialog_groupable_header);
                            }
                            this.f2922a.add(new f(j10, 2));
                            z11 = true;
                        }
                        this.f2922a.add(new f(iVar, 3));
                    }
                }
            }
            if (!h.this.f2888g.isEmpty()) {
                for (t0.i iVar2 : h.this.f2888g) {
                    t0.i iVar3 = h.this.f2885d;
                    if (iVar3 != iVar2) {
                        if (!z10) {
                            p0.b g11 = iVar3.g();
                            String k10 = g11 != null ? g11.k() : null;
                            if (TextUtils.isEmpty(k10)) {
                                k10 = h.this.f2890i.getString(R$string.mr_dialog_transferable_header);
                            }
                            this.f2922a.add(new f(k10, 2));
                            z10 = true;
                        }
                        this.f2922a.add(new f(iVar2, 4));
                    }
                }
            }
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
            int itemViewType = getItemViewType(i10);
            f d10 = d(i10);
            if (itemViewType == 1) {
                h.this.f2898q.put(((t0.i) d10.a()).k(), (f) d0Var);
                ((d) d0Var).f(d10);
            } else {
                if (itemViewType == 2) {
                    ((e) d0Var).b(d10);
                    return;
                }
                if (itemViewType != 3) {
                    if (itemViewType != 4) {
                        return;
                    }
                    ((c) d0Var).b(d10);
                } else {
                    h.this.f2898q.put(((t0.i) d10.a()).k(), (f) d0Var);
                    ((g) d0Var).f(d10);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 1) {
                return new d(this.f2923b.inflate(R$layout.mr_cast_group_volume_item, viewGroup, false));
            }
            if (i10 == 2) {
                return new e(this.f2923b.inflate(R$layout.mr_cast_header_item, viewGroup, false));
            }
            if (i10 == 3) {
                return new g(this.f2923b.inflate(R$layout.mr_cast_route_item, viewGroup, false));
            }
            if (i10 != 4) {
                return null;
            }
            return new c(this.f2923b.inflate(R$layout.mr_cast_group_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onViewRecycled(RecyclerView.d0 d0Var) {
            super.onViewRecycled(d0Var);
            h.this.f2898q.values().remove(d0Var);
        }
    }

    public static final class i implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final i f2965a = new i();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public class j implements SeekBar.OnSeekBarChangeListener {
        public j() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                t0.i iVar = (t0.i) seekBar.getTag();
                f fVar = (f) h.this.f2898q.get(iVar.k());
                if (fVar != null) {
                    fVar.d(i10 == 0);
                }
                iVar.G(i10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            h hVar = h.this;
            if (hVar.f2899r != null) {
                hVar.f2894m.removeMessages(2);
            }
            h.this.f2899r = (t0.i) seekBar.getTag();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            h.this.f2894m.sendEmptyMessageDelayed(2, 500L);
        }
    }

    public h(Context context) {
        this(context, 0);
    }

    public static Bitmap a(Bitmap bitmap, float f10, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius(f10);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        createTyped.copyTo(copy);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        create.destroy();
        return copy;
    }

    public static boolean d(Bitmap bitmap) {
        return bitmap != null && bitmap.isRecycled();
    }

    public static void h(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public void b() {
        this.L = false;
        this.M = null;
        this.N = 0;
    }

    public List c() {
        ArrayList arrayList = new ArrayList();
        for (t0.i iVar : this.f2885d.q().f()) {
            t0.i.a h10 = this.f2885d.h(iVar);
            if (h10 != null && h10.b()) {
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    public boolean e(t0.i iVar) {
        return !iVar.w() && iVar.x() && iVar.E(this.f2884c) && this.f2885d != iVar;
    }

    public void f(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!e((t0.i) list.get(size))) {
                list.remove(size);
            }
        }
    }

    public void g() {
        MediaDescriptionCompat mediaDescriptionCompat = this.H;
        Bitmap b10 = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.b();
        MediaDescriptionCompat mediaDescriptionCompat2 = this.H;
        Uri c10 = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : null;
        d dVar = this.I;
        Bitmap b11 = dVar == null ? this.J : dVar.b();
        d dVar2 = this.I;
        Uri c11 = dVar2 == null ? this.K : dVar2.c();
        if (b11 != b10 || (b11 == null && !a0.c.a(c11, c10))) {
            d dVar3 = this.I;
            if (dVar3 != null) {
                dVar3.cancel(true);
            }
            d dVar4 = new d();
            this.I = dVar4;
            dVar4.execute(new Void[0]);
        }
    }

    public final void i(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.F;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.g(this.G);
            this.F = null;
        }
        if (token != null && this.f2892k) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f2890i, token);
            this.F = mediaControllerCompat2;
            mediaControllerCompat2.e(this.G);
            MediaMetadataCompat a10 = this.F.a();
            this.H = a10 != null ? a10.e() : null;
            g();
            m();
        }
    }

    public void j(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f2884c.equals(s0Var)) {
            return;
        }
        this.f2884c = s0Var;
        if (this.f2892k) {
            this.f2882a.q(this.f2883b);
            this.f2882a.b(s0Var, this.f2883b, 1);
            n();
        }
    }

    public final boolean k() {
        if (this.f2899r != null || this.f2901t || this.f2902u) {
            return true;
        }
        return !this.f2891j;
    }

    public void l() {
        getWindow().setLayout(androidx.mediarouter.app.f.c(this.f2890i), androidx.mediarouter.app.f.a(this.f2890i));
        this.J = null;
        this.K = null;
        g();
        m();
        o();
    }

    public void m() {
        if (k()) {
            this.f2904w = true;
            return;
        }
        this.f2904w = false;
        if (!this.f2885d.C() || this.f2885d.w()) {
            dismiss();
        }
        if (!this.L || d(this.M) || this.M == null) {
            if (d(this.M)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't set artwork image with recycled bitmap: ");
                sb.append(this.M);
            }
            this.B.setVisibility(8);
            this.A.setVisibility(8);
            this.f2907z.setImageBitmap(null);
        } else {
            this.B.setVisibility(0);
            this.B.setImageBitmap(this.M);
            this.B.setBackgroundColor(this.N);
            this.A.setVisibility(0);
            this.f2907z.setImageBitmap(a(this.M, 10.0f, this.f2890i));
        }
        b();
        MediaDescriptionCompat mediaDescriptionCompat = this.H;
        CharSequence f10 = mediaDescriptionCompat == null ? null : mediaDescriptionCompat.f();
        boolean z10 = !TextUtils.isEmpty(f10);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.H;
        CharSequence e10 = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.e() : null;
        boolean isEmpty = true ^ TextUtils.isEmpty(e10);
        if (z10) {
            this.C.setText(f10);
        } else {
            this.C.setText(this.E);
        }
        if (!isEmpty) {
            this.D.setVisibility(8);
        } else {
            this.D.setText(e10);
            this.D.setVisibility(0);
        }
    }

    public void n() {
        this.f2886e.clear();
        this.f2887f.clear();
        this.f2888g.clear();
        this.f2886e.addAll(this.f2885d.l());
        for (t0.i iVar : this.f2885d.q().f()) {
            t0.i.a h10 = this.f2885d.h(iVar);
            if (h10 != null) {
                if (h10.b()) {
                    this.f2887f.add(iVar);
                }
                if (h10.c()) {
                    this.f2888g.add(iVar);
                }
            }
        }
        f(this.f2887f);
        f(this.f2888g);
        List list = this.f2886e;
        i iVar2 = i.f2965a;
        Collections.sort(list, iVar2);
        Collections.sort(this.f2887f, iVar2);
        Collections.sort(this.f2888g, iVar2);
        this.f2896o.h();
    }

    public void o() {
        if (this.f2892k) {
            if (SystemClock.uptimeMillis() - this.f2893l < 300) {
                this.f2894m.removeMessages(1);
                this.f2894m.sendEmptyMessageAtTime(1, this.f2893l + 300);
            } else {
                if (k()) {
                    this.f2903v = true;
                    return;
                }
                this.f2903v = false;
                if (!this.f2885d.C() || this.f2885d.w()) {
                    dismiss();
                }
                this.f2893l = SystemClock.uptimeMillis();
                this.f2896o.g();
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2892k = true;
        this.f2882a.b(this.f2884c, this.f2883b, 1);
        n();
        i(this.f2882a.j());
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_cast_dialog);
        androidx.mediarouter.app.i.s(this.f2890i, this);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_cast_close_button);
        this.f2905x = imageButton;
        imageButton.setColorFilter(-1);
        this.f2905x.setOnClickListener(new b());
        Button button = (Button) findViewById(R$id.mr_cast_stop_button);
        this.f2906y = button;
        button.setTextColor(-1);
        this.f2906y.setOnClickListener(new c());
        this.f2896o = new C0041h();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_cast_list);
        this.f2895n = recyclerView;
        recyclerView.setAdapter(this.f2896o);
        this.f2895n.setLayoutManager(new LinearLayoutManager(this.f2890i));
        this.f2897p = new j();
        this.f2898q = new HashMap();
        this.f2900s = new HashMap();
        this.f2907z = (ImageView) findViewById(R$id.mr_cast_meta_background);
        this.A = findViewById(R$id.mr_cast_meta_black_scrim);
        this.B = (ImageView) findViewById(R$id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R$id.mr_cast_meta_title);
        this.C = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R$id.mr_cast_meta_subtitle);
        this.D = textView2;
        textView2.setTextColor(-1);
        this.E = this.f2890i.getResources().getString(R$string.mr_cast_dialog_title_view_placeholder);
        this.f2891j = true;
        l();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2892k = false;
        this.f2882a.q(this.f2883b);
        this.f2894m.removeCallbacksAndMessages(null);
        i(null);
    }

    public void p() {
        if (this.f2903v) {
            o();
        }
        if (this.f2904w) {
            m();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(Context context, int i10) {
        super(r2, androidx.mediarouter.app.i.c(r2));
        Context b10 = androidx.mediarouter.app.i.b(context, i10, false);
        this.f2884c = s0.f17005c;
        this.f2886e = new ArrayList();
        this.f2887f = new ArrayList();
        this.f2888g = new ArrayList();
        this.f2889h = new ArrayList();
        this.f2894m = new a();
        Context context2 = getContext();
        this.f2890i = context2;
        t0 i11 = t0.i(context2);
        this.f2882a = i11;
        this.f2883b = new g();
        this.f2885d = i11.m();
        this.G = new e();
        i(i11.j());
    }
}
