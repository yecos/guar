package com.hpplay.cybergarage.upnp;

import com.hpplay.cybergarage.upnp.xml.ArgumentData;
import com.hpplay.cybergarage.xml.Node;

/* loaded from: classes2.dex */
public class Argument {
    private static final String DIRECTION = "direction";
    public static final String ELEM_NAME = "argument";
    public static final String IN = "in";
    private static final String NAME = "name";
    public static final String OUT = "out";
    private static final String RELATED_STATE_VARIABLE = "relatedStateVariable";
    private Node argumentNode;
    private Node serviceNode;
    private Object userData;

    public Argument() {
        this.userData = null;
        this.argumentNode = new Node(ELEM_NAME);
        this.serviceNode = null;
    }

    private ArgumentData getArgumentData() {
        Node argumentNode = getArgumentNode();
        ArgumentData argumentData = (ArgumentData) argumentNode.getUserData();
        if (argumentData != null) {
            return argumentData;
        }
        ArgumentData argumentData2 = new ArgumentData();
        argumentNode.setUserData(argumentData2);
        argumentData2.setNode(argumentNode);
        return argumentData2;
    }

    private Node getServiceNode() {
        return this.serviceNode;
    }

    public static boolean isArgumentNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    public Action getAction() {
        return new Action(getServiceNode(), getActionNode());
    }

    public Node getActionNode() {
        Node parentNode;
        Node parentNode2 = getArgumentNode().getParentNode();
        if (parentNode2 == null || (parentNode = parentNode2.getParentNode()) == null || !Action.isActionNode(parentNode)) {
            return null;
        }
        return parentNode;
    }

    public Node getArgumentNode() {
        return this.argumentNode;
    }

    public String getDirection() {
        return getArgumentNode().getNodeValue(DIRECTION);
    }

    public int getIntegerValue() {
        try {
            return Integer.parseInt(getValue());
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getName() {
        return getArgumentNode().getNodeValue("name");
    }

    public StateVariable getRelatedStateVariable() {
        Service service = getService();
        if (service == null) {
            return null;
        }
        return service.getStateVariable(getRelatedStateVariableName());
    }

    public String getRelatedStateVariableName() {
        return getArgumentNode().getNodeValue(RELATED_STATE_VARIABLE);
    }

    public Service getService() {
        return new Service(getServiceNode());
    }

    public Object getUserData() {
        return this.userData;
    }

    public String getValue() {
        return getArgumentData().getValue();
    }

    public boolean isInDirection() {
        String direction = getDirection();
        if (direction == null) {
            return false;
        }
        return direction.equalsIgnoreCase(IN);
    }

    public boolean isOutDirection() {
        return !isInDirection();
    }

    public void setDirection(String str) {
        getArgumentNode().setNode(DIRECTION, str);
    }

    public void setName(String str) {
        getArgumentNode().setNode("name", str);
    }

    public void setRelatedStateVariableName(String str) {
        getArgumentNode().setNode(RELATED_STATE_VARIABLE, str);
    }

    public void setService(Service service) {
        service.getServiceNode();
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void setValue(String str) {
        getArgumentData().setValue(str);
    }

    public void setValue(int i10) {
        setValue(Integer.toString(i10));
    }

    public Argument(Node node) {
        this.userData = null;
        this.argumentNode = new Node(ELEM_NAME);
        this.serviceNode = node;
    }

    public Argument(Node node, Node node2) {
        this.userData = null;
        this.serviceNode = node;
        this.argumentNode = node2;
    }

    public Argument(String str, String str2) {
        this();
        setName(str);
        setValue(str2);
    }
}
