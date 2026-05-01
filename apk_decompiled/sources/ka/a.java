package ka;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface a {
    @Streaming
    @GET
    Observable<ResponseBody> a(@Url String str);
}
