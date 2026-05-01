package i7;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.mobile.autoupdate.R$style;
import com.mobile.bean.UpdateBean;
import com.mobile.view.UpgradeProgressView;
import h7.e;
import h7.g;

/* loaded from: classes3.dex */
public class b extends Dialog implements h7.c {

    /* renamed from: a, reason: collision with root package name */
    public final UpdateBean f14337a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.c f14338b;

    /* renamed from: c, reason: collision with root package name */
    public UpgradeProgressView f14339c;

    /* renamed from: d, reason: collision with root package name */
    public e f14340d;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.f14340d != null) {
                b.this.f14340d.a(dialogInterface, false);
            }
        }
    }

    /* renamed from: i7.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0232b implements View.OnClickListener {
        public ViewOnClickListenerC0232b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.h();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j7.a.c(b.this.getContext(), b.this.f14338b.g());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public b(Context context, UpdateBean updateBean, d5.c cVar) {
        super(context, R$style.UpgradeDialog);
        this.f14337a = updateBean;
        this.f14338b = cVar;
    }

    @Override // h7.c
    public void A(long j10, long j11) {
        this.f14339c.setProgress((int) ((j10 * 100) / j11));
    }

    public final String d() {
        String str;
        try {
            str = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            str = "";
        }
        return getContext().getString(R$string.upgrade_progress_current_version, str);
    }

    public final String e() {
        String f10 = this.f14338b.f();
        return TextUtils.isEmpty(f10) ? this.f14338b.c() : f10;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f14337a.getNote())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : this.f14337a.getNote().split("\\n")) {
            sb.append("<b>·</b> ");
            sb.append(str);
            sb.append("<br>");
        }
        return sb.toString();
    }

    public final String g() {
        return "(" + getContext().getString(R$string.upgrade_progress_version, this.f14337a.getVersionName()) + ")";
    }

    public final void h() {
        String e10 = e();
        if (!e10.startsWith("http://") && !e10.startsWith("https://")) {
            e10 = "http://" + e10;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(e10));
        getContext().startActivity(intent);
    }

    public final void i() {
        b5.a.g().j(new g(getContext(), this.f14338b));
        b5.a.g().j(this);
        b5.a.g().m(getContext(), this.f14338b);
    }

    public b j(e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f14340d = eVar;
        setOnDismissListener(new a());
        return this;
    }

    public final void k() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(R$id.mTvUpdating);
        TextView textView2 = (TextView) findViewById(R$id.mTvDontCloseApp);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        ((TextView) findViewById(R$id.mTvDownloadFail)).setVisibility(0);
        ((TextView) findViewById(R$id.mTvDownloadLinkDesc)).setText(Html.fromHtml(getContext().getString(R$string.upgrade_progress_download_link, String.format("<u><font color=\"#22a4e6\">%s</font></u>", e()))));
        TextView textView3 = (TextView) findViewById(R$id.mTvDownloadHint);
        textView3.setVisibility(0);
        textView3.setText(R$string.upgrade_progress_cant_download);
        TextView textView4 = (TextView) findViewById(R$id.mTvContract);
        textView4.setVisibility(0);
        if (!this.f14338b.h().isEmpty()) {
            textView4.setText(getContext().getString(R$string.upgrade_progress_contract_email, this.f14338b.h()));
        }
        Button button = (Button) findViewById(R$id.mBtnClose);
        button.setText(R$string.upgrade_progress_close);
        button.setVisibility(0);
        button.setOnClickListener(new d());
    }

    public final void l() {
        Button button = (Button) findViewById(R$id.mBtnClose);
        button.setText(R$string.upgrade_progress_install);
        button.setVisibility(0);
        button.setOnClickListener(new c());
    }

    public final void m() {
        TextView textView = (TextView) findViewById(R$id.mTvDownloadLinkDesc);
        textView.setOnClickListener(new ViewOnClickListenerC0232b());
        textView.setText(Html.fromHtml(getContext().getString(R$string.upgrade_progress_click_download_url, String.format("<u><font color=\"#22a4e6\">%s</font></u>", e()))));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dialog_upgrade_progress);
        getWindow().setLayout(-1, -1);
        getWindow().addFlags(2);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.9f;
        getWindow().setAttributes(attributes);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(R$id.mTvVersion);
        TextView textView2 = (TextView) findViewById(R$id.mTvReleaseNote);
        TextView textView3 = (TextView) findViewById(R$id.mTvCurrentVersion);
        this.f14339c = (UpgradeProgressView) findViewById(R$id.mUpvProgress);
        textView.setText(g());
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView2.setText(Html.fromHtml(f()));
        textView3.setText(d());
        m();
        i();
    }

    @Override // h7.c
    public void onFailure(Exception exc) {
        this.f14339c.setInvalid(true);
        b5.a.g().n(this);
        k();
    }

    @Override // h7.c
    public void onSuccess() {
        this.f14339c.setProgress(100);
        b5.a.g().n(this);
        l();
        j7.a.c(getContext(), this.f14338b.g());
    }

    @Override // h7.c
    public void z() {
    }
}
