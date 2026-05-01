package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes2.dex */
public interface IMediaDataSource {
    void close();

    long getSize();

    int readAt(long j10, byte[] bArr, int i10, int i11);
}
