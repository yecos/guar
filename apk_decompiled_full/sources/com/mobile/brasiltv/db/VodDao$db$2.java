package com.mobile.brasiltv.db;

import android.content.Context;
import s9.a;
import t9.j;

/* loaded from: classes3.dex */
public final class VodDao$db$2 extends j implements a {
    final /* synthetic */ VodDao this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodDao$db$2(VodDao vodDao) {
        super(0);
        this.this$0 = vodDao;
    }

    @Override // s9.a
    public final ra.a invoke() {
        Context context;
        String str;
        boolean z10;
        int i10;
        context = this.this$0.ctx;
        str = this.this$0.DATABASE_NAME;
        z10 = this.this$0.DUBUG_MODEL;
        i10 = this.this$0.DB_VERSION;
        return ra.a.b(context, str, z10, i10, this.this$0);
    }
}
