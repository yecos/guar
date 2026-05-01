package com.mobile.brasiltv.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.view.DropDownPop;
import com.mobile.brasiltv.view.dialog.AccountRemoveDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DropDownListView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private ImageView mArrowImg;
    private ArrayList<SwitchAccountBean> mData;
    private final DropDownPop mPop;
    private s9.p mRemoveListener;
    private int mSelectPos;
    private TextView mTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DropDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(attributeSet, "attr");
        this._$_findViewCache = new LinkedHashMap();
        this.mPop = new DropDownPop(context);
        this.mData = new ArrayList<>();
        initView();
        initListener();
    }

    private final void initListener() {
        this.mPop.setItemClickListener(new DropDownPop.OnItemClickListener() { // from class: com.mobile.brasiltv.view.DropDownListView$initListener$1
            @Override // com.mobile.brasiltv.view.DropDownPop.OnItemClickListener
            public void onItemClick(int i10, SwitchAccountBean switchAccountBean) {
                TextView textView;
                t9.i.g(switchAccountBean, "bean");
                DropDownListView.this.mSelectPos = i10;
                textView = DropDownListView.this.mTextView;
                if (textView == null) {
                    t9.i.w("mTextView");
                    textView = null;
                }
                textView.setText(switchAccountBean.getShowName());
            }

            @Override // com.mobile.brasiltv.view.DropDownPop.OnItemClickListener
            public void onItemRemoveClick(int i10, String str, SwitchAccountBean switchAccountBean) {
                t9.i.g(str, "account");
                t9.i.g(switchAccountBean, "bean");
                Context context = DropDownListView.this.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                new AccountRemoveDialog(context, str, new DropDownListView$initListener$1$onItemRemoveClick$1(DropDownListView.this, i10, switchAccountBean), DropDownListView$initListener$1$onItemRemoveClick$2.INSTANCE).show();
            }
        });
        this.mPop.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.mobile.brasiltv.view.g
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                DropDownListView.initListener$lambda$0(DropDownListView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(DropDownListView dropDownListView) {
        t9.i.g(dropDownListView, "this$0");
        dropDownListView.rotateArrow(false);
    }

    private final void initView() {
        setFocusable(true);
        setClickable(true);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.bg_dropdown_recentlogins);
        int percentWidthSize = AutoUtils.getPercentWidthSize(20);
        setPadding(percentWidthSize, 0, percentWidthSize, 0);
        TextView textView = new TextView(getContext());
        this.mTextView = textView;
        textView.setTextColor(-1);
        TextView textView2 = this.mTextView;
        View view = null;
        if (textView2 == null) {
            t9.i.w("mTextView");
            textView2 = null;
        }
        textView2.setSingleLine();
        TextView textView3 = this.mTextView;
        if (textView3 == null) {
            t9.i.w("mTextView");
            textView3 = null;
        }
        textView3.setGravity(16);
        TextView textView4 = this.mTextView;
        if (textView4 == null) {
            t9.i.w("mTextView");
            textView4 = null;
        }
        textView4.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        TextView textView5 = this.mTextView;
        if (textView5 == null) {
            t9.i.w("mTextView");
            textView5 = null;
        }
        textView5.setTextSize(0, AutoUtils.getPercentWidthSize(32));
        AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        View view2 = this.mTextView;
        if (view2 == null) {
            t9.i.w("mTextView");
            view2 = null;
        }
        addView(view2, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.mArrowImg = imageView;
        imageView.setImageResource(R.drawable.ic_dropdown_arrow_new);
        ViewGroup.LayoutParams layoutParams2 = new AutoLinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(25), AutoUtils.getPercentHeightSize(18));
        View view3 = this.mArrowImg;
        if (view3 == null) {
            t9.i.w("mArrowImg");
        } else {
            view = view3;
        }
        addView(view, layoutParams2);
    }

    private final void rotateArrow(boolean z10) {
        ObjectAnimator ofFloat;
        ImageView imageView = null;
        if (z10) {
            ImageView imageView2 = this.mArrowImg;
            if (imageView2 == null) {
                t9.i.w("mArrowImg");
            } else {
                imageView = imageView2;
            }
            ofFloat = ObjectAnimator.ofFloat(imageView, ParamsMap.MirrorParams.KEY_ROTATION, 0.0f, 180.0f);
        } else {
            ImageView imageView3 = this.mArrowImg;
            if (imageView3 == null) {
                t9.i.w("mArrowImg");
            } else {
                imageView = imageView3;
            }
            ofFloat = ObjectAnimator.ofFloat(imageView, ParamsMap.MirrorParams.KEY_ROTATION, 180.0f, 0.0f);
        }
        ofFloat.setDuration(200L);
        ofFloat.start();
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

    public final void attachDataToView(ArrayList<SwitchAccountBean> arrayList) {
        t9.i.g(arrayList, "data");
        this.mData.clear();
        this.mData.addAll(arrayList);
        this.mPop.setData(arrayList);
        setClickable(!arrayList.isEmpty());
        if (!(!arrayList.isEmpty()) || this.mSelectPos >= arrayList.size()) {
            setText("");
            return;
        }
        SwitchAccountBean switchAccountBean = arrayList.get(this.mSelectPos);
        t9.i.f(switchAccountBean, "data[mSelectPos]");
        setText(switchAccountBean.getShowName());
    }

    public final SwitchAccountBean getSelectAccount() {
        SwitchAccountBean switchAccountBean = this.mData.get(this.mSelectPos);
        t9.i.f(switchAccountBean, "mData[mSelectPos]");
        return switchAccountBean;
    }

    public final String getText() {
        TextView textView = this.mTextView;
        if (textView == null) {
            t9.i.w("mTextView");
            textView = null;
        }
        return textView.getText().toString();
    }

    @Override // android.view.View
    public boolean performClick() {
        rotateArrow(true);
        this.mPop.showAsDropDown(this, 0, AutoUtils.getPercentHeightSize(5));
        return super.performClick();
    }

    public final void setRemoveAccountListener(s9.p pVar) {
        t9.i.g(pVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mRemoveListener = pVar;
    }

    public final void setText(String str) {
        t9.i.g(str, "content");
        TextView textView = this.mTextView;
        if (textView == null) {
            t9.i.w("mTextView");
            textView = null;
        }
        textView.setText(str);
    }
}
