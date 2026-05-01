package com.mobile.brasiltv.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.MoreTextView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import mobile.com.requestframe.utils.response.AssetData;
import t9.i;

/* loaded from: classes3.dex */
public final class ProgramDetailView extends AutoRelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Map f8564a = new LinkedHashMap();

    public ProgramDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.layout_detail_info_view, (ViewGroup) this, true);
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f8564a;
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

    public final void a(AssetData assetData) {
        i.g(assetData, "program");
        int i10 = R$id.mTextDetail;
        ((MoreTextView) _$_findCachedViewById(i10)).setMaxLine(3);
        if (b0.H(assetData.getDescription())) {
            ((MoreTextView) _$_findCachedViewById(i10)).setMoreText(assetData.getDescription());
        } else {
            ((MoreTextView) _$_findCachedViewById(i10)).setMoreText(b0.z(R.string.unkownInfo));
        }
    }
}
