package k2;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class a extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public float f14800a = 2.1474836E9f;

    /* renamed from: b, reason: collision with root package name */
    public final float f14801b;

    /* renamed from: c, reason: collision with root package name */
    public final WheelView f14802c;

    public a(WheelView wheelView, float f10) {
        this.f14802c = wheelView;
        this.f14801b = f10;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f14800a == 2.1474836E9f) {
            if (Math.abs(this.f14801b) <= 2000.0f) {
                this.f14800a = this.f14801b;
            } else if (this.f14801b > 0.0f) {
                this.f14800a = 2000.0f;
            } else {
                this.f14800a = -2000.0f;
            }
        }
        if (Math.abs(this.f14800a) >= 0.0f && Math.abs(this.f14800a) <= 20.0f) {
            this.f14802c.a();
            this.f14802c.f6003c.sendEmptyMessage(2000);
            return;
        }
        int i10 = (int) ((this.f14800a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f14802c;
        float f10 = i10;
        wheelView.f6021u -= f10;
        if (!wheelView.f6020t) {
            float f11 = wheelView.f6014n;
            float f12 = (-wheelView.f6022v) * f11;
            int itemsCount = wheelView.getItemsCount() - 1;
            WheelView wheelView2 = this.f14802c;
            float f13 = (itemsCount - wheelView2.f6022v) * f11;
            float f14 = wheelView2.f6021u;
            double d10 = f14;
            double d11 = f11;
            Double.isNaN(d11);
            double d12 = d11 * 0.25d;
            Double.isNaN(d10);
            if (d10 - d12 < f12) {
                f12 = f14 + f10;
            } else {
                double d13 = f14;
                Double.isNaN(d13);
                if (d13 + d12 > f13) {
                    f13 = f14 + f10;
                }
            }
            if (f14 <= f12) {
                this.f14800a = 40.0f;
                wheelView2.f6021u = (int) f12;
            } else if (f14 >= f13) {
                wheelView2.f6021u = (int) f13;
                this.f14800a = -40.0f;
            }
        }
        float f15 = this.f14800a;
        if (f15 < 0.0f) {
            this.f14800a = f15 + 20.0f;
        } else {
            this.f14800a = f15 - 20.0f;
        }
        this.f14802c.f6003c.sendEmptyMessage(1000);
    }
}
