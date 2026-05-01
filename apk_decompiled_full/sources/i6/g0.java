package i6;

import com.mobile.brasiltv.bean.AudioTrackBean;
import com.titan.ranger.bean.Program;
import java.util.HashMap;
import java.util.List;
import mobile.com.requestframe.utils.response.AssetData;

/* loaded from: classes3.dex */
public interface g0 extends m5.a {

    /* renamed from: b0, reason: collision with root package name */
    public static final a f14313b0 = a.f14314a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f14314a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final String f14315b = "TDC_From";

        /* renamed from: c, reason: collision with root package name */
        public static final String f14316c = "type";

        /* renamed from: d, reason: collision with root package name */
        public static final String f14317d = "programType";

        /* renamed from: e, reason: collision with root package name */
        public static final String f14318e = "contentId";

        /* renamed from: f, reason: collision with root package name */
        public static final String f14319f = "entryType";

        /* renamed from: g, reason: collision with root package name */
        public static final String f14320g = "topicName";

        /* renamed from: h, reason: collision with root package name */
        public static final String f14321h = "topicImage";

        /* renamed from: i, reason: collision with root package name */
        public static final String f14322i = "isCr";

        /* renamed from: j, reason: collision with root package name */
        public static final String f14323j = "isFree";

        /* renamed from: k, reason: collision with root package name */
        public static final String f14324k = "parentColumnId";

        /* renamed from: l, reason: collision with root package name */
        public static final String f14325l = "is_cast";

        public final String a() {
            return f14318e;
        }

        public final String b() {
            return f14319f;
        }

        public final String c() {
            return f14322i;
        }

        public final String d() {
            return f14323j;
        }

        public final String e() {
            return f14324k;
        }

        public final String f() {
            return f14317d;
        }

        public final String g() {
            return f14315b;
        }

        public final String h() {
            return f14321h;
        }

        public final String i() {
            return f14320g;
        }

        public final String j() {
            return f14316c;
        }

        public final String k() {
            return f14325l;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(g0 g0Var, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorInWindow");
            }
            if ((i10 & 1) != 0) {
                str = "-10000";
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            g0Var.E0(str, z10);
        }

        public static /* synthetic */ void b(g0 g0Var, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadError");
            }
            if ((i10 & 1) != 0) {
                str = "-10000";
            }
            g0Var.y0(str);
        }
    }

    void D1();

    void D2(HashMap hashMap, AudioTrackBean audioTrackBean);

    void E0(String str, boolean z10);

    void G1(List list);

    void G2();

    void I0(List list);

    void N0(AssetData assetData);

    void T1(String str, Program program);

    void W0(AssetData assetData);

    void d0(AssetData assetData);

    void d2();

    void f0(AssetData assetData);

    void g0(boolean z10);

    void i0();

    void u1(boolean z10);

    void w2();

    void y0(String str);

    long z1();
}
