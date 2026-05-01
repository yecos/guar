package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.upnp.StateVariable;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class QueryRequest extends ControlRequest {
    public QueryRequest() {
    }

    private Node createContentNode(StateVariable stateVariable) {
        Node node = new Node();
        node.setName("u", Control.QUERY_STATE_VARIABLE);
        node.setNameSpace("u", Control.XMLNS);
        Node node2 = new Node();
        node2.setName("u", Control.VAR_NAME);
        node2.setValue(stateVariable.getName());
        node.addNode(node2);
        return node;
    }

    private Node getVarNameNode() {
        Node node;
        Node bodyNode = getBodyNode();
        if (bodyNode != null && bodyNode.hasNodes() && (node = bodyNode.getNode(0)) != null && node.hasNodes()) {
            return node.getNode(0);
        }
        return null;
    }

    public String getVarName() {
        Node varNameNode = getVarNameNode();
        return varNameNode == null ? "" : varNameNode.getValue();
    }

    public QueryResponse post() {
        return new QueryResponse(postMessage(getRequestHost(), getRequestPort()));
    }

    public void setRequest(StateVariable stateVariable) {
        Service service = stateVariable.getService();
        service.getControlURL();
        setRequestHost(service);
        setEnvelopeNode(SOAP.createEnvelopeBodyNode());
        Node envelopeNode = getEnvelopeNode();
        getBodyNode().addNode(createContentNode(stateVariable));
        setContent(envelopeNode);
        setSOAPAction(Control.QUERY_SOAPACTION);
    }

    public QueryRequest(HTTPRequest hTTPRequest) {
        set(hTTPRequest);
    }
}
