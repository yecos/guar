package com.hpplay.sdk.source.api;

import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public abstract class IConferenceMirrorListener implements ILelinkPlayerListener {
    public static final int CONFERENCE_CAST_SUCESS = 200;
    public static final int CONFERENCE_CONNECT_DISCONNECT = 110;
    public static final int CONFERENCE_CONNECT_DISCONNECT_BY_PREEMPT = 112;
    public static final int CONFERENCE_CONNECT_DISCONNECT_BY_REJECT = 102;
    public static final int CONFERENCE_CONNECT_DISCONNECT_BY_SERVER = 113;
    public static final int CONFERENCE_CONNECT_DISCONNECT_BY_SINK = 111;
    public static final int CONFERENCE_CONNECT_DISCONNECT_BY_UNKONW = 199;
    public static final int CONFERENCE_CONNECT_DISCONNECT_NOT_FIND = 114;
    public static final int CONFERENCE_CONNECT_FAILURE = 101;
    public static final int CONFERENCE_CONNECT_SUBDEVS_DUPLICATION = 201;
    public static final int CONFERENCE_FUZZY_SEARCH = 115;
    public static final int CONFERENCE_FUZZY_SEARCH_NO_DEVICES = 116;
    public static final int CONFERENCE_GUESTMODE = 202;
    public static final int CONFERENCE_GUESTMODE_RESETGUESTMODE_FAILED = 2023;
    public static final int CONFERENCE_GUESTMODE_RESETGUESTMODE_OK = 2022;
    public static final int CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED = 2021;
    public static final int CONFERENCE_GUESTMODE_SETGEUSTMODE_OK = 2020;
    public static final int STATUS_FAILURE = 0;
    public static final int STATUS_OK = 1;

    public void onAction(int i10, int i11, String str) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onCompletion() {
    }

    public void onConnectFailedDevs(List<String> list) {
    }

    public void onConnectedDevs(List<String> list) {
    }

    public void onDistributeDevs(List<String> list) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onError(int i10, int i11) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onInfo(int i10, int i11) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onLoading() {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onPause() {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onPositionUpdate(long j10, long j11) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onSeekComplete(int i10) {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onStart() {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onStop() {
    }

    @Override // com.hpplay.sdk.source.api.ILelinkPlayerListener
    public void onVolumeChanged(float f10) {
    }

    public void onError(int i10, int i11, String str) {
    }
}
