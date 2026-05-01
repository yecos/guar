package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static volatile n f5917a = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5918d = false;

    /* renamed from: e, reason: collision with root package name */
    private static long f5919e = 0;

    /* renamed from: g, reason: collision with root package name */
    private static String f5920g = "https://";

    /* renamed from: h, reason: collision with root package name */
    private static String f5921h = null;

    /* renamed from: h, reason: collision with other field name */
    public static boolean f24h = false;

    /* renamed from: c, reason: collision with root package name */
    private String f5922c;

    /* renamed from: e, reason: collision with other field name */
    private boolean f28e;

    /* renamed from: e, reason: collision with other field name */
    private int f27e = 0;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f25a = null;

    /* renamed from: f, reason: collision with other field name */
    private long f29f = 0;

    /* renamed from: g, reason: collision with other field name */
    private long f31g = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f5923f = 0;

    /* renamed from: f, reason: collision with other field name */
    private boolean f30f = false;

    /* renamed from: g, reason: collision with other field name */
    private boolean f32g = true;

    /* renamed from: i, reason: collision with root package name */
    private String f5924i = null;

    /* renamed from: a, reason: collision with other field name */
    private Handler f26a = null;

    private n() {
    }

    public static n a() {
        if (f5917a == null) {
            synchronized (n.class) {
                if (f5917a == null) {
                    f5917a = new n();
                }
            }
        }
        return f5917a;
    }

    private String e() {
        return (this.f28e || this.f30f) ? f.f5902b[this.f5923f] : f.f19a[this.f27e];
    }

    private void f() {
        int i10 = this.f5923f;
        this.f5923f = i10 < f.f5902b.length + (-1) ? i10 + 1 : 0;
    }

    public synchronized void b(Context context, String str) {
        try {
            if (str.equals(this.f5924i)) {
                i.e("region should be different");
            } else {
                this.f5924i = str;
                if (System.currentTimeMillis() - this.f31g >= 300000) {
                    d();
                } else {
                    long currentTimeMillis = 300000 - (System.currentTimeMillis() - this.f31g);
                    i.e("The call time should be greater than 5 minutes. SDK will initiate an update request after " + (currentTimeMillis / 60000) + " minutes.");
                    if (this.f26a == null) {
                        Handler handler = new Handler();
                        this.f26a = handler;
                        handler.postDelayed(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.n.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.d();
                            }
                        }, currentTimeMillis);
                    }
                }
                if (this.f25a == null) {
                    if (context == null) {
                        i.f("sp failed to save, does not affect the current settings");
                        return;
                    }
                    this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                }
                SharedPreferences.Editor edit = this.f25a.edit();
                edit.putString("httpdns_region", this.f5924i);
                edit.putBoolean("httpdns_first_start", true);
                edit.putLong("schedule_center_last_request_time", 0L);
                edit.commit();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void c() {
        m a10;
        int length;
        if (System.currentTimeMillis() - this.f29f >= 300000) {
            i.d("update server ips from StartIp schedule center.");
            this.f27e = 0;
            this.f5923f = 0;
            this.f30f = false;
            this.f32g = true;
            f24h = false;
            if (this.f28e) {
                a10 = m.a();
                length = f.f5902b.length;
            } else {
                a10 = m.a();
                length = f.f19a.length;
            }
            a10.a(length - 1);
            c.a().submit(m.a());
        } else {
            i.d("update server ips from StartIp schedule center too often, give up. ");
            u.j();
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public synchronized String m19d() {
        StringBuilder sb;
        String str;
        try {
            sb = new StringBuilder();
            sb.append(f5920g);
            sb.append(e());
            sb.append(Operator.Operation.DIVISION);
            String str2 = this.f5922c;
            if (str2 == null) {
                str2 = f.f5903c;
            }
            sb.append(str2);
            sb.append("/ss?platform=android&sdk_version=");
            sb.append("1.3.2.3-no-bssid-ssid");
            sb.append("&sid=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
            sb.append("&net=");
            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
            if (TextUtils.isEmpty(this.f5924i)) {
                str = "";
            } else {
                str = "&region=" + this.f5924i;
            }
            sb.append(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public void setAccountId(String str) {
        this.f5922c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        i.d("update server ips from StartIp schedule center.");
        this.f31g = System.currentTimeMillis();
        this.f27e = 0;
        this.f5923f = 0;
        this.f30f = false;
        this.f28e = true;
        this.f32g = true;
        f24h = false;
        m.a().a(f.f5902b.length - 1);
        c.a().submit(m.a());
        this.f26a = null;
    }

    /* renamed from: e, reason: collision with other method in class */
    private void m18e() {
        int i10 = this.f27e;
        this.f27e = i10 < f.f19a.length + (-1) ? i10 + 1 : 0;
    }

    public synchronized void a(Context context, String str) {
        try {
            if (!f5918d) {
                synchronized (n.class) {
                    if (!f5918d) {
                        setAccountId(str);
                        if (context != null) {
                            this.f25a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        this.f28e = this.f25a.getBoolean("httpdns_first_start", true);
                        f5921h = this.f25a.getString("httpdns_server_ips", null);
                        this.f5924i = this.f25a.getString("httpdns_region", null);
                        String str2 = f5921h;
                        if (str2 != null) {
                            f.a(str2.split(";"));
                        }
                        long j10 = this.f25a.getLong("schedule_center_last_request_time", 0L);
                        f5919e = j10;
                        if (j10 == 0 || System.currentTimeMillis() - f5919e >= 86400000) {
                            t.a().c(false);
                            c();
                        }
                        f5918d = true;
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void c(Throwable th) {
        try {
            f24h = false;
            d(th);
            if (this.f28e) {
                f();
            } else {
                if (!this.f30f) {
                    m18e();
                }
                if (this.f27e == 0) {
                    this.f30f = true;
                    if (this.f32g) {
                        this.f32g = false;
                        this.f5923f = 0;
                        i.d("StartIp Scheduler center update from StartIp");
                        m.a().a(f.f5902b.length - 1);
                        c.a().submit(m.a());
                    } else {
                        f();
                        if (this.f5923f == 0) {
                            this.f29f = System.currentTimeMillis();
                            i.f("StartIp Scheduler center update failed");
                            u.j();
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void d(Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                int a11 = com.alibaba.sdk.android.httpdns.d.c.a(th);
                a10.a(m19d(), String.valueOf(a11), th.getMessage(), com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized void a(o oVar, long j10) {
        try {
            a(m19d(), j10);
            this.f27e = 0;
            this.f5923f = 0;
            this.f30f = false;
            this.f32g = true;
            HttpDns.switchDnsService(oVar.isEnabled());
            if (a(oVar.b())) {
                i.d("StartIp Scheduler center update success    StartIp isFirstStart：" + this.f28e);
                f24h = true;
                this.f29f = System.currentTimeMillis();
                u.i();
                if (this.f28e) {
                    SharedPreferences.Editor edit = this.f25a.edit();
                    edit.putBoolean("httpdns_first_start", false);
                    edit.commit();
                    this.f28e = false;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void a(String str, long j10) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.a(str, j10, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public synchronized boolean a(String[] strArr) {
        try {
            if (!f.a(strArr)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            sb.deleteCharAt(sb.length() - 1);
            SharedPreferences sharedPreferences = this.f25a;
            if (sharedPreferences == null) {
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("httpdns_server_ips", sb.toString());
            edit.putLong("schedule_center_last_request_time", System.currentTimeMillis());
            edit.commit();
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
