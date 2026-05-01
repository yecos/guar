package com.mobile.brasiltv.view.vod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.y1;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.j1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ProgramSeason;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class SeasonSpinner extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private AbsSeasonAdapter mSeasonAdapter;
    private y1 mSeasonPopupWindow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context) {
        this(context, null, 0, 6, null);
        i.g(context, f.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SeasonSpinner seasonSpinner, View view) {
        i.g(seasonSpinner, "this$0");
        if (seasonSpinner.isShowingSeasonPopup()) {
            seasonSpinner.hideSeasonPopup();
        } else {
            seasonSpinner.showSeasonPopup();
        }
    }

    private final ArrayAdapter<ProgramSeason> createSeasonAdapter() {
        final List<ProgramSeason> arrayList;
        AbsSeasonAdapter absSeasonAdapter = this.mSeasonAdapter;
        if (absSeasonAdapter == null || (arrayList = absSeasonAdapter.getItemData()) == null) {
            arrayList = new ArrayList<>();
        }
        final Context context = getContext();
        return new ArrayAdapter<ProgramSeason>(arrayList, context) { // from class: com.mobile.brasiltv.view.vod.SeasonSpinner$createSeasonAdapter$1
            private LayoutInflater inflater = LayoutInflater.from(getContext());

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                AbsSeasonAdapter absSeasonAdapter2;
                AbsSeasonAdapter absSeasonAdapter3;
                i.g(viewGroup, "parent");
                if (view == null) {
                    LayoutInflater layoutInflater = this.inflater;
                    view = layoutInflater != null ? layoutInflater.inflate(R.layout.item_pop_season, viewGroup, false) : null;
                }
                i.d(view);
                View findViewById = view.findViewById(R.id.tv_season);
                i.f(findViewById, "view!!.findViewById(R.id.tv_season)");
                TextView textView = (TextView) findViewById;
                absSeasonAdapter2 = this.mSeasonAdapter;
                if (absSeasonAdapter2 != null) {
                    absSeasonAdapter2.update(textView, (ProgramSeason) getItem(i10));
                }
                View findViewById2 = view.findViewById(R.id.iv_selector);
                i.f(findViewById2, "view.findViewById(R.id.iv_selector)");
                ImageView imageView = (ImageView) findViewById2;
                absSeasonAdapter3 = this.mSeasonAdapter;
                if (absSeasonAdapter3 != null && i10 == absSeasonAdapter3.getSelectedIndex()) {
                    imageView.setImageResource(R.drawable.ic_season_checked);
                } else {
                    imageView.setImageResource(0);
                }
                return view;
            }
        };
    }

    private final void hideSeasonPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvArrow)).setSelected(false);
        y1 y1Var = this.mSeasonPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
        this.mSeasonPopupWindow = null;
    }

    private final boolean isShowingSeasonPopup() {
        y1 y1Var = this.mSeasonPopupWindow;
        if (y1Var != null) {
            return y1Var != null && y1Var.isShowing();
        }
        return false;
    }

    private final void showSeasonPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvArrow)).setSelected(true);
        y1 y1Var = new y1(getContext());
        this.mSeasonPopupWindow = y1Var;
        y1Var.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.bg_pop_season));
        y1 y1Var2 = this.mSeasonPopupWindow;
        if (y1Var2 != null) {
            y1Var2.k(createSeasonAdapter());
        }
        y1 y1Var3 = this.mSeasonPopupWindow;
        if (y1Var3 != null) {
            y1Var3.w(this);
        }
        y1 y1Var4 = this.mSeasonPopupWindow;
        if (y1Var4 != null) {
            y1Var4.C(true);
        }
        y1 y1Var5 = this.mSeasonPopupWindow;
        if (y1Var5 != null) {
            y1Var5.D(new PopupWindow.OnDismissListener() { // from class: com.mobile.brasiltv.view.vod.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    SeasonSpinner.showSeasonPopup$lambda$1(SeasonSpinner.this);
                }
            });
        }
        y1 y1Var6 = this.mSeasonPopupWindow;
        if (y1Var6 != null) {
            y1Var6.g(-j1.a(getContext(), 2));
        }
        y1 y1Var7 = this.mSeasonPopupWindow;
        if (y1Var7 != null) {
            y1Var7.E(new AdapterView.OnItemClickListener() { // from class: com.mobile.brasiltv.view.vod.b
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    SeasonSpinner.showSeasonPopup$lambda$2(SeasonSpinner.this, adapterView, view, i10, j10);
                }
            });
        }
        y1 y1Var8 = this.mSeasonPopupWindow;
        if (y1Var8 != null) {
            y1Var8.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSeasonPopup$lambda$1(SeasonSpinner seasonSpinner) {
        i.g(seasonSpinner, "this$0");
        seasonSpinner.mSeasonPopupWindow = null;
        ((ImageView) seasonSpinner._$_findCachedViewById(R$id.mIvArrow)).setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSeasonPopup$lambda$2(SeasonSpinner seasonSpinner, AdapterView adapterView, View view, int i10, long j10) {
        i.g(seasonSpinner, "this$0");
        AbsSeasonAdapter absSeasonAdapter = seasonSpinner.mSeasonAdapter;
        if (absSeasonAdapter != null) {
            absSeasonAdapter.onClickItem(i10, absSeasonAdapter != null ? absSeasonAdapter.getItem(i10) : null);
        }
        y1 y1Var = seasonSpinner.mSeasonPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
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

    public final void setSeasonAdapter(AbsSeasonAdapter absSeasonAdapter) {
        i.g(absSeasonAdapter, "adapter");
        this.mSeasonAdapter = absSeasonAdapter;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        y1 y1Var;
        super.setVisibility(i10);
        if (i10 == 0 || (y1Var = this.mSeasonPopupWindow) == null) {
            return;
        }
        y1Var.dismiss();
    }

    public final void updateSelectedIndex(int i10) {
        AbsSeasonAdapter absSeasonAdapter = this.mSeasonAdapter;
        if (absSeasonAdapter != null) {
            absSeasonAdapter.setSelectedIndex(i10);
        }
        AbsSeasonAdapter absSeasonAdapter2 = this.mSeasonAdapter;
        if (absSeasonAdapter2 != null) {
            TextView textView = (TextView) _$_findCachedViewById(R$id.mTvSeason);
            i.f(textView, "mTvSeason");
            AbsSeasonAdapter absSeasonAdapter3 = this.mSeasonAdapter;
            absSeasonAdapter2.update(textView, absSeasonAdapter3 != null ? absSeasonAdapter3.getItem(i10) : null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.g(context, f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_spinner_season, (ViewGroup) this, true);
        setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.vod.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SeasonSpinner._init_$lambda$0(SeasonSpinner.this, view);
            }
        });
    }

    public /* synthetic */ SeasonSpinner(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
