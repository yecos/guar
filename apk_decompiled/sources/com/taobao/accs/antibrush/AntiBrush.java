package com.taobao.accs.antibrush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.g;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes3.dex */
public class AntiBrush {
    private static final String ANTI_ATTACK_ACTION = "mtopsdk.mtop.antiattack.checkcode.validate.activity_action";
    private static final String ANTI_ATTACK_RESULT_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    public static final int STATUS_BRUSH = 419;
    private static final String TAG = "AntiBrush";
    private static String mHost = null;
    private static volatile boolean mIsInCheckCodeActivity = false;
    private static ScheduledFuture<?> mTimeoutTask;
    private BroadcastReceiver mAntiAttackReceiver = null;
    private Context mContext;

    public static class AntiReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                try {
                    String stringExtra = intent.getStringExtra("Result");
                    ALog.e(AntiBrush.TAG, "anti onReceive result: " + stringExtra, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), stringExtra.equalsIgnoreCase("success"));
                } catch (Exception e10) {
                    ALog.e(AntiBrush.TAG, "anti onReceive", e10, new Object[0]);
                    AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                }
            } catch (Throwable th) {
                AntiBrush.onResult(GlobalClientInfo.getContext(), false);
                throw th;
            }
        }
    }

    public AntiBrush(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void handleAntiBrush(String str) {
        if (mIsInCheckCodeActivity) {
            ALog.e(TAG, "handleAntiBrush return", "mIsInCheckCodeActivity", Boolean.valueOf(mIsInCheckCodeActivity));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(ANTI_ATTACK_ACTION);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
            intent.putExtra("Location", str);
            ALog.e(TAG, "handleAntiBrush:", new Object[0]);
            this.mContext.startActivity(intent);
            mIsInCheckCodeActivity = true;
            if (this.mAntiAttackReceiver == null) {
                this.mAntiAttackReceiver = new AntiReceiver();
            }
            if (Build.VERSION.SDK_INT >= 33) {
                this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION), 4);
            } else {
                this.mContext.registerReceiver(this.mAntiAttackReceiver, new IntentFilter(ANTI_ATTACK_RESULT_ACTION));
            }
        } catch (Throwable th) {
            ALog.e(TAG, "handleAntiBrush", th, new Object[0]);
        }
    }

    public static void onResult(Context context, boolean z10) {
        mIsInCheckCodeActivity = false;
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", 104);
        intent.putExtra(Constants.KEY_ANTI_BRUSH_RET, z10);
        g.a().b(context, intent);
        ScheduledFuture<?> scheduledFuture = mTimeoutTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            mTimeoutTask = null;
        }
        String str = mHost;
        if (str != null) {
            UtilityImpl.b(context, b.a(str));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(3:15|16|(4:18|(1:20)(1:34)|21|(2:23|(9:25|(1:27)|28|(1:30)(1:33)|31|4|5|(1:9)|11))))|3|4|5|(2:7|9)|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a8, code lost:
    
        r8 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkAntiBrush(java.net.URL r8, java.util.Map<java.lang.Integer, java.lang.String> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "AntiBrush"
            r1 = 0
            if (r9 == 0) goto L86
            boolean r2 = com.taobao.accs.utl.UtilityImpl.a()     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L86
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r2 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_STATUS     // Catch: java.lang.Throwable -> L83
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L83
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r2 = r9.get(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L83
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L83
            if (r3 == 0) goto L23
            r2 = 0
            goto L2b
        L23:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L83
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L83
        L2b:
            r3 = 419(0x1a3, float:5.87E-43)
            if (r2 != r3) goto L86
            com.taobao.accs.base.TaoBaseService$ExtHeaderType r2 = com.taobao.accs.base.TaoBaseService.ExtHeaderType.TYPE_LOCATION     // Catch: java.lang.Throwable -> L83
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L83
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.Object r9 = r9.get(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L83
            boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L86
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "start anti bursh location:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L83
            r2.append(r9)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L83
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L83
            com.taobao.accs.utl.ALog.e(r0, r2, r3)     // Catch: java.lang.Throwable -> L83
            r7.handleAntiBrush(r9)     // Catch: java.lang.Throwable -> L83
            java.util.concurrent.ScheduledFuture<?> r9 = com.taobao.accs.antibrush.AntiBrush.mTimeoutTask     // Catch: java.lang.Throwable -> L83
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L69
            r9.cancel(r3)     // Catch: java.lang.Throwable -> L83
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r2     // Catch: java.lang.Throwable -> L83
        L69:
            com.taobao.accs.antibrush.a r9 = new com.taobao.accs.antibrush.a     // Catch: java.lang.Throwable -> L83
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L83
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L83
            r5 = 60000(0xea60, double:2.9644E-319)
            java.util.concurrent.ScheduledFuture r9 = com.taobao.accs.common.ThreadPoolExecutorFactory.schedule(r9, r5, r4)     // Catch: java.lang.Throwable -> L83
            com.taobao.accs.antibrush.AntiBrush.mTimeoutTask = r9     // Catch: java.lang.Throwable -> L83
            if (r8 != 0) goto L7c
            goto L80
        L7c:
            java.lang.String r2 = r8.getHost()     // Catch: java.lang.Throwable -> L83
        L80:
            com.taobao.accs.antibrush.AntiBrush.mHost = r2     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r8 = move-exception
            r3 = 0
            goto La9
        L86:
            r3 = 0
        L87:
            java.lang.String r8 = com.taobao.accs.client.GlobalClientInfo.f9033c     // Catch: java.lang.Throwable -> La8
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> La8
            if (r8 != 0) goto Lb0
            java.lang.String r8 = com.taobao.accs.antibrush.AntiBrush.mHost     // Catch: java.lang.Throwable -> La8
            java.lang.String r8 = com.taobao.accs.antibrush.b.a(r8)     // Catch: java.lang.Throwable -> La8
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto Lb0
            java.lang.String r8 = "cookie invalid, clear"
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> La8
            com.taobao.accs.utl.ALog.e(r0, r8, r9)     // Catch: java.lang.Throwable -> La8
            android.content.Context r8 = r7.mContext     // Catch: java.lang.Throwable -> La8
            com.taobao.accs.utl.UtilityImpl.n(r8)     // Catch: java.lang.Throwable -> La8
            goto Lb0
        La8:
            r8 = move-exception
        La9:
            java.lang.String r9 = "checkAntiBrush error"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.taobao.accs.utl.ALog.e(r0, r9, r8, r1)
        Lb0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.antibrush.AntiBrush.checkAntiBrush(java.net.URL, java.util.Map):boolean");
    }
}
