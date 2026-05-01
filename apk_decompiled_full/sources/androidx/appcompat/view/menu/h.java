package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;
import com.hpplay.sdk.source.common.global.Constant;

/* loaded from: classes.dex */
public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: a, reason: collision with root package name */
    public g f1193a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.c f1194b;

    /* renamed from: c, reason: collision with root package name */
    public e f1195c;

    /* renamed from: d, reason: collision with root package name */
    public m.a f1196d;

    public h(g gVar) {
        this.f1193a = gVar;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(g gVar) {
        m.a aVar = this.f1196d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    public void b() {
        androidx.appcompat.app.c cVar = this.f1194b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void c(IBinder iBinder) {
        g gVar = this.f1193a;
        c.a aVar = new c.a(gVar.getContext());
        e eVar = new e(aVar.getContext(), R$layout.abc_list_menu_item_layout);
        this.f1195c = eVar;
        eVar.setCallback(this);
        this.f1193a.addMenuPresenter(this.f1195c);
        aVar.setAdapter(this.f1195c.a(), this);
        View headerView = gVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(gVar.getHeaderIcon()).setTitle(gVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        androidx.appcompat.app.c create = aVar.create();
        this.f1194b = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1194b.getWindow().getAttributes();
        attributes.type = Constant.STOP_FROM_SINK;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1194b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f1193a.performItemAction((i) this.f1195c.a().getItem(i10), 0);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void onCloseMenu(g gVar, boolean z10) {
        if (z10 || gVar == this.f1193a) {
            b();
        }
        m.a aVar = this.f1196d;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1195c.onCloseMenu(this.f1193a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1194b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1194b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1193a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1193a.performShortcut(i10, keyEvent, 0);
    }
}
