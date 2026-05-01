package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class FormattedStringFunction<T> implements Function<T, String> {
    private final String msg;

    public FormattedStringFunction(String str) {
        this.msg = (String) Assert.hasText(str, "msg argument cannot be null or empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.jsonwebtoken.impl.lang.Function
    public /* bridge */ /* synthetic */ String apply(Object obj) {
        return apply2((FormattedStringFunction<T>) obj);
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    /* renamed from: apply, reason: avoid collision after fix types in other method */
    public String apply2(T t10) {
        return String.format(this.msg, t10);
    }
}
