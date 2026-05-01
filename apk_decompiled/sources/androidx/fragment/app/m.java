package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class m implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final o f2333a;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f2334a;

        public a(v vVar) {
            this.f2334a = vVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f2334a.k();
            this.f2334a.m();
            j0.n((ViewGroup) k10.mView.getParent(), m.this.f2333a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public m(o oVar) {
        this.f2333a = oVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        v v10;
        if (i.class.getName().equals(str)) {
            return new i(context, attributeSet, this.f2333a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2125d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !k.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment g02 = resourceId != -1 ? this.f2333a.g0(resourceId) : null;
        if (g02 == null && string != null) {
            g02 = this.f2333a.h0(string);
        }
        if (g02 == null && id != -1) {
            g02 = this.f2333a.g0(id);
        }
        if (g02 == null) {
            g02 = this.f2333a.q0().a(context.getClassLoader(), attributeValue);
            g02.mFromLayout = true;
            g02.mFragmentId = resourceId != 0 ? resourceId : id;
            g02.mContainerId = id;
            g02.mTag = string;
            g02.mInLayout = true;
            o oVar = this.f2333a;
            g02.mFragmentManager = oVar;
            g02.mHost = oVar.t0();
            g02.onInflate(this.f2333a.t0().f(), attributeSet, g02.mSavedFragmentState);
            v10 = this.f2333a.g(g02);
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(g02);
                sb.append(" has been inflated via the <fragment> tag: id=0x");
                sb.append(Integer.toHexString(resourceId));
            }
        } else {
            if (g02.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            g02.mInLayout = true;
            o oVar2 = this.f2333a;
            g02.mFragmentManager = oVar2;
            g02.mHost = oVar2.t0();
            g02.onInflate(this.f2333a.t0().f(), attributeSet, g02.mSavedFragmentState);
            v10 = this.f2333a.v(g02);
            if (o.F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Retained Fragment ");
                sb2.append(g02);
                sb2.append(" has been re-attached via the <fragment> tag: id=0x");
                sb2.append(Integer.toHexString(resourceId));
            }
        }
        g02.mContainer = (ViewGroup) view;
        v10.m();
        v10.j();
        View view2 = g02.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (g02.mView.getTag() == null) {
            g02.mView.setTag(string);
        }
        g02.mView.addOnAttachStateChangeListener(new a(v10));
        return g02.mView;
    }
}
