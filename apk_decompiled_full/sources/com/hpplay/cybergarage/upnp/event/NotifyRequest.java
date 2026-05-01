package com.hpplay.cybergarage.upnp.event;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.soap.SOAPRequest;
import com.hpplay.cybergarage.upnp.device.NT;
import com.hpplay.cybergarage.upnp.device.NTS;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class NotifyRequest extends SOAPRequest {
    private static final String PROPERTY = "property";
    private static final String PROPERTYSET = "propertyset";
    private static final String TAG = "NotifyRequest";
    private static final String XMLNS = "e";

    public NotifyRequest() {
    }

    private Node createPropertySetNode(String str, String str2) {
        Node node = new Node(PROPERTYSET);
        node.setNameSpace(XMLNS, Subscription.XMLNS);
        Node node2 = new Node(PROPERTY);
        node.addNode(node2);
        Node node3 = new Node(str);
        node3.setValue(str2);
        node2.addNode(node3);
        return node;
    }

    private Property getProperty(Node node) {
        Property property = new Property();
        if (node == null) {
            return property;
        }
        String name = node.getName();
        int lastIndexOf = name.lastIndexOf(58);
        if (lastIndexOf != -1) {
            name = name.substring(lastIndexOf + 1);
        }
        property.setName(name);
        property.setValue(node.getValue());
        return property;
    }

    private Node getVariableNode() {
        Node envelopeNode = getEnvelopeNode();
        if (envelopeNode == null || !envelopeNode.hasNodes()) {
            return null;
        }
        Node node = envelopeNode.getNode(0);
        if (node.hasNodes()) {
            return node.getNode(0);
        }
        return null;
    }

    public PropertyList getPropertyList() {
        PropertyList propertyList = new PropertyList();
        Node envelopeNode = getEnvelopeNode();
        CLog.d(TAG, "start get getPropertyList ");
        if (envelopeNode == null) {
            CLog.d(TAG, "varSetNode is null");
            return null;
        }
        for (int i10 = 0; i10 < envelopeNode.getNNodes(); i10++) {
            Node node = envelopeNode.getNode(i10);
            if (node != null) {
                propertyList.add(getProperty(node.getNode(0)));
            }
        }
        return propertyList;
    }

    public long getSEQ() {
        return getLongHeaderValue(HTTP.SEQ);
    }

    public String getSID() {
        return Subscription.getSID(getHeaderValue(HTTP.SID));
    }

    public void setNT(String str) {
        setHeader(HTTP.NT, str);
    }

    public void setNTS(String str) {
        setHeader(HTTP.NTS, str);
    }

    public boolean setRequest(Subscriber subscriber, String str, String str2) {
        subscriber.getDeliveryURL();
        String sid = subscriber.getSID();
        long notifyCount = subscriber.getNotifyCount();
        String deliveryHost = subscriber.getDeliveryHost();
        String deliveryPath = subscriber.getDeliveryPath();
        int deliveryPort = subscriber.getDeliveryPort();
        setMethod(HTTP.NOTIFY);
        setURI(deliveryPath);
        setHost(deliveryHost, deliveryPort);
        setNT(NT.EVENT);
        setNTS(NTS.PROPCHANGE);
        setSID(sid);
        setSEQ(notifyCount);
        setContentType("text/xml; charset=\"utf-8\"");
        setContent(createPropertySetNode(str, str2));
        return true;
    }

    public void setSEQ(long j10) {
        setHeader(HTTP.SEQ, Long.toString(j10));
    }

    public void setSID(String str) {
        setHeader(HTTP.SID, Subscription.toSIDHeaderString(str));
    }

    public NotifyRequest(HTTPRequest hTTPRequest) {
        set(hTTPRequest);
    }
}
