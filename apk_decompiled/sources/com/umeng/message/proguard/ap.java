package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ap implements Externalizable {
    private static final long serialVersionUID = -1;

    /* renamed from: a, reason: collision with root package name */
    public UMessage f11535a;

    /* renamed from: b, reason: collision with root package name */
    long f11536b;

    /* renamed from: c, reason: collision with root package name */
    public int f11537c;

    public ap(UMessage uMessage) {
        this.f11535a = uMessage;
        this.f11536b = System.currentTimeMillis();
        a();
    }

    private void a() {
        JSONObject optJSONObject = this.f11535a.getRaw().optJSONObject("u");
        if (optJSONObject != null) {
            this.f11537c = optJSONObject.optInt("ia");
        }
    }

    public final boolean equals(Object obj) {
        UMessage uMessage;
        UMessage uMessage2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ap)) {
            return false;
        }
        ap apVar = (ap) obj;
        if (hashCode() != apVar.hashCode() || (uMessage = this.f11535a) == null || (uMessage2 = apVar.f11535a) == null) {
            return false;
        }
        if (uMessage == uMessage2) {
            return true;
        }
        return TextUtils.equals(uMessage.getRaw().toString(), apVar.f11535a.getRaw().toString());
    }

    public final int hashCode() {
        UMessage uMessage = this.f11535a;
        return uMessage == null ? super.hashCode() : uMessage.getRaw() == null ? super.hashCode() : this.f11535a.getRaw().hashCode();
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        this.f11536b = objectInput.readLong();
        try {
            this.f11535a = new UMessage(new JSONObject((String) objectInput.readObject()));
            a();
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    public final String toString() {
        UMessage uMessage = this.f11535a;
        return uMessage == null ? "" : uMessage.getMsgId();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeLong(this.f11536b);
        objectOutput.writeObject(this.f11535a.getRaw().toString());
        objectOutput.writeObject(null);
    }

    public ap() {
    }
}
