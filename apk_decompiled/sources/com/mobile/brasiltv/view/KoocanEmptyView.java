package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class KoocanEmptyView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private AnimationDrawable loading;
    private ReloadListener reloadListener;
    private Type viewType;

    public interface ReloadListener {
        void onClick();
    }

    public enum Type {
        NO_CONTENT,
        NO_WIFI,
        NO_DISCUSS,
        NO_COLLECT,
        NO_MSG,
        NO_PLAY,
        NO_ORDER,
        LOADING,
        NO_BESPEAK,
        NO_LIVE_ORDER,
        NO_SEARCH
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.NO_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.NO_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.NO_DISCUSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.NO_COLLECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Type.NO_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Type.NO_PLAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Type.NO_ORDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Type.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Type.NO_LIVE_ORDER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Type.NO_BESPEAK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Type.NO_SEARCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
    }

    private final Type changeNum2Type(int i10) {
        switch (i10) {
        }
        return Type.NO_CONTENT;
    }

    private final void configView() {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KoocanEmptyView.configView$lambda$1(KoocanEmptyView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configView$lambda$1(KoocanEmptyView koocanEmptyView, View view) {
        t9.i.g(koocanEmptyView, "this$0");
        ReloadListener reloadListener = koocanEmptyView.reloadListener;
        if (reloadListener == null || koocanEmptyView.viewType != Type.NO_WIFI) {
            return;
        }
        reloadListener.onClick();
        koocanEmptyView.changeType(Type.LOADING);
    }

    private final void initView(Context context, int i10) {
        LayoutInflater.from(context).inflate(R.layout.koocan_empty, this);
        changeType(changeNum2Type(i10));
    }

    private final void intView(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f7787g, i10, i10);
        t9.i.f(obtainStyledAttributes, "context.theme.obtainStyl…fStyleAttr, defStyleAttr)");
        int i11 = obtainStyledAttributes.getInt(1, 1);
        int color = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.color_secondary_background));
        initView(context, i11);
        setBackground(color);
        configView();
    }

    private final void setTip(int i10) {
        ((TextView) _$_findCachedViewById(R$id.koocanEmptyTip)).setText(com.mobile.brasiltv.utils.b0.z(i10));
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

    public final void changeType(Type type) {
        t9.i.g(type, "type");
        this.viewType = type;
        if (type == Type.LOADING) {
            ((LinearLayout) _$_findCachedViewById(R$id.koocanEmptyLayout)).setVisibility(8);
            ((ProgressBar) _$_findCachedViewById(R$id.koocanLoadLayout)).setVisibility(0);
        } else {
            ((LinearLayout) _$_findCachedViewById(R$id.koocanEmptyLayout)).setVisibility(0);
            ((ProgressBar) _$_findCachedViewById(R$id.koocanLoadLayout)).setVisibility(8);
        }
        int i10 = R$id.koocanEmptyRefreshTip;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                setTip(R.string.koocan_no_content);
                break;
            case 2:
                setTip(R.string.koocan_no_net);
                if (this.reloadListener != null) {
                    ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
                    break;
                }
                break;
            case 3:
                setTip(R.string.koocan_no_discuss);
                break;
            case 4:
                setTip(R.string.koocan_no_collect);
                break;
            case 5:
                setTip(R.string.koocan_no_msg);
                break;
            case 6:
                setTip(R.string.koocan_no_play);
                break;
            case 7:
                setTip(R.string.koocan_no_order);
                break;
            case 9:
                setTip(R.string.channel_live_advance_no);
                break;
            case 10:
                setTip(R.string.live_order_no_hint_top);
                break;
            case 11:
                setTip(R.string.live_order_no_hint_top);
                break;
        }
    }

    public final AnimationDrawable getLoading() {
        return this.loading;
    }

    public final ReloadListener getReloadListener() {
        return this.reloadListener;
    }

    public final Type getViewType() {
        return this.viewType;
    }

    public final void setBackground(int i10) {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setBackgroundColor(i10);
    }

    public final void setBackgroundDrawable(int i10) {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setBackgroundResource(i10);
    }

    public final void setLoading(AnimationDrawable animationDrawable) {
        this.loading = animationDrawable;
    }

    public final void setReloadListener(ReloadListener reloadListener) {
        this.reloadListener = reloadListener;
        if (this.viewType == Type.NO_WIFI) {
            ((TextView) _$_findCachedViewById(R$id.koocanEmptyRefreshTip)).setVisibility(0);
        }
    }

    public final void setTextImageMarginTop(int i10) {
        int i11 = R$id.koocanEmptyTip;
        ViewGroup.LayoutParams layoutParams = ((TextView) _$_findCachedViewById(i11)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i10;
        ((TextView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
    }

    public final void setViewType(Type type) {
        t9.i.g(type, "<set-?>");
        this.viewType = type;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        AnimationDrawable animationDrawable;
        if (i10 == 0) {
            AnimationDrawable animationDrawable2 = this.loading;
            if (animationDrawable2 != null) {
                animationDrawable2.start();
            }
        } else if ((i10 == 4 || i10 == 8) && (animationDrawable = this.loading) != null) {
            animationDrawable.stop();
        }
        super.setVisibility(i10);
    }

    public final void setTip(String str) {
        t9.i.g(str, "str");
        ((TextView) _$_findCachedViewById(R$id.koocanEmptyTip)).setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        intView(context, attributeSet, 0);
    }

    private final void initView(Type type) {
        LayoutInflater.from(getContext()).inflate(R.layout.koocan_empty, this);
        changeType(type);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        intView(context, attributeSet, i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, Type type) {
        super(context);
        t9.i.g(type, "type");
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        initView(type);
        configView();
    }

    public /* synthetic */ KoocanEmptyView(Context context, Type type, int i10, t9.g gVar) {
        this(context, (i10 & 2) != 0 ? Type.NO_CONTENT : type);
    }
}
