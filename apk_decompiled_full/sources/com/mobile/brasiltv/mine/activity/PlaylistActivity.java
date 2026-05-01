package com.mobile.brasiltv.mine.activity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.PlaylistActivity;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import f5.c;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class PlaylistActivity extends c {

    /* renamed from: m, reason: collision with root package name */
    public static final a f8426m = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public Map f8428l = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final String f8427k = "PlaylistActivity";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final void T2(PlaylistActivity playlistActivity, String str, View view) {
        Display display;
        i.g(playlistActivity, "this$0");
        b0.i(playlistActivity, String.valueOf(str));
        display = playlistActivity.getDisplay();
        i.d(display);
        int height = display.getHeight();
        f1.a aVar = f1.f8649a;
        String string = playlistActivity.getString(R.string.copy_success);
        i.f(string, "getString(R.string.copy_success)");
        aVar.n(playlistActivity, string, 0, 48, 0, height / 3);
    }

    public View S2(int i10) {
        Map map = this.f8428l;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_playlist);
        final String stringExtra = getIntent().getStringExtra("url");
        ((TextView) S2(R$id.mTvPlaylistUrl)).setText(String.valueOf(stringExtra));
        ((TextView) S2(R$id.mButtonCopy)).setOnClickListener(new View.OnClickListener() { // from class: e6.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaylistActivity.T2(PlaylistActivity.this, stringExtra, view);
            }
        });
    }
}
