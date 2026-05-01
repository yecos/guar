package com.mobile.brasiltv.bean;

import android.graphics.drawable.Drawable;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.utils.b0;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class MainTabEntity implements CustomTabEntity {
    private final String enTitle;
    private boolean isNet;
    private Drawable selectedDrawable;
    private final int selectedIcon;
    private final String selectedIconUrl;
    private int seriesNumber;
    private final String title;
    private Drawable unSelectDrawable;
    private final int unSelectedIcon;
    private final String unSelectedIconUrl;
    private final String zhTitle;

    public MainTabEntity() {
        this(null, 0, 0, null, null, null, null, false, 0, 511, null);
    }

    public final Drawable getSelectedDrawable() {
        return this.selectedDrawable;
    }

    public final String getSelectedIconUrl() {
        return this.selectedIconUrl;
    }

    public final int getSeriesNumber() {
        return this.seriesNumber;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    public int getTabSelectedIcon() {
        return this.selectedIcon;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    public String getTabTitle() {
        return this.title.length() == 0 ? b0.c(this.enTitle, this.zhTitle) : this.title;
    }

    @Override // com.flyco.tablayout.listener.CustomTabEntity
    public int getTabUnselectedIcon() {
        return this.unSelectedIcon;
    }

    public final Drawable getUnSelectDrawable() {
        return this.unSelectDrawable;
    }

    public final String getUnSelectedIconUrl() {
        return this.unSelectedIconUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isUseNetIcon() {
        boolean z10;
        boolean z11;
        String str = this.selectedIconUrl;
        if (str != null) {
            if (str.length() > 0) {
                z10 = true;
                if (z10) {
                    String str2 = this.unSelectedIconUrl;
                    if (str2 != null) {
                        if (str2.length() > 0) {
                            z11 = true;
                            if (!z11 && this.isNet) {
                                return true;
                            }
                        }
                    }
                    z11 = false;
                    if (!z11) {
                    }
                }
                return false;
            }
        }
        z10 = false;
        if (z10) {
        }
        return false;
    }

    public final void setSelectedDrawable(Drawable drawable) {
        this.selectedDrawable = drawable;
    }

    public final void setSeriesNumber(int i10) {
        this.seriesNumber = i10;
    }

    public final void setUnSelectDrawable(Drawable drawable) {
        this.unSelectDrawable = drawable;
    }

    public String toString() {
        return "MainTabEntity(title='" + this.title + "', selectedIcon=" + this.selectedIcon + ", unSelectedIcon=" + this.unSelectedIcon + ", selectedIconUrl=" + this.selectedIconUrl + ", unSelectedIconUrl=" + this.unSelectedIconUrl + ", zhTitle=" + this.zhTitle + ", enTitle=" + this.enTitle + ", isNet=" + this.isNet + ", seriesNumber=" + this.seriesNumber + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public MainTabEntity(String str, int i10, int i11, String str2, String str3, String str4, String str5, boolean z10, int i12) {
        i.g(str, "title");
        this.title = str;
        this.selectedIcon = i10;
        this.unSelectedIcon = i11;
        this.selectedIconUrl = str2;
        this.unSelectedIconUrl = str3;
        this.zhTitle = str4;
        this.enTitle = str5;
        this.isNet = z10;
        this.seriesNumber = i12;
    }

    public /* synthetic */ MainTabEntity(String str, int i10, int i11, String str2, String str3, String str4, String str5, boolean z10, int i12, int i13, g gVar) {
        this((i13 & 1) != 0 ? "" : str, (i13 & 2) != 0 ? -1 : i10, (i13 & 4) == 0 ? i11 : -1, (i13 & 8) != 0 ? "" : str2, (i13 & 16) != 0 ? "" : str3, (i13 & 32) != 0 ? "" : str4, (i13 & 64) == 0 ? str5 : "", (i13 & 128) != 0 ? false : z10, (i13 & 256) == 0 ? i12 : 0);
    }
}
