package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface HttpOrBuilder extends MessageLiteOrBuilder {
    boolean getFullyDecodeReservedExpansion();

    HttpRule getRules(int i10);

    int getRulesCount();

    List<HttpRule> getRulesList();
}
