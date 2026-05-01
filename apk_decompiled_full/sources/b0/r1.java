package b0;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R$id;

/* loaded from: classes.dex */
public abstract class r1 {
    public static boolean a(ViewGroup viewGroup) {
        boolean isTransitionGroup;
        if (Build.VERSION.SDK_INT >= 21) {
            isTransitionGroup = viewGroup.isTransitionGroup();
            return isTransitionGroup;
        }
        Boolean bool = (Boolean) viewGroup.getTag(R$id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && c1.I(viewGroup) == null) ? false : true;
    }
}
