package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.a;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.b;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.c;
import com.hpplay.sdk.source.d;
import com.hpplay.sdk.source.e;
import com.hpplay.sdk.source.f;
import com.hpplay.sdk.source.g;
import com.hpplay.sdk.source.h;
import com.hpplay.sdk.source.i;
import com.hpplay.sdk.source.j;
import com.hpplay.sdk.source.k;
import com.hpplay.sdk.source.l;
import com.hpplay.sdk.source.m;
import com.hpplay.sdk.source.n;
import com.hpplay.sdk.source.o;
import com.hpplay.sdk.source.p;
import com.hpplay.sdk.source.q;
import com.hpplay.sdk.source.r;
import com.hpplay.sdk.source.s;
import com.hpplay.sdk.source.t;
import com.hpplay.sdk.source.u;
import com.hpplay.sdk.source.v;
import com.hpplay.sdk.source.w;
import com.hpplay.sdk.source.x;
import java.util.List;

/* loaded from: classes3.dex */
public interface z extends IInterface {

    public static abstract class a extends Binder implements z {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.SDKInterface";
        static final int TRANSACTION_addFavoriteDevice = 59;
        static final int TRANSACTION_addPinCodeToLelinkServiceInfo = 36;
        static final int TRANSACTION_addQRCodeToLelinkServiceInfo = 35;
        static final int TRANSACTION_addVolume = 24;
        static final int TRANSACTION_appendPlayList = 55;
        static final int TRANSACTION_browse = 12;
        static final int TRANSACTION_canPlayLocalMedia = 39;
        static final int TRANSACTION_canPlayScreen = 38;
        static final int TRANSACTION_clearPlayList = 56;
        static final int TRANSACTION_connect = 15;
        static final int TRANSACTION_createPinCode = 33;
        static final int TRANSACTION_createShortUrl = 34;
        static final int TRANSACTION_disconnect = 16;
        static final int TRANSACTION_getConnectInfos = 17;
        static final int TRANSACTION_getFavoriteDeviceList = 61;
        static final int TRANSACTION_getHistoryDeviceList = 64;
        static final int TRANSACTION_getOption = 46;
        static final int TRANSACTION_getSDKInfos = 50;
        static final int TRANSACTION_initSdkWithUserId = 1;
        static final int TRANSACTION_multiMirrorControl = 47;
        static final int TRANSACTION_multiPushControl = 48;
        static final int TRANSACTION_pause = 23;
        static final int TRANSACTION_removeFavoriteDevice = 60;
        static final int TRANSACTION_removeHistoryDevice = 65;
        static final int TRANSACTION_resume = 22;
        static final int TRANSACTION_seekTo = 13;
        static final int TRANSACTION_setAuthListener = 30;
        static final int TRANSACTION_setCloudMirrorPlayListener = 49;
        static final int TRANSACTION_setCommonListener = 53;
        static final int TRANSACTION_setConnectStatusListener = 9;
        static final int TRANSACTION_setCreatePinCodeListener = 31;
        static final int TRANSACTION_setCreateShortUrlListener = 32;
        static final int TRANSACTION_setDaPlayListenerListener = 8;
        static final int TRANSACTION_setDebugAVListener = 5;
        static final int TRANSACTION_setDebugMode = 2;
        static final int TRANSACTION_setDebugTimestamp = 3;
        static final int TRANSACTION_setFavoriteDeviceAlias = 62;
        static final int TRANSACTION_setFavoriteDeviceListener = 58;
        static final int TRANSACTION_setHistoryDeviceListener = 63;
        static final int TRANSACTION_setLelinkPlayListenerListener = 6;
        static final int TRANSACTION_setLelinkServiceInfoListener = 4;
        static final int TRANSACTION_setLelinkServiceInfoOption = 29;
        static final int TRANSACTION_setLogCallback = 51;
        static final int TRANSACTION_setMirrorChangeListener = 52;
        static final int TRANSACTION_setNewPlayListenerListener = 7;
        static final int TRANSACTION_setOption = 28;
        static final int TRANSACTION_setReceiverPropertiesCallback = 66;
        static final int TRANSACTION_setRelevantInfoListener = 40;
        static final int TRANSACTION_setSearchBannerDataCallback = 45;
        static final int TRANSACTION_setSendPassCallback = 57;
        static final int TRANSACTION_setServiceInfoListParseListener = 11;
        static final int TRANSACTION_setServiceInfoParseListener = 10;
        static final int TRANSACTION_setSinkKeyEventListener = 43;
        static final int TRANSACTION_setSinkTouchEventListener = 44;
        static final int TRANSACTION_setSystemApp = 37;
        static final int TRANSACTION_setVolume = 26;
        static final int TRANSACTION_startMirrorForPlayerInfo = 21;
        static final int TRANSACTION_startOnlineCheck = 54;
        static final int TRANSACTION_startPlayMedia = 18;
        static final int TRANSACTION_startPlayMediaForPlayerInfo = 19;
        static final int TRANSACTION_startPlayMediaImmed = 20;
        static final int TRANSACTION_stopBrowse = 14;
        static final int TRANSACTION_stopPlay = 27;
        static final int TRANSACTION_subVolume = 25;
        static final int TRANSACTION_updateAudioData = 41;
        static final int TRANSACTION_updateVideoData = 42;

        /* renamed from: com.hpplay.sdk.source.z$a$a, reason: collision with other inner class name */
        public static class C0155a implements z {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f7772a;

            public C0155a(IBinder iBinder) {
                this.f7772a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            @Override // com.hpplay.sdk.source.z
            public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void addPinCodeToLelinkServiceInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f7772a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void addQRCodeToLelinkServiceInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f7772a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void addVolume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedArray(dramaInfoBeanArr, 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    this.f7772a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7772a;
            }

            @Override // com.hpplay.sdk.source.z
            public void browse(boolean z10, boolean z11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    int i10 = 1;
                    obtain.writeInt(z10 ? 1 : 0);
                    if (!z11) {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    this.f7772a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void clearPlayList() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void connect(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void createPinCode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void createShortUrl() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public List<LelinkServiceInfo> getConnectInfos() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LelinkServiceInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void getFavoriteDeviceList(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f7772a.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void getHistoryDeviceList(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f7772a.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public String getOption(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f7772a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public String getSDKInfos(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f7772a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void initSdkWithUserId(String str, String str2, String str3, String str4, String str5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    this.f7772a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeTypedList(list);
                    this.f7772a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeTypedList(list);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    this.f7772a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void pause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.f7772a.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    obtain.writeInt(i10);
                    this.f7772a.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void resume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void seekTo(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f7772a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setAuthListener(com.hpplay.sdk.source.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f7772a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setCloudMirrorPlayListener(c cVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f7772a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setCommonListener(d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f7772a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setConnectStatusListener(e eVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    this.f7772a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setCreatePinCodeListener(f fVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f7772a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setCreateShortUrlListener(g gVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f7772a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setDaPlayListenerListener(h hVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.f7772a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setDebugAVListener(i iVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.f7772a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setDebugMode(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f7772a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setDebugTimestamp(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f7772a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f7772a.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setFavoriteDeviceListener(j jVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f7772a.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setHistoryDeviceListener(k kVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    this.f7772a.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setLelinkPlayListenerListener(l lVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f7772a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setLelinkServiceInfoListener(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f7772a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setLogCallback(m mVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    this.f7772a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setMirrorChangeListener(n nVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.f7772a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setNewPlayListenerListener(o oVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f7772a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setOption(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    this.f7772a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setReceiverPropertiesCallback(q qVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    this.f7772a.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setRelevantInfoListener(r rVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                    this.f7772a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setSearchBannerDataCallback(s sVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    this.f7772a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setSendPassCallback(t tVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    this.f7772a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setServiceInfoListParseListener(u uVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    this.f7772a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setServiceInfoParseListener(v vVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f7772a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setSinkKeyEventListener(w wVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    this.f7772a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (sinkTouchEventArea != null) {
                        obtain.writeInt(1);
                        sinkTouchEventArea.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeFloat(f10);
                    obtain.writeStrongBinder(xVar != null ? xVar.asBinder() : null);
                    this.f7772a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setSystemApp(boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f7772a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void setVolume(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f7772a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkPlayerInfo != null) {
                        obtain.writeInt(1);
                        lelinkPlayerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void startOnlineCheck(p pVar, List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    obtain.writeTypedList(list);
                    this.f7772a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void startPlayMedia(String str, int i10, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f7772a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkPlayerInfo != null) {
                        obtain.writeInt(1);
                        lelinkPlayerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    int i11 = 1;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (!z10) {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    this.f7772a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void stopBrowse() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void stopPlay() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void subVolume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f7772a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (audioFrameBean != null) {
                        obtain.writeInt(1);
                        audioFrameBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hpplay.sdk.source.z
            public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (videoFrameBean != null) {
                        obtain.writeInt(1);
                        videoFrameBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f7772a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static z asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof z)) ? new C0155a(iBinder) : (z) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    initSdkWithUserId(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDebugMode(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDebugTimestamp(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLelinkServiceInfoListener(b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDebugAVListener(i.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLelinkPlayListenerListener(l.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setNewPlayListenerListener(o.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    setDaPlayListenerListener(h.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    setConnectStatusListener(e.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    setServiceInfoParseListener(v.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    setServiceInfoListParseListener(u.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    browse(parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    seekTo(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopBrowse();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    connect(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disconnect = disconnect(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(disconnect ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<LelinkServiceInfo> connectInfos = getConnectInfos();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(connectInfos);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    startPlayMedia(parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    startPlayMediaForPlayerInfo(parcel.readInt() != 0 ? LelinkPlayerInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    startPlayMediaImmed(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    startMirrorForPlayerInfo(parcel.readInt() != 0 ? LelinkPlayerInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    resume();
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    addVolume();
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    subVolume();
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    setVolume(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopPlay();
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    setOption(parcel.readInt(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean lelinkServiceInfoOption = setLelinkServiceInfoOption(parcel.readInt(), parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(lelinkServiceInfoOption ? 1 : 0);
                    return true;
                case 30:
                    parcel.enforceInterface(DESCRIPTOR);
                    setAuthListener(a.AbstractBinderC0123a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCreatePinCodeListener(f.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCreateShortUrlListener(g.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface(DESCRIPTOR);
                    createPinCode();
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(DESCRIPTOR);
                    createShortUrl();
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(DESCRIPTOR);
                    addQRCodeToLelinkServiceInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(DESCRIPTOR);
                    addPinCodeToLelinkServiceInfo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSystemApp(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean canPlayScreen = canPlayScreen(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(canPlayScreen ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean canPlayLocalMedia = canPlayLocalMedia(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(canPlayLocalMedia ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRelevantInfoListener(r.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateAudioData(parcel.createByteArray(), parcel.readInt() != 0 ? AudioFrameBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateVideoData(parcel.createByteArray(), parcel.readInt() != 0 ? VideoFrameBean.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSinkKeyEventListener(w.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSinkTouchEventListener(parcel.readInt() != 0 ? SinkTouchEventArea.CREATOR.createFromParcel(parcel) : null, parcel.readFloat(), x.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSearchBannerDataCallback(s.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface(DESCRIPTOR);
                    String option = getOption(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(option);
                    return true;
                case 47:
                    parcel.enforceInterface(DESCRIPTOR);
                    multiMirrorControl(parcel.readInt() != 0, parcel.createTypedArrayList(LelinkServiceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface(DESCRIPTOR);
                    multiPushControl(parcel.readInt() != 0, parcel.createTypedArrayList(LelinkServiceInfo.CREATOR), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCloudMirrorPlayListener(c.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(DESCRIPTOR);
                    String sDKInfos = getSDKInfos(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(sDKInfos);
                    return true;
                case 51:
                    parcel.enforceInterface(DESCRIPTOR);
                    setLogCallback(m.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 52:
                    parcel.enforceInterface(DESCRIPTOR);
                    setMirrorChangeListener(n.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface(DESCRIPTOR);
                    setCommonListener(d.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface(DESCRIPTOR);
                    startOnlineCheck(p.a.asInterface(parcel.readStrongBinder()), parcel.createTypedArrayList(LelinkServiceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 55:
                    parcel.enforceInterface(DESCRIPTOR);
                    appendPlayList((DramaInfoBean[]) parcel.createTypedArray(DramaInfoBean.CREATOR), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 56:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearPlayList();
                    parcel2.writeNoException();
                    return true;
                case 57:
                    parcel.enforceInterface(DESCRIPTOR);
                    setSendPassCallback(t.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 58:
                    parcel.enforceInterface(DESCRIPTOR);
                    setFavoriteDeviceListener(j.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 59:
                    parcel.enforceInterface(DESCRIPTOR);
                    addFavoriteDevice(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeFavoriteDevice(parcel.createTypedArrayList(LelinkServiceInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 61:
                    parcel.enforceInterface(DESCRIPTOR);
                    getFavoriteDeviceList(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 62:
                    parcel.enforceInterface(DESCRIPTOR);
                    setFavoriteDeviceAlias(parcel.readInt() != 0 ? LelinkServiceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 63:
                    parcel.enforceInterface(DESCRIPTOR);
                    setHistoryDeviceListener(k.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 64:
                    parcel.enforceInterface(DESCRIPTOR);
                    getHistoryDeviceList(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 65:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeHistoryDevice(parcel.createTypedArrayList(LelinkServiceInfo.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 66:
                    parcel.enforceInterface(DESCRIPTOR);
                    setReceiverPropertiesCallback(q.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo);

    void addPinCodeToLelinkServiceInfo(String str);

    void addQRCodeToLelinkServiceInfo(String str);

    void addVolume();

    void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12);

    void browse(boolean z10, boolean z11);

    boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo);

    boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo);

    void clearPlayList();

    void connect(LelinkServiceInfo lelinkServiceInfo);

    void createPinCode();

    void createShortUrl();

    boolean disconnect(LelinkServiceInfo lelinkServiceInfo);

    List<LelinkServiceInfo> getConnectInfos();

    void getFavoriteDeviceList(int i10, int i11);

    void getHistoryDeviceList(int i10, int i11);

    String getOption(int i10);

    String getSDKInfos(int i10);

    void initSdkWithUserId(String str, String str2, String str3, String str4, String str5);

    void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list);

    void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10);

    void pause();

    void removeFavoriteDevice(List<LelinkServiceInfo> list);

    void removeHistoryDevice(List<LelinkServiceInfo> list, int i10);

    void resume();

    void seekTo(int i10);

    void setAuthListener(com.hpplay.sdk.source.a aVar);

    void setCloudMirrorPlayListener(c cVar);

    void setCommonListener(d dVar);

    void setConnectStatusListener(e eVar);

    void setCreatePinCodeListener(f fVar);

    void setCreateShortUrlListener(g gVar);

    void setDaPlayListenerListener(h hVar);

    void setDebugAVListener(i iVar);

    void setDebugMode(boolean z10);

    void setDebugTimestamp(boolean z10);

    void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str);

    void setFavoriteDeviceListener(j jVar);

    void setHistoryDeviceListener(k kVar);

    void setLelinkPlayListenerListener(l lVar);

    void setLelinkServiceInfoListener(b bVar);

    boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo);

    void setLogCallback(m mVar);

    void setMirrorChangeListener(n nVar);

    void setNewPlayListenerListener(o oVar);

    void setOption(int i10, String[] strArr);

    void setReceiverPropertiesCallback(q qVar);

    void setRelevantInfoListener(r rVar);

    void setSearchBannerDataCallback(s sVar);

    void setSendPassCallback(t tVar);

    void setServiceInfoListParseListener(u uVar);

    void setServiceInfoParseListener(v vVar);

    void setSinkKeyEventListener(w wVar);

    void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar);

    void setSystemApp(boolean z10);

    void setVolume(int i10);

    void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo);

    void startOnlineCheck(p pVar, List<LelinkServiceInfo> list);

    void startPlayMedia(String str, int i10, boolean z10);

    void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo);

    void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10);

    void stopBrowse();

    void stopPlay();

    void subVolume();

    void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean);

    void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean);
}
