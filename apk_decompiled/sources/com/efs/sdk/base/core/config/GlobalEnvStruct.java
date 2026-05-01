package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class GlobalEnvStruct {

    /* renamed from: a, reason: collision with root package name */
    private String f6119a;

    /* renamed from: b, reason: collision with root package name */
    private String f6120b;

    /* renamed from: i, reason: collision with root package name */
    private String f6127i;
    public Context mAppContext;

    /* renamed from: q, reason: collision with root package name */
    private ILogEncryptAction f6135q;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6121c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6122d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6123e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6124f = false;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f6125g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6126h = false;

    /* renamed from: j, reason: collision with root package name */
    private String f6128j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f6129k = "";

    /* renamed from: l, reason: collision with root package name */
    private boolean f6130l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6131m = false;
    public long configRefreshDelayMills = 5000;

    /* renamed from: n, reason: collision with root package name */
    private long f6132n = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;

    /* renamed from: o, reason: collision with root package name */
    private long f6133o = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, String> f6134p = new HashMap(5);

    /* renamed from: r, reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> f6136r = new ConcurrentHashMap<>();

    /* renamed from: s, reason: collision with root package name */
    private List<IEfsReporterObserver> f6137s = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (this.f6137s.contains(iEfsReporterObserver)) {
            return;
        }
        this.f6137s.add(iEfsReporterObserver);
    }

    public void addPublicParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(this.f6134p);
        hashMap.putAll(map);
        this.f6134p = hashMap;
    }

    public String getAppid() {
        return this.f6119a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i10) {
        return (!this.f6136r.containsKey(Integer.valueOf(i10)) || this.f6136r.get(Integer.valueOf(i10)) == null) ? Collections.emptyList() : this.f6136r.get(Integer.valueOf(i10));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.f6137s;
    }

    public String getLogDid() {
        return this.f6129k;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.f6135q;
    }

    public long getLogSendDelayMills() {
        return this.f6132n;
    }

    public long getLogSendIntervalMills() {
        return this.f6133o;
    }

    public String getLogUid() {
        return this.f6128j;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.f6134p;
        return map == null ? Collections.emptyMap() : map;
    }

    public String getSecret() {
        return this.f6120b;
    }

    public String getUid() {
        return this.f6127i;
    }

    public boolean isDebug() {
        return this.f6124f;
    }

    public boolean isEnablePaBackup() {
        return this.f6122d;
    }

    public boolean isEnableSendLog() {
        return this.f6123e;
    }

    public boolean isEnableWaStat() {
        return this.f6121c;
    }

    public boolean isIntl() {
        return this.f6131m;
    }

    public boolean isOpenCodeLog() {
        return this.f6130l;
    }

    public boolean isPrintLogDetail() {
        return this.f6126h;
    }

    public void registerCallback(int i10, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        List<ValueCallback<Pair<Message, Message>>> list = this.f6136r.get(Integer.valueOf(i10));
        if (list == null) {
            list = new LinkedList<>();
            this.f6136r.putIfAbsent(Integer.valueOf(i10), list);
        }
        list.add(valueCallback);
    }

    public void setAppid(String str) {
        this.f6119a = str;
    }

    public void setDebug(boolean z10) {
        this.f6124f = z10;
    }

    public void setEnablePaBackup(boolean z10) {
        this.f6122d = z10;
    }

    public void setEnableSendLog(boolean z10) {
        this.f6123e = z10;
    }

    public void setEnableWaStat(boolean z10) {
        this.f6121c = z10;
    }

    public void setIsIntl(boolean z10) {
        this.f6131m = z10;
    }

    public void setLogDid(String str) {
        this.f6129k = str;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.f6135q = iLogEncryptAction;
    }

    public void setLogUid(String str) {
        this.f6128j = str;
    }

    public void setOpenCodeLog(boolean z10) {
        this.f6130l = z10;
    }

    public void setPrintLogDetail(boolean z10) {
        this.f6126h = z10;
    }

    public void setSecret(String str) {
        this.f6120b = str;
    }

    public void setUid(String str) {
        this.f6127i = str;
    }
}
