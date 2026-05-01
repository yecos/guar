package c5;

import com.mobile.bean.UpdateBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface b {
    @GET("/MarketServer/update")
    Observable<UpdateBean> a(@Query("action") String str, @Query("packagenamesAndVersioncodes") String str2, @Query("language") String str3, @Query("sn") String str4, @Query("userId") String str5);
}
