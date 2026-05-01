package a9;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final Logger f432a;

    /* renamed from: b, reason: collision with root package name */
    public final Level f433b;

    public enum a {
        INBOUND,
        OUTBOUND
    }

    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);


        /* renamed from: a, reason: collision with root package name */
        public final int f444a;

        b(int i10) {
            this.f444a = i10;
        }

        public int a() {
            return this.f444a;
        }
    }

    public j(Level level, Class cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public static String l(c9.i iVar) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.a())) {
                enumMap.put((EnumMap) bVar, (b) Integer.valueOf(iVar.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    public static String m(Buffer buffer) {
        if (buffer.size() <= 64) {
            return buffer.snapshot().hex();
        }
        return buffer.snapshot((int) Math.min(buffer.size(), 64L)).hex() + "...";
    }

    public final boolean a() {
        return this.f432a.isLoggable(this.f433b);
    }

    public void b(a aVar, int i10, Buffer buffer, int i11, boolean z10) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " DATA: streamId=" + i10 + " endStream=" + z10 + " length=" + i11 + " bytes=" + m(buffer));
        }
    }

    public void c(a aVar, int i10, c9.a aVar2, ByteString byteString) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " GO_AWAY: lastStreamId=" + i10 + " errorCode=" + aVar2 + " length=" + byteString.size() + " bytes=" + m(new Buffer().write(byteString)));
        }
    }

    public void d(a aVar, int i10, List list, boolean z10) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " HEADERS: streamId=" + i10 + " headers=" + list + " endStream=" + z10);
        }
    }

    public void e(a aVar, long j10) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " PING: ack=false bytes=" + j10);
        }
    }

    public void f(a aVar, long j10) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " PING: ack=true bytes=" + j10);
        }
    }

    public void g(a aVar, int i10, int i11, List list) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " PUSH_PROMISE: streamId=" + i10 + " promisedStreamId=" + i11 + " headers=" + list);
        }
    }

    public void h(a aVar, int i10, c9.a aVar2) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " RST_STREAM: streamId=" + i10 + " errorCode=" + aVar2);
        }
    }

    public void i(a aVar, c9.i iVar) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " SETTINGS: ack=false settings=" + l(iVar));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i10, long j10) {
        if (a()) {
            this.f432a.log(this.f433b, aVar + " WINDOW_UPDATE: streamId=" + i10 + " windowSizeIncrement=" + j10);
        }
    }

    public j(Level level, Logger logger) {
        this.f433b = (Level) Preconditions.checkNotNull(level, FirebaseAnalytics.Param.LEVEL);
        this.f432a = (Logger) Preconditions.checkNotNull(logger, "logger");
    }
}
