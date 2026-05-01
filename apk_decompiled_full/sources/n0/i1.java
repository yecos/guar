package n0;

import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import n0.n0;

/* loaded from: classes.dex */
public abstract class i1 {
    public static List a(List list) {
        Stream stream;
        Stream filter;
        Stream map;
        Collector list2;
        Object collect;
        if (list == null) {
            return new ArrayList();
        }
        stream = list.stream();
        filter = stream.filter(new Predicate() { // from class: n0.h1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return b0.a((MediaRoute2Info) obj);
            }
        });
        map = filter.map(new Function() { // from class: n0.f1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String id;
                id = ((MediaRoute2Info) obj).getId();
                return id;
            }
        });
        list2 = Collectors.toList();
        collect = map.collect(list2);
        return (List) collect;
    }

    public static RouteDiscoveryPreference b(o0 o0Var) {
        RouteDiscoveryPreference build;
        Stream stream;
        Stream map;
        Collector list;
        Object collect;
        RouteDiscoveryPreference build2;
        if (o0Var == null || !o0Var.e()) {
            build = new RouteDiscoveryPreference.Builder(new ArrayList(), false).build();
            return build;
        }
        boolean d10 = o0Var.d();
        stream = o0Var.c().e().stream();
        map = stream.map(new Function() { // from class: n0.g1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return i1.d((String) obj);
            }
        });
        list = Collectors.toList();
        collect = map.collect(list);
        build2 = new RouteDiscoveryPreference.Builder((List) collect, d10).build();
        return build2;
    }

    public static n0 c(MediaRoute2Info mediaRoute2Info) {
        String id;
        CharSequence name;
        int connectionState;
        int volumeHandling;
        int volumeMax;
        int volume;
        Bundle extras;
        CharSequence description;
        Uri iconUri;
        Bundle extras2;
        if (mediaRoute2Info == null) {
            return null;
        }
        id = mediaRoute2Info.getId();
        name = mediaRoute2Info.getName();
        n0.a aVar = new n0.a(id, name.toString());
        connectionState = mediaRoute2Info.getConnectionState();
        n0.a g10 = aVar.g(connectionState);
        volumeHandling = mediaRoute2Info.getVolumeHandling();
        n0.a s10 = g10.s(volumeHandling);
        volumeMax = mediaRoute2Info.getVolumeMax();
        n0.a t10 = s10.t(volumeMax);
        volume = mediaRoute2Info.getVolume();
        n0.a r10 = t10.r(volume);
        extras = mediaRoute2Info.getExtras();
        n0.a f10 = r10.k(extras).j(true).f(false);
        description = mediaRoute2Info.getDescription();
        if (description != null) {
            f10.h(description.toString());
        }
        iconUri = mediaRoute2Info.getIconUri();
        if (iconUri != null) {
            f10.l(iconUri);
        }
        extras2 = mediaRoute2Info.getExtras();
        if (extras2 == null || !extras2.containsKey("androidx.mediarouter.media.KEY_EXTRAS") || !extras2.containsKey("androidx.mediarouter.media.KEY_DEVICE_TYPE") || !extras2.containsKey("androidx.mediarouter.media.KEY_CONTROL_FILTERS")) {
            return null;
        }
        f10.k(extras2.getBundle("androidx.mediarouter.media.KEY_EXTRAS"));
        f10.i(extras2.getInt("androidx.mediarouter.media.KEY_DEVICE_TYPE", 0));
        f10.p(extras2.getInt("androidx.mediarouter.media.KEY_PLAYBACK_TYPE", 1));
        ArrayList parcelableArrayList = extras2.getParcelableArrayList("androidx.mediarouter.media.KEY_CONTROL_FILTERS");
        if (parcelableArrayList != null) {
            f10.b(parcelableArrayList);
        }
        return f10.e();
    }

    public static String d(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.intent.category.REMOTE_PLAYBACK":
                return "android.media.route.feature.REMOTE_PLAYBACK";
            case "android.media.intent.category.LIVE_AUDIO":
                return "android.media.route.feature.LIVE_AUDIO";
            case "android.media.intent.category.LIVE_VIDEO":
                return "android.media.route.feature.LIVE_VIDEO";
            default:
                return str;
        }
    }
}
