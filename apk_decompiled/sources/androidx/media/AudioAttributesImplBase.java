package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f2647a;

    /* renamed from: b, reason: collision with root package name */
    public int f2648b;

    /* renamed from: c, reason: collision with root package name */
    public int f2649c;

    /* renamed from: d, reason: collision with root package name */
    public int f2650d;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a, reason: collision with root package name */
        public int f2651a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f2652b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f2653c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f2654d = -1;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final a b(int i10) {
            switch (i10) {
                case 0:
                    this.f2652b = 1;
                    break;
                case 1:
                    this.f2652b = 4;
                    break;
                case 2:
                    this.f2652b = 4;
                    break;
                case 3:
                    this.f2652b = 2;
                    break;
                case 4:
                    this.f2652b = 4;
                    break;
                case 5:
                    this.f2652b = 4;
                    break;
                case 6:
                    this.f2652b = 1;
                    this.f2653c |= 4;
                    break;
                case 7:
                    this.f2653c = 1 | this.f2653c;
                    this.f2652b = 4;
                    break;
                case 8:
                    this.f2652b = 4;
                    break;
                case 9:
                    this.f2652b = 4;
                    break;
                case 10:
                    this.f2652b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i10 + " for AudioAttributesCompat");
                    break;
            }
            this.f2651a = AudioAttributesImplBase.e(i10);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.a
        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f2652b, this.f2653c, this.f2651a, this.f2654d);
        }

        @Override // androidx.media.AudioAttributesImpl.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(int i10) {
            if (i10 == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.f2654d = i10;
            return b(i10);
        }
    }

    public AudioAttributesImplBase() {
        this.f2647a = 0;
        this.f2648b = 0;
        this.f2649c = 0;
        this.f2650d = -1;
    }

    public static int e(int i10) {
        switch (i10) {
        }
        return 2;
    }

    public int a() {
        return this.f2648b;
    }

    public int b() {
        int i10 = this.f2649c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f2650d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(false, this.f2649c, this.f2647a);
    }

    public int d() {
        return this.f2647a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f2648b == audioAttributesImplBase.a() && this.f2649c == audioAttributesImplBase.b() && this.f2647a == audioAttributesImplBase.d() && this.f2650d == audioAttributesImplBase.f2650d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2648b), Integer.valueOf(this.f2649c), Integer.valueOf(this.f2647a), Integer.valueOf(this.f2650d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2650d != -1) {
            sb.append(" stream=");
            sb.append(this.f2650d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f2647a));
        sb.append(" content=");
        sb.append(this.f2648b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2649c).toUpperCase());
        return sb.toString();
    }

    public AudioAttributesImplBase(int i10, int i11, int i12, int i13) {
        this.f2648b = i10;
        this.f2649c = i11;
        this.f2647a = i12;
        this.f2650d = i13;
    }
}
