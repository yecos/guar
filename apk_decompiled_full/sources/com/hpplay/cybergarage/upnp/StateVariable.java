package com.hpplay.cybergarage.upnp;

import com.hpplay.cybergarage.upnp.control.QueryListener;
import com.hpplay.cybergarage.upnp.control.QueryRequest;
import com.hpplay.cybergarage.upnp.control.QueryResponse;
import com.hpplay.cybergarage.upnp.xml.NodeData;
import com.hpplay.cybergarage.upnp.xml.StateVariableData;
import com.hpplay.cybergarage.xml.Node;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class StateVariable extends NodeData {
    private static final String DATATYPE = "dataType";
    private static final String DEFAULT_VALUE = "defaultValue";
    public static final String ELEM_NAME = "stateVariable";
    private static final String NAME = "name";
    private static final String SENDEVENTS = "sendEvents";
    private static final String SENDEVENTS_NO = "no";
    private static final String SENDEVENTS_YES = "yes";
    private Node serviceNode;
    private Node stateVariableNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public StateVariable() {
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = null;
        this.stateVariableNode = new Node(ELEM_NAME);
    }

    public static boolean isStateVariableNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    private void setQueryResponse(QueryResponse queryResponse) {
        getStateVariableData().setQueryResponse(queryResponse);
    }

    public AllowedValueList getAllowedValueList() {
        AllowedValueList allowedValueList = new AllowedValueList();
        Node node = getStateVariableNode().getNode(AllowedValueList.ELEM_NAME);
        if (node == null) {
            return null;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (AllowedValue.isAllowedValueNode(node2)) {
                allowedValueList.add(new AllowedValue(node2));
            }
        }
        return allowedValueList;
    }

    public AllowedValueRange getAllowedValueRange() {
        Node node = getStateVariableNode().getNode(AllowedValueRange.ELEM_NAME);
        if (node == null) {
            return null;
        }
        return new AllowedValueRange(node);
    }

    public String getDataType() {
        return getStateVariableNode().getNodeValue(DATATYPE);
    }

    public String getDefaultValue() {
        return getStateVariableNode().getNodeValue(DEFAULT_VALUE);
    }

    public String getName() {
        return getStateVariableNode().getNodeValue("name");
    }

    public QueryListener getQueryListener() {
        return getStateVariableData().getQueryListener();
    }

    public QueryResponse getQueryResponse() {
        return getStateVariableData().getQueryResponse();
    }

    public UPnPStatus getQueryStatus() {
        return getQueryResponse().getUPnPError();
    }

    public Service getService() {
        Node serviceNode = getServiceNode();
        if (serviceNode == null) {
            return null;
        }
        return new Service(serviceNode);
    }

    public Node getServiceNode() {
        return this.serviceNode;
    }

    public StateVariableData getStateVariableData() {
        Node stateVariableNode = getStateVariableNode();
        StateVariableData stateVariableData = (StateVariableData) stateVariableNode.getUserData();
        if (stateVariableData != null) {
            return stateVariableData;
        }
        StateVariableData stateVariableData2 = new StateVariableData();
        stateVariableNode.setUserData(stateVariableData2);
        stateVariableData2.setNode(stateVariableNode);
        return stateVariableData2;
    }

    public Node getStateVariableNode() {
        return this.stateVariableNode;
    }

    public UPnPStatus getStatus() {
        return this.upnpStatus;
    }

    public Object getUserData() {
        return this.userData;
    }

    public String getValue() {
        return getStateVariableData().getValue();
    }

    public boolean hasAllowedValueList() {
        return getAllowedValueList() != null;
    }

    public boolean hasAllowedValueRange() {
        return getAllowedValueRange() != null;
    }

    public boolean isSendEvents() {
        String attributeValue = getStateVariableNode().getAttributeValue(SENDEVENTS);
        return attributeValue != null && attributeValue.equalsIgnoreCase(SENDEVENTS_YES);
    }

    public boolean performQueryListener(QueryRequest queryRequest) {
        QueryListener queryListener = getQueryListener();
        if (queryListener == null) {
            return false;
        }
        QueryResponse queryResponse = new QueryResponse();
        StateVariable stateVariable = new StateVariable();
        stateVariable.set(this);
        stateVariable.setValue("");
        stateVariable.setStatus(404);
        if (queryListener.queryControlReceived(stateVariable)) {
            queryResponse.setResponse(stateVariable);
        } else {
            UPnPStatus status = stateVariable.getStatus();
            queryResponse.setFaultResponse(status.getCode(), status.getDescription());
        }
        queryRequest.post(queryResponse);
        return true;
    }

    public boolean postQuerylAction() {
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setRequest(this);
        queryRequest.print();
        QueryResponse post = queryRequest.post();
        post.print();
        setQueryResponse(post);
        if (post.isSuccessful()) {
            setValue(post.getReturnValue());
            return true;
        }
        setValue(post.getReturnValue());
        return false;
    }

    public void set(StateVariable stateVariable) {
        setName(stateVariable.getName());
        setValue(stateVariable.getValue());
        setDataType(stateVariable.getDataType());
        setSendEvents(stateVariable.isSendEvents());
    }

    public void setAllowedValueList(AllowedValueList allowedValueList) {
        getStateVariableNode().removeNode(AllowedValueList.ELEM_NAME);
        getStateVariableNode().removeNode(AllowedValueRange.ELEM_NAME);
        Node node = new Node(AllowedValueList.ELEM_NAME);
        Iterator<E> it = allowedValueList.iterator();
        while (it.hasNext()) {
            node.addNode(((AllowedValue) it.next()).getAllowedValueNode());
        }
        getStateVariableNode().addNode(node);
    }

    public void setAllowedValueRange(AllowedValueRange allowedValueRange) {
        getStateVariableNode().removeNode(AllowedValueList.ELEM_NAME);
        getStateVariableNode().removeNode(AllowedValueRange.ELEM_NAME);
        getStateVariableNode().addNode(allowedValueRange.getAllowedValueRangeNode());
    }

    public void setDataType(String str) {
        getStateVariableNode().setNode(DATATYPE, str);
    }

    public void setDefaultValue(String str) {
        getStateVariableNode().setNode(DEFAULT_VALUE, str);
    }

    public void setName(String str) {
        getStateVariableNode().setNode("name", str);
    }

    public void setQueryListener(QueryListener queryListener) {
        getStateVariableData().setQueryListener(queryListener);
    }

    public void setSendEvents(boolean z10) {
        getStateVariableNode().setAttribute(SENDEVENTS, z10 ? SENDEVENTS_YES : SENDEVENTS_NO);
    }

    public void setServiceNode(Node node) {
        this.serviceNode = node;
    }

    public void setStatus(int i10, String str) {
        this.upnpStatus.setCode(i10);
        this.upnpStatus.setDescription(str);
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void setValue(String str) {
        String value = getStateVariableData().getValue();
        if (value == null || !value.equals(str)) {
            getStateVariableData().setValue(str);
            Service service = getService();
            if (service != null && isSendEvents()) {
                service.notify(this);
            }
        }
    }

    public void setStatus(int i10) {
        setStatus(i10, UPnPStatus.code2String(i10));
    }

    public StateVariable(Node node, Node node2) {
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = node;
        this.stateVariableNode = node2;
    }

    public void setValue(int i10) {
        setValue(Integer.toString(i10));
    }

    public void setValue(long j10) {
        setValue(Long.toString(j10));
    }
}
