package com.titans.entity;

import t9.i;

/* loaded from: classes3.dex */
public final class CdnType {
    public static final String DIGITAL_TYPE_AWS = "4";
    public static final String DIGITAL_TYPE_ICDN = "1";
    public static final String DIGITAL_TYPE_PCDN = "5";
    public static final String DIGITAL_TYPE_PEERSTAR = "6";
    public static final String DIGITAL_TYPE_QINIU = "3";
    public static final String DIGITAL_TYPE_WANGSU = "2";
    public static final CdnType INSTANCE = new CdnType();
    public static final String TYPE_AWS = "aws";
    public static final String TYPE_ICDN = "icdn";
    public static final String TYPE_PCDN = "pcdn";
    public static final String TYPE_PEERSTAR = "peerstar";
    public static final String TYPE_QINIU = "qiniu";
    public static final String TYPE_WANGSU = "wangsu";

    private CdnType() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String transform(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "cdnDigital"
            t9.i.g(r2, r0)
            int r0 = r2.hashCode()
            switch(r0) {
                case 49: goto L3d;
                case 50: goto L31;
                case 51: goto L25;
                case 52: goto Lc;
                case 53: goto L19;
                case 54: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L49
        Ld:
            java.lang.String r0 = "6"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L16
            goto L49
        L16:
            java.lang.String r2 = "peerstar"
            goto L4b
        L19:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L22
            goto L49
        L22:
            java.lang.String r2 = "pcdn"
            goto L4b
        L25:
            java.lang.String r0 = "3"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L2e
            goto L49
        L2e:
            java.lang.String r2 = "qiniu"
            goto L4b
        L31:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3a
            goto L49
        L3a:
            java.lang.String r2 = "wangsu"
            goto L4b
        L3d:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L46
            goto L49
        L46:
            java.lang.String r2 = "icdn"
            goto L4b
        L49:
            java.lang.String r2 = "aws"
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titans.entity.CdnType.transform(java.lang.String):java.lang.String");
    }

    public final String transformOnDetectNull(String str) {
        i.g(str, "cdnDigital");
        return str.length() == 0 ? "lslb" : transform(str);
    }
}
