package com.google.firebase.dynamiclinks.ktx;

import android.net.Uri;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.ktx.Firebase;
import com.taobao.accs.common.Constants;
import java.util.List;
import s9.l;
import t9.i;

/* loaded from: classes2.dex */
public final class FirebaseDynamicLinksKt {
    public static final String LIBRARY_NAME = "fire-dl-ktx";

    public static final void androidParameters(DynamicLink.Builder builder, l lVar) {
        i.g(builder, "<this>");
        i.g(lVar, "init");
        DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder();
        lVar.invoke(builder2);
        builder.setAndroidParameters(builder2.build());
    }

    public static final Uri component1(ShortDynamicLink shortDynamicLink) {
        i.g(shortDynamicLink, "<this>");
        return shortDynamicLink.getShortLink();
    }

    public static final Uri component2(ShortDynamicLink shortDynamicLink) {
        i.g(shortDynamicLink, "<this>");
        return shortDynamicLink.getPreviewLink();
    }

    public static final List<ShortDynamicLink.Warning> component3(ShortDynamicLink shortDynamicLink) {
        i.g(shortDynamicLink, "<this>");
        List warnings = shortDynamicLink.getWarnings();
        i.f(warnings, "warnings");
        return warnings;
    }

    public static final DynamicLink dynamicLink(FirebaseDynamicLinks firebaseDynamicLinks, l lVar) {
        i.g(firebaseDynamicLinks, "<this>");
        i.g(lVar, "init");
        DynamicLink.Builder createDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        i.f(createDynamicLink, "getInstance().createDynamicLink()");
        lVar.invoke(createDynamicLink);
        DynamicLink buildDynamicLink = createDynamicLink.buildDynamicLink();
        i.f(buildDynamicLink, "builder.buildDynamicLink()");
        return buildDynamicLink;
    }

    public static final FirebaseDynamicLinks dynamicLinks(Firebase firebase, FirebaseApp firebaseApp) {
        i.g(firebase, "<this>");
        i.g(firebaseApp, "app");
        FirebaseDynamicLinks firebaseDynamicLinks = FirebaseDynamicLinks.getInstance(firebaseApp);
        i.f(firebaseDynamicLinks, "getInstance(app)");
        return firebaseDynamicLinks;
    }

    public static final FirebaseDynamicLinks getDynamicLinks(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseDynamicLinks firebaseDynamicLinks = FirebaseDynamicLinks.getInstance();
        i.f(firebaseDynamicLinks, "getInstance()");
        return firebaseDynamicLinks;
    }

    public static final void googleAnalyticsParameters(DynamicLink.Builder builder, l lVar) {
        i.g(builder, "<this>");
        i.g(lVar, "init");
        DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder();
        lVar.invoke(builder2);
        builder.setGoogleAnalyticsParameters(builder2.build());
    }

    public static final void iosParameters(DynamicLink.Builder builder, String str, l lVar) {
        i.g(builder, "<this>");
        i.g(str, "bundleId");
        i.g(lVar, "init");
        DynamicLink.IosParameters.Builder builder2 = new DynamicLink.IosParameters.Builder(str);
        lVar.invoke(builder2);
        builder.setIosParameters(builder2.build());
    }

    public static final void itunesConnectAnalyticsParameters(DynamicLink.Builder builder, l lVar) {
        i.g(builder, "<this>");
        i.g(lVar, "init");
        DynamicLink.ItunesConnectAnalyticsParameters.Builder builder2 = new DynamicLink.ItunesConnectAnalyticsParameters.Builder();
        lVar.invoke(builder2);
        builder.setItunesConnectAnalyticsParameters(builder2.build());
    }

    public static final void navigationInfoParameters(DynamicLink.Builder builder, l lVar) {
        i.g(builder, "<this>");
        i.g(lVar, "init");
        DynamicLink.NavigationInfoParameters.Builder builder2 = new DynamicLink.NavigationInfoParameters.Builder();
        lVar.invoke(builder2);
        builder.setNavigationInfoParameters(builder2.build());
    }

    public static final Task<ShortDynamicLink> shortLinkAsync(FirebaseDynamicLinks firebaseDynamicLinks, l lVar) {
        i.g(firebaseDynamicLinks, "<this>");
        i.g(lVar, "init");
        DynamicLink.Builder createDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        i.f(createDynamicLink, "getInstance().createDynamicLink()");
        lVar.invoke(createDynamicLink);
        Task<ShortDynamicLink> buildShortDynamicLink = createDynamicLink.buildShortDynamicLink();
        i.f(buildShortDynamicLink, "builder.buildShortDynamicLink()");
        return buildShortDynamicLink;
    }

    public static final void socialMetaTagParameters(DynamicLink.Builder builder, l lVar) {
        i.g(builder, "<this>");
        i.g(lVar, "init");
        DynamicLink.SocialMetaTagParameters.Builder builder2 = new DynamicLink.SocialMetaTagParameters.Builder();
        lVar.invoke(builder2);
        builder.setSocialMetaTagParameters(builder2.build());
    }

    public static final Uri component1(PendingDynamicLinkData pendingDynamicLinkData) {
        i.g(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getLink();
    }

    public static final int component2(PendingDynamicLinkData pendingDynamicLinkData) {
        i.g(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getMinimumAppVersion();
    }

    public static final long component3(PendingDynamicLinkData pendingDynamicLinkData) {
        i.g(pendingDynamicLinkData, "<this>");
        return pendingDynamicLinkData.getClickTimestamp();
    }

    public static final void androidParameters(DynamicLink.Builder builder, String str, l lVar) {
        i.g(builder, "<this>");
        i.g(str, Constants.KEY_PACKAGE_NAME);
        i.g(lVar, "init");
        DynamicLink.AndroidParameters.Builder builder2 = new DynamicLink.AndroidParameters.Builder(str);
        lVar.invoke(builder2);
        builder.setAndroidParameters(builder2.build());
    }

    public static final void googleAnalyticsParameters(DynamicLink.Builder builder, String str, String str2, String str3, l lVar) {
        i.g(builder, "<this>");
        i.g(str, "source");
        i.g(str2, "medium");
        i.g(str3, "campaign");
        i.g(lVar, "init");
        DynamicLink.GoogleAnalyticsParameters.Builder builder2 = new DynamicLink.GoogleAnalyticsParameters.Builder(str, str2, str3);
        lVar.invoke(builder2);
        builder.setGoogleAnalyticsParameters(builder2.build());
    }

    public static final Task<ShortDynamicLink> shortLinkAsync(FirebaseDynamicLinks firebaseDynamicLinks, int i10, l lVar) {
        i.g(firebaseDynamicLinks, "<this>");
        i.g(lVar, "init");
        DynamicLink.Builder createDynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink();
        i.f(createDynamicLink, "getInstance().createDynamicLink()");
        lVar.invoke(createDynamicLink);
        Task<ShortDynamicLink> buildShortDynamicLink = createDynamicLink.buildShortDynamicLink(i10);
        i.f(buildShortDynamicLink, "builder.buildShortDynamicLink(suffix)");
        return buildShortDynamicLink;
    }
}
