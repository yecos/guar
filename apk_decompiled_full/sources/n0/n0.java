package n0;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f16911a;

    /* renamed from: b, reason: collision with root package name */
    public List f16912b;

    /* renamed from: c, reason: collision with root package name */
    public List f16913c;

    public n0(Bundle bundle) {
        this.f16911a = bundle;
    }

    public static n0 d(Bundle bundle) {
        if (bundle != null) {
            return new n0(bundle);
        }
        return null;
    }

    public boolean a() {
        return this.f16911a.getBoolean("canDisconnect", false);
    }

    public void b() {
        if (this.f16913c == null) {
            ArrayList parcelableArrayList = this.f16911a.getParcelableArrayList("controlFilters");
            this.f16913c = parcelableArrayList;
            if (parcelableArrayList == null) {
                this.f16913c = Collections.emptyList();
            }
        }
    }

    public void c() {
        if (this.f16912b == null) {
            ArrayList<String> stringArrayList = this.f16911a.getStringArrayList("groupMemberIds");
            this.f16912b = stringArrayList;
            if (stringArrayList == null) {
                this.f16912b = Collections.emptyList();
            }
        }
    }

    public int e() {
        return this.f16911a.getInt("connectionState", 0);
    }

    public List f() {
        b();
        return this.f16913c;
    }

    public String g() {
        return this.f16911a.getString(Constant.KEY_STATUS);
    }

    public int h() {
        return this.f16911a.getInt("deviceType");
    }

    public Bundle i() {
        return this.f16911a.getBundle("extras");
    }

    public List j() {
        c();
        return this.f16912b;
    }

    public Uri k() {
        String string = this.f16911a.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public String l() {
        return this.f16911a.getString("id");
    }

    public int m() {
        return this.f16911a.getInt("maxClientVersion", Integer.MAX_VALUE);
    }

    public int n() {
        return this.f16911a.getInt("minClientVersion", 1);
    }

    public String o() {
        return this.f16911a.getString("name");
    }

    public int p() {
        return this.f16911a.getInt("playbackStream", -1);
    }

    public int q() {
        return this.f16911a.getInt("playbackType", 1);
    }

    public int r() {
        return this.f16911a.getInt("presentationDisplayId", -1);
    }

    public IntentSender s() {
        return (IntentSender) this.f16911a.getParcelable("settingsIntent");
    }

    public int t() {
        return this.f16911a.getInt(PlistBuilder.VALUE_TYPE_VOLUME);
    }

    public String toString() {
        return "MediaRouteDescriptor{ id=" + l() + ", groupMemberIds=" + j() + ", name=" + o() + ", description=" + g() + ", iconUri=" + k() + ", isEnabled=" + w() + ", connectionState=" + e() + ", controlFilters=" + Arrays.toString(f().toArray()) + ", playbackType=" + q() + ", playbackStream=" + p() + ", deviceType=" + h() + ", volume=" + t() + ", volumeMax=" + v() + ", volumeHandling=" + u() + ", presentationDisplayId=" + r() + ", extras=" + i() + ", isValid=" + x() + ", minClientVersion=" + n() + ", maxClientVersion=" + m() + " }";
    }

    public int u() {
        return this.f16911a.getInt("volumeHandling", 0);
    }

    public int v() {
        return this.f16911a.getInt("volumeMax");
    }

    public boolean w() {
        return this.f16911a.getBoolean("enabled", true);
    }

    public boolean x() {
        b();
        return (TextUtils.isEmpty(l()) || TextUtils.isEmpty(o()) || this.f16913c.contains(null)) ? false : true;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f16914a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f16915b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f16916c;

        public a(String str, String str2) {
            this.f16914a = new Bundle();
            m(str);
            n(str2);
        }

        public a a(IntentFilter intentFilter) {
            if (intentFilter == null) {
                throw new IllegalArgumentException("filter must not be null");
            }
            if (this.f16916c == null) {
                this.f16916c = new ArrayList();
            }
            if (!this.f16916c.contains(intentFilter)) {
                this.f16916c.add(intentFilter);
            }
            return this;
        }

        public a b(Collection collection) {
            if (collection == null) {
                throw new IllegalArgumentException("filters must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    a((IntentFilter) it.next());
                }
            }
            return this;
        }

        public a c(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("groupMemberId must not be empty");
            }
            if (this.f16915b == null) {
                this.f16915b = new ArrayList();
            }
            if (!this.f16915b.contains(str)) {
                this.f16915b.add(str);
            }
            return this;
        }

        public a d(Collection collection) {
            if (collection == null) {
                throw new IllegalArgumentException("groupMemberIds must not be null");
            }
            if (!collection.isEmpty()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    c((String) it.next());
                }
            }
            return this;
        }

        public n0 e() {
            ArrayList<? extends Parcelable> arrayList = this.f16916c;
            if (arrayList != null) {
                this.f16914a.putParcelableArrayList("controlFilters", arrayList);
            }
            ArrayList<String> arrayList2 = this.f16915b;
            if (arrayList2 != null) {
                this.f16914a.putStringArrayList("groupMemberIds", arrayList2);
            }
            return new n0(this.f16914a);
        }

        public a f(boolean z10) {
            this.f16914a.putBoolean("canDisconnect", z10);
            return this;
        }

        public a g(int i10) {
            this.f16914a.putInt("connectionState", i10);
            return this;
        }

        public a h(String str) {
            this.f16914a.putString(Constant.KEY_STATUS, str);
            return this;
        }

        public a i(int i10) {
            this.f16914a.putInt("deviceType", i10);
            return this;
        }

        public a j(boolean z10) {
            this.f16914a.putBoolean("enabled", z10);
            return this;
        }

        public a k(Bundle bundle) {
            this.f16914a.putBundle("extras", bundle);
            return this;
        }

        public a l(Uri uri) {
            if (uri == null) {
                throw new IllegalArgumentException("iconUri must not be null");
            }
            this.f16914a.putString("iconUri", uri.toString());
            return this;
        }

        public a m(String str) {
            this.f16914a.putString("id", str);
            return this;
        }

        public a n(String str) {
            this.f16914a.putString("name", str);
            return this;
        }

        public a o(int i10) {
            this.f16914a.putInt("playbackStream", i10);
            return this;
        }

        public a p(int i10) {
            this.f16914a.putInt("playbackType", i10);
            return this;
        }

        public a q(int i10) {
            this.f16914a.putInt("presentationDisplayId", i10);
            return this;
        }

        public a r(int i10) {
            this.f16914a.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            return this;
        }

        public a s(int i10) {
            this.f16914a.putInt("volumeHandling", i10);
            return this;
        }

        public a t(int i10) {
            this.f16914a.putInt("volumeMax", i10);
            return this;
        }

        public a(n0 n0Var) {
            if (n0Var != null) {
                this.f16914a = new Bundle(n0Var.f16911a);
                if (!n0Var.j().isEmpty()) {
                    this.f16915b = new ArrayList(n0Var.j());
                }
                if (n0Var.f().isEmpty()) {
                    return;
                }
                this.f16916c = new ArrayList(n0Var.f16913c);
                return;
            }
            throw new IllegalArgumentException("descriptor must not be null");
        }
    }
}
