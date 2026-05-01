package com.mobile.brasiltv.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.s;
import com.mobile.brasiltv.view.CleanableEditText;
import com.mobile.brasiltv.view.KoocanButton;
import com.msandroid.mobile.R;
import f5.c;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;

/* loaded from: classes3.dex */
public final class FindPwdByPhoneAty extends c {

    /* renamed from: k, reason: collision with root package name */
    public Map f8334k = new LinkedHashMap();

    public View R2(int i10) {
        Map map = this.f8334k;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void S2() {
        s sVar = s.f8745a;
        CleanableEditText cleanableEditText = (CleanableEditText) R2(R$id.mEditNewPwd);
        i.f(cleanableEditText, "mEditNewPwd");
        CleanableEditText cleanableEditText2 = (CleanableEditText) R2(R$id.mEditNewPwdAgain);
        i.f(cleanableEditText2, "mEditNewPwdAgain");
        KoocanButton koocanButton = (KoocanButton) R2(R$id.mButtonCommit);
        i.f(koocanButton, "mButtonCommit");
        sVar.h(cleanableEditText, cleanableEditText2, koocanButton);
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_find_pwd_by_phone);
        ((TextView) R2(R$id.mTextAccount)).setText(getIntent().getStringExtra("intent_username"));
        S2();
    }
}
