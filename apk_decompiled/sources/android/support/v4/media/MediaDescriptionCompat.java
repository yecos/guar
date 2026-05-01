package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f579a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f580b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f581c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f582d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f583e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f584f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f585g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f586h;

    /* renamed from: i, reason: collision with root package name */
    public MediaDescription f587i;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            Parcelable.Creator creator;
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            creator = MediaDescription.CREATOR;
            return MediaDescriptionCompat.a(creator.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f588a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f589b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f590c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f591d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f592e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f593f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f594g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f595h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f588a, this.f589b, this.f590c, this.f591d, this.f592e, this.f593f, this.f594g, this.f595h);
        }

        public b b(CharSequence charSequence) {
            this.f591d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f594g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f592e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f593f = uri;
            return this;
        }

        public b f(String str) {
            this.f588a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f595h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f590c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f589b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f579a = str;
        this.f580b = charSequence;
        this.f581c = charSequence2;
        this.f582d = charSequence3;
        this.f583e = bitmap;
        this.f584f = uri;
        this.f585g = bundle;
        this.f586h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L85
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L85
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            android.media.MediaDescription r9 = android.support.v4.media.a.a(r9)
            java.lang.String r3 = android.support.v4.media.c.a(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.d.a(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.e.a(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.f.a(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.g.a(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.h.a(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.i.a(r9)
            if (r3 == 0) goto L46
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.s(r3)
        L46:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L51
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L52
        L51:
            r5 = r0
        L52:
            if (r5 == 0) goto L6a
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L64
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L64
            goto L6b
        L64:
            r3.remove(r4)
            r3.remove(r6)
        L6a:
            r0 = r3
        L6b:
            r2.c(r0)
            if (r5 == 0) goto L74
            r2.g(r5)
            goto L7f
        L74:
            r0 = 23
            if (r1 < r0) goto L7f
            android.net.Uri r0 = android.support.v4.media.j.a(r9)
            r2.g(r0)
        L7f:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.f587i = r9
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Bitmap b() {
        return this.f583e;
    }

    public Uri c() {
        return this.f584f;
    }

    public Object d() {
        int i10;
        MediaDescription build;
        MediaDescription mediaDescription = this.f587i;
        if (mediaDescription != null || (i10 = Build.VERSION.SDK_INT) < 21) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f579a);
        builder.setTitle(this.f580b);
        builder.setSubtitle(this.f581c);
        builder.setDescription(this.f582d);
        builder.setIconBitmap(this.f583e);
        builder.setIconUri(this.f584f);
        Bundle bundle = this.f585g;
        if (i10 < 23 && this.f586h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f586h);
        }
        builder.setExtras(bundle);
        if (i10 >= 23) {
            builder.setMediaUri(this.f586h);
        }
        build = builder.build();
        this.f587i = build;
        return build;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f581c;
    }

    public CharSequence f() {
        return this.f580b;
    }

    public String toString() {
        return ((Object) this.f580b) + ", " + ((Object) this.f581c) + ", " + ((Object) this.f582d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.a.a(d()).writeToParcel(parcel, i10);
            return;
        }
        parcel.writeString(this.f579a);
        TextUtils.writeToParcel(this.f580b, parcel, i10);
        TextUtils.writeToParcel(this.f581c, parcel, i10);
        TextUtils.writeToParcel(this.f582d, parcel, i10);
        parcel.writeParcelable(this.f583e, i10);
        parcel.writeParcelable(this.f584f, i10);
        parcel.writeBundle(this.f585g);
        parcel.writeParcelable(this.f586h, i10);
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f579a = parcel.readString();
        this.f580b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f581c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f582d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f583e = (Bitmap) parcel.readParcelable(classLoader);
        this.f584f = (Uri) parcel.readParcelable(classLoader);
        this.f585g = parcel.readBundle(classLoader);
        this.f586h = (Uri) parcel.readParcelable(classLoader);
    }
}
