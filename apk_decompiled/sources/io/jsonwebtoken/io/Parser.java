package io.jsonwebtoken.io;

import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes3.dex */
public interface Parser<T> {
    T parse(InputStream inputStream);

    T parse(Reader reader);

    T parse(CharSequence charSequence);

    T parse(CharSequence charSequence, int i10, int i11);
}
