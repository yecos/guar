package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class MarginTopAttr extends AutoAttr {
    public MarginTopAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MarginTopAttr generate(int i10, int i11) {
        MarginTopAttr marginTopAttr;
        if (i11 == 1) {
            marginTopAttr = new MarginTopAttr(i10, 64, 0);
        } else if (i11 == 2) {
            marginTopAttr = new MarginTopAttr(i10, 0, 64);
        } else {
            if (i11 != 3) {
                return null;
            }
            marginTopAttr = new MarginTopAttr(i10, 0, 0);
        }
        return marginTopAttr;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 64;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = i10;
        }
    }
}
