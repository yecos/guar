package d8;

import t9.g;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f12726a;

    /* renamed from: b, reason: collision with root package name */
    public int f12727b;

    /* renamed from: c, reason: collision with root package name */
    public int f12728c;

    public d(int i10, int i11, int i12) {
        this.f12726a = i10;
        this.f12727b = i11;
        this.f12728c = i12;
    }

    public final int a() {
        return this.f12727b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.f12726a == dVar.f12726a) {
                    if (this.f12727b == dVar.f12727b) {
                        if (this.f12728c == dVar.f12728c) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f12726a * 31) + this.f12727b) * 31) + this.f12728c;
    }

    public String toString() {
        return "SelectedTracks(videoTrack=" + this.f12726a + ", audioTrack=" + this.f12727b + ", subtitleTrack=" + this.f12728c + ")";
    }

    public /* synthetic */ d(int i10, int i11, int i12, int i13, g gVar) {
        this((i13 & 1) != 0 ? -1 : i10, (i13 & 2) != 0 ? -1 : i11, (i13 & 4) != 0 ? -1 : i12);
    }
}
