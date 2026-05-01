package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.i;

/* loaded from: classes.dex */
public class b extends d {

    public class a implements i.a {
        public a() {
        }

        @Override // androidx.cardview.widget.i.a
        public void a(Canvas canvas, RectF rectF, float f10, Paint paint) {
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
    }

    @Override // androidx.cardview.widget.f
    public void l() {
        i.f1775r = new a();
    }
}
