package b7;

import android.text.InputFilter;
import android.text.Spanned;
import ba.s;
import ba.t;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public final class a implements InputFilter {
    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (t.o(String.valueOf(charSequence), Operator.Operation.PLUS, false, 2, null)) {
            return s.j(String.valueOf(charSequence), Operator.Operation.PLUS, "", false, 4, null);
        }
        return null;
    }
}
