package j3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes.dex */
public class n implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final char f14668a;

    /* renamed from: b, reason: collision with root package name */
    public final char f14669b;

    /* renamed from: c, reason: collision with root package name */
    public final char f14670c;

    public n() {
        this(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN, ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
    }

    public static n a() {
        return new n();
    }

    public char b() {
        return this.f14670c;
    }

    public char c() {
        return this.f14669b;
    }

    public char d() {
        return this.f14668a;
    }

    public n(char c10, char c11, char c12) {
        this.f14668a = c10;
        this.f14669b = c11;
        this.f14670c = c12;
    }
}
