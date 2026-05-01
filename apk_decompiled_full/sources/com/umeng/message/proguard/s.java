package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class s implements ActionInfo {
    @Override // com.umeng.ccg.ActionInfo
    public final String getModule(Context context) {
        return "push";
    }

    @Override // com.umeng.ccg.ActionInfo
    public final String[] getSupportAction(Context context) {
        return new String[]{com.umeng.ccg.a.f10645e};
    }

    @Override // com.umeng.ccg.ActionInfo
    public final boolean getSwitchState(Context context, String str) {
        if (TextUtils.equals(str, com.umeng.ccg.a.f10645e)) {
            return f.f12083a;
        }
        return false;
    }

    @Override // com.umeng.ccg.ActionInfo
    public final void onCommand(Context context, String str, Object obj) {
        Future<?> future;
        if (TextUtils.equals(str, com.umeng.ccg.a.f10645e) && (obj instanceof JSONObject) && f.b(context)) {
            JSONObject jSONObject = (JSONObject) obj;
            WeakReference<Future<?>> weakReference = o.f12125a;
            if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
                o.f12125a = new WeakReference<>(b.b(new n(jSONObject)));
            }
        }
    }
}
