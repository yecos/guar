package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.upnp.event.SubscriberList;
import com.hpplay.cybergarage.util.ListenerList;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class ServiceData extends NodeData {
    private ListenerList controlActionListenerList = new ListenerList();
    private Node scpdNode = null;
    private SubscriberList subscriberList = new SubscriberList();
    private String descriptionURL = "";
    private String sid = "";
    private long timeout = 0;

    public ListenerList getControlActionListenerList() {
        return this.controlActionListenerList;
    }

    public String getDescriptionURL() {
        return this.descriptionURL;
    }

    public Node getSCPDNode() {
        return this.scpdNode;
    }

    public String getSID() {
        return this.sid;
    }

    public SubscriberList getSubscriberList() {
        return this.subscriberList;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setDescriptionURL(String str) {
        this.descriptionURL = str;
    }

    public void setSCPDNode(Node node) {
        this.scpdNode = node;
    }

    public void setSID(String str) {
        this.sid = str;
    }

    public void setTimeout(long j10) {
        this.timeout = j10;
    }
}
