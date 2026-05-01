package r1;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class g implements Key {

    /* renamed from: a, reason: collision with root package name */
    public final String f18327a;

    /* renamed from: b, reason: collision with root package name */
    public final Key f18328b;

    public g(String str, Key key) {
        this.f18327a = str;
        this.f18328b = key;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f18327a.equals(gVar.f18327a) && this.f18328b.equals(gVar.f18328b);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.f18327a.hashCode() * 31) + this.f18328b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f18327a.getBytes(Key.CHARSET));
        this.f18328b.updateDiskCacheKey(messageDigest);
    }
}
