package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public TextView f1501a;

    /* renamed from: b, reason: collision with root package name */
    public TextClassifier f1502b;

    public g0(TextView textView) {
        this.f1501a = (TextView) a0.h.d(textView);
    }

    public TextClassifier a() {
        Object systemService;
        TextClassifier textClassifier;
        TextClassifier textClassifier2;
        TextClassifier textClassifier3 = this.f1502b;
        if (textClassifier3 != null) {
            return textClassifier3;
        }
        systemService = this.f1501a.getContext().getSystemService((Class<Object>) c0.a());
        TextClassificationManager a10 = d0.a(systemService);
        if (a10 != null) {
            textClassifier2 = a10.getTextClassifier();
            return textClassifier2;
        }
        textClassifier = TextClassifier.NO_OP;
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f1502b = textClassifier;
    }
}
