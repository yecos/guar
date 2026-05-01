package l0;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.n;
import android.widget.RemoteViews;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;
import o.r;
import o.s;

/* loaded from: classes.dex */
public class c extends s.f {

    /* renamed from: e, reason: collision with root package name */
    public int[] f15888e = null;

    /* renamed from: f, reason: collision with root package name */
    public MediaSessionCompat.Token f15889f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15890g;

    /* renamed from: h, reason: collision with root package name */
    public PendingIntent f15891h;

    @Override // o.s.f
    public void b(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            rVar.a().setStyle(m(new Notification.MediaStyle()));
        } else if (this.f15890g) {
            rVar.a().setOngoing(true);
        }
    }

    @Override // o.s.f
    public RemoteViews i(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return n();
    }

    @Override // o.s.f
    public RemoteViews j(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return o();
    }

    public Notification.MediaStyle m(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f15888e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f15889f;
        if (token != null) {
            mediaStyle.setMediaSession(n.a(token.c()));
        }
        return mediaStyle;
    }

    public RemoteViews n() {
        int min = Math.min(this.f17439a.f17414b.size(), 5);
        RemoteViews c10 = c(false, q(min), false);
        c10.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i10 = 0; i10 < min; i10++) {
                c10.addView(R$id.media_actions, p((s.a) this.f17439a.f17414b.get(i10)));
            }
        }
        if (this.f15890g) {
            int i11 = R$id.cancel_action;
            c10.setViewVisibility(i11, 0);
            c10.setInt(i11, "setAlpha", this.f17439a.f17413a.getResources().getInteger(R$integer.cancel_button_image_alpha));
            c10.setOnClickPendingIntent(i11, this.f15891h);
        } else {
            c10.setViewVisibility(R$id.cancel_action, 8);
        }
        return c10;
    }

    public RemoteViews o() {
        RemoteViews c10 = c(false, r(), true);
        int size = this.f17439a.f17414b.size();
        int[] iArr = this.f15888e;
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        c10.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i10 = 0; i10 < min; i10++) {
                if (i10 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i10), Integer.valueOf(size - 1)));
                }
                c10.addView(R$id.media_actions, p((s.a) this.f17439a.f17414b.get(this.f15888e[i10])));
            }
        }
        if (this.f15890g) {
            c10.setViewVisibility(R$id.end_padder, 8);
            int i11 = R$id.cancel_action;
            c10.setViewVisibility(i11, 0);
            c10.setOnClickPendingIntent(i11, this.f15891h);
            c10.setInt(i11, "setAlpha", this.f17439a.f17413a.getResources().getInteger(R$integer.cancel_button_image_alpha));
        } else {
            c10.setViewVisibility(R$id.end_padder, 0);
            c10.setViewVisibility(R$id.cancel_action, 8);
        }
        return c10;
    }

    public final RemoteViews p(s.a aVar) {
        boolean z10 = aVar.a() == null;
        RemoteViews remoteViews = new RemoteViews(this.f17439a.f17413a.getPackageName(), R$layout.notification_media_action);
        int i10 = R$id.action0;
        remoteViews.setImageViewResource(i10, aVar.e());
        if (!z10) {
            remoteViews.setOnClickPendingIntent(i10, aVar.a());
        }
        remoteViews.setContentDescription(i10, aVar.j());
        return remoteViews;
    }

    public int q(int i10) {
        return i10 <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
    }

    public int r() {
        return R$layout.notification_template_media;
    }

    public c s(MediaSessionCompat.Token token) {
        this.f15889f = token;
        return this;
    }

    public c t(int... iArr) {
        this.f15888e = iArr;
        return this;
    }
}
