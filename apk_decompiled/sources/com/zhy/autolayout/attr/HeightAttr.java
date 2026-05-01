package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class HeightAttr extends AutoAttr {
    public HeightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static HeightAttr generate(int i10, int i11) {
        HeightAttr heightAttr;
        if (i11 == 1) {
            heightAttr = new HeightAttr(i10, 2, 0);
        } else if (i11 == 2) {
            heightAttr = new HeightAttr(i10, 0, 2);
        } else {
            if (i11 != 3) {
                return null;
            }
            heightAttr = new HeightAttr(i10, 0, 0);
        }
        return heightAttr;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 2;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.getLayoutParams().height = i10;
    }
}
