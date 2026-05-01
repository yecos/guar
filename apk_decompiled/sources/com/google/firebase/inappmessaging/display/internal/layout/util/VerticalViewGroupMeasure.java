package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class VerticalViewGroupMeasure {

    /* renamed from: h, reason: collision with root package name */
    private int f7038h;
    private List<ViewMeasure> vms;

    /* renamed from: w, reason: collision with root package name */
    private int f7039w;

    public VerticalViewGroupMeasure(int i10, int i11) {
        this.vms = new ArrayList();
        this.f7039w = i10;
        this.f7038h = i11;
    }

    public void add(View view, boolean z10) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z10);
        viewMeasure.setMaxDimens(this.f7039w, this.f7038h);
        this.vms.add(viewMeasure);
    }

    public void allocateSpace(int i10) {
        float f10;
        ArrayList<ViewMeasure> arrayList = new ArrayList();
        for (ViewMeasure viewMeasure : this.vms) {
            if (viewMeasure.isFlex()) {
                arrayList.add(viewMeasure);
            }
        }
        Collections.sort(arrayList, new Comparator<ViewMeasure>() { // from class: com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure.1
            @Override // java.util.Comparator
            public int compare(ViewMeasure viewMeasure2, ViewMeasure viewMeasure3) {
                if (viewMeasure2.getDesiredHeight() > viewMeasure3.getDesiredHeight()) {
                    return -1;
                }
                return viewMeasure2.getDesiredHeight() < viewMeasure3.getDesiredHeight() ? 1 : 0;
            }
        });
        Iterator it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 += ((ViewMeasure) it.next()).getDesiredHeight();
        }
        if (arrayList.size() >= 6) {
            throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
        }
        float f11 = 1.0f - ((r1 - 1) * 0.2f);
        Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2f, f11);
        float f12 = 0.0f;
        for (ViewMeasure viewMeasure2 : arrayList) {
            float desiredHeight = viewMeasure2.getDesiredHeight() / i11;
            if (desiredHeight > f11) {
                f12 += desiredHeight - f11;
                f10 = f11;
            } else {
                f10 = desiredHeight;
            }
            if (desiredHeight < 0.2f) {
                float min = Math.min(0.2f - desiredHeight, f12);
                f12 -= min;
                f10 = desiredHeight + min;
            }
            Logging.logdPair("\t(desired, granted)", desiredHeight, f10);
            viewMeasure2.setMaxDimens(this.f7039w, (int) (f10 * i10));
        }
    }

    public int getTotalFixedHeight() {
        int i10 = 0;
        for (ViewMeasure viewMeasure : this.vms) {
            if (!viewMeasure.isFlex()) {
                i10 += viewMeasure.getDesiredHeight();
            }
        }
        return i10;
    }

    public int getTotalHeight() {
        Iterator<ViewMeasure> it = this.vms.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().getDesiredHeight();
        }
        return i10;
    }

    public List<ViewMeasure> getViews() {
        return this.vms;
    }

    public void reset(int i10, int i11) {
        this.f7039w = i10;
        this.f7038h = i11;
        this.vms = new ArrayList();
    }

    public VerticalViewGroupMeasure() {
        this.vms = new ArrayList();
        this.f7039w = 0;
        this.f7038h = 0;
    }
}
