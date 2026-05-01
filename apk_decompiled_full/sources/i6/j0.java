package i6;

import mobile.com.requestframe.utils.response.ExchangeData;

/* loaded from: classes3.dex */
public interface j0 extends m5.a {

    public static final class a {
        public static /* synthetic */ void a(j0 j0Var, String str, ExchangeData exchangeData, String str2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onExchangeFail");
            }
            if ((i10 & 2) != 0) {
                exchangeData = null;
            }
            if ((i10 & 4) != 0) {
                str2 = "";
            }
            j0Var.W(str, exchangeData, str2);
        }
    }

    void S1();

    void W(String str, ExchangeData exchangeData, String str2);

    void o2(int i10);

    void showLoading(boolean z10);
}
