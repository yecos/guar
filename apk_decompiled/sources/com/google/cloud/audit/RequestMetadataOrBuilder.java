package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes2.dex */
public interface RequestMetadataOrBuilder extends MessageLiteOrBuilder {
    String getCallerIp();

    ByteString getCallerIpBytes();

    String getCallerSuppliedUserAgent();

    ByteString getCallerSuppliedUserAgentBytes();
}
