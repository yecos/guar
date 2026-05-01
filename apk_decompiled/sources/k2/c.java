package k2;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class c extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public int f14804a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f14805b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f14806c;

    /* renamed from: d, reason: collision with root package name */
    public final WheelView f14807d;

    public c(WheelView wheelView, int i10) {
        this.f14807d = wheelView;
        this.f14806c = i10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f14804a == Integer.MAX_VALUE) {
            this.f14804a = this.f14806c;
        }
        int i10 = this.f14804a;
        int i11 = (int) (i10 * 0.1f);
        this.f14805b = i11;
        if (i11 == 0) {
            if (i10 < 0) {
                this.f14805b = -1;
            } else {
                this.f14805b = 1;
            }
        }
        if (Math.abs(i10) <= 1) {
            this.f14807d.a();
            this.f14807d.f6003c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f14807d;
        wheelView.f6021u += this.f14805b;
        if (!wheelView.f6020t) {
            float f10 = wheelView.f6014n;
            float f11 = (-wheelView.f6022v) * f10;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.f14807d;
            float f12 = (itemsCount - wheelView2.f6022v) * f10;
            float f13 = wheelView2.f6021u;
            if (f13 <= f11 || f13 >= f12) {
                wheelView2.f6021u = f13 - this.f14805b;
                wheelView2.a();
                this.f14807d.f6003c.sendEmptyMessage(3000);
                return;
            }
        }
        this.f14807d.f6003c.sendEmptyMessage(1000);
        this.f14804a -= this.f14805b;
    }
}
