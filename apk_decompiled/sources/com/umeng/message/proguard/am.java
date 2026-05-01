package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class am {

    /* renamed from: b, reason: collision with root package name */
    Future<?> f11518b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<ap> f11519c = new LinkedList<>();

    /* renamed from: a, reason: collision with root package name */
    transient boolean f11517a = true;

    private void c() {
        Future<?> future = this.f11518b;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            UPLog.i("Pop", "cancel cache task", Boolean.valueOf(future.cancel(false)));
        }
        final LinkedList linkedList = new LinkedList();
        synchronized (this.f11519c) {
            if (!this.f11519c.isEmpty()) {
                linkedList.addAll(this.f11519c);
            }
        }
        this.f11517a = linkedList.isEmpty();
        UPLog.i("Pop", "save task", Integer.valueOf(linkedList.size()));
        this.f11518b = b.a(new Runnable() { // from class: com.umeng.message.proguard.am.2
            @Override // java.lang.Runnable
            public final void run() {
                am.this.f11518b = null;
                File a10 = bp.a(y.a());
                if (!linkedList.isEmpty()) {
                    bp.a(linkedList, a10);
                    UPLog.i("Pop", "save", linkedList);
                } else if (a10.exists()) {
                    a10.delete();
                    UPLog.i("Pop", "clear");
                }
            }
        }, 1L, TimeUnit.SECONDS);
    }

    public final void a(ap apVar) {
        synchronized (this.f11519c) {
            this.f11519c.addFirst(apVar);
            if (this.f11519c.size() > 1) {
                Collections.sort(this.f11519c, new Comparator<ap>() { // from class: com.umeng.message.proguard.am.1
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(ap apVar2, ap apVar3) {
                        return Long.signum(apVar2.f11535a.getMsgTime() - apVar3.f11535a.getMsgTime()) * (-1);
                    }
                });
            }
            int i10 = ak.a().c().f11524b;
            while (this.f11519c.size() > i10) {
                ap removeLast = this.f11519c.removeLast();
                try {
                    UPLog.i("Pop", "add unShow msgId", removeLast.f11535a.getMsgId());
                    UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
                    if (inAppMessageHandler != null) {
                        inAppMessageHandler.onMessageIgnored(y.a(), removeLast.f11535a);
                    }
                } catch (Throwable th) {
                    UPLog.e("Pop", th);
                }
            }
            c();
        }
    }

    public final boolean b(ap apVar) {
        boolean remove;
        synchronized (this.f11519c) {
            remove = this.f11519c.remove(apVar);
        }
        if (remove) {
            c();
        }
        return remove;
    }

    public final void b() {
        LinkedList linkedList = (LinkedList) bp.a(bp.a(y.a()));
        if (linkedList != null && !linkedList.isEmpty()) {
            synchronized (this.f11519c) {
                this.f11519c.clear();
                this.f11519c.addAll(linkedList);
            }
            this.f11517a = false;
        }
        if (this.f11517a) {
            return;
        }
        UPLog.i("Pop", "load", linkedList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00e2, code lost:
    
        c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.umeng.message.proguard.ap a() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.am.a():com.umeng.message.proguard.ap");
    }

    public final ap a(String str) {
        synchronized (this.f11519c) {
            Iterator<ap> it = this.f11519c.iterator();
            while (it.hasNext()) {
                ap next = it.next();
                UMessage uMessage = next.f11535a;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
