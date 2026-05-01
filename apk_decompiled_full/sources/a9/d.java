package a9;

import anet.channel.util.HttpConstant;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import y8.j0;
import y8.v0;
import z8.k2;
import z8.q0;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c9.d f324a;

    /* renamed from: b, reason: collision with root package name */
    public static final c9.d f325b;

    /* renamed from: c, reason: collision with root package name */
    public static final c9.d f326c;

    /* renamed from: d, reason: collision with root package name */
    public static final c9.d f327d;

    /* renamed from: e, reason: collision with root package name */
    public static final c9.d f328e;

    /* renamed from: f, reason: collision with root package name */
    public static final c9.d f329f;

    static {
        ByteString byteString = c9.d.f5669g;
        f324a = new c9.d(byteString, "https");
        f325b = new c9.d(byteString, HttpConstant.HTTP);
        ByteString byteString2 = c9.d.f5667e;
        f326c = new c9.d(byteString2, "POST");
        f327d = new c9.d(byteString2, "GET");
        f328e = new c9.d(q0.f20842j.d(), "application/grpc");
        f329f = new c9.d("te", "trailers");
    }

    public static List a(List list, v0 v0Var) {
        byte[][] d10 = k2.d(v0Var);
        for (int i10 = 0; i10 < d10.length; i10 += 2) {
            ByteString of = ByteString.of(d10[i10]);
            if (of.size() != 0 && of.getByte(0) != 58) {
                list.add(new c9.d(of, ByteString.of(d10[i10 + 1])));
            }
        }
        return list;
    }

    public static List b(v0 v0Var, String str, String str2, String str3, boolean z10, boolean z11) {
        Preconditions.checkNotNull(v0Var, "headers");
        Preconditions.checkNotNull(str, "defaultPath");
        Preconditions.checkNotNull(str2, "authority");
        c(v0Var);
        ArrayList arrayList = new ArrayList(j0.a(v0Var) + 7);
        if (z11) {
            arrayList.add(f325b);
        } else {
            arrayList.add(f324a);
        }
        if (z10) {
            arrayList.add(f327d);
        } else {
            arrayList.add(f326c);
        }
        arrayList.add(new c9.d(c9.d.f5670h, str2));
        arrayList.add(new c9.d(c9.d.f5668f, str));
        arrayList.add(new c9.d(q0.f20844l.d(), str3));
        arrayList.add(f328e);
        arrayList.add(f329f);
        return a(arrayList, v0Var);
    }

    public static void c(v0 v0Var) {
        v0Var.e(q0.f20842j);
        v0Var.e(q0.f20843k);
        v0Var.e(q0.f20844l);
    }
}
