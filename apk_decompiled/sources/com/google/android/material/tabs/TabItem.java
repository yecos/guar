package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.r2;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        r2 t10 = r2.t(context, attributeSet, R.styleable.TabItem);
        this.text = t10.p(R.styleable.TabItem_android_text);
        this.icon = t10.g(R.styleable.TabItem_android_icon);
        this.customLayout = t10.n(R.styleable.TabItem_android_layout, 0);
        t10.v();
    }
}
