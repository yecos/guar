package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLDecoder;

/* loaded from: classes3.dex */
public class DLNABridge extends LelinkPushBridge {
    public DLNABridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        LelinkPushBridge.TAG = "DLNABridge";
    }

    private boolean isJGTP() {
        BrowserInfo browserInfo;
        LelinkServiceInfo lelinkServiceInfo = this.mPlayInfo.serviceInfo;
        if (lelinkServiceInfo == null || (browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 3)) == null) {
            return false;
        }
        return "QQLiveTV Render".equalsIgnoreCase(browserInfo.getExtras().get(BrowserInfo.KEY_DLNA_MODE_NAME)) && browserInfo.getExtras().get(BrowserInfo.KEY_MANUFACTURER).contains("极光");
    }

    @Override // com.hpplay.sdk.source.protocol.LelinkPushBridge, com.hpplay.sdk.source.protocol.IBridge
    public void play(String str) {
        if (this.mPushController == null) {
            SourceLog.w(LelinkPushBridge.TAG, "play ignore");
            return;
        }
        OutParameter outParameter = this.mPlayInfo;
        BrowserInfo browserInfo = outParameter.currentBrowserInfo;
        if (browserInfo == null) {
            SourceLog.w(LelinkPushBridge.TAG, "play ignore, invalid browser info");
            return;
        }
        this.isCallPrepared = false;
        this.mDuration = outParameter.duration;
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        String name = lelinkServiceInfo != null ? lelinkServiceInfo.getName() : "";
        SourceLog.i(LelinkPushBridge.TAG, "play " + this.mPlayInfo.getPlayUrl() + " to " + name + Operator.Operation.DIVISION + this);
        ParamsMap create = ParamsMap.create();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mPlayInfo.mimeType);
        sb.append("");
        create.putParam(ParamsMap.PushParams.KEY_MEDIA_TYPE, sb.toString());
        create.putParam(ParamsMap.PushParams.KEY_PROTOCOL_TYPE, this.mPlayInfo.protocol + "");
        create.putParam("ip", browserInfo.getIp());
        create.putParam(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        create.putParam(ParamsMap.PushParams.KEY_LOCATION_URI, browserInfo.getExtras().get(BrowserInfo.KEY_DLNA_LOCATION));
        create.putParam(ParamsMap.PushParams.KEY_START_POSITION, Integer.valueOf(this.mPlayInfo.startPosition));
        MediaAssetBean mediaAssetBean = this.mPlayInfo.mediaAssetBean;
        if (mediaAssetBean != null && !TextUtils.isEmpty(mediaAssetBean.getMetaData())) {
            create.put(ParamsMap.PushParams.KEY_DLNA_META_DATA, this.mPlayInfo.mediaAssetBean.getMetaData());
        }
        if (OptionCentral.SET_DLNA_CUSTOM_IDS) {
            create.putParam(ParamsMap.DeviceParams.KEY_RECEIVER_UID, browserInfo.getUid());
            create.putParam("uri", this.mPlayInfo.urlID);
            create.putParam(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            create.putParam(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            create.putParam(ParamsMap.DeviceParams.KEY_SESSION_ID, this.mPlayInfo.session);
        }
        create.putParam(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID, this.mPlayInfo.connectSession);
        MediaAssetBean mediaAssetBean2 = this.mPlayInfo.mediaAssetBean;
        if (mediaAssetBean2 != null && !mediaAssetBean2.isEmpty()) {
            try {
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getName())) {
                    create.putParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME, URLDecoder.decode(this.mPlayInfo.mediaAssetBean.getName(), XML.CHARSET_UTF8));
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getAlbum())) {
                    create.putParam(ParamsMap.PushParams.KEY_DLNA_ALBUM, URLDecoder.decode(this.mPlayInfo.mediaAssetBean.getAlbum(), XML.CHARSET_UTF8));
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getAlbumArtURI())) {
                    create.putParam(ParamsMap.PushParams.KEY_DLNA_ALBUM_URL, this.mPlayInfo.mediaAssetBean.getAlbumArtURI());
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getActor())) {
                    create.putParam(ParamsMap.PushParams.KEY_DLNA_ARTIST, URLDecoder.decode(this.mPlayInfo.mediaAssetBean.getActor(), XML.CHARSET_UTF8));
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getDirector())) {
                    create.putParam(ParamsMap.PushParams.KEY_DLNA_CREATOR, URLDecoder.decode(this.mPlayInfo.mediaAssetBean.getDirector(), XML.CHARSET_UTF8));
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getId())) {
                    create.putParam("playid", this.mPlayInfo.mediaAssetBean.getId());
                }
                if (!TextUtils.isEmpty(this.mPlayInfo.mediaAssetBean.getResolution())) {
                    create.putParam(ParamsMap.PushParams.KEY_DLNA_RESOLUTION, this.mPlayInfo.mediaAssetBean.getResolution());
                }
                create.putParam(ParamsMap.PushParams.KEY_DLNA_SIZE, String.valueOf(this.mPlayInfo.mediaAssetBean.getSize()));
                create.putParam(ParamsMap.PushParams.KEY_DLNA_DURATION, String.valueOf(this.mPlayInfo.mediaAssetBean.getDuration()));
            } catch (Exception e10) {
                SourceLog.w(LelinkPushBridge.TAG, e10);
            }
            create.putParam(ParamsMap.PushParams.KEY_DLNA_DURATION, HpplayUtil.secToTime(this.mPlayInfo.mediaAssetBean.getDuration()));
            create.putParam(ParamsMap.PushParams.KEY_DLNA_SIZE, Long.valueOf(this.mPlayInfo.mediaAssetBean.getSize()));
            create.putParam(ParamsMap.PushParams.KEY_DLNA_RESOLUTION, this.mPlayInfo.mediaAssetBean.getResolution());
        }
        SourceLog.i(LelinkPushBridge.TAG, "play " + create.toString());
        this.mPushController.DLNARetryHttp(this.mPlayInfo.retryDLNAHttp);
        this.mPushController.push(this.mPlayInfo.getPlayUrl(), create);
        this.isJGTP = isJGTP();
    }
}
