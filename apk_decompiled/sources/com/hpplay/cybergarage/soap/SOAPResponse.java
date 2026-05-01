package com.hpplay.cybergarage.soap;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTPResponse;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class SOAPResponse extends HTTPResponse {
    private static final String TAG = "Cyber-SOAPResponse";
    private Node rootNode;

    public SOAPResponse() {
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    private Node getRootNode() {
        return this.rootNode;
    }

    private void setRootNode(Node node) {
        this.rootNode = node;
    }

    public Node getBodyNode() {
        Node envelopeNode = getEnvelopeNode();
        if (envelopeNode == null) {
            return null;
        }
        return envelopeNode.getNodeEndsWith(SOAP.BODY);
    }

    public Node getEnvelopeNode() {
        return getRootNode();
    }

    public String getFaultActor() {
        Node faultActorNode = getFaultActorNode();
        return faultActorNode == null ? "" : faultActorNode.getValue();
    }

    public Node getFaultActorNode() {
        Node faultNode = getFaultNode();
        if (faultNode == null) {
            return null;
        }
        return faultNode.getNodeEndsWith(SOAP.FAULTACTOR);
    }

    public String getFaultCode() {
        Node faultCodeNode = getFaultCodeNode();
        return faultCodeNode == null ? "" : faultCodeNode.getValue();
    }

    public Node getFaultCodeNode() {
        Node faultNode = getFaultNode();
        if (faultNode == null) {
            return null;
        }
        return faultNode.getNodeEndsWith(SOAP.FAULT_CODE);
    }

    public Node getFaultDetailNode() {
        Node faultNode = getFaultNode();
        if (faultNode == null) {
            return null;
        }
        return faultNode.getNodeEndsWith(SOAP.DETAIL);
    }

    public Node getFaultNode() {
        Node bodyNode = getBodyNode();
        if (bodyNode == null) {
            return null;
        }
        return bodyNode.getNodeEndsWith(SOAP.FAULT);
    }

    public String getFaultString() {
        Node faultStringNode = getFaultStringNode();
        return faultStringNode == null ? "" : faultStringNode.getValue();
    }

    public Node getFaultStringNode() {
        Node faultNode = getFaultNode();
        if (faultNode == null) {
            return null;
        }
        return faultNode.getNodeEndsWith(SOAP.FAULT_STRING);
    }

    public Node getMethodResponseNode(String str) {
        Node bodyNode = getBodyNode();
        if (bodyNode == null) {
            return null;
        }
        return bodyNode.getNodeEndsWith(str + SOAP.RESPONSE);
    }

    @Override // com.hpplay.cybergarage.http.HTTPResponse
    public void print() {
        Node rootNode;
        CLog.d(TAG, toString());
        if (hasContent() || (rootNode = getRootNode()) == null) {
            return;
        }
        CLog.d(TAG, rootNode.toString());
    }

    public void setContent(Node node) {
        setContent((("<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + node.toString());
    }

    public void setEnvelopeNode(Node node) {
        setRootNode(node);
    }

    public SOAPResponse(HTTPResponse hTTPResponse) {
        super(hTTPResponse);
        setRootNode(SOAP.createEnvelopeBodyNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }

    public SOAPResponse(SOAPResponse sOAPResponse) {
        super(sOAPResponse);
        setEnvelopeNode(sOAPResponse.getEnvelopeNode());
        setContentType("text/xml; charset=\"utf-8\"");
    }
}
