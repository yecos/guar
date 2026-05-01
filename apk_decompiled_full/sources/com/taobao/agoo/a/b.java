package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import com.taobao.accs.utl.p;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.agoo.a.a.c;
import com.taobao.agoo.a.a.d;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b implements AccsDataListener {

    /* renamed from: b, reason: collision with root package name */
    public static a f9417b;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, ICallback> f9418a = new HashMap();

    public b(Context context) {
        if (f9417b == null) {
            f9417b = new a(context.getApplicationContext());
        }
    }

    private void a(JSONObject jSONObject, ICallback iCallback) {
        String a10 = p.a(jSONObject, com.taobao.agoo.a.a.a.JSON_PUSH_USER_TOKEN, null);
        if (TextUtils.isEmpty(a10)) {
            if (iCallback != null) {
                iCallback.onFailure("", "agoo server error-pushtoken null");
            }
        } else {
            Config.c(GlobalClientInfo.getContext(), a10);
            if (iCallback != null) {
                iCallback.onSuccess();
                f9417b.c(iCallback.extra);
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z10, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i10, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        boolean equals;
        try {
            if ("AgooDeviceCmd".equals(str)) {
                ICallback iCallback = this.f9418a.get(str2);
                if (i10 == 200) {
                    String str3 = new String(bArr, XML.CHARSET_UTF8);
                    ALog.i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, iCallback, "json", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    String a10 = p.a(jSONObject, com.taobao.agoo.a.a.b.JSON_ERRORCODE, null);
                    String a11 = p.a(jSONObject, com.taobao.agoo.a.a.b.JSON_CMD, null);
                    if (!"success".equals(a10)) {
                        if (iCallback != null) {
                            iCallback.onFailure(String.valueOf(a10), "agoo server error");
                        }
                        if (equals) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (c.JSON_CMD_REGISTER.equals(a11)) {
                        String a12 = p.a(jSONObject, "deviceId", null);
                        if (!TextUtils.isEmpty(a12)) {
                            TaobaoRegister.setIsRegisterSuccess(true);
                            l.a().b();
                            Config.b(GlobalClientInfo.getContext(), a12);
                            f9417b.a(GlobalClientInfo.getContext().getPackageName());
                            if (iCallback instanceof IRegister) {
                                UtilityImpl.c(Config.PREFERENCES, GlobalClientInfo.getContext());
                                ((IRegister) iCallback).onSuccess(a12);
                            }
                        } else if (iCallback != null) {
                            iCallback.onFailure("", "agoo server error deviceid null");
                        }
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9418a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if (com.taobao.agoo.a.a.a.JSON_CMD_SETALIAS.equals(a11)) {
                        a(jSONObject, iCallback);
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9418a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if (com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS.equals(a11)) {
                        Config.c(GlobalClientInfo.getContext(), null);
                        if (iCallback != null) {
                            iCallback.onSuccess();
                        }
                        f9417b.a();
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f9418a.remove(str2);
                            return;
                        }
                        return;
                    }
                    if ((d.JSON_CMD_ENABLEPUSH.equals(a11) || d.JSON_CMD_DISABLEPUSH.equals(a11)) && iCallback != null) {
                        iCallback.onSuccess();
                    }
                } else if (iCallback != null) {
                    iCallback.onFailure(String.valueOf(i10), "accs channel error");
                }
            }
            if (!"AgooDeviceCmd".equals(str)) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e("RequestListener", "onResponse", th, new Object[0]);
                if (!"AgooDeviceCmd".equals(str)) {
                    return;
                }
            } finally {
                if ("AgooDeviceCmd".equals(str)) {
                    this.f9418a.remove(str2);
                }
            }
        }
        this.f9418a.remove(str2);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }
}
