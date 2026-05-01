package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public final class Section {
    public static final int ADDITIONAL = 3;
    public static final int ANSWER = 1;
    public static final int AUTHORITY = 2;
    public static final int PREREQ = 1;
    public static final int QUESTION = 0;
    public static final int UPDATE = 2;
    public static final int ZONE = 0;
    private static String[] longSections;
    private static Mnemonic sections;
    private static String[] updateSections;

    static {
        Mnemonic mnemonic = new Mnemonic("Message Section", 3);
        sections = mnemonic;
        longSections = new String[4];
        updateSections = new String[4];
        mnemonic.setMaximum(3);
        sections.setNumericAllowed(true);
        sections.add(0, "qd");
        sections.add(1, "an");
        sections.add(2, "au");
        sections.add(3, "ad");
        String[] strArr = longSections;
        strArr[0] = "QUESTIONS";
        strArr[1] = "ANSWERS";
        strArr[2] = "AUTHORITY RECORDS";
        strArr[3] = "ADDITIONAL RECORDS";
        String[] strArr2 = updateSections;
        strArr2[0] = "ZONE";
        strArr2[1] = "PREREQUISITES";
        strArr2[2] = "UPDATE RECORDS";
        strArr2[3] = "ADDITIONAL RECORDS";
    }

    private Section() {
    }

    public static String longString(int i10) {
        sections.check(i10);
        return longSections[i10];
    }

    public static String string(int i10) {
        return sections.getText(i10);
    }

    public static String updString(int i10) {
        sections.check(i10);
        return updateSections[i10];
    }

    public static int value(String str) {
        return sections.getValue(str);
    }
}
