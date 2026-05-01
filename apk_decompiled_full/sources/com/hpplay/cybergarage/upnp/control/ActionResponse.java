package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.soap.SOAPResponse;
import com.hpplay.cybergarage.upnp.Action;
import com.hpplay.cybergarage.upnp.Argument;
import com.hpplay.cybergarage.upnp.ArgumentList;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class ActionResponse extends ControlResponse {
    public ActionResponse() {
        setHeader(HTTP.EXT, "");
    }

    private Node createResponseNode(Action action) {
        Node node = new Node("u:" + action.getName() + SOAP.RESPONSE);
        Service service = action.getService();
        if (service != null) {
            node.setAttribute("xmlns:u", service.getServiceType());
        }
        ArgumentList argumentList = action.getArgumentList();
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            if (argument.isOutDirection()) {
                Node node2 = new Node();
                node2.setName(argument.getName());
                node2.setValue(argument.getValue());
                node.addNode(node2);
            }
        }
        return node;
    }

    private Node getActionResponseNode() {
        Node bodyNode = getBodyNode();
        if (bodyNode == null || !bodyNode.hasNodes()) {
            return null;
        }
        return bodyNode.getNode(0);
    }

    public ArgumentList getResponse() {
        ArgumentList argumentList = new ArgumentList();
        Node actionResponseNode = getActionResponseNode();
        if (actionResponseNode == null) {
            return argumentList;
        }
        int nNodes = actionResponseNode.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node = actionResponseNode.getNode(i10);
            argumentList.add(new Argument(node.getName(), node.getValue()));
        }
        return argumentList;
    }

    public void setResponse(Action action) {
        setStatusCode(200);
        getBodyNode().addNode(createResponseNode(action));
        setContent(getEnvelopeNode());
    }

    public ActionResponse(SOAPResponse sOAPResponse) {
        super(sOAPResponse);
        setHeader(HTTP.EXT, "");
    }
}
