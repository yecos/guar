package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface EndpointOrBuilder extends MessageLiteOrBuilder {
    @Deprecated
    String getAliases(int i10);

    @Deprecated
    ByteString getAliasesBytes(int i10);

    @Deprecated
    int getAliasesCount();

    @Deprecated
    List<String> getAliasesList();

    boolean getAllowCors();

    String getFeatures(int i10);

    ByteString getFeaturesBytes(int i10);

    int getFeaturesCount();

    List<String> getFeaturesList();

    String getName();

    ByteString getNameBytes();

    String getTarget();

    ByteString getTargetBytes();
}
