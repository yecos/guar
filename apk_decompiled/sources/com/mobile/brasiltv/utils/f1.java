package com.mobile.brasiltv.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8649a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static Toast f8650b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public static /* synthetic */ void f(a aVar, Context context, String str, boolean z10, int i10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                i10 = 0;
            }
            aVar.e(context, str, z10, i10);
        }

        public static /* synthetic */ void j(a aVar, Context context, int i10, int i11, int i12, Object obj) {
            if ((i12 & 4) != 0) {
                i11 = 0;
            }
            aVar.h(context, i10, i11);
        }

        public static /* synthetic */ void p(a aVar, Context context, String str, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 1;
            }
            aVar.o(context, str, i10);
        }

        public static final void r(Handler handler) {
            t9.i.g(handler, "$handler");
            a aVar = f1.f8649a;
            r2.a.a(aVar.c());
            Toast c10 = aVar.c();
            if (c10 != null) {
                c10.setDuration(1);
            }
            Toast c11 = aVar.c();
            if (c11 != null) {
                c11.show();
            }
            handler.postDelayed(new Runnable() { // from class: com.mobile.brasiltv.utils.e1
                @Override // java.lang.Runnable
                public final void run() {
                    f1.a.s();
                }
            }, 5000L);
        }

        public static final void s() {
            Toast c10 = f1.f8649a.c();
            if (c10 != null) {
                c10.cancel();
            }
        }

        public final Toast c() {
            return f1.f8650b;
        }

        public final boolean d(Context context) {
            return context != null && (context instanceof Activity) && ((Activity) context).isFinishing();
        }

        public final void e(Context context, String str, boolean z10, int i10) {
            t9.i.g(str, Constant.KEY_MSG);
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_center_force, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.mTvToast);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.mImgIcon);
            if (z10) {
                imageView.setImageResource(R.mipmap.icon_force_faild);
            } else {
                imageView.setImageResource(R.mipmap.icon_force_succese);
            }
            textView.setText(str);
            toast.setView(inflate);
            r2.a.a(toast);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i10);
            toast.show();
        }

        public final void g(Toast toast) {
            f1.f8650b = toast;
        }

        public final void h(Context context, int i10, int i11) {
            String str;
            Resources resources;
            if (context == null || (resources = context.getResources()) == null || (str = resources.getString(i10)) == null) {
                str = "";
            }
            i(context, str, i11);
        }

        public final void i(Context context, String str, int i10) {
            t9.i.g(str, Constant.KEY_MSG);
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_center, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
            toast.setView(inflate);
            r2.a.a(toast);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i10);
            toast.show();
        }

        public final void k(Context context, String str, int i10) {
            t9.i.g(str, Constant.KEY_MSG);
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_center_large, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.mTvToast)).setText(str);
            toast.setView(inflate);
            r2.a.a(toast);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i10);
            toast.show();
        }

        public final void l(Context context, int i10, int i11) {
            String str;
            Resources resources;
            if (context == null || (resources = context.getResources()) == null || (str = resources.getString(i10)) == null) {
                str = "";
            }
            m(context, str, i11);
        }

        public final void m(Context context, String str, int i10) {
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast c10 = c();
            if (c10 != null) {
                c10.cancel();
            }
            g(new Toast(context));
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_white_center, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
            Toast c11 = c();
            if (c11 != null) {
                c11.setView(inflate);
            }
            r2.a.a(c());
            Toast c12 = c();
            if (c12 != null) {
                c12.setDuration(i10);
            }
            Toast c13 = c();
            if (c13 != null) {
                c13.show();
            }
        }

        public final void n(Context context, String str, int i10, int i11, int i12, int i13) {
            t9.i.g(str, Constant.KEY_MSG);
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast c10 = c();
            if (c10 != null) {
                c10.cancel();
            }
            g(new Toast(context));
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_white_center, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
            Toast c11 = c();
            if (c11 != null) {
                c11.setView(inflate);
            }
            Toast c12 = c();
            if (c12 != null) {
                c12.setGravity(i11, i12, i13);
            }
            r2.a.a(c());
            Toast c13 = c();
            if (c13 != null) {
                c13.setDuration(i10);
            }
            Toast c14 = c();
            if (c14 != null) {
                c14.show();
            }
        }

        public final void o(Context context, String str, int i10) {
            t9.i.g(str, Constant.KEY_MSG);
            if ((str.length() == 0) || d(context)) {
                return;
            }
            Toast toast = new Toast(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.toast_center, (ViewGroup) null);
            AutoUtils.autoSize(inflate);
            ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
            toast.setView(inflate);
            r2.a.a(toast);
            toast.setGravity(17, 0, 0);
            toast.setDuration(i10);
            toast.show();
        }

        public final void q(Context context, String str) {
            t9.i.g(str, Constant.KEY_MSG);
            if (context != null) {
                if ((str.length() == 0) || d(context)) {
                    return;
                }
                Toast c10 = c();
                if (c10 != null) {
                    c10.cancel();
                }
                g(new Toast(context));
                View inflate = LayoutInflater.from(context).inflate(R.layout.toast_koocan_white_center, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.mTvToast)).setText(str);
                Toast c11 = c();
                if (c11 != null) {
                    c11.setView(inflate);
                }
                final Handler handler = new Handler();
                handler.post(new Runnable() { // from class: com.mobile.brasiltv.utils.d1
                    @Override // java.lang.Runnable
                    public final void run() {
                        f1.a.r(handler);
                    }
                });
            }
        }

        public final void t(int i10) {
            l(com.mobile.brasiltv.utils.a.a(), i10, 1);
        }

        public final void u(String str) {
            t9.i.g(str, "str");
            m(com.mobile.brasiltv.utils.a.a(), str, 1);
        }

        public final void v() {
            g(null);
        }

        public final void w(int i10) {
            l(com.mobile.brasiltv.utils.a.a(), i10, 0);
        }

        public final void x(String str) {
            t9.i.g(str, "str");
            m(com.mobile.brasiltv.utils.a.a(), str, 0);
        }
    }
}
