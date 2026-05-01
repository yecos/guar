package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import java.util.Map;

/* loaded from: classes.dex */
class EngineKeyFactory {
    public EngineKey buildKey(Object obj, Key key, int i10, int i11, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        return new EngineKey(obj, key, i10, i11, map, cls, cls2, options);
    }
}
