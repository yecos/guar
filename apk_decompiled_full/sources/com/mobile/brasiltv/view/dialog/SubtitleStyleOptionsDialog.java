package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import g5.n3;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class SubtitleStyleOptionsDialog extends CommonDialog {
    private n3 mAdapter;
    private String optionType;
    private ArrayList<SubtitleStyleBean> options;
    private String title;

    public /* synthetic */ SubtitleStyleOptionsDialog(Context context, String str, ArrayList arrayList, String str2, int i10, int i11, t9.g gVar) {
        this(context, str, arrayList, str2, (i11 & 16) != 0 ? R.style.SubtitleOptionDialog : i10);
    }

    private final int getIndex() {
        if (t9.i.b(this.optionType, SubtitleManager.GLOBAL_SUBTITLE_COLOR)) {
            return SubtitleManager.INSTANCE.getMGlobalColor();
        }
        return 0;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 320;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_subtitle_style;
    }

    public final String getOptionType() {
        return this.optionType;
    }

    public final ArrayList<SubtitleStyleBean> getOptions() {
        return this.options;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        setCancelable(true);
        ((TextView) findViewById(R$id.mTvTitle)).setText(this.title);
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        n3 n3Var = new n3(context, this.options, new SubtitleStyleOptionsDialog$initView$1(this));
        this.mAdapter = n3Var;
        n3Var.e(getIndex());
        int i10 = R$id.mRvOptions;
        ((RecyclerView) findViewById(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) findViewById(i10)).setAdapter(this.mAdapter);
        n3 n3Var2 = this.mAdapter;
        if (n3Var2 != null) {
            n3Var2.notifyDataSetChanged();
        }
    }

    public final void setOptionType(String str) {
        t9.i.g(str, "<set-?>");
        this.optionType = str;
    }

    public final void setOptions(ArrayList<SubtitleStyleBean> arrayList) {
        t9.i.g(arrayList, "<set-?>");
        this.options = arrayList;
    }

    public final void setTitle(String str) {
        t9.i.g(str, "<set-?>");
        this.title = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleStyleOptionsDialog(Context context, String str, ArrayList<SubtitleStyleBean> arrayList, String str2, int i10) {
        super(context, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "title");
        t9.i.g(arrayList, "options");
        t9.i.g(str2, "optionType");
        this.title = str;
        this.options = arrayList;
        this.optionType = str2;
    }
}
