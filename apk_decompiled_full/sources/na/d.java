package na;

import android.text.TextUtils;
import com.hpplay.component.protocol.ProtocolBuilder;

/* loaded from: classes3.dex */
public abstract class d {
    public static boolean a(String str) {
        return TextUtils.equals(str, "aaa100010") || TextUtils.equals(str, "aaa100011") || TextUtils.equals(str, "aaa100040") || TextUtils.equals(str, "aaa100042") || TextUtils.equals(str, "aaa100044") || TextUtils.equals(str, "aaa100055") || TextUtils.equals(str, "aaa100041") || TextUtils.equals(str, "aaa100045") || TextUtils.equals(str, "aaa100039") || TextUtils.equals(str, "aaa100074");
    }

    public static String b(String str) {
        return a(str) ? "EA1" : h(str) ? "EA2" : TextUtils.equals(str, "aaa100017") ? "EA3" : TextUtils.equals(str, "aaa100018") ? "EA4" : TextUtils.equals(str, "aaa100050") ? "EA5" : i(str) ? "EA6" : (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50012") || TextUtils.equals(str, "50011")) ? "EA7" : TextUtils.equals(str, "50014") ? "EA9" : TextUtils.equals(str, "portal100040") ? "EA10" : TextUtils.equals(str, "portal100024") ? "EA11" : TextUtils.equals(str, "portal200001") ? "EA17" : TextUtils.equals(str, "portal100055") ? "EA19" : TextUtils.equals(str, "aaa100075") ? "EA24" : TextUtils.equals(str, "aaa100078") ? "EA27" : "no_report_type";
    }

    public static String c(String str) {
        return (TextUtils.equals(str, "portal100022") || TextUtils.equals(str, "portal100023")) ? "EB1" : (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50012") || TextUtils.equals(str, "50011")) ? "EB2" : i(str) ? "EB3" : "no_report_type";
    }

    public static String d(String str) {
        return (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50011") || TextUtils.equals(str, "25100") || TextUtils.equals(str, "50012")) ? "EC1" : TextUtils.equals(str, "400") ? "EC2" : TextUtils.equals(str, ProtocolBuilder.LELINK_STATE_SCREENCODE) ? "EC4" : TextUtils.equals(str, "500") ? "EC3" : TextUtils.equals(str, "503") ? "EC4" : (TextUtils.equals(str, "EC5") || TextUtils.equals(str, "20900")) ? "EC5" : TextUtils.equals(str, "32600") ? "EC25" : TextUtils.equals(str, "25500") ? "EC13" : TextUtils.equals(str, "20700") ? "EC3" : TextUtils.equals(str, "20800") ? "EC4" : TextUtils.equals(str, "20600") ? "EC2" : "no_report_type";
    }

    public static String e(String str) {
        return TextUtils.equals(str, "CUSTOM_NO_ASSOCIATED_PORTAL") ? "ED2" : TextUtils.equals(str, "1") ? "ED3" : TextUtils.equals(str, "portal100041") ? "ED4" : TextUtils.equals(str, "portal100042") ? "ED5" : TextUtils.equals(str, "portal100043") ? "ED6" : TextUtils.equals(str, "aaa100048") ? "ED7" : "no_report_type";
    }

    public static String f(String str) {
        return (TextUtils.equals(str, "aaa100027") || TextUtils.equals(str, "aaa100028") || TextUtils.equals(str, "aaa100029") || TextUtils.equals(str, "aaa100030")) ? "EE2" : "no_report_type";
    }

    public static String g(String str) {
        return TextUtils.equals(str, "portal100054") ? "EF1" : TextUtils.equals(str, "portal100057") ? "EF2" : TextUtils.equals(str, "portal100028") ? "EF3" : TextUtils.equals(str, "portal100058") ? "EF4" : TextUtils.equals(str, "portal100059") ? "EF5" : TextUtils.equals(str, "aaa100076") ? "EF6" : TextUtils.equals(str, "aaa100077") ? "EF7" : TextUtils.equals(str, "aaa100079") ? "EF8" : TextUtils.equals(str, "aaa100080") ? "EF9" : TextUtils.equals(str, "aaa100022") ? "EF11" : (TextUtils.equals(str, "aaa100003") || TextUtils.equals(str, "portal100067")) ? "EF12" : TextUtils.equals(str, "aaa100082") ? "EF13" : TextUtils.equals(str, "portal100064") ? "EF16" : TextUtils.equals(str, "portal100065") ? "EF17" : TextUtils.equals(str, "aaa100090") ? "EF18" : TextUtils.equals(str, "portal100066") ? "EF19" : TextUtils.equals(str, "portal100068") ? "EF20" : TextUtils.equals(str, "aaa100081") ? "EF21" : "no_report_type";
    }

    public static boolean h(String str) {
        return TextUtils.equals(str, "aaa100019") || TextUtils.equals(str, "aaa100004");
    }

    public static boolean i(String str) {
        return TextUtils.equals(str, "800") || TextUtils.equals(str, "1000") || TextUtils.equals(str, "500") || TextUtils.equals(str, "1") || TextUtils.equals(str, "portal100000");
    }
}
