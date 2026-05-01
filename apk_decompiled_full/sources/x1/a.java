package x1;

import com.advertlib.bean.AdvertResult;
import com.advertlib.bean.ReportResult;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* loaded from: classes.dex */
public interface a {
    @Headers({"Content-Type:application/json;charset=utf-8"})
    @POST("{agreement}://{ip}/api/adserver/report")
    Observable<ReportResult> a(@Path("agreement") String str, @Path("ip") String str2, @Body RequestBody requestBody);

    @Headers({"Content-Type:application/json;charset=utf-8"})
    @POST("{agreement}://{ip}/api/adserver/v2/get_content")
    Observable<AdvertResult> b(@Path("agreement") String str, @Path("ip") String str2, @Body RequestBody requestBody);

    @Streaming
    @GET
    Call<ResponseBody> c(@Url String str);
}
