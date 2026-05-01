package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bt;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.SendMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    private static Context mContext;
    protected NotifManager notifyManager = null;
    private MessageService messageService = null;

    public static class a implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private Intent f17829a;

        /* renamed from: b, reason: collision with root package name */
        private String f17830b;

        /* renamed from: c, reason: collision with root package name */
        private SendMessage f17831c;

        /* renamed from: d, reason: collision with root package name */
        private ServiceConnection f17832d = this;

        public a(String str, Intent intent) {
            this.f17830b = str;
            this.f17829a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.d(AgooFactory.TAG, "MessageConnection conneted:" + componentName, new Object[0]);
            this.f17831c = SendMessage.Stub.asInterface(iBinder);
            ALog.d(AgooFactory.TAG, "onConnected current tid:" + Thread.currentThread().getId(), new Object[0]);
            ALog.d(AgooFactory.TAG, "MessageConnection sent:" + this.f17829a, new Object[0]);
            if (this.f17831c != null) {
                ThreadPoolExecutorFactory.execute(new f(this));
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ALog.d(AgooFactory.TAG, "MessageConnection disConnected", new Object[0]);
        }
    }

    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private String f17834b;

        /* renamed from: c, reason: collision with root package name */
        private Intent f17835c;

        public b(String str, Intent intent) {
            this.f17834b = str;
            this.f17835c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ALog.d(AgooFactory.TAG, "running tid:" + Thread.currentThread().getId() + ",pack=" + this.f17834b, new Object[0]);
                AgooFactory.mContext.sendBroadcast(this.f17835c);
                StringBuilder sb = new StringBuilder();
                sb.append("SendMessageRunnable for accs,pack=");
                sb.append(this.f17834b);
                ALog.d(AgooFactory.TAG, sb.toString(), new Object[0]);
                try {
                    this.f17835c.setPackage(this.f17834b);
                    this.f17835c.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                    com.taobao.accs.a.a.a(AgooFactory.mContext, this.f17835c);
                } catch (Throwable unused) {
                }
                Intent intent = new Intent(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                intent.setPackage(this.f17834b);
                ALog.d(AgooFactory.TAG, "this message pack:" + this.f17834b, new Object[0]);
                ALog.d(AgooFactory.TAG, "start to service...", new Object[0]);
                boolean bindService = AgooFactory.mContext.bindService(intent, new a(this.f17835c.getStringExtra("id"), this.f17835c), 17);
                ALog.d(AgooFactory.TAG, "start service ret:" + bindService, new Object[0]);
                if (bindService) {
                    return;
                }
                ALog.d(AgooFactory.TAG, "SendMessageRunnable is error", new Object[0]);
            } catch (Throwable th) {
                ALog.e(AgooFactory.TAG, "SendMessageRunnable is error,e=" + th.toString(), new Object[0]);
            }
        }
    }

    private static final boolean checkPackage(Context context, String str) {
        return context.getPackageManager().getApplicationInfo(str, 0) != null;
    }

    private static Bundle getFlag(long j10, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j10).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static String parseEncryptedMsg(String str) {
        byte[] bArr;
        String str2 = null;
        try {
            String a10 = Config.a(mContext);
            String b10 = Config.b(mContext);
            String j10 = UtilityImpl.j(mContext);
            if (TextUtils.isEmpty(b10)) {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
                bArr = null;
            } else {
                bArr = org.android.agoo.common.a.a(b10.getBytes(XML.CHARSET_UTF8), (a10 + j10).getBytes(XML.CHARSET_UTF8));
            }
            if (bArr == null || bArr.length <= 0) {
                ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
            } else {
                str2 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArr), "AES"), org.android.agoo.common.a.a(a10.getBytes(XML.CHARSET_UTF8))), XML.CHARSET_UTF8);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        return TextUtils.isEmpty(str2) ? parseEncryptedMsgByOldDid(str) : str2;
    }

    private static String parseEncryptedMsgByOldDid(String str) {
        byte[] bArr;
        try {
            String d10 = UtilityImpl.d(Constants.SP_FILE_NAME, mContext);
            if (TextUtils.isEmpty(d10) || TextUtils.equals(d10, UtilityImpl.j(mContext))) {
                return null;
            }
            String a10 = Config.a(mContext);
            String b10 = Config.b(mContext);
            if (TextUtils.isEmpty(b10)) {
                ALog.e(TAG, "oldDid getAppsign secret null", new Object[0]);
                bArr = null;
            } else {
                bArr = org.android.agoo.common.a.a(b10.getBytes(XML.CHARSET_UTF8), (a10 + d10).getBytes(XML.CHARSET_UTF8));
            }
            if (bArr != null && bArr.length > 0) {
                return new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArr), "AES"), org.android.agoo.common.a.a(a10.getBytes(XML.CHARSET_UTF8))), XML.CHARSET_UTF8);
            }
            ALog.e(TAG, "oldDid aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "oldDid parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "onHandleMessage current tid:" + Thread.currentThread().getId(), new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(str, intent));
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgByBindService error >>", th, new Object[0]);
        }
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z10, String str2, TaoBaseService.ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBussiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBussiness intent:" + bundle.toString() + ",utdid=" + com.taobao.accs.utl.j.b(context) + ",pack=" + str + ",agooFlag=" + z10, new Object[0]);
        }
        if (z10) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(context), "agooMsg", AgooConstants.ACK_PACK_ERROR);
            sendMsgByBindService(str, intent);
        } else {
            intent.setClassName(str, com.taobao.accs.client.a.b());
            com.taobao.accs.a.a.a(context, intent);
        }
    }

    public void init(Context context, NotifManager notifManager, MessageService messageService) {
        mContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (notifManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService;
        if (messageService == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(mContext);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:46|(2:48|(1:50)(4:64|44|31|32))(1:65)|51|52|53|(1:55)|56|(1:58)(1:59)|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x021c, code lost:
    
        if (com.taobao.accs.utl.ALog.isPrintLog(com.taobao.accs.utl.ALog.Level.I) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x021e, code lost:
    
        com.taobao.accs.utl.ALog.i(org.android.agoo.control.AgooFactory.TAG, "agoo msg has no time", new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle msgReceiverPreHandler(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo, boolean z10) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        boolean z11;
        String str5;
        Bundle bundle;
        StringBuilder sb;
        String str6;
        StringBuilder sb2;
        int i10;
        int i11;
        String str7 = ",";
        String str8 = "ext";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str9 = new String(bArr, XML.CHARSET_UTF8);
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "msgRecevie,message--->[" + str9 + "],utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
                    }
                    if (TextUtils.isEmpty(str9)) {
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "message==null");
                        ALog.i(TAG, "handleMessage message==null,utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
                        return null;
                    }
                    JSONArray jSONArray2 = new JSONArray(str9);
                    int length = jSONArray2.length();
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder sb4 = new StringBuilder();
                    Bundle bundle2 = null;
                    String str10 = null;
                    int i12 = 0;
                    while (i12 < length) {
                        Bundle bundle3 = new Bundle();
                        JSONObject jSONObject = jSONArray2.getJSONObject(i12);
                        if (jSONObject == null) {
                            jSONArray = jSONArray2;
                            i10 = i12;
                            sb = sb4;
                            sb2 = sb3;
                            i11 = length;
                            str6 = str9;
                            str4 = str7;
                            str2 = str8;
                            bundle = bundle3;
                        } else {
                            MsgDO msgDO = new MsgDO();
                            jSONArray = jSONArray2;
                            String string = jSONObject.getString(bt.aD);
                            String str11 = str10;
                            String string2 = jSONObject.getString(bt.aI);
                            String str12 = str9;
                            String string3 = jSONObject.getString(c8.b.f5629b);
                            StringBuilder sb5 = sb4;
                            StringBuilder sb6 = sb3;
                            long j10 = jSONObject.getLong(m7.f.f16828a);
                            if (jSONObject.isNull(str8)) {
                                str2 = str8;
                                str3 = str11;
                            } else {
                                str3 = jSONObject.getString(str8);
                                str2 = str8;
                            }
                            str4 = str7;
                            int optInt = jSONObject.optInt(bt.aL, -1);
                            int i13 = length - 1;
                            msgDO.msgIds = string2;
                            msgDO.extData = str3;
                            msgDO.removePacks = string;
                            msgDO.messageSource = str;
                            if (TextUtils.isEmpty(string3)) {
                                msgDO.errorCode = AgooConstants.ACK_BODY_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (TextUtils.isEmpty(string)) {
                                msgDO.errorCode = AgooConstants.ACK_PACK_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else if (j10 == -1) {
                                msgDO.errorCode = AgooConstants.ACK_FLAG_NULL;
                                this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                            } else {
                                int i14 = length;
                                if (checkPackage(mContext, string)) {
                                    Bundle flag = getFlag(j10, msgDO);
                                    String string4 = flag.getString(AgooConstants.MESSAGE_ENCRYPTED);
                                    int i15 = i12;
                                    if (!mContext.getPackageName().equals(string)) {
                                        z11 = true;
                                    } else if (TextUtils.equals(string4, Integer.toString(4))) {
                                        z11 = false;
                                    } else {
                                        ALog.e(TAG, "msgRecevie msg encrypted flag not exist, cannot prase!!!", new Object[0]);
                                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "encrypted!=4", AgooConstants.ACK_PACK_ERROR);
                                        msgDO.errorCode = AgooConstants.REPORT_NOT_ENCRYPT;
                                        this.notifyManager.handlerACKMessage(msgDO, extraInfo);
                                        sb = sb5;
                                        str4 = str4;
                                        sb2 = sb6;
                                        i10 = i15;
                                        str6 = str12;
                                        bundle = bundle3;
                                        i11 = i14;
                                        str5 = str3;
                                        str10 = str5;
                                    }
                                    bundle3.putAll(flag);
                                    String string5 = jSONObject.getString("t");
                                    if (!TextUtils.isEmpty(string5)) {
                                        bundle3.putString(AgooConstants.MESSAGE_TIME, string5);
                                    }
                                    str4 = str4;
                                    bundle3.putLong(AgooConstants.MESSAGE_TRACE, System.currentTimeMillis());
                                    bundle3.putString("id", string2);
                                    bundle3.putString("body", string3);
                                    bundle3.putString("source", string);
                                    bundle3.putString(AgooConstants.MESSAGE_FROM_APPKEY, Config.a(mContext));
                                    bundle3.putString(AgooConstants.MESSAGE_EXT, str3);
                                    bundle3.putString(AgooConstants.MESSAGE_ORI, str12);
                                    bundle3.putInt("channel", optInt);
                                    if (z10) {
                                        str5 = str3;
                                        bundle = bundle3;
                                        i10 = i15;
                                        sb = sb5;
                                        sb2 = sb6;
                                        i11 = i14;
                                        str6 = str12;
                                        sendMsgToBussiness(mContext, string, bundle, z11, str, extraInfo);
                                    } else {
                                        str5 = str3;
                                        bundle = bundle3;
                                        sb = sb5;
                                        str6 = str12;
                                        sb2 = sb6;
                                        i10 = i15;
                                        i11 = i14;
                                        bundle.putString("type", "common-push");
                                        bundle.putString(AgooConstants.MESSAGE_SOURCE, str);
                                    }
                                    str10 = str5;
                                } else {
                                    ALog.d(TAG, "msgRecevie checkpackage is del,pack=" + string, new Object[0]);
                                    UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "deletePack", string);
                                    sb5.append(string);
                                    sb6.append(string2);
                                    if (i12 < i13) {
                                        sb5.append(str4);
                                        sb6.append(str4);
                                        sb2 = sb6;
                                        i10 = i12;
                                        sb = sb5;
                                        str4 = str4;
                                        str6 = str12;
                                        bundle = bundle3;
                                        i11 = i14;
                                        str5 = str3;
                                        str10 = str5;
                                    } else {
                                        sb2 = sb6;
                                        str5 = str3;
                                        i10 = i12;
                                        sb = sb5;
                                        str6 = str12;
                                        bundle = bundle3;
                                        i11 = i14;
                                        str10 = str5;
                                    }
                                }
                            }
                            str5 = str3;
                            i10 = i12;
                            i11 = length;
                            str6 = str12;
                            bundle = bundle3;
                            sb2 = sb6;
                            sb = sb5;
                            str10 = str5;
                        }
                        i12 = i10 + 1;
                        sb4 = sb;
                        bundle2 = bundle;
                        sb3 = sb2;
                        length = i11;
                        str9 = str6;
                        str8 = str2;
                        str7 = str4;
                        jSONArray2 = jSONArray;
                    }
                    StringBuilder sb7 = sb4;
                    StringBuilder sb8 = sb3;
                    if (sb7.length() > 0) {
                        MsgDO msgDO2 = new MsgDO();
                        msgDO2.msgIds = sb8.toString();
                        msgDO2.removePacks = sb7.toString();
                        msgDO2.errorCode = AgooConstants.ACK_REMOVE_PACKAGE;
                        msgDO2.messageSource = str;
                        this.notifyManager.handlerACKMessage(msgDO2, extraInfo);
                    }
                    return bundle2;
                }
            } catch (Throwable th) {
                if (!ALog.isPrintLog(ALog.Level.E)) {
                    return null;
                }
                ALog.e(TAG, "msgRecevie is error,e=" + th, new Object[0]);
                return null;
            }
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, com.taobao.accs.utl.j.b(mContext), "data==null");
        ALog.i(TAG, "handleMessage data==null,utdid=" + com.taobao.accs.utl.j.b(mContext), new Object[0]);
        return null;
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, null);
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new c(this));
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, null);
    }

    public void updateMsg(byte[] bArr, boolean z10) {
        ThreadPoolExecutorFactory.execute(new d(this, bArr, z10));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.f(mContext), new Object[0]);
                }
                if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    this.messageService.a(str, "2");
                } else if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
                    this.messageService.a(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(String str, String str2) {
        ThreadPoolExecutorFactory.execute(new e(this, str, str2));
    }

    public void msgRecevie(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgRecevie]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new org.android.agoo.control.b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        ThreadPoolExecutorFactory.execute(new org.android.agoo.control.a(this, bArr, str));
    }
}
