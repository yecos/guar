package com.hpplay.cybergarage.soap;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.xml.Node;
import java.io.ByteArrayInputStream;

/* loaded from: classes2.dex */
public class SOAPRequest extends HTTPRequest {
    private static final String SOAPACTION = "SOAPACTION";
    private static final String TAG = "Cyber-SOAPRequest";
    private Node rootNode;

    public SOAPRequest() {
        setContentType("text/xml; charset=\"utf-8\"");
        setMethod("POST");
    }

    private synchronized Node getRootNode() {
        Node node = this.rootNode;
        if (node != null) {
            return node;
        }
        try {
            this.rootNode = SOAP.getXMLParser().parse(new ByteArrayInputStream(getContent()));
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
        }
        return this.rootNode;
    }

    private void setRootNode(Node node) {
        this.rootNode = node;
    }

    public Node getBodyNode() {
        Node envelopeNode = getEnvelopeNode();
        if (envelopeNode != null && envelopeNode.hasNodes()) {
            return envelopeNode.getNode(0);
        }
        return null;
    }

    public Node getEnvelopeNode() {
        return getRootNode();
    }

    public String getSOAPAction() {
        return getStringHeaderValue("SOAPACTION");
    }

    public boolean isSOAPAction(String str) {
        String headerValue = getHeaderValue("SOAPACTION");
        if (headerValue == null) {
            return false;
        }
        if (headerValue.equals(str)) {
            return true;
        }
        String sOAPAction = getSOAPAction();
        if (sOAPAction == null) {
            return false;
        }
        return sOAPAction.equals(str);
    }

    public SOAPResponse postMessage(String str, int i10) {
        SOAPResponse sOAPResponse = new SOAPResponse(post(str, i10));
        byte[] content = sOAPResponse.getContent();
        if (content.length <= 0) {
            return sOAPResponse;
        }
        try {
            sOAPResponse.setEnvelopeNode(SOAP.getXMLParser().parse(new ByteArrayInputStream(content)));
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
        }
        return sOAPResponse;
    }

    @Override // com.hpplay.cybergarage.http.HTTPRequest
    public void print() {
        Node rootNode;
        CLog.d(TAG, toString());
        if (hasContent() || (rootNode = getRootNode()) == null) {
            return;
        }
        CLog.d(TAG, rootNode.toString());
    }

    public void setContent(Node node) {
        setContent(((("<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + node.toString()).trim());
    }

    public void setEnvelopeNode(Node node) {
        setRootNode(node);
    }

    public void setSOAPAction(String str) {
        setStringHeader("SOAPACTION", str);
    }

    public SOAPRequest(HTTPRequest hTTPRequest) {
        set(hTTPRequest);
    }
}
