package com.zhy.autolayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.zhy.autolayout.attr.AutoAttr;
import com.zhy.autolayout.attr.HeightAttr;
import com.zhy.autolayout.attr.MarginBottomAttr;
import com.zhy.autolayout.attr.MarginLeftAttr;
import com.zhy.autolayout.attr.MarginRightAttr;
import com.zhy.autolayout.attr.MarginTopAttr;
import com.zhy.autolayout.attr.MaxHeightAttr;
import com.zhy.autolayout.attr.MaxWidthAttr;
import com.zhy.autolayout.attr.MinHeightAttr;
import com.zhy.autolayout.attr.MinWidthAttr;
import com.zhy.autolayout.attr.PaddingBottomAttr;
import com.zhy.autolayout.attr.PaddingLeftAttr;
import com.zhy.autolayout.attr.PaddingRightAttr;
import com.zhy.autolayout.attr.PaddingTopAttr;
import com.zhy.autolayout.attr.TextSizeAttr;
import com.zhy.autolayout.attr.WidthAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AutoLayoutInfo {
    private List<AutoAttr> autoAttrs = new ArrayList();

    public static AutoLayoutInfo getAttrFromView(View view, int i10, int i11) {
        int i12;
        int i13;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        AutoLayoutInfo autoLayoutInfo = new AutoLayoutInfo();
        if ((i10 & 1) != 0 && (i13 = layoutParams.width) > 0) {
            autoLayoutInfo.addAttr(WidthAttr.generate(i13, i11));
        }
        if ((i10 & 2) != 0 && (i12 = layoutParams.height) > 0) {
            autoLayoutInfo.addAttr(HeightAttr.generate(i12, i11));
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if ((i10 & 16) != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                autoLayoutInfo.addAttr(MarginLeftAttr.generate(marginLayoutParams.leftMargin, i11));
                autoLayoutInfo.addAttr(MarginTopAttr.generate(marginLayoutParams.topMargin, i11));
                autoLayoutInfo.addAttr(MarginRightAttr.generate(marginLayoutParams.rightMargin, i11));
                autoLayoutInfo.addAttr(MarginBottomAttr.generate(marginLayoutParams.bottomMargin, i11));
            }
            if ((i10 & 32) != 0) {
                autoLayoutInfo.addAttr(MarginLeftAttr.generate(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11));
            }
            if ((i10 & 64) != 0) {
                autoLayoutInfo.addAttr(MarginTopAttr.generate(((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i11));
            }
            if ((i10 & 128) != 0) {
                autoLayoutInfo.addAttr(MarginRightAttr.generate(((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i11));
            }
            if ((i10 & 256) != 0) {
                autoLayoutInfo.addAttr(MarginBottomAttr.generate(((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, i11));
            }
        }
        if ((i10 & 8) != 0) {
            autoLayoutInfo.addAttr(PaddingLeftAttr.generate(view.getPaddingLeft(), i11));
            autoLayoutInfo.addAttr(PaddingTopAttr.generate(view.getPaddingTop(), i11));
            autoLayoutInfo.addAttr(PaddingRightAttr.generate(view.getPaddingRight(), i11));
            autoLayoutInfo.addAttr(PaddingBottomAttr.generate(view.getPaddingBottom(), i11));
        }
        if ((i10 & 512) != 0) {
            autoLayoutInfo.addAttr(MarginLeftAttr.generate(view.getPaddingLeft(), i11));
        }
        if ((i10 & 1024) != 0) {
            autoLayoutInfo.addAttr(MarginTopAttr.generate(view.getPaddingTop(), i11));
        }
        if ((i10 & 2048) != 0) {
            autoLayoutInfo.addAttr(MarginRightAttr.generate(view.getPaddingRight(), i11));
        }
        if ((i10 & 4096) != 0) {
            autoLayoutInfo.addAttr(MarginBottomAttr.generate(view.getPaddingBottom(), i11));
        }
        if ((i10 & 8192) != 0) {
            autoLayoutInfo.addAttr(MinWidthAttr.generate(MinWidthAttr.getMinWidth(view), i11));
        }
        if ((i10 & 16384) != 0) {
            autoLayoutInfo.addAttr(MaxWidthAttr.generate(MaxWidthAttr.getMaxWidth(view), i11));
        }
        if ((32768 & i10) != 0) {
            autoLayoutInfo.addAttr(MinHeightAttr.generate(MinHeightAttr.getMinHeight(view), i11));
        }
        if ((65536 & i10) != 0) {
            autoLayoutInfo.addAttr(MaxHeightAttr.generate(MaxHeightAttr.getMaxHeight(view), i11));
        }
        if ((view instanceof TextView) && (i10 & 4) != 0) {
            autoLayoutInfo.addAttr(TextSizeAttr.generate((int) ((TextView) view).getTextSize(), i11));
        }
        return autoLayoutInfo;
    }

    public void addAttr(AutoAttr autoAttr) {
        this.autoAttrs.add(autoAttr);
    }

    public void fillAttrs(View view) {
        Iterator<AutoAttr> it = this.autoAttrs.iterator();
        while (it.hasNext()) {
            it.next().apply(view);
        }
    }

    public String toString() {
        return "AutoLayoutInfo{autoAttrs=" + this.autoAttrs + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
