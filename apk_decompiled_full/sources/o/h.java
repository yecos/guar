package o;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class h extends p.a {

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f17359a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f17360b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f17361c;

        public a(String[] strArr, Activity activity, int i10) {
            this.f17359a = strArr;
            this.f17360b = activity;
            this.f17361c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f17359a.length];
            PackageManager packageManager = this.f17360b.getPackageManager();
            String packageName = this.f17360b.getPackageName();
            int length = this.f17359a.length;
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = packageManager.checkPermission(this.f17359a[i10], packageName);
            }
            ((c) this.f17360b).onRequestPermissionsResult(this.f17361c, this.f17359a, iArr);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17362a;

        public b(Activity activity) {
            this.f17362a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17362a.isFinishing() || k.i(this.f17362a)) {
                return;
            }
            this.f17362a.recreate();
        }
    }

    public interface c {
        void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr);
    }

    public interface d {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void b(Activity activity) {
        activity.finishAffinity();
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static void d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void e(Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            activity.recreate();
        } else if (i10 <= 23) {
            new Handler(activity.getMainLooper()).post(new b(activity));
        } else {
            if (k.i(activity)) {
                return;
            }
            activity.recreate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f(Activity activity, String[] strArr, int i10) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof d) {
                ((d) activity).validateRequestPermissionsRequestCode(i10);
            }
            activity.requestPermissions(strArr, i10);
        } else if (activity instanceof c) {
            new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i10));
        }
    }

    public static void g(Activity activity, k1 k1Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(null);
        }
    }

    public static void h(Activity activity, k1 k1Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(null);
        }
    }

    public static boolean i(Activity activity, String str) {
        boolean shouldShowRequestPermissionRationale;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
        return shouldShowRequestPermissionRationale;
    }

    public static void j(Activity activity, Intent intent, int i10, Bundle bundle) {
        activity.startActivityForResult(intent, i10, bundle);
    }

    public static void k(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void l(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}
