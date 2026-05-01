package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.b;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f3287a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3288b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList f3289c = new a();

    /* renamed from: d, reason: collision with root package name */
    public final b.a f3290d = new b();

    public class a extends RemoteCallbackList {
        public a() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.a aVar, Object obj) {
            MultiInstanceInvalidationService.this.f3288b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends b.a {
        public b() {
        }

        @Override // androidx.room.b
        public void b(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f3289c) {
                String str = (String) MultiInstanceInvalidationService.this.f3288b.get(Integer.valueOf(i10));
                if (str == null) {
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f3289c.beginBroadcast();
                for (int i11 = 0; i11 < beginBroadcast; i11++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f3289c.getBroadcastCookie(i11)).intValue();
                        String str2 = (String) MultiInstanceInvalidationService.this.f3288b.get(Integer.valueOf(intValue));
                        if (i10 != intValue && str.equals(str2)) {
                            try {
                                ((androidx.room.a) MultiInstanceInvalidationService.this.f3289c.getBroadcastItem(i11)).a(strArr);
                            } catch (RemoteException unused) {
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.f3289c.finishBroadcast();
                    }
                }
            }
        }

        @Override // androidx.room.b
        public int d(androidx.room.a aVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f3289c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i10 = multiInstanceInvalidationService.f3287a + 1;
                multiInstanceInvalidationService.f3287a = i10;
                if (multiInstanceInvalidationService.f3289c.register(aVar, Integer.valueOf(i10))) {
                    MultiInstanceInvalidationService.this.f3288b.put(Integer.valueOf(i10), str);
                    return i10;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f3287a--;
                return 0;
            }
        }

        @Override // androidx.room.b
        public void g0(androidx.room.a aVar, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f3289c) {
                MultiInstanceInvalidationService.this.f3289c.unregister(aVar);
                MultiInstanceInvalidationService.this.f3288b.remove(Integer.valueOf(i10));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f3290d;
    }
}
