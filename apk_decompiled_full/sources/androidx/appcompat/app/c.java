package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class c extends j implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class a {
        private final AlertController.f P;
        private final int mTheme;

        public a(Context context) {
            this(context, c.resolveDialogTheme(context, 0));
        }

        public c create() {
            c cVar = new c(this.P.f870a, this.mTheme);
            this.P.a(cVar.mAlert);
            cVar.setCancelable(this.P.f887r);
            if (this.P.f887r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.P.f888s);
            cVar.setOnDismissListener(this.P.f889t);
            DialogInterface.OnKeyListener onKeyListener = this.P.f890u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context getContext() {
            return this.P.f870a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f892w = listAdapter;
            fVar.f893x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z10) {
            this.P.f887r = z10;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.L = str;
            fVar.f893x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.P.f876g = view;
            return this;
        }

        public a setIcon(int i10) {
            this.P.f872c = i10;
            return this;
        }

        public a setIconAttribute(int i10) {
            TypedValue typedValue = new TypedValue();
            this.P.f870a.getTheme().resolveAttribute(i10, typedValue, true);
            this.P.f872c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z10) {
            this.P.N = z10;
            return this;
        }

        public a setItems(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = fVar.f870a.getResources().getTextArray(i10);
            this.P.f893x = onClickListener;
            return this;
        }

        public a setMessage(int i10) {
            AlertController.f fVar = this.P;
            fVar.f877h = fVar.f870a.getText(i10);
            return this;
        }

        public a setMultiChoiceItems(int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = fVar.f870a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.P;
            fVar2.J = onMultiChoiceClickListener;
            fVar2.F = zArr;
            fVar2.G = true;
            return this;
        }

        public a setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f881l = fVar.f870a.getText(i10);
            this.P.f883n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.P.f882m = drawable;
            return this;
        }

        public a setNeutralButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f884o = fVar.f870a.getText(i10);
            this.P.f886q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.P.f885p = drawable;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.f888s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.f889t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.f890u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f878i = fVar.f870a.getText(i10);
            this.P.f880k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.P.f879j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z10) {
            this.P.P = z10;
            return this;
        }

        public a setSingleChoiceItems(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = fVar.f870a.getResources().getTextArray(i10);
            AlertController.f fVar2 = this.P;
            fVar2.f893x = onClickListener;
            fVar2.I = i11;
            fVar2.H = true;
            return this;
        }

        public a setTitle(int i10) {
            AlertController.f fVar = this.P;
            fVar.f875f = fVar.f870a.getText(i10);
            return this;
        }

        public a setView(int i10) {
            AlertController.f fVar = this.P;
            fVar.f895z = null;
            fVar.f894y = i10;
            fVar.E = false;
            return this;
        }

        public c show() {
            c create = create();
            create.show();
            return create;
        }

        public a(Context context, int i10) {
            this.P = new AlertController.f(new ContextThemeWrapper(context, c.resolveDialogTheme(context, i10)));
            this.mTheme = i10;
        }

        public a setIcon(Drawable drawable) {
            this.P.f873d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.P.f877h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.P.f875f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = charSequenceArr;
            fVar.f893x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f881l = charSequence;
            fVar.f883n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f884o = charSequence;
            fVar.f886q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f878i = charSequence;
            fVar.f880k = onClickListener;
            return this;
        }

        public a setView(View view) {
            AlertController.f fVar = this.P;
            fVar.f895z = view;
            fVar.f894y = 0;
            fVar.E = false;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i10, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.f893x = onClickListener;
            fVar.I = i10;
            fVar.L = str;
            fVar.H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i10, int i11, int i12, int i13) {
            AlertController.f fVar = this.P;
            fVar.f895z = view;
            fVar.f894y = 0;
            fVar.E = true;
            fVar.A = i10;
            fVar.B = i11;
            fVar.C = i12;
            fVar.D = i13;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.P;
            fVar.K = cursor;
            fVar.J = onMultiChoiceClickListener;
            fVar.M = str;
            fVar.L = str2;
            fVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f891v = charSequenceArr;
            fVar.f893x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.P;
            fVar.f892w = listAdapter;
            fVar.f893x = onClickListener;
            fVar.I = i10;
            fVar.H = true;
            return this;
        }
    }

    public c(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i10) {
        return this.mAlert.c(i10);
    }

    public ListView getListView() {
        return this.mAlert.e();
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.mAlert.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.mAlert.i(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setButton(int i10, CharSequence charSequence, Message message) {
        this.mAlert.l(i10, charSequence, null, message, null);
    }

    public void setButtonPanelLayoutHint(int i10) {
        this.mAlert.m(i10);
    }

    public void setCustomTitle(View view) {
        this.mAlert.n(view);
    }

    public void setIcon(int i10) {
        this.mAlert.o(i10);
    }

    public void setIconAttribute(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.mAlert.o(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.p(drawable);
    }

    public void setView(View view, int i10, int i11, int i12, int i13) {
        this.mAlert.v(view, i10, i11, i12, i13);
    }

    public void setButton(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.l(i10, charSequence, onClickListener, null, drawable);
    }
}
