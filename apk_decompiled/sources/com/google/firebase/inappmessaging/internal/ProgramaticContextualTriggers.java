package com.google.firebase.inappmessaging.internal;

/* loaded from: classes2.dex */
public class ProgramaticContextualTriggers {
    private Listener listener;

    public interface Listener {
        void onEventTrigger(String str);
    }

    public void removeListener(Listener listener) {
        this.listener = null;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void triggerEvent(String str) {
        Logging.logd("Programmatically trigger: " + str);
        this.listener.onEventTrigger(str);
    }
}
