package f4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import h4.e;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(ValueAnimator valueAnimator) {
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public static boolean b(e... eVarArr) {
        for (e eVar : eVarArr) {
            if (eVar.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static void c(Animator animator) {
        if (animator == null || animator.isStarted()) {
            return;
        }
        animator.start();
    }

    public static void d(e... eVarArr) {
        for (e eVar : eVarArr) {
            eVar.start();
        }
    }

    public static void e(e... eVarArr) {
        for (e eVar : eVarArr) {
            eVar.stop();
        }
    }
}
