package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Supplier;

/* loaded from: classes3.dex */
public class FormattedStringSupplier implements Supplier<String> {
    private final Object[] args;
    private final String msg;

    public FormattedStringSupplier(String str, Object[] objArr) {
        this.msg = (String) Assert.hasText(str, "Message cannot be null or empty.");
        this.args = Assert.notEmpty(objArr, "Arguments cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.lang.Supplier
    public String get() {
        return String.format(this.msg, this.args);
    }
}
