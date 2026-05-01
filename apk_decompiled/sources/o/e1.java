package o;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.s;

/* loaded from: classes.dex */
public class e1 implements r {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17348a;

    /* renamed from: b, reason: collision with root package name */
    public final Notification.Builder f17349b;

    /* renamed from: c, reason: collision with root package name */
    public final s.e f17350c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteViews f17351d;

    /* renamed from: e, reason: collision with root package name */
    public RemoteViews f17352e;

    /* renamed from: f, reason: collision with root package name */
    public final List f17353f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f17354g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public int f17355h;

    /* renamed from: i, reason: collision with root package name */
    public RemoteViews f17356i;

    public e1(s.e eVar) {
        Notification.Builder badgeIconType;
        Notification.Builder settingsText;
        Notification.Builder shortcutId;
        Notification.Builder timeoutAfter;
        Icon icon;
        Notification.Builder category;
        Notification.Builder color;
        Notification.Builder visibility;
        Notification.Builder publicVersion;
        AudioAttributes audioAttributes;
        Notification.Builder localOnly;
        Notification.Builder group;
        Notification.Builder groupSummary;
        List e10;
        this.f17350c = eVar;
        this.f17348a = eVar.f17413a;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f17349b = new Notification.Builder(eVar.f17413a, eVar.L);
        } else {
            this.f17349b = new Notification.Builder(eVar.f17413a);
        }
        Notification notification = eVar.R;
        this.f17349b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f17421i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f17417e).setContentText(eVar.f17418f).setContentInfo(eVar.f17423k).setContentIntent(eVar.f17419g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f17420h, (notification.flags & 128) != 0).setLargeIcon(eVar.f17422j).setNumber(eVar.f17424l).setProgress(eVar.f17433u, eVar.f17434v, eVar.f17435w);
        if (i10 < 21) {
            this.f17349b.setSound(notification.sound, notification.audioStreamType);
        }
        this.f17349b.setSubText(eVar.f17430r).setUsesChronometer(eVar.f17427o).setPriority(eVar.f17425m);
        Iterator it = eVar.f17414b.iterator();
        while (it.hasNext()) {
            b((s.a) it.next());
        }
        Bundle bundle = eVar.E;
        if (bundle != null) {
            this.f17354g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 20) {
            if (eVar.A) {
                this.f17354g.putBoolean("android.support.localOnly", true);
            }
            String str = eVar.f17436x;
            if (str != null) {
                this.f17354g.putString("android.support.groupKey", str);
                if (eVar.f17437y) {
                    this.f17354g.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f17354g.putBoolean("android.support.useSideChannel", true);
                }
            }
            String str2 = eVar.f17438z;
            if (str2 != null) {
                this.f17354g.putString("android.support.sortKey", str2);
            }
        }
        this.f17351d = eVar.I;
        this.f17352e = eVar.J;
        this.f17349b.setShowWhen(eVar.f17426n);
        if (i11 < 21 && (e10 = e(g(eVar.f17415c), eVar.U)) != null && !e10.isEmpty()) {
            this.f17354g.putStringArray("android.people", (String[]) e10.toArray(new String[e10.size()]));
        }
        if (i11 >= 20) {
            localOnly = this.f17349b.setLocalOnly(eVar.A);
            group = localOnly.setGroup(eVar.f17436x);
            groupSummary = group.setGroupSummary(eVar.f17437y);
            groupSummary.setSortKey(eVar.f17438z);
            this.f17355h = eVar.P;
        }
        if (i11 >= 21) {
            category = this.f17349b.setCategory(eVar.D);
            color = category.setColor(eVar.F);
            visibility = color.setVisibility(eVar.G);
            publicVersion = visibility.setPublicVersion(eVar.H);
            Uri uri = notification.sound;
            audioAttributes = notification.audioAttributes;
            publicVersion.setSound(uri, audioAttributes);
            List e11 = i11 < 28 ? e(g(eVar.f17415c), eVar.U) : eVar.U;
            if (e11 != null && !e11.isEmpty()) {
                Iterator it2 = e11.iterator();
                while (it2.hasNext()) {
                    this.f17349b.addPerson((String) it2.next());
                }
            }
            this.f17356i = eVar.K;
            if (eVar.f17416d.size() > 0) {
                Bundle bundle2 = eVar.e().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i12 = 0; i12 < eVar.f17416d.size(); i12++) {
                    bundle4.putBundle(Integer.toString(i12), f1.b((s.a) eVar.f17416d.get(i12)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.e().putBundle("android.car.EXTENSIONS", bundle2);
                this.f17354g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23 && (icon = eVar.T) != null) {
            this.f17349b.setSmallIcon(icon);
        }
        if (i13 >= 24) {
            this.f17349b.setExtras(eVar.E).setRemoteInputHistory(eVar.f17432t);
            RemoteViews remoteViews = eVar.I;
            if (remoteViews != null) {
                this.f17349b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.J;
            if (remoteViews2 != null) {
                this.f17349b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.K;
            if (remoteViews3 != null) {
                this.f17349b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i13 >= 26) {
            badgeIconType = this.f17349b.setBadgeIconType(eVar.M);
            settingsText = badgeIconType.setSettingsText(eVar.f17431s);
            shortcutId = settingsText.setShortcutId(eVar.N);
            timeoutAfter = shortcutId.setTimeoutAfter(eVar.O);
            timeoutAfter.setGroupAlertBehavior(eVar.P);
            if (eVar.C) {
                this.f17349b.setColorized(eVar.B);
            }
            if (!TextUtils.isEmpty(eVar.L)) {
                this.f17349b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i13 >= 28) {
            Iterator it3 = eVar.f17415c.iterator();
            if (it3.hasNext()) {
                androidx.appcompat.app.m.a(it3.next());
                throw null;
            }
        }
        if (i13 >= 29) {
            this.f17349b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.f17349b.setBubbleMetadata(s.d.a(null));
        }
        if (eVar.S) {
            if (this.f17350c.f17437y) {
                this.f17355h = 2;
            } else {
                this.f17355h = 1;
            }
            this.f17349b.setVibrate(null);
            this.f17349b.setSound(null);
            int i14 = notification.defaults & (-2) & (-3);
            notification.defaults = i14;
            this.f17349b.setDefaults(i14);
            if (i13 >= 26) {
                if (TextUtils.isEmpty(this.f17350c.f17436x)) {
                    this.f17349b.setGroup("silent");
                }
                this.f17349b.setGroupAlertBehavior(this.f17355h);
            }
        }
    }

    public static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        androidx.appcompat.app.m.a(it.next());
        throw null;
    }

    @Override // o.r
    public Notification.Builder a() {
        return this.f17349b;
    }

    public final void b(s.a aVar) {
        Notification.Action build;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 20) {
            this.f17353f.add(f1.e(this.f17349b, aVar));
            return;
        }
        IconCompat f10 = aVar.f();
        Notification.Action.Builder builder = i10 >= 23 ? new Notification.Action.Builder(f10 != null ? f10.u() : null, aVar.j(), aVar.a()) : new Notification.Action.Builder(f10 != null ? f10.g() : 0, aVar.j(), aVar.a());
        if (aVar.g() != null) {
            for (RemoteInput remoteInput : j1.b(aVar.g())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.h());
        if (i11 >= 28) {
            builder.setSemanticAction(aVar.h());
        }
        if (i11 >= 29) {
            builder.setContextual(aVar.k());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
        builder.addExtras(bundle);
        Notification.Builder builder2 = this.f17349b;
        build = builder.build();
        builder2.addAction(build);
    }

    public Notification c() {
        Bundle a10;
        RemoteViews k10;
        RemoteViews i10;
        s.f fVar = this.f17350c.f17429q;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews j10 = fVar != null ? fVar.j(this) : null;
        Notification d10 = d();
        if (j10 != null) {
            d10.contentView = j10;
        } else {
            RemoteViews remoteViews = this.f17350c.I;
            if (remoteViews != null) {
                d10.contentView = remoteViews;
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (fVar != null && (i10 = fVar.i(this)) != null) {
            d10.bigContentView = i10;
        }
        if (i11 >= 21 && fVar != null && (k10 = this.f17350c.f17429q.k(this)) != null) {
            d10.headsUpContentView = k10;
        }
        if (fVar != null && (a10 = s.a(d10)) != null) {
            fVar.a(a10);
        }
        return d10;
    }

    public Notification d() {
        String group;
        String group2;
        String group3;
        String group4;
        String group5;
        String group6;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f17349b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f17349b.build();
            if (this.f17355h != 0) {
                group5 = build.getGroup();
                if (group5 != null && (build.flags & 512) != 0 && this.f17355h == 2) {
                    h(build);
                }
                group6 = build.getGroup();
                if (group6 != null && (build.flags & 512) == 0 && this.f17355h == 1) {
                    h(build);
                }
            }
            return build;
        }
        if (i10 >= 21) {
            this.f17349b.setExtras(this.f17354g);
            Notification build2 = this.f17349b.build();
            RemoteViews remoteViews = this.f17351d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f17352e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f17356i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f17355h != 0) {
                group3 = build2.getGroup();
                if (group3 != null && (build2.flags & 512) != 0 && this.f17355h == 2) {
                    h(build2);
                }
                group4 = build2.getGroup();
                if (group4 != null && (build2.flags & 512) == 0 && this.f17355h == 1) {
                    h(build2);
                }
            }
            return build2;
        }
        if (i10 < 20) {
            SparseArray<? extends Parcelable> a10 = f1.a(this.f17353f);
            if (a10 != null) {
                this.f17354g.putSparseParcelableArray("android.support.actionExtras", a10);
            }
            this.f17349b.setExtras(this.f17354g);
            Notification build3 = this.f17349b.build();
            RemoteViews remoteViews4 = this.f17351d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f17352e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            return build3;
        }
        this.f17349b.setExtras(this.f17354g);
        Notification build4 = this.f17349b.build();
        RemoteViews remoteViews6 = this.f17351d;
        if (remoteViews6 != null) {
            build4.contentView = remoteViews6;
        }
        RemoteViews remoteViews7 = this.f17352e;
        if (remoteViews7 != null) {
            build4.bigContentView = remoteViews7;
        }
        if (this.f17355h != 0) {
            group = build4.getGroup();
            if (group != null && (build4.flags & 512) != 0 && this.f17355h == 2) {
                h(build4);
            }
            group2 = build4.getGroup();
            if (group2 != null && (build4.flags & 512) == 0 && this.f17355h == 1) {
                h(build4);
            }
        }
        return build4;
    }

    public Context f() {
        return this.f17348a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }
}
