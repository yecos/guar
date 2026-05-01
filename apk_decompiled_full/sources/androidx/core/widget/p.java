package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public abstract class p {
    public static boolean a(ListView listView, int i10) {
        return listView.canScrollList(i10);
    }

    public static void b(ListView listView, int i10) {
        listView.scrollListBy(i10);
    }
}
