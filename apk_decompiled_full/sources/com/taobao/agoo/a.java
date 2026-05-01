package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* loaded from: classes3.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f9384a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseNotifyClick f9385b;

    public a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f9385b = baseNotifyClick;
        this.f9384a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String parseMsgByThirdPush;
        String str;
        String str2;
        NotifManager notifManager;
        AgooFactory agooFactory;
        AgooFactory agooFactory2;
        String str3;
        AgooFactory agooFactory3;
        AgooFactory agooFactory4;
        Context context;
        NotifManager notifManager2;
        Intent intent = null;
        try {
            Intent intent2 = this.f9384a;
            if (intent2 != null) {
                parseMsgByThirdPush = this.f9385b.parseMsgByThirdPush(intent2);
                if (!TextUtils.isEmpty(parseMsgByThirdPush)) {
                    str2 = this.f9385b.msgSource;
                    if (!TextUtils.isEmpty(str2)) {
                        notifManager = this.f9385b.notifyManager;
                        if (notifManager == null) {
                            this.f9385b.notifyManager = new NotifManager();
                        }
                        agooFactory = this.f9385b.agooFactory;
                        if (agooFactory == null) {
                            this.f9385b.agooFactory = new AgooFactory();
                            agooFactory4 = this.f9385b.agooFactory;
                            context = this.f9385b.context;
                            notifManager2 = this.f9385b.notifyManager;
                            agooFactory4.init(context, notifManager2, null);
                        }
                        agooFactory2 = this.f9385b.agooFactory;
                        byte[] bytes = parseMsgByThirdPush.getBytes("UTF-8");
                        str3 = this.f9385b.msgSource;
                        Bundle msgReceiverPreHandler = agooFactory2.msgReceiverPreHandler(bytes, str3, null, false);
                        String string = msgReceiverPreHandler.getString("body");
                        ALog.i("BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                        String parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                        int i10 = msgReceiverPreHandler.getInt("channel", -1);
                        if (TextUtils.isEmpty(parseEncryptedMsg)) {
                            ALog.e("BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                        } else {
                            msgReceiverPreHandler.putString("body", parseEncryptedMsg);
                            msgReceiverPreHandler.putInt("channel", i10);
                        }
                        Intent intent3 = new Intent();
                        try {
                            intent3.putExtras(msgReceiverPreHandler);
                            agooFactory3 = this.f9385b.agooFactory;
                            agooFactory3.saveMsg(parseMsgByThirdPush.getBytes("UTF-8"), "2");
                            this.f9385b.reportClickNotifyMsg(intent3);
                            intent = intent3;
                        } catch (Throwable th) {
                            intent = intent3;
                            th = th;
                            try {
                                ALog.e("BaseNotifyClick", "buildMessage", th, new Object[0]);
                                try {
                                    this.f9385b.onMessage(intent);
                                    return;
                                } catch (Throwable th2) {
                                    ALog.e("BaseNotifyClick", "onMessage", th2, new Object[0]);
                                    return;
                                }
                            } catch (Throwable th3) {
                                try {
                                    this.f9385b.onMessage(intent);
                                } catch (Throwable th4) {
                                    ALog.e("BaseNotifyClick", "onMessage", th4, new Object[0]);
                                }
                                throw th3;
                            }
                        }
                    }
                }
                str = this.f9385b.msgSource;
                ALog.e("BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", str);
            }
            try {
                this.f9385b.onMessage(intent);
            } catch (Throwable th5) {
                ALog.e("BaseNotifyClick", "onMessage", th5, new Object[0]);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
