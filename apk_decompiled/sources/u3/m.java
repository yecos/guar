package u3;

import com.google.android.gms.common.Scopes;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes.dex */
public enum m {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL(Scopes.EMAIL),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE("phone"),
    REGEX("regex"),
    STYLE("style"),
    TIME(AgooConstants.MESSAGE_TIME),
    URI("uri"),
    UTC_MILLISEC("utc-millisec"),
    UUID("uuid");


    /* renamed from: a, reason: collision with root package name */
    public final String f19048a;

    m(String str) {
        this.f19048a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f19048a;
    }
}
