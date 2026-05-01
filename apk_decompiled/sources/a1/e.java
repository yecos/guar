package a1;

import android.app.Notification;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f108b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f109c;

    public e(int i10, Notification notification, int i11) {
        this.f107a = i10;
        this.f109c = notification;
        this.f108b = i11;
    }

    public int a() {
        return this.f108b;
    }

    public Notification b() {
        return this.f109c;
    }

    public int c() {
        return this.f107a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f107a == eVar.f107a && this.f108b == eVar.f108b) {
            return this.f109c.equals(eVar.f109c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f107a * 31) + this.f108b) * 31) + this.f109c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f107a + ", mForegroundServiceType=" + this.f108b + ", mNotification=" + this.f109c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
