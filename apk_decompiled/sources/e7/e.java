package e7;

import android.app.Activity;
import android.content.DialogInterface;

/* loaded from: classes3.dex */
public final class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f12953a;

    public e(Activity activity) {
        this.f12953a = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12953a.finish();
    }
}
