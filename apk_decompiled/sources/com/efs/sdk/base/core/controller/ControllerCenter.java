package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.b.e;
import com.efs.sdk.base.core.b.h;
import com.efs.sdk.base.core.c.d;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.a.a;
import com.efs.sdk.base.core.d.c;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ControllerCenter implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name */
    private static GlobalEnvStruct f6165h;

    /* renamed from: a, reason: collision with root package name */
    private int f6166a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final int f6167b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f6168c = 1;

    /* renamed from: d, reason: collision with root package name */
    private final int f6169d = 2;

    /* renamed from: e, reason: collision with root package name */
    private final int f6170e = 3;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f6171f = false;

    /* renamed from: g, reason: collision with root package name */
    private a f6172g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6173i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f6174j;

    public ControllerCenter(EfsReporter.Builder builder) {
        this.f6173i = false;
        GlobalEnvStruct globalEnvStruct = builder.getGlobalEnvStruct();
        f6165h = globalEnvStruct;
        this.f6173i = globalEnvStruct.isOpenCodeLog();
        Handler handler = new Handler(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper(), this);
        this.f6174j = handler;
        handler.sendEmptyMessage(0);
    }

    private void a() {
        if (this.f6172g == null) {
            this.f6172g = new a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f6165h.mAppContext.registerReceiver(this.f6172g, intentFilter);
        } catch (Throwable th) {
            Log.w("efs.base", "register network change receiver error", th);
            int i10 = this.f6166a + 1;
            this.f6166a = i10;
            if (i10 < 3) {
                this.f6174j.sendEmptyMessageDelayed(3, 6000L);
            }
        }
    }

    private void b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                final d dVar;
                try {
                    iLogProtocol.insertGlobal(GlobalInfoManager.getInstance().getGlobalInfo());
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.a(iLogProtocol);
                    }
                    if (ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        final LogDto buildLogDto = LogDto.buildLogDto(iLogProtocol);
                        dVar = d.a.f6103a;
                        WorkThreadUtil.submit(new Runnable() { // from class: com.efs.sdk.base.core.c.d.1

                            /* renamed from: a */
                            final /* synthetic */ LogDto f6101a;

                            public AnonymousClass1(final LogDto buildLogDto2) {
                                r2 = buildLogDto2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.f6100a.a(r2);
                            }
                        });
                    }
                } catch (Throwable th) {
                    Log.e("efs.base", "log send error", th);
                }
            }
        });
    }

    public static GlobalEnvStruct getGlobalEnvStruct() {
        return f6165h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        f fVar;
        f fVar2;
        h unused;
        int i10 = message.what;
        if (i10 == 0) {
            GlobalInfoManager.getInstance().initGlobalInfo();
            unused = h.a.f6096a;
            b.a().b();
            a();
            fVar = f.a.f6196a;
            boolean isIntl = f6165h.isIntl();
            c cVar = fVar.f6192a;
            if (isIntl) {
                cVar.f6184a = "https://errnewlogos.umeng.com/api/crashsdk/logcollect";
                cVar.f6185b = "4ea4e41a3993";
            } else {
                cVar.f6184a = "https://errnewlog.umeng.com/api/crashsdk/logcollect";
                cVar.f6185b = "28ef1713347d";
            }
            fVar.f6193b = this;
            fVar.f6194c.f6177a = this;
            fVar.f6195d.f6177a = this;
            this.f6171f = true;
            e.a().sendEmptyMessageDelayed(0, f6165h.getLogSendDelayMills());
            if (this.f6173i) {
                e.a().sendEmptyMessageDelayed(10, f6165h.getLogSendDelayMills());
            }
            fVar2 = f.a.f6196a;
            if (fVar2.f6193b != null && getGlobalEnvStruct().isEnableWaStat()) {
                fVar2.f6193b.send(new com.efs.sdk.base.core.d.b("efs_core", "pvuv", fVar2.f6192a.f6186c));
            }
        } else if (i10 == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                b((ILogProtocol) obj);
            }
        } else if (i10 == 3) {
            a();
        }
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f6171f) {
            b(iLogProtocol);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iLogProtocol;
        this.f6174j.sendMessage(obtain);
    }

    public HttpResponse sendSyncImmediately(String str, int i10, String str2, boolean z10, File file) {
        d dVar;
        LogDto logDto = new LogDto(str, (byte) 2);
        logDto.setLogBodyType(1);
        logDto.setFile(file);
        logDto.setCp(str2);
        logDto.setDe(i10);
        logDto.setLimitByFlow(z10);
        logDto.setSendImediately(true);
        dVar = d.a.f6103a;
        dVar.f6100a.a(logDto);
        return logDto.getResponseDto();
    }

    public static /* synthetic */ void a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("log_type", iLogProtocol.getLogType());
            hashMap.put("log_data", iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            Message obtain = Message.obtain(null, 9, hashMap);
            Message obtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
