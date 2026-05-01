package com.zhy.autolayout.attr;

import android.view.View;
import anet.channel.entity.ConnType;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.zhy.autolayout.utils.AutoUtils;
import com.zhy.autolayout.utils.L;

/* loaded from: classes3.dex */
public abstract class AutoAttr {
    public static final int BASE_DEFAULT = 3;
    public static final int BASE_HEIGHT = 2;
    public static final int BASE_WIDTH = 1;
    protected int baseHeight;
    protected int baseWidth;
    protected int pxVal;

    public AutoAttr(int i10, int i11, int i12) {
        this.pxVal = i10;
        this.baseWidth = i11;
        this.baseHeight = i12;
    }

    public void apply(View view) {
        int percentHeightSize;
        boolean z10 = view.getTag() != null && view.getTag().toString().equals(ConnType.PK_AUTO);
        if (z10) {
            L.e(" pxVal = " + this.pxVal + " ," + getClass().getSimpleName());
        }
        if (useDefault()) {
            percentHeightSize = defaultBaseWidth() ? getPercentWidthSize() : getPercentHeightSize();
            if (z10) {
                L.e(" useDefault val= " + percentHeightSize);
            }
        } else if (baseWidth()) {
            percentHeightSize = getPercentWidthSize();
            if (z10) {
                L.e(" baseWidth val= " + percentHeightSize);
            }
        } else {
            percentHeightSize = getPercentHeightSize();
            if (z10) {
                L.e(" baseHeight val= " + percentHeightSize);
            }
        }
        if (percentHeightSize > 0) {
            percentHeightSize = Math.max(percentHeightSize, 1);
        }
        execute(view, percentHeightSize);
    }

    public abstract int attrVal();

    public boolean baseWidth() {
        return contains(this.baseWidth, attrVal());
    }

    public boolean contains(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public abstract boolean defaultBaseWidth();

    public abstract void execute(View view, int i10);

    public int getPercentHeightSize() {
        return AutoUtils.getPercentHeightSizeBigger(this.pxVal);
    }

    public int getPercentWidthSize() {
        return AutoUtils.getPercentWidthSizeBigger(this.pxVal);
    }

    public String toString() {
        return "AutoAttr{pxVal=" + this.pxVal + ", baseWidth=" + baseWidth() + ", defaultBaseWidth=" + defaultBaseWidth() + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public boolean useDefault() {
        return (contains(this.baseHeight, attrVal()) || contains(this.baseWidth, attrVal())) ? false : true;
    }
}
