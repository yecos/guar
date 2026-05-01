package com.hpplay.sdk.source.mdns.xbill.dns;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* loaded from: classes3.dex */
class Client {
    protected long endTime;
    protected SelectionKey key;

    public Client(SelectableChannel selectableChannel, long j10) {
        Selector selector;
        this.endTime = j10;
        try {
            selector = Selector.open();
            try {
                selectableChannel.configureBlocking(false);
                this.key = selectableChannel.register(selector, 1);
            } catch (Throwable th) {
                th = th;
                if (selector != null) {
                    selector.close();
                }
                selectableChannel.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            selector = null;
        }
    }

    public static void blockUntil(SelectionKey selectionKey, long j10) {
        long currentTimeMillis = j10 - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    public void cleanup() {
        this.key.selector().close();
        this.key.channel().close();
    }
}
