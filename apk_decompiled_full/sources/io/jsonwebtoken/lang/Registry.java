package io.jsonwebtoken.lang;

import java.util.Map;

/* loaded from: classes3.dex */
public interface Registry<K, V> extends Map<K, V> {
    V forKey(K k10);
}
