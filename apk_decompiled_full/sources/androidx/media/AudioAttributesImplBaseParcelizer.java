package androidx.media;

import y0.b;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2647a = bVar.p(audioAttributesImplBase.f2647a, 1);
        audioAttributesImplBase.f2648b = bVar.p(audioAttributesImplBase.f2648b, 2);
        audioAttributesImplBase.f2649c = bVar.p(audioAttributesImplBase.f2649c, 3);
        audioAttributesImplBase.f2650d = bVar.p(audioAttributesImplBase.f2650d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.x(false, false);
        bVar.F(audioAttributesImplBase.f2647a, 1);
        bVar.F(audioAttributesImplBase.f2648b, 2);
        bVar.F(audioAttributesImplBase.f2649c, 3);
        bVar.F(audioAttributesImplBase.f2650d, 4);
    }
}
