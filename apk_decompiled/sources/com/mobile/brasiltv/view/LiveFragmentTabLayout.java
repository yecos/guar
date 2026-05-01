package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LiveFragmentTabLayout extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private RelativeLayout leftCon;
    private View leftIndex;
    private TextView leftText;
    private int leftTextColor;
    private int leftTextSize;
    private TabOnClickListener onClickListener;
    private RelativeLayout rightCon;
    private View rightIndex;
    private TextView rightText;
    private int rightTextColor;
    private int rightTextSize;
    private int selectIndexColor;
    private boolean selectLeft;
    private int selectTextColor;

    public LiveFragmentTabLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LiveFragmentTabLayout liveFragmentTabLayout, View view) {
        t9.i.g(liveFragmentTabLayout, "this$0");
        if (liveFragmentTabLayout.selectLeft) {
            return;
        }
        liveFragmentTabLayout.selectLeft = true;
        liveFragmentTabLayout.selectedLeftText();
        TabOnClickListener tabOnClickListener = liveFragmentTabLayout.onClickListener;
        if (tabOnClickListener != null) {
            tabOnClickListener.leftTextClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LiveFragmentTabLayout liveFragmentTabLayout, View view) {
        t9.i.g(liveFragmentTabLayout, "this$0");
        if (liveFragmentTabLayout.selectLeft) {
            liveFragmentTabLayout.selectLeft = false;
            liveFragmentTabLayout.selectedRightText();
            TabOnClickListener tabOnClickListener = liveFragmentTabLayout.onClickListener;
            if (tabOnClickListener != null) {
                tabOnClickListener.rightTextClick();
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void initView(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.f7791k) : null;
            this.leftTextColor = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(0, this.leftTextColor) : -16776961;
            this.rightTextColor = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(3, this.rightTextColor) : -16776961;
            this.selectIndexColor = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(6, this.selectIndexColor) : -16776961;
            this.selectTextColor = obtainStyledAttributes != null ? obtainStyledAttributes.getColor(7, this.selectTextColor) : -16776961;
            this.leftTextSize = obtainStyledAttributes != null ? obtainStyledAttributes.getDimensionPixelSize(1, this.leftTextSize) : 10;
            this.rightTextSize = obtainStyledAttributes != null ? obtainStyledAttributes.getDimensionPixelSize(4, this.rightTextSize) : 10;
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_live_table, (ViewGroup) this, true);
        t9.i.f(inflate, "from(context).inflate(R.…t_live_table, this, true)");
        this.leftText = (TextView) inflate.findViewById(R.id.leftText);
        this.rightText = (TextView) inflate.findViewById(R.id.rightText);
        this.leftCon = (RelativeLayout) inflate.findViewById(R.id.leftCon);
        this.rightCon = (RelativeLayout) inflate.findViewById(R.id.rightCon);
        this.leftIndex = inflate.findViewById(R.id.leftIndex);
        this.rightIndex = inflate.findViewById(R.id.rightIndex);
        TextView textView = this.leftText;
        if (textView != null) {
            textView.setText(com.mobile.brasiltv.utils.b0.z(R.string.live_channel));
        }
        TextView textView2 = this.leftText;
        if (textView2 != null) {
            textView2.setTextSize(2, this.leftTextSize);
        }
        TextView textView3 = this.leftText;
        if (textView3 != null) {
            textView3.setTextColor(this.leftTextColor);
        }
        TextView textView4 = this.rightText;
        if (textView4 != null) {
            textView4.setText(com.mobile.brasiltv.utils.b0.z(R.string.live_fav));
        }
        TextView textView5 = this.rightText;
        if (textView5 != null) {
            textView5.setTextSize(2, this.rightTextSize);
        }
        TextView textView6 = this.rightText;
        if (textView6 != null) {
            textView6.setTextColor(this.rightTextColor);
        }
        View view = this.leftIndex;
        if (view != null) {
            view.setBackgroundColor(this.selectIndexColor);
        }
        View view2 = this.rightIndex;
        if (view2 != null) {
            view2.setBackgroundColor(this.selectIndexColor);
        }
        RelativeLayout relativeLayout = this.leftCon;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveFragmentTabLayout.initView$lambda$1(LiveFragmentTabLayout.this, view3);
                }
            });
        }
        RelativeLayout relativeLayout2 = this.rightCon;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveFragmentTabLayout.initView$lambda$2(LiveFragmentTabLayout.this, view3);
                }
            });
        }
        selectedLeftText();
    }

    public final void selectedLeftText() {
        TextView textView = this.leftText;
        if (textView != null) {
            textView.setTextColor(this.selectTextColor);
        }
        TextView textView2 = this.rightText;
        if (textView2 != null) {
            textView2.setTextColor(this.rightTextColor);
        }
        View view = this.leftIndex;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.rightIndex;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void selectedRightText() {
        TextView textView = this.rightText;
        if (textView != null) {
            textView.setTextColor(this.selectTextColor);
        }
        TextView textView2 = this.leftText;
        if (textView2 != null) {
            textView2.setTextColor(this.rightTextColor);
        }
        View view = this.rightIndex;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.leftIndex;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void setOnClickListener(TabOnClickListener tabOnClickListener) {
        t9.i.g(tabOnClickListener, "onClickListener");
        this.onClickListener = tabOnClickListener;
    }

    public LiveFragmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFragmentTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this._$_findViewCache = new LinkedHashMap();
        this.leftTextColor = -16776961;
        this.rightTextColor = -16776961;
        this.selectIndexColor = -16776961;
        this.selectTextColor = -16776961;
        this.leftTextSize = 10;
        this.rightTextSize = 10;
        this.selectLeft = true;
        initView(context, attributeSet);
    }
}
