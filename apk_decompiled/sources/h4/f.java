package h4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class f extends e {
    public e[] E = N();
    public int F;

    public f() {
        L();
        M(this.E);
    }

    public void I(Canvas canvas) {
        e[] eVarArr = this.E;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                int save = canvas.save();
                eVar.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    public e J(int i10) {
        e[] eVarArr = this.E;
        if (eVarArr == null) {
            return null;
        }
        return eVarArr[i10];
    }

    public int K() {
        e[] eVarArr = this.E;
        if (eVarArr == null) {
            return 0;
        }
        return eVarArr.length;
    }

    public final void L() {
        e[] eVarArr = this.E;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setCallback(this);
            }
        }
    }

    public void M(e... eVarArr) {
    }

    public abstract e[] N();

    @Override // h4.e
    public void b(Canvas canvas) {
    }

    @Override // h4.e
    public ValueAnimator c() {
        return null;
    }

    @Override // h4.e, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        I(canvas);
    }

    @Override // h4.e, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return f4.a.b(this.E) || super.isRunning();
    }

    @Override // h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (e eVar : this.E) {
            eVar.setBounds(rect);
        }
    }

    @Override // h4.e, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        f4.a.d(this.E);
    }

    @Override // h4.e, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        f4.a.e(this.E);
    }

    @Override // h4.e
    public void t(int i10) {
        this.F = i10;
        for (int i11 = 0; i11 < K(); i11++) {
            J(i11).t(i10);
        }
    }
}
