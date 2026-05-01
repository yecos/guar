package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.HashMap;

/* loaded from: classes3.dex */
class Mnemonic {
    static final int CASE_LOWER = 3;
    static final int CASE_SENSITIVE = 1;
    static final int CASE_UPPER = 2;
    private static Integer[] cachedInts = new Integer[64];
    private String description;
    private boolean numericok;
    private String prefix;
    private int wordcase;
    private HashMap strings = new HashMap();
    private HashMap values = new HashMap();
    private int max = Integer.MAX_VALUE;

    static {
        int i10 = 0;
        while (true) {
            Integer[] numArr = cachedInts;
            if (i10 >= numArr.length) {
                return;
            }
            numArr[i10] = new Integer(i10);
            i10++;
        }
    }

    public Mnemonic(String str, int i10) {
        this.description = str;
        this.wordcase = i10;
    }

    private int parseNumeric(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                return -1;
            }
            if (parseInt <= this.max) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String sanitize(String str) {
        int i10 = this.wordcase;
        return i10 == 2 ? str.toUpperCase() : i10 == 3 ? str.toLowerCase() : str;
    }

    public static Integer toInteger(int i10) {
        if (i10 >= 0) {
            Integer[] numArr = cachedInts;
            if (i10 < numArr.length) {
                return numArr[i10];
            }
        }
        return new Integer(i10);
    }

    public void add(int i10, String str) {
        check(i10);
        Integer integer = toInteger(i10);
        String sanitize = sanitize(str);
        this.strings.put(sanitize, integer);
        this.values.put(integer, sanitize);
    }

    public void addAlias(int i10, String str) {
        check(i10);
        Integer integer = toInteger(i10);
        this.strings.put(sanitize(str), integer);
    }

    public void addAll(Mnemonic mnemonic) {
        if (this.wordcase == mnemonic.wordcase) {
            this.strings.putAll(mnemonic.strings);
            this.values.putAll(mnemonic.values);
        } else {
            throw new IllegalArgumentException(mnemonic.description + ": wordcases do not match");
        }
    }

    public void check(int i10) {
        if (i10 < 0 || i10 > this.max) {
            throw new IllegalArgumentException(this.description + " " + i10 + "is out of range");
        }
    }

    public String getText(int i10) {
        check(i10);
        String str = (String) this.values.get(toInteger(i10));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i10);
        if (this.prefix == null) {
            return num;
        }
        return this.prefix + num;
    }

    public int getValue(String str) {
        int parseNumeric;
        String sanitize = sanitize(str);
        Integer num = (Integer) this.strings.get(sanitize);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.prefix;
        if (str2 != null && sanitize.startsWith(str2) && (parseNumeric = parseNumeric(sanitize.substring(this.prefix.length()))) >= 0) {
            return parseNumeric;
        }
        if (this.numericok) {
            return parseNumeric(sanitize);
        }
        return -1;
    }

    public void setMaximum(int i10) {
        this.max = i10;
    }

    public void setNumericAllowed(boolean z10) {
        this.numericok = z10;
    }

    public void setPrefix(String str) {
        this.prefix = sanitize(str);
    }
}
