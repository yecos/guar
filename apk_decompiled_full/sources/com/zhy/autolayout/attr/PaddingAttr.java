package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class PaddingAttr extends AutoAttr {
    public PaddingAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void apply(View view) {
        if (!useDefault()) {
            super.apply(view);
            return;
        }
        int percentWidthSize = getPercentWidthSize();
        int percentHeightSize = getPercentHeightSize();
        view.setPadding(percentWidthSize, percentHeightSize, percentWidthSize, percentHeightSize);
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 8;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        view.setPadding(i10, i10, i10, i10);
    }
}
