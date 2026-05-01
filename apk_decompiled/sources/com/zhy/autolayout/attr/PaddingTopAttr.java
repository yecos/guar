package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class PaddingTopAttr extends AutoAttr {
    public PaddingTopAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static PaddingTopAttr generate(int i10, int i11) {
        PaddingTopAttr paddingTopAttr;
        if (i11 == 1) {
            paddingTopAttr = new PaddingTopAttr(i10, 1024, 0);
        } else if (i11 == 2) {
            paddingTopAttr = new PaddingTopAttr(i10, 0, 1024);
        } else {
            if (i11 != 3) {
                return null;
            }
            paddingTopAttr = new PaddingTopAttr(i10, 0, 0);
        }
        return paddingTopAttr;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 1024;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), view.getPaddingBottom());
    }
}
