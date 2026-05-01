package qa;

import io.reactivex.Observable;
import mobile.com.requestframe.utils.response.ActiveResult;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.AddSubscribeResult;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.ApkReceiveCouponResult;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.CancelSubscriptionResult;
import mobile.com.requestframe.utils.response.CheckForceBindResult;
import mobile.com.requestframe.utils.response.CheckGetVipResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.ConfigResult;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.DelSubscribeResult;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import mobile.com.requestframe.utils.response.ExchangeCodeResult;
import mobile.com.requestframe.utils.response.ExchangeResult;
import mobile.com.requestframe.utils.response.FeedBackContactResult;
import mobile.com.requestframe.utils.response.FilterByContentResult;
import mobile.com.requestframe.utils.response.FilterGenreResult;
import mobile.com.requestframe.utils.response.FootballMatchResult;
import mobile.com.requestframe.utils.response.FreeResult;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.GetDeviceResult;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import mobile.com.requestframe.utils.response.GetExchangeOrderInfoResult;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import mobile.com.requestframe.utils.response.GetHomeResult;
import mobile.com.requestframe.utils.response.GetItemDataResult;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import mobile.com.requestframe.utils.response.GetNextColumnResult;
import mobile.com.requestframe.utils.response.GetOrderInfoResult;
import mobile.com.requestframe.utils.response.GetPackageResult;
import mobile.com.requestframe.utils.response.GetPriorityVipResult;
import mobile.com.requestframe.utils.response.GetProgramResult;
import mobile.com.requestframe.utils.response.GetQrResult;
import mobile.com.requestframe.utils.response.GetShortVideoResult;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResult;
import mobile.com.requestframe.utils.response.GetSubscriptionRecordResult;
import mobile.com.requestframe.utils.response.GiftDaysResult;
import mobile.com.requestframe.utils.response.HeartBeatResult;
import mobile.com.requestframe.utils.response.LineupResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.MatchEventResult;
import mobile.com.requestframe.utils.response.MatchStatResult;
import mobile.com.requestframe.utils.response.MsgBoxResult;
import mobile.com.requestframe.utils.response.MsgNumResult;
import mobile.com.requestframe.utils.response.PropertiesInfoResult;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.SearchByContentData;
import mobile.com.requestframe.utils.response.SearchByNameResult;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveMatchResult;
import mobile.com.requestframe.utils.response.SnTokenResult;
import mobile.com.requestframe.utils.response.StartPlayLiveResult;
import mobile.com.requestframe.utils.response.StartPlayVODResult;
import mobile.com.requestframe.utils.response.SubResponse;
import mobile.com.requestframe.utils.response.ThirdPartResult;
import mobile.com.requestframe.utils.response.TopUserResult;
import mobile.com.requestframe.utils.response.TypeQuestionResult;
import mobile.com.requestframe.utils.response.UpdatePwdResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import mobile.com.requestframe.utils.response.UserBindResult;
import mobile.com.requestframe.utils.response.VerificationResult;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/* loaded from: classes3.dex */
public interface b {
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getExchangeOrderInfo")
    Observable<GetExchangeOrderInfoResult> A(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/filterByContent")
    Observable<FilterByContentResult> A0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/delFavorite")
    Observable<DelFavoriteResult> B(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/apkQueryCoupon")
    Observable<ApkQueryCouponResult> B0(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/checkVerifiCode")
    Observable<CheckVerificationResult> C(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/getPriorityVip")
    Observable<GetPriorityVipResult> C0(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v8/active")
    Observable<ActiveResult> D(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/getFree")
    Observable<FreeResult> D0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/package/getSubscriptionRecord")
    Observable<GetSubscriptionRecordResult> E(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/device-management/getDevice")
    Observable<GetDeviceResult> E0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v2/getShelveMatch")
    Observable<ShelveMatchResult> F(@Query("appId") String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v2/getTeamEvent")
    Observable<MatchEventResult> F0(@Query("gameId") String str);

    @Headers({"Cache-Control:no-store;Content-Type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getNextColumns")
    Observable<GetNextColumnResult> G(@Body String str);

    @POST("/api/portalCore/getTop")
    Observable<TopUserResult> G0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/filterGenre")
    Observable<FilterGenreResult> H(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("api/portalCore/reportHardInfo")
    Observable<BaseResult> H0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/package/getOrderInfo")
    Observable<GetOrderInfoResult> I(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v2/getAllMatch")
    Observable<FootballMatchResult> I0(@Query("appId") String str, @Query("match") String str2, @Query("gameId") String str3, @Query("pageSize") int i10);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getUserExchange")
    Observable<ExchangeCodeResult> J(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/updateBindEmailOrPwd")
    Observable<UpdatePwdResult> J0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v4/getItemData")
    Observable<GetItemDataResult> K(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/checkGetVip")
    Observable<CheckGetVipResult> K0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8;responseKey:NxZZ7EYgaJiJSBHjnq7sDxYvYRm32tPQ"})
    @POST("/api/subs/terminal/metadata")
    Observable<SubResponse> L(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v10/startPlayVOD")
    Observable<StartPlayVODResult> L0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/getRecommends")
    Observable<VodRecommendsRespone> M(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v4/resetPwd")
    Observable<BaseResult> N(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/box/update")
    Observable<BaseResult> O(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/box/select")
    Observable<MsgBoxResult> P(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v14/getSlbInfo")
    Observable<GetSlbInfoBeanResult> Q(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @PUT("/api/portalCore/device/updateOrInsert")
    Observable<BaseResult> R(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/pwdCheck")
    Observable<PwdCheckResult> S(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getVerifiCode")
    Observable<VerificationResult> T(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/emailResetPassNotice")
    Observable<EmailResetPwdResult> U(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getFavorite")
    Observable<GetFavoriteResult> V(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/qr/getResult")
    Observable<GetQrResult> W(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/blSearchByContent")
    Observable<SearchByContentData> X(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/package/cancelSubscription")
    Observable<CancelSubscriptionResult> Y(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/updateRestrictedStatus")
    Observable<UpdateRestrictResult> Z(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @POST("/api/portalCore/feedback/getCustomerService")
    Observable<FeedBackContactResult> a(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/getColumnContents")
    Observable<GetColumnContentsResult> a0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @POST("/api/portalCore/feedback/userFeedBack")
    Observable<BaseResult> b(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/package/getPackageCustomization")
    Observable<GetPackageResult> b0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/box/delete")
    Observable<BaseResult> c(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v3/getFootballMatch")
    Observable<FootballMatchResult> c0(@Query("appId") String str, @Query("match") String str2, @Query("date") String str3, @Query("gameId") String str4, @Query("appLanguage") String str5);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/sendEmailVerifyCode")
    Observable<BaseResult> d(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/bindPhone")
    Observable<BindPhoneResult> d0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v5/qr/getResult")
    Observable<GetQrResult> e(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getBindInfo")
    Observable<UserBindResult> e0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v10/startPlayVOD")
    Call<StartPlayVODResult> f(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v9/getAuthInfo")
    Observable<GetAuthInfoResult> f0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/searchByName")
    Observable<SearchByNameResult> g(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/bindEmailGiftDays")
    Observable<GiftDaysResult> g0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v2/getLineUps")
    Observable<LineupResult> h(@Query("gameId") String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/addSubscribe")
    Observable<AddSubscribeResult> h0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v6/getLiveData")
    Observable<GetLiveDataResult> i(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v5/heartbeat")
    Observable<HeartBeatResult> i0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getThridPart")
    Observable<ThirdPartResult> j(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getShortVideo")
    Observable<GetShortVideoResult> j0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v5/getNearestMatch")
    Observable<FootballMatchResult> k(@Query("appId") String str, @Query("pageSize") int i10);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/qr/waitConfirm")
    Observable<BaseResult> k0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getAreaCode")
    Observable<AreaCodeResult> l(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @GET("/api/portalCore/epg/v2/getMatchDetail")
    Observable<MatchStatResult> l0(@Query("gameId") String str, @Query("teamAName") String str2, @Query("teamBName") String str3);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/getProgram")
    Observable<GetProgramResult> m(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v4/startPlayLive")
    Observable<StartPlayLiveResult> m0(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/checkForceBind")
    Observable<CheckForceBindResult> n(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/delSubscribe")
    Observable<DelSubscribeResult> n0(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/snToken")
    Observable<SnTokenResult> o(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v7/login/thirdpart")
    Observable<LoginResult> o0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/changeBindPhone")
    Observable<BaseResult> p(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getEmailSuffix")
    Observable<GetEmailSuffixResult> p0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getHome")
    Observable<GetHomeResult> q(@Body String str);

    @Headers({"Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v8/login")
    Observable<LoginResult> q0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/device-management/deleteDevice")
    Observable<BaseResult> r(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/addFavorite")
    Observable<AddFavoriteResult> r0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "ProcessResult:false"})
    @POST("/api/portalCore/config/get")
    Observable<ConfigResult> s(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v5/exchange")
    Observable<ExchangeResult> s0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/bindEmail")
    Observable<BaseResult> t(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/validateVerifyCode")
    Observable<BaseResult> t0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/epg/getSportsMatch")
    Observable<FootballMatchResult> u(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/bindThirdpart")
    Observable<BindThirdPartResult> u0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/unBind")
    Observable<BaseResult> v(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/box/count")
    Observable<MsgNumResult> v0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/apkReceiveCoupon")
    Observable<ApkReceiveCouponResult> w(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v2/changeBindEmail")
    Observable<BaseResult> w0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/getPropertiesInfo")
    Observable<PropertiesInfoResult> x(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/searchByContent")
    Observable<SearchByContentData> x0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v15/getSlbInfo")
    Observable<GetSlbInfoBeanResult> y(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v3/getShelveData")
    Observable<ShelveDataBean> y0(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    @POST("/api/portalCore/feedback/getTypeQuestion")
    Observable<TypeQuestionResult> z(@Body String str);

    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    @POST("/api/portalCore/v5/loginOut")
    Observable<BaseResult> z0(@Body String str);
}
