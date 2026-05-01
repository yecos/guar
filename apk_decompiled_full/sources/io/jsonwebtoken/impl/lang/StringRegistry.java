package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class StringRegistry<V> extends DefaultRegistry<String, V> {
    private final Function<String, String> CASE_FN;
    private final Map<String, V> CI_VALUES;

    public static final class CaseInsensitiveFunction implements Function<String, String> {
        private static final CaseInsensitiveFunction ENGLISH = new CaseInsensitiveFunction(Locale.ENGLISH);
        private final Locale LOCALE;

        private CaseInsensitiveFunction(Locale locale) {
            this.LOCALE = (Locale) Assert.notNull(locale, "Case insensitive Locale argument cannot be null.");
        }

        @Override // io.jsonwebtoken.impl.lang.Function
        public String apply(String str) {
            return ((String) Assert.notNull(Strings.clean(str), "String identifier cannot be null or empty.")).toUpperCase(this.LOCALE);
        }
    }

    public StringRegistry(String str, String str2, Collection<V> collection, Function<V, String> function, boolean z10) {
        this(str, str2, collection, function, (Function<String, String>) (z10 ? Functions.identity() : CaseInsensitiveFunction.ENGLISH));
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public V get(Object obj) {
        String str = (String) obj;
        Assert.hasText(str, "id argument cannot be null or empty.");
        V v10 = (V) super.get(str);
        if (v10 != null) {
            return v10;
        }
        return this.CI_VALUES.get(this.CASE_FN.apply(str));
    }

    public StringRegistry(String str, String str2, Collection<V> collection, Function<V, String> function, Function<String, String> function2) {
        super(str, str2, collection, function);
        this.CASE_FN = (Function) Assert.notNull(function2, "Case function cannot be null.");
        LinkedHashMap linkedHashMap = new LinkedHashMap(values().size());
        for (V v10 : collection) {
            linkedHashMap.put(this.CASE_FN.apply(function.apply(v10)), v10);
        }
        this.CI_VALUES = Collections.immutable(linkedHashMap);
    }
}
