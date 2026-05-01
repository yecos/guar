package com.google.firebase.inappmessaging.model;

/* loaded from: classes2.dex */
public class TriggeredInAppMessage {
    private InAppMessage inAppMessage;
    private String triggeringEvent;

    public TriggeredInAppMessage(InAppMessage inAppMessage, String str) {
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    public InAppMessage getInAppMessage() {
        return this.inAppMessage;
    }

    public String getTriggeringEvent() {
        return this.triggeringEvent;
    }
}
