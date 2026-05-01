package com.hpplay.glide.signature;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class StringSignature implements Key {
    private final String signature;

    public StringSignature(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.signature = str;
    }

    @Override // com.hpplay.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.signature.equals(((StringSignature) obj).signature);
    }

    @Override // com.hpplay.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.signature + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    @Override // com.hpplay.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
