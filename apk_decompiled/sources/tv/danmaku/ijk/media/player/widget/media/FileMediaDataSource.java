package tv.danmaku.ijk.media.player.widget.media;

import java.io.File;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* loaded from: classes2.dex */
public class FileMediaDataSource implements IMediaDataSource {
    private RandomAccessFile mFile;
    private long mFileSize;

    public FileMediaDataSource(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.mFile = randomAccessFile;
        this.mFileSize = randomAccessFile.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() {
        this.mFileSize = 0L;
        RandomAccessFile randomAccessFile = this.mFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.mFile = null;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() {
        return this.mFileSize;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j10, byte[] bArr, int i10, int i11) {
        if (this.mFile.getFilePointer() != j10) {
            this.mFile.seek(j10);
        }
        if (i11 == 0) {
            return 0;
        }
        return this.mFile.read(bArr, 0, i11);
    }
}
