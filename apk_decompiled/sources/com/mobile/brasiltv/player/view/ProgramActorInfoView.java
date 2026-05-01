package com.mobile.brasiltv.player.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import ba.s;
import ba.t;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.event.GoToSharingEvent;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.player.view.ProgramActorInfoView;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import mobile.com.requestframe.utils.response.AssetData;
import t9.i;
import xa.c;

/* loaded from: classes3.dex */
public final class ProgramActorInfoView extends AutoRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Map f8560a = new LinkedHashMap();

    public static final class a extends ForegroundColorSpan {

        /* renamed from: a, reason: collision with root package name */
        public final float f8561a;

        public a(int i10, float f10) {
            super(i10);
            this.f8561a = f10;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            i.g(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setTextSize(this.f8561a);
        }
    }

    public static final class b extends ReplacementSpan {

        /* renamed from: a, reason: collision with root package name */
        public final int f8562a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8563b;

        public b(int i10, int i11) {
            this.f8562a = i10;
            this.f8563b = i11;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
            i.g(canvas, "canvas");
            i.g(paint, "paint");
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
            i.g(paint, "paint");
            return this.f8562a + this.f8563b;
        }
    }

    public ProgramActorInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.layout_actor_info_view, (ViewGroup) this, true);
    }

    public static final void e(AssetData assetData, ProgramActorInfoView programActorInfoView, View view) {
        i.g(assetData, "$data");
        i.g(programActorInfoView, "this$0");
        if (b0.H(assetData.getAwardsUrl())) {
            Context context = programActorInfoView.getContext();
            i.f(context, f.X);
            String awardsUrl = assetData.getAwardsUrl();
            i.d(awardsUrl);
            b0.h0(context, awardsUrl, false, false, false, true);
        }
    }

    public static final void f(ProgramActorInfoView programActorInfoView, AssetData assetData, View view) {
        i.g(programActorInfoView, "this$0");
        i.g(assetData, "$data");
        b0.U(programActorInfoView, "mFavLayout: " + w6.i.f19214g.I());
        PlayAty.a aVar = PlayAty.G;
        if (aVar.b().contains(assetData.getContentId())) {
            return;
        }
        aVar.b().add(assetData.getContentId());
        c.c().j(new VodFavEvent(assetData));
    }

    private final void setAwards(final AssetData assetData) {
        String awardsUrl = assetData.getAwardsUrl();
        if (awardsUrl == null || awardsUrl.length() == 0) {
            ((TextView) _$_findCachedViewById(R$id.mTvAwards)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvAwards;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: r6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramActorInfoView.e(AssetData.this, this, view);
            }
        });
    }

    private final void setFavAndSub(final AssetData assetData) {
        k(assetData);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mFavLayout)).setOnClickListener(new View.OnClickListener() { // from class: r6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramActorInfoView.f(ProgramActorInfoView.this, assetData, view);
            }
        });
        l(assetData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShare$lambda$2(View view) {
        c.c().j(new GoToSharingEvent());
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f8560a;
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

    public final void d(AssetData assetData) {
        String str;
        String str2;
        String z10;
        i.g(assetData, "program");
        setFavAndSub(assetData);
        setAwards(assetData);
        i();
        String contentTag = assetData.getContentTag();
        if (contentTag == null || contentTag.length() == 0) {
            ((TextView) _$_findCachedViewById(R$id.mTvGrade)).setVisibility(8);
        } else {
            int i10 = R$id.mTvGrade;
            ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
            ((TextView) _$_findCachedViewById(i10)).setText(assetData.getContentTag());
        }
        String j10 = s.j(b0.e(assetData.getAlias(), assetData.getName()), "\n", "", false, 4, null);
        if (i.b(IdManager.DEFAULT_VERSION_NAME, String.valueOf(assetData.getScore()))) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            sb.append(assetData.getScore());
            str = sb.toString();
        }
        if (!i.b(assetData.getProgramType(), "movie") || assetData.getVolumnCount() <= 0) {
            str2 = "";
        } else {
            str2 = Operator.Operation.DIVISION + String.valueOf(assetData.getVolumnCount()) + " " + getContext().getResources().getString(R.string.epsode_all);
        }
        i.f(str2, "if (program.programType …\n            \"\"\n        }");
        SpannableString spannableString = new SpannableString(j10 + str + str2);
        if (!i.b(str, "")) {
            spannableString.setSpan(new b(25, 0), j10.length(), j10.length() + 1, 17);
            spannableString.setSpan(new a(b0.y(R.color.color_ff8900), s0.d(getContext(), 15.0f)), j10.length() + 1, (j10 + str).length(), 17);
        }
        if (!i.b(str2, "")) {
            spannableString.setSpan(new a(b0.y(R.color.color_cccccc), s0.d(getContext(), 15.0f)), (j10 + str).length(), (j10 + str + str2).length(), 17);
        }
        ((TextView) _$_findCachedViewById(R$id.mTextName)).setText(spannableString);
        ((TextView) _$_findCachedViewById(R$id.mTextCountry)).setText(b0.H(assetData.getOriginalCountry()) ? assetData.getOriginalCountry() : b0.z(R.string.unkownInfo));
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTextReleaseTime);
        if (!b0.H(assetData.getReleaseTime())) {
            z10 = b0.z(R.string.unkownInfo);
        } else if (assetData.getReleaseTime().length() >= 4) {
            z10 = assetData.getReleaseTime().substring(0, 4);
            i.f(z10, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            z10 = assetData.getReleaseTime();
        }
        textView.setText(z10);
        int i11 = R$id.mTextDirector;
        ((TextView) _$_findCachedViewById(i11)).setText(b0.z(R.string.dector) + ' ');
        if (b0.H(assetData.getDirector())) {
            ((TextView) _$_findCachedViewById(i11)).append(t.W(s.j(assetData.getDirector(), ",", Operator.Operation.DIVISION, false, 4, null)).toString());
        } else {
            ((TextView) _$_findCachedViewById(i11)).append(b0.z(R.string.unkownInfo));
        }
        int i12 = R$id.mTextActors;
        ((TextView) _$_findCachedViewById(i12)).setText(b0.z(R.string.actor) + ' ');
        if (TextUtils.isEmpty(assetData.getActorDisplay())) {
            ((TextView) _$_findCachedViewById(i12)).append(b0.z(R.string.unkownInfo));
        } else {
            ((TextView) _$_findCachedViewById(i12)).append(t.W(s.j(assetData.getActorDisplay(), ",", Operator.Operation.DIVISION, false, 4, null)).toString());
        }
        int i13 = R$id.mTextType;
        ((TextView) _$_findCachedViewById(i13)).setText("");
        if (TextUtils.isEmpty(assetData.getTags())) {
            ((TextView) _$_findCachedViewById(i13)).append(b0.z(R.string.unkownInfo));
        } else {
            ((TextView) _$_findCachedViewById(i13)).append(t.W(s.j(assetData.getTags(), ",", Operator.Operation.DIVISION, false, 4, null)).toString());
        }
        j();
    }

    public final void g(VodDao vodDao, AssetData assetData, String str, boolean z10) {
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        ((ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView)).r(vodDao, assetData, str, z10, true);
    }

    public final void h(VodDao vodDao, AssetData assetData, String str, boolean z10) {
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        ProgramSetInfoView programSetInfoView = (ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView);
        i.f(programSetInfoView, "mProgramSetInfoView");
        programSetInfoView.r(vodDao, assetData, str, z10, (r12 & 16) != 0 ? false : false);
    }

    public final void i() {
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) _$_findCachedViewById(R$id.mShareLayout);
        i.f(autoLinearLayout, "mShareLayout");
        b0.P(autoLinearLayout, new View.OnClickListener() { // from class: r6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProgramActorInfoView.setShare$lambda$2(view);
            }
        });
    }

    public final void j() {
        ViewParent parent = getParent();
        i.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setVisibility(0);
    }

    public final void k(AssetData assetData) {
        i.g(assetData, "data");
        if (TextUtils.isEmpty(assetData.getHasFavorite())) {
            assetData.setHasFavorite("0");
        }
        if (i.b(assetData.getHasFavorite(), "1")) {
            ((ImageView) _$_findCachedViewById(R$id.mImageFav)).setImageResource(R.drawable.ic_vod_fav);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageFav)).setImageResource(R.drawable.ic_vod_unfav);
        }
    }

    public final void l(AssetData assetData) {
        i.g(assetData, "data");
        if (TextUtils.isEmpty(assetData.getHasSubscribe())) {
            assetData.setHasSubscribe("0");
        }
    }

    public final void m(AssetData assetData) {
        i.g(assetData, "program");
        ((ProgramDetailView) _$_findCachedViewById(R$id.mProgramDetail)).a(assetData);
    }

    public final void setIsResumed(boolean z10) {
        ((ProgramSetInfoView) _$_findCachedViewById(R$id.mProgramSetInfoView)).setIsResumed(z10);
    }
}
