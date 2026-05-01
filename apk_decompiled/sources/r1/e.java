package r1;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import t9.i;

/* loaded from: classes.dex */
public abstract class e {
    public static final GlideUrl a(String str) {
        i.g(str, "<this>");
        return new GlideUrl(str, new LazyHeaders.Builder().addHeader("ReqSource", "own").build());
    }
}
