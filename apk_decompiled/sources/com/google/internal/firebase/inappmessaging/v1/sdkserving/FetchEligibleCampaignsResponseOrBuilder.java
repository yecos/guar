package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface FetchEligibleCampaignsResponseOrBuilder extends MessageLiteOrBuilder {
    long getExpirationEpochTimestampMillis();

    CampaignProto.ThickContent getMessages(int i10);

    int getMessagesCount();

    List<CampaignProto.ThickContent> getMessagesList();
}
