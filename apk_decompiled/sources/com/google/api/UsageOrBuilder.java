package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface UsageOrBuilder extends MessageLiteOrBuilder {
    String getProducerNotificationChannel();

    ByteString getProducerNotificationChannelBytes();

    String getRequirements(int i10);

    ByteString getRequirementsBytes(int i10);

    int getRequirementsCount();

    List<String> getRequirementsList();

    UsageRule getRules(int i10);

    int getRulesCount();

    List<UsageRule> getRulesList();
}
