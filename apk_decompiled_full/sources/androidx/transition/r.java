package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.n;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class r extends n {

    /* renamed from: c, reason: collision with root package name */
    public int f3525c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3523a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f3524b = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3526d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f3527e = 0;

    public class a extends o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f3528a;

        public a(n nVar) {
            this.f3528a = nVar;
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            this.f3528a.runAnimators();
            nVar.removeListener(this);
        }
    }

    public static class b extends o {

        /* renamed from: a, reason: collision with root package name */
        public r f3530a;

        public b(r rVar) {
            this.f3530a = rVar;
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void b(n nVar) {
            r rVar = this.f3530a;
            if (rVar.f3526d) {
                return;
            }
            rVar.start();
            this.f3530a.f3526d = true;
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            r rVar = this.f3530a;
            int i10 = rVar.f3525c - 1;
            rVar.f3525c = i10;
            if (i10 == 0) {
                rVar.f3526d = false;
                rVar.end();
            }
            nVar.removeListener(this);
        }
    }

    @Override // androidx.transition.n
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public r removeListener(n.g gVar) {
        return (r) super.removeListener(gVar);
    }

    @Override // androidx.transition.n
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public r removeTarget(int i10) {
        for (int i11 = 0; i11 < this.f3523a.size(); i11++) {
            ((n) this.f3523a.get(i11)).removeTarget(i10);
        }
        return (r) super.removeTarget(i10);
    }

    @Override // androidx.transition.n
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public r removeTarget(View view) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).removeTarget(view);
        }
        return (r) super.removeTarget(view);
    }

    @Override // androidx.transition.n
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public r removeTarget(Class cls) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).removeTarget((Class<?>) cls);
        }
        return (r) super.removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.n
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public r removeTarget(String str) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).removeTarget(str);
        }
        return (r) super.removeTarget(str);
    }

    @Override // androidx.transition.n
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public r setDuration(long j10) {
        ArrayList arrayList;
        super.setDuration(j10);
        if (this.mDuration >= 0 && (arrayList = this.f3523a) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((n) this.f3523a.get(i10)).setDuration(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.n
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public r setInterpolator(TimeInterpolator timeInterpolator) {
        this.f3527e |= 1;
        ArrayList arrayList = this.f3523a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((n) this.f3523a.get(i10)).setInterpolator(timeInterpolator);
            }
        }
        return (r) super.setInterpolator(timeInterpolator);
    }

    public r H(int i10) {
        if (i10 == 0) {
            this.f3524b = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
            this.f3524b = false;
        }
        return this;
    }

    @Override // androidx.transition.n
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public r setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.n
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public r setStartDelay(long j10) {
        return (r) super.setStartDelay(j10);
    }

    public final void K() {
        b bVar = new b(this);
        Iterator it = this.f3523a.iterator();
        while (it.hasNext()) {
            ((n) it.next()).addListener(bVar);
        }
        this.f3525c = this.f3523a.size();
    }

    @Override // androidx.transition.n
    public void cancel() {
        super.cancel();
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).cancel();
        }
    }

    @Override // androidx.transition.n
    public void captureEndValues(u uVar) {
        if (isValidTarget(uVar.f3535b)) {
            Iterator it = this.f3523a.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.isValidTarget(uVar.f3535b)) {
                    nVar.captureEndValues(uVar);
                    uVar.f3536c.add(nVar);
                }
            }
        }
    }

    @Override // androidx.transition.n
    public void capturePropagationValues(u uVar) {
        super.capturePropagationValues(uVar);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).capturePropagationValues(uVar);
        }
    }

    @Override // androidx.transition.n
    public void captureStartValues(u uVar) {
        if (isValidTarget(uVar.f3535b)) {
            Iterator it = this.f3523a.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.isValidTarget(uVar.f3535b)) {
                    nVar.captureStartValues(uVar);
                    uVar.f3536c.add(nVar);
                }
            }
        }
    }

    @Override // androidx.transition.n
    public void createAnimators(ViewGroup viewGroup, v vVar, v vVar2, ArrayList arrayList, ArrayList arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            n nVar = (n) this.f3523a.get(i10);
            if (startDelay > 0 && (this.f3524b || i10 == 0)) {
                long startDelay2 = nVar.getStartDelay();
                if (startDelay2 > 0) {
                    nVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    nVar.setStartDelay(startDelay);
                }
            }
            nVar.createAnimators(viewGroup, vVar, vVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.n
    public n excludeTarget(View view, boolean z10) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).excludeTarget(view, z10);
        }
        return super.excludeTarget(view, z10);
    }

    @Override // androidx.transition.n
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).forceToEnd(viewGroup);
        }
    }

    @Override // androidx.transition.n
    public void pause(View view) {
        super.pause(view);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).pause(view);
        }
    }

    @Override // androidx.transition.n
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public r addListener(n.g gVar) {
        return (r) super.addListener(gVar);
    }

    @Override // androidx.transition.n
    public void resume(View view) {
        super.resume(view);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).resume(view);
        }
    }

    @Override // androidx.transition.n
    public void runAnimators() {
        if (this.f3523a.isEmpty()) {
            start();
            end();
            return;
        }
        K();
        if (this.f3524b) {
            Iterator it = this.f3523a.iterator();
            while (it.hasNext()) {
                ((n) it.next()).runAnimators();
            }
            return;
        }
        for (int i10 = 1; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10 - 1)).addListener(new a((n) this.f3523a.get(i10)));
        }
        n nVar = (n) this.f3523a.get(0);
        if (nVar != null) {
            nVar.runAnimators();
        }
    }

    @Override // androidx.transition.n
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public r addTarget(int i10) {
        for (int i11 = 0; i11 < this.f3523a.size(); i11++) {
            ((n) this.f3523a.get(i11)).addTarget(i10);
        }
        return (r) super.addTarget(i10);
    }

    @Override // androidx.transition.n
    public void setCanRemoveViews(boolean z10) {
        super.setCanRemoveViews(z10);
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).setCanRemoveViews(z10);
        }
    }

    @Override // androidx.transition.n
    public void setEpicenterCallback(n.f fVar) {
        super.setEpicenterCallback(fVar);
        this.f3527e |= 8;
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).setEpicenterCallback(fVar);
        }
    }

    @Override // androidx.transition.n
    public void setPathMotion(h hVar) {
        super.setPathMotion(hVar);
        this.f3527e |= 4;
        if (this.f3523a != null) {
            for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
                ((n) this.f3523a.get(i10)).setPathMotion(hVar);
            }
        }
    }

    @Override // androidx.transition.n
    public void setPropagation(q qVar) {
        super.setPropagation(qVar);
        this.f3527e |= 2;
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3523a.get(i10)).setPropagation(qVar);
        }
    }

    @Override // androidx.transition.n
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public r addTarget(View view) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).addTarget(view);
        }
        return (r) super.addTarget(view);
    }

    @Override // androidx.transition.n
    public String toString(String str) {
        String nVar = super.toString(str);
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nVar);
            sb.append("\n");
            sb.append(((n) this.f3523a.get(i10)).toString(str + "  "));
            nVar = sb.toString();
        }
        return nVar;
    }

    @Override // androidx.transition.n
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public r addTarget(Class cls) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).addTarget((Class<?>) cls);
        }
        return (r) super.addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.n
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public r addTarget(String str) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).addTarget(str);
        }
        return (r) super.addTarget(str);
    }

    public r w(n nVar) {
        x(nVar);
        long j10 = this.mDuration;
        if (j10 >= 0) {
            nVar.setDuration(j10);
        }
        if ((this.f3527e & 1) != 0) {
            nVar.setInterpolator(getInterpolator());
        }
        if ((this.f3527e & 2) != 0) {
            getPropagation();
            nVar.setPropagation(null);
        }
        if ((this.f3527e & 4) != 0) {
            nVar.setPathMotion(getPathMotion());
        }
        if ((this.f3527e & 8) != 0) {
            nVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public final void x(n nVar) {
        this.f3523a.add(nVar);
        nVar.mParent = this;
    }

    public n y(int i10) {
        if (i10 < 0 || i10 >= this.f3523a.size()) {
            return null;
        }
        return (n) this.f3523a.get(i10);
    }

    public int z() {
        return this.f3523a.size();
    }

    @Override // androidx.transition.n
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public n mo0clone() {
        r rVar = (r) super.mo0clone();
        rVar.f3523a = new ArrayList();
        int size = this.f3523a.size();
        for (int i10 = 0; i10 < size; i10++) {
            rVar.x(((n) this.f3523a.get(i10)).mo0clone());
        }
        return rVar;
    }

    @Override // androidx.transition.n
    public n excludeTarget(String str, boolean z10) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).excludeTarget(str, z10);
        }
        return super.excludeTarget(str, z10);
    }

    @Override // androidx.transition.n
    public n excludeTarget(int i10, boolean z10) {
        for (int i11 = 0; i11 < this.f3523a.size(); i11++) {
            ((n) this.f3523a.get(i11)).excludeTarget(i10, z10);
        }
        return super.excludeTarget(i10, z10);
    }

    @Override // androidx.transition.n
    public n excludeTarget(Class cls, boolean z10) {
        for (int i10 = 0; i10 < this.f3523a.size(); i10++) {
            ((n) this.f3523a.get(i10)).excludeTarget((Class<?>) cls, z10);
        }
        return super.excludeTarget((Class<?>) cls, z10);
    }
}
