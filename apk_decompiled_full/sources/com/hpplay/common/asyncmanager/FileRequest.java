package com.hpplay.common.asyncmanager;

import com.hpplay.common.log.LeLog;
import com.hpplay.common.utils.CertUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

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
    */
    public boolean download() {
        Throwable th;
        URL url;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        boolean z10;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mLocalPath);
        String str2 = ".cache";
        sb.append(".cache");
        File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
            this.mDownloadedSize = 0L;
        } else {
            this.mDownloadedSize = 0L;
        }
        File file2 = new File(this.mLocalPath);
        if (file2.exists()) {
            file2.delete();
        }
        LeLog.i("FileRequest", "mURL, " + this.mURL + " downloadedSize, " + this.mDownloadedSize);
        HttpURLConnection httpURLConnection2 = null;
        r2 = null;
        InputStream inputStream2 = null;
        HttpURLConnection httpURLConnection3 = null;
        int i10 = 0;
        try {
            try {
                url = new URL(this.mURL);
                httpURLConnection = CertUtils.getHttpURLConnection(url);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            this.mTotalSize = httpURLConnection.getContentLength();
            LeLog.i("FileRequest", "totalSize, " + this.mTotalSize);
            long j10 = this.mTotalSize;
            if (j10 == 0) {
                makeDownLoadError();
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e11) {
                    LeLog.w("FileRequest", e11);
                }
                return false;
            }
            long j11 = this.mDownloadedSize;
            int i11 = 1;
            if (j11 == j10) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e12) {
                    LeLog.w("FileRequest", e12);
                }
                return true;
            }
            if (j11 > j10 && !file.delete()) {
                makeDownLoadError();
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e13) {
                    LeLog.w("FileRequest", e13);
                }
                return false;
            }
            httpURLConnection.disconnect();
            try {
                httpURLConnection.disconnect();
            } catch (Exception e14) {
                LeLog.w("FileRequest", e14);
            }
            try {
                httpURLConnection = CertUtils.getHttpURLConnection(url);
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT, "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
                httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.REFERER, this.mURL);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Range", "bytes=" + this.mDownloadedSize + Operator.Operation.MINUS);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setConnectTimeout(30000);
                InputStream inputStream3 = httpURLConnection.getInputStream();
                try {
                    randomAccessFile = new RandomAccessFile(new File(this.mLocalPath + ".cache"), "rwd");
                    try {
                        randomAccessFile.seek(this.mDownloadedSize);
                        int i12 = 1024;
                        int i13 = (((int) this.mTotalSize) / 1024) / 100;
                        byte[] bArr = new byte[1024];
                        int i14 = 0;
                        while (true) {
                            int read = inputStream3.read(bArr, i10, i12);
                            if (read == -1 || this.isShutDown) {
                                break;
                            }
                            randomAccessFile.write(bArr, i10, read);
                            i14 += i11;
                            if (i14 == i13) {
                                inputStream = inputStream3;
                                try {
                                    long j12 = this.mDownloadedSize;
                                    str = str2;
                                    long j13 = this.mTotalSize;
                                    if (j12 < j13) {
                                        this.mDownloadPercent = (int) ((100 * j12) / j13);
                                        DownloadListener downloadListener = this.mDownloadListener;
                                        if (downloadListener != null) {
                                            downloadListener.onDownLoad(this.mTaskCode, j12, j13, 0);
                                        }
                                        i14 = 0;
                                    }
                                } catch (Exception e15) {
                                    e = e15;
                                    inputStream2 = inputStream;
                                    try {
                                        LeLog.w("FileRequest", e);
                                        LeLog.i("FileRequest", e.toString());
                                        makeDownLoadError();
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e16) {
                                                LeLog.w("FileRequest", e16);
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception e17) {
                                                LeLog.w("FileRequest", e17);
                                            }
                                        }
                                        if (randomAccessFile != null) {
                                            try {
                                                randomAccessFile.close();
                                            } catch (Exception e18) {
                                                LeLog.w("FileRequest", e18);
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e19) {
                                                LeLog.w("FileRequest", e19);
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            try {
                                                httpURLConnection.disconnect();
                                            } catch (Exception e20) {
                                                LeLog.w("FileRequest", e20);
                                            }
                                        }
                                        if (randomAccessFile != null) {
                                            throw th2;
                                        }
                                        try {
                                            randomAccessFile.close();
                                            throw th2;
                                        } catch (Exception e21) {
                                            LeLog.w("FileRequest", e21);
                                            throw th2;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    th2 = th;
                                    inputStream2 = inputStream;
                                    if (inputStream2 != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (randomAccessFile != null) {
                                    }
                                }
                            } else {
                                str = str2;
                                inputStream = inputStream3;
                            }
                            this.mDownloadedSize += read;
                            inputStream3 = inputStream;
                            str2 = str;
                            i12 = 1024;
                            i10 = 0;
                            i11 = 1;
                        }
                        String str3 = str2;
                        InputStream inputStream4 = inputStream3;
                        if (this.isShutDown) {
                            DownloadListener downloadListener2 = this.mDownloadListener;
                            if (downloadListener2 != null) {
                                int i15 = this.mTaskCode;
                                long j14 = this.mTotalSize;
                                downloadListener2.onDownLoad(i15, j14, j14, 3);
                            }
                            z10 = false;
                        } else {
                            long j15 = this.mDownloadedSize;
                            long j16 = this.mTotalSize;
                            if (j15 >= j16 && j15 > 0 && j16 > 0) {
                                renameToNewFile(this.mLocalPath + str3, this.mLocalPath);
                            }
                            DownloadListener downloadListener3 = this.mDownloadListener;
                            if (downloadListener3 != null) {
                                int i16 = this.mTaskCode;
                                long j17 = this.mTotalSize;
                                downloadListener3.onDownLoad(i16, j17, j17, 1);
                            }
                            z10 = true;
                        }
                        try {
                            inputStream4.close();
                        } catch (Exception e22) {
                            LeLog.w("FileRequest", e22);
                        }
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e23) {
                            LeLog.w("FileRequest", e23);
                        }
                        try {
                            randomAccessFile.close();
                            return z10;
                        } catch (Exception e24) {
                            LeLog.w("FileRequest", e24);
                            return z10;
                        }
                    } catch (Exception e25) {
                        e = e25;
                        inputStream = inputStream3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStream3;
                    }
                } catch (Exception e26) {
                    e = e26;
                    inputStream = inputStream3;
                    randomAccessFile = null;
                } catch (Throwable th7) {
                    inputStream = inputStream3;
                    th2 = th7;
                    randomAccessFile = null;
                }
            } catch (Exception e27) {
                e = e27;
                randomAccessFile = null;
            } catch (Throwable th8) {
                th2 = th8;
                randomAccessFile = null;
            }
        } catch (Exception e28) {
            e = e28;
            httpURLConnection2 = httpURLConnection;
            LeLog.w("FileRequest", e);
            makeDownLoadError();
            if (httpURLConnection2 == null) {
                return false;
            }
            try {
                httpURLConnection2.disconnect();
                return false;
            } catch (Exception e29) {
                LeLog.w("FileRequest", e29);
                return false;
            }
        } catch (Throwable th9) {
            th = th9;
            httpURLConnection3 = httpURLConnection;
            if (httpURLConnection3 == null) {
                throw th;
            }
            try {
                httpURLConnection3.disconnect();
                throw th;
            } catch (Exception e30) {
                LeLog.w("FileRequest", e30);
                throw th;
            }
        }
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
