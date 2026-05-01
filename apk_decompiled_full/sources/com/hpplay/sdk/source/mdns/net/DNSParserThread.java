package com.hpplay.sdk.source.mdns.net;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class DNSParserThread extends Thread {
    private static final String TAG = "DNSParserThread";
    private PacketListener mDispatcher;
    private BlockingQueue<Packet> mPacketQueue = new LinkedBlockingQueue(20);
    private AtomicBoolean isQuit = new AtomicBoolean();

    public DNSParserThread(PacketListener packetListener) {
        this.mDispatcher = packetListener;
        setName(TAG);
    }

    public synchronized void release() {
        this.isQuit.set(true);
        interrupt();
        this.mDispatcher = null;
        this.mPacketQueue.clear();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.isQuit.set(false);
        while (!this.isQuit.get() && !isInterrupted()) {
            try {
                Packet take = this.mPacketQueue.take();
                PacketListener packetListener = this.mDispatcher;
                if (packetListener != null) {
                    packetListener.packetReceived(take);
                }
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append(Thread.currentThread());
                sb.append("  InterruptedException exit...");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Thread.currentThread());
        sb2.append(" DNSParserThread exit...");
    }

    public synchronized void updateReceiveData(Packet packet) {
        if (!this.isQuit.get()) {
            this.mPacketQueue.offer(packet);
        }
    }
}
