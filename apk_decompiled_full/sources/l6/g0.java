package l6;

import android.content.Context;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.activity.MainAty;
import com.msandroid.mobile.R;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.entity.RangerPlayTag;
import com.umeng.analytics.pro.bd;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.LiveAddress;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes3.dex */
public final class g0 implements j6.f {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f15998a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.g f15999b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16000c;

    /* renamed from: d, reason: collision with root package name */
    public o6.a f16001d;

    /* renamed from: e, reason: collision with root package name */
    public List f16002e;

    /* renamed from: f, reason: collision with root package name */
    public Disposable f16003f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f16004g;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f16006b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Channel f16007c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list, Channel channel) {
            super(1);
            this.f16006b = list;
            this.f16007c = channel;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Media invoke(o6.a aVar) {
            t9.i.g(aVar, "it");
            Object obj = aVar.e().get(0);
            t9.i.f(obj, "it.liveAddressList[0]");
            LiveAddress liveAddress = (LiveAddress) obj;
            g0 g0Var = g0.this;
            List list = this.f16006b;
            t9.i.d(list);
            String c10 = aVar.c();
            String supportVideoType = this.f16007c.getSupportVideoType();
            if (supportVideoType == null) {
                supportVideoType = "";
            }
            return g0Var.p(list, liveAddress, c10, supportVideoType);
        }
    }

    public static final class b extends t9.j implements s9.p {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16008a = new b();

        public b() {
            super(2);
        }

        public final void b(ArrayList arrayList, Media media) {
            if (media != null) {
                arrayList.add(media);
            }
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Media) obj2);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Channel f16010b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Channel channel) {
            super(1);
            this.f16010b = channel;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Program invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "it");
            k7.f.e("media size: " + arrayList.size(), new Object[0]);
            return g0.this.q(this.f16010b, arrayList);
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Channel f16012b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Channel channel) {
            super(1);
            this.f16012b = channel;
        }

        public final void b(Program program) {
            com.mobile.brasiltv.utils.b0.U(g0.this, "program info is " + program);
            j6.g x10 = g0.this.x();
            Channel channel = this.f16012b;
            t9.i.f(program, "it");
            x10.C0(channel, program);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Program) obj);
            return h9.t.f14242a;
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f16013a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public g0(b6.f fVar, j6.g gVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(gVar, "view");
        this.f15998a = fVar;
        this.f15999b = gVar;
        this.f16002e = new ArrayList();
        this.f16004g = new ArrayList();
    }

    public static final ArrayList A() {
        return new ArrayList();
    }

    public static final void B(s9.p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final Program C(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Program) lVar.invoke(obj);
    }

    public static final void D(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final Media z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Media) lVar.invoke(obj);
    }

    public void F(boolean z10) {
        this.f16000c = z10;
    }

    public void G(Channel channel) {
        List<LiveAddress> liveAddressList;
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (channel != null && (liveAddressList = channel.getLiveAddressList()) != null && liveAddressList.isEmpty()) {
            z10 = true;
        }
        if (z10) {
            this.f16002e = arrayList;
            return;
        }
        o6.a aVar = new o6.a(o6.c.c().a(), o6.c.c().c(), o6.c.c().d(), new ArrayList());
        o6.a aVar2 = new o6.a(o6.c.b().a(), o6.c.b().c(), o6.c.b().d(), new ArrayList());
        o6.a aVar3 = new o6.a(o6.c.a().a(), o6.c.a().c(), o6.c.a().d(), new ArrayList());
        t9.i.d(channel);
        List<LiveAddress> liveAddressList2 = channel.getLiveAddressList();
        if (liveAddressList2 != null) {
            for (LiveAddress liveAddress : liveAddressList2) {
                if (com.mobile.brasiltv.utils.b0.J(liveAddress.getQuality()) || t9.i.b(liveAddress.getQuality(), "1")) {
                    aVar.e().add(liveAddress);
                } else if (t9.i.b(liveAddress.getQuality(), "2")) {
                    aVar2.e().add(liveAddress);
                } else if (t9.i.b(liveAddress.getQuality(), "3")) {
                    aVar3.e().add(liveAddress);
                }
            }
        }
        if (!aVar3.e().isEmpty()) {
            arrayList.add(aVar3);
        }
        if (!aVar2.e().isEmpty()) {
            arrayList.add(aVar2);
        }
        if (!aVar.e().isEmpty()) {
            arrayList.add(aVar);
        }
        this.f16002e = arrayList;
    }

    @Override // j6.f
    public void b(Channel channel, String str) {
        String str2;
        String str3;
        t9.i.g(str, "slbHost");
        t();
        if (channel == null) {
            return;
        }
        com.mobile.brasiltv.utils.b0.U(this, "channel: " + channel);
        r5.i iVar = r5.i.f18523a;
        List x10 = iVar.x(r5.k.LIVE);
        if (x10 == null || x10.isEmpty()) {
            com.mobile.brasiltv.utils.b0.U(this, "live cdn list");
            str2 = iVar.z();
            if (str2.length() == 0) {
                str2 = "20900";
            }
            str3 = com.mobile.brasiltv.utils.y.f8771a.c(str2);
        } else {
            str2 = "";
            str3 = str2;
        }
        List<LiveAddress> liveAddressList = channel.getLiveAddressList();
        if (liveAddressList == null || liveAddressList.isEmpty()) {
            com.mobile.brasiltv.utils.b0.U(this, "live address list is empty");
            str3 = "EC21";
            str2 = AgooConstants.REPORT_MESSAGE_NULL;
        }
        String str4 = str2;
        String str5 = str3;
        if (!t9.i.b(str5, "")) {
            c2.d.f5311a.g(channel.getChannelCode(), channel.getName(), str, com.mobile.brasiltv.utils.y.f8771a.h(), "", str5, str4, "apk");
            j6.g gVar = this.f15999b;
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            Context context = this.f15998a.getContext();
            sb.append(context != null ? com.mobile.brasiltv.utils.x.f8754a.y(context, R.string.failed_ec5) : null);
            gVar.z0(sb.toString());
            return;
        }
        com.mobile.brasiltv.utils.b0.U(this, "live cdn tag list: " + x10);
        Observable fromIterable = Observable.fromIterable(this.f16002e);
        final a aVar = new a(x10, channel);
        Observable map = fromIterable.map(new Function() { // from class: l6.a0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Media z10;
                z10 = g0.z(s9.l.this, obj);
                return z10;
            }
        });
        Callable callable = new Callable() { // from class: l6.b0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ArrayList A;
                A = g0.A();
                return A;
            }
        };
        final b bVar = b.f16008a;
        Single collect = map.collect(callable, new BiConsumer() { // from class: l6.c0
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                g0.B(s9.p.this, obj, obj2);
            }
        });
        final c cVar = new c(channel);
        Single compose = collect.map(new Function() { // from class: l6.d0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Program C;
                C = g0.C(s9.l.this, obj);
                return C;
            }
        }).compose(ma.q.c()).compose(this.f15998a.O2());
        final d dVar = new d(channel);
        Consumer consumer = new Consumer() { // from class: l6.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g0.D(s9.l.this, obj);
            }
        };
        final e eVar = e.f16013a;
        this.f16003f = compose.subscribe(consumer, new Consumer() { // from class: l6.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g0.E(s9.l.this, obj);
            }
        });
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final Media p(List list, LiveAddress liveAddress, String str, String str2) {
        String playCode = liveAddress.getPlayCode();
        if ((playCode == null || playCode.length() == 0) || !list.contains(liveAddress.getTag())) {
            return null;
        }
        String playCode2 = liveAddress.getPlayCode();
        t9.i.d(playCode2);
        return new Media(playCode2, liveAddress.getLicense(), "", str, str2, com.mobile.brasiltv.utils.b0.K(liveAddress.getAVFormat()) ? liveAddress.getAVFormat() : "");
    }

    public final Program q(Channel channel, List list) {
        return new Program(channel.getChannelCode(), RangerPlayTag.LIVE.getValue(), channel.getName(), "-1", this.f15999b.Z0(), bd.f9986m, list, "", 0L);
    }

    public void r() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Object obj = null;
        if (this.f16002e.isEmpty()) {
            this.f16001d = null;
            return;
        }
        List list = this.f16002e;
        boolean z14 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((o6.a) it.next()).b() == MainAty.A.d()) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (z10) {
            Iterator it2 = this.f16002e.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((o6.a) next).b() == MainAty.A.d()) {
                    obj = next;
                    break;
                }
            }
            this.f16001d = (o6.a) obj;
            return;
        }
        int d10 = MainAty.A.d();
        if (d10 == 1) {
            List list2 = this.f16002e;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    if (t9.i.b(((o6.a) it3.next()).c(), "720p")) {
                        z11 = true;
                        break;
                    }
                }
            }
            z11 = false;
            if (z11) {
                Iterator it4 = this.f16002e.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next2 = it4.next();
                    if (t9.i.b(((o6.a) next2).c(), "720p")) {
                        obj = next2;
                        break;
                    }
                }
                o6.a aVar = (o6.a) obj;
                this.f16001d = aVar;
                MainAty.a aVar2 = MainAty.A;
                t9.i.d(aVar);
                aVar2.m(aVar.b());
                return;
            }
            List list3 = this.f16002e;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it5 = list3.iterator();
                while (it5.hasNext()) {
                    if (t9.i.b(((o6.a) it5.next()).c(), "1080p")) {
                        break;
                    }
                }
            }
            z14 = false;
            if (z14) {
                Iterator it6 = this.f16002e.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next3 = it6.next();
                    if (t9.i.b(((o6.a) next3).c(), "1080p")) {
                        obj = next3;
                        break;
                    }
                }
                o6.a aVar3 = (o6.a) obj;
                this.f16001d = aVar3;
                MainAty.a aVar4 = MainAty.A;
                t9.i.d(aVar3);
                aVar4.m(aVar3.b());
                return;
            }
            return;
        }
        if (d10 == 2) {
            List list4 = this.f16002e;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator it7 = list4.iterator();
                while (it7.hasNext()) {
                    if (t9.i.b(((o6.a) it7.next()).c(), "480p")) {
                        z12 = true;
                        break;
                    }
                }
            }
            z12 = false;
            if (z12) {
                Iterator it8 = this.f16002e.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        break;
                    }
                    Object next4 = it8.next();
                    if (t9.i.b(((o6.a) next4).c(), "480p")) {
                        obj = next4;
                        break;
                    }
                }
                o6.a aVar5 = (o6.a) obj;
                this.f16001d = aVar5;
                MainAty.a aVar6 = MainAty.A;
                t9.i.d(aVar5);
                aVar6.m(aVar5.b());
                return;
            }
            List list5 = this.f16002e;
            if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                Iterator it9 = list5.iterator();
                while (it9.hasNext()) {
                    if (t9.i.b(((o6.a) it9.next()).c(), "1080p")) {
                        break;
                    }
                }
            }
            z14 = false;
            if (z14) {
                Iterator it10 = this.f16002e.iterator();
                while (true) {
                    if (!it10.hasNext()) {
                        break;
                    }
                    Object next5 = it10.next();
                    if (t9.i.b(((o6.a) next5).c(), "1080p")) {
                        obj = next5;
                        break;
                    }
                }
                o6.a aVar7 = (o6.a) obj;
                this.f16001d = aVar7;
                MainAty.a aVar8 = MainAty.A;
                t9.i.d(aVar7);
                aVar8.m(aVar7.b());
                return;
            }
            return;
        }
        if (d10 != 3) {
            return;
        }
        List list6 = this.f16002e;
        if (!(list6 instanceof Collection) || !list6.isEmpty()) {
            Iterator it11 = list6.iterator();
            while (it11.hasNext()) {
                if (t9.i.b(((o6.a) it11.next()).c(), "720p")) {
                    z13 = true;
                    break;
                }
            }
        }
        z13 = false;
        if (z13) {
            Iterator it12 = this.f16002e.iterator();
            while (true) {
                if (!it12.hasNext()) {
                    break;
                }
                Object next6 = it12.next();
                if (t9.i.b(((o6.a) next6).c(), "720p")) {
                    obj = next6;
                    break;
                }
            }
            o6.a aVar9 = (o6.a) obj;
            this.f16001d = aVar9;
            MainAty.a aVar10 = MainAty.A;
            t9.i.d(aVar9);
            aVar10.m(aVar9.b());
            return;
        }
        List list7 = this.f16002e;
        if (!(list7 instanceof Collection) || !list7.isEmpty()) {
            Iterator it13 = list7.iterator();
            while (it13.hasNext()) {
                if (t9.i.b(((o6.a) it13.next()).c(), "480p")) {
                    break;
                }
            }
        }
        z14 = false;
        if (z14) {
            Iterator it14 = this.f16002e.iterator();
            while (true) {
                if (!it14.hasNext()) {
                    break;
                }
                Object next7 = it14.next();
                if (t9.i.b(((o6.a) next7).c(), "480p")) {
                    obj = next7;
                    break;
                }
            }
            o6.a aVar11 = (o6.a) obj;
            this.f16001d = aVar11;
            MainAty.a aVar12 = MainAty.A;
            t9.i.d(aVar11);
            aVar12.m(aVar11.b());
        }
    }

    public void s() {
        this.f16001d = null;
        MainAty.A.m(1);
    }

    public final void t() {
        Disposable disposable = this.f16003f;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        Disposable disposable2 = this.f16003f;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f16003f = null;
    }

    public final ArrayList u() {
        if (this.f16004g == null) {
            this.f16004g = new ArrayList();
        }
        this.f16004g.clear();
        d6.a aVar = d6.a.f12650a;
        if (aVar.j() == 3 && aVar.i().size() > 0) {
            for (Iterator it = aVar.i().iterator(); it.hasNext(); it = it) {
                Favorite favorite = (Favorite) it.next();
                ArrayList arrayList = this.f16004g;
                String contentId = favorite.getContentId();
                t9.i.d(contentId);
                String name = favorite.getName();
                t9.i.d(name);
                arrayList.add(new Channel(contentId, name, favorite.getAlias(), 0, favorite.getPosterUrl(), null, "0", null, null, null, null));
            }
        }
        return this.f16004g;
    }

    public o6.a v() {
        return this.f16001d;
    }

    public final ArrayList w() {
        return this.f16004g;
    }

    public final j6.g x() {
        return this.f15999b;
    }

    public boolean y() {
        return this.f16000c;
    }
}
