package com.mobile.brasiltv.view.dialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.config.AutoLayoutConifg;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class GuideDialog extends Dialog {
    public static final Companion Companion = new Companion(null);
    private static boolean mIsShowing;
    private final String TAG;
    private String mButtonText;
    private String mContentText;
    private View mCustomGuideView;
    private int mCustomGuideViewId;
    private final int[] mCustomOffset;
    private Direction mDirection;
    private final Html.ImageGetter mImageGetter;
    private boolean mIsFullScreen;
    private boolean mIsLandScreen;
    private s9.a mListener;
    private final int[] mTargetLocation;
    private View mTargetView;
    private View mView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(t9.g gVar) {
            this();
        }

        public static /* synthetic */ void getMIsShowing$annotations() {
        }

        public final boolean getMIsShowing() {
            return GuideDialog.mIsShowing;
        }

        public final void setMIsShowing(boolean z10) {
            GuideDialog.mIsShowing = z10;
        }
    }

    public enum Direction {
        DOWN_RIGHT,
        DOWN_LEFT,
        TOP_RIGHT,
        TOP_LEFT,
        RIGHT,
        LEFT
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.DOWN_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.DOWN_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.TOP_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Direction.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Direction.RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideDialog(final Context context) {
        super(context, R.style.guideDialgTheme);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.TAG = GuideDialog.class.getSimpleName();
        this.mDirection = Direction.DOWN_RIGHT;
        this.mTargetLocation = new int[2];
        this.mCustomOffset = new int[2];
        this.mContentText = "";
        this.mButtonText = "";
        this.mImageGetter = new Html.ImageGetter() { // from class: com.mobile.brasiltv.view.dialog.b0
            @Override // android.text.Html.ImageGetter
            public final Drawable getDrawable(String str) {
                Drawable mImageGetter$lambda$6;
                mImageGetter$lambda$6 = GuideDialog.mImageGetter$lambda$6(context, str);
                return mImageGetter$lambda$6;
            }
        };
    }

    private final void fullScreenImmersive(View view) {
        view.setSystemUiVisibility(5894);
    }

    private final void getCustomViewById() {
        if (this.mCustomGuideViewId > 0) {
            this.mCustomGuideView = View.inflate(getContext(), this.mCustomGuideViewId, null);
        }
        View view = this.mCustomGuideView;
        if (view != null) {
            TextView textView = view != null ? (TextView) view.findViewWithTag("mTvSure") : null;
            View view2 = this.mCustomGuideView;
            TextView textView2 = view2 != null ? (TextView) view2.findViewWithTag("mTextContent") : null;
            if ((this.mButtonText.length() > 0) && textView != null) {
                textView.setText(this.mButtonText);
            }
            if ((this.mContentText.length() > 0) && textView2 != null) {
                textView2.setText(this.mContentText);
            }
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.d0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        GuideDialog.getCustomViewById$lambda$3(GuideDialog.this, view3);
                    }
                });
            }
            if (textView2 != null) {
                textView2.setText(Html.fromHtml(String.valueOf(textView2.getText()), this.mImageGetter, null));
            }
            View view3 = this.mCustomGuideView;
            ImageView imageView = view3 != null ? (ImageView) view3.findViewWithTag("mThumbnailArrow") : null;
            if (imageView != null) {
                initThumbnailArrow(imageView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCustomViewById$lambda$3(GuideDialog guideDialog, View view) {
        t9.i.g(guideDialog, "this$0");
        guideDialog.dismiss();
    }

    public static final boolean getMIsShowing() {
        return Companion.getMIsShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlerLocation(View view) {
        if (this.mIsFullScreen && !this.mIsLandScreen) {
            int a10 = n5.a.f17268a.a(getContext());
            int[] iArr = this.mTargetLocation;
            iArr[1] = iArr[1] - a10;
        }
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setDrawingCacheEnabled(true);
        }
        Bitmap drawingCache = view.getDrawingCache();
        int i10 = R$id.mImgTarget;
        ((ImageView) findViewById(i10)).setImageBitmap(drawingCache);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
        int[] iArr2 = this.mTargetLocation;
        layoutParams.leftMargin = iArr2[0];
        layoutParams.topMargin = iArr2[1];
        ((ImageView) findViewById(i10)).setLayoutParams(layoutParams);
        initCustomView();
    }

    private final void initCustomView() {
        getCustomViewById();
        View view = this.mCustomGuideView;
        if (view != null) {
            ((AutoRelativeLayout) findViewById(R$id.mLayoutRoot)).addView(view);
            int screenWidth = AutoLayoutConifg.getInstance().getScreenWidth();
            View.MeasureSpec.makeMeasureSpec(screenWidth, Integer.MIN_VALUE);
            view.measure(screenWidth, -1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            switch (WhenMappings.$EnumSwitchMapping$0[this.mDirection.ordinal()]) {
                case 1:
                    int measuredHeight = this.mTargetLocation[1] - view.getMeasuredHeight();
                    int[] iArr = this.mCustomOffset;
                    layoutParams.topMargin = measuredHeight + iArr[1];
                    layoutParams.rightMargin = iArr[0];
                    layoutParams.addRule(7, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    break;
                case 2:
                    int measuredHeight2 = this.mTargetLocation[1] - view.getMeasuredHeight();
                    int[] iArr2 = this.mCustomOffset;
                    layoutParams.topMargin = measuredHeight2 + iArr2[1];
                    layoutParams.leftMargin = iArr2[0];
                    layoutParams.addRule(5, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    break;
                case 3:
                    layoutParams.addRule(3, R.id.mImgTarget);
                    layoutParams.addRule(7, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    int[] iArr3 = this.mCustomOffset;
                    layoutParams.topMargin = iArr3[1];
                    layoutParams.rightMargin = iArr3[0];
                    break;
                case 4:
                    layoutParams.addRule(3, R.id.mImgTarget);
                    layoutParams.addRule(5, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    int[] iArr4 = this.mCustomOffset;
                    layoutParams.topMargin = iArr4[1];
                    layoutParams.leftMargin = iArr4[0];
                    break;
                case 5:
                    int[] iArr5 = this.mTargetLocation;
                    layoutParams.topMargin = iArr5[1];
                    layoutParams.leftMargin = (iArr5[0] - view.getMeasuredWidth()) + this.mCustomOffset[1];
                    break;
                case 6:
                    layoutParams.addRule(0, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    layoutParams.leftMargin = this.mCustomOffset[1];
                    break;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private final void initGuide() {
        initTargetView();
    }

    private final void initTargetView() {
        final View view = this.mTargetView;
        if (view != null) {
            view.getLocationInWindow(this.mTargetLocation);
            int[] iArr = this.mTargetLocation;
            if ((iArr[0] == 0 && iArr[1] == 0) || view.getWidth() == 0) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.mobile.brasiltv.view.dialog.GuideDialog$initTargetView$1$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int[] iArr2;
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        View view2 = view;
                        iArr2 = this.mTargetLocation;
                        view2.getLocationInWindow(iArr2);
                        this.handlerLocation(view);
                    }
                });
            } else {
                handlerLocation(view);
            }
        }
    }

    private final void initThumbnailArrow(ImageView imageView) {
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, AutoUtils.getPercentHeightSize(70));
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        imageView.setOnKeyListener(new View.OnKeyListener() { // from class: com.mobile.brasiltv.view.dialog.e0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                boolean initThumbnailArrow$lambda$5;
                initThumbnailArrow$lambda$5 = GuideDialog.initThumbnailArrow$lambda$5(ofFloat, this, view, i10, keyEvent);
                return initThumbnailArrow$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initThumbnailArrow$lambda$5(ObjectAnimator objectAnimator, GuideDialog guideDialog, View view, int i10, KeyEvent keyEvent) {
        t9.i.g(guideDialog, "this$0");
        if (keyEvent.getAction() == 0) {
            if (i10 != 4 && i10 != 66) {
                switch (i10) {
                }
            }
            objectAnimator.cancel();
            guideDialog.dismiss();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable mImageGetter$lambda$6(Context context, String str) {
        t9.i.g(context, "$context");
        Drawable drawable = context.getResources().getDrawable(context.getResources().getIdentifier(str, "mipmap", context.getPackageName()));
        drawable.setBounds(0, 0, AutoUtils.getPercentWidthSize(64), AutoUtils.getPercentHeightSize(36));
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(GuideDialog guideDialog, DialogInterface dialogInterface) {
        t9.i.g(guideDialog, "this$0");
        mIsShowing = false;
        s9.a aVar = guideDialog.mListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public static final void setMIsShowing(boolean z10) {
        Companion.setMIsShowing(z10);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_guide_base);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        initGuide();
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobile.brasiltv.view.dialog.c0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GuideDialog.onCreate$lambda$0(GuideDialog.this, dialogInterface);
            }
        });
    }

    public final void setButtonText(String str) {
        t9.i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        this.mButtonText = str;
    }

    public final void setContentText(String str) {
        t9.i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        this.mContentText = str;
    }

    public final void setCustomGuideView(View view) {
        t9.i.g(view, "view");
        this.mCustomGuideView = view;
    }

    public final void setCustomOffset(int i10, int i11) {
        int[] iArr = this.mCustomOffset;
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final void setDirection(Direction direction) {
        t9.i.g(direction, "direction");
        this.mDirection = direction;
    }

    public final void setFullScreen(boolean z10) {
        this.mIsFullScreen = z10;
    }

    public final void setLandScreen(boolean z10) {
        this.mIsLandScreen = z10;
    }

    public final void setOnButtonClickListener(s9.a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = aVar;
    }

    public final void setTargetView(View view) {
        t9.i.g(view, "view");
        this.mTargetView = view;
    }

    @Override // android.app.Dialog
    public void show() {
        View decorView;
        Window window;
        if (this.mIsLandScreen && (window = getWindow()) != null) {
            window.addFlags(8);
        }
        super.show();
        mIsShowing = true;
        if (this.mIsLandScreen) {
            Window window2 = getWindow();
            if (window2 != null && (decorView = window2.getDecorView()) != null) {
                fullScreenImmersive(decorView);
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.clearFlags(8);
            }
        }
    }

    public final void setCustomGuideView(int i10) {
        this.mCustomGuideViewId = i10;
    }
}
