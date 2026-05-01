package com.uyumao;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.uyumao.g;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class f extends Handler {
    public f(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 256) {
            return;
        }
        int i10 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i10 / 100);
        HashMap<Integer, g.a> hashMap = g.f12410c;
        if (hashMap == null) {
            return;
        }
        g.a aVar = hashMap.containsKey(valueOf) ? g.f12410c.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i10);
        }
    }
}
