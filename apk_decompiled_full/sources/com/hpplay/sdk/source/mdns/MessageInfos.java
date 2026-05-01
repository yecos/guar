package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class MessageInfos {
    WeakReference<Object> ids;
    WeakReference<ResolverListener> listener;
    WeakReference<Message> message;

    public WeakReference<Object> getIds() {
        return this.ids;
    }

    public WeakReference<ResolverListener> getListener() {
        return this.listener;
    }

    public WeakReference<Message> getMessage() {
        return this.message;
    }

    public void setIds(Object obj) {
        this.ids = new WeakReference<>(obj);
    }

    public void setListener(ResolverListener resolverListener) {
        this.listener = new WeakReference<>(resolverListener);
    }

    public void setMessage(Message message) {
        this.message = new WeakReference<>(message);
    }
}
