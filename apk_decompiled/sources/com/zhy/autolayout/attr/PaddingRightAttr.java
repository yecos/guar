package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class PaddingRightAttr extends AutoAttr {
    public PaddingRightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static PaddingRightAttr generate(int i10, int i11) {
        PaddingRightAttr paddingRightAttr;
        if (i11 == 1) {
            paddingRightAttr = new PaddingRightAttr(i10, 2048, 0);
        } else if (i11 == 2) {
            paddingRightAttr = new PaddingRightAttr(i10, 0, 2048);
        } else {
            if (i11 != 3) {
                return null;
            }
            paddingRightAttr = new PaddingRightAttr(i10, 0, 0);
        }
        return paddingRightAttr;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 2048;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return true;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i10, view.getPaddingBottom());
    }
}
