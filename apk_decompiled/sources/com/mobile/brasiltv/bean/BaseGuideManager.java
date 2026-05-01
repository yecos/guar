package com.mobile.brasiltv.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.e0;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public class BaseGuideManager {
    private final String content;
    private final Context context;
    private final GuideDialog.Direction diretion;
    private GuideNextClickListener guideNextClickListener;
    private final String introVersion;
    private final boolean isFullScreen;
    private boolean isLandScreen;
    private final String key;
    private BaseGuideManager next;
    private final String okStr;
    private final View tagerView;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GuideDialog.Direction.values().length];
            try {
                iArr[GuideDialog.Direction.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuideDialog.Direction.DOWN_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuideDialog.Direction.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuideDialog.Direction.DOWN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BaseGuideManager(Context context, View view, String str, String str2, GuideDialog.Direction direction, String str3, boolean z10, boolean z11, String str4) {
        i.g(str2, "content");
        i.g(direction, "diretion");
        this.context = context;
        this.tagerView = view;
        this.key = str;
        this.content = str2;
        this.diretion = direction;
        this.okStr = str3;
        this.isFullScreen = z10;
        this.isLandScreen = z11;
        this.introVersion = str4;
    }

    public final BaseGuideManager addNext(BaseGuideManager baseGuideManager) {
        i.g(baseGuideManager, "next");
        this.next = baseGuideManager;
        return baseGuideManager;
    }

    public final BaseGuideManager addNextRecursion(BaseGuideManager baseGuideManager) {
        i.g(baseGuideManager, "next");
        BaseGuideManager baseGuideManager2 = this;
        while (true) {
            BaseGuideManager baseGuideManager3 = baseGuideManager2.next;
            if (baseGuideManager3 == null) {
                baseGuideManager2.next = baseGuideManager;
                return baseGuideManager;
            }
            i.d(baseGuideManager3);
            baseGuideManager2 = baseGuideManager3;
        }
    }

    public void alreadyShow() {
        if (this.key == null) {
            return;
        }
        if (this.introVersion == null) {
            e0.f8646a.e(App.f8263e.a(), this.key, false);
        } else {
            e0.f8646a.d(App.f8263e.a(), this.key, this.introVersion);
        }
    }

    public final BaseGuideManager findFirstShow() {
        BaseGuideManager baseGuideManager = this;
        while (baseGuideManager != null && (!baseGuideManager.isShow() || baseGuideManager.key == null || this.context == null)) {
            baseGuideManager = baseGuideManager.next;
        }
        return baseGuideManager;
    }

    public final BaseGuideManager findNextShow() {
        BaseGuideManager baseGuideManager = this.next;
        while (baseGuideManager != null && !baseGuideManager.isShow()) {
            baseGuideManager = baseGuideManager.next;
        }
        return baseGuideManager;
    }

    public final String getContent() {
        return this.content;
    }

    public final Context getContext() {
        return this.context;
    }

    public final GuideDialog.Direction getDiretion() {
        return this.diretion;
    }

    public int getGuideLayoutResId() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.diretion.ordinal()];
        return i10 != 1 ? i10 != 2 ? (i10 == 3 || i10 != 4) ? R.layout.layout_guide_top_right : R.layout.layout_guide_down_left : R.layout.layout_guide_down_right : R.layout.layout_guide_top_left;
    }

    public final GuideNextClickListener getGuideNextClickListener() {
        return this.guideNextClickListener;
    }

    public final String getIntroVersion() {
        return this.introVersion;
    }

    public final String getKey() {
        return this.key;
    }

    public final BaseGuideManager getNext() {
        return this.next;
    }

    public final String getOkStr() {
        return this.okStr;
    }

    public final View getTagerView() {
        return this.tagerView;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isLandScreen() {
        return this.isLandScreen;
    }

    public boolean isShow() {
        if (this.key == null) {
            return true;
        }
        return this.introVersion == null ? e0.f8646a.a(App.f8263e.a(), this.key, true) : !i.b(e0.c(e0.f8646a, App.f8263e.a(), this.key, null, 4, null), this.introVersion);
    }

    public final void setGuideNextClickListener(GuideNextClickListener guideNextClickListener) {
        this.guideNextClickListener = guideNextClickListener;
    }

    public final void setLandScreen(boolean z10) {
        this.isLandScreen = z10;
    }

    public final void setNext(BaseGuideManager baseGuideManager) {
        this.next = baseGuideManager;
    }

    public final void showGuide() {
        Context context;
        if (GuideDialog.Companion.getMIsShowing()) {
            return;
        }
        if (isShow() && (context = this.context) != null) {
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) context).isFinishing()) {
                return;
            }
            alreadyShow();
            showGuideInner(this.context, this.tagerView);
            return;
        }
        BaseGuideManager findFirstShow = findFirstShow();
        GuideNextClickListener guideNextClickListener = this.guideNextClickListener;
        if (guideNextClickListener != null && findFirstShow != null) {
            findFirstShow.guideNextClickListener = guideNextClickListener;
        }
        if (findFirstShow != null) {
            findFirstShow.showGuide();
        }
    }

    public void showGuideInner(Context context, View view) {
        i.g(context, f.X);
        if (view == null) {
            return;
        }
        GuideDialog guideDialog = new GuideDialog(context);
        guideDialog.setTargetView(view);
        guideDialog.setDirection(this.diretion);
        guideDialog.setFullScreen(this.isFullScreen);
        guideDialog.setLandScreen(this.isLandScreen);
        guideDialog.setContentText(this.content);
        if (b0.K(this.okStr)) {
            String str = this.okStr;
            i.d(str);
            guideDialog.setButtonText(str);
        } else {
            String string = findNextShow() == null ? context.getString(R.string.no_update_ok) : context.getString(R.string.next_step);
            i.f(string, "if (findNextShow == null….next_step)\n            }");
            guideDialog.setButtonText(string);
        }
        guideDialog.setCustomOffset(0, AutoUtils.getPercentHeightSize(0));
        guideDialog.setCustomGuideView(getGuideLayoutResId());
        guideDialog.setOnButtonClickListener(new BaseGuideManager$showGuideInner$1(this));
        guideDialog.show();
    }

    public final void showNext() {
        BaseGuideManager findNextShow = findNextShow();
        GuideNextClickListener guideNextClickListener = this.guideNextClickListener;
        if (guideNextClickListener != null) {
            guideNextClickListener.onGuideNextClick(this.key, findNextShow == null);
        }
        GuideNextClickListener guideNextClickListener2 = this.guideNextClickListener;
        if (guideNextClickListener2 != null && findNextShow != null) {
            findNextShow.guideNextClickListener = guideNextClickListener2;
        }
        if (findNextShow != null) {
            findNextShow.showGuide();
        }
    }

    public /* synthetic */ BaseGuideManager(Context context, View view, String str, String str2, GuideDialog.Direction direction, String str3, boolean z10, boolean z11, String str4, int i10, g gVar) {
        this(context, view, str, str2, direction, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? true : z10, (i10 & 128) != 0 ? false : z11, (i10 & 256) != 0 ? null : str4);
    }
}
