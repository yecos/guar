package com.hpplay.common.asyncmanager;

import java.io.File;

/* loaded from: classes2.dex */
public class FileRequest {
    public static final int TASKDONWLOADED = 1;
    public static final int TASKDONWLOADING = 0;
    public static final int TASKDOWNLOADCANCEL = 3;
    public static final int TASKDOWNLOADERROR = 2;
    private DownloadListener mDownloadListener;
    private int mDownloadPercent;
    private String mLocalPath;
    private long mTotalSize;
    private String mURL;
    private final String TAG = "FileRequest";
    private long mDownloadedSize = 0;
    private int mTaskCode = 0;
    private boolean isShutDown = false;
    private final String cacheName = ".cache";

    public interface DownloadListener {
        void onDownLoad(int i10, long j10, long j11, int i11);
    }

    public FileRequest(String str, String str2) {
        this.mLocalPath = str2;
        this.mURL = str;
    }

    private boolean renameToNewFile(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0275 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean download() {
        /*
            Method dump skipped, instructions count: 683
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.FileRequest.download():boolean");
    }

    public void makeDownLoadError() {
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onDownLoad(this.mTaskCode, this.mDownloadedSize, this.mTotalSize, 2);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public void setTaskCode(int i10) {
        this.mTaskCode = i10;
    }

    public void shutDown() {
        this.isShutDown = true;
    }
}
