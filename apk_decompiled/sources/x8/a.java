package x8;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLException;
import okhttp3.internal.http.StatusLine;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f19478h = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_DISPOSITION_REGEX, 2);

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f19479i = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_TYPE_REGEX, 2);

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f19480j = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_DISPOSITION_ATTRIBUTE_REGEX);

    /* renamed from: k, reason: collision with root package name */
    public static final Logger f19481k = Logger.getLogger(a.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final String f19482a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19483b;

    /* renamed from: c, reason: collision with root package name */
    public volatile ServerSocket f19484c;

    /* renamed from: d, reason: collision with root package name */
    public p f19485d;

    /* renamed from: e, reason: collision with root package name */
    public Thread f19486e;

    /* renamed from: f, reason: collision with root package name */
    public b f19487f;

    /* renamed from: g, reason: collision with root package name */
    public r f19488g;

    public interface b {
        void a(c cVar);

        void b(c cVar);
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f19489a;

        /* renamed from: b, reason: collision with root package name */
        public final Socket f19490b;

        public c(InputStream inputStream, Socket socket) {
            this.f19489a = inputStream;
            this.f19490b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = this.f19490b.getOutputStream();
                    j jVar = a.this.new j(a.this.f19488g.create(), this.f19489a, outputStream, this.f19490b.getInetAddress());
                    while (!this.f19490b.isClosed()) {
                        jVar.d();
                    }
                } catch (Exception e10) {
                    if ((!(e10 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e10.getMessage())) && !(e10 instanceof SocketTimeoutException)) {
                        a.f19481k.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e10);
                    }
                }
            } finally {
                a.o(outputStream);
                a.o(this.f19489a);
                a.o(this.f19490b);
                a.this.f19487f.b(this);
            }
        }
    }

    public static class d {

        /* renamed from: e, reason: collision with root package name */
        public static final Pattern f19492e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

        /* renamed from: f, reason: collision with root package name */
        public static final Pattern f19493f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: g, reason: collision with root package name */
        public static final Pattern f19494g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: a, reason: collision with root package name */
        public final String f19495a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19496b;

        /* renamed from: c, reason: collision with root package name */
        public final String f19497c;

        /* renamed from: d, reason: collision with root package name */
        public final String f19498d;

        public d(String str) {
            this.f19495a = str;
            if (str != null) {
                this.f19496b = b(str, f19492e, "", 1);
                this.f19497c = b(str, f19493f, null, 2);
            } else {
                this.f19496b = "";
                this.f19497c = "UTF-8";
            }
            if ("multipart/form-data".equalsIgnoreCase(this.f19496b)) {
                this.f19498d = b(str, f19494g, null, 2);
            } else {
                this.f19498d = null;
            }
        }

        public String a() {
            return this.f19495a;
        }

        public final String b(String str, Pattern pattern, String str2, int i10) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(i10) : str2;
        }

        public String c() {
            String str = this.f19497c;
            return str == null ? "US-ASCII" : str;
        }

        public d d() {
            if (this.f19497c != null) {
                return this;
            }
            return new d(this.f19495a + "; charset=UTF-8");
        }
    }

    public class e implements Iterable {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f19499a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f19500b = new ArrayList();

        public e(Map map) {
            String str = (String) map.get("cookie");
            if (str != null) {
                for (String str2 : str.split(";")) {
                    String[] split = str2.trim().split(Operator.Operation.EQUALS);
                    if (split.length == 2) {
                        this.f19499a.put(split[0], split[1]);
                    }
                }
            }
        }

        public void a(m mVar) {
            Iterator it = this.f19500b.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f19499a.keySet().iterator();
        }
    }

    public static class f implements b {

        /* renamed from: a, reason: collision with root package name */
        public long f19502a;

        /* renamed from: b, reason: collision with root package name */
        public final List f19503b = Collections.synchronizedList(new ArrayList());

        @Override // x8.a.b
        public void a(c cVar) {
            this.f19502a++;
            Thread thread = new Thread(cVar);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f19502a + ")");
            this.f19503b.add(cVar);
            thread.start();
        }

        @Override // x8.a.b
        public void b(c cVar) {
            this.f19503b.remove(cVar);
        }
    }

    public static class g implements p {
        @Override // x8.a.p
        public ServerSocket create() {
            return new ServerSocket();
        }
    }

    public static class h implements q {

        /* renamed from: a, reason: collision with root package name */
        public final File f19504a;

        /* renamed from: b, reason: collision with root package name */
        public final List f19505b;

        public h() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f19504a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f19505b = new ArrayList();
        }

        @Override // x8.a.q
        public void clear() {
            Iterator it = this.f19505b.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                try {
                    throw null;
                } catch (Exception e10) {
                    a.f19481k.log(Level.WARNING, "could not delete file ", (Throwable) e10);
                }
            }
            this.f19505b.clear();
        }
    }

    public class i implements r {
        public i() {
        }

        @Override // x8.a.r
        public q create() {
            return new h();
        }
    }

    public class j implements k {

        /* renamed from: a, reason: collision with root package name */
        public final q f19507a;

        /* renamed from: b, reason: collision with root package name */
        public final OutputStream f19508b;

        /* renamed from: c, reason: collision with root package name */
        public final BufferedInputStream f19509c;

        /* renamed from: d, reason: collision with root package name */
        public int f19510d;

        /* renamed from: e, reason: collision with root package name */
        public int f19511e;

        /* renamed from: f, reason: collision with root package name */
        public String f19512f;

        /* renamed from: g, reason: collision with root package name */
        public l f19513g;

        /* renamed from: h, reason: collision with root package name */
        public Map f19514h;

        /* renamed from: i, reason: collision with root package name */
        public Map f19515i;

        /* renamed from: j, reason: collision with root package name */
        public e f19516j;

        /* renamed from: k, reason: collision with root package name */
        public String f19517k;

        /* renamed from: l, reason: collision with root package name */
        public String f19518l;

        /* renamed from: m, reason: collision with root package name */
        public String f19519m;

        /* renamed from: n, reason: collision with root package name */
        public String f19520n;

        public j(q qVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.f19507a = qVar;
            this.f19509c = new BufferedInputStream(inputStream, 8192);
            this.f19508b = outputStream;
            this.f19518l = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.f19519m = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
            this.f19515i = new HashMap();
        }

        @Override // x8.a.k
        public final String a() {
            return this.f19512f;
        }

        public final void b(BufferedReader bufferedReader, Map map, Map map2, Map map3) {
            String i10;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new n(m.d.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                map.put(FirebaseAnalytics.Param.METHOD, stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new n(m.d.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(63);
                if (indexOf >= 0) {
                    c(nextToken.substring(indexOf + 1), map2);
                    i10 = a.i(nextToken.substring(0, indexOf));
                } else {
                    i10 = a.i(nextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.f19520n = stringTokenizer.nextToken();
                } else {
                    this.f19520n = "HTTP/1.1";
                    a.f19481k.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                }
                String readLine2 = bufferedReader.readLine();
                while (readLine2 != null && !readLine2.trim().isEmpty()) {
                    int indexOf2 = readLine2.indexOf(58);
                    if (indexOf2 >= 0) {
                        map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                    }
                    readLine2 = bufferedReader.readLine();
                }
                map.put("uri", i10);
            } catch (IOException e10) {
                throw new n(m.d.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e10.getMessage(), e10);
            }
        }

        public final void c(String str, Map map) {
            String trim;
            String str2;
            if (str == null) {
                this.f19517k = "";
                return;
            }
            this.f19517k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, DispatchConstants.SIGN_SPLIT_SYMBOL);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    trim = a.i(nextToken.substring(0, indexOf)).trim();
                    str2 = a.i(nextToken.substring(indexOf + 1));
                } else {
                    trim = a.i(nextToken).trim();
                    str2 = "";
                }
                List list = (List) map.get(trim);
                if (list == null) {
                    list = new ArrayList();
                    map.put(trim, list);
                }
                list.add(str2);
            }
        }

        public void d() {
            byte[] bArr;
            boolean z10;
            m mVar = null;
            try {
                try {
                    try {
                        try {
                            try {
                                bArr = new byte[8192];
                                z10 = false;
                                this.f19510d = 0;
                                this.f19511e = 0;
                                this.f19509c.mark(8192);
                            } catch (IOException e10) {
                                a.n(m.d.INTERNAL_ERROR, com.hpplay.a.a.a.d.MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e10.getMessage()).m(this.f19508b);
                                a.o(this.f19508b);
                            }
                        } catch (n e11) {
                            a.n(e11.a(), com.hpplay.a.a.a.d.MIME_PLAINTEXT, e11.getMessage()).m(this.f19508b);
                            a.o(this.f19508b);
                        }
                    } catch (SocketException e12) {
                        throw e12;
                    }
                } catch (SocketTimeoutException e13) {
                    throw e13;
                } catch (SSLException e14) {
                    a.n(m.d.INTERNAL_ERROR, com.hpplay.a.a.a.d.MIME_PLAINTEXT, "SSL PROTOCOL FAILURE: " + e14.getMessage()).m(this.f19508b);
                    a.o(this.f19508b);
                }
                try {
                    int read = this.f19509c.read(bArr, 0, 8192);
                    if (read == -1) {
                        a.o(this.f19509c);
                        a.o(this.f19508b);
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                    while (read > 0) {
                        int i10 = this.f19511e + read;
                        this.f19511e = i10;
                        int e15 = e(bArr, i10);
                        this.f19510d = e15;
                        if (e15 > 0) {
                            break;
                        }
                        BufferedInputStream bufferedInputStream = this.f19509c;
                        int i11 = this.f19511e;
                        read = bufferedInputStream.read(bArr, i11, 8192 - i11);
                    }
                    if (this.f19510d < this.f19511e) {
                        this.f19509c.reset();
                        this.f19509c.skip(this.f19510d);
                    }
                    this.f19514h = new HashMap();
                    Map map = this.f19515i;
                    if (map == null) {
                        this.f19515i = new HashMap();
                    } else {
                        map.clear();
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f19511e)));
                    HashMap hashMap = new HashMap();
                    b(bufferedReader, hashMap, this.f19514h, this.f19515i);
                    String str = this.f19518l;
                    if (str != null) {
                        this.f19515i.put("remote-addr", str);
                        this.f19515i.put("http-client-ip", this.f19518l);
                    }
                    l a10 = l.a((String) hashMap.get(FirebaseAnalytics.Param.METHOD));
                    this.f19513g = a10;
                    if (a10 == null) {
                        throw new n(m.d.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) hashMap.get(FirebaseAnalytics.Param.METHOD)) + " unhandled.");
                    }
                    this.f19512f = (String) hashMap.get("uri");
                    this.f19516j = a.this.new e(this.f19515i);
                    String str2 = (String) this.f19515i.get("connection");
                    boolean z11 = "HTTP/1.1".equals(this.f19520n) && (str2 == null || !str2.matches("(?i).*close.*"));
                    mVar = a.this.p(this);
                    if (mVar == null) {
                        throw new n(m.d.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                    }
                    String str3 = (String) this.f19515i.get("accept-encoding");
                    this.f19516j.a(mVar);
                    mVar.z(this.f19513g);
                    if (a.this.t(mVar) && str3 != null && str3.contains("gzip")) {
                        z10 = true;
                    }
                    mVar.x(z10);
                    mVar.y(z11);
                    mVar.m(this.f19508b);
                    if (!z11 || mVar.e()) {
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                } catch (SSLException e16) {
                    throw e16;
                } catch (IOException unused) {
                    a.o(this.f19509c);
                    a.o(this.f19508b);
                    throw new SocketException("NanoHttpd Shutdown");
                }
            } finally {
                a.o(null);
                this.f19507a.clear();
            }
        }

        public final int e(byte[] bArr, int i10) {
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

        @Override // x8.a.k
        public final l getMethod() {
            return this.f19513g;
        }

        @Override // x8.a.k
        public final Map getParameters() {
            return this.f19514h;
        }
    }

    public interface k {
        String a();

        l getMethod();

        Map getParameters();
    }

    public enum l {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        public static l a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public static class m implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public c f19539a;

        /* renamed from: b, reason: collision with root package name */
        public String f19540b;

        /* renamed from: c, reason: collision with root package name */
        public InputStream f19541c;

        /* renamed from: d, reason: collision with root package name */
        public long f19542d;

        /* renamed from: e, reason: collision with root package name */
        public final Map f19543e = new C0336a();

        /* renamed from: f, reason: collision with root package name */
        public final Map f19544f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        public l f19545g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f19546h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f19547i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f19548j;

        /* renamed from: x8.a$m$a, reason: collision with other inner class name */
        public class C0336a extends HashMap {
            public C0336a() {
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String put(String str, String str2) {
                m.this.f19544f.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        }

        public static class b extends FilterOutputStream {
            public b(OutputStream outputStream) {
                super(outputStream);
            }

            public void a() {
                ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                write(new byte[]{(byte) i10}, 0, 1);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr) {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                if (i11 == 0) {
                    return;
                }
                ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i11)).getBytes());
                ((FilterOutputStream) this).out.write(bArr, i10, i11);
                ((FilterOutputStream) this).out.write("\r\n".getBytes());
            }
        }

        public interface c {
            String getDescription();
        }

        public enum d implements c {
            SWITCH_PROTOCOL(101, IPushHandler.SP),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(UPnPStatus.OUT_OF_SYNC, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(Constant.TOKEN_EXPIRED, "Gone"),
            LENGTH_REQUIRED(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(UPnPStatus.ACTION_FAILED, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");


            /* renamed from: a, reason: collision with root package name */
            public final int f19574a;

            /* renamed from: b, reason: collision with root package name */
            public final String f19575b;

            d(int i10, String str) {
                this.f19574a = i10;
                this.f19575b = str;
            }

            @Override // x8.a.m.c
            public String getDescription() {
                return "" + this.f19574a + " " + this.f19575b;
            }
        }

        public m(c cVar, String str, InputStream inputStream, long j10) {
            this.f19539a = cVar;
            this.f19540b = str;
            if (inputStream == null) {
                this.f19541c = new ByteArrayInputStream(new byte[0]);
                this.f19542d = 0L;
            } else {
                this.f19541c = inputStream;
                this.f19542d = j10;
            }
            this.f19546h = this.f19542d < 0;
            this.f19548j = true;
        }

        public String b(String str) {
            return (String) this.f19544f.get(str.toLowerCase());
        }

        public String c() {
            return this.f19540b;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InputStream inputStream = this.f19541c;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public boolean e() {
            return HTTP.CLOSE.equals(b("connection"));
        }

        public void f(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
        }

        public void m(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f19539a == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new d(this.f19540b).c())), false);
                printWriter.append("HTTP/1.1 ").append((CharSequence) this.f19539a.getDescription()).append(" \r\n");
                String str = this.f19540b;
                if (str != null) {
                    f(printWriter, "Content-Type", str);
                }
                if (b("date") == null) {
                    f(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry entry : this.f19543e.entrySet()) {
                    f(printWriter, (String) entry.getKey(), (String) entry.getValue());
                }
                if (b("connection") == null) {
                    f(printWriter, "Connection", this.f19548j ? "keep-alive" : HTTP.CLOSE);
                }
                if (b("content-length") != null) {
                    this.f19547i = false;
                }
                if (this.f19547i) {
                    f(printWriter, "Content-Encoding", "gzip");
                    v(true);
                }
                long j10 = this.f19541c != null ? this.f19542d : 0L;
                if (this.f19545g != l.HEAD && this.f19546h) {
                    f(printWriter, "Transfer-Encoding", "chunked");
                } else if (!this.f19547i) {
                    j10 = u(printWriter, j10);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                s(outputStream, j10);
                outputStream.flush();
                a.o(this.f19541c);
            } catch (IOException e10) {
                a.f19481k.log(Level.SEVERE, "Could not send response to the client", (Throwable) e10);
            }
        }

        public final void n(OutputStream outputStream, long j10) {
            byte[] bArr = new byte[(int) 16384];
            boolean z10 = j10 == -1;
            while (true) {
                if (j10 <= 0 && !z10) {
                    return;
                }
                int read = this.f19541c.read(bArr, 0, (int) (z10 ? 16384L : Math.min(j10, 16384L)));
                if (read <= 0) {
                    return;
                }
                outputStream.write(bArr, 0, read);
                if (!z10) {
                    j10 -= read;
                }
            }
        }

        public final void q(OutputStream outputStream, long j10) {
            if (!this.f19547i) {
                n(outputStream, j10);
                return;
            }
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            n(gZIPOutputStream, -1L);
            gZIPOutputStream.finish();
        }

        public final void s(OutputStream outputStream, long j10) {
            if (this.f19545g == l.HEAD || !this.f19546h) {
                q(outputStream, j10);
                return;
            }
            b bVar = new b(outputStream);
            q(bVar, -1L);
            bVar.a();
        }

        public long u(PrintWriter printWriter, long j10) {
            String b10 = b("content-length");
            if (b10 != null) {
                try {
                    j10 = Long.parseLong(b10);
                } catch (NumberFormatException unused) {
                    a.f19481k.severe("content-length was no number " + b10);
                }
            }
            printWriter.print("Content-Length: " + j10 + "\r\n");
            return j10;
        }

        public void v(boolean z10) {
            this.f19546h = z10;
        }

        public void x(boolean z10) {
            this.f19547i = z10;
        }

        public void y(boolean z10) {
            this.f19548j = z10;
        }

        public void z(l lVar) {
            this.f19545g = lVar;
        }
    }

    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f19577a;

        /* renamed from: b, reason: collision with root package name */
        public IOException f19578b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19579c = false;

        public o(int i10) {
            this.f19577a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.f19484c.bind(a.this.f19482a != null ? new InetSocketAddress(a.this.f19482a, a.this.f19483b) : new InetSocketAddress(a.this.f19483b));
                this.f19579c = true;
                do {
                    try {
                        Socket accept = a.this.f19484c.accept();
                        int i10 = this.f19577a;
                        if (i10 > 0) {
                            accept.setSoTimeout(i10);
                        }
                        InputStream inputStream = accept.getInputStream();
                        a aVar = a.this;
                        aVar.f19487f.a(aVar.g(accept, inputStream));
                    } catch (IOException e10) {
                        a.f19481k.log(Level.FINE, "Communication with the client broken", (Throwable) e10);
                    }
                } while (!a.this.f19484c.isClosed());
            } catch (IOException e11) {
                this.f19578b = e11;
            }
        }
    }

    public interface p {
        ServerSocket create();
    }

    public interface q {
        void clear();
    }

    public interface r {
        q create();
    }

    public a(int i10) {
        this(null, i10);
    }

    public static String i(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e10) {
            f19481k.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e10);
            return null;
        }
    }

    public static m l(String str) {
        return n(m.d.OK, com.hpplay.a.a.a.d.MIME_HTML, str);
    }

    public static m m(m.c cVar, String str, InputStream inputStream, long j10) {
        return new m(cVar, str, inputStream, j10);
    }

    public static m n(m.c cVar, String str, String str2) {
        byte[] bArr;
        d dVar = new d(str);
        if (str2 == null) {
            return m(cVar, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(dVar.c()).newEncoder().canEncode(str2)) {
                dVar = dVar.d();
            }
            bArr = str2.getBytes(dVar.c());
        } catch (UnsupportedEncodingException e10) {
            f19481k.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e10);
            bArr = new byte[0];
        }
        return m(cVar, dVar.a(), new ByteArrayInputStream(bArr), bArr.length);
    }

    public static final void o(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e10) {
                f19481k.log(Level.SEVERE, "Could not close", (Throwable) e10);
            }
        }
    }

    public c g(Socket socket, InputStream inputStream) {
        return new c(inputStream, socket);
    }

    public o h(int i10) {
        return new o(i10);
    }

    public final int j() {
        if (this.f19484c == null) {
            return -1;
        }
        return this.f19484c.getLocalPort();
    }

    public p k() {
        return this.f19485d;
    }

    public abstract m p(k kVar);

    public void q(b bVar) {
        this.f19487f = bVar;
    }

    public void r(r rVar) {
        this.f19488g = rVar;
    }

    public void s(int i10, boolean z10) {
        this.f19484c = k().create();
        this.f19484c.setReuseAddress(true);
        o h10 = h(i10);
        Thread thread = new Thread(h10);
        this.f19486e = thread;
        thread.setDaemon(z10);
        this.f19486e.setName("NanoHttpd Main Listener");
        this.f19486e.start();
        while (!h10.f19579c && h10.f19578b == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        if (h10.f19578b != null) {
            throw h10.f19578b;
        }
    }

    public boolean t(m mVar) {
        return mVar.c() != null && (mVar.c().toLowerCase().contains("text/") || mVar.c().toLowerCase().contains("/json"));
    }

    public static final class n extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final m.d f19576a;

        public n(m.d dVar, String str) {
            super(str);
            this.f19576a = dVar;
        }

        public m.d a() {
            return this.f19576a;
        }

        public n(m.d dVar, String str, Exception exc) {
            super(str, exc);
            this.f19576a = dVar;
        }
    }

    public a(String str, int i10) {
        this.f19485d = new g();
        this.f19482a = str;
        this.f19483b = i10;
        r(new i());
        q(new f());
    }
}
