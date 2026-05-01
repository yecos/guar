package com.google.firebase.crashlytics.ndk;

import com.hpplay.component.protocol.push.IPushHandler;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class SessionMetadataJsonSerializer {
    private SessionMetadataJsonSerializer() {
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String serializeBeginSession(String str, String str2, long j10) {
        HashMap hashMap = new HashMap();
        hashMap.put("session_id", str);
        hashMap.put("generator", str2);
        hashMap.put("started_at_seconds", Long.valueOf(j10));
        return new JSONObject(hashMap).toString();
    }

    public static String serializeSessionApp(String str, String str2, String str3, String str4, int i10, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_identifier", str);
        hashMap.put("version_code", str2);
        hashMap.put("version_name", str3);
        hashMap.put("install_uuid", str4);
        hashMap.put("delivery_mechanism", Integer.valueOf(i10));
        hashMap.put("development_platform", emptyIfNull(str5));
        hashMap.put("development_platform_version", emptyIfNull(str6));
        return new JSONObject(hashMap).toString();
    }

    public static String serializeSessionDevice(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("arch", Integer.valueOf(i10));
        hashMap.put("build_model", str);
        hashMap.put("available_processors", Integer.valueOf(i11));
        hashMap.put("total_ram", Long.valueOf(j10));
        hashMap.put("disk_space", Long.valueOf(j11));
        hashMap.put("is_emulator", Boolean.valueOf(z10));
        hashMap.put(IPushHandler.STATE, Integer.valueOf(i12));
        hashMap.put("build_manufacturer", str2);
        hashMap.put("build_product", str3);
        return new JSONObject(hashMap).toString();
    }

    public static String serializeSessionOs(String str, String str2, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("version", str);
        hashMap.put("build_version", str2);
        hashMap.put("is_rooted", Boolean.valueOf(z10));
        return new JSONObject(hashMap).toString();
    }
}
