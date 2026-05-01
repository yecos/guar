package h7;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.autoupdate.R$string;

/* loaded from: classes3.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14210a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14211b;

    public f(Context context, String str) {
        this.f14210a = context.getApplicationContext();
        this.f14211b = str;
    }

    @Override // h7.c
    public void A(long j10, long j11) {
    }

    @Override // h7.c
    public void onFailure(Exception exc) {
        Context context = this.f14210a;
        j7.g.a(context, context.getString(R$string.common_upgrade_download_fail), 0);
        b5.a.g().n(this);
    }

    @Override // h7.c
    public void onSuccess() {
        b5.a.g().n(this);
        if (TextUtils.isEmpty(this.f14211b)) {
            return;
        }
        j7.a.c(this.f14210a, this.f14211b);
    }

    @Override // h7.c
    public void z() {
        Context context = this.f14210a;
        j7.g.a(context, context.getString(R$string.common_upgrade_downloading), 0);
    }
}
