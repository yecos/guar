package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.http.HTTPStatus;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.soap.SOAPResponse;
import com.hpplay.cybergarage.upnp.UPnP;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class ControlResponse extends SOAPResponse {
    public static final String FAULT_CODE = "Client";
    public static final String FAULT_STRING = "UPnPError";
    private UPnPStatus upnpErr;

    public ControlResponse() {
        this.upnpErr = new UPnPStatus();
        setServer(UPnP.getServerName());
    }

    private Node createFaultResponseNode(int i10, String str) {
        Node node = new Node("s:Fault");
        Node node2 = new Node(SOAP.FAULT_CODE);
        node2.setValue("s:Client");
        node.addNode(node2);
        Node node3 = new Node(SOAP.FAULT_STRING);
        node3.setValue("UPnPError");
        node.addNode(node3);
        Node node4 = new Node(SOAP.DETAIL);
        node.addNode(node4);
        Node node5 = new Node("UPnPError");
        node5.setAttribute("xmlns", Control.XMLNS);
        node4.addNode(node5);
        Node node6 = new Node("errorCode");
        node6.setValue(i10);
        node5.addNode(node6);
        Node node7 = new Node(SOAP.ERROR_DESCRIPTION);
        node7.setValue(str);
        node5.addNode(node7);
        return node;
    }

    private Node getUPnPErrorCodeNode() {
        Node uPnPErrorNode = getUPnPErrorNode();
        if (uPnPErrorNode == null) {
            return null;
        }
        return uPnPErrorNode.getNodeEndsWith("errorCode");
    }

    private Node getUPnPErrorDescriptionNode() {
        Node uPnPErrorNode = getUPnPErrorNode();
        if (uPnPErrorNode == null) {
            return null;
        }
        return uPnPErrorNode.getNodeEndsWith(SOAP.ERROR_DESCRIPTION);
    }

    private Node getUPnPErrorNode() {
        Node faultDetailNode = getFaultDetailNode();
        if (faultDetailNode == null) {
            return null;
        }
        return faultDetailNode.getNodeEndsWith("UPnPError");
    }

    public UPnPStatus getUPnPError() {
        int uPnPErrorCode = getUPnPErrorCode();
        String uPnPErrorDescription = getUPnPErrorDescription();
        this.upnpErr.setCode(uPnPErrorCode);
        this.upnpErr.setDescription(uPnPErrorDescription);
        return this.upnpErr;
    }

    public int getUPnPErrorCode() {
        Node uPnPErrorCodeNode = getUPnPErrorCodeNode();
        if (uPnPErrorCodeNode == null) {
            return -1;
        }
        try {
            return Integer.parseInt(uPnPErrorCodeNode.getValue());
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getUPnPErrorDescription() {
        Node uPnPErrorDescriptionNode = getUPnPErrorDescriptionNode();
        return uPnPErrorDescriptionNode == null ? "" : uPnPErrorDescriptionNode.getValue();
    }

    public void setFaultResponse(int i10, String str) {
        setStatusCode(HTTPStatus.INTERNAL_SERVER_ERROR);
        getBodyNode().addNode(createFaultResponseNode(i10, str));
        setContent(getEnvelopeNode());
    }

    public ControlResponse(SOAPResponse sOAPResponse) {
        super(sOAPResponse);
        this.upnpErr = new UPnPStatus();
    }

    public void setFaultResponse(int i10) {
        setFaultResponse(i10, UPnPStatus.code2String(i10));
    }

    private Node createFaultResponseNode(int i10) {
        return createFaultResponseNode(i10, UPnPStatus.code2String(i10));
    }
}
