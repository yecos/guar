package h7;

import android.app.Notification;
import android.content.Context;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.raizlabs.android.dbflow.sql.language.Operator;
import q5.i;

/* loaded from: classes3.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14212a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.c f14213b;

    /* renamed from: c, reason: collision with root package name */
    public int f14214c = 0;

    /* renamed from: d, reason: collision with root package name */
    public Notification f14215d = null;

    public g(Context context, d5.c cVar) {
        this.f14212a = context;
        this.f14213b = cVar;
    }

    @Override // h7.c
    public void A(long j10, long j11) {
        b((int) ((j10 * 100) / j11));
    }

    public final void a() {
        Context context = this.f14212a;
        if (context == null) {
            return;
        }
        i iVar = i.f18197a;
        if (iVar.j(context)) {
            Notification a10 = new i.a().s(this.f14212a).q("progress").r(4).v(this.f14213b.d()).x(this.f14213b.e()).w(false).p(false).u(true).t(R$layout.layout_update_remote_view).a();
            this.f14215d = a10;
            a10.contentView.setImageViewResource(R$id.img_icon, this.f14213b.d());
            this.f14215d.contentView.setTextViewText(R$id.text_title, this.f14212a.getString(R$string.notify_begin_download));
            this.f14215d.flags |= 2;
            int g10 = iVar.g();
            this.f14214c = g10;
            iVar.k(this.f14212a, this.f14215d, g10);
        }
    }

    public final void b(int i10) {
        Notification notification = this.f14215d;
        if (notification == null || this.f14212a == null) {
            return;
        }
        notification.contentView.setTextViewText(R$id.text_title, this.f14212a.getString(R$string.notify_download_percent, Integer.valueOf(i10)) + Operator.Operation.MOD);
        this.f14215d.contentView.setProgressBar(R$id.progress_download, 100, i10, false);
        Notification notification2 = this.f14215d;
        notification2.flags = notification2.flags | 2;
        i.f18197a.k(this.f14212a, notification2, this.f14214c);
    }

    public final void c() {
        Context context;
        if (this.f14215d == null || (context = this.f14212a) == null) {
            return;
        }
        i.f18197a.c(context, this.f14214c);
    }

    public final void d() {
        Context context;
        if (this.f14215d == null || (context = this.f14212a) == null) {
            return;
        }
        i.f18197a.c(context, this.f14214c);
    }

    @Override // h7.c
    public void onFailure(Exception exc) {
        b5.a.g().n(this);
        c();
    }

    @Override // h7.c
    public void onSuccess() {
        b5.a.g().n(this);
        d();
    }

    @Override // h7.c
    public void z() {
        a();
    }
}
