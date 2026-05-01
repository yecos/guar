package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.upnp.control.ActionListener;
import com.hpplay.cybergarage.upnp.control.ControlResponse;

/* loaded from: classes2.dex */
public class ActionData extends NodeData {
    private ActionListener actionListener = null;
    private ControlResponse ctrlRes = null;

    public ActionListener getActionListener() {
        return this.actionListener;
    }

    public ControlResponse getControlResponse() {
        return this.ctrlRes;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setControlResponse(ControlResponse controlResponse) {
        this.ctrlRes = controlResponse;
    }
}
