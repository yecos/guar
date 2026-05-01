package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class MinWidthAttr extends AutoAttr {
    public MinWidthAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MinWidthAttr generate(int i10, int i11) {
        MinWidthAttr minWidthAttr;
        if (i11 == 1) {
            minWidthAttr = new MinWidthAttr(i10, 8192, 0);
        } else if (i11 == 2) {
            minWidthAttr = new MinWidthAttr(i10, 0, 8192);
        } else {
            if (i11 != 3) {
                return null;
            }
            minWidthAttr = new MinWidthAttr(i10, 0, 0);
        }
        return minWidthAttr;
    }

    public static int getMinWidth(View view) {
        return view.getMinimumWidth();
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 8192;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return true;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.setMinimumWidth(i10);
    }
}
