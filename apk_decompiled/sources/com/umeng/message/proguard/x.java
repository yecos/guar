package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class x {

    /* renamed from: b, reason: collision with root package name */
    private static volatile x f12217b;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<ad> f12218a = new LinkedList<>();

    private x() {
    }

    public static x a() {
        if (f12217b == null) {
            synchronized (x.class) {
                if (f12217b == null) {
                    f12217b = new x();
                }
            }
        }
        return f12217b;
    }

    public final ad b() {
        ad pollFirst;
        synchronized (this.f12218a) {
            pollFirst = this.f12218a.pollFirst();
        }
        return pollFirst;
    }

    public final int c() {
        int size;
        synchronized (this.f12218a) {
            size = this.f12218a.size();
        }
        return size;
    }

    public final void b(ad adVar) {
        synchronized (this.f12218a) {
            this.f12218a.remove(adVar);
        }
    }

    public final void a(ad adVar) {
        synchronized (this.f12218a) {
            this.f12218a.addLast(adVar);
        }
    }

    public final ad a(String str) {
        synchronized (this.f12218a) {
            Iterator<ad> it = this.f12218a.iterator();
            while (it.hasNext()) {
                ad next = it.next();
                UMessage uMessage = next.f11454b;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
