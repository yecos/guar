package com.hpplay.cybergarage.upnp;

import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.cybergarage.upnp.control.ActionListener;
import com.hpplay.cybergarage.upnp.control.ActionRequest;
import com.hpplay.cybergarage.upnp.control.ActionResponse;
import com.hpplay.cybergarage.upnp.control.ControlResponse;
import com.hpplay.cybergarage.upnp.xml.ActionData;
import com.hpplay.cybergarage.util.Mutex;
import com.hpplay.cybergarage.xml.Node;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Action {
    public static final String ELEM_NAME = "action";
    private static final String NAME = "name";
    public static final String STATUS_FLAG = "L@L";
    private Node actionNode;
    public boolean isSuccessful;
    private ResponseCallbackLisener mResponseCallbackLisener;
    private Mutex mutex;
    private Node serviceNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public interface ResponseCallbackLisener {
        void onCallback(String str, String str2);
    }

    public Action(Node node) {
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = node;
        this.actionNode = new Node("action");
    }

    private void clearOutputAgumentValues() {
        ArgumentList argumentList = getArgumentList();
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            if (argument.isOutDirection()) {
                argument.setValue("");
            }
        }
    }

    private ActionData getActionData() {
        Node actionNode = getActionNode();
        ActionData actionData = (ActionData) actionNode.getUserData();
        if (actionData != null) {
            return actionData;
        }
        ActionData actionData2 = new ActionData();
        actionNode.setUserData(actionData2);
        actionData2.setNode(actionNode);
        return actionData2;
    }

    private ControlResponse getControlResponse() {
        return getActionData().getControlResponse();
    }

    private Node getServiceNode() {
        return this.serviceNode;
    }

    public static boolean isActionNode(Node node) {
        return "action".equals(node.getName());
    }

    private void setControlResponse(ControlResponse controlResponse) {
        getActionData().setControlResponse(controlResponse);
    }

    public ActionListener getActionListener() {
        return getActionData().getActionListener();
    }

    public Node getActionNode() {
        return this.actionNode;
    }

    public Argument getArgument(String str) {
        ArgumentList argumentList = getArgumentList();
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            String name = argument.getName();
            if (name != null && str.equals(name)) {
                return argument;
            }
        }
        return null;
    }

    public int getArgumentIntegerValue(String str) {
        Argument argument = getArgument(str);
        if (argument == null) {
            return 0;
        }
        return argument.getIntegerValue();
    }

    public ArgumentList getArgumentList() {
        ArgumentList argumentList = new ArgumentList();
        Node node = getActionNode().getNode(ArgumentList.ELEM_NAME);
        if (node == null) {
            return argumentList;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (Argument.isArgumentNode(node2)) {
                argumentList.add(new Argument(getServiceNode(), node2));
            }
        }
        return argumentList;
    }

    public String getArgumentValue(String str) {
        Argument argument = getArgument(str);
        return argument == null ? "" : argument.getValue();
    }

    public UPnPStatus getControlStatus() {
        return getControlResponse().getUPnPError();
    }

    public ArgumentList getInputArgumentList() {
        ArgumentList argumentList = getArgumentList();
        int size = argumentList.size();
        ArgumentList argumentList2 = new ArgumentList();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            if (argument.isInDirection()) {
                argumentList2.add(argument);
            }
        }
        return argumentList2;
    }

    public String getName() {
        return getActionNode().getNodeValue("name");
    }

    public ArgumentList getOutputArgumentList() {
        ArgumentList argumentList = getArgumentList();
        int size = argumentList.size();
        ArgumentList argumentList2 = new ArgumentList();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            if (argument.isOutDirection()) {
                argumentList2.add(argument);
            }
        }
        return argumentList2;
    }

    public Service getService() {
        return new Service(getServiceNode());
    }

    public UPnPStatus getStatus() {
        return this.upnpStatus;
    }

    public Object getUserData() {
        return this.userData;
    }

    public void lock() {
        this.mutex.lock();
    }

    public boolean performActionListener(ActionRequest actionRequest) {
        ActionListener actionListener = getActionListener();
        if (actionListener == null) {
            return false;
        }
        ActionResponse actionResponse = new ActionResponse();
        setStatus(401);
        clearOutputAgumentValues();
        if (actionListener.actionControlReceived(this)) {
            actionResponse.setResponse(this);
        } else {
            UPnPStatus status = getStatus();
            actionResponse.setFaultResponse(status.getCode(), status.getDescription());
        }
        actionResponse.print();
        actionRequest.post(actionResponse);
        return true;
    }

    public boolean postControlAction(String str) {
        ArgumentList argumentList = getArgumentList();
        ArgumentList inputArgumentList = getInputArgumentList();
        ActionRequest actionRequest = new ActionRequest(str);
        actionRequest.setRequest(this, inputArgumentList);
        actionRequest.print();
        ActionResponse post = actionRequest.post();
        post.print();
        setControlResponse(post);
        setStatus(post.getStatusCode());
        ArgumentList response = post.getResponse();
        try {
            if (actionRequest.getHeader().contains(IDLNAController.PLAY) || actionRequest.getHeader().contains("SetAVTransportURI")) {
                String str2 = post.getHeader() + "\r\n" + new String(post.getContent());
                ResponseCallbackLisener responseCallbackLisener = this.mResponseCallbackLisener;
                if (responseCallbackLisener != null) {
                    responseCallbackLisener.onCallback(actionRequest.getHeader() + "\r\n" + new String(actionRequest.getContent()), str2);
                }
            }
            argumentList.setResArgs(response);
            return post.isSuccessful();
        } catch (Exception unused) {
            setStatus(402, "Action succesfully delivered but invalid arguments returned.");
            return false;
        }
    }

    public String postPlayAction(String str) {
        this.isSuccessful = false;
        ArgumentList argumentList = getArgumentList();
        ArgumentList inputArgumentList = getInputArgumentList();
        ActionRequest actionRequest = new ActionRequest(str);
        actionRequest.setRequest(this, inputArgumentList);
        actionRequest.print();
        ActionResponse post = actionRequest.post();
        post.print();
        setControlResponse(post);
        setStatus(post.getStatusCode());
        ArgumentList response = post.getResponse();
        try {
            String str2 = post.getHeader() + "\r\n" + new String(post.getContent());
            ResponseCallbackLisener responseCallbackLisener = this.mResponseCallbackLisener;
            if (responseCallbackLisener != null) {
                responseCallbackLisener.onCallback(actionRequest.getHeader() + "\r\n" + new String(actionRequest.getContent()), str2);
            }
            argumentList.setResArgs(response);
            this.isSuccessful = post.isSuccessful();
            return str2 + STATUS_FLAG + post.getStatusCode();
        } catch (Exception e10) {
            setStatus(402, "Action succesfully delivered but invalid arguments returned.");
            return e10.toString();
        }
    }

    public void print() {
        System.out.println("Action : " + getName());
        ArgumentList argumentList = getArgumentList();
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            String name = argument.getName();
            String value = argument.getValue();
            String direction = argument.getDirection();
            System.out.println(" [" + i10 + "] = " + direction + ", " + name + ", " + value);
        }
    }

    public void setActionListener(ActionListener actionListener) {
        getActionData().setActionListener(actionListener);
    }

    public void setArgumentList(ArgumentList argumentList) {
        Node node = getActionNode().getNode(ArgumentList.ELEM_NAME);
        if (node == null) {
            node = new Node(ArgumentList.ELEM_NAME);
            getActionNode().addNode(node);
        } else {
            node.removeAllNodes();
        }
        Iterator<E> it = argumentList.iterator();
        while (it.hasNext()) {
            Argument argument = (Argument) it.next();
            argument.setService(getService());
            node.addNode(argument.getArgumentNode());
        }
    }

    public void setArgumentValue(String str, String str2) {
        Argument argument = getArgument(str);
        if (argument == null) {
            return;
        }
        argument.setValue(str2);
    }

    public void setArgumentValues(ArgumentList argumentList) {
        getArgumentList().set(argumentList);
    }

    public void setInArgumentValues(ArgumentList argumentList) {
        getArgumentList().setReqArgs(argumentList);
    }

    public void setName(String str) {
        getActionNode().setNode("name", str);
    }

    public void setOutArgumentValues(ArgumentList argumentList) {
        getArgumentList().setResArgs(argumentList);
    }

    public void setResponseCallbackLisener(ResponseCallbackLisener responseCallbackLisener) {
        this.mResponseCallbackLisener = responseCallbackLisener;
    }

    public void setService(Service service) {
        this.serviceNode = service.getServiceNode();
        Iterator<E> it = getArgumentList().iterator();
        while (it.hasNext()) {
            ((Argument) it.next()).setService(service);
        }
    }

    public void setStatus(int i10, String str) {
        this.upnpStatus.setCode(i10);
        this.upnpStatus.setDescription(str);
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void unlock() {
        this.mutex.unlock();
    }

    public void setArgumentValue(String str, int i10) {
        setArgumentValue(str, Integer.toString(i10));
    }

    public void setStatus(int i10) {
        setStatus(i10, UPnPStatus.code2String(i10));
    }

    public Action(Node node, Node node2) {
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = node;
        this.actionNode = node2;
    }

    public Action(Action action) {
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = action.getServiceNode();
        this.actionNode = action.getActionNode();
    }
}
