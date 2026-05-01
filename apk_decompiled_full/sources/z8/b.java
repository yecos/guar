package z8;

import com.google.common.base.MoreObjects;
import com.hpplay.component.protocol.mirror.AutoStrategy;

/* loaded from: classes3.dex */
public abstract class b extends y8.s0 {

    /* renamed from: a, reason: collision with root package name */
    public int f20295a = AutoStrategy.BITRATE_LOW;

    @Override // y8.s0
    public y8.r0 a() {
        return c().a();
    }

    public abstract y8.s0 c();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", c()).toString();
    }
}
