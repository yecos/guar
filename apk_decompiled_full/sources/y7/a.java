package y7;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import t9.i;

/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final ApiException f19769a;

    public a(ApiException apiException) {
        i.g(apiException, "e");
        this.f19769a = apiException;
    }

    @Override // y7.b
    public boolean a() {
        return this.f19769a.getStatusCode() == Status.RESULT_INTERNAL_ERROR.getStatusCode() || this.f19769a.getStatusCode() == Status.RESULT_TIMEOUT.getStatusCode() || this.f19769a.getStatusCode() == 7;
    }

    @Override // y7.b
    public boolean b() {
        return this.f19769a.getStatusCode() == 12500;
    }
}
