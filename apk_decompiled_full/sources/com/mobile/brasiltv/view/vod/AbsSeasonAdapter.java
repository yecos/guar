package com.mobile.brasiltv.view.vod;

import android.widget.TextView;
import java.util.List;
import mobile.com.requestframe.utils.response.ProgramSeason;

/* loaded from: classes3.dex */
public abstract class AbsSeasonAdapter {
    private int mSelectedIndex = -1;

    public abstract ProgramSeason getItem(int i10);

    public abstract int getItemCount();

    public abstract List<ProgramSeason> getItemData();

    public final int getSelectedIndex() {
        return this.mSelectedIndex;
    }

    public abstract void onClickItem(int i10, ProgramSeason programSeason);

    public final void setSelectedIndex(int i10) {
        this.mSelectedIndex = i10;
    }

    public abstract void update(TextView textView, ProgramSeason programSeason);
}
