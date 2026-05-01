package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class CustomerService {
    private final String appId;

    public CustomerService(String str) {
        i.g(str, "appId");
        this.appId = str;
    }

    public static /* synthetic */ CustomerService copy$default(CustomerService customerService, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = customerService.appId;
        }
        return customerService.copy(str);
    }

    public final String component1() {
        return this.appId;
    }

    public final CustomerService copy(String str) {
        i.g(str, "appId");
        return new CustomerService(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerService) && i.b(this.appId, ((CustomerService) obj).appId);
    }

    public final String getAppId() {
        return this.appId;
    }

    public int hashCode() {
        return this.appId.hashCode();
    }

    public String toString() {
        return "CustomerService(appId=" + this.appId + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
