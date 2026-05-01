package com.hpplay.a.a.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.a.a.a.d;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;

/* loaded from: classes2.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7232a = "postData";

    /* renamed from: b, reason: collision with root package name */
    public static final int f7233b = 8192;

    /* renamed from: c, reason: collision with root package name */
    public static final int f7234c = 1024;

    /* renamed from: d, reason: collision with root package name */
    private static final int f7235d = 512;

    /* renamed from: e, reason: collision with root package name */
    private static final int f7236e = 1024;

    /* renamed from: f, reason: collision with root package name */
    private final d f7237f;

    /* renamed from: g, reason: collision with root package name */
    private final com.hpplay.a.a.a.e.e f7238g;

    /* renamed from: h, reason: collision with root package name */
    private final OutputStream f7239h;

    /* renamed from: i, reason: collision with root package name */
    private final BufferedInputStream f7240i;

    /* renamed from: j, reason: collision with root package name */
    private int f7241j;

    /* renamed from: k, reason: collision with root package name */
    private int f7242k;

    /* renamed from: l, reason: collision with root package name */
    private String f7243l;

    /* renamed from: m, reason: collision with root package name */
    private com.hpplay.a.a.a.b.a f7244m;

    /* renamed from: n, reason: collision with root package name */
    private Map<String, List<String>> f7245n;

    /* renamed from: o, reason: collision with root package name */
    private Map<String, String> f7246o;

    /* renamed from: p, reason: collision with root package name */
    private com.hpplay.a.a.a.a.c f7247p;

    /* renamed from: q, reason: collision with root package name */
    private String f7248q;

    /* renamed from: r, reason: collision with root package name */
    private String f7249r;

    /* renamed from: s, reason: collision with root package name */
    private String f7250s;

    /* renamed from: t, reason: collision with root package name */
    private String f7251t;

    public b(d dVar, com.hpplay.a.a.a.e.e eVar, InputStream inputStream, OutputStream outputStream) {
        this.f7237f = dVar;
        this.f7238g = eVar;
        this.f7240i = new BufferedInputStream(inputStream, 8192);
        this.f7239h = outputStream;
    }

    private void a(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) {
        String decodePercent;
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            if (!stringTokenizer.hasMoreTokens()) {
                throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put(FirebaseAnalytics.Param.METHOD, stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(63);
            if (indexOf >= 0) {
                a(nextToken.substring(indexOf + 1), map2);
                decodePercent = d.decodePercent(nextToken.substring(0, indexOf));
            } else {
                decodePercent = d.decodePercent(nextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                this.f7251t = stringTokenizer.nextToken();
            } else {
                this.f7251t = "HTTP/1.1";
                d.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
            }
            String readLine2 = bufferedReader.readLine();
            while (readLine2 != null && !readLine2.trim().isEmpty()) {
                int indexOf2 = readLine2.indexOf(58);
                if (indexOf2 >= 0) {
                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                }
                readLine2 = bufferedReader.readLine();
            }
            map.put("uri", decodePercent);
        } catch (IOException e10) {
            throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e10.getMessage(), e10);
        }
    }

    private int b(byte[] bArr, int i10) {
        int i11;
        int i12 = 0;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= i10) {
                return 0;
            }
            byte b10 = bArr[i12];
            if (b10 == 13 && bArr[i13] == 10 && (i11 = i12 + 3) < i10 && bArr[i12 + 2] == 13 && bArr[i11] == 10) {
                return i12 + 4;
            }
            if (b10 == 10 && bArr[i13] == 10) {
                return i12 + 2;
            }
            i12 = i13;
        }
    }

    private RandomAccessFile m() {
        try {
            return new RandomAccessFile(this.f7238g.a(null).b(), "rw");
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    @Override // com.hpplay.a.a.a.c
    public final Map<String, String> c() {
        return this.f7246o;
    }

    @Override // com.hpplay.a.a.a.c
    public final InputStream d() {
        return this.f7240i;
    }

    @Override // com.hpplay.a.a.a.c
    public final com.hpplay.a.a.a.b.a e() {
        return this.f7244m;
    }

    @Override // com.hpplay.a.a.a.c
    @Deprecated
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        for (String str : this.f7245n.keySet()) {
            hashMap.put(str, this.f7245n.get(str).get(0));
        }
        return hashMap;
    }

    @Override // com.hpplay.a.a.a.c
    public final Map<String, List<String>> g() {
        return this.f7245n;
    }

    @Override // com.hpplay.a.a.a.c
    public String h() {
        return this.f7248q;
    }

    @Override // com.hpplay.a.a.a.c
    public final String i() {
        return this.f7243l;
    }

    public long j() {
        if (this.f7246o.containsKey("content-length")) {
            return Long.parseLong(this.f7246o.get("content-length"));
        }
        if (this.f7241j < this.f7242k) {
            return r1 - r0;
        }
        return 0L;
    }

    @Override // com.hpplay.a.a.a.c
    public String k() {
        return this.f7249r;
    }

    @Override // com.hpplay.a.a.a.c
    public String l() {
        return this.f7250s;
    }

    @Override // com.hpplay.a.a.a.c
    public com.hpplay.a.a.a.a.c b() {
        return this.f7247p;
    }

    public b(d dVar, com.hpplay.a.a.a.e.e eVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f7237f = dVar;
        this.f7238g = eVar;
        this.f7240i = new BufferedInputStream(inputStream, 8192);
        this.f7239h = outputStream;
        this.f7249r = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        this.f7250s = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
        this.f7246o = new HashMap();
    }

    private void a(com.hpplay.a.a.a.a.a aVar, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) {
        String str;
        try {
            int[] a10 = a(byteBuffer, aVar.d().getBytes());
            int i10 = 2;
            if (a10.length >= 2) {
                int i11 = 1024;
                byte[] bArr = new byte[1024];
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    int i15 = 1;
                    if (i13 >= a10.length - 1) {
                        return;
                    }
                    byteBuffer.position(a10[i13]);
                    int remaining = byteBuffer.remaining() < i11 ? byteBuffer.remaining() : 1024;
                    byteBuffer.get(bArr, i12, remaining);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i12, remaining), Charset.forName(aVar.c())), remaining);
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || !readLine.contains(aVar.d())) {
                        break;
                    }
                    String readLine2 = bufferedReader.readLine();
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    int i16 = 2;
                    while (readLine2 != null && readLine2.trim().length() > 0) {
                        Matcher matcher = d.CONTENT_DISPOSITION_PATTERN.matcher(readLine2);
                        if (matcher.matches()) {
                            Matcher matcher2 = d.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i10));
                            while (matcher2.find()) {
                                String group = matcher2.group(i15);
                                if ("name".equalsIgnoreCase(group)) {
                                    str = matcher2.group(2);
                                } else {
                                    if ("filename".equalsIgnoreCase(group)) {
                                        String group2 = matcher2.group(2);
                                        if (!group2.isEmpty()) {
                                            if (i14 > 0) {
                                                str = str2 + String.valueOf(i14);
                                                str3 = group2;
                                                i14++;
                                            } else {
                                                i14++;
                                            }
                                        }
                                        str3 = group2;
                                    }
                                    i15 = 1;
                                }
                                str2 = str;
                                i15 = 1;
                            }
                        }
                        Matcher matcher3 = d.CONTENT_TYPE_PATTERN.matcher(readLine2);
                        if (matcher3.matches()) {
                            str4 = matcher3.group(2).trim();
                        }
                        readLine2 = bufferedReader.readLine();
                        i16++;
                        i10 = 2;
                        i15 = 1;
                    }
                    int i17 = 0;
                    while (true) {
                        int i18 = i16 - 1;
                        if (i16 <= 0) {
                            break;
                        }
                        i17 = a(bArr, i17);
                        i16 = i18;
                    }
                    if (i17 < remaining - 4) {
                        int i19 = a10[i13] + i17;
                        i13++;
                        int i20 = a10[i13] - 4;
                        byteBuffer.position(i19);
                        List<String> list = map.get(str2);
                        if (list == null) {
                            list = new ArrayList<>();
                            map.put(str2, list);
                        }
                        if (str4 == null) {
                            byte[] bArr2 = new byte[i20 - i19];
                            byteBuffer.get(bArr2);
                            list.add(new String(bArr2, aVar.c()));
                        } else {
                            String a11 = a(byteBuffer, i19, i20 - i19, str3);
                            if (!map2.containsKey(str2)) {
                                map2.put(str2, a11);
                            } else {
                                int i21 = 2;
                                while (true) {
                                    if (!map2.containsKey(str2 + i21)) {
                                        break;
                                    } else {
                                        i21++;
                                    }
                                }
                                map2.put(str2 + i21, a11);
                            }
                            list.add(str3);
                        }
                        i11 = 1024;
                        i10 = 2;
                        i12 = 0;
                    } else {
                        throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                    }
                }
                throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
            }
            throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
        } catch (d.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, e11.toString());
        }
    }

    private int a(byte[] bArr, int i10) {
        while (bArr[i10] != 10) {
            i10++;
        }
        return i10 + 1;
    }

    private void a(String str, Map<String, List<String>> map) {
        String trim;
        String str2;
        if (str == null) {
            this.f7248q = "";
            return;
        }
        this.f7248q = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str, DispatchConstants.SIGN_SPLIT_SYMBOL);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf >= 0) {
                trim = d.decodePercent(nextToken.substring(0, indexOf)).trim();
                str2 = d.decodePercent(nextToken.substring(indexOf + 1));
            } else {
                trim = d.decodePercent(nextToken).trim();
                str2 = "";
            }
            List<String> list = map.get(trim);
            if (list == null) {
                list = new ArrayList<>();
                map.put(trim, list);
            }
            list.add(str2);
        }
    }

    @Override // com.hpplay.a.a.a.c
    public void a() {
        byte[] bArr;
        com.hpplay.a.a.a.c.c cVar = null;
        try {
            try {
                try {
                    try {
                        try {
                            bArr = new byte[8192];
                            this.f7241j = 0;
                            this.f7242k = 0;
                            this.f7240i.mark(8192);
                        } catch (SocketTimeoutException e10) {
                            throw e10;
                        }
                    } catch (SSLException e11) {
                        com.hpplay.a.a.a.c.c.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, d.MIME_PLAINTEXT, "SSL PROTOCOL FAILURE: " + e11.getMessage()).a(this.f7239h);
                        d.safeClose(this.f7239h);
                    }
                } catch (d.a e12) {
                    com.hpplay.a.a.a.c.c.a(e12.a(), d.MIME_PLAINTEXT, e12.getMessage()).a(this.f7239h);
                    d.safeClose(this.f7239h);
                }
            } catch (SocketException e13) {
                throw e13;
            } catch (IOException e14) {
                com.hpplay.a.a.a.c.c.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, d.MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e14.getMessage()).a(this.f7239h);
                d.safeClose(this.f7239h);
            }
            try {
                int read = this.f7240i.read(bArr, 0, 8192);
                if (read != -1) {
                    while (read > 0) {
                        int i10 = this.f7242k + read;
                        this.f7242k = i10;
                        int b10 = b(bArr, i10);
                        this.f7241j = b10;
                        if (b10 > 0) {
                            break;
                        }
                        BufferedInputStream bufferedInputStream = this.f7240i;
                        int i11 = this.f7242k;
                        read = bufferedInputStream.read(bArr, i11, 8192 - i11);
                    }
                    if (this.f7241j < this.f7242k) {
                        this.f7240i.reset();
                        this.f7240i.skip(this.f7241j);
                    }
                    this.f7245n = new HashMap();
                    Map<String, String> map = this.f7246o;
                    if (map == null) {
                        this.f7246o = new HashMap();
                    } else {
                        map.clear();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f7242k)));
                    HashMap hashMap = new HashMap();
                    a(bufferedReader, hashMap, this.f7245n, this.f7246o);
                    String str = this.f7249r;
                    if (str != null) {
                        this.f7246o.put("remote-addr", str);
                        this.f7246o.put("http-client-ip", this.f7249r);
                    }
                    com.hpplay.a.a.a.b.a a10 = com.hpplay.a.a.a.b.a.a(hashMap.get(FirebaseAnalytics.Param.METHOD));
                    this.f7244m = a10;
                    if (a10 != null) {
                        this.f7243l = hashMap.get("uri");
                        this.f7247p = new com.hpplay.a.a.a.a.c(this.f7246o);
                        String str2 = this.f7246o.get("connection");
                        boolean z10 = "HTTP/1.1".equals(this.f7251t) && (str2 == null || !str2.matches("(?i).*close.*"));
                        cVar = this.f7237f.handle(this);
                        if (cVar != null) {
                            String str3 = this.f7246o.get("accept-encoding");
                            this.f7247p.a(cVar);
                            cVar.a(this.f7244m);
                            if (str3 == null || !str3.contains("gzip")) {
                                cVar.d(false);
                            }
                            cVar.b(z10);
                            cVar.a(this.f7239h);
                            if (!z10 || cVar.b()) {
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                            return;
                        }
                        throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                    }
                    throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + hashMap.get(FirebaseAnalytics.Param.METHOD) + " unhandled.");
                }
                d.safeClose(this.f7240i);
                d.safeClose(this.f7239h);
                throw new SocketException("NanoHttpd Shutdown");
            } catch (SSLException e15) {
                throw e15;
            } catch (IOException unused) {
                d.safeClose(this.f7240i);
                d.safeClose(this.f7239h);
                throw new SocketException("NanoHttpd Shutdown");
            }
        } finally {
            d.safeClose(null);
            this.f7238g.a();
        }
    }

    private int[] a(ByteBuffer byteBuffer, byte[] bArr) {
        int[] iArr = new int[0];
        if (byteBuffer.remaining() < bArr.length) {
            return iArr;
        }
        int length = bArr.length + 4096;
        byte[] bArr2 = new byte[length];
        int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
        byteBuffer.get(bArr2, 0, remaining);
        int length2 = remaining - bArr.length;
        int i10 = 0;
        do {
            for (int i11 = 0; i11 < length2; i11++) {
                for (int i12 = 0; i12 < bArr.length && bArr2[i11 + i12] == bArr[i12]; i12++) {
                    if (i12 == bArr.length - 1) {
                        int[] iArr2 = new int[iArr.length + 1];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i10 + i11;
                        iArr = iArr2;
                    }
                }
            }
            i10 += length2;
            System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
            length2 = length - bArr.length;
            if (byteBuffer.remaining() < length2) {
                length2 = byteBuffer.remaining();
            }
            byteBuffer.get(bArr2, bArr.length, length2);
        } while (length2 > 0);
        return iArr;
    }

    @Override // com.hpplay.a.a.a.c
    public void a(Map<String, String> map) {
        long j10;
        RandomAccessFile m10;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutput dataOutput;
        ByteBuffer map2;
        RandomAccessFile randomAccessFile = null;
        try {
            j10 = j();
            if (j10 < 1024) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutput = new DataOutputStream(byteArrayOutputStream);
                m10 = null;
            } else {
                m10 = m();
                byteArrayOutputStream = null;
                dataOutput = m10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[512];
            while (this.f7242k >= 0 && j10 > 0) {
                int read = this.f7240i.read(bArr, 0, (int) Math.min(j10, 512L));
                this.f7242k = read;
                j10 -= read;
                if (read > 0) {
                    dataOutput.write(bArr, 0, read);
                }
            }
            if (byteArrayOutputStream != null) {
                map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            } else {
                map2 = m10.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, m10.length());
                m10.seek(0L);
            }
            if (com.hpplay.a.a.a.b.a.POST.equals(this.f7244m)) {
                com.hpplay.a.a.a.a.a aVar = new com.hpplay.a.a.a.a.a(this.f7246o.get("content-type"));
                if (aVar.e()) {
                    if (aVar.d() != null) {
                        a(aVar, map2, this.f7245n, map);
                    } else {
                        throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                } else {
                    byte[] bArr2 = new byte[map2.remaining()];
                    map2.get(bArr2);
                    String trim = new String(bArr2, aVar.c()).trim();
                    if ("application/x-www-form-urlencoded".equalsIgnoreCase(aVar.b())) {
                        a(trim, this.f7245n);
                    } else if (trim.length() != 0) {
                        map.put(f7232a, trim);
                    }
                }
            } else if (com.hpplay.a.a.a.b.a.PUT.equals(this.f7244m)) {
                map.put("content", a(map2, 0, map2.limit(), (String) null));
            }
            d.safeClose(m10);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = m10;
            d.safeClose(randomAccessFile);
            throw th;
        }
    }

    private String a(ByteBuffer byteBuffer, int i10, int i11, String str) {
        com.hpplay.a.a.a.e.d a10;
        ByteBuffer duplicate;
        FileOutputStream fileOutputStream;
        if (i11 <= 0) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                a10 = this.f7238g.a(str);
                duplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(a10.b());
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            FileChannel channel = fileOutputStream.getChannel();
            duplicate.position(i10).limit(i10 + i11);
            channel.write(duplicate.slice());
            String b10 = a10.b();
            d.safeClose(fileOutputStream);
            return b10;
        } catch (Exception e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            throw new Error(e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.safeClose(fileOutputStream2);
            throw th;
        }
    }
}
