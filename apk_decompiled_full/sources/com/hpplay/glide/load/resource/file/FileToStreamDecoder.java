package com.hpplay.glide.load.resource.file;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class FileToStreamDecoder<T> implements ResourceDecoder<File, T> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final FileOpener fileOpener;
    private ResourceDecoder<InputStream, T> streamDecoder;

    public static class FileOpener {
        public InputStream open(File file) {
            return new FileInputStream(file);
        }
    }

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder) {
        this(resourceDecoder, DEFAULT_FILE_OPENER);
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder, FileOpener fileOpener) {
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public Resource<T> decode(File file, int i10, int i11) {
        InputStream inputStream = null;
        try {
            inputStream = this.fileOpener.open(file);
            Resource<T> decode = this.streamDecoder.decode(inputStream, i10, i11);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return decode;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
