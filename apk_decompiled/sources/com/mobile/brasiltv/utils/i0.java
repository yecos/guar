package com.mobile.brasiltv.utils;

/* loaded from: classes3.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f8719a = new i0();

    /* JADX WARN: Code restructure failed: missing block: B:10:0x00bd, code lost:
    
        if (r2.length() != 4) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x00bf, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append(com.hpplay.component.protocol.plist.ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        r4 = r2.substring(0, 3);
        t9.i.f(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        r1.append(r4);
        r1.append(com.hpplay.component.protocol.plist.ASCIIPropertyListParser.ARRAY_END_TOKEN);
        r1.append(r2.charAt(3));
        r17.setText(r1.toString());
        r17.setSelection(6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ef, code lost:
    
        if (r2.length() >= 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00f1, code lost:
    
        r17.setText(r2);
        r17.setSelection(r2.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b6, code lost:
    
        if (r19.equals("United States of America") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0066, code lost:
    
        if (r19.equals("Canada") == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.widget.EditText r17, android.text.TextWatcher r18, java.lang.String r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r19
            java.lang.String r2 = "phoneEt"
            t9.i.g(r0, r2)
            java.lang.String r2 = "watcher"
            r3 = r18
            t9.i.g(r3, r2)
            java.lang.String r2 = "country"
            t9.i.g(r1, r2)
            android.text.Editable r2 = r17.getText()
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = ba.t.W(r2)
            java.lang.String r4 = r2.toString()
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r10 = ba.s.j(r4, r5, r6, r7, r8, r9)
            java.lang.String r11 = "("
            java.lang.String r12 = ""
            r13 = 0
            r14 = 4
            r15 = 0
            java.lang.String r4 = ba.s.j(r10, r11, r12, r13, r14, r15)
            java.lang.String r5 = ")"
            java.lang.String r6 = ""
            java.lang.String r2 = ba.s.j(r4, r5, r6, r7, r8, r9)
            r17.removeTextChangedListener(r18)
            int r4 = r19.hashCode()
            r5 = -771733562(0xffffffffd20047c6, float:-1.3774E11)
            java.lang.String r6 = "this as java.lang.String…ing(startIndex, endIndex)"
            r7 = 0
            r8 = 4
            r9 = 3
            if (r4 == r5) goto Lb0
            r5 = 1997815692(0x77143f8c, float:3.0068313E33)
            if (r4 == r5) goto L6a
            r5 = 2011108078(0x77df12ee, float:9.048954E33)
            if (r4 == r5) goto L60
            goto Lfb
        L60:
            java.lang.String r4 = "Canada"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto Lb9
            goto Lfb
        L6a:
            java.lang.String r4 = "Brazil"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto Lfb
            int r1 = r2.length()
            if (r1 != r9) goto L9f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = 2
            java.lang.String r5 = r2.substring(r7, r4)
            t9.i.f(r5, r6)
            r1.append(r5)
            r5 = 32
            r1.append(r5)
            char r2 = r2.charAt(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            r0.setSelection(r8)
            goto Lfb
        L9f:
            int r1 = r2.length()
            if (r1 >= r9) goto Lfb
            r0.setText(r2)
            int r1 = r2.length()
            r0.setSelection(r1)
            goto Lfb
        Lb0:
            java.lang.String r4 = "United States of America"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto Lb9
            goto Lfb
        Lb9:
            int r1 = r2.length()
            if (r1 != r8) goto Leb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = 40
            r1.append(r4)
            java.lang.String r4 = r2.substring(r7, r9)
            t9.i.f(r4, r6)
            r1.append(r4)
            r4 = 41
            r1.append(r4)
            char r2 = r2.charAt(r9)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            r1 = 6
            r0.setSelection(r1)
            goto Lfb
        Leb:
            int r1 = r2.length()
            if (r1 >= r8) goto Lfb
            r0.setText(r2)
            int r1 = r2.length()
            r0.setSelection(r1)
        Lfb:
            r17.addTextChangedListener(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.i0.a(android.widget.EditText, android.text.TextWatcher, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0076, code lost:
    
        if (r13.length() > 5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0078, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r14.equals("United States of America") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0054, code lost:
    
        if (r14.equals("Canada") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.widget.EditText r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "phoneEt"
            t9.i.g(r13, r0)
            java.lang.String r0 = "country"
            t9.i.g(r14, r0)
            android.text.Editable r13 = r13.getText()
            java.lang.String r13 = r13.toString()
            java.lang.CharSequence r13 = ba.t.W(r13)
            java.lang.String r0 = r13.toString()
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r6 = ba.s.j(r0, r1, r2, r3, r4, r5)
            java.lang.String r7 = "("
            java.lang.String r8 = ""
            r9 = 0
            r10 = 4
            r11 = 0
            java.lang.String r0 = ba.s.j(r6, r7, r8, r9, r10, r11)
            java.lang.String r1 = ")"
            java.lang.String r2 = ""
            java.lang.String r13 = ba.s.j(r0, r1, r2, r3, r4, r5)
            int r0 = r14.hashCode()
            r1 = -771733562(0xffffffffd20047c6, float:-1.3774E11)
            java.lang.String r2 = ""
            if (r0 == r1) goto L68
            r1 = 1997815692(0x77143f8c, float:3.0068313E33)
            if (r0 == r1) goto L57
            r1 = 2011108078(0x77df12ee, float:9.048954E33)
            if (r0 == r1) goto L4e
            goto L79
        L4e:
            java.lang.String r0 = "Canada"
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L71
            goto L79
        L57:
            java.lang.String r0 = "Brazil"
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L60
            goto L79
        L60:
            int r14 = r13.length()
            r0 = 3
            if (r14 > r0) goto L79
            return r2
        L68:
            java.lang.String r0 = "United States of America"
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L71
            goto L79
        L71:
            int r14 = r13.length()
            r0 = 5
            if (r14 > r0) goto L79
            return r2
        L79:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.i0.b(android.widget.EditText, java.lang.String):java.lang.String");
    }
}
