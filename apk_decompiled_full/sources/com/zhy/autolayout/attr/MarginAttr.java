package com.zhy.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class MarginAttr extends AutoAttr {
    public MarginAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void apply(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            if (!useDefault()) {
                super.apply(view);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int percentWidthSize = getPercentWidthSize();
            marginLayoutParams.rightMargin = percentWidthSize;
            marginLayoutParams.leftMargin = percentWidthSize;
            int percentHeightSize = getPercentHeightSize();
            marginLayoutParams.bottomMargin = percentHeightSize;
            marginLayoutParams.topMargin = percentHeightSize;
        }
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 16;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = i10;
        marginLayoutParams.topMargin = i10;
        marginLayoutParams.rightMargin = i10;
        marginLayoutParams.leftMargin = i10;
    }
}
