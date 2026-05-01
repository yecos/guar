package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public class FileLockUtil {
    private final Object lockObject = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static FileLock getFileLock(String str) {
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "rw").getChannel();
        } catch (FileNotFoundException e10) {
            e = e10;
            fileChannel = null;
        } catch (IOException e11) {
            e = e11;
            fileChannel = null;
        }
        try {
            return fileChannel.lock();
        } catch (FileNotFoundException e12) {
            e = e12;
            e.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return null;
        } catch (IOException e14) {
            e = e14;
            e.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName(), obj);
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e11) {
                                e = e11;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e12) {
                            e = e12;
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i10) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file, i10);
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e11) {
                                e = e11;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e12) {
                            e = e12;
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e10) {
                                e = e10;
                                e.printStackTrace();
                            }
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e12) {
                                e = e12;
                                e.printStackTrace();
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
