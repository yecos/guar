package com.zhy.autolayout.attr;

import android.view.View;

/* loaded from: classes3.dex */
public class MinHeightAttr extends AutoAttr {
    public MinHeightAttr(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }

    public static MinHeightAttr generate(int i10, int i11) {
        MinHeightAttr minHeightAttr;
        if (i11 == 1) {
            minHeightAttr = new MinHeightAttr(i10, 32768, 0);
        } else if (i11 == 2) {
            minHeightAttr = new MinHeightAttr(i10, 0, 32768);
        } else {
            if (i11 != 3) {
                return null;
            }
            minHeightAttr = new MinHeightAttr(i10, 0, 0);
        }
        return minHeightAttr;
    }

    public static int getMinHeight(View view) {
        return view.getMinimumHeight();
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public int attrVal() {
        return 32768;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public boolean defaultBaseWidth() {
        return false;
    }

    @Override // com.zhy.autolayout.attr.AutoAttr
    public void execute(View view, int i10) {
        try {
            view.setMinimumHeight(i10);
        } catch (Exception unused) {
        }
    }
}
