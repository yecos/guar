package com.hpplay.component.protocol.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RequestManagerImp implements IRequstManager {
    protected long requestCount;
    private final List<IRequestHandler> running = Collections.synchronizedList(new ArrayList());

    @Override // com.hpplay.component.protocol.server.IRequstManager
    public void closeAll() {
        Iterator it = new ArrayList(this.running).iterator();
        while (it.hasNext()) {
            ((IRequestHandler) it.next()).close();
        }
    }

    @Override // com.hpplay.component.protocol.server.IRequstManager
    public void closed(IRequestHandler iRequestHandler) {
        this.running.remove(iRequestHandler);
    }

    public Thread createThread(IRequestHandler iRequestHandler) {
        Thread thread = new Thread((Runnable) iRequestHandler);
        thread.setDaemon(true);
        thread.setName("Request thread  " + this.requestCount);
        return thread;
    }

    @Override // com.hpplay.component.protocol.server.IRequstManager
    public void exec(IRequestHandler iRequestHandler) {
        this.requestCount++;
        this.running.add(iRequestHandler);
        createThread(iRequestHandler).start();
    }

    public List<IRequestHandler> getRunning() {
        return this.running;
    }
}
