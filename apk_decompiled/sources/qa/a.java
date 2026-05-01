package qa;

import io.reactivex.Observable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ConfigCenterResponse;
import mobile.com.requestframe.utils.response.GetAddrResult;
import mobile.com.requestframe.utils.response.JsonEpgResult;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface a {
    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/configCenter/config/get")
    Observable<ConfigCenterResponse> a(@Body RequestBody requestBody);

    @GET
    Observable<ArrayList<JsonEpgResult>> b(@Url String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/v2/dcs/getAddr")
    Observable<GetAddrResult> c(@Body RequestBody requestBody);
}
