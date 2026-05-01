package com.hpplay.component.common.dlna;

import com.hpplay.component.common.protocol.ProtocolListener;

/* loaded from: classes2.dex */
public interface IDLNAController {
    public static final String DEC_VOLUME = "decvolume";
    public static final String GET_MEDIA_INFO = "GetMediaInfo";
    public static final String GET_POSITION_INFO = "GetPositionInfo";
    public static final String GET_TRANSPORT_INFO = "GetTransportInfo";
    public static final String INC_VOLUME = "incvloume";
    public static final String PAUSE = "Pause";
    public static final String PLAY = "Play";
    public static final String RESUME = "Resume";
    public static final String SEEK = "Seek";
    public static final String SET_MUTE = "SetMute";
    public static final String SET_VOLUME = "SetVolume";
    public static final String STOP = "Stop";

    String close();

    boolean connect(String str, String str2, ProtocolListener protocolListener);

    String[] sendAction(String str);
}
