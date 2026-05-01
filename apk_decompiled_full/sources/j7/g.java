package j7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;

/* loaded from: classes3.dex */
public abstract class g {
    public static void a(Context context, String str, int i10) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_upgrade_toast, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.tv_upgrade_toast)).setText(str);
        Toast toast = new Toast(context);
        toast.setView(inflate);
        toast.setDuration(i10);
        toast.setGravity(17, 0, 0);
        toast.show();
    }
}
