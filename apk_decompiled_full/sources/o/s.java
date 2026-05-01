package o;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$integer;
import androidx.core.R$string;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class s {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f17389a;

        /* renamed from: b, reason: collision with root package name */
        public IconCompat f17390b;

        /* renamed from: c, reason: collision with root package name */
        public final j1[] f17391c;

        /* renamed from: d, reason: collision with root package name */
        public final j1[] f17392d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f17393e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f17394f;

        /* renamed from: g, reason: collision with root package name */
        public final int f17395g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f17396h;

        /* renamed from: i, reason: collision with root package name */
        public int f17397i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f17398j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f17399k;

        /* renamed from: o.s$a$a, reason: collision with other inner class name */
        public static final class C0298a {

            /* renamed from: a, reason: collision with root package name */
            public final IconCompat f17400a;

            /* renamed from: b, reason: collision with root package name */
            public final CharSequence f17401b;

            /* renamed from: c, reason: collision with root package name */
            public final PendingIntent f17402c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f17403d;

            /* renamed from: e, reason: collision with root package name */
            public final Bundle f17404e;

            /* renamed from: f, reason: collision with root package name */
            public ArrayList f17405f;

            /* renamed from: g, reason: collision with root package name */
            public int f17406g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f17407h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f17408i;

            public C0298a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.e(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f17405f;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    if (it.hasNext()) {
                        androidx.appcompat.app.m.a(it.next());
                        throw null;
                    }
                }
                j1[] j1VarArr = arrayList.isEmpty() ? null : (j1[]) arrayList.toArray(new j1[arrayList.size()]);
                return new a(this.f17400a, this.f17401b, this.f17402c, this.f17404e, arrayList2.isEmpty() ? null : (j1[]) arrayList2.toArray(new j1[arrayList2.size()]), j1VarArr, this.f17403d, this.f17406g, this.f17407h, this.f17408i);
            }

            public final void b() {
                if (this.f17408i && this.f17402c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0298a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, j1[] j1VarArr, boolean z10, int i10, boolean z11, boolean z12) {
                this.f17403d = true;
                this.f17407h = true;
                this.f17400a = iconCompat;
                this.f17401b = e.h(charSequence);
                this.f17402c = pendingIntent;
                this.f17404e = bundle;
                this.f17405f = j1VarArr == null ? null : new ArrayList(Arrays.asList(j1VarArr));
                this.f17403d = z10;
                this.f17406g = i10;
                this.f17407h = z11;
                this.f17408i = z12;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.e(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f17399k;
        }

        public boolean b() {
            return this.f17393e;
        }

        public j1[] c() {
            return this.f17392d;
        }

        public Bundle d() {
            return this.f17389a;
        }

        public int e() {
            return this.f17397i;
        }

        public IconCompat f() {
            int i10;
            if (this.f17390b == null && (i10 = this.f17397i) != 0) {
                this.f17390b = IconCompat.e(null, "", i10);
            }
            return this.f17390b;
        }

        public j1[] g() {
            return this.f17391c;
        }

        public int h() {
            return this.f17395g;
        }

        public boolean i() {
            return this.f17394f;
        }

        public CharSequence j() {
            return this.f17398j;
        }

        public boolean k() {
            return this.f17396h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, j1[] j1VarArr, j1[] j1VarArr2, boolean z10, int i10, boolean z11, boolean z12) {
            this.f17394f = true;
            this.f17390b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f17397i = iconCompat.g();
            }
            this.f17398j = e.h(charSequence);
            this.f17399k = pendingIntent;
            this.f17389a = bundle == null ? new Bundle() : bundle;
            this.f17391c = j1VarArr;
            this.f17392d = j1VarArr2;
            this.f17393e = z10;
            this.f17395g = i10;
            this.f17394f = z11;
            this.f17396h = z12;
        }
    }

    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f17409e;

        /* renamed from: f, reason: collision with root package name */
        public IconCompat f17410f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f17411g;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: o.s$b$b, reason: collision with other inner class name */
        public static class C0299b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @Override // o.s.f
        public void b(r rVar) {
            int i10 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(rVar.a()).setBigContentTitle(this.f17440b).bigPicture(this.f17409e);
            if (this.f17411g) {
                IconCompat iconCompat = this.f17410f;
                if (iconCompat == null) {
                    a.a(bigPicture, null);
                } else if (i10 >= 23) {
                    C0299b.a(bigPicture, this.f17410f.v(rVar instanceof e1 ? ((e1) rVar).f() : null));
                } else if (iconCompat.l() == 1) {
                    a.a(bigPicture, this.f17410f.f());
                } else {
                    a.a(bigPicture, null);
                }
            }
            if (this.f17442d) {
                a.b(bigPicture, this.f17441c);
            }
        }

        @Override // o.s.f
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b m(Bitmap bitmap) {
            this.f17410f = bitmap == null ? null : IconCompat.c(bitmap);
            this.f17411g = true;
            return this;
        }

        public b n(Bitmap bitmap) {
            this.f17409e = bitmap;
            return this;
        }
    }

    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f17412e;

        @Override // o.s.f
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f17412e);
            }
        }

        @Override // o.s.f
        public void b(r rVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(rVar.a()).setBigContentTitle(this.f17440b).bigText(this.f17412e);
            if (this.f17442d) {
                bigText.setSummaryText(this.f17441c);
            }
        }

        @Override // o.s.f
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c m(CharSequence charSequence) {
            this.f17412e = e.h(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public e f17439a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f17440b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f17441c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f17442d = false;

        public void a(Bundle bundle) {
            if (this.f17442d) {
                bundle.putCharSequence("android.summaryText", this.f17441c);
            }
            CharSequence charSequence = this.f17440b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String h10 = h();
            if (h10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", h10);
            }
        }

        public abstract void b(r rVar);

        /* JADX WARN: Removed duplicated region for block: B:37:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01ee  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01e4  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01dd  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RemoteViews c(boolean z10, int i10, boolean z11) {
            boolean z12;
            CharSequence charSequence;
            boolean z13;
            Resources resources = this.f17439a.f17413a.getResources();
            RemoteViews remoteViews = new RemoteViews(this.f17439a.f17413a.getPackageName(), i10);
            boolean z14 = true;
            boolean z15 = this.f17439a.f() < -1;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 21) {
                if (z15) {
                    remoteViews.setInt(R$id.notification_background, "setBackgroundResource", R$drawable.notification_bg_low);
                    remoteViews.setInt(R$id.icon, "setBackgroundResource", R$drawable.notification_template_icon_low_bg);
                } else {
                    remoteViews.setInt(R$id.notification_background, "setBackgroundResource", R$drawable.notification_bg);
                    remoteViews.setInt(R$id.icon, "setBackgroundResource", R$drawable.notification_template_icon_bg);
                }
            }
            e eVar = this.f17439a;
            if (eVar.f17422j != null) {
                int i12 = R$id.icon;
                remoteViews.setViewVisibility(i12, 0);
                remoteViews.setImageViewBitmap(i12, this.f17439a.f17422j);
                if (z10 && this.f17439a.R.icon != 0) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_right_icon_size);
                    int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R$dimen.notification_small_icon_background_padding) * 2);
                    if (i11 >= 21) {
                        e eVar2 = this.f17439a;
                        remoteViews.setImageViewBitmap(R$id.right_icon, g(eVar2.R.icon, dimensionPixelSize, dimensionPixelSize2, eVar2.d()));
                    } else {
                        remoteViews.setImageViewBitmap(R$id.right_icon, d(this.f17439a.R.icon, -1));
                    }
                    remoteViews.setViewVisibility(R$id.right_icon, 0);
                }
            } else if (z10 && eVar.R.icon != 0) {
                int i13 = R$id.icon;
                remoteViews.setViewVisibility(i13, 0);
                if (i11 >= 21) {
                    int dimensionPixelSize3 = resources.getDimensionPixelSize(R$dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R$dimen.notification_big_circle_margin);
                    int dimensionPixelSize4 = resources.getDimensionPixelSize(R$dimen.notification_small_icon_size_as_large);
                    e eVar3 = this.f17439a;
                    remoteViews.setImageViewBitmap(i13, g(eVar3.R.icon, dimensionPixelSize3, dimensionPixelSize4, eVar3.d()));
                } else {
                    remoteViews.setImageViewBitmap(i13, d(this.f17439a.R.icon, -1));
                }
            }
            CharSequence charSequence2 = this.f17439a.f17417e;
            if (charSequence2 != null) {
                remoteViews.setTextViewText(R$id.title, charSequence2);
            }
            CharSequence charSequence3 = this.f17439a.f17418f;
            if (charSequence3 != null) {
                remoteViews.setTextViewText(R$id.text, charSequence3);
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z16 = i11 < 21 && this.f17439a.f17422j != null;
            e eVar4 = this.f17439a;
            CharSequence charSequence4 = eVar4.f17423k;
            if (charSequence4 != null) {
                int i14 = R$id.info;
                remoteViews.setTextViewText(i14, charSequence4);
                remoteViews.setViewVisibility(i14, 0);
            } else {
                if (eVar4.f17424l <= 0) {
                    remoteViews.setViewVisibility(R$id.info, 8);
                    charSequence = this.f17439a.f17430r;
                    if (charSequence != null) {
                        remoteViews.setTextViewText(R$id.text, charSequence);
                        CharSequence charSequence5 = this.f17439a.f17418f;
                        if (charSequence5 != null) {
                            int i15 = R$id.text2;
                            remoteViews.setTextViewText(i15, charSequence5);
                            remoteViews.setViewVisibility(i15, 0);
                            z13 = true;
                            if (z13) {
                                if (z11) {
                                    remoteViews.setTextViewTextSize(R$id.text, 0, resources.getDimensionPixelSize(R$dimen.notification_subtext_size));
                                }
                                remoteViews.setViewPadding(R$id.line1, 0, 0, 0, 0);
                            }
                            if (this.f17439a.g() == 0) {
                                z14 = z16;
                            } else if (this.f17439a.f17427o) {
                                int i16 = R$id.chronometer;
                                remoteViews.setViewVisibility(i16, 0);
                                remoteViews.setLong(i16, "setBase", this.f17439a.g() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                                remoteViews.setBoolean(i16, "setStarted", true);
                                boolean z17 = this.f17439a.f17428p;
                                if (z17 && i11 >= 24) {
                                    remoteViews.setChronometerCountDown(i16, z17);
                                }
                            } else {
                                int i17 = R$id.time;
                                remoteViews.setViewVisibility(i17, 0);
                                remoteViews.setLong(i17, "setTime", this.f17439a.g());
                            }
                            remoteViews.setViewVisibility(R$id.right_side, z14 ? 0 : 8);
                            remoteViews.setViewVisibility(R$id.line3, z12 ? 0 : 8);
                            return remoteViews;
                        }
                        remoteViews.setViewVisibility(R$id.text2, 8);
                    }
                    z13 = false;
                    if (z13) {
                    }
                    if (this.f17439a.g() == 0) {
                    }
                    remoteViews.setViewVisibility(R$id.right_side, z14 ? 0 : 8);
                    remoteViews.setViewVisibility(R$id.line3, z12 ? 0 : 8);
                    return remoteViews;
                }
                if (this.f17439a.f17424l > resources.getInteger(R$integer.status_bar_notification_info_maxnum)) {
                    remoteViews.setTextViewText(R$id.info, resources.getString(R$string.status_bar_notification_info_overflow));
                } else {
                    remoteViews.setTextViewText(R$id.info, NumberFormat.getIntegerInstance().format(this.f17439a.f17424l));
                }
                remoteViews.setViewVisibility(R$id.info, 0);
            }
            z12 = true;
            z16 = true;
            charSequence = this.f17439a.f17430r;
            if (charSequence != null) {
            }
            z13 = false;
            if (z13) {
            }
            if (this.f17439a.g() == 0) {
            }
            remoteViews.setViewVisibility(R$id.right_side, z14 ? 0 : 8);
            remoteViews.setViewVisibility(R$id.line3, z12 ? 0 : 8);
            return remoteViews;
        }

        public Bitmap d(int i10, int i11) {
            return e(i10, i11, 0);
        }

        public final Bitmap e(int i10, int i11, int i12) {
            return f(IconCompat.d(this.f17439a.f17413a, i10), i11, i12);
        }

        public final Bitmap f(IconCompat iconCompat, int i10, int i11) {
            Drawable q10 = iconCompat.q(this.f17439a.f17413a);
            int intrinsicWidth = i11 == 0 ? q10.getIntrinsicWidth() : i11;
            if (i11 == 0) {
                i11 = q10.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i11, Bitmap.Config.ARGB_8888);
            q10.setBounds(0, 0, intrinsicWidth, i11);
            if (i10 != 0) {
                q10.mutate().setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
            }
            q10.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public final Bitmap g(int i10, int i11, int i12, int i13) {
            int i14 = R$drawable.notification_icon_background;
            if (i13 == 0) {
                i13 = 0;
            }
            Bitmap e10 = e(i14, i13, i11);
            Canvas canvas = new Canvas(e10);
            Drawable mutate = this.f17439a.f17413a.getResources().getDrawable(i10).mutate();
            mutate.setFilterBitmap(true);
            int i15 = (i11 - i12) / 2;
            int i16 = i12 + i15;
            mutate.setBounds(i15, i15, i16, i16);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return e10;
        }

        public String h() {
            return null;
        }

        public RemoteViews i(r rVar) {
            return null;
        }

        public RemoteViews j(r rVar) {
            return null;
        }

        public RemoteViews k(r rVar) {
            return null;
        }

        public void l(e eVar) {
            if (this.f17439a != eVar) {
                this.f17439a = eVar;
                if (eVar != null) {
                    eVar.D(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static class e {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public long O;
        public int P;
        public boolean Q;
        public Notification R;
        public boolean S;
        public Icon T;
        public ArrayList U;

        /* renamed from: a, reason: collision with root package name */
        public Context f17413a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f17414b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f17415c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f17416d;

        /* renamed from: e, reason: collision with root package name */
        public CharSequence f17417e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f17418f;

        /* renamed from: g, reason: collision with root package name */
        public PendingIntent f17419g;

        /* renamed from: h, reason: collision with root package name */
        public PendingIntent f17420h;

        /* renamed from: i, reason: collision with root package name */
        public RemoteViews f17421i;

        /* renamed from: j, reason: collision with root package name */
        public Bitmap f17422j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f17423k;

        /* renamed from: l, reason: collision with root package name */
        public int f17424l;

        /* renamed from: m, reason: collision with root package name */
        public int f17425m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f17426n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f17427o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f17428p;

        /* renamed from: q, reason: collision with root package name */
        public f f17429q;

        /* renamed from: r, reason: collision with root package name */
        public CharSequence f17430r;

        /* renamed from: s, reason: collision with root package name */
        public CharSequence f17431s;

        /* renamed from: t, reason: collision with root package name */
        public CharSequence[] f17432t;

        /* renamed from: u, reason: collision with root package name */
        public int f17433u;

        /* renamed from: v, reason: collision with root package name */
        public int f17434v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f17435w;

        /* renamed from: x, reason: collision with root package name */
        public String f17436x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f17437y;

        /* renamed from: z, reason: collision with root package name */
        public String f17438z;

        public e(Context context, String str) {
            this.f17414b = new ArrayList();
            this.f17415c = new ArrayList();
            this.f17416d = new ArrayList();
            this.f17426n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f17413a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f17425m = 0;
            this.U = new ArrayList();
            this.Q = true;
        }

        public static CharSequence h(CharSequence charSequence) {
            return charSequence == null ? charSequence : charSequence.length() > 5120 ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z10) {
            this.f17426n = z10;
            return this;
        }

        public e B(int i10) {
            this.R.icon = i10;
            return this;
        }

        public e C(Uri uri) {
            AudioAttributes.Builder contentType;
            AudioAttributes.Builder usage;
            AudioAttributes build;
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                contentType = new AudioAttributes.Builder().setContentType(4);
                usage = contentType.setUsage(5);
                build = usage.build();
                notification.audioAttributes = build;
            }
            return this;
        }

        public e D(f fVar) {
            if (this.f17429q != fVar) {
                this.f17429q = fVar;
                if (fVar != null) {
                    fVar.l(this);
                }
            }
            return this;
        }

        public e E(CharSequence charSequence) {
            this.R.tickerText = h(charSequence);
            return this;
        }

        public e F(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public e G(int i10) {
            this.G = i10;
            return this;
        }

        public e H(long j10) {
            this.R.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f17414b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f17414b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new e1(this).c();
        }

        public int d() {
            return this.F;
        }

        public Bundle e() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public int f() {
            return this.f17425m;
        }

        public long g() {
            if (this.f17426n) {
                return this.R.when;
            }
            return 0L;
        }

        public final Bitmap i(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f17413a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d10 = dimensionPixelSize;
            double max = Math.max(1, bitmap.getWidth());
            Double.isNaN(d10);
            Double.isNaN(max);
            double d11 = d10 / max;
            double d12 = dimensionPixelSize2;
            double max2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d12);
            Double.isNaN(max2);
            double min = Math.min(d11, d12 / max2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int ceil = (int) Math.ceil(width * min);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * min), true);
        }

        public e j(boolean z10) {
            t(16, z10);
            return this;
        }

        public e k(String str) {
            this.D = str;
            return this;
        }

        public e l(String str) {
            this.L = str;
            return this;
        }

        public e m(int i10) {
            this.F = i10;
            return this;
        }

        public e n(PendingIntent pendingIntent) {
            this.f17419g = pendingIntent;
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f17418f = h(charSequence);
            return this;
        }

        public e p(CharSequence charSequence) {
            this.f17417e = h(charSequence);
            return this;
        }

        public e q(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        public e r(int i10) {
            Notification notification = this.R;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e s(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public final void t(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.R;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.R;
                notification2.flags = (i10 ^ (-1)) & notification2.flags;
            }
        }

        public e u(Bitmap bitmap) {
            this.f17422j = i(bitmap);
            return this;
        }

        public e v(int i10, int i11, int i12) {
            Notification notification = this.R;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e w(boolean z10) {
            this.A = z10;
            return this;
        }

        public e x(int i10) {
            this.f17424l = i10;
            return this;
        }

        public e y(boolean z10) {
            t(2, z10);
            return this;
        }

        public e z(int i10) {
            this.f17425m = i10;
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }
}
