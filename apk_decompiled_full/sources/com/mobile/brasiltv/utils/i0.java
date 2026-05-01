package com.mobile.brasiltv.utils;

import android.text.TextWatcher;
import android.widget.EditText;
import com.umeng.analytics.pro.bt;

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
    */
    public final void a(EditText editText, TextWatcher textWatcher, String str) {
        t9.i.g(editText, "phoneEt");
        t9.i.g(textWatcher, "watcher");
        t9.i.g(str, bt.O);
        String j10 = ba.s.j(ba.s.j(ba.s.j(ba.t.W(editText.getText().toString()).toString(), " ", "", false, 4, null), "(", "", false, 4, null), ")", "", false, 4, null);
        editText.removeTextChangedListener(textWatcher);
        int hashCode = str.hashCode();
        if (hashCode != -771733562) {
            if (hashCode != 1997815692) {
                if (hashCode == 2011108078) {
                }
            } else if (str.equals("Brazil")) {
                if (j10.length() == 3) {
                    StringBuilder sb = new StringBuilder();
                    String substring = j10.substring(0, 2);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append(' ');
                    sb.append(j10.charAt(2));
                    editText.setText(sb.toString());
                    editText.setSelection(4);
                } else if (j10.length() < 3) {
                    editText.setText(j10);
                    editText.setSelection(j10.length());
                }
            }
        }
        editText.addTextChangedListener(textWatcher);
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
    */
    public final String b(EditText editText, String str) {
        t9.i.g(editText, "phoneEt");
        t9.i.g(str, bt.O);
        String j10 = ba.s.j(ba.s.j(ba.s.j(ba.t.W(editText.getText().toString()).toString(), " ", "", false, 4, null), "(", "", false, 4, null), ")", "", false, 4, null);
        int hashCode = str.hashCode();
        if (hashCode != -771733562) {
            if (hashCode != 1997815692) {
                if (hashCode == 2011108078) {
                }
            } else if (str.equals("Brazil") && j10.length() <= 3) {
                return "";
            }
            return j10;
        }
    }
}
