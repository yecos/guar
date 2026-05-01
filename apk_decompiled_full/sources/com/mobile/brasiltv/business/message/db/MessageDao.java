package com.mobile.brasiltv.business.message.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import ba.t;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.business.message.inapp.bean.CouponNumRecord;
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
    */
    public final int queryCouponNum(String str) {
        boolean z10;
        i.g(str, "userId");
        try {
            List m10 = this.f8273db.m(CouponNumRecord.class, "userId='" + str + '\'');
            if (m10 != null && !m10.isEmpty()) {
                z10 = false;
                if (z10) {
                    return ((CouponNumRecord) m10.get(0)).getNum();
                }
                return 0;
            }
            z10 = true;
            if (z10) {
            }
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return 0;
                }
            }
            throw e10;
        }
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
    */
    public final void updateCouponNum(String str, int i10) {
        boolean z10;
        i.g(str, "userId");
        try {
            List m10 = this.f8273db.m(CouponNumRecord.class, "userId='" + str + '\'');
            if (m10 != null && !m10.isEmpty()) {
                z10 = false;
                if (z10) {
                    ((CouponNumRecord) m10.get(0)).setUserId(str);
                    ((CouponNumRecord) m10.get(0)).setNum(i10);
                    this.f8273db.t(m10.get(0));
                    return;
                } else {
                    CouponNumRecord couponNumRecord = new CouponNumRecord();
                    couponNumRecord.setUserId(str);
                    couponNumRecord.setNum(i10);
                    this.f8273db.r(couponNumRecord);
                    return;
                }
            }
            z10 = true;
            if (z10) {
            }
        } catch (RuntimeException e10) {
            e10.printStackTrace();
            String message = e10.getMessage();
            if (!TextUtils.isEmpty(message)) {
                i.d(message);
                if (t.o(message, "Could not allocate CursorWindow", false, 2, null)) {
                    return;
                }
            }
            throw e10;
        }
    }
}
