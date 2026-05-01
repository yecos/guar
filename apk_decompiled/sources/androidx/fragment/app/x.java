package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2431a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2432b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public r f2433c;

    public void a(Fragment fragment) {
        if (this.f2431a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f2431a) {
            this.f2431a.add(fragment);
        }
        fragment.mAdded = true;
    }

    public void b() {
        this.f2432b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f2432b.get(str) != null;
    }

    public void d(int i10) {
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                vVar.u(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2432b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (v vVar : this.f2432b.values()) {
                printWriter.print(str);
                if (vVar != null) {
                    Fragment k10 = vVar.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2431a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) this.f2431a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        v vVar = (v) this.f2432b.get(str);
        if (vVar != null) {
            return vVar.k();
        }
        return null;
    }

    public Fragment g(int i10) {
        for (int size = this.f2431a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f2431a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                Fragment k10 = vVar.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f2431a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f2431a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                Fragment k10 = vVar.k();
                if (str.equals(k10.mTag)) {
                    return k10;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (v vVar : this.f2432b.values()) {
            if (vVar != null && (findFragmentByWho = vVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f2431a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = (Fragment) this.f2431a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f2431a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f2431a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                arrayList.add(vVar);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                arrayList.add(vVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public v m(String str) {
        return (v) this.f2432b.get(str);
    }

    public List n() {
        ArrayList arrayList;
        if (this.f2431a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2431a) {
            arrayList = new ArrayList(this.f2431a);
        }
        return arrayList;
    }

    public r o() {
        return this.f2433c;
    }

    public void p(v vVar) {
        Fragment k10 = vVar.k();
        if (c(k10.mWho)) {
            return;
        }
        this.f2432b.put(k10.mWho, vVar);
        if (k10.mRetainInstanceChangedWhileDetached) {
            if (k10.mRetainInstance) {
                this.f2433c.f(k10);
            } else {
                this.f2433c.n(k10);
            }
            k10.mRetainInstanceChangedWhileDetached = false;
        }
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Added fragment to active set ");
            sb.append(k10);
        }
    }

    public void q(v vVar) {
        Fragment k10 = vVar.k();
        if (k10.mRetainInstance) {
            this.f2433c.n(k10);
        }
        if (((v) this.f2432b.put(k10.mWho, null)) != null && o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Removed fragment from active set ");
            sb.append(k10);
        }
    }

    public void r() {
        Iterator it = this.f2431a.iterator();
        while (it.hasNext()) {
            v vVar = (v) this.f2432b.get(((Fragment) it.next()).mWho);
            if (vVar != null) {
                vVar.m();
            }
        }
        for (v vVar2 : this.f2432b.values()) {
            if (vVar2 != null) {
                vVar2.m();
                Fragment k10 = vVar2.k();
                if (k10.mRemoving && !k10.isInBackStack()) {
                    q(vVar2);
                }
            }
        }
    }

    public void s(Fragment fragment) {
        synchronized (this.f2431a) {
            this.f2431a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void t() {
        this.f2432b.clear();
    }

    public void u(List list) {
        this.f2431a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment f10 = f(str);
                if (f10 == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("restoreSaveState: added (");
                    sb.append(str);
                    sb.append("): ");
                    sb.append(f10);
                }
                a(f10);
            }
        }
    }

    public ArrayList v() {
        ArrayList arrayList = new ArrayList(this.f2432b.size());
        for (v vVar : this.f2432b.values()) {
            if (vVar != null) {
                Fragment k10 = vVar.k();
                u s10 = vVar.s();
                arrayList.add(s10);
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Saved state of ");
                    sb.append(k10);
                    sb.append(": ");
                    sb.append(s10.f2415m);
                }
            }
        }
        return arrayList;
    }

    public ArrayList w() {
        synchronized (this.f2431a) {
            if (this.f2431a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.f2431a.size());
            Iterator it = this.f2431a.iterator();
            while (it.hasNext()) {
                Fragment fragment = (Fragment) it.next();
                arrayList.add(fragment.mWho);
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveAllState: adding fragment (");
                    sb.append(fragment.mWho);
                    sb.append("): ");
                    sb.append(fragment);
                }
            }
            return arrayList;
        }
    }

    public void x(r rVar) {
        this.f2433c = rVar;
    }
}
