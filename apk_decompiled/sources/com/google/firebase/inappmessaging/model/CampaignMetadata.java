package com.google.firebase.inappmessaging.model;

/* loaded from: classes2.dex */
public class CampaignMetadata {
    private final String campaignId;
    private final String campaignName;
    private final boolean isTestMessage;

    public CampaignMetadata(String str, String str2, boolean z10) {
        this.campaignId = str;
        this.campaignName = str2;
        this.isTestMessage = z10;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getCampaignName() {
        return this.campaignName;
    }

    public boolean getIsTestMessage() {
        return this.isTestMessage;
    }
}
