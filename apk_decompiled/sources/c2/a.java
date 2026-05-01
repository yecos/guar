package c2;

import com.bigbee.bean.request.CastAction;
import com.bigbee.bean.request.CastDeviceDiscovery;
import com.bigbee.bean.request.CastPlay;
import com.hpplay.cybergarage.upnp.Device;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5307a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f5308b = a.class.getSimpleName();

    public final void a(CastAction castAction, long j10, long j11) {
        t9.i.g(castAction, "castAction");
        HashMap hashMap = new HashMap();
        hashMap.put("cast_ver", castAction.getCast_ver());
        hashMap.put("session", castAction.getSession());
        hashMap.put("action", castAction.getAction());
        e.f5339a.a("app_cast_action", hashMap, j10, j11, false, true);
    }

    public final void b(CastDeviceDiscovery castDeviceDiscovery, long j10, long j11) {
        t9.i.g(castDeviceDiscovery, "castDeviceDiscovery");
        HashMap hashMap = new HashMap();
        hashMap.put("cast_ver", castDeviceDiscovery.getCast_ver());
        hashMap.put("duration", Long.valueOf(castDeviceDiscovery.getDuration()));
        hashMap.put("devices", castDeviceDiscovery.getDevices());
        hashMap.put("is_connect_to_wifi", Boolean.valueOf(castDeviceDiscovery.isConnectToWifi()));
        e.f5339a.a("app_cast_discovery", hashMap, j10, j11, false, true);
    }

    public final void c(CastPlay castPlay, long j10, long j11) {
        t9.i.g(castPlay, "castPlay");
        HashMap hashMap = new HashMap();
        hashMap.put("cast_ver", castPlay.getCast_ver());
        hashMap.put("program", castPlay.getProgram());
        hashMap.put("title", castPlay.getTitle());
        hashMap.put("episode", castPlay.getEpisode());
        hashMap.put("buss", castPlay.getBuss());
        hashMap.put("media", castPlay.getMedia());
        hashMap.put(IjkMediaMeta.IJKM_KEY_FORMAT, castPlay.getFormat());
        hashMap.put("encode", castPlay.getEncode());
        hashMap.put("quality", castPlay.getQuality());
        hashMap.put("lang", castPlay.getLang());
        hashMap.put("session", castPlay.getSession());
        hashMap.put("duration", Long.valueOf(castPlay.getDuration()));
        hashMap.put("prepare_spent", Long.valueOf(castPlay.getPrepare_spent()));
        hashMap.put(Device.ELEM_NAME, castPlay.getDevice());
        hashMap.put("err", Long.valueOf(castPlay.getErr()));
        hashMap.put("err_msg", castPlay.getErr_msg());
        hashMap.put(Constants.KEY_HOST, castPlay.getHost());
        hashMap.put("httping_err", Integer.valueOf(castPlay.getHttping_err()));
        hashMap.put("name", castPlay.getDevice().getName());
        hashMap.put("udn", castPlay.getDevice().getUdn());
        hashMap.put(Constants.KEY_MODEL, castPlay.getDevice().getModel());
        hashMap.put("model_number", castPlay.getDevice().getModel_number());
        hashMap.put("casting_product", castPlay.getDevice().getCasting_product());
        hashMap.put("discovery_product", castPlay.getDevice().getDiscovery_product());
        e.f5339a.a("app_cast_play", hashMap, j10, j11, false, true);
    }
}
