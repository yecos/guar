package c9;

import okhttp3.internal.http2.Header;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f5666d = ByteString.encodeUtf8(":status");

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f5667e = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f5668f = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f5669g = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f5670h = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f5671i = ByteString.encodeUtf8(":host");

    /* renamed from: j, reason: collision with root package name */
    public static final ByteString f5672j = ByteString.encodeUtf8(":version");

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f5673a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f5674b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5675c;

    public d(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5673a.equals(dVar.f5673a) && this.f5674b.equals(dVar.f5674b);
    }

    public int hashCode() {
        return ((527 + this.f5673a.hashCode()) * 31) + this.f5674b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f5673a.utf8(), this.f5674b.utf8());
    }

    public d(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public d(ByteString byteString, ByteString byteString2) {
        this.f5673a = byteString;
        this.f5674b = byteString2;
        this.f5675c = byteString.size() + 32 + byteString2.size();
    }
}
