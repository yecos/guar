package com.hpplay.sdk.source.b;

import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7427a = "CastManager";

    /* renamed from: b, reason: collision with root package name */
    private static a f7428b;

    /* renamed from: c, reason: collision with root package name */
    private final List<INewPlayerListener> f7429c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final INewPlayerListener f7430d = new INewPlayerListener() { // from class: com.hpplay.sdk.source.b.a.1
        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onCompletion(CastBean castBean, int i10) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onCompletion(castBean, i10);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onError(CastBean castBean, int i10, int i11) {
            SourceLog.i(a.f7427a, "onError what:" + i10 + " extra:" + i11);
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onError(castBean, i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, int i11) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onInfo(castBean, i10, i11);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onLoading(CastBean castBean) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onLoading(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPause(CastBean castBean) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onPause(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onPositionUpdate(CastBean castBean, long j10, long j11) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onPositionUpdate(castBean, j10, j11);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onSeekComplete(CastBean castBean, int i10) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onSeekComplete(castBean, i10);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStart(CastBean castBean) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onStart(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onStop(CastBean castBean) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onStop(castBean);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onVolumeChanged(CastBean castBean, float f10) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onVolumeChanged(castBean, f10);
            }
        }

        @Override // com.hpplay.sdk.source.api.INewPlayerListener
        public void onInfo(CastBean castBean, int i10, String str) {
            Iterator it = a.this.f7429c.iterator();
            while (it.hasNext()) {
                ((INewPlayerListener) it.next()).onInfo(castBean, i10, str);
            }
        }
    };

    private a() {
    }

    public INewPlayerListener b() {
        return this.f7430d;
    }

    public static synchronized a a() {
        synchronized (a.class) {
            synchronized (a.class) {
                if (f7428b == null) {
                    f7428b = new a();
                }
            }
            return f7428b;
        }
        return f7428b;
    }

    public void b(INewPlayerListener iNewPlayerListener) {
        this.f7429c.remove(iNewPlayerListener);
    }

    public void a(INewPlayerListener iNewPlayerListener) {
        this.f7429c.add(iNewPlayerListener);
    }
}
