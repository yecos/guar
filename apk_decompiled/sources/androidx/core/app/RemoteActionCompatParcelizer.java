package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import y0.b;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2015a = (IconCompat) bVar.v(remoteActionCompat.f2015a, 1);
        remoteActionCompat.f2016b = bVar.l(remoteActionCompat.f2016b, 2);
        remoteActionCompat.f2017c = bVar.l(remoteActionCompat.f2017c, 3);
        remoteActionCompat.f2018d = (PendingIntent) bVar.r(remoteActionCompat.f2018d, 4);
        remoteActionCompat.f2019e = bVar.h(remoteActionCompat.f2019e, 5);
        remoteActionCompat.f2020f = bVar.h(remoteActionCompat.f2020f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.x(false, false);
        bVar.M(remoteActionCompat.f2015a, 1);
        bVar.D(remoteActionCompat.f2016b, 2);
        bVar.D(remoteActionCompat.f2017c, 3);
        bVar.H(remoteActionCompat.f2018d, 4);
        bVar.z(remoteActionCompat.f2019e, 5);
        bVar.z(remoteActionCompat.f2020f, 6);
    }
}
