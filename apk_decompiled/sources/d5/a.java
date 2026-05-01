package d5;

import com.mobile.bean.UpdateBean;
import j7.e;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
public class a implements Converter {
    @Override // retrofit2.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UpdateBean convert(ResponseBody responseBody) {
        return e.a(responseBody.byteStream());
    }
}
