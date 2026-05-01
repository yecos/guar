package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.soap.SOAPResponse;
import com.hpplay.cybergarage.upnp.StateVariable;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class QueryResponse extends ControlResponse {
    public QueryResponse() {
    }

    private Node createResponseNode(String str) {
        Node node = new Node();
        node.setName("u", Control.QUERY_STATE_VARIABLE_RESPONSE);
        node.setNameSpace("u", Control.XMLNS);
        Node node2 = new Node();
        node2.setName(Control.RETURN);
        node2.setValue(str);
        node.addNode(node2);
        return node;
    }

    private Node getReturnNode() {
        Node node;
        Node bodyNode = getBodyNode();
        if (bodyNode != null && bodyNode.hasNodes() && (node = bodyNode.getNode(0)) != null && node.hasNodes()) {
            return node.getNode(0);
        }
        return null;
    }

    public String getReturnValue() {
        Node returnNode = getReturnNode();
        return returnNode == null ? "" : returnNode.getValue();
    }

    public void setResponse(StateVariable stateVariable) {
        String value = stateVariable.getValue();
        setStatusCode(200);
        getBodyNode().addNode(createResponseNode(value));
        setContent(getEnvelopeNode());
    }

    public QueryResponse(SOAPResponse sOAPResponse) {
        super(sOAPResponse);
    }
}
