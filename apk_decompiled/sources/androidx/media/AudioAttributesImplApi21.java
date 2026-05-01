package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f2644a;

    /* renamed from: b, reason: collision with root package name */
    public int f2645b;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f2646a = new AudioAttributes.Builder();

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(int i10) {
            this.f2646a.setLegacyStreamType(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl build() {
            AudioAttributes build;
            build = this.f2646a.build();
            return new AudioAttributesImplApi21(build);
        }
    }

    public AudioAttributesImplApi21() {
        this.f2645b = -1;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        equals = this.f2644a.equals(((AudioAttributesImplApi21) obj).f2644a);
        return equals;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f2644a.hashCode();
        return hashCode;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2644a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i10) {
        this.f2644a = audioAttributes;
        this.f2645b = i10;
    }
}
