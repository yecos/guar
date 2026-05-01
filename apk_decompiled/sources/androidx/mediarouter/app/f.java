package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.mediarouter.R$bool;
import androidx.mediarouter.R$dimen;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f {
    public static int a(Context context) {
        return !context.getResources().getBoolean(R$bool.is_tablet) ? -1 : -2;
    }

    public static int b(Context context) {
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z10 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(z10 ? R$dimen.mr_dialog_fixed_width_minor : R$dimen.mr_dialog_fixed_width_major, typedValue, true);
        int i10 = typedValue.type;
        if (i10 == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else {
            if (i10 != 6) {
                return -2;
            }
            int i11 = displayMetrics.widthPixels;
            fraction = typedValue.getFraction(i11, i11);
        }
        return (int) fraction;
    }

    public static int c(Context context) {
        if (context.getResources().getBoolean(R$bool.is_tablet)) {
            return b(context);
        }
        return -1;
    }

    public static HashMap d(Context context, ListView listView, ArrayAdapter arrayAdapter) {
        HashMap hashMap = new HashMap();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i10 = 0; i10 < listView.getChildCount(); i10++) {
            hashMap.put(arrayAdapter.getItem(firstVisiblePosition + i10), h(context, listView.getChildAt(i10)));
        }
        return hashMap;
    }

    public static HashMap e(ListView listView, ArrayAdapter arrayAdapter) {
        HashMap hashMap = new HashMap();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i10 = 0; i10 < listView.getChildCount(); i10++) {
            Object item = arrayAdapter.getItem(firstVisiblePosition + i10);
            View childAt = listView.getChildAt(i10);
            hashMap.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
        }
        return hashMap;
    }

    public static Set f(List list, List list2) {
        HashSet hashSet = new HashSet(list2);
        hashSet.removeAll(list);
        return hashSet;
    }

    public static Set g(List list, List list2) {
        HashSet hashSet = new HashSet(list);
        hashSet.removeAll(list2);
        return hashSet;
    }

    public static BitmapDrawable h(Context context, View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    public static boolean i(List list, List list2) {
        return new HashSet(list).equals(new HashSet(list2));
    }
}
