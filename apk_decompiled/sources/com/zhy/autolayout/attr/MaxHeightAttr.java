package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class MaxHeightAttr extends AutoAttr {
    public MaxHeightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MaxHeightAttr generate(int i10, int i11) {
        MaxHeightAttr maxHeightAttr;
        if (i11 == 1) {
            maxHeightAttr = new MaxHeightAttr(i10, 65536, 0);
        } else if (i11 == 2) {
            maxHeightAttr = new MaxHeightAttr(i10, 0, 65536);
        } else {
            if (i11 != 3) {
                return null;
            }
            maxHeightAttr = new MaxHeightAttr(i10, 0, 0);
        }
        return maxHeightAttr;
    }

    public static int getMaxHeight(View view) {
        try {
            return ((Integer) view.getClass().getMethod("getMaxHeight", new Class[0]).invoke(view, new Object[0])).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 65536;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        try {
            view.getClass().getMethod("setMaxHeight", Integer.TYPE).invoke(view, Integer.valueOf(i10));
        } catch (Exception unused) {
        }
    }
}
