package j7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.content.FileProvider;
import com.mobile.autoupdate.R$string;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: j7.a$a, reason: collision with other inner class name */
    public class C0240a implements Observer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14695a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f14696b;

        public C0240a(String str, File file) {
            this.f14695a = str;
            this.f14696b = file;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(d5.b bVar) {
            h.d((a.d(this.f14695a) ? "externalStorage_" : "internalStorage_") + ((String) bVar.b()), this.f14696b.length(), (String) bVar.a());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    public class b implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f14697a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14698b;

        public b(File file, String str) {
            this.f14697a = file;
            this.f14698b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d5.b call() {
            String b10 = d.b(this.f14697a);
            if (b10 == null || b10.isEmpty()) {
                b10 = "apkMd5 is empty";
            }
            String str = this.f14698b;
            if (str == null || str.trim().isEmpty()) {
                str = "pathMd5 is empty";
            }
            return new d5.b(b10, str);
        }
    }

    public static Long b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Long.valueOf(Long.valueOf(statFs.getAvailableBlocksLong()).longValue() * Long.valueOf(statFs.getBlockSizeLong()).longValue());
    }

    public static void c(Context context, String str) {
        Long b10 = b();
        File file = new File(str);
        if (b10.longValue() < file.length()) {
            g.a(context, context.getString(R$string.insufficient_disk_space), 0);
        }
        e(file, str);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            Uri e10 = FileProvider.e(context, context.getPackageName() + ".fileprovider", file);
            intent.setFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(e10, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        if (f(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static boolean d(String str) {
        return str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public static void e(File file, String str) {
        Observable.fromCallable(new b(file, str)).compose(f.a()).subscribe(new C0240a(str, file));
    }

    public static boolean f(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null || packageManager.resolveActivity(intent, 0) == null) ? false : true;
    }
}
