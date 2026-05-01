package d6;

import android.text.TextUtils;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import h9.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mobile.com.requestframe.utils.response.AddFavorite;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.GetFavoriteDate;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12650a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList f12651b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList f12652c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f12653d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList f12654e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public static int f12655f = 1;

    /* renamed from: d6.a$a, reason: collision with other inner class name */
    public static final class C0206a extends ha.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Channel f12656a;

        /* renamed from: d6.a$a$a, reason: collision with other inner class name */
        public static final class C0207a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12657a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0207a(String str) {
                super(1);
                this.f12657a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f12657a, null, null, 6, null));
            }
        }

        public C0206a(Channel channel) {
            this.f12656a = channel;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(AddFavoriteResult addFavoriteResult) {
            i.g(addFavoriteResult, "it");
            List<AddFavorite> favoriteList = addFavoriteResult.getData().getFavoriteList();
            i.d(favoriteList);
            Favorite favorite = new Favorite(favoriteList.get(0).getFavoriteId(), this.f12656a.getChannelCode(), this.f12656a.getName(), "2", null, this.f12656a.getAlias(), null, null, null, null, null, this.f12656a.getPosterUrl(), false, 4096, null);
            if (!a.f12652c.contains(this.f12656a.getChannelCode())) {
                a.f12651b.add(0, favorite);
                a.f12652c.add(0, this.f12656a.getChannelCode());
                HashMap hashMap = a.f12653d;
                String channelCode = this.f12656a.getChannelCode();
                Integer id = favorite.getId();
                i.d(id);
                hashMap.put(channelCode, id);
            }
            if (a.f12654e.contains(this.f12656a.getChannelCode())) {
                a.f12654e.remove(this.f12656a.getChannelCode());
            }
            xa.c.c().j(new UpdateFavStatusEvent(this.f12656a.getChannelCode(), true));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            if (a.f12654e.contains(this.f12656a.getChannelCode())) {
                a.f12654e.remove(this.f12656a.getChannelCode());
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (TextUtils.equals("portal100061", str)) {
                f1.a.j(f1.f8649a, App.f8263e.a(), R.string.vod_fav_limit, 0, 4, null);
            } else {
                x.f8754a.w(App.f8263e.a(), new C0207a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Channel f12658a;

        /* renamed from: d6.a$b$a, reason: collision with other inner class name */
        public static final class C0208a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f12659a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0208a(String str) {
                super(1);
                this.f12659a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f12659a, null, null, 6, null));
            }
        }

        public b(Channel channel) {
            this.f12658a = channel;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            i.g(delFavoriteResult, "it");
            if (a.f12652c.contains(this.f12658a.getChannelCode())) {
                a.f12652c.remove(this.f12658a.getChannelCode());
                a.f12653d.remove(this.f12658a.getChannelCode());
            }
            ArrayList arrayList = a.f12651b;
            Channel channel = this.f12658a;
            int i10 = -1;
            int i11 = 0;
            for (Object obj : arrayList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (i.b(((Favorite) obj).getContentId(), channel.getChannelCode())) {
                    i10 = i11;
                }
                i11 = i12;
            }
            if (i10 >= 0) {
                a.f12651b.remove(i10);
            }
            if (a.f12654e.contains(this.f12658a.getChannelCode())) {
                a.f12654e.remove(this.f12658a.getChannelCode());
            }
            xa.c.c().j(new UpdateFavStatusEvent(this.f12658a.getChannelCode(), false));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            if (a.f12654e.contains(this.f12658a.getChannelCode())) {
                a.f12654e.remove(this.f12658a.getChannelCode());
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            x.f8754a.w(App.f8263e.a(), new C0208a(str));
        }
    }

    public static final class c extends ha.a {
        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetFavoriteResult getFavoriteResult) {
            i.g(getFavoriteResult, "it");
            a.f12650a.n(3);
            a.f12651b.clear();
            a.f12652c.clear();
            a.f12653d.clear();
            if (getFavoriteResult.getData() != null) {
                GetFavoriteDate data = getFavoriteResult.getData();
                i.d(data);
                if (b0.I(data.getFavoriteList())) {
                    ArrayList arrayList = a.f12651b;
                    GetFavoriteDate data2 = getFavoriteResult.getData();
                    i.d(data2);
                    List<Favorite> favoriteList = data2.getFavoriteList();
                    i.d(favoriteList);
                    arrayList.addAll(favoriteList);
                    GetFavoriteDate data3 = getFavoriteResult.getData();
                    i.d(data3);
                    List<Favorite> favoriteList2 = data3.getFavoriteList();
                    i.d(favoriteList2);
                    for (Favorite favorite : favoriteList2) {
                        ArrayList arrayList2 = a.f12652c;
                        String contentId = favorite.getContentId();
                        i.d(contentId);
                        arrayList2.add(contentId);
                        HashMap hashMap = a.f12653d;
                        String contentId2 = favorite.getContentId();
                        i.d(contentId2);
                        Integer id = favorite.getId();
                        i.d(id);
                        hashMap.put(contentId2, id);
                    }
                }
            }
            xa.c.c().j(new AlreadyQueryFavEvent());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            a.f12650a.n(1);
        }
    }

    public final void e(Channel channel) {
        i.g(channel, "channel");
        w6.i.c1(w6.i.f19214g.b(), "2", i9.i.b(channel.getChannelCode()), false, 4, null).compose(p0.b()).subscribe(new C0206a(channel));
    }

    public final void f(String str) {
        i.g(str, "channelCode");
        f12654e.add(str);
    }

    public final boolean g(Channel channel) {
        i.g(channel, "channel");
        return f12652c.contains(channel.getChannelCode());
    }

    public final void h(Channel channel) {
        i.g(channel, "channel");
        if (!f12652c.contains(channel.getChannelCode()) || !f12653d.containsKey(channel.getChannelCode())) {
            xa.c.c().j(new UpdateFavStatusEvent(channel.getChannelCode(), false));
            return;
        }
        Object obj = f12653d.get(channel.getChannelCode());
        i.d(obj);
        w6.i.f19214g.b().o1(new int[]{((Number) obj).intValue()}).compose(p0.b()).subscribe(new b(channel));
    }

    public final ArrayList i() {
        return f12651b;
    }

    public final int j() {
        return f12655f;
    }

    public final void k() {
        f12655f = 1;
    }

    public final boolean l(String str) {
        i.g(str, "channelCode");
        return f12654e.contains(str);
    }

    public final void m() {
        f12655f = 2;
        w6.i.v1(w6.i.f19214g.b(), "live", null, 2, null).compose(p0.b()).subscribe(new c());
    }

    public final void n(int i10) {
        f12655f = i10;
    }
}
