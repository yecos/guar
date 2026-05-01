package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

/* loaded from: classes.dex */
final class c implements IStrategyListener {
    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        String str;
        String str2;
        String str3;
        if (dVar == null || dVar.f4237b == null) {
            return;
        }
        int i10 = 0;
        loop0: while (true) {
            l.b[] bVarArr = dVar.f4237b;
            if (i10 >= bVarArr.length) {
                return;
            }
            l.b bVar = bVarArr[i10];
            str = bVar.f4222a;
            l.a[] aVarArr = bVar.f4229h;
            if (aVarArr != null && aVarArr.length > 0) {
                for (l.a aVar : aVarArr) {
                    String str4 = aVar.f4215b;
                    if (ConnType.HTTP3.equals(str4) || ConnType.HTTP3_PLAIN.equals(str4)) {
                        break loop0;
                    }
                }
            }
            i10++;
        }
        str2 = a.f3947b;
        if (!str.equals(str2)) {
            String unused = a.f3947b = str;
            SharedPreferences.Editor edit = a.f3951f.edit();
            str3 = a.f3947b;
            edit.putString("http3_detector_host", str3);
            edit.apply();
        }
        a.a(NetworkStatusHelper.getStatus());
    }
}
