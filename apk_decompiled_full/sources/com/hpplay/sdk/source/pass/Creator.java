package com.hpplay.sdk.source.pass;

import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.pass.bean.DescribeBean;

/* loaded from: classes3.dex */
public class Creator {
    private static final String TAG = "Creator";

    public static DescribeBean getDescribeBean(String str, int i10, int i11, int i12) {
        Session session = Session.getInstance();
        DescribeBean describeBean = new DescribeBean();
        describeBean.ver = 1;
        describeBean.manifestType = i10;
        describeBean.manifestVer = i11;
        describeBean.handler = i12;
        describeBean.subscribe = 0;
        describeBean.sessionID = str;
        describeBean.cuid = session.getUID();
        return describeBean;
    }
}
