package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import w6.i;

/* loaded from: classes3.dex */
public final class VersionForbiddenDialog extends CommonDialog {
    private c5.a mCheckUpdate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionForbiddenDialog(Context context) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void checkUpdate() {
        ((AutoFrameLayout) findViewById(R$id.mAflLoading)).setVisibility(0);
        if (this.mCheckUpdate == null) {
            this.mCheckUpdate = new c5.a(new ja.c(".update"), new la.a(".update"));
        }
        c5.a aVar = this.mCheckUpdate;
        if (aVar != null) {
            aVar.f();
        }
        c5.a aVar2 = this.mCheckUpdate;
        if (aVar2 != null) {
            Context context = getContext();
            i.c cVar = w6.i.f19214g;
            aVar2.g(context, cVar.E(), cVar.l(), new h7.a() { // from class: com.mobile.brasiltv.view.dialog.VersionForbiddenDialog$checkUpdate$1
                @Override // h7.a
                public void onCompleted() {
                }

                @Override // h7.a
                public void onError(Throwable th) {
                    ((AutoFrameLayout) VersionForbiddenDialog.this.findViewById(R$id.mAflLoading)).setVisibility(8);
                    Context context2 = VersionForbiddenDialog.this.getContext();
                    t9.i.f(context2, com.umeng.analytics.pro.f.X);
                    String string = VersionForbiddenDialog.this.getContext().getResources().getString(R.string.no_update);
                    t9.i.f(string, "context.resources.getString(R.string.no_update)");
                    new OkDialog(context2, string).setConfirmCallback(VersionForbiddenDialog$checkUpdate$1$onError$1.INSTANCE).show();
                }

                public void onReady() {
                }

                @Override // h7.a
                public void onOver(UpdateBean updateBean) {
                    t9.i.g(updateBean, "result");
                    ((AutoFrameLayout) VersionForbiddenDialog.this.findViewById(R$id.mAflLoading)).setVisibility(8);
                    VersionForbiddenDialog.this.handleForceUpgrade(updateBean);
                    DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_UPDATE);
                    com.mobile.brasiltv.utils.b0.j(VersionForbiddenDialog.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleForceUpgrade(UpdateBean updateBean) {
        d5.c cVar = new d5.c();
        cVar.q(updateBean.getForceUpdate() == 1);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.x(updateBean.getSpareUrl());
        cVar.p(s6.a.f18777a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        cVar.v(com.mobile.brasiltv.utils.x.f8754a.h());
        cVar.u(y5.a.f19767a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        new i7.b(getContext(), updateBean, cVar).j(new h7.e() { // from class: com.mobile.brasiltv.view.dialog.g1
            @Override // h7.e
            public final void a(DialogInterface dialogInterface, boolean z10) {
                VersionForbiddenDialog.handleForceUpgrade$lambda$5(dialogInterface, z10);
            }
        }).show();
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleForceUpgrade$lambda$5(DialogInterface dialogInterface, boolean z10) {
    }

    private final void handleUpgradeBussiness(UpdateBean updateBean) {
        d5.c cVar = new d5.c();
        cVar.q(updateBean.getForceUpdate() == 1);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.p(s6.a.f18777a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        cVar.v(com.mobile.brasiltv.utils.x.f8754a.h());
        cVar.u(y5.a.f19767a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        i7.a m10 = new i7.a(getContext(), updateBean, cVar, Boolean.FALSE).m(new h7.e() { // from class: com.mobile.brasiltv.view.dialog.h1
            @Override // h7.e
            public final void a(DialogInterface dialogInterface, boolean z10) {
                VersionForbiddenDialog.handleUpgradeBussiness$lambda$4(VersionForbiddenDialog.this, dialogInterface, z10);
            }
        });
        t9.i.f(m10, "CommonUpgradeDialog(cont…Dialog)\n                }");
        com.mobile.brasiltv.utils.b0.S(m10, DialogManager.DIALOG_UPDATE);
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUpgradeBussiness$lambda$4(VersionForbiddenDialog versionForbiddenDialog, DialogInterface dialogInterface, boolean z10) {
        t9.i.g(versionForbiddenDialog, "this$0");
        if (z10) {
            return;
        }
        if (MainAty.A.i()) {
            DialogManager dialogManager = DialogManager.INSTANCE;
            if (!dialogManager.hasDialogSaved(DialogManager.DIALOG_VERSION_FORBIDDEN)) {
                Context context = versionForbiddenDialog.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                dialogManager.showByManager(new VersionForbiddenDialog(context), DialogManager.DIALOG_VERSION_FORBIDDEN);
            }
        }
        DialogManager dialogManager2 = DialogManager.INSTANCE;
        t9.i.e(dialogInterface, "null cannot be cast to non-null type android.app.Dialog");
        dialogManager2.showNext((Dialog) dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(VersionForbiddenDialog versionForbiddenDialog, View view) {
        t9.i.g(versionForbiddenDialog, "this$0");
        versionForbiddenDialog.checkUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$3(VersionForbiddenDialog versionForbiddenDialog, View view) {
        t9.i.g(versionForbiddenDialog, "this$0");
        String e10 = s6.a.f18777a.a().e();
        Context context = versionForbiddenDialog.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        com.mobile.brasiltv.utils.b0.f0(context, "http://" + e10);
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -2;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_version_forbidden;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((AutoFrameLayout) findViewById(R$id.mAflLoading)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VersionForbiddenDialog.initListener$lambda$1(view);
            }
        });
        ((TextView) findViewById(R$id.mTvUpdate)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.j1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VersionForbiddenDialog.initListener$lambda$2(VersionForbiddenDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvUpgradeLink)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.k1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VersionForbiddenDialog.initListener$lambda$3(VersionForbiddenDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(R.id.tvEmail);
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) findViewById(R.id.autoEmails);
        com.mobile.brasiltv.utils.x xVar = com.mobile.brasiltv.utils.x.f8754a;
        if (xVar.h().length() == 0) {
            autoLinearLayout.setVisibility(4);
        } else {
            autoLinearLayout.setVisibility(0);
            textView.setText(xVar.h());
        }
        TextView textView2 = (TextView) findViewById(R.id.tvVersion);
        String f10 = na.f.f(na.a.f17333a, "key_user_id", "");
        if (f10.length() == 0) {
            f10 = w6.i.f19214g.l();
        }
        t9.i.f(f10, "userId");
        if (f10.length() == 0) {
            textView2.setText(getContext().getResources().getString(R.string.current_version) + na.a.c());
        } else {
            textView2.setText(getContext().getResources().getString(R.string.current_version) + na.a.c() + "  " + getContext().getResources().getString(R.string.uid) + f10);
        }
        String e10 = s6.a.f18777a.a().e();
        ((TextView) findViewById(R$id.mTvUpgradeLink)).setText(Html.fromHtml(getContext().getString(R.string.version_forbidden_upgrade_hint) + " <font color=\"#22A4E6\"><u>" + e10 + "</u></font>"));
    }
}
