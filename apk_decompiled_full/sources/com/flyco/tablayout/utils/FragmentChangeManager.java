package com.flyco.tablayout.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import androidx.fragment.app.y;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FragmentChangeManager {
    private int mContainerViewId;
    private int mCurrentTab;
    private o mFragmentManager;
    private ArrayList<Fragment> mFragments;

    public FragmentChangeManager(o oVar, int i10, ArrayList<Fragment> arrayList) {
        this.mFragmentManager = oVar;
        this.mContainerViewId = i10;
        this.mFragments = arrayList;
        initFragments();
    }

    private void initFragments() {
        Iterator<Fragment> it = this.mFragments.iterator();
        while (it.hasNext()) {
            Fragment next = it.next();
            this.mFragmentManager.m().b(this.mContainerViewId, next).o(next).h();
        }
        setFragments(0);
    }

    public Fragment getCurrentFragment() {
        return this.mFragments.get(this.mCurrentTab);
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public void setFragments(int i10) {
        for (int i11 = 0; i11 < this.mFragments.size(); i11++) {
            y m10 = this.mFragmentManager.m();
            Fragment fragment = this.mFragments.get(i11);
            if (i11 == i10) {
                m10.u(fragment);
            } else {
                m10.o(fragment);
            }
            m10.h();
        }
        this.mCurrentTab = i10;
    }
}
