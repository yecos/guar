package f7;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.mobile.brasiltv.utils.zxing.view.ViewfinderView;

/* loaded from: classes3.dex */
public final class a implements ResultPointCallback {

    /* renamed from: a, reason: collision with root package name */
    public final ViewfinderView f13319a;

    public a(ViewfinderView viewfinderView) {
        this.f13319a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f13319a.a(resultPoint);
    }
}
