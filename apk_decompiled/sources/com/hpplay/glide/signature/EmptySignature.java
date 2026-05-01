package com.hpplay.glide.signature;

import com.hpplay.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class EmptySignature implements Key {
    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    @Override // com.hpplay.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
