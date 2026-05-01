package com.hpplay.sdk.source.bean;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class OutParameter implements Cloneable {
    public int castType;
    public int connectProtocol;
    public String connectSession;
    public BrowserInfo currentBrowserInfo;
    public String dramaID;
    public int duration;
    public int headLength;
    public MediaAssetBean mediaAssetBean;
    public MicroAppInfoBean microAppInfoBean;
    public int mimeType;
    public Intent mirrorIntent;
    public LelinkPlayerInfo originPlayerInfo;
    public String password;
    public int period;
    public PlayerInfoBean playerInfoBean;
    public int protocol;
    public String roomID;
    public LelinkServiceInfo serviceInfo;
    public String session;
    public int startPosition;
    public int tailLength;
    private String url;
    public String urlID;
    public DramaInfoBean[] urls;
    public boolean retryDLNAHttp = false;
    public int pushType = 0;
    public int mirrorAudioType = 2;
    public boolean requestAudioFocus = true;
    public int mirrorResLevel = 3;
    public int mirrorBitRateLevel = 4;
    public int fullScreenType = 1;
    public boolean isAutoBitrate = true;
    public boolean isExpandMirror = false;
    public Activity expandActivity = null;
    public View expandView = null;
    public SecondMirrorView secondMirrorView = null;
    public int mirrorSendTimeout = 0;
    public boolean isGroup = false;
    public boolean isMultiCast = false;

    public String getKey() {
        return this.session + Operator.Operation.MINUS + this.castType + Operator.Operation.MINUS + this.mimeType + Operator.Operation.MINUS + this.urlID;
    }

    public String getPlayUrl() {
        DramaInfoBean[] dramaInfoBeanArr = this.urls;
        if (dramaInfoBeanArr != null && dramaInfoBeanArr.length > 0) {
            for (DramaInfoBean dramaInfoBean : dramaInfoBeanArr) {
                DramaInfoBean.UrlBean[] urlBeanArr = dramaInfoBean.urls;
                if (urlBeanArr != null && urlBeanArr.length > 0) {
                    for (DramaInfoBean.UrlBean urlBean : urlBeanArr) {
                        if (TextUtils.equals(this.dramaID, urlBean.id)) {
                            return urlBean.url;
                        }
                    }
                }
            }
        }
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "OutParameter{connectSession='" + this.connectSession + "', session='" + this.session + "', castType=" + this.castType + ", mimeType=" + this.mimeType + ", protocol=" + this.protocol + ", connectProtocol=" + this.connectProtocol + ", urlID='" + this.urlID + "', url='" + this.url + "', startPosition=" + this.startPosition + ", duration=" + this.duration + ", retryDLNAHttp=" + this.retryDLNAHttp + ", mirrorIntent=" + this.mirrorIntent + ", mirrorAudioType=" + this.mirrorAudioType + ", requestAudioFocus=" + this.requestAudioFocus + ", mirrorResLevel=" + this.mirrorResLevel + ", mirrorBitRateLevel=" + this.mirrorBitRateLevel + ", fullScreenType=" + this.fullScreenType + ", isAutoBitrate=" + this.isAutoBitrate + ", isExpandMirror=" + this.isExpandMirror + ", expandActivity=" + this.expandActivity + ", expandView=" + this.expandView + ", mirrorSendTimeout=" + this.mirrorSendTimeout + ", password='" + this.password + "', roomID='" + this.roomID + "', serviceInfo=" + this.serviceInfo + ", currentBrowserInfo=" + this.currentBrowserInfo + ", mediaAssetBean=" + this.mediaAssetBean + ", playerInfoBean=" + this.playerInfoBean + ", isGroup=" + this.isGroup + ", isMultiCast=" + this.isMultiCast + ", pushType=" + this.pushType + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public OutParameter m45clone() {
        try {
            return (OutParameter) super.clone();
        } catch (Exception e10) {
            SourceLog.w("OutParameter", "clone failed", e10);
            return this;
        }
    }
}
