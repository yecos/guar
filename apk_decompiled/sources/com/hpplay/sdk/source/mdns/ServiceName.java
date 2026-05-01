package com.hpplay.sdk.source.mdns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import java.io.PrintStream;
import java.lang.reflect.Field;

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
        /*
            r0 = 5
            byte[] r1 = new byte[r0]
            r1 = {x00b0: FILL_ARRAY_DATA , data: [4, 95, 115, 117, 98} // fill-array
            com.hpplay.sdk.source.mdns.ServiceName.SUB_SERVICE_INDICATOR = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 3
            byte[][] r3 = new byte[r2][]
            byte[] r4 = new byte[r0]
            r4 = {x00b8: FILL_ARRAY_DATA , data: [4, 95, 116, 99, 112} // fill-array
            r5 = 0
            r3[r5] = r4
            byte[] r0 = new byte[r0]
            r0 = {x00c0: FILL_ARRAY_DATA , data: [4, 95, 117, 100, 112} // fill-array
            r4 = 1
            r3[r4] = r0
            r0 = 6
            byte[] r0 = new byte[r0]
            r0 = {x00c8: FILL_ARRAY_DATA , data: [5, 95, 115, 99, 116, 112} // fill-array
            r6 = 2
            r3[r6] = r0
            r0 = 0
        L2a:
            if (r0 >= r2) goto L34
            r6 = r3[r0]
            r1.add(r6)
            int r0 = r0 + 1
            goto L2a
        L34:
            java.lang.Class<com.hpplay.sdk.source.mdns.ServiceName> r0 = com.hpplay.sdk.source.mdns.ServiceName.class
            java.lang.String r2 = "ServiceName.protocol"
            java.net.URL r0 = r0.getResource(r2)
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            java.io.InputStream r7 = r0.openStream()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L71
        L4b:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            if (r2 == 0) goto L69
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            byte[] r2 = r2.getBytes()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            int r6 = r2.length     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            int r6 = r6 + r4
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            int r7 = r2.length     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            byte r7 = (byte) r7     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            r6[r5] = r7     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            int r7 = r2.length     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            java.lang.System.arraycopy(r2, r5, r6, r4, r7)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            r1.add(r6)     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> La6
            goto L4b
        L69:
            r3.close()     // Catch: java.io.IOException -> L97
            goto L97
        L6d:
            r2 = move-exception
            goto L75
        L6f:
            r0 = move-exception
            goto La8
        L71:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
        L75:
            java.util.logging.Logger r4 = java.util.logging.Logger.getAnonymousLogger()     // Catch: java.lang.Throwable -> La6
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r6.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r7 = "Could not find Protocols file \""
            r6.append(r7)     // Catch: java.lang.Throwable -> La6
            r6.append(r0)     // Catch: java.lang.Throwable -> La6
            java.lang.String r0 = "\""
            r6.append(r0)     // Catch: java.lang.Throwable -> La6
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> La6
            r4.log(r5, r0, r2)     // Catch: java.lang.Throwable -> La6
            if (r3 == 0) goto L97
            goto L69
        L97:
            int r0 = r1.size()
            byte[][] r0 = new byte[r0][]
            java.lang.Object[] r0 = r1.toArray(r0)
            byte[][] r0 = (byte[][]) r0
            com.hpplay.sdk.source.mdns.ServiceName.PROTOCOLS = r0
            return
        La6:
            r0 = move-exception
            r2 = r3
        La8:
            if (r2 == 0) goto Lad
            r2.close()     // Catch: java.io.IOException -> Lad
        Lad:
            goto Laf
        Lae:
            throw r0
        Laf:
            goto Lae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.ServiceName.<clinit>():void");
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
