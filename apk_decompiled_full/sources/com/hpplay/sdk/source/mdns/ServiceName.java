package com.hpplay.sdk.source.mdns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class ServiceName extends Name {
    private static final byte[][] PROTOCOLS;
    private static final byte[] SUB_SERVICE_INDICATOR = {4, 95, 115, 117, 98};
    private static final long serialVersionUID = 201305151047L;
    private String application;
    private String domain;
    private String fullSubType;
    private String fullType;
    private String instance;
    private String protocol;
    private final Name serviceRRName;
    private final Name serviceTypeName;
    private String subType;
    private String type;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
    
        if (r3 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        BufferedReader bufferedReader;
        Exception e10;
        ArrayList arrayList = new ArrayList();
        byte[][] bArr = {new byte[]{4, 95, 116, 99, 112}, new byte[]{4, 95, 117, 100, 112}, new byte[]{5, 95, 115, 99, 116, 112}};
        for (int i10 = 0; i10 < 3; i10++) {
            arrayList.add(bArr[i10]);
        }
        URL resource = ServiceName.class.getResource("ServiceName.protocol");
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(resource.openStream()));
        } catch (Exception e11) {
            bufferedReader = null;
            e10 = e11;
        } catch (Throwable th) {
            th = th;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        byte[] bytes = readLine.trim().getBytes();
                        byte[] bArr2 = new byte[bytes.length + 1];
                        bArr2[0] = (byte) bytes.length;
                        System.arraycopy(bytes, 0, bArr2, 1, bytes.length);
                        arrayList.add(bArr2);
                    }
                } catch (Exception e12) {
                    e10 = e12;
                    Logger.getAnonymousLogger().log(Level.FINE, "Could not find Protocols file \"" + resource + "\"", (Throwable) e10);
                }
                try {
                    break;
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        }
        bufferedReader.close();
        PROTOCOLS = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
    }

    public ServiceName(String str) {
        this(new Name(str));
    }

    private static final boolean arrayEquals(byte[] bArr, byte[] bArr2, short s10) {
        short s11 = bArr2[s10];
        if (s11 != bArr[0] || bArr2.length <= s10 + s11) {
            return false;
        }
        for (int i10 = 1; i10 < s11; i10++) {
            if (bArr[i10] != bArr2[s10 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... strArr) {
        Name name = new Name(strArr.length > 0 ? strArr[0] : "Steve Posick's Work MacBook Pro._test._sub._syncmate._tcp.local.");
        ServiceName serviceName = new ServiceName(name);
        System.out.println("Service Name = " + serviceName);
        System.out.println("Instance: " + serviceName.instance);
        System.out.println("Full Type: " + serviceName.fullType);
        System.out.println("Sub Type: " + serviceName.subType);
        System.out.println("Type: " + serviceName.type);
        System.out.println("Application: " + serviceName.application);
        System.out.println("Protocol: " + serviceName.protocol);
        System.out.println("Domain: " + serviceName.domain);
        long nanoTime = System.nanoTime();
        for (int i10 = 0; i10 < 100000; i10++) {
            new ServiceName(name);
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Took ");
        double d10 = nanoTime2;
        Double.isNaN(d10);
        sb.append(d10 / 1000000.0d);
        sb.append(" milliseconds to parse ");
        sb.append(100000);
        sb.append(" service names at ");
        long j10 = nanoTime2 / 100000;
        double d11 = j10;
        Double.isNaN(d11);
        sb.append(d11 / 1000000.0d);
        sb.append(" millis / ");
        sb.append(j10);
        sb.append(" nanoseconds each name");
        printStream.println(sb.toString());
    }

    public String getApplication() {
        return this.application;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getFullSubType() {
        return this.fullSubType;
    }

    public String getFullType() {
        return this.fullType;
    }

    public String getInstance() {
        return this.instance;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Name getServiceRRName() {
        return this.serviceRRName;
    }

    public Name getServiceTypeName() {
        return this.serviceTypeName;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public ServiceName(String str, Name name) {
        this(new Name(str, name));
    }

    public ServiceName(Name name) {
        super(name, 0);
        byte[] bArr;
        try {
            Field declaredField = Name.class.getDeclaredField("name");
            declaredField.setAccessible(true);
            bArr = (byte[]) declaredField.get(name);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException unused) {
            bArr = null;
        }
        int labels = name.labels();
        if (bArr == null) {
            bArr = new byte[name.length()];
            int i10 = 0;
            for (int i11 = 0; i11 < labels; i11++) {
                byte[] label = name.getLabel(i11);
                System.arraycopy(label, 0, bArr, i10, label[0] + 1);
                i10 += label[0] + 1;
            }
        }
        short[] sArr = new short[labels];
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = 0;
        int i16 = 0;
        short s10 = 0;
        while (i15 < labels) {
            sArr[i15] = s10;
            byte b10 = bArr[s10];
            short s11 = (short) (((short) (b10 & UnsignedBytes.MAX_VALUE)) + s10 + 1);
            if (b10 > 0 && bArr[s10 + 1] == 95) {
                i12 = i12 < 0 ? i15 : i12;
                if (i13 < 0 && arrayEquals(SUB_SERVICE_INDICATOR, bArr, s10)) {
                    i13 = i15;
                }
                i16++;
                i14 = i15;
            }
            i15++;
            s10 = s11;
        }
        if (i16 > 0) {
            StringBuilder sb = new StringBuilder();
            if (i12 > 0) {
                for (int i17 = 0; i17 < i12; i17++) {
                    short s12 = sArr[i17];
                    byte b11 = bArr[s12];
                    if (b11 > 0) {
                        sb.append(new String(bArr, s12 + 1, (int) b11));
                        sb.append('.');
                    }
                }
                this.instance = sb.substring(0, sb.length() - 1);
                sb.setLength(0);
            }
            while (true) {
                if (i12 > i14) {
                    break;
                }
                short s13 = sArr[i12];
                byte b12 = bArr[s13];
                if (b12 > 0) {
                    String str = new String(bArr, s13 + 1, (int) b12);
                    if (i12 < i13) {
                        sb.append(str);
                    } else if (i12 == i13) {
                        this.subType = sb.substring(0, sb.length() - 1);
                        sb.append(str);
                        this.fullSubType = sb.toString();
                    } else if (i12 == i14) {
                        sb.append(str);
                        byte[][] bArr2 = PROTOCOLS;
                        int length = bArr2.length;
                        int i18 = 0;
                        while (true) {
                            if (i18 >= length) {
                                break;
                            }
                            if (arrayEquals(bArr2[i18], bArr, sArr[i12])) {
                                this.protocol = str;
                                break;
                            }
                            i18++;
                        }
                    } else {
                        sb.append(str);
                    }
                    sb.append('.');
                }
                i12++;
            }
            String str2 = this.fullSubType;
            if (str2 != null) {
                this.type = sb.substring(str2.length() + 1, sb.length());
                this.fullType = sb.toString();
                if (this.protocol != null) {
                    this.application = sb.substring(this.fullSubType.length() + 1, (sb.length() - this.protocol.length()) - 1);
                } else {
                    this.application = this.type;
                }
            } else {
                String sb2 = sb.toString();
                this.fullType = sb2;
                this.type = sb2;
                if (this.protocol != null) {
                    this.application = sb.substring(0, (sb.length() - this.protocol.length()) - 1);
                } else {
                    this.application = sb2;
                }
            }
            sb.setLength(0);
            for (int i19 = i14 + 1; i19 < labels; i19++) {
                short s14 = sArr[i19];
                byte b13 = bArr[s14];
                if (b13 > 0) {
                    sb.append(new String(bArr, s14 + 1, (int) b13));
                    sb.append('.');
                }
            }
            this.domain = sb.substring(0, sb.length());
            sb.setLength(0);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.type);
            sb3.append(this.domain != null ? "." + this.domain : "");
            Name name2 = new Name(sb3.toString());
            this.serviceTypeName = name2;
            String str3 = this.instance;
            if (str3 != null && str3.length() > 0) {
                this.serviceRRName = new Name(this.instance, name2);
                return;
            } else {
                this.serviceRRName = null;
                return;
            }
        }
        throw new Exception("Name \"" + name + "\" is not an IETF RFC 2782 or IETF RFC 6763 compliant service name.");
    }
}
