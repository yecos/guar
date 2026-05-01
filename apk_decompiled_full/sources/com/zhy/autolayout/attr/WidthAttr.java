package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class WidthAttr extends AutoAttr {
    public WidthAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static WidthAttr generate(int i10, int i11) {
        WidthAttr widthAttr;
        if (i11 == 1) {
            widthAttr = new WidthAttr(i10, 1, 0);
        } else if (i11 == 2) {
            widthAttr = new WidthAttr(i10, 0, 1);
        } else {
            if (i11 != 3) {
                return null;
            }
            widthAttr = new WidthAttr(i10, 0, 0);
        }
        return widthAttr;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 1;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return true;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.getLayoutParams().width = i10;
    }
}
