package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.EncodingException;
import io.jsonwebtoken.lang.Assert;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class EncodingOutputStream extends FilteredOutputStream {
    private final String codecName;
    private final String name;

    public EncodingOutputStream(OutputStream outputStream, String str, String str2) {
        super(outputStream);
        this.codecName = (String) Assert.hasText(str, "codecName cannot be null or empty.");
        this.name = (String) Assert.hasText(str2, "name cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.impl.io.FilteredOutputStream
    public void onThrowable(Throwable th) {
        throw new EncodingException("Unable to " + this.codecName + "-encode " + this.name + ": " + th.getMessage(), th);
    }
}
