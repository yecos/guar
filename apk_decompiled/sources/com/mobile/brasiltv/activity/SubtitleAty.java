package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SubtitleAty;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.view.dialog.SubtitleOptionsDialog;
import com.mobile.brasiltv.view.dialog.SubtitleStyleOptionsDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class SubtitleAty extends f5.c {

    /* renamed from: p, reason: collision with root package name */
    public Map f8208p = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final g f8203k = h.b(new a());

    /* renamed from: l, reason: collision with root package name */
    public final g f8204l = h.b(new c());

    /* renamed from: m, reason: collision with root package name */
    public final g f8205m = h.b(new d());

    /* renamed from: n, reason: collision with root package name */
    public final g f8206n = h.b(new b());

    /* renamed from: o, reason: collision with root package name */
    public final g f8207o = h.b(new e());

    public static final class a extends j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return new String[]{SubtitleAty.this.getResources().getString(R.string.subtitle_language_pt), SubtitleAty.this.getResources().getString(R.string.subtitle_language_en), SubtitleAty.this.getResources().getString(R.string.subtitle_language_es)};
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return new String[]{SubtitleAty.this.getResources().getString(R.string.subtitle_color_white), SubtitleAty.this.getResources().getString(R.string.subtitle_color_yellow)};
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return new String[]{SubtitleAty.this.getResources().getString(R.string.subtitle_language_pt), SubtitleAty.this.getResources().getString(R.string.subtitle_language_en), SubtitleAty.this.getResources().getString(R.string.subtitle_language_es)};
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return new String[]{SubtitleAty.this.getResources().getString(R.string.subtitle_size_normal), SubtitleAty.this.getResources().getString(R.string.subtitle_size_small), SubtitleAty.this.getResources().getString(R.string.subtitle_size_big)};
        }
    }

    public static final class e extends j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getStyleList(SubtitleAty.this);
        }
    }

    public static final void g3(final SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.audio_language);
        i.f(string, "resources.getString(R.string.audio_language)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.b3(), SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0, 16, null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: f5.x5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SubtitleAty.h3(SubtitleAty.this, dialogInterface);
            }
        });
    }

    public static final void h3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void i3(final SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_language);
        i.f(string, "resources.getString(R.string.subtitle_language)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.c3(), SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0, 16, null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: f5.v5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SubtitleAty.j3(SubtitleAty.this, dialogInterface);
            }
        });
    }

    public static final void j3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        subtitleManager.clearLruCacheSwitch();
        subtitleManager.clearSelectSubtitle();
        subtitleAty.q3();
    }

    public static final void k3(final SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_size);
        i.f(string, "resources.getString(R.string.subtitle_size)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.d3(), SubtitleManager.GLOBAL_SUBTITLE_SIZE, 0, 16, null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: f5.u5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SubtitleAty.l3(SubtitleAty.this, dialogInterface);
            }
        });
    }

    public static final void l3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void m3(final SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_Style);
        i.f(string, "resources.getString(R.string.subtitle_Style)");
        SubtitleStyleOptionsDialog subtitleStyleOptionsDialog = new SubtitleStyleOptionsDialog(subtitleAty, string, subtitleAty.e3(), SubtitleManager.GLOBAL_SUBTITLE_COLOR, 0, 16, null);
        subtitleStyleOptionsDialog.show();
        subtitleStyleOptionsDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: f5.w5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SubtitleAty.n3(SubtitleAty.this, dialogInterface);
            }
        });
    }

    public static final void n3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void o3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        subtitleManager.setMGlobalSwitch(!subtitleManager.getMGlobalSwitch());
        ((ImageView) subtitleAty.a3(R$id.mIvSwitch)).setSelected(subtitleManager.getMGlobalSwitch());
        subtitleManager.clearSelectSubtitle();
        subtitleManager.clearLruCacheSwitch();
        subtitleAty.p3(subtitleManager.getMGlobalSwitch());
    }

    public View a3(int i10) {
        Map map = this.f8208p;
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

    public final String[] b3() {
        return (String[]) this.f8203k.getValue();
    }

    public final String[] c3() {
        return (String[]) this.f8204l.getValue();
    }

    public final String[] d3() {
        return (String[]) this.f8205m.getValue();
    }

    public final ArrayList e3() {
        return (ArrayList) this.f8207o.getValue();
    }

    public final void f3() {
        q3();
        ((AutoFrameLayout) a3(R$id.mFlAudioLanguage)).setOnClickListener(new View.OnClickListener() { // from class: f5.p5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleAty.g3(SubtitleAty.this, view);
            }
        });
        ((AutoFrameLayout) a3(R$id.mFlLanguage)).setOnClickListener(new View.OnClickListener() { // from class: f5.q5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleAty.i3(SubtitleAty.this, view);
            }
        });
        ((AutoFrameLayout) a3(R$id.mFlSize)).setOnClickListener(new View.OnClickListener() { // from class: f5.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleAty.k3(SubtitleAty.this, view);
            }
        });
        ((AutoFrameLayout) a3(R$id.mFlColor)).setOnClickListener(new View.OnClickListener() { // from class: f5.s5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleAty.m3(SubtitleAty.this, view);
            }
        });
        ((ImageView) a3(R$id.mIvSwitch)).setOnClickListener(new View.OnClickListener() { // from class: f5.t5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubtitleAty.o3(SubtitleAty.this, view);
            }
        });
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_subtitle);
        f3();
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        super.onStop();
        n0 n0Var = n0.f8733a;
        String[] strArr = {SubtitleManager.GLOBAL_AUDIO_LANGUAGE, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, SubtitleManager.GLOBAL_SUBTITLE_SIZE, SubtitleManager.GLOBAL_SUBTITLE_COLOR, SubtitleManager.GLOBAL_SUBTITLE_SWITCH};
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        n0Var.l(this, strArr, new Object[]{Integer.valueOf(subtitleManager.getMGlobalAudioLanguage()), Integer.valueOf(subtitleManager.getMGlobalLanguage()), Integer.valueOf(subtitleManager.getMGlobalSize()), Integer.valueOf(subtitleManager.getMGlobalColor()), Boolean.valueOf(subtitleManager.getMGlobalSwitch())});
    }

    public final void p3(boolean z10) {
        ((AutoFrameLayout) a3(R$id.mFlLanguage)).setEnabled(z10);
        ((AutoFrameLayout) a3(R$id.mFlColor)).setEnabled(z10);
        ((AutoFrameLayout) a3(R$id.mFlSize)).setEnabled(z10);
    }

    public final void q3() {
        TextView textView = (TextView) a3(R$id.mTvSelectedAudioLanguage);
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        int mGlobalAudioLanguage = subtitleManager.getMGlobalAudioLanguage();
        textView.setText(mGlobalAudioLanguage != 0 ? mGlobalAudioLanguage != 1 ? mGlobalAudioLanguage != 2 ? getResources().getString(R.string.subtitle_language_pt) : getResources().getString(R.string.subtitle_language_es) : getResources().getString(R.string.subtitle_language_en) : getResources().getString(R.string.subtitle_language_pt));
        TextView textView2 = (TextView) a3(R$id.mTvSelectedLanguage);
        int mGlobalLanguage = subtitleManager.getMGlobalLanguage();
        textView2.setText(mGlobalLanguage != 0 ? mGlobalLanguage != 1 ? mGlobalLanguage != 2 ? getResources().getString(R.string.subtitle_language_es) : getResources().getString(R.string.subtitle_language_es) : getResources().getString(R.string.subtitle_language_en) : getResources().getString(R.string.subtitle_language_pt));
        TextView textView3 = (TextView) a3(R$id.mTvSelectedSize);
        int mGlobalSize = subtitleManager.getMGlobalSize();
        textView3.setText(mGlobalSize != 0 ? mGlobalSize != 1 ? mGlobalSize != 2 ? getResources().getString(R.string.subtitle_size_normal) : getResources().getString(R.string.subtitle_size_big) : getResources().getString(R.string.subtitle_size_small) : getResources().getString(R.string.subtitle_size_normal));
        TextView textView4 = (TextView) a3(R$id.mTvSelectedColor);
        int mGlobalColor = subtitleManager.getMGlobalColor();
        textView4.setTextColor(mGlobalColor != 0 ? mGlobalColor != 1 ? mGlobalColor != 2 ? getResources().getColor(R.color.color_important_white) : getResources().getColor(R.color.color_important_white) : getResources().getColor(R.color.color_ffaa00) : getResources().getColor(R.color.color_important_white));
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) a3(R$id.mLlBg);
        int mGlobalColor2 = subtitleManager.getMGlobalColor();
        autoLinearLayout.setBackgroundColor(mGlobalColor2 != 0 ? mGlobalColor2 != 1 ? mGlobalColor2 != 2 ? getResources().getColor(R.color.transparent) : getResources().getColor(R.color.color_191919) : getResources().getColor(R.color.transparent) : getResources().getColor(R.color.transparent));
        ((ImageView) a3(R$id.mIvSwitch)).setSelected(subtitleManager.getMGlobalSwitch());
        p3(subtitleManager.getMGlobalSwitch());
    }
}
