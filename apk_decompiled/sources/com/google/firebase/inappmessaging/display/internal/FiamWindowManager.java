package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FiamWindowManager {
    static final int DEFAULT_TYPE = 1003;
    private BindingWrapper bindingWrapper;

    @Inject
    public FiamWindowManager() {
    }

    private Point getDisplaySize(Activity activity) {
        Point point = new Point();
        getWindowManager(activity).getDefaultDisplay().getRealSize(point);
        return point;
    }

    private Rect getInsetDimensions(Activity activity) {
        Rect rect = new Rect();
        Rect visibleFrame = getVisibleFrame(activity);
        Point displaySize = getDisplaySize(activity);
        rect.top = visibleFrame.top;
        rect.left = visibleFrame.left;
        rect.right = displaySize.x - visibleFrame.right;
        rect.bottom = displaySize.y - visibleFrame.bottom;
        return rect;
    }

    private WindowManager.LayoutParams getLayoutParams(InAppMessageLayoutConfig inAppMessageLayoutConfig, Activity activity) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(inAppMessageLayoutConfig.windowWidth().intValue(), inAppMessageLayoutConfig.windowHeight().intValue(), 1003, inAppMessageLayoutConfig.windowFlag().intValue(), -3);
        Rect insetDimensions = getInsetDimensions(activity);
        if ((inAppMessageLayoutConfig.viewWindowGravity().intValue() & 48) == 48) {
            layoutParams.y = insetDimensions.top;
        }
        layoutParams.dimAmount = 0.3f;
        layoutParams.gravity = inAppMessageLayoutConfig.viewWindowGravity().intValue();
        layoutParams.windowAnimations = 0;
        return layoutParams;
    }

    private SwipeDismissTouchListener getSwipeListener(InAppMessageLayoutConfig inAppMessageLayoutConfig, final BindingWrapper bindingWrapper, final WindowManager windowManager, final WindowManager.LayoutParams layoutParams) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks = new SwipeDismissTouchListener.DismissCallbacks() { // from class: com.google.firebase.inappmessaging.display.internal.FiamWindowManager.1
            @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks
            public boolean canDismiss(Object obj) {
                return true;
            }

            @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks
            public void onDismiss(View view, Object obj) {
                if (bindingWrapper.getDismissListener() != null) {
                    bindingWrapper.getDismissListener().onClick(view);
                }
            }
        };
        return inAppMessageLayoutConfig.windowWidth().intValue() == -1 ? new SwipeDismissTouchListener(bindingWrapper.getDialogView(), null, dismissCallbacks) : new SwipeDismissTouchListener(bindingWrapper.getDialogView(), null, dismissCallbacks) { // from class: com.google.firebase.inappmessaging.display.internal.FiamWindowManager.2
            @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener
            public float getTranslationX() {
                return layoutParams.x;
            }

            @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener
            public void setTranslationX(float f10) {
                layoutParams.x = (int) f10;
                windowManager.updateViewLayout(bindingWrapper.getRootView(), layoutParams);
            }
        };
    }

    private Rect getVisibleFrame(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    private WindowManager getWindowManager(Activity activity) {
        return (WindowManager) activity.getSystemService("window");
    }

    public void destroy(Activity activity) {
        if (isFiamDisplayed()) {
            getWindowManager(activity).removeViewImmediate(this.bindingWrapper.getRootView());
            this.bindingWrapper = null;
        }
    }

    public boolean isFiamDisplayed() {
        BindingWrapper bindingWrapper = this.bindingWrapper;
        if (bindingWrapper == null) {
            return false;
        }
        return bindingWrapper.getRootView().isShown();
    }

    public void show(BindingWrapper bindingWrapper, Activity activity) {
        if (isFiamDisplayed()) {
            Logging.loge("Fiam already active. Cannot show new Fiam.");
            return;
        }
        if (activity.isFinishing()) {
            Logging.loge("Activity is finishing or does not have valid window token. Cannot show FIAM.");
            return;
        }
        InAppMessageLayoutConfig config = bindingWrapper.getConfig();
        WindowManager.LayoutParams layoutParams = getLayoutParams(config, activity);
        WindowManager windowManager = getWindowManager(activity);
        windowManager.addView(bindingWrapper.getRootView(), layoutParams);
        Rect insetDimensions = getInsetDimensions(activity);
        Logging.logdPair("Inset (top, bottom)", insetDimensions.top, insetDimensions.bottom);
        Logging.logdPair("Inset (left, right)", insetDimensions.left, insetDimensions.right);
        if (bindingWrapper.canSwipeToDismiss()) {
            bindingWrapper.getDialogView().setOnTouchListener(getSwipeListener(config, bindingWrapper, windowManager, layoutParams));
        }
        this.bindingWrapper = bindingWrapper;
    }
}
