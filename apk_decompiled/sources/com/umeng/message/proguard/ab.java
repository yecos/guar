package com.umeng.message.proguard;

import com.umeng.message.api.UPushAliasCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
abstract class ab {
    public abstract void a();

    public abstract void a(String str);

    public abstract void a(String str, int i10);

    public abstract void a(String str, int i10, String str2);

    public abstract void a(String str, String str2, int i10);

    public abstract void a(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback);

    public abstract void b(String str, int i10);

    public abstract void b(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback);

    public abstract void c(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback);
}
