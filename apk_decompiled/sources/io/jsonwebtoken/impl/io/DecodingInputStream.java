package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.lang.Assert;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class DecodingInputStream extends FilteredInputStream {
    private final String codecName;
    private final String name;

    public DecodingInputStream(InputStream inputStream, String str, String str2) {
        super(inputStream);
        this.codecName = (String) Assert.hasText(str, "codecName cannot be null or empty.");
        this.name = (String) Assert.hasText(str2, "Name cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.impl.io.FilteredInputStream
    public void onThrowable(Throwable th) {
        throw new DecodingException("Unable to " + this.codecName + "-decode " + this.name + ": " + th.getMessage(), th);
    }
}
