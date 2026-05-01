package i7;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.mobile.autoupdate.R$style;
import com.mobile.bean.UpdateBean;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import h7.g;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final UpdateBean f14326a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.c f14327b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14328c;

    /* renamed from: d, reason: collision with root package name */
    public h7.e f14329d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f14330e;

    /* renamed from: i7.a$a, reason: collision with other inner class name */
    public class RunnableC0231a implements Runnable {
        public RunnableC0231a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = a.this.f14330e.getLayoutParams();
            if (a.this.f14330e.getLineCount() > 3) {
                layoutParams.height = AutoUtils.getPercentWidthSize(340);
            } else {
                layoutParams.height = AutoUtils.getPercentWidthSize(150);
            }
            a.this.f14330e.setLayoutParams(layoutParams);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.k();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.d(a.this);
            throw null;
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f14329d != null) {
                a.this.f14329d.a(dialogInterface, a.this.f14328c);
            }
        }
    }

    public a(Context context, UpdateBean updateBean, d5.c cVar, Boolean bool) {
        super(context, R$style.UpgradeDialog);
        this.f14328c = false;
        this.f14326a = updateBean;
        this.f14327b = cVar;
        setContentView(R$layout.dialog_common_upgrade);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(600);
            window.setAttributes(attributes);
        }
        ImageView imageView = (ImageView) findViewById(R$id.ivClose);
        this.f14330e = (TextView) findViewById(R$id.tvContent);
        TextView textView = (TextView) findViewById(R$id.tvEmail);
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) findViewById(R$id.autoEmails);
        if (cVar.b().isEmpty()) {
            autoLinearLayout.setVisibility(4);
        } else {
            autoLinearLayout.setVisibility(0);
            textView.setText(cVar.b());
        }
        TextView textView2 = (TextView) findViewById(R$id.mCopyTips);
        Button button = (Button) findViewById(R$id.mBtnCopy);
        if (bool.booleanValue()) {
            textView2.setVisibility(0);
            button.setVisibility(0);
        } else {
            textView2.setVisibility(8);
            button.setVisibility(8);
        }
        ((TextView) findViewById(R$id.tvUpgradeVersion)).setText("V" + updateBean.getVersionName());
        TextView textView3 = (TextView) findViewById(R$id.tvVersion);
        if (cVar.l().isEmpty()) {
            textView3.setText(getContext().getResources().getString(R$string.current_version) + cVar.a());
        } else {
            textView3.setText(getContext().getResources().getString(R$string.current_version) + cVar.a() + "  " + getContext().getResources().getString(R$string.uid) + cVar.l());
        }
        Button button2 = (Button) findViewById(R$id.kbUpgrade);
        TextView textView4 = (TextView) findViewById(R$id.tvOfficialDownloadUrl);
        this.f14330e.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f14330e.setText(updateBean.getNote());
        this.f14330e.post(new RunnableC0231a());
        textView4.setText(Html.fromHtml(h()));
        if (cVar.m()) {
            imageView.setVisibility(8);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
        imageView.setOnClickListener(new b());
        button2.setOnClickListener(new c());
        textView4.setOnClickListener(new d());
        button.setOnClickListener(new e());
    }

    public static /* synthetic */ h7.d d(a aVar) {
        aVar.getClass();
        return null;
    }

    public final String g() {
        String f10 = this.f14327b.f();
        return TextUtils.isEmpty(f10) ? this.f14327b.c() : f10;
    }

    public final String h() {
        return getContext().getString(R$string.common_click_official_website, String.format("<u><font color=\"#22a4e6\">%s</font></u>", g().replace("http://", "").replace("https://", "")));
    }

    public final void i() {
        this.f14328c = true;
        new i7.b(getContext(), this.f14326a, this.f14327b).j(this.f14329d).show();
    }

    public final void j() {
        boolean z10;
        Iterator it = b5.a.g().h().iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            } else if (((h7.c) it.next()) instanceof h7.f) {
                z10 = true;
                break;
            }
        }
        if (!z10) {
            b5.a.g().j(new h7.f(getContext(), this.f14327b.g()));
            b5.a.g().j(new g(getContext(), this.f14327b));
        }
        b5.a.g().m(getContext(), this.f14327b);
    }

    public final void k() {
        try {
            String g10 = g();
            if (!g10.startsWith("http://") && !g10.startsWith("https://")) {
                g10 = "http://" + g10;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(g10));
            getContext().startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void l() {
        if (this.f14327b.m()) {
            i();
        } else {
            j();
        }
        dismiss();
    }

    public a m(h7.e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f14329d = eVar;
        setOnDismissListener(new f());
        return this;
    }
}
