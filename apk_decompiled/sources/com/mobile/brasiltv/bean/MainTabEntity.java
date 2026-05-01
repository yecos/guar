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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isUseNetIcon() {
        /*
            r3 = this;
            java.lang.String r0 = r3.selectedIconUrl
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            int r0 = r0.length()
            if (r0 <= 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 != r1) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L2f
            java.lang.String r0 = r3.unSelectedIconUrl
            if (r0 == 0) goto L27
            int r0 = r0.length()
            if (r0 <= 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 != r1) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L2f
            boolean r0 = r3.isNet
            if (r0 == 0) goto L2f
            goto L30
        L2f:
            r1 = 0
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.MainTabEntity.isUseNetIcon():boolean");
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
