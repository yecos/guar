package com.hpplay.sdk.source.pass;

import android.text.TextUtils;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.pass.bean.DescribeBean;
import com.hpplay.sdk.source.pass.bean.PassLeboBean;
import com.hpplay.sdk.source.pass.bean.PassThirdBean;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventInfoBean;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.Feature;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Parser {
    private static final String TAG = "Parser";
    private static Parser sInstance;
    private Map<String, SinkBean> mSinkMap = new HashMap();
    private OnSinkTouchEventInfoListener mSinkTouchEventInfoListener;

    public interface OnSinkTouchEventInfoListener {
        void onInfo(SinkTouchEventInfoBean sinkTouchEventInfoBean);
    }

    private Parser() {
    }

    public static synchronized Parser getInstance() {
        synchronized (Parser.class) {
            synchronized (Parser.class) {
                if (sInstance == null) {
                    sInstance = new Parser();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    private SinkBean getSinkBean(String str) {
        SinkBean sinkBean = this.mSinkMap.get(str);
        if (sinkBean != null) {
            return sinkBean;
        }
        SinkBean sinkBean2 = new SinkBean();
        sinkBean2.uid = str;
        return sinkBean2;
    }

    private void handleAPPMessage(int i10, DescribeBean describeBean, String str) {
        String str2;
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "handleAPPMessage invalid input");
            return;
        }
        int i11 = describeBean.manifestType;
        int i12 = -1;
        if (i11 == -1) {
            handleErrorMessage(describeBean, str);
        } else if (i11 == 23) {
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
            }
            RightsManager.getInstance().handleRightMessage(describeBean.uid, str);
        } else {
            if (i11 != 45) {
                if (i11 != 100) {
                    if (i11 != 10000) {
                        SourceLog.w(TAG, "handleAPPMessage parse nonsupport msg type: " + describeBean.manifestType);
                        i12 = 1;
                        str2 = "Nonsupport message";
                    } else {
                        PassThirdBean formJSON = PassThirdBean.formJSON(str);
                        if (formJSON == null) {
                            SourceLog.w(TAG, "handleAPPMessage parse pass failed");
                            str2 = "parse pass failed";
                            i12 = 2;
                        } else if (formJSON.data == null) {
                            SourceLog.w(TAG, "handleAPPMessage parse pass invalid data");
                            str2 = "parse pass invalid data";
                            i12 = 3;
                        } else if (TextUtils.equals(Session.getInstance().appKey, formJSON.appID)) {
                            SourceLog.w(TAG, "MANIFEST_PASS_THIRD " + LelinkSdkManager.getInstance().mOuterRelevantInfoListener);
                            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(10000, str);
                            }
                        } else {
                            SourceLog.w(TAG, "handleAPPMessage parse pass unequal appID");
                            i12 = 4;
                            str2 = "wrong appID";
                        }
                    }
                } else if (Feature.isLeboApp()) {
                    PassLeboBean formJSON2 = PassLeboBean.formJSON(str);
                    if (formJSON2 == null) {
                        SourceLog.w(TAG, "handleAPPMessage, parse pass lebo failed");
                        str2 = "parse pass lebo failed";
                        i12 = 2;
                    } else if (formJSON2.data == null) {
                        SourceLog.w(TAG, "handleAPPMessage, parse pass lebo invalid data");
                        str2 = "parse pass lebo invalid data";
                        i12 = 3;
                    } else if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                        LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(100, str);
                    }
                } else {
                    SourceLog.i(TAG, "MANIFEST_PASS_LEBO ignore,not lebo app");
                }
                if (i12 > 0 || TextUtils.isEmpty(str2)) {
                }
                sendErrorMessage(describeBean, i12, str2);
                return;
            }
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(describeBean.manifestType, str);
            }
        }
        str2 = null;
        if (i12 > 0) {
        }
    }

    private void handleErrorMessage(DescribeBean describeBean, String str) {
        SourceLog.w(TAG, "handleErrorMessage " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0363  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleSDKMessage(int r8, com.hpplay.sdk.source.pass.bean.DescribeBean r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.pass.Parser.handleSDKMessage(int, com.hpplay.sdk.source.pass.bean.DescribeBean, java.lang.String):void");
    }

    private void parse(int i10, DescribeBean describeBean, String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.i(TAG, "parse invalid input");
            return;
        }
        if (describeBean == null) {
            SourceLog.w(TAG, "parse describeBean failed");
            return;
        }
        if (TextUtils.isEmpty(describeBean.uid) && TextUtils.isEmpty(describeBean.cuid)) {
            SourceLog.w(TAG, "parse describeBean miss uid");
            return;
        }
        int i11 = describeBean.handler;
        if (i11 != 1 && i11 != 2) {
            SourceLog.w(TAG, "parse describeBean invalid handler");
            return;
        }
        SourceLog.i(TAG, "parse " + describeBean.manifestType + " / " + str);
        SourceLog.i(TAG, "parse ");
        if (describeBean.handler == 2) {
            handleSDKMessage(i10, describeBean, str);
        } else {
            handleAPPMessage(i10, describeBean, str);
        }
    }

    private void sendErrorMessage(DescribeBean describeBean, int i10, String str) {
        SourceLog.w(TAG, "sendErrorMessage " + str);
    }

    public ConnectBean getConnectBean(String str) {
        ConnectBean connectBean;
        SinkBean sinkBean = getSinkBean(str);
        if (sinkBean == null || (connectBean = sinkBean.connectBean) == null) {
            return null;
        }
        return connectBean;
    }

    public void parseByLocalCast(DescribeBean describeBean, String str) {
        if (describeBean == null || TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "parseByLocalCast invalid input");
        } else {
            parse(1, describeBean, str);
        }
    }

    public void parseByNetCast(String str) {
        String[] split = str.split(Pass.PLACEHOLDER_END);
        DescribeBean describeBean = null;
        for (int i10 = 0; i10 < split.length; i10++) {
            if (TextUtils.isEmpty(split[i10]) || !split[i10].startsWith(Pass.PLACEHOLDER_START)) {
                SourceLog.w(TAG, "parseByNetCast invalid msg at " + i10);
                return;
            }
            if (i10 == 0) {
                describeBean = DescribeBean.formJson(split[i10].substring(6));
                if (describeBean == null) {
                    SourceLog.w(TAG, "parseByNetCast describeBean failed");
                    return;
                }
                if (TextUtils.isEmpty(describeBean.uid) && TextUtils.isEmpty(describeBean.cuid)) {
                    SourceLog.w(TAG, "parseByNetCast describeBean miss cuid");
                    return;
                }
                int i11 = describeBean.handler;
                if (i11 != 1 && i11 != 2) {
                    sendErrorMessage(describeBean, 5, "wrong handler");
                    return;
                }
            } else if (i10 == 1) {
                parse(2, describeBean, split[i10].substring(6));
            }
        }
    }

    public void setOnSinkTouchEventInfoListener(OnSinkTouchEventInfoListener onSinkTouchEventInfoListener) {
        this.mSinkTouchEventInfoListener = onSinkTouchEventInfoListener;
    }
}
