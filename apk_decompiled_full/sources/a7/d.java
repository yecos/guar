package a7;

import com.hpplay.cybergarage.upnp.Icon;
import io.jsonwebtoken.Claims;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.ShelvePoster;
import t9.i;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f279a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final String f280b = "poster";

    /* renamed from: c, reason: collision with root package name */
    public static final String f281c = "special_topic";

    /* renamed from: d, reason: collision with root package name */
    public static final String f282d = "banner";

    /* renamed from: e, reason: collision with root package name */
    public static final String f283e = Icon.ELEM_NAME;

    /* renamed from: f, reason: collision with root package name */
    public static final String f284f = "background";

    /* renamed from: g, reason: collision with root package name */
    public static final String f285g = "stage";

    /* renamed from: h, reason: collision with root package name */
    public static final String f286h = "special_topic_banner";

    /* renamed from: i, reason: collision with root package name */
    public static final String f287i = "logo";

    public static final void d(List list, String str, ObservableEmitter observableEmitter) {
        i.g(str, "$type");
        i.g(observableEmitter, Claims.SUBJECT);
        if (list == null || list.isEmpty()) {
            observableEmitter.onError(new Exception("图片不存在"));
            return;
        }
        if (str.length() == 0) {
            observableEmitter.onNext(list.get(0));
            observableEmitter.onComplete();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PosterList posterList = (PosterList) it.next();
            if (i.b(str, posterList.getFileType())) {
                observableEmitter.onNext(posterList);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onError(new Exception("图片不存在"));
    }

    public static final void m(List list, String str, ObservableEmitter observableEmitter) {
        i.g(str, "$type");
        i.g(observableEmitter, Claims.SUBJECT);
        if (list == null || list.isEmpty()) {
            observableEmitter.onError(new Exception("图片不存在"));
            return;
        }
        if (str.length() == 0) {
            observableEmitter.onNext(list.get(0));
            observableEmitter.onComplete();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShelvePoster shelvePoster = (ShelvePoster) it.next();
            if (i.b(str, shelvePoster.getFileType())) {
                observableEmitter.onNext(shelvePoster);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onError(new Exception("图片不存在"));
    }

    public final Observable c(final List list, final String str) {
        i.g(str, "type");
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: a7.c
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                d.d(list, str, observableEmitter);
            }
        });
        i.f(create, "create { sub ->\n        …ption(\"图片不存在\"))\n        }");
        return create;
    }

    public final String e() {
        return f284f;
    }

    public final String f() {
        return f282d;
    }

    public final String g() {
        return f283e;
    }

    public final String h() {
        return f287i;
    }

    public final String i() {
        return f280b;
    }

    public final String j() {
        return f286h;
    }

    public final String k() {
        return f285g;
    }

    public final Observable l(final List list, final String str) {
        i.g(str, "type");
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: a7.b
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                d.m(list, str, observableEmitter);
            }
        });
        i.f(create, "create { sub ->\n        …ption(\"图片不存在\"))\n        }");
        return create;
    }

    public final String n(List list, String str) {
        i.g(str, "type");
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PosterList posterList = (PosterList) it.next();
            if (str.equals(posterList.getFileType())) {
                return posterList.getFileUrl();
            }
        }
        return null;
    }

    public final String o(List list, String str) {
        i.g(str, "type");
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShelvePoster shelvePoster = (ShelvePoster) it.next();
            if (str.equals(shelvePoster != null ? shelvePoster.getFileType() : null)) {
                return shelvePoster.getFileUrl();
            }
        }
        return null;
    }
}
