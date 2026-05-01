package na;

import android.text.TextUtils;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import ma.i;

/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f17339a = "000000000000";

    /* renamed from: b, reason: collision with root package name */
    public static String f17340b = "000000000000";

    public static String a() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address) && !"127.0.0.1".equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public static void b(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                try {
                    String trim = readLine.trim();
                    if (trim.length() >= 63 && !trim.toUpperCase(Locale.US).contains("IP")) {
                        String trim2 = trim.substring(0, 17).trim();
                        trim.substring(29, 32).trim();
                        String trim3 = trim.substring(41, 63).trim();
                        if (!trim3.contains("00:00:00:00:00:00") && !TextUtils.isEmpty(trim3) && ((!TextUtils.isEmpty(str) && str.equals(trim2)) || (!TextUtils.isEmpty(str2) && str2.equals(trim2)))) {
                            f17339a = trim3.replaceAll(SOAP.DELIM, "");
                            c();
                            break;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            bufferedReader.close();
        } catch (Exception unused2) {
        }
    }

    public static void c() {
        f17340b = i.e(f17339a, "combrasiltvaslgklxckbcombrasiltv");
    }

    public static void d() {
        String a10 = a();
        if (a10 != null) {
            String[] split = a10.split("\\.");
            if (split.length >= 4) {
                split[3] = "1";
                String str = split[0] + "." + split[1] + "." + split[2] + "." + split[3];
                split[3] = "254";
                b(str, split[0] + "." + split[1] + "." + split[2] + "." + split[3]);
            }
        }
    }
}
