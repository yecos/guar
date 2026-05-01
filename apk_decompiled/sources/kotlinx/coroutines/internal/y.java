package kotlinx.coroutines.internal;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f15779a;

    public y(String str) {
        this.f15779a = str;
    }

    public String toString() {
        return ASCIIPropertyListParser.DATA_BEGIN_TOKEN + this.f15779a + ASCIIPropertyListParser.DATA_END_TOKEN;
    }
}
