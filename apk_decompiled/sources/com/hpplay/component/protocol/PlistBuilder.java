package com.hpplay.component.protocol;

import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSObject;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class PlistBuilder {
    public static final String AUDIO_CHANNEL_TYPE_TCP = "2";
    public static final String AUDIO_CHANNEL_TYPE_UDP = "1";
    public static final String KEY_AUDIO_SOCKET_TYPE = "ast";
    public static final String KEY_CONTENT_LOCATION = "content-location";
    public static final String KEY_CONTROL_PORT = "control-port";
    public static final String KEY_CURPLAYID = "curplayid";
    public static final String KEY_DATAPORT = "data-port";
    public static final String KEY_DISPLAYS = "displays";
    public static final String KEY_EVENT = "event";
    public static final String KEY_EVENT_PORT = "event-port";
    public static final String KEY_HEIGHT_PIXELS = "height";
    public static final String KEY_ITEM = "item";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_LATENCYMAX = "latencyMax";
    public static final String KEY_LATENCYMIN = "latencyMin";
    public static final String KEY_MEDIA_TYPE = "media-type";
    public static final String KEY_MIRROR_SOCKET_TYPE = "mst";
    public static final String KEY_PASSTH_DATA = "data";
    public static final String KEY_PASSTH_DATA_LENGTH = "length";
    public static final String KEY_PERIOD = "period";
    public static final String KEY_PLAYMODE = "play-mode";
    public static final String KEY_PROP_TYPE = "prop-type";
    public static final String KEY_REFRESH_RATE = "refresh-rate";
    public static final String KEY_SEEK_POSTION = "seek-position";
    public static final String KEY_SF = "sample-format";
    public static final String KEY_SR = "sample-rate";
    public static final String KEY_START_POSITION = "start-position";
    public static final String KEY_STREAMS = "streams";
    public static final String KEY_STREAM_TIME = "stream-time";
    public static final String KEY_TIMING_PORT = "timing-port";
    public static final String KEY_TYPE = "type";
    public static final String KEY_TYPE_CATEGORY = "category";
    public static final String KEY_TYPE_MEDIA_NAME = "name";
    public static final String KEY_TYPE_PLAYID = "playid";
    public static final String KEY_UDP_DATAPORT = "udp-port";
    public static final String KEY_URL = "url";
    public static final String KEY_USESCREEN = "usingScreen";
    public static final String KEY_UUID = "uuid";
    public static final String KEY_VALUE = "value";
    public static final String KEY_WIDTH_PIXELS = "width";
    public static final String TAG = "PlistBuilder";
    public static final String TYPE_AUDIO = "music";
    public static final String TYPE_IMAGE = "image/url";
    public static final String TYPE_VEDIO = "video";
    public static final String VALUE_TYPE_AUDIOTRACK = "audiotrack";
    public static final String VALUE_TYPE_DECREASE = "decrease";
    public static final String VALUE_TYPE_INCREASE = "increase";
    public static final String VALUE_TYPE_PLAYLIST = "set-playlist";
    public static final String VALUE_TYPE_POSITION = "position";
    public static final String VALUE_TYPE_VOLUME = "volume";
    private Map<String, NSArray> mNSArrayMap = new HashMap();
    private NSDictionary mRoot = new NSDictionary();

    public PlistBuilder addArrayToArray(String str, int i10, String str2) {
        NSArray nSArray = this.mNSArrayMap.get(str);
        if (nSArray != null) {
            NSDictionary nSDictionary = (NSDictionary) nSArray.getArray()[i10];
            NSObject[] array = this.mNSArrayMap.get(str2).getArray();
            NSArray nSArray2 = new NSArray(array.length);
            for (int i11 = 0; i11 < array.length; i11++) {
                nSArray2.setValue(i11, array[i11]);
            }
            nSDictionary.put(str2, (NSObject) nSArray2);
            nSArray.setValue(i10, nSDictionary);
        }
        return this;
    }

    public PlistBuilder addArrayToRoot(String str) {
        NSArray nSArray = this.mNSArrayMap.get(str);
        if (nSArray != null) {
            this.mRoot.put(str, (NSObject) nSArray);
        }
        return this;
    }

    public PlistBuilder addBlooeanToArray(String str, int i10, String str2, boolean z10) {
        NSArray nSArray = this.mNSArrayMap.get(str);
        if (nSArray != null) {
            NSDictionary nSDictionary = (NSDictionary) nSArray.getArray()[i10];
            nSDictionary.put(str2, (Object) Boolean.valueOf(z10));
            nSArray.setValue(i10, nSDictionary);
        }
        return this;
    }

    public PlistBuilder addIntagerToArray(String str, int i10, String str2, int i11) {
        NSArray nSArray = this.mNSArrayMap.get(str);
        if (nSArray != null) {
            NSDictionary nSDictionary = (NSDictionary) nSArray.getArray()[i10];
            nSDictionary.put(str2, (Object) Integer.valueOf(i11));
            nSArray.setValue(i10, nSDictionary);
        }
        return this;
    }

    public PlistBuilder addIntagerToRoot(String str, int i10) {
        this.mRoot.put(str, (Object) Integer.valueOf(i10));
        return this;
    }

    public PlistBuilder addStringToArray(String str, int i10, String str2, String str3) {
        NSArray nSArray = this.mNSArrayMap.get(str);
        if (nSArray != null) {
            NSDictionary nSDictionary = (NSDictionary) nSArray.getArray()[i10];
            nSDictionary.put(str2, (Object) str3);
            nSArray.setValue(i10, nSDictionary);
        }
        return this;
    }

    public PlistBuilder addStringToRoot(String str, String str2) {
        this.mRoot.put(str, (Object) str2);
        return this;
    }

    public PlistBuilder createIPlistArray(String str, int i10) {
        NSArray nSArray = new NSArray(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            nSArray.setValue(i11, new NSDictionary());
        }
        this.mNSArrayMap.put(str, nSArray);
        return this;
    }

    public String getPotocol() {
        return this.mRoot.toXMLPropertyList();
    }
}
