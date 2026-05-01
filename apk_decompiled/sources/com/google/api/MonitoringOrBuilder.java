package com.google.api;

import com.google.api.Monitoring;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface MonitoringOrBuilder extends MessageLiteOrBuilder {
    Monitoring.MonitoringDestination getConsumerDestinations(int i10);

    int getConsumerDestinationsCount();

    List<Monitoring.MonitoringDestination> getConsumerDestinationsList();

    Monitoring.MonitoringDestination getProducerDestinations(int i10);

    int getProducerDestinationsCount();

    List<Monitoring.MonitoringDestination> getProducerDestinationsList();
}
