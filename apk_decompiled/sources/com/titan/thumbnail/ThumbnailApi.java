package com.titan.thumbnail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

/* loaded from: classes3.dex */
public interface ThumbnailApi {
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @GET
    Observable<ThumbnailResult> getThumbnail(@Url String str);
}
