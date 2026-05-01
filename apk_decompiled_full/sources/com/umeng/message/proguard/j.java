package com.umeng.message.proguard;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static final j f12101b = new j();

    /* renamed from: a, reason: collision with root package name */
    private final Vector<String> f12102a = new Vector<>();

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final UMessage f12103a;

        /* renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f12104b;

        /* renamed from: c, reason: collision with root package name */
        private final int f12105c;

        public a(UMessage uMessage) {
            this.f12103a = uMessage;
            ArrayList<String> arrayList = new ArrayList<>();
            this.f12104b = arrayList;
            if (uMessage.isLargeIconFromInternet()) {
                arrayList.add(uMessage.getLargeIconUrl());
            }
            if (uMessage.isSoundFromInternet()) {
                arrayList.add(uMessage.getSoundUri());
            }
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                arrayList.add(uMessage.getBarImageUrl());
            }
            if (uMessage.hasBackgroundImage()) {
                arrayList.add(uMessage.getBackgroundImageUrl());
            }
            if (!TextUtils.isEmpty(uMessage.getBigImage())) {
                arrayList.add(uMessage.getBigImage());
            }
            this.f12105c = 3;
        }

        private static boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Application a10 = y.a();
                File file = new File(f.g(a10), UMUtils.MD5(str));
                File file2 = new File(f.g(a10), UMUtils.MD5(str) + ".tmp");
                if (file.exists()) {
                    f.a((Closeable) null);
                    f.a((Closeable) null);
                    return true;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                InputStream openStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = openStream.read(bArr);
                            if (read <= 0) {
                                file2.renameTo(file);
                                f.a(openStream);
                                f.a(fileOutputStream);
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        inputStream = openStream;
                        e = e;
                        try {
                            UPLog.e("DownloadResource", e);
                            f.a(inputStream);
                            f.a(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            f.a(inputStream);
                            f.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openStream;
                        th = th;
                        f.a(inputStream);
                        f.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                j.a(f.g(y.a()));
                int i10 = 0;
                boolean z10 = true;
                do {
                    i10++;
                    Iterator<String> it = this.f12104b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        boolean a10 = a(next);
                        if (!a10) {
                            UPLog.i("DownloadResource", "download fail:", next);
                        }
                        z10 &= a10;
                    }
                    if (z10) {
                        break;
                    }
                } while (i10 < this.f12105c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            j.a().f12102a.remove(this.f12103a.getMsgId());
            Application a11 = y.a();
            UPushMessageHandler messageHandler = PushAgent.getInstance(a11).getMessageHandler();
            if (messageHandler != null) {
                messageHandler.handleMessage(a11, this.f12103a);
            }
        }
    }

    public static j a() {
        return f12101b;
    }

    public final boolean a(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("body")) != null && stringExtra.length() != 0) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                if (this.f12102a.contains(uMessage.getMsgId())) {
                    return true;
                }
                this.f12102a.add(uMessage.getMsgId());
                b.c(new a(uMessage));
                return true;
            } catch (Throwable th) {
                UPLog.e("DownloadResource", th);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(File file) {
        try {
            if (file.exists()) {
                long j10 = 0;
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        j10 = file.length();
                    } else {
                        LinkedList linkedList = new LinkedList();
                        linkedList.push(file);
                        while (!linkedList.isEmpty()) {
                            File[] listFiles = ((File) linkedList.pop()).listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (file2.isDirectory()) {
                                        linkedList.push(file2);
                                    } else {
                                        j10 += file2.length();
                                    }
                                }
                            }
                        }
                    }
                }
                if (j10 > 1048576) {
                    bm.a(file.getPath(), new FileFilter() { // from class: com.umeng.message.proguard.j.1
                        @Override // java.io.FileFilter
                        public final boolean accept(File file3) {
                            return System.currentTimeMillis() - file3.lastModified() > 86400000;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            UPLog.e("DownloadResource", th);
        }
    }
}
