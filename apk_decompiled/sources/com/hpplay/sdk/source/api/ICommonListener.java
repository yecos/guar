package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.bean.CommonResultBean;

/* loaded from: classes3.dex */
public interface ICommonListener {
    public static final int EVENT_HOST_STATUS_CHANGE = 1;
    public static final int EVENT_REMOTE_SERVER_FAILED = 2;
    public static final int EVENT_REMOTE_SERVER_STARTED = 1;
    public static final int EVENT_SINK_HOST_CAST_SETTING_CHANGE = 1;
    public static final int EVENT_SINK_HOST_REVERSE_CAST_SETTING_CHANGE = 2;
    public static final int EVENT_SINK_NOTIFY_SOURCE_CAST = 1;
    public static final int EVENT_SINK_PREPARED = 1;
    public static final int LISTENER_HOST_STATUS_CHANGE = 4;
    public static final int LISTENER_REMOTE_SERVER = 1;
    public static final int LISTENER_SINK_HOST_SETTING_CHANGE = 3;
    public static final int LISTENER_SINK_NOTIFY_SOURCE_CAST = 5;
    public static final int LISTENER_SINK_PREPARED = 2;

    CommonResultBean onCallback(int i10, int i11, String str);
}
