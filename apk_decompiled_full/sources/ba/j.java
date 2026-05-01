package ba;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public abstract class j {
    public static final g d(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new h(matcher, charSequence);
        }
        return null;
    }

    public static final y9.c e(MatchResult matchResult) {
        return y9.e.f(matchResult.start(), matchResult.end());
    }

    public static final y9.c f(MatchResult matchResult, int i10) {
        return y9.e.f(matchResult.start(i10), matchResult.end(i10));
    }
}
