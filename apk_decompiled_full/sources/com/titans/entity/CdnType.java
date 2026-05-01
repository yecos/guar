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
    */
    public final String transform(String str) {
        i.g(str, "cdnDigital");
        switch (str.hashCode()) {
            case 49:
                return !str.equals("1") ? TYPE_AWS : TYPE_ICDN;
            case 50:
                if (str.equals("2")) {
                    return TYPE_WANGSU;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    return TYPE_QINIU;
                }
                break;
            case 53:
                if (str.equals(DIGITAL_TYPE_PCDN)) {
                    return TYPE_PCDN;
                }
                break;
            case 54:
                if (str.equals(DIGITAL_TYPE_PEERSTAR)) {
                    return TYPE_PEERSTAR;
                }
                break;
        }
    }

    public final String transformOnDetectNull(String str) {
        i.g(str, "cdnDigital");
        return str.length() == 0 ? "lslb" : transform(str);
    }
}
