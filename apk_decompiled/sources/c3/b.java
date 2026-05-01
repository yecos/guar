package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5398a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f5399b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f5400c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f5401d;

    static {
        a aVar = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN, 76);
        f5398a = aVar;
        f5399b = new a(aVar, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f5400c = new a(aVar, "PEM", true, ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN, 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(Operator.Operation.PLUS), ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        sb.setCharAt(sb.indexOf(Operator.Operation.DIVISION), '_');
        f5401d = new a("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }

    public static a a() {
        return f5399b;
    }
}
