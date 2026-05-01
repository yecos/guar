package com.hpplay.cybergarage.upnp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import com.hpplay.cybergarage.xml.Parser;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
public class UPnP {
    public static final int CONFIGID_UPNP_ORG_MAX = 16777215;
    public static final int DEFAULT_EXPIRED_DEVICE_EXTRA_TIME = 60;
    public static final int DEFAULT_TTL = 4;
    public static final String INMPR03 = "INMPR03";
    public static final int INMPR03_DISCOVERY_OVER_WIRELESS_COUNT = 4;
    public static final String INMPR03_VERSION = "1.0";
    public static final String NAME = "CyberLinkJava";
    public static final int SERVER_RETRY_COUNT = 100;
    private static final String TAG = "Cyber-UPnP";
    public static final int USE_IPV6_ADMINISTRATIVE_SCOPE = 5;
    public static final int USE_IPV6_GLOBAL_SCOPE = 7;
    public static final int USE_IPV6_LINK_LOCAL_SCOPE = 3;
    public static final int USE_IPV6_SITE_LOCAL_SCOPE = 6;
    public static final int USE_IPV6_SUBNET_SCOPE = 4;
    public static final int USE_LOOPBACK_ADDR = 2;
    public static final int USE_ONLY_IPV4_ADDR = 9;
    public static final int USE_ONLY_IPV6_ADDR = 1;
    public static final int USE_SSDP_SEARCHRESPONSE_MULTIPLE_INTERFACES = 8;
    public static final String VERSION = "3.0";
    public static final String XML_CLASS_PROPERTTY = "cyberlink.upnp.xml.parser";
    public static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    private static int timeToLive = 4;
    private static Parser xmlParser;

    static {
        setTimeToLive(4);
    }

    public static final int caluculateConfigId(String str) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i10 += str.codePointAt(i11);
            if (i10 >= 16777215) {
                i10 %= CONFIGID_UPNP_ORG_MAX;
            }
        }
        return i10;
    }

    public static final int createBootId() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static final String createUUID() {
        long currentTimeMillis = System.currentTimeMillis();
        double currentTimeMillis2 = System.currentTimeMillis();
        double random = Math.random();
        Double.isNaN(currentTimeMillis2);
        long j10 = (long) (currentTimeMillis2 * random);
        return toUUID((int) (currentTimeMillis & 65535)) + Operator.Operation.MINUS + toUUID(((int) ((currentTimeMillis >> 32) | 40960)) & Message.MAXLENGTH) + Operator.Operation.MINUS + toUUID((int) (65535 & j10)) + Operator.Operation.MINUS + toUUID(65535 & ((int) ((j10 >> 32) | 57344)));
    }

    public static final String getServerName() {
        return System.getProperty("os.name") + Operator.Operation.DIVISION + System.getProperty("os.version") + " UPnP/1.0 " + NAME + Operator.Operation.DIVISION + VERSION;
    }

    public static final int getTimeToLive() {
        return timeToLive;
    }

    public static final Parser getXMLParser() {
        if (xmlParser == null) {
            Parser loadDefaultXMLParser = loadDefaultXMLParser();
            xmlParser = loadDefaultXMLParser;
            if (loadDefaultXMLParser == null) {
                throw new RuntimeException("No XML parser defined. And unable to laod any. \nTry to invoke UPnP.setXMLParser before UPnP.getXMLParser");
            }
            SOAP.setXMLParser(loadDefaultXMLParser);
        }
        return xmlParser;
    }

    public static final void initialize() {
    }

    public static final boolean isEnabled(int i10) {
        if (i10 == 1) {
            return HostInterface.USE_ONLY_IPV6_ADDR;
        }
        if (i10 == 2) {
            return HostInterface.USE_LOOPBACK_ADDR;
        }
        if (i10 != 9) {
            return false;
        }
        return HostInterface.USE_ONLY_IPV4_ADDR;
    }

    private static Parser loadDefaultXMLParser() {
        String[] strArr = {System.getProperty(XML_CLASS_PROPERTTY), "com.hpplay.cybergarage.xml.parser.XmlPullParser", "com.hpplay.cybergarage.xml.parser.JaxpParser", "com.hpplay.cybergarage.xml.parser.kXML2Parser", "com.hpplay.cybergarage.xml.parser.XercesParser"};
        for (int i10 = 0; i10 < 5; i10++) {
            String str = strArr[i10];
            if (str != null) {
                try {
                    return (Parser) Class.forName(str).newInstance();
                } catch (Throwable th) {
                    CLog.d(TAG, "Unable to load " + strArr[i10] + " as XMLParser due to " + th);
                }
            }
        }
        return null;
    }

    public static final void setDisable(int i10) {
        if (i10 == 1) {
            HostInterface.USE_ONLY_IPV6_ADDR = false;
        } else if (i10 == 2) {
            HostInterface.USE_LOOPBACK_ADDR = false;
        } else {
            if (i10 != 9) {
                return;
            }
            HostInterface.USE_ONLY_IPV4_ADDR = false;
        }
    }

    public static final void setEnable(int i10) {
        switch (i10) {
            case 1:
                HostInterface.USE_ONLY_IPV6_ADDR = true;
                break;
            case 2:
                HostInterface.USE_LOOPBACK_ADDR = true;
                break;
            case 3:
                SSDP.setIPv6Address(SSDP.IPV6_LINK_LOCAL_ADDRESS);
                break;
            case 4:
                SSDP.setIPv6Address(SSDP.IPV6_SUBNET_ADDRESS);
                break;
            case 5:
                SSDP.setIPv6Address(SSDP.IPV6_ADMINISTRATIVE_ADDRESS);
                break;
            case 6:
                SSDP.setIPv6Address(SSDP.IPV6_SITE_LOCAL_ADDRESS);
                break;
            case 7:
                SSDP.setIPv6Address(SSDP.IPV6_GLOBAL_ADDRESS);
                break;
            case 9:
                HostInterface.USE_ONLY_IPV4_ADDR = true;
                break;
        }
    }

    public static final void setTimeToLive(int i10) {
        timeToLive = i10;
    }

    public static final void setXMLParser(Parser parser) {
        xmlParser = parser;
        SOAP.setXMLParser(parser);
    }

    private static final String toUUID(int i10) {
        String num = Integer.toString(i10 & Message.MAXLENGTH, 16);
        String str = "";
        for (int i11 = 0; i11 < 4 - num.length(); i11++) {
            str = str + "0";
        }
        return str + num;
    }
}
