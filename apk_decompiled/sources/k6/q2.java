package k6;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.gson.GsonBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import i6.j0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import mobile.com.requestframe.utils.bean.ResultException;
import mobile.com.requestframe.utils.response.AuthInfo;
import mobile.com.requestframe.utils.response.ExchangeData;
import mobile.com.requestframe.utils.response.ExchangeResult;

/* loaded from: classes3.dex */
public final class q2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15489a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.j0 f15490b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15491c;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15493b;

        public a(String str) {
            this.f15493b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ExchangeResult exchangeResult) {
            List<AuthInfo> authInfoList;
            t9.i.g(exchangeResult, "t");
            ExchangeData data = exchangeResult.getData();
            if ((data == null || (authInfoList = data.getAuthInfoList()) == null || authInfoList.isEmpty()) ? false : true) {
                xa.c.c().m(new UpdateMineViewEvent());
            }
            q2.this.p().showLoading(false);
            q2.this.p().S1();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            if (th instanceof ResultException) {
                ResultException resultException = (ResultException) th;
                if (TextUtils.isEmpty(resultException.getErrorData())) {
                    return;
                }
                q2 q2Var = q2.this;
                String returnCode = resultException.getReturnCode();
                t9.i.f(returnCode, "e.returnCode");
                String errorData = resultException.getErrorData();
                t9.i.f(errorData, "e.errorData");
                q2Var.l(returnCode, errorData, this.f15493b);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            q2.this.f15491c = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            q2.this.p().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
                q2.m(q2.this, str, null, null, 6, null);
            }
        }
    }

    public q2(f5.c cVar, i6.j0 j0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(j0Var, "view");
        this.f15489a = cVar;
        this.f15490b = j0Var;
    }

    public static /* synthetic */ void m(q2 q2Var, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        q2Var.l(str, str2, str3);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void j() {
        Disposable disposable;
        Disposable disposable2 = this.f15491c;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f15491c) != null) {
            disposable.dispose();
        }
        this.f15491c = null;
    }

    public void k(String str) {
        t9.i.g(str, "exchangeCode");
        String o10 = o(str);
        if (TextUtils.isEmpty(o10)) {
            this.f15490b.o2(R.string.redemption_please_exchange_code);
        } else if (o10.length() != 16) {
            this.f15490b.o2(R.string.redemption_input_correct_code);
        } else {
            this.f15490b.showLoading(true);
            w6.i.f19214g.b().a1(o10).compose(this.f15489a.O1()).subscribe(new a(str));
        }
    }

    public final void l(String str, String str2, String str3) {
        if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
            j0.a.a(this.f15490b, "-1", null, null, 6, null);
            return;
        }
        this.f15490b.W(str, (ExchangeData) new GsonBuilder().disableHtmlEscaping().create().fromJson(str2, ExchangeData.class), str3);
        t9.i.b(str, "aaa40002");
    }

    public final void n(EditText editText, TextWatcher textWatcher) {
        t9.i.g(editText, "edit");
        t9.i.g(textWatcher, "textWatcher");
        editText.removeTextChangedListener(textWatcher);
        String j10 = ba.s.j(ba.s.j(editText.getText().toString(), " ", "", false, 4, null), Operator.Operation.MINUS, "", false, 4, null);
        String str = "";
        int i10 = 0;
        for (int i11 = 0; i11 < j10.length(); i11++) {
            char charAt = j10.charAt(i11);
            i10++;
            str = i10 % 4 == 0 ? str + charAt + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER : str + charAt;
        }
        editText.setText(str);
        editText.addTextChangedListener(textWatcher);
    }

    public final String o(String str) {
        t9.i.g(str, Constants.KEY_HTTP_CODE);
        return ba.s.j(ba.s.j(str, " ", "", false, 4, null), Operator.Operation.MINUS, "", false, 4, null);
    }

    public final i6.j0 p() {
        return this.f15490b;
    }
}
