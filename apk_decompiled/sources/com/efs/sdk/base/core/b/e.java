package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public int f6074a;

    /* renamed from: b, reason: collision with root package name */
    public int f6075b;

    /* renamed from: c, reason: collision with root package name */
    public d f6076c;

    /* renamed from: d, reason: collision with root package name */
    public IFileFilter f6077d;

    /* renamed from: e, reason: collision with root package name */
    private d f6078e;

    /* renamed from: f, reason: collision with root package name */
    private d f6079f;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f6080g;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f6081h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f6082i;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f6083j;

    /* renamed from: k, reason: collision with root package name */
    private IFileFilter f6084k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f6085a = new e(0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    public static e a() {
        return a.f6085a;
    }

    public final void b(Object obj, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = obj;
        obtain.arg1 = i10;
        sendMessage(obtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        h hVar;
        super.handleMessage(message);
        hVar = h.a.f6096a;
        if (hVar.a()) {
            int i10 = message.what;
            if (i10 == 0) {
                String netStatus = GlobalInfoManager.getInstance().getNetStatus();
                if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus)) {
                    Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus)));
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                List<LogDto> emptyList = Collections.emptyList();
                try {
                    emptyList = CacheManager.getInstance().getLogDto(this.f6074a, this.f6084k);
                } catch (Throwable unused) {
                }
                for (LogDto logDto : emptyList) {
                    if ("wa".equals(logDto.getLogType()) || c.a().a(logDto.getLogType(), logDto.getBodySize())) {
                        d dVar = this.f6076c;
                        if ("wa".equals(logDto.getLogType())) {
                            dVar = this.f6079f;
                        }
                        String uuid = UUID.randomUUID().toString();
                        this.f6080g.add(uuid);
                        if (WorkThreadUtil.submit(new f(logDto, dVar, uuid)) == null) {
                            a(uuid, -1);
                        }
                    }
                }
                if (this.f6080g.size() <= 0) {
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                    return;
                }
                return;
            }
            if (i10 == 1) {
                Object obj = message.obj;
                if (obj != null) {
                    this.f6080g.remove(obj.toString());
                }
                int incrementAndGet = message.arg1 != 0 ? this.f6082i.incrementAndGet() : 0;
                if (this.f6080g.isEmpty()) {
                    if (incrementAndGet < 5) {
                        sendEmptyMessage(0);
                        return;
                    }
                    this.f6082i.set(0);
                    sendEmptyMessageDelayed(0, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (i10 != 10) {
                if (i10 != 11) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 != null) {
                    this.f6081h.remove(obj2.toString());
                }
                int incrementAndGet2 = message.arg1 != 0 ? this.f6083j.incrementAndGet() : 0;
                if (this.f6081h.isEmpty()) {
                    if (incrementAndGet2 == 0) {
                        Log.i("efs.send_log", "send secess.");
                        this.f6077d.finish();
                    }
                    if (incrementAndGet2 < 5) {
                        sendEmptyMessage(10);
                        return;
                    }
                    this.f6083j.set(0);
                    sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendDelayMills());
                    Log.i("efs.send_log", "request error cnt gt 5, next request delay 10s");
                    return;
                }
                return;
            }
            if (!this.f6077d.hasTask()) {
                Log.i("efs.send_log", "-> none task. return.");
                return;
            }
            String netStatus2 = GlobalInfoManager.getInstance().getNetStatus();
            if (NetworkUtil.NETWORK_CLASS_DENIED.equalsIgnoreCase(netStatus2) || NetworkUtil.NETWORK_CLASS_DISCONNECTED.equalsIgnoreCase(netStatus2)) {
                Log.i("efs.send_log", "log cann't be send because net status is ".concat(String.valueOf(netStatus2)));
                Log.i("efs.send_log", "-> none net. over.");
                sendEmptyMessageDelayed(10, 300000L);
                return;
            }
            List<LogDto> emptyList2 = Collections.emptyList();
            try {
                emptyList2 = CacheManager.getInstance().getLogDtoCodeLog(this.f6075b, this.f6077d);
            } catch (Throwable unused2) {
            }
            for (LogDto logDto2 : emptyList2) {
                d dVar2 = this.f6078e;
                String uuid2 = UUID.randomUUID().toString();
                this.f6081h.add(uuid2);
                if (WorkThreadUtil.submit(new g(logDto2, dVar2, uuid2)) == null) {
                    b(uuid2, -1);
                }
            }
            if (this.f6081h.size() <= 0) {
                if (CacheManager.getInstance().getCodeLogList() == null || CacheManager.getInstance().getCodeLogList().isEmpty()) {
                    Log.i("efs.send_log", "-> deal done and none log. return.");
                    sendEmptyMessageDelayed(10, 300000L);
                } else {
                    if (!this.f6077d.hasTask()) {
                        Log.i("efs.send_log", "-> deal done and none task. return.");
                        return;
                    }
                    Log.i("efs.send_log", "-> deal done and has task. next interval.");
                    this.f6077d.finish();
                    sendEmptyMessageDelayed(10, ControllerCenter.getGlobalEnvStruct().getLogSendIntervalMills());
                }
            }
        }
    }

    private e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper());
        this.f6074a = 5;
        this.f6075b = 1000;
        this.f6080g = new ArrayList();
        this.f6081h = new ArrayList();
        this.f6082i = new AtomicInteger(0);
        this.f6083j = new AtomicInteger(0);
        this.f6076c = new com.efs.sdk.base.core.b.a();
        this.f6078e = new b();
        this.f6079f = new com.efs.sdk.base.core.d.e();
        this.f6084k = new com.efs.sdk.base.core.cache.f();
    }

    public final void a(Object obj, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = obj;
        obtain.arg1 = i10;
        sendMessage(obtain);
    }
}
