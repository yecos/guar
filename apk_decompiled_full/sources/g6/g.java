package g6;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.dialog.BaseDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

/* loaded from: classes3.dex */
public final class g extends BaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        i.g(context, com.umeng.analytics.pro.f.X);
    }

    public static final void c(g gVar, View view) {
        i.g(gVar, "this$0");
        gVar.cancel();
    }

    public static final void d(g gVar, View view) {
        i.g(gVar, "this$0");
        Context context = gVar.getContext();
        i.f(context, com.umeng.analytics.pro.f.X);
        new d(context).show();
        gVar.cancel();
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_restrict);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            attributes.height = AutoUtils.getPercentWidthSize(450);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        ((TextView) findViewById(R$id.mTextNo)).setOnClickListener(new View.OnClickListener() { // from class: g6.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.c(g.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTextYes)).setOnClickListener(new View.OnClickListener() { // from class: g6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.d(g.this, view);
            }
        });
    }
}
