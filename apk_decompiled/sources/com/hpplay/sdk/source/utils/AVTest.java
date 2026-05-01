package com.hpplay.sdk.source.utils;

import com.hpplay.sdk.source.log.SourceLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class AVTest {
    private final String TAG = "AudioTest";
    private boolean isStop = false;
    private OutputStream mAudioStream;

    private void init() {
        File file = new File("sdcard/000.pcm");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (Exception e10) {
            SourceLog.w("AudioTest", e10);
        }
        try {
            this.mAudioStream = new FileOutputStream(file);
        } catch (Exception e11) {
            SourceLog.w("AudioTest", e11);
        }
    }

    public void stop() {
        OutputStream outputStream = this.mAudioStream;
        if (outputStream == null) {
            return;
        }
        this.isStop = true;
        try {
            outputStream.flush();
            this.mAudioStream.close();
            this.mAudioStream = null;
        } catch (Exception e10) {
            SourceLog.w("AudioTest", e10);
        }
    }

    public void writeAudio(byte[] bArr) {
        if (this.isStop) {
            return;
        }
        if (this.mAudioStream == null) {
            init();
        }
        OutputStream outputStream = this.mAudioStream;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.write(bArr);
        } catch (Exception e10) {
            SourceLog.w("AudioTest", e10);
        }
    }
}
