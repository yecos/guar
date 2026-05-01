package com.hpplay.component.common.protocol;

/* loaded from: classes2.dex */
public abstract class ProtocolListener {
    public static final int CMD_ADD_PLAY_LIST = 21;
    public static final int CMD_CLEAR = 24;
    public static final int CMD_CONNECT = 11;
    public static final int CMD_DECREASE_VOLUME = 6;
    public static final int CMD_GET_PALYINFO = 8;
    public static final int CMD_GET_STATEINFO = 9;
    public static final int CMD_INCREASE_VOLUME = 5;
    public static final int CMD_ON_COMPLETION = 12;
    public static final int CMD_ON_LOADING = 14;
    public static final int CMD_ON_PAUSE = 15;
    public static final int CMD_ON_PREEMPT_STOPPED = 28;
    public static final int CMD_ON_REVERSE_PLAYINFO = 17;
    public static final int CMD_ON_START_PLAY = 13;
    public static final int CMD_ON_STOPED = 16;
    public static final int CMD_PASSTH_CONNECT = 18;
    public static final int CMD_PASSTH_RESULT = 19;
    public static final int CMD_PAUSE = 2;
    public static final int CMD_PLAY_NEXT = 22;
    public static final int CMD_PLAY_PRE = 23;
    public static final int CMD_PUSH = 1;
    public static final int CMD_REOBTAIN_RESULT = 20;
    public static final int CMD_RESUME = 3;
    public static final int CMD_SEEKTO = 4;
    public static final int CMD_SELECT_AUDIOTRACK = 27;
    public static final int CMD_SELECT_PLAY = 25;
    public static final int CMD_SET_VOLUME = 10;
    public static final int CMD_STOP_PLAY = 7;
    public static final int EPISODE_STOPED = 26;
    public int cmdType = -1;

    public abstract void onResult(int i10, String... strArr);
}
