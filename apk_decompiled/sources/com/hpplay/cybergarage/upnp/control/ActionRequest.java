package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.upnp.Action;
import com.hpplay.cybergarage.upnp.Argument;
import com.hpplay.cybergarage.upnp.ArgumentList;
import com.hpplay.cybergarage.upnp.Service;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class ActionRequest extends ControlRequest {
    public ActionRequest(String str) {
        setHeader("User-Agent", "UPnP/1.0");
    }

    private Node createContentNode(Service service, Action action, ArgumentList argumentList) {
        String name = action.getName();
        String serviceType = service.getServiceType();
        Node node = new Node();
        node.setName("u", name);
        node.setNameSpace("u", serviceType);
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            Node node2 = new Node();
            node2.setName(argument.getName());
            node2.setValue(argument.getValue());
            node.addNode(node2);
        }
        return node;
    }

    public String getActionName() {
        String name;
        int indexOf;
        Node actionNode = getActionNode();
        return (actionNode == null || (name = actionNode.getName()) == null || (indexOf = name.indexOf(SOAP.DELIM) + 1) < 0) ? "" : name.substring(indexOf, name.length());
    }

    public Node getActionNode() {
        Node bodyNode = getBodyNode();
        if (bodyNode != null && bodyNode.hasNodes()) {
            return bodyNode.getNode(0);
        }
        return null;
    }

    public ArgumentList getArgumentList() {
        Node actionNode = getActionNode();
        int nNodes = actionNode.getNNodes();
        ArgumentList argumentList = new ArgumentList();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Argument argument = new Argument();
            Node node = actionNode.getNode(i10);
            argument.setName(node.getName());
            argument.setValue(node.getValue());
            argumentList.add(argument);
        }
        return argumentList;
    }

    public ActionResponse post() {
        return new ActionResponse(postMessage(getRequestHost(), getRequestPort()));
    }

    public void setRequest(Action action, ArgumentList argumentList) {
        Service service = action.getService();
        setRequestHost(service);
        setEnvelopeNode(SOAP.createEnvelopeBodyNode());
        Node envelopeNode = getEnvelopeNode();
        getBodyNode().addNode(createContentNode(service, action, argumentList));
        setContent(envelopeNode);
        setSOAPAction("\"" + service.getServiceType() + "#" + action.getName() + "\"");
    }

    public ActionRequest(HTTPRequest hTTPRequest) {
        set(hTTPRequest);
    }
}
