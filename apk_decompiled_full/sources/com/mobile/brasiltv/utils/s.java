package com.mobile.brasiltv.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f8745a = new s();

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Button f8746a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Button button) {
            super(1);
            this.f8746a = button;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            s sVar = s.f8745a;
            t9.i.f(bool, "it");
            sVar.e(bool.booleanValue(), this.f8746a);
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f8747a;

        public b(ObservableEmitter observableEmitter) {
            this.f8747a = observableEmitter;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            t9.i.g(editable, "s");
            this.f8747a.onNext(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if ((r3.length() > 0) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Boolean g(Editable editable, Editable editable2) {
        t9.i.g(editable, "t1");
        t9.i.g(editable2, "t2");
        boolean z10 = true;
        if (editable.length() > 0) {
        }
        z10 = false;
        return Boolean.valueOf(z10);
    }

    public static final void i(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k(EditText editText, ObservableEmitter observableEmitter) {
        t9.i.g(editText, "$editText");
        t9.i.g(observableEmitter, "subscriber");
        editText.addTextChangedListener(new b(observableEmitter));
    }

    public final void e(boolean z10, Button button) {
        if (z10) {
            button.setEnabled(true);
            button.setAlpha(1.0f);
        } else {
            button.setEnabled(false);
            button.setAlpha(0.6f);
        }
    }

    public final Observable f(EditText editText, EditText editText2) {
        t9.i.g(editText, "edit1");
        t9.i.g(editText2, "edit2");
        Observable combineLatest = Observable.combineLatest(j(editText), j(editText2), new BiFunction() { // from class: com.mobile.brasiltv.utils.q
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean g10;
                g10 = s.g((Editable) obj, (Editable) obj2);
                return g10;
            }
        });
        t9.i.f(combineLatest, "combineLatest(create(edi…2.isNotEmpty()\n        })");
        return combineLatest;
    }

    public final void h(EditText editText, EditText editText2, Button button) {
        t9.i.g(editText, "edit1");
        t9.i.g(editText2, "edit2");
        t9.i.g(button, "button");
        Observable f10 = f(editText, editText2);
        final a aVar = new a(button);
        f10.subscribe(new Consumer() { // from class: com.mobile.brasiltv.utils.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                s.i(s9.l.this, obj);
            }
        });
    }

    public final Observable j(final EditText editText) {
        t9.i.g(editText, "editText");
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: com.mobile.brasiltv.utils.r
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                s.k(editText, observableEmitter);
            }
        });
        t9.i.f(create, "create({ subscriber ->\n …            })\n        })");
        return create;
    }
}
