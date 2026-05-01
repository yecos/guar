package c9;

import anet.channel.util.HttpConstant;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f5681a = ByteString.encodeUtf8(SOAP.DELIM);

    /* renamed from: b, reason: collision with root package name */
    public static final d[] f5682b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map f5683c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f5684a;

        /* renamed from: b, reason: collision with root package name */
        public final BufferedSource f5685b;

        /* renamed from: c, reason: collision with root package name */
        public int f5686c;

        /* renamed from: d, reason: collision with root package name */
        public int f5687d;

        /* renamed from: e, reason: collision with root package name */
        public d[] f5688e;

        /* renamed from: f, reason: collision with root package name */
        public int f5689f;

        /* renamed from: g, reason: collision with root package name */
        public int f5690g;

        /* renamed from: h, reason: collision with root package name */
        public int f5691h;

        public a(int i10, Source source) {
            this(i10, i10, source);
        }

        public final void a() {
            int i10 = this.f5687d;
            int i11 = this.f5691h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f5688e, (Object) null);
            this.f5689f = this.f5688e.length - 1;
            this.f5690g = 0;
            this.f5691h = 0;
        }

        public final int c(int i10) {
            return this.f5689f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f5688e.length;
                while (true) {
                    length--;
                    i11 = this.f5689f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f5688e[length].f5675c;
                    i10 -= i13;
                    this.f5691h -= i13;
                    this.f5690g--;
                    i12++;
                }
                d[] dVarArr = this.f5688e;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f5690g);
                this.f5689f += i12;
            }
            return i12;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f5684a);
            this.f5684a.clear();
            return arrayList;
        }

        public final ByteString f(int i10) {
            if (i(i10)) {
                return f.f5682b[i10].f5673a;
            }
            int c10 = c(i10 - f.f5682b.length);
            if (c10 >= 0) {
                d[] dVarArr = this.f5688e;
                if (c10 < dVarArr.length) {
                    return dVarArr[c10].f5673a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public void g(int i10) {
            this.f5686c = i10;
            this.f5687d = i10;
            a();
        }

        public final void h(int i10, d dVar) {
            this.f5684a.add(dVar);
            int i11 = dVar.f5675c;
            if (i10 != -1) {
                i11 -= this.f5688e[c(i10)].f5675c;
            }
            int i12 = this.f5687d;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f5691h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f5690g + 1;
                d[] dVarArr = this.f5688e;
                if (i13 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f5689f = this.f5688e.length - 1;
                    this.f5688e = dVarArr2;
                }
                int i14 = this.f5689f;
                this.f5689f = i14 - 1;
                this.f5688e[i14] = dVar;
                this.f5690g++;
            } else {
                this.f5688e[i10 + c(i10) + d10] = dVar;
            }
            this.f5691h += i11;
        }

        public final boolean i(int i10) {
            return i10 >= 0 && i10 <= f.f5682b.length - 1;
        }

        public final int j() {
            return this.f5685b.readByte() & UnsignedBytes.MAX_VALUE;
        }

        public ByteString k() {
            int j10 = j();
            boolean z10 = (j10 & 128) == 128;
            int n10 = n(j10, 127);
            return z10 ? ByteString.of(h.f().c(this.f5685b.readByteArray(n10))) : this.f5685b.readByteString(n10);
        }

        public void l() {
            while (!this.f5685b.exhausted()) {
                int readByte = this.f5685b.readByte() & UnsignedBytes.MAX_VALUE;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m(n(readByte, 127) - 1);
                } else if (readByte == 64) {
                    p();
                } else if ((readByte & 64) == 64) {
                    o(n(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n10 = n(readByte, 31);
                    this.f5687d = n10;
                    if (n10 < 0 || n10 > this.f5686c) {
                        throw new IOException("Invalid dynamic table size update " + this.f5687d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    r();
                } else {
                    q(n(readByte, 15) - 1);
                }
            }
        }

        public final void m(int i10) {
            if (i(i10)) {
                this.f5684a.add(f.f5682b[i10]);
                return;
            }
            int c10 = c(i10 - f.f5682b.length);
            if (c10 >= 0) {
                d[] dVarArr = this.f5688e;
                if (c10 <= dVarArr.length - 1) {
                    this.f5684a.add(dVarArr[c10]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public int n(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int j10 = j();
                if ((j10 & 128) == 0) {
                    return i11 + (j10 << i13);
                }
                i11 += (j10 & 127) << i13;
                i13 += 7;
            }
        }

        public final void o(int i10) {
            h(-1, new d(f(i10), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i10) {
            this.f5684a.add(new d(f(i10), k()));
        }

        public final void r() {
            this.f5684a.add(new d(f.e(k()), k()));
        }

        public a(int i10, int i11, Source source) {
            this.f5684a = new ArrayList();
            this.f5688e = new d[8];
            this.f5689f = r0.length - 1;
            this.f5690g = 0;
            this.f5691h = 0;
            this.f5686c = i10;
            this.f5687d = i11;
            this.f5685b = Okio.buffer(source);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Buffer f5692a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5693b;

        /* renamed from: c, reason: collision with root package name */
        public int f5694c;

        /* renamed from: d, reason: collision with root package name */
        public int f5695d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5696e;

        /* renamed from: f, reason: collision with root package name */
        public int f5697f;

        /* renamed from: g, reason: collision with root package name */
        public d[] f5698g;

        /* renamed from: h, reason: collision with root package name */
        public int f5699h;

        /* renamed from: i, reason: collision with root package name */
        public int f5700i;

        /* renamed from: j, reason: collision with root package name */
        public int f5701j;

        public b(Buffer buffer) {
            this(4096, false, buffer);
        }

        public final void a() {
            Arrays.fill(this.f5698g, (Object) null);
            this.f5700i = this.f5698g.length - 1;
            this.f5699h = 0;
            this.f5701j = 0;
        }

        public final int b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f5698g.length;
                while (true) {
                    length--;
                    i11 = this.f5700i;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f5698g[length].f5675c;
                    i10 -= i13;
                    this.f5701j -= i13;
                    this.f5699h--;
                    i12++;
                }
                d[] dVarArr = this.f5698g;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f5699h);
                this.f5700i += i12;
            }
            return i12;
        }

        public final void c(d dVar) {
            int i10 = dVar.f5675c;
            int i11 = this.f5697f;
            if (i10 > i11) {
                a();
                return;
            }
            b((this.f5701j + i10) - i11);
            int i12 = this.f5699h + 1;
            d[] dVarArr = this.f5698g;
            if (i12 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f5700i = this.f5698g.length - 1;
                this.f5698g = dVarArr2;
            }
            int i13 = this.f5700i;
            this.f5700i = i13 - 1;
            this.f5698g[i13] = dVar;
            this.f5699h++;
            this.f5701j += i10;
        }

        public void d(ByteString byteString) {
            if (!this.f5693b || h.f().e(byteString.toByteArray()) >= byteString.size()) {
                f(byteString.size(), 127, 0);
                this.f5692a.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            h.f().d(byteString.toByteArray(), buffer.outputStream());
            ByteString readByteString = buffer.readByteString();
            f(readByteString.size(), 127, 128);
            this.f5692a.write(readByteString);
        }

        public void e(List list) {
            int i10;
            int i11;
            if (this.f5696e) {
                int i12 = this.f5695d;
                if (i12 < this.f5697f) {
                    f(i12, 31, 32);
                }
                this.f5696e = false;
                this.f5695d = Integer.MAX_VALUE;
                f(this.f5697f, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                d dVar = (d) list.get(i13);
                ByteString asciiLowercase = dVar.f5673a.toAsciiLowercase();
                ByteString byteString = dVar.f5674b;
                Integer num = (Integer) f.f5683c.get(asciiLowercase);
                if (num != null) {
                    i10 = num.intValue() + 1;
                    if (i10 >= 2 && i10 <= 7) {
                        if (f.f5682b[i10 - 1].f5674b.equals(byteString)) {
                            i11 = i10;
                        } else if (f.f5682b[i10].f5674b.equals(byteString)) {
                            i11 = i10;
                            i10++;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i10 = -1;
                    i11 = -1;
                }
                if (i10 == -1) {
                    int i14 = this.f5700i;
                    while (true) {
                        i14++;
                        d[] dVarArr = this.f5698g;
                        if (i14 >= dVarArr.length) {
                            break;
                        }
                        if (dVarArr[i14].f5673a.equals(asciiLowercase)) {
                            if (this.f5698g[i14].f5674b.equals(byteString)) {
                                i10 = f.f5682b.length + (i14 - this.f5700i);
                                break;
                            } else if (i11 == -1) {
                                i11 = (i14 - this.f5700i) + f.f5682b.length;
                            }
                        }
                    }
                }
                if (i10 != -1) {
                    f(i10, 127, 128);
                } else if (i11 == -1) {
                    this.f5692a.writeByte(64);
                    d(asciiLowercase);
                    d(byteString);
                    c(dVar);
                } else if (!asciiLowercase.startsWith(f.f5681a) || d.f5670h.equals(asciiLowercase)) {
                    f(i11, 63, 64);
                    d(byteString);
                    c(dVar);
                } else {
                    f(i11, 15, 0);
                    d(byteString);
                }
            }
        }

        public void f(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f5692a.writeByte(i10 | i12);
                return;
            }
            this.f5692a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f5692a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f5692a.writeByte(i13);
        }

        public b(int i10, boolean z10, Buffer buffer) {
            this.f5695d = Integer.MAX_VALUE;
            this.f5698g = new d[8];
            this.f5700i = r0.length - 1;
            this.f5694c = i10;
            this.f5697f = i10;
            this.f5693b = z10;
            this.f5692a = buffer;
        }
    }

    static {
        ByteString byteString = d.f5667e;
        ByteString byteString2 = d.f5668f;
        ByteString byteString3 = d.f5669g;
        ByteString byteString4 = d.f5666d;
        f5682b = new d[]{new d(d.f5670h, ""), new d(byteString, "GET"), new d(byteString, "POST"), new d(byteString2, Operator.Operation.DIVISION), new d(byteString2, "/index.html"), new d(byteString3, HttpConstant.HTTP), new d(byteString3, "https"), new d(byteString4, ProtocolBuilder.LELINK_STATE_SUCCESS), new d(byteString4, "204"), new d(byteString4, "206"), new d(byteString4, "304"), new d(byteString4, "400"), new d(byteString4, "404"), new d(byteString4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d(PlistBuilder.KEY_CONTENT_LOCATION, ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d(Constants.MessagePayloadKeys.FROM, ""), new d(com.taobao.accs.common.Constants.KEY_HOST, ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d(DynamicLink.Builder.KEY_LINK, ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f5683c = f();
    }

    public static ByteString e(ByteString byteString) {
        int size = byteString.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b10 = byteString.getByte(i10);
            if (b10 >= 65 && b10 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f5682b.length);
        int i10 = 0;
        while (true) {
            d[] dVarArr = f5682b;
            if (i10 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i10].f5673a)) {
                linkedHashMap.put(dVarArr[i10].f5673a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
