package com.uyumao;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public long f12411a = 0;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12413b;

        public a(h hVar, Context context, JSONObject jSONObject) {
            this.f12412a = context;
            this.f12413b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f12412a.getCacheDir().getPath() + File.separator + "net_change");
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12413b.toString());
            sb.append("\n");
            e.a(file, sb.toString().getBytes(), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010e A[Catch: all -> 0x0126, TRY_LEAVE, TryCatch #2 {all -> 0x0126, blocks: (B:3:0x0002, B:5:0x000c, B:9:0x0015, B:11:0x0032, B:13:0x0038, B:15:0x003e, B:18:0x004a, B:20:0x0054, B:21:0x005f, B:38:0x010e, B:44:0x0123, B:51:0x0108, B:55:0x006e, B:57:0x0074, B:59:0x007a, B:60:0x0087, B:62:0x008d, B:64:0x0093, B:66:0x0099, B:69:0x00a5, B:71:0x00af, B:40:0x0111), top: B:2:0x0002, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r12, android.content.Intent r13) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.h.onReceive(android.content.Context, android.content.Intent):void");
    }
}
