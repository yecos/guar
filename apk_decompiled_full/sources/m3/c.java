package m3;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final int f16634c = e.values().length;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f16636b = new b[f16634c];

    /* renamed from: a, reason: collision with root package name */
    public Boolean f16635a = Boolean.FALSE;

    public b a(e eVar) {
        return this.f16636b[eVar.ordinal()];
    }

    public Boolean b() {
        return this.f16635a;
    }
}
