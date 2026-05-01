package com.mobile.brasiltv.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.activity.SingleColumnAty;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.mine.activity.MyBenefitsAty;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.taobao.accs.common.Constants;
import i6.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.ShelveAsset;
import w6.i;

/* loaded from: classes3.dex */
public abstract class b0 {

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.l f8618a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f8619b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s9.l lVar, Intent intent) {
            super(0);
            this.f8618a = lVar;
            this.f8619b = intent;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke() {
            return (Intent) this.f8618a.invoke(this.f8619b);
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f8620a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Intent intent) {
            super(0);
            this.f8620a = intent;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke() {
            return this.f8620a;
        }
    }

    public static final String A(Context context, int i10) {
        t9.i.g(context, "<this>");
        String string = context.getString(i10);
        t9.i.f(string, "this.getString(resId)");
        return string;
    }

    public static final void B(b6.f fVar) {
        t9.i.g(fVar, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/activity-center?lang=");
        sb.append(f0.a());
        sb.append("&uid=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&appId=");
        sb.append(na.a.g());
        sb.append("&tk=");
        sb.append(cVar.J());
        sb.append("&loginType=3&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        k0(fVar, sb.toString(), false, true, false, 8, null);
    }

    public static final void C(f5.c cVar) {
        t9.i.g(cVar, "<this>");
        Context Q1 = cVar.Q1();
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/activity-center?lang=");
        sb.append(f0.a());
        sb.append("&uid=");
        i.c cVar2 = w6.i.f19214g;
        sb.append(cVar2.H());
        sb.append("&appId=");
        sb.append(na.a.g());
        sb.append("&tk=");
        sb.append(cVar2.J());
        sb.append("&loginType=3&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar2.v());
        j0(Q1, sb.toString(), false, true, false, false, 24, null);
    }

    public static final void D(b6.f fVar) {
        t9.i.g(fVar, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/invite?lang=");
        sb.append(f0.a());
        sb.append("&userId=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&appId=");
        sb.append(na.a.g());
        sb.append("&tk=");
        sb.append(cVar.J());
        sb.append("&loginType=3&userIdentify=");
        sb.append(cVar.I());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&timeStamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        i0(fVar, sb.toString(), true, true, true);
    }

    public static final void E(f5.c cVar) {
        t9.i.g(cVar, "<this>");
        Context Q1 = cVar.Q1();
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/invite?lang=");
        sb.append(f0.a());
        sb.append("&userId=");
        i.c cVar2 = w6.i.f19214g;
        sb.append(cVar2.H());
        sb.append("&appId=");
        sb.append(na.a.g());
        sb.append("&tk=");
        sb.append(cVar2.J());
        sb.append("&loginType=3&userIdentify=");
        sb.append(cVar2.I());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&timeStamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar2.v());
        j0(Q1, sb.toString(), true, true, true, false, 16, null);
    }

    public static final void F(f5.c cVar) {
        t9.i.g(cVar, "<this>");
        Object systemService = cVar.getSystemService("input_method");
        t9.i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(cVar.getWindow().getDecorView().getWindowToken(), 0);
    }

    public static final boolean G(ArrayList arrayList) {
        return arrayList == null || arrayList.size() == 0;
    }

    public static final boolean H(String str) {
        if (str != null) {
            return str.length() > 0;
        }
        return false;
    }

    public static final boolean I(Collection collection) {
        return collection != null && (collection.isEmpty() ^ true);
    }

    public static final boolean J(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence);
    }

    public static final boolean K(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence);
    }

    public static final void L(Object obj, String str) {
        t9.i.g(obj, "<this>");
    }

    public static final void M(f5.c cVar) {
        Context Q1;
        i.c cVar2 = w6.i.f19214g;
        boolean b10 = t9.i.b(cVar2.e(), "0");
        if (cVar == null || (Q1 = cVar.Q1()) == null) {
            return;
        }
        j0(Q1, x(m7.c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + na.a.g() + "&userId=" + cVar2.H() + "&lang=" + f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar2.v(), false, true, false, false, 24, null);
    }

    public static final void N(Activity activity) {
        t9.i.g(activity, "<this>");
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        activity.getWindow().setAttributes(attributes);
    }

    public static final void O(Activity activity, float f10) {
        t9.i.g(activity, "<this>");
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = f10;
        activity.getWindow().setAttributes(attributes);
    }

    public static final void P(View view, final View.OnClickListener onClickListener) {
        t9.i.g(view, "<this>");
        t9.i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        final t9.v vVar = new t9.v();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.utils.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b0.Q(t9.v.this, onClickListener, view2);
            }
        });
    }

    public static final void Q(t9.v vVar, View.OnClickListener onClickListener, View view) {
        t9.i.g(vVar, "$lastTime");
        t9.i.g(onClickListener, "$listener");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - vVar.f18960a > 500) {
            vVar.f18960a = currentTimeMillis;
            onClickListener.onClick(view);
        }
    }

    public static final void R(Dialog dialog) {
        t9.i.g(dialog, "<this>");
        DialogManager.INSTANCE.showNext(dialog);
    }

    public static final void S(Dialog dialog, String str) {
        t9.i.g(dialog, "<this>");
        t9.i.g(str, FirebaseAnalytics.Param.LEVEL);
        DialogManager.INSTANCE.showByManager(dialog, str);
    }

    public static final boolean T(CharSequence charSequence, CharSequence charSequence2) {
        return TextUtils.equals(charSequence, charSequence2);
    }

    public static final void U(Object obj, String str) {
        t9.i.g(obj, "<this>");
    }

    public static final void V(f5.c cVar, s9.a aVar) {
        t9.i.g(cVar, "<this>");
        t9.i.g(aVar, "intent");
        try {
            cVar.startActivity((Intent) aVar.invoke());
        } catch (ActivityNotFoundException unused) {
            f1.f8649a.u("no found this app!");
        }
    }

    public static final GlideUrl W(String str) {
        t9.i.g(str, "<this>");
        try {
            return new GlideUrl(str, new LazyHeaders.Builder().addHeader("ReqSource", "own").build());
        } catch (Exception unused) {
            return null;
        }
    }

    public static final float X(String str) {
        if (str == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return 0.0f;
        }
    }

    public static final int Y(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static final long Z(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public static final void a0(b6.f fVar, Class cls) {
        t9.i.g(fVar, "<this>");
        t9.i.g(cls, "clazz");
        c0(w(fVar), cls);
    }

    public static final void b0(b6.f fVar, Class cls, s9.l lVar) {
        t9.i.g(fVar, "<this>");
        t9.i.g(cls, "clazz");
        t9.i.g(lVar, "addExtra");
        d0(w(fVar), cls, lVar);
    }

    public static final String c(String str, String str2) {
        if (f0.b()) {
            return str2 == null ? "" : str2;
        }
        boolean z10 = false;
        if (str != null) {
            if (str.length() > 0) {
                z10 = true;
            }
        }
        return z10 ? str : str2 == null ? "" : str2;
    }

    public static final void c0(f5.c cVar, Class cls) {
        t9.i.g(cVar, "<this>");
        t9.i.g(cls, "clazz");
        V(cVar, new b(new Intent(cVar, (Class<?>) cls)));
    }

    public static final void d(TextView textView, String str, String str2) {
        t9.i.g(textView, "view");
        if (f0.b()) {
            if (str2 == null) {
                str2 = "";
            }
            textView.setText(str2);
            return;
        }
        boolean z10 = false;
        if (str != null) {
            if (str.length() > 0) {
                z10 = true;
            }
        }
        if (z10) {
            textView.setText(str);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        textView.setText(str2);
    }

    public static final void d0(f5.c cVar, Class cls, s9.l lVar) {
        t9.i.g(cVar, "<this>");
        t9.i.g(cls, "clazz");
        t9.i.g(lVar, "addExtra");
        V(cVar, new a(lVar, new Intent(cVar, (Class<?>) cls)));
    }

    public static final String e(String str, String str2) {
        Context context = na.a.f17333a;
        t9.i.f(context, "mContext");
        c cVar = new c(context);
        boolean z10 = false;
        if (f0.b() || t9.i.b(cVar.c(), "es")) {
            if (!(str2 == null || str2.length() == 0)) {
                return str2 == null ? "" : str2;
            }
        }
        if (str != null) {
            if (str.length() > 0) {
                z10 = true;
            }
        }
        return z10 ? str : str2 == null ? "" : str2;
    }

    public static final void e0(f5.c cVar, Class cls, int i10) {
        t9.i.g(cVar, "<this>");
        t9.i.g(cls, "clazz");
        cVar.startActivityForResult(new Intent(cVar, (Class<?>) cls), i10);
    }

    public static final void f(View view, final s9.l lVar, long j10) {
        t9.i.g(view, "<this>");
        t9.i.g(lVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        final c0 c0Var = new c0(j10);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.utils.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b0.g(c0.this, lVar, view2);
            }
        });
    }

    public static final void f0(Context context, String str) {
        t9.i.g(context, "<this>");
        if (str != null) {
            if (!ba.t.o(str, "http://", false, 2, null) && !ba.t.o(str, "https://", false, 2, null)) {
                str = "http://" + str;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                context.startActivity(intent);
            }
        }
    }

    public static final void g(c0 c0Var, s9.l lVar, View view) {
        t9.i.g(c0Var, "$bean");
        t9.i.g(lVar, "$listener");
        if (System.currentTimeMillis() - c0Var.b() > c0Var.a()) {
            t9.i.f(view, "it");
            lVar.invoke(view);
        }
        c0Var.c(System.currentTimeMillis());
    }

    public static final void g0(Context context, String str) {
        t9.i.g(context, "<this>");
        if (str == null) {
            return;
        }
        try {
            if (!ba.t.o(str, "http://", false, 2, null) && !ba.t.o(str, "https://", false, 2, null)) {
                str = "http://" + str;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                context.startActivity(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static final boolean h(Activity activity, String str) {
        t9.i.g(activity, "<this>");
        t9.i.g(str, Constants.KEY_PACKAGE_NAME);
        try {
            activity.getPackageManager().getPackageInfo(str, 64);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static final void h0(Context context, String str, boolean z10, boolean z11, boolean z12, boolean z13) {
        String str2;
        t9.i.g(context, "<this>");
        if (str != null) {
            if (ba.t.o(str, "http://", false, 2, null) || ba.t.o(str, "https://", false, 2, null)) {
                str2 = str;
            } else {
                str2 = "http://" + str;
            }
            WebViewAty.a aVar = WebViewAty.B;
            if (aVar.k(context, str)) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) WebViewAty.class);
            intent.putExtra(aVar.j(), str2);
            intent.putExtra(aVar.a(), z10);
            intent.putExtra(aVar.e(), z11);
            intent.putExtra(aVar.i(), z12);
            intent.putExtra(aVar.f(), z13);
            context.startActivity(intent);
        }
    }

    public static final void i(Context context, String str) {
        t9.i.g(context, "<this>");
        t9.i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        Object systemService = context.getSystemService("clipboard");
        t9.i.e(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("copy", str));
    }

    public static final void i0(b6.f fVar, String str, boolean z10, boolean z11, boolean z12) {
        t9.i.g(fVar, "<this>");
        t9.i.g(str, "urlPath");
        j0(w(fVar).Q1(), str, z10, z11, z12, false, 16, null);
    }

    public static final void j(Dialog dialog) {
        t9.i.g(dialog, "<this>");
        DialogManager.INSTANCE.dismissAndShowNext(dialog);
    }

    public static /* synthetic */ void j0(Context context, String str, boolean z10, boolean z11, boolean z12, boolean z13, int i10, Object obj) {
        h0(context, str, z10, z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13);
    }

    public static final void k(f5.c cVar, ChildColumnList childColumnList, int i10, boolean z10) {
        t9.i.g(cVar, "<this>");
        if (childColumnList == null) {
            return;
        }
        Intent intent = new Intent(cVar, (Class<?>) ColumnListAty.class);
        ColumnListAty.a aVar = ColumnListAty.f7853t;
        intent.putExtra(aVar.a(), childColumnList);
        intent.putExtra(aVar.d(), i10);
        intent.putExtra(aVar.c(), z10);
        cVar.startActivity(intent);
    }

    public static /* synthetic */ void k0(b6.f fVar, String str, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z12 = false;
        }
        i0(fVar, str, z10, z11, z12);
    }

    public static final void l(Context context) {
        t9.i.g(context, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/app-help?isFree=false&appId=");
        sb.append(na.a.g());
        sb.append("&userId=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&lang=");
        sb.append(f0.a());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&faqSelectedIndex=3&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        j0(context, sb.toString(), false, true, false, false, 24, null);
    }

    public static final void m(Context context) {
        t9.i.g(context, "<this>");
        MyBenefitsAty.a.b(MyBenefitsAty.f8389r, context, 0, false, 6, null);
    }

    public static final void n(Context context, String str) {
        t9.i.g(context, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/order-progress?appId=");
        sb.append(na.a.g());
        sb.append("&userId=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&appLanguage=");
        sb.append(f0.a());
        sb.append("&apkVersion=");
        sb.append(na.a.b());
        sb.append("&orderId=");
        sb.append(str);
        sb.append("&timeStamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        j0(context, sb.toString(), false, true, false, false, 24, null);
    }

    public static final void o(Context context, String str, String str2, String str3) {
        t9.i.g(context, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(x(m7.c.g()));
        sb.append("/#/feedback?editType=5&appId=");
        sb.append(na.a.g());
        sb.append("&userId=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&lang=");
        sb.append(f0.a());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&orderId=");
        sb.append(str);
        sb.append("&payType=");
        sb.append(str2 != null ? ba.s.j(str2, " ", "_", false, 4, null) : null);
        sb.append("&paymentPlatform=");
        sb.append(str3);
        sb.append("&portalCode=");
        sb.append(cVar.v());
        j0(context, sb.toString(), false, true, false, false, 24, null);
    }

    public static final void p(Context context, String str, String str2, String str3) {
        t9.i.g(context, "<this>");
        t9.i.g(str2, "extraJson");
        t9.i.g(str3, "paymentType");
        String str4 = x(m7.c.g()) + "/#/topayagain?orderId=" + str;
        U(context, "h5 extra json: " + str2);
        U(context, "h5 extra paymentType: " + str3);
        U(context, "pay page url: " + str4);
        Intent intent = new Intent(context, (Class<?>) WebViewAty.class);
        WebViewAty.a aVar = WebViewAty.B;
        intent.putExtra(aVar.j(), str4);
        intent.putExtra(aVar.a(), false);
        intent.putExtra(aVar.e(), true);
        intent.putExtra(aVar.c(), str2);
        intent.putExtra(aVar.g(), str3);
        context.startActivity(intent);
    }

    public static final void q(f5.c cVar, Album album, String str) {
        t9.i.g(cVar, "<this>");
        t9.i.g(album, PlistBuilder.KEY_ITEM);
        t9.i.g(str, "tdcFrom");
        Intent intent = new Intent(cVar, (Class<?>) PlayAty.class);
        g0.a aVar = i6.g0.f14313b0;
        intent.putExtra(aVar.j(), album.getType());
        intent.putExtra(aVar.a(), album.getContentId());
        intent.putExtra(aVar.f(), album.getProgramType());
        intent.putExtra(aVar.b(), EnterType.HISTORY);
        intent.putExtra(aVar.g(), str);
        String i10 = aVar.i();
        String alias = album.getAlias();
        String obj = alias != null ? ba.t.W(alias).toString() : null;
        String name = album.getName();
        intent.putExtra(i10, c(obj, name != null ? ba.t.W(name).toString() : null));
        intent.putExtra(aVar.h(), album.getPosterUrl());
        cVar.startActivity(intent);
    }

    public static final void r(f5.c cVar, String str, String str2, String str3, EnterType enterType, String str4, boolean z10, boolean z11, int i10, String str5, String str6) {
        t9.i.g(cVar, "<this>");
        t9.i.g(str5, "tdcFrom");
        t9.i.g(str6, "image");
        Intent intent = new Intent(cVar, (Class<?>) PlayAty.class);
        g0.a aVar = i6.g0.f14313b0;
        intent.putExtra(aVar.j(), str);
        intent.putExtra(aVar.a(), str3);
        intent.putExtra(aVar.f(), str2);
        intent.putExtra(aVar.b(), enterType);
        intent.putExtra(aVar.i(), str4);
        intent.putExtra(aVar.c(), z10);
        intent.putExtra(aVar.d(), z11);
        intent.putExtra(aVar.e(), i10);
        intent.putExtra(aVar.g(), str5);
        intent.putExtra(aVar.h(), str6);
        cVar.startActivity(intent);
    }

    public static final void s(f5.c cVar, ShelveAsset shelveAsset, String str, boolean z10) {
        t9.i.g(cVar, "<this>");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        t9.i.g(str, "tdcFrom");
        Intent intent = new Intent(cVar, (Class<?>) PlayAty.class);
        g0.a aVar = i6.g0.f14313b0;
        intent.putExtra(aVar.j(), shelveAsset.getType());
        intent.putExtra(aVar.a(), shelveAsset.getContentId());
        intent.putExtra(aVar.f(), shelveAsset.getProgramType());
        intent.putExtra(aVar.g(), str);
        String i10 = aVar.i();
        String alias = shelveAsset.getAlias();
        String obj = alias != null ? ba.t.W(alias).toString() : null;
        String name = shelveAsset.getName();
        intent.putExtra(i10, c(obj, name != null ? ba.t.W(name).toString() : null));
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(shelveAsset.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        intent.putExtra(aVar.h(), o10);
        intent.putExtra(aVar.c(), z10);
        cVar.startActivity(intent);
    }

    public static final void u(f5.c cVar, HomeRecommend homeRecommend) {
        t9.i.g(cVar, "<this>");
        t9.i.g(homeRecommend, "homeRecommend");
        Intent intent = new Intent(cVar, (Class<?>) SingleColumnAty.class);
        intent.putExtra(SingleColumnAty.f8160t.a(), homeRecommend);
        cVar.startActivity(intent);
    }

    public static final void v(Context context, String str) {
        String str2;
        t9.i.g(context, "<this>");
        if (str != null) {
            if (ba.t.o(str, "http://", false, 2, null) || ba.t.o(str, "https://", false, 2, null)) {
                str2 = str;
            } else {
                str2 = "http://" + str;
            }
            WebViewAty.a aVar = WebViewAty.B;
            if (aVar.k(context, str)) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) WebViewAty.class);
            intent.putExtra(aVar.j(), str2);
            intent.putExtra(aVar.a(), false);
            intent.putExtra(aVar.e(), true);
            intent.putExtra(aVar.d(), true);
            context.startActivity(intent);
        }
    }

    public static final f5.c w(b6.f fVar) {
        t9.i.g(fVar, "<this>");
        androidx.fragment.app.e activity = fVar.getActivity();
        t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        return (f5.c) activity;
    }

    public static final String x(String str) {
        return "http://" + str;
    }

    public static final int y(int i10) {
        return App.f8263e.a().getResources().getColor(i10);
    }

    public static final String z(int i10) {
        String string = App.f8263e.a().getString(i10);
        t9.i.f(string, "App.instance.getString(resId)");
        return string;
    }
}
