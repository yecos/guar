package com.mobile.brasiltv.db;

import android.content.Context;
import s9.a;
import t9.j;

/* loaded from: classes3.dex */
public final class MobileDao$db$2 extends j implements a {
    final /* synthetic */ MobileDao this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileDao$db$2(MobileDao mobileDao) {
        super(0);
        this.this$0 = mobileDao;
    }

    @Override // s9.a
    public final ra.a invoke() {
        Context context;
        String str;
        boolean z10;
        int i10;
        context = this.this$0.context;
        Context applicationContext = context.getApplicationContext();
        str = this.this$0.DATABASE_NAME;
        z10 = this.this$0.DUBUG_MODEL;
        i10 = this.this$0.DB_VERSION;
        return ra.a.b(applicationContext, str, z10, i10, this.this$0);
    }
}
