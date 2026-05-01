package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class SlbInfo {
    private int dead_time_addr;
    private int error_code;
    private String main_slb_addr;
    private String main_slb_token;
    private int rst_status;
    private String spared_slb_addr;
    private String spared_slb_token;

    public SlbInfo(String str, String str2, int i10, String str3, String str4, int i11, int i12) {
        i.g(str, "main_slb_addr");
        i.g(str2, "spared_slb_addr");
        i.g(str3, "main_slb_token");
        i.g(str4, "spared_slb_token");
        this.main_slb_addr = str;
        this.spared_slb_addr = str2;
        this.dead_time_addr = i10;
        this.main_slb_token = str3;
        this.spared_slb_token = str4;
        this.rst_status = i11;
        this.error_code = i12;
    }

    public static /* synthetic */ SlbInfo copy$default(SlbInfo slbInfo, String str, String str2, int i10, String str3, String str4, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = slbInfo.main_slb_addr;
        }
        if ((i13 & 2) != 0) {
            str2 = slbInfo.spared_slb_addr;
        }
        String str5 = str2;
        if ((i13 & 4) != 0) {
            i10 = slbInfo.dead_time_addr;
        }
        int i14 = i10;
        if ((i13 & 8) != 0) {
            str3 = slbInfo.main_slb_token;
        }
        String str6 = str3;
        if ((i13 & 16) != 0) {
            str4 = slbInfo.spared_slb_token;
        }
        String str7 = str4;
        if ((i13 & 32) != 0) {
            i11 = slbInfo.rst_status;
        }
        int i15 = i11;
        if ((i13 & 64) != 0) {
            i12 = slbInfo.error_code;
        }
        return slbInfo.copy(str, str5, i14, str6, str7, i15, i12);
    }

    public final String component1() {
        return this.main_slb_addr;
    }

    public final String component2() {
        return this.spared_slb_addr;
    }

    public final int component3() {
        return this.dead_time_addr;
    }

    public final String component4() {
        return this.main_slb_token;
    }

    public final String component5() {
        return this.spared_slb_token;
    }

    public final int component6() {
        return this.rst_status;
    }

    public final int component7() {
        return this.error_code;
    }

    public final SlbInfo copy(String str, String str2, int i10, String str3, String str4, int i11, int i12) {
        i.g(str, "main_slb_addr");
        i.g(str2, "spared_slb_addr");
        i.g(str3, "main_slb_token");
        i.g(str4, "spared_slb_token");
        return new SlbInfo(str, str2, i10, str3, str4, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlbInfo)) {
            return false;
        }
        SlbInfo slbInfo = (SlbInfo) obj;
        return i.b(this.main_slb_addr, slbInfo.main_slb_addr) && i.b(this.spared_slb_addr, slbInfo.spared_slb_addr) && this.dead_time_addr == slbInfo.dead_time_addr && i.b(this.main_slb_token, slbInfo.main_slb_token) && i.b(this.spared_slb_token, slbInfo.spared_slb_token) && this.rst_status == slbInfo.rst_status && this.error_code == slbInfo.error_code;
    }

    public final int getDead_time_addr() {
        return this.dead_time_addr;
    }

    public final int getError_code() {
        return this.error_code;
    }

    public final String getMain_slb_addr() {
        return this.main_slb_addr;
    }

    public final String getMain_slb_token() {
        return this.main_slb_token;
    }

    public final int getRst_status() {
        return this.rst_status;
    }

    public final String getSpared_slb_addr() {
        return this.spared_slb_addr;
    }

    public final String getSpared_slb_token() {
        return this.spared_slb_token;
    }

    public int hashCode() {
        return (((((((((((this.main_slb_addr.hashCode() * 31) + this.spared_slb_addr.hashCode()) * 31) + this.dead_time_addr) * 31) + this.main_slb_token.hashCode()) * 31) + this.spared_slb_token.hashCode()) * 31) + this.rst_status) * 31) + this.error_code;
    }

    public final void setDead_time_addr(int i10) {
        this.dead_time_addr = i10;
    }

    public final void setError_code(int i10) {
        this.error_code = i10;
    }

    public final void setMain_slb_addr(String str) {
        i.g(str, "<set-?>");
        this.main_slb_addr = str;
    }

    public final void setMain_slb_token(String str) {
        i.g(str, "<set-?>");
        this.main_slb_token = str;
    }

    public final void setRst_status(int i10) {
        this.rst_status = i10;
    }

    public final void setSpared_slb_addr(String str) {
        i.g(str, "<set-?>");
        this.spared_slb_addr = str;
    }

    public final void setSpared_slb_token(String str) {
        i.g(str, "<set-?>");
        this.spared_slb_token = str;
    }

    public String toString() {
        return "SlbInfo(main_slb_addr=" + this.main_slb_addr + ", spared_slb_addr=" + this.spared_slb_addr + ", dead_time_addr=" + this.dead_time_addr + ", main_slb_token=" + this.main_slb_token + ", spared_slb_token=" + this.spared_slb_token + ", rst_status=" + this.rst_status + ", error_code=" + this.error_code + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
