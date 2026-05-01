package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.k;

@Keep
/* loaded from: classes3.dex */
public class c implements com.taobao.accs.c {

    /* renamed from: a, reason: collision with root package name */
    private com.taobao.accs.net.a f9150a;

    public c(String str) {
        this.f9150a = new k(GlobalClientInfo.f9031a, 1, str);
    }

    @Override // com.taobao.accs.c
    public void a() {
        this.f9150a.a();
    }

    @Override // com.taobao.accs.c
    public void b() {
        this.f9150a.k();
    }

    @Override // com.taobao.accs.c
    public String c() {
        return this.f9150a.i();
    }

    @Override // com.taobao.accs.c
    public String d() {
        return this.f9150a.f9165i.getAppSecret();
    }

    @Override // com.taobao.accs.c
    public boolean e(String str) {
        return this.f9150a.j().c(str);
    }

    @Override // com.taobao.accs.c
    public boolean f(String str) {
        return this.f9150a.j().d(str);
    }

    @Override // com.taobao.accs.c
    public void a(boolean z10, boolean z11) {
        this.f9150a.a(z10, z11);
    }

    @Override // com.taobao.accs.c
    public String b(String str) {
        return this.f9150a.b(str);
    }

    @Override // com.taobao.accs.c
    public void c(String str) {
        this.f9150a.f9157a = str;
    }

    @Override // com.taobao.accs.c
    public void d(String str) {
        this.f9150a.f9158b = str;
    }

    @Override // com.taobao.accs.c
    public String e() {
        return this.f9150a.f9165i.getStoreId();
    }

    @Override // com.taobao.accs.c
    public boolean f() {
        return this.f9150a.m();
    }

    @Override // com.taobao.accs.c
    public boolean a(String str) {
        return this.f9150a.a(str);
    }

    @Override // com.taobao.accs.c
    public void b(AccsConnectStateListener accsConnectStateListener) {
        this.f9150a.b(accsConnectStateListener);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, int i10) {
        this.f9150a.b(message, i10);
    }

    @Override // com.taobao.accs.c
    public void a(Message message, boolean z10) {
        this.f9150a.b(message, z10);
    }

    @Override // com.taobao.accs.c
    public void a(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.a aVar = this.f9150a;
        if (aVar instanceof k) {
            ((k) aVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.c
    public boolean a(String str, String str2) {
        return this.f9150a.j().b(str, str2);
    }

    @Override // com.taobao.accs.c
    public void a(AccsConnectStateListener accsConnectStateListener) {
        this.f9150a.a(accsConnectStateListener);
    }
}
