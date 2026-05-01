package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface QuotaOrBuilder extends MessageLiteOrBuilder {
    QuotaLimit getLimits(int i10);

    int getLimitsCount();

    List<QuotaLimit> getLimitsList();

    MetricRule getMetricRules(int i10);

    int getMetricRulesCount();

    List<MetricRule> getMetricRulesList();
}
