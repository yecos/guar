package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();
}
