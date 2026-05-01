package o;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l1 implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17387a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Context f17388b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public l1(Context context) {
        this.f17388b = context;
    }

    public static l1 d(Context context) {
        return new l1(context);
    }

    public l1 a(Intent intent) {
        this.f17387a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l1 b(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = q.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f17388b.getPackageManager());
            }
            c(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public l1 c(ComponentName componentName) {
        int size = this.f17387a.size();
        try {
            Intent b10 = q.b(this.f17388b, componentName);
            while (b10 != null) {
                this.f17387a.add(size, b10);
                b10 = q.b(this.f17388b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public PendingIntent e(int i10, int i11) {
        return f(i10, i11, null);
    }

    public PendingIntent f(int i10, int i11, Bundle bundle) {
        if (this.f17387a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        ArrayList arrayList = this.f17387a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return PendingIntent.getActivities(this.f17388b, i10, intentArr, i11, bundle);
    }

    public void g() {
        h(null);
    }

    public void h(Bundle bundle) {
        if (this.f17387a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList arrayList = this.f17387a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (p.a.startActivities(this.f17388b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f17388b.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f17387a.iterator();
    }
}
