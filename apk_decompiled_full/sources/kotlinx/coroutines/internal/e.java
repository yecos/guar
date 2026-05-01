package kotlinx.coroutines.internal;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public final class e implements ca.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final k9.f f15736a;

    public e(k9.f fVar) {
        this.f15736a = fVar;
    }

    @Override // ca.c0
    public k9.f d() {
        return this.f15736a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + d() + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
