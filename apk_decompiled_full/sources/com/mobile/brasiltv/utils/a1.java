package com.mobile.brasiltv.utils;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.event.SubTitleDownloadFinishEvent;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a1 {

    /* renamed from: a, reason: collision with root package name */
    public int f8610a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f8611b = 0;

    /* renamed from: c, reason: collision with root package name */
    public ka.b f8612c = new ka.b("", new b());

    public class a implements Observer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8613a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f8614b;

        public a(String str, File file) {
            this.f8613a = str;
            this.f8614b = file;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a1.this.f8610a++;
            if (a1.this.f8610a == a1.this.f8611b) {
                xa.c.c().j(new SubTitleDownloadFinishEvent(this.f8613a));
            }
            ma.p.a("DownSubTitle", "total:" + a1.this.f8611b + ",index:" + a1.this.f8610a + "," + this.f8614b.getName() + " download completed!");
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a1.this.f8610a++;
            if (a1.this.f8610a == a1.this.f8611b) {
                xa.c.c().j(new SubTitleDownloadFinishEvent(this.f8613a));
            }
            ma.p.a("DownSubTitle", this.f8614b.getName() + " download error!" + th.getMessage());
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            ma.p.a("DownSubTitle", "download next!");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public class b implements ka.d {
        public b() {
        }

        @Override // ka.d
        public void a() {
            ma.p.a("SubtitleDownloadUtil", "onFinishDownload");
        }

        @Override // ka.d
        public void b(int i10) {
            ma.p.a("SubtitleDownloadUtil", "onProgress progress= " + i10);
        }

        @Override // ka.d
        public void c(Exception exc) {
            ma.p.a("SubtitleDownloadUtil", "onFail " + exc.getMessage());
        }

        @Override // ka.d
        public void d(long j10) {
            ma.p.a("SubtitleDownloadUtil", "onStartDownload length = " + j10);
        }
    }

    public void d(String str, List list) {
        this.f8611b = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubTitleData subTitleData = (SubTitleData) it.next();
            String filePath = subTitleData.getFilePath();
            String subUrl = subTitleData.getSubUrl();
            if (!TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(subUrl)) {
                File file = new File(filePath);
                if (!file.exists()) {
                    e(file, subUrl, str);
                } else if (file.length() == 0 || file.isDirectory()) {
                    ma.p.a("DownSubTitle", "file don't download finish, delete it.");
                    if (file.delete()) {
                        e(file, subUrl, str);
                    } else {
                        ma.p.a("DownSubTitle", "delete file occur error.");
                    }
                } else {
                    String b10 = ma.m.b(file);
                    String md5 = subTitleData.getMd5();
                    ma.p.a("DownSubTitle", "md5:" + md5 + ",fileMd5:" + b10);
                    if (TextUtils.isEmpty(b10) || !TextUtils.equals(md5, b10)) {
                        ma.p.a("DownSubTitle", "file ms5 isn't match, delete it.");
                        if (file.delete()) {
                            e(file, subUrl, str);
                        } else {
                            ma.p.a("DownSubTitle", "delete file occur error.");
                        }
                    } else {
                        ma.p.a("DownSubTitle", "file exists");
                        int i10 = this.f8610a + 1;
                        this.f8610a = i10;
                        if (i10 == this.f8611b) {
                            xa.c.c().j(new SubTitleDownloadFinishEvent(str));
                        }
                    }
                }
            }
        }
    }

    public final void e(File file, String str, String str2) {
        if (file.mkdirs()) {
            this.f8612c.b(str, file, new a(str2, file));
        }
    }
}
