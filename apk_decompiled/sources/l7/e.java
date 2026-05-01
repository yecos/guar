package l7;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import l7.e;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16260a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final String f16261b = "ExternalSubtitles";

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList f16262c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static SimpleDateFormat f16263d = new SimpleDateFormat("HH:mm:ss,SSS", Locale.getDefault());

    /* renamed from: e, reason: collision with root package name */
    public static long f16264e;

    /* renamed from: f, reason: collision with root package name */
    public static Disposable f16265f;

    /* renamed from: g, reason: collision with root package name */
    public static Disposable f16266g;

    public static final class a {

        /* renamed from: l7.e$a$a, reason: collision with other inner class name */
        public static final class C0282a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextView f16267a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f16268b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0282a(TextView textView, long j10) {
                super(1);
                this.f16267a = textView;
                this.f16268b = j10;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                e.f16260a.j(this.f16267a, this.f16268b);
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16269a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f16269a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                e.f16260a.h(this.f16269a);
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static final void k(TextView textView) {
            i.g(textView, "$textView");
            textView.bringToFront();
            if (textView.getVisibility() == 0) {
                textView.setVisibility(4);
                textView.setText("");
            }
        }

        public static final void l(TextView textView, f fVar) {
            i.g(textView, "$textView");
            i.g(fVar, "$srt");
            textView.bringToFront();
            textView.setVisibility(0);
            textView.setText(Html.fromHtml(fVar.a()));
            String unused = e.f16261b;
            fVar.a();
        }

        public static final void n(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void p(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public final void f() {
            Disposable disposable = e.f16265f;
            if (disposable != null) {
                disposable.dispose();
            }
            e.f16262c.clear();
            Disposable disposable2 = e.f16266g;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            e.f16265f = null;
            e.f16266g = null;
        }

        public final String g(String str) {
            String str2;
            str2 = "UTF-8";
            FileInputStream fileInputStream = null;
            try {
                try {
                    byte[] bArr = new byte[4096];
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        try {
                            za.c cVar = new za.c(null);
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read <= 0 || cVar.d()) {
                                    break;
                                }
                                cVar.c(bArr, 0, read);
                            }
                            cVar.a();
                            String b10 = cVar.b();
                            i.f(b10, "detector.detectedCharset");
                            try {
                                str2 = TextUtils.isEmpty(b10) ? "UTF-8" : b10;
                                cVar.e();
                                fileInputStream2.close();
                            } catch (Exception e10) {
                                e = e10;
                                str2 = b10;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e12) {
                e = e12;
            }
            return str2;
        }

        public final synchronized void h(String str) {
            try {
                e.f16262c.clear();
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), g(str)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            i.f(readLine, "it.readLine() ?: break");
                            if (i.b(readLine, "")) {
                                List M = ba.t.M(stringBuffer, new String[]{"@"}, false, 0, 6, null);
                                if (M.size() < 4) {
                                    stringBuffer.delete(0, stringBuffer.length());
                                } else {
                                    f fVar = new f();
                                    fVar.f((String) M.get(0));
                                    List M2 = ba.t.M(ba.t.W((String) M.get(1)).toString(), new String[]{"-->"}, false, 0, 6, null);
                                    if (M2.size() == 2) {
                                        fVar.g(e.f16263d.parse((String) M2.get(0)).getTime() - e.f16263d.parse("00:00:00,000").getTime());
                                        fVar.e(e.f16263d.parse((String) M2.get(1)).getTime() - e.f16263d.parse("00:00:00,000").getTime());
                                    }
                                    StringBuffer stringBuffer2 = new StringBuffer();
                                    Iterator it = M.subList(2, M.size() - 1).iterator();
                                    while (it.hasNext()) {
                                        stringBuffer2.append((String) it.next());
                                        stringBuffer2.append("<br>");
                                    }
                                    String str2 = "";
                                    if (ba.t.o(stringBuffer2, "<br>", false, 2, null)) {
                                        str2 = stringBuffer2.substring(0, stringBuffer2.length() - 4);
                                        i.f(str2, "content.substring(0, con…t.length - \"<br>\".length)");
                                    }
                                    fVar.d(str2);
                                    stringBuffer.delete(0, stringBuffer.length());
                                    e.f16262c.add(fVar);
                                }
                            } else {
                                stringBuffer.append(readLine);
                                stringBuffer.append("@");
                            }
                        } finally {
                        }
                    }
                    t tVar = t.f14242a;
                    q9.a.a(bufferedReader, null);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public final int i(long j10) {
            int size = e.f16262c.size() - 1;
            if (size == 0) {
                return -1;
            }
            int i10 = 0;
            while (i10 <= size) {
                int i11 = (i10 + size) / 2;
                if (j10 < ((f) e.f16262c.get(i11)).c()) {
                    size = i11 - 1;
                } else {
                    if (j10 <= ((f) e.f16262c.get(i11)).b()) {
                        return i11;
                    }
                    i10 = i11 + 1;
                }
            }
            return -1;
        }

        public final synchronized void j(final TextView textView, long j10) {
            i.g(textView, "textView");
            if (e.f16264e == j10) {
                return;
            }
            e.f16264e = j10;
            String unused = e.f16261b;
            StringBuilder sb = new StringBuilder();
            sb.append("position: ");
            sb.append(j10);
            sb.append(", size: ");
            sb.append(e.f16262c.size());
            int i10 = i(j10);
            String unused2 = e.f16261b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("searchPos: ");
            sb2.append(i10);
            if (i10 == -1) {
                textView.post(new Runnable() { // from class: l7.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.k(textView);
                    }
                });
            } else {
                Object obj = e.f16262c.get(i10);
                i.f(obj, "subtitleList[searchPos]");
                final f fVar = (f) obj;
                textView.post(new Runnable() { // from class: l7.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.l(textView, fVar);
                    }
                });
            }
        }

        public final void m(TextView textView, long j10) {
            Disposable disposable;
            i.g(textView, "textView");
            Disposable disposable2 = e.f16266g;
            boolean z10 = false;
            if (disposable2 != null && !disposable2.isDisposed()) {
                z10 = true;
            }
            if (z10 && (disposable = e.f16266g) != null) {
                disposable.dispose();
            }
            Observable subscribeOn = Observable.just("").subscribeOn(Schedulers.io());
            final C0282a c0282a = new C0282a(textView, j10);
            e.f16266g = subscribeOn.subscribe(new Consumer() { // from class: l7.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    e.a.n(l.this, obj);
                }
            });
        }

        public final void o(String str) {
            i.g(str, "path");
            f();
            if (TextUtils.isEmpty(str)) {
                Log.e(e.f16261b, "sub path is NULL...");
                return;
            }
            Observable subscribeOn = Observable.just("").subscribeOn(Schedulers.io());
            final b bVar = new b(str);
            e.f16265f = subscribeOn.subscribe(new Consumer() { // from class: l7.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    e.a.p(l.this, obj);
                }
            });
        }
    }

    public static final void j() {
        f16260a.f();
    }

    public static final void k(TextView textView, long j10) {
        f16260a.m(textView, j10);
    }

    public static final void l(String str) {
        f16260a.o(str);
    }
}
