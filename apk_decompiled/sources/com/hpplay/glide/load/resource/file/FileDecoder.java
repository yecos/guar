package com.hpplay.glide.load.resource.file;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import java.io.File;

/* loaded from: classes2.dex */
public class FileDecoder implements ResourceDecoder<File, File> {
    @Override // com.hpplay.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public Resource<File> decode(File file, int i10, int i11) {
        return new FileResource(file);
    }
}
