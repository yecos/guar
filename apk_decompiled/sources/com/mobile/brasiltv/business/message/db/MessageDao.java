package com.mobile.brasiltv.business.message.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import ba.t;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.umeng.analytics.pro.f;
import java.util.List;
import ra.a;
import t9.i;

/* loaded from: classes3.dex */
public final class MessageDao implements a.b {
    private final String DATABASE_NAME;
    private final int DB_VERSION;

    /* renamed from: db, reason: collision with root package name */
    private final a f8273db;

    public MessageDao(Context context) {
        i.g(context, f.X);
        this.DB_VERSION = 1;
        this.DATABASE_NAME = "cs_msg.db";
        a b10 = a.b(context, "cs_msg.db", false, 1, this);
        i.f(b10, "create(context, DATABASE….DEBUG, DB_VERSION, this)");
        this.f8273db = b10;
    }

    public final void addInAppMsg(InAppMsg inAppMsg) {
        i.g(inAppMsg, Constant.KEY_MSG);
        this.f8273db.r(inAppMsg);
    }

    public final void deleteInAppMsg(InAppMsg inAppMsg) {
        i.g(inAppMsg, Constant.KEY_MSG);
        this.f8273db.e(inAppMsg);
    }

    public final void deleteInAppMsgByType(String str, String str2) {
        i.g(str, "messageType");
        i.g(str2, "type");
        this.f8273db.h(InAppMsg.class, "messageType='" + str + "' and type='" + str2 + '\'');
    }

    @Override // ra.a.b
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // ra.a.b
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: RuntimeException -> 0x003e, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x003e, blocks: (B:3:0x0006, B:5:0x0026, B:12:0x0033), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int queryCouponNum(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "userId"
            t9.i.g(r6, r0)
            r0 = 0
            ra.a r1 = r5.f8273db     // Catch: java.lang.RuntimeException -> L3e
            java.lang.Class<com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord> r2 = com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord.class
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L3e
            r3.<init>()     // Catch: java.lang.RuntimeException -> L3e
            java.lang.String r4 = "userId='"
            r3.append(r4)     // Catch: java.lang.RuntimeException -> L3e
            r3.append(r6)     // Catch: java.lang.RuntimeException -> L3e
            r6 = 39
            r3.append(r6)     // Catch: java.lang.RuntimeException -> L3e
            java.lang.String r6 = r3.toString()     // Catch: java.lang.RuntimeException -> L3e
            java.util.List r6 = r1.m(r2, r6)     // Catch: java.lang.RuntimeException -> L3e
            if (r6 == 0) goto L2f
            boolean r1 = r6.isEmpty()     // Catch: java.lang.RuntimeException -> L3e
            if (r1 == 0) goto L2d
            goto L2f
        L2d:
            r1 = 0
            goto L30
        L2f:
            r1 = 1
        L30:
            if (r1 == 0) goto L33
            return r0
        L33:
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.RuntimeException -> L3e
            com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord r6 = (com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord) r6     // Catch: java.lang.RuntimeException -> L3e
            int r6 = r6.getNum()     // Catch: java.lang.RuntimeException -> L3e
            return r6
        L3e:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.String r1 = r6.getMessage()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L5a
            t9.i.d(r1)
            r2 = 2
            r3 = 0
            java.lang.String r4 = "Could not allocate CursorWindow"
            boolean r1 = ba.t.o(r1, r4, r0, r2, r3)
            if (r1 == 0) goto L5a
            return r0
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.business.message.db.MessageDao.queryCouponNum(java.lang.String):int");
    }

    public final List<InAppMsg> queryInAppMsgByMsgType(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        try {
            return this.f8273db.n(InAppMsg.class, "userId='" + str + "' and messageType='" + str2 + '\'', "id DESC");
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return null;
                }
            }
            throw e10;
        }
    }

    public final List<InAppMsg> queryInAppMsgList(String str, String str2, String str3) {
        i.g(str, "userId");
        i.g(str2, "messageType");
        i.g(str3, "type");
        try {
            return this.f8273db.n(InAppMsg.class, "userId='" + str + "' and messageType='" + str2 + "' and type='" + str3 + '\'', "id DESC");
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return null;
                }
            }
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[Catch: RuntimeException -> 0x005f, TryCatch #0 {RuntimeException -> 0x005f, blocks: (B:3:0x0006, B:5:0x0026, B:10:0x0032, B:13:0x0043), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: RuntimeException -> 0x005f, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x005f, blocks: (B:3:0x0006, B:5:0x0026, B:10:0x0032, B:13:0x0043), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateCouponNum(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "userId"
            t9.i.g(r6, r0)
            r0 = 0
            ra.a r1 = r5.f8273db     // Catch: java.lang.RuntimeException -> L5f
            java.lang.Class<com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord> r2 = com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord.class
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.RuntimeException -> L5f
            r3.<init>()     // Catch: java.lang.RuntimeException -> L5f
            java.lang.String r4 = "userId='"
            r3.append(r4)     // Catch: java.lang.RuntimeException -> L5f
            r3.append(r6)     // Catch: java.lang.RuntimeException -> L5f
            r4 = 39
            r3.append(r4)     // Catch: java.lang.RuntimeException -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.RuntimeException -> L5f
            java.util.List r1 = r1.m(r2, r3)     // Catch: java.lang.RuntimeException -> L5f
            if (r1 == 0) goto L2f
            boolean r2 = r1.isEmpty()     // Catch: java.lang.RuntimeException -> L5f
            if (r2 == 0) goto L2d
            goto L2f
        L2d:
            r2 = 0
            goto L30
        L2f:
            r2 = 1
        L30:
            if (r2 == 0) goto L43
            com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord r1 = new com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord     // Catch: java.lang.RuntimeException -> L5f
            r1.<init>()     // Catch: java.lang.RuntimeException -> L5f
            r1.setUserId(r6)     // Catch: java.lang.RuntimeException -> L5f
            r1.setNum(r7)     // Catch: java.lang.RuntimeException -> L5f
            ra.a r6 = r5.f8273db     // Catch: java.lang.RuntimeException -> L5f
            r6.r(r1)     // Catch: java.lang.RuntimeException -> L5f
            return
        L43:
            java.lang.Object r2 = r1.get(r0)     // Catch: java.lang.RuntimeException -> L5f
            com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord r2 = (com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord) r2     // Catch: java.lang.RuntimeException -> L5f
            r2.setUserId(r6)     // Catch: java.lang.RuntimeException -> L5f
            java.lang.Object r6 = r1.get(r0)     // Catch: java.lang.RuntimeException -> L5f
            com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord r6 = (com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord) r6     // Catch: java.lang.RuntimeException -> L5f
            r6.setNum(r7)     // Catch: java.lang.RuntimeException -> L5f
            ra.a r6 = r5.f8273db     // Catch: java.lang.RuntimeException -> L5f
            java.lang.Object r7 = r1.get(r0)     // Catch: java.lang.RuntimeException -> L5f
            r6.t(r7)     // Catch: java.lang.RuntimeException -> L5f
            return
        L5f:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.String r7 = r6.getMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L7b
            t9.i.d(r7)
            r1 = 2
            r2 = 0
            java.lang.String r3 = "Could not allocate CursorWindow"
            boolean r7 = ba.t.o(r7, r3, r0, r1, r2)
            if (r7 == 0) goto L7b
            return
        L7b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.business.message.db.MessageDao.updateCouponNum(java.lang.String, int):void");
    }
}
