package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

/* loaded from: classes2.dex */
public class NavigationMenu extends g {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.view.menu.g, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        i iVar = (i) addInternal(i10, i11, i12, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, iVar);
        iVar.x(navigationSubMenu);
        return navigationSubMenu;
    }
}
