package com.uc.crashsdk.a;

import com.google.android.gms.cast.MediaError;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9618a = true;

    /* renamed from: b, reason: collision with root package name */
    private final int f9619b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f9620c;

    public e(int i10) {
        this.f9619b = i10;
        this.f9620c = null;
    }

    public final boolean a() {
        int i10 = this.f9619b;
        if (i10 == 451 || i10 == 452) {
            return com.uc.crashsdk.e.b(i10, this.f9620c);
        }
        switch (i10) {
            case 351:
            case 352:
            case 353:
            case 354:
                return h.b(i10, this.f9620c);
            default:
                switch (i10) {
                    case 751:
                    case 752:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return com.uc.crashsdk.f.a(i10, this.f9620c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (f9618a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = this.f9619b;
        if (i10 == 10) {
            f.a(i10, this.f9620c);
            return;
        }
        if (i10 == 500) {
            d.a(i10);
            return;
        }
        if (i10 == 700) {
            com.uc.crashsdk.f.b(i10);
            return;
        }
        if (i10 == 800) {
            g.a(i10);
            return;
        }
        if (i10 == 201 || i10 == 202) {
            com.uc.crashsdk.a.a(i10);
            return;
        }
        switch (i10) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                com.uc.crashsdk.b.a(i10);
                return;
            default:
                switch (i10) {
                    case 301:
                    case 302:
                    case 303:
                        h.a(i10, this.f9620c);
                        return;
                    default:
                        switch (i10) {
                            case 401:
                            case 402:
                            case UPnPStatus.OUT_OF_SYNC /* 403 */:
                                break;
                            default:
                                switch (i10) {
                                    case 405:
                                    case 406:
                                    case 407:
                                    case 408:
                                    case 409:
                                    case Constant.TOKEN_EXPIRED /* 410 */:
                                    case MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER /* 411 */:
                                    case 412:
                                    case 413:
                                    case 414:
                                    case 415:
                                    case 416:
                                        break;
                                    default:
                                        a.d("crashsdk", "Unknown async runnable: " + toString());
                                        if (!f9618a) {
                                            throw new AssertionError();
                                        }
                                        return;
                                }
                        }
                        com.uc.crashsdk.e.a(i10, this.f9620c);
                        return;
                }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f9619b;
    }

    public e(int i10, Object[] objArr) {
        this.f9619b = i10;
        this.f9620c = objArr;
    }
}
