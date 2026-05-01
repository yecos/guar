package o;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.hpplay.cybergarage.upnp.Icon;
import java.util.List;
import o.s;

/* loaded from: classes.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f17357a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f17358b = new Object();

    public static SparseArray a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = (Bundle) list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle b(s.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat f10 = aVar.f();
        bundle.putInt(Icon.ELEM_NAME, f10 != null ? f10.g() : 0);
        bundle.putCharSequence("title", aVar.j());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", d(aVar.g()));
        bundle.putBoolean("showsUserInterface", aVar.i());
        bundle.putInt("semanticAction", aVar.h());
        return bundle;
    }

    public static Bundle c(j1 j1Var) {
        new Bundle();
        throw null;
    }

    public static Bundle[] d(j1[] j1VarArr) {
        if (j1VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[j1VarArr.length];
        for (int i10 = 0; i10 < j1VarArr.length; i10++) {
            j1 j1Var = j1VarArr[i10];
            bundleArr[i10] = c(null);
        }
        return bundleArr;
    }

    public static Bundle e(Notification.Builder builder, s.a aVar) {
        IconCompat f10 = aVar.f();
        builder.addAction(f10 != null ? f10.g() : 0, aVar.j(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", d(aVar.g()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", d(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
