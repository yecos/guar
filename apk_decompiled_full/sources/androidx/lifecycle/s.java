package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f2583e;

    /* renamed from: a, reason: collision with root package name */
    public final Map f2584a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f2585b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f2586c;

    /* renamed from: d, reason: collision with root package name */
    public final SavedStateRegistry.b f2587d;

    public class a implements SavedStateRegistry.b {
        public a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(s.this.f2585b).entrySet()) {
                s.this.c((String) entry.getKey(), ((SavedStateRegistry.b) entry.getValue()).a());
            }
            Set<String> keySet = s.this.f2584a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(s.this.f2584a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(UserMetadata.KEYDATA_FILENAME, arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i10 = Build.VERSION.SDK_INT;
        clsArr[27] = i10 >= 21 ? q.a() : cls;
        if (i10 >= 21) {
            cls = r.a();
        }
        clsArr[28] = cls;
        f2583e = clsArr;
    }

    public s(Map map) {
        this.f2585b = new HashMap();
        this.f2586c = new HashMap();
        this.f2587d = new a();
        this.f2584a = new HashMap(map);
    }

    public static s a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new s();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new s(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
            hashMap.put((String) parcelableArrayList.get(i10), parcelableArrayList2.get(i10));
        }
        return new s(hashMap);
    }

    public static void d(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : f2583e) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    public SavedStateRegistry.b b() {
        return this.f2587d;
    }

    public void c(String str, Object obj) {
        d(obj);
        l lVar = (l) this.f2586c.get(str);
        if (lVar != null) {
            lVar.n(obj);
        } else {
            this.f2584a.put(str, obj);
        }
    }

    public s() {
        this.f2585b = new HashMap();
        this.f2586c = new HashMap();
        this.f2587d = new a();
        this.f2584a = new HashMap();
    }
}
