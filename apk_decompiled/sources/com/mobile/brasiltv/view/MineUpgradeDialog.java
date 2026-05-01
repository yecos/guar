package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.mobile.bean.UpdateBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MineUpgradeDialog extends Dialog {
    public KoocanButton dialog_cancel;
    public KoocanButton dialog_submit;
    private UpdateBean mUpdateBean;

    public MineUpgradeDialog(Context context, UpdateBean updateBean) {
        super(context, R.style.OptionDialog);
        setContentView(R.layout.dialog_mine_upgrade);
        this.mUpdateBean = updateBean;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            window.setAttributes(attributes);
        }
        this.dialog_cancel = (KoocanButton) findViewById(R.id.dialog_cancel);
        this.dialog_submit = (KoocanButton) findViewById(R.id.dialog_submit);
        setCanceledOnTouchOutside(false);
        this.dialog_cancel.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.MineUpgradeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MineUpgradeDialog.this.dismiss();
            }
        });
        this.dialog_submit.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.MineUpgradeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MineUpgradeDialog.this.dismiss();
                if (MineUpgradeDialog.this.mUpdateBean.getUrl() != null) {
                    k7.f.b("downloadUrl:" + MineUpgradeDialog.this.mUpdateBean.getUrl());
                    MineUpgradeDialog mineUpgradeDialog = MineUpgradeDialog.this;
                    mineUpgradeDialog.handleUpgradeBussiness(mineUpgradeDialog.mUpdateBean);
                }
            }
        });
    }

    private void gotoForceUpgrade(d5.c cVar) {
        new i7.b(getContext(), this.mUpdateBean, cVar).show();
    }

    private void gotoNormalUpgrade(d5.c cVar) {
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
            b5.a.g().j(new h7.f(getContext(), cVar.g()));
            b5.a.g().j(new h7.g(getContext(), cVar));
        }
        b5.a.g().m(getContext(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpgradeBussiness(UpdateBean updateBean) {
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
        if (cVar.m()) {
            gotoForceUpgrade(cVar);
        } else {
            gotoNormalUpgrade(cVar);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
    }
}
