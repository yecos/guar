package f9;

import com.google.common.collect.ImmutableList;
import f9.e;
import java.util.List;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class f {
    public static List a(e.g gVar) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (gVar.f13362e != null) {
            builder.add((ImmutableList.Builder) new e.k(gVar));
        }
        if (gVar.f13363f != null) {
            builder.add((ImmutableList.Builder) new e.f(gVar));
        }
        return builder.build();
    }
}
