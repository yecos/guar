package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<SessionRequest, List<Session>> f3942a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f3943b;

    /* renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f3944c;

    /* renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f3945d;

    public e() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f3943b = reentrantReadWriteLock;
        this.f3944c = reentrantReadWriteLock.readLock();
        this.f3945d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.a() == null || session == null) {
            return;
        }
        this.f3945d.lock();
        try {
            List<Session> list = this.f3942a.get(sessionRequest);
            if (list == null) {
                list = new ArrayList<>();
                this.f3942a.put(sessionRequest, list);
            }
            if (list.indexOf(session) != -1) {
                return;
            }
            list.add(session);
            Collections.sort(list);
        } finally {
            this.f3945d.unlock();
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f3945d.lock();
        try {
            List<Session> list = this.f3942a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.f3942a.remove(sessionRequest);
            }
        } finally {
            this.f3945d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f3944c.lock();
        try {
            List<Session> list = this.f3942a.get(sessionRequest);
            boolean z10 = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            this.f3944c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f3944c.lock();
        try {
            List<Session> list = this.f3942a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f3944c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i10) {
        this.f3944c.lock();
        try {
            List<Session> list = this.f3942a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i10 == anet.channel.entity.c.f3974c || session2.f3821j.getType() == i10)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f3944c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f3944c.lock();
        try {
            return this.f3942a.isEmpty() ? list : new ArrayList(this.f3942a.keySet());
        } finally {
            this.f3944c.unlock();
        }
    }
}
