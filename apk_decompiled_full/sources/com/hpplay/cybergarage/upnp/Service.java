package com.hpplay.cybergarage.upnp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.control.ActionListener;
import com.hpplay.cybergarage.upnp.control.QueryListener;
import com.hpplay.cybergarage.upnp.device.InvalidDescriptionException;
import com.hpplay.cybergarage.upnp.device.NTS;
import com.hpplay.cybergarage.upnp.device.ST;
import com.hpplay.cybergarage.upnp.event.NotifyRequest;
import com.hpplay.cybergarage.upnp.event.Subscriber;
import com.hpplay.cybergarage.upnp.event.SubscriberList;
import com.hpplay.cybergarage.upnp.ssdp.SSDPNotifyRequest;
import com.hpplay.cybergarage.upnp.ssdp.SSDPNotifySocket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;
import com.hpplay.cybergarage.upnp.xml.ServiceData;
import com.hpplay.cybergarage.util.Mutex;
import com.hpplay.cybergarage.util.StringUtil;
import com.hpplay.cybergarage.xml.Node;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Service {
    private static final String CONFIG_ID = "configId";
    private static final String CONTROL_URL = "controlURL";
    public static final String ELEM_NAME = "service";
    private static final String EVENT_SUB_URL = "eventSubURL";
    public static final String MAJOR = "major";
    public static final String MAJOR_VALUE = "1";
    public static final String MINOR = "minor";
    public static final String MINOR_VALUE = "0";
    private static final String SCPDURL = "SCPDURL";
    public static final String SCPD_ROOTNODE = "scpd";
    public static final String SCPD_ROOTNODE_NS = "urn:schemas-upnp-org:service-1-0";
    private static final String SERVICE_ID = "serviceId";
    private static final String SERVICE_TYPE = "serviceType";
    public static final String SPEC_VERSION = "specVersion";
    private static final String TAG = "Cyber-Service";
    private String mErrorMsg;
    private Mutex mutex;
    private Node serviceNode;
    private Object userData;

    public Service() {
        this(new Node(ELEM_NAME));
        Node node = new Node("specVersion");
        Node node2 = new Node("major");
        node2.setValue("1");
        node.addNode(node2);
        Node node3 = new Node("minor");
        node3.setValue("0");
        node.addNode(node3);
        Node node4 = new Node(SCPD_ROOTNODE);
        node4.addAttribute("xmlns", SCPD_ROOTNODE_NS);
        node4.addNode(node);
        getServiceData().setSCPDNode(node4);
    }

    private Node getDeviceNode() {
        Node parentNode = getServiceNode().getParentNode();
        if (parentNode == null) {
            return null;
        }
        return parentNode.getParentNode();
    }

    private String getNotifyServiceTypeNT() {
        return getServiceType();
    }

    private String getNotifyServiceTypeUSN() {
        return getDevice().getUDN() + "::" + getServiceType();
    }

    private Node getRootNode() {
        return getServiceNode().getRootNode();
    }

    private Node getSCPDNode(URL url) {
        return UPnP.getXMLParser().parse(url.toString(), 10000);
    }

    private ServiceData getServiceData() {
        Node serviceNode = getServiceNode();
        ServiceData serviceData = (ServiceData) serviceNode.getUserData();
        if (serviceData != null) {
            return serviceData;
        }
        ServiceData serviceData2 = new ServiceData();
        serviceNode.setUserData(serviceData2);
        serviceData2.setNode(serviceNode);
        return serviceData2;
    }

    public static boolean isServiceNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    private boolean isURL(String str, String str2) {
        return (str == null || str2 == null || (!str2.equals(str) && !str2.equals(HTTP.toRelativeURL(str, false)))) ? false : true;
    }

    private boolean notify(Subscriber subscriber, StateVariable stateVariable) {
        String name = stateVariable.getName();
        String value = stateVariable.getValue();
        String deliveryHost = subscriber.getDeliveryHost();
        int deliveryPort = subscriber.getDeliveryPort();
        NotifyRequest notifyRequest = new NotifyRequest();
        notifyRequest.setRequest(subscriber, name, value);
        if (!notifyRequest.post(deliveryHost, deliveryPort).isSuccessful()) {
            return false;
        }
        subscriber.incrementNotifyCount();
        return true;
    }

    public void addAction(Action action) {
        Iterator<E> it = action.getArgumentList().iterator();
        while (it.hasNext()) {
            ((Argument) it.next()).setService(this);
        }
        Node sCPDNode = getSCPDNode();
        if (sCPDNode.getNode(ActionList.ELEM_NAME) == null) {
            sCPDNode.addNode(new Node(ActionList.ELEM_NAME));
        }
    }

    public void addStateVariable(StateVariable stateVariable) {
        Node sCPDNode = getSCPDNode();
        Node node = sCPDNode != null ? sCPDNode.getNode(ServiceStateTable.ELEM_NAME) : null;
        if (node == null) {
            node = new Node(ServiceStateTable.ELEM_NAME);
            Node sCPDNode2 = getSCPDNode();
            if (sCPDNode2 != null) {
                sCPDNode2.addNode(node);
            }
        }
        stateVariable.setServiceNode(getServiceNode());
        node.addNode(stateVariable.getStateVariableNode());
    }

    public void addSubscriber(Subscriber subscriber) {
        getSubscriberList().add(subscriber);
    }

    public void announce(String str) {
        String locationURL = getRootDevice().getLocationURL(str);
        String notifyServiceTypeNT = getNotifyServiceTypeNT();
        String notifyServiceTypeUSN = getNotifyServiceTypeUSN();
        Device device = getDevice();
        SSDPNotifyRequest sSDPNotifyRequest = new SSDPNotifyRequest();
        sSDPNotifyRequest.setServer(UPnP.getServerName());
        sSDPNotifyRequest.setLeaseTime(device.getLeaseTime());
        sSDPNotifyRequest.setLocation(locationURL);
        sSDPNotifyRequest.setNTS(NTS.ALIVE);
        sSDPNotifyRequest.setNT(notifyServiceTypeNT);
        sSDPNotifyRequest.setUSN(notifyServiceTypeUSN);
        SSDPNotifySocket sSDPNotifySocket = new SSDPNotifySocket(str);
        Device.notifyWait();
        sSDPNotifySocket.post(sSDPNotifyRequest);
    }

    public void byebye(String str) {
        String notifyServiceTypeNT = getNotifyServiceTypeNT();
        String notifyServiceTypeUSN = getNotifyServiceTypeUSN();
        SSDPNotifyRequest sSDPNotifyRequest = new SSDPNotifyRequest();
        sSDPNotifyRequest.setNTS(NTS.BYEBYE);
        sSDPNotifyRequest.setNT(notifyServiceTypeNT);
        sSDPNotifyRequest.setUSN(notifyServiceTypeUSN);
        SSDPNotifySocket sSDPNotifySocket = new SSDPNotifySocket(str);
        Device.notifyWait();
        sSDPNotifySocket.post(sSDPNotifyRequest);
    }

    public void clearSID() {
        setSID("");
        setTimeout(0L);
    }

    public Action getAction(String str) {
        ActionList actionList = getActionList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Action action = actionList.getAction(i10);
            String name = action.getName();
            if (name != null && name.equals(str)) {
                return action;
            }
        }
        return null;
    }

    public ActionList getActionList() {
        ActionList actionList = new ActionList();
        Node sCPDNode = getSCPDNode();
        if (sCPDNode == null) {
            return actionList;
        }
        Node node = sCPDNode.getNode(ActionList.ELEM_NAME);
        if (node == null) {
            return actionList;
        }
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (Action.isActionNode(node2)) {
                actionList.add(new Action(this.serviceNode, node2));
            }
        }
        return actionList;
    }

    public int getConfigId() {
        Node sCPDNode = getSCPDNode();
        if (sCPDNode == null) {
            return 0;
        }
        return sCPDNode.getAttributeIntegerValue(CONFIG_ID);
    }

    public String getControlURL() {
        return getServiceNode().getNodeValue(CONTROL_URL);
    }

    public String getDescriptionURL() {
        return getServiceData().getDescriptionURL();
    }

    public Device getDevice() {
        return new Device(getRootNode(), getDeviceNode());
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getEventSubURL() {
        return getServiceNode().getNodeValue(EVENT_SUB_URL);
    }

    public Device getRootDevice() {
        return getDevice().getRootDevice();
    }

    public byte[] getSCPDData() {
        Node sCPDNode = getSCPDNode();
        if (sCPDNode == null) {
            return new byte[0];
        }
        return (((new String() + "<?xml version=\"1.0\" encoding=\"utf-8\"?>") + "\n") + sCPDNode.toString()).getBytes();
    }

    public String getSCPDURL() {
        return getServiceNode().getNodeValue(SCPDURL);
    }

    public String getSID() {
        return getServiceData().getSID();
    }

    public String getServiceID() {
        return getServiceNode().getNodeValue("serviceId");
    }

    public Node getServiceNode() {
        return this.serviceNode;
    }

    public ServiceStateTable getServiceStateTable() {
        ServiceStateTable serviceStateTable = new ServiceStateTable();
        Node sCPDNode = getSCPDNode();
        if (sCPDNode == null) {
            return serviceStateTable;
        }
        Node node = sCPDNode.getNode(ServiceStateTable.ELEM_NAME);
        if (node == null) {
            return serviceStateTable;
        }
        Node serviceNode = getServiceNode();
        int nNodes = node.getNNodes();
        for (int i10 = 0; i10 < nNodes; i10++) {
            Node node2 = node.getNode(i10);
            if (StateVariable.isStateVariableNode(node2)) {
                serviceStateTable.add(new StateVariable(serviceNode, node2));
            }
        }
        return serviceStateTable;
    }

    public String getServiceType() {
        return getServiceNode().getNodeValue(SERVICE_TYPE);
    }

    public StateVariable getStateVariable(String str) {
        ServiceStateTable serviceStateTable = getServiceStateTable();
        int size = serviceStateTable.size();
        for (int i10 = 0; i10 < size; i10++) {
            StateVariable stateVariable = serviceStateTable.getStateVariable(i10);
            String name = stateVariable.getName();
            if (name != null && name.equals(str)) {
                return stateVariable;
            }
        }
        return null;
    }

    public Subscriber getSubscriber(String str) {
        String sid;
        SubscriberList subscriberList = getSubscriberList();
        int size = subscriberList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Subscriber subscriber = subscriberList.getSubscriber(i10);
            if (subscriber != null && (sid = subscriber.getSID()) != null && sid.equals(str)) {
                return subscriber;
            }
        }
        return null;
    }

    public SubscriberList getSubscriberList() {
        return getServiceData().getSubscriberList();
    }

    public long getTimeout() {
        return getServiceData().getTimeout();
    }

    public Object getUserData() {
        return this.userData;
    }

    public boolean hasSID() {
        return StringUtil.hasData(getSID());
    }

    public boolean hasStateVariable(String str) {
        return getStateVariable(str) != null;
    }

    public boolean isControlURL(String str) {
        return isURL(getControlURL(), str);
    }

    public boolean isEventSubURL(String str) {
        return isURL(getEventSubURL(), str);
    }

    public boolean isSCPDURL(String str) {
        return isURL(getSCPDURL(), str);
    }

    public boolean isService(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(getServiceType()) || str.endsWith(getServiceID());
    }

    public boolean isSubscribed() {
        return hasSID();
    }

    public boolean loadSCPD(String str) {
        try {
            Node parse = UPnP.getXMLParser().parse(str);
            if (parse == null) {
                return false;
            }
            getServiceData().setSCPDNode(parse);
            return true;
        } catch (Exception e10) {
            throw new InvalidDescriptionException(e10);
        }
    }

    public void lock() {
        this.mutex.lock();
    }

    public void notifyAllStateVariables() {
        ServiceStateTable serviceStateTable = getServiceStateTable();
        int size = serviceStateTable.size();
        for (int i10 = 0; i10 < size; i10++) {
            StateVariable stateVariable = serviceStateTable.getStateVariable(i10);
            if (stateVariable.isSendEvents()) {
                notify(stateVariable);
            }
        }
    }

    public void removeSubscriber(Subscriber subscriber) {
        getSubscriberList().remove(subscriber);
    }

    public boolean serviceSearchResponse(SSDPPacket sSDPPacket) {
        String st = sSDPPacket.getST();
        if (st == null) {
            return false;
        }
        Device device = getDevice();
        String notifyServiceTypeNT = getNotifyServiceTypeNT();
        String notifyServiceTypeUSN = getNotifyServiceTypeUSN();
        if (ST.isAllDevice(st)) {
            device.postSearchResponse(sSDPPacket, notifyServiceTypeNT, notifyServiceTypeUSN);
        } else if (ST.isURNService(st)) {
            String serviceType = getServiceType();
            if (st.equals(serviceType)) {
                device.postSearchResponse(sSDPPacket, serviceType, notifyServiceTypeUSN);
            }
        }
        return true;
    }

    public void setActionListener(ActionListener actionListener) {
        ActionList actionList = getActionList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            actionList.getAction(i10).setActionListener(actionListener);
        }
    }

    public void setControlURL(String str) {
        getServiceNode().setNode(CONTROL_URL, str);
    }

    public void setDescriptionURL(String str) {
        getServiceData().setDescriptionURL(str);
    }

    public void setEventSubURL(String str) {
        getServiceNode().setNode(EVENT_SUB_URL, str);
    }

    public void setQueryListener(QueryListener queryListener) {
        ServiceStateTable serviceStateTable = getServiceStateTable();
        int size = serviceStateTable.size();
        for (int i10 = 0; i10 < size; i10++) {
            serviceStateTable.getStateVariable(i10).setQueryListener(queryListener);
        }
    }

    public void setSCPDURL(String str) {
        getServiceNode().setNode(SCPDURL, str);
    }

    public void setSID(String str) {
        getServiceData().setSID(str);
    }

    public void setServiceID(String str) {
        getServiceNode().setNode("serviceId", str);
    }

    public void setServiceType(String str) {
        getServiceNode().setNode(SERVICE_TYPE, str);
    }

    public void setTimeout(long j10) {
        getServiceData().setTimeout(j10);
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void unlock() {
        this.mutex.unlock();
    }

    public void updateConfigId() {
        Node sCPDNode = getSCPDNode();
        if (sCPDNode == null) {
            return;
        }
        sCPDNode.setAttribute(CONFIG_ID, UPnP.caluculateConfigId(sCPDNode.toString()));
    }

    private Node getSCPDNode(File file) {
        return UPnP.getXMLParser().parse(file);
    }

    private Node getSCPDNode() {
        Node sCPDNode;
        ServiceData serviceData = getServiceData();
        Node sCPDNode2 = serviceData.getSCPDNode();
        if (sCPDNode2 != null) {
            return sCPDNode2;
        }
        Device rootDevice = getRootDevice();
        if (rootDevice == null) {
            this.mErrorMsg = "root dev is null";
            return null;
        }
        String scpdurl = getSCPDURL();
        this.mErrorMsg = scpdurl;
        String descriptionFilePath = rootDevice.getDescriptionFilePath();
        if (descriptionFilePath != null) {
            File file = new File(descriptionFilePath.concat(scpdurl));
            if (file.exists()) {
                try {
                    sCPDNode2 = getSCPDNode(file);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (sCPDNode2 != null) {
                    serviceData.setSCPDNode(sCPDNode2);
                    return sCPDNode2;
                }
            }
        }
        try {
            sCPDNode = getSCPDNode(new URL(rootDevice.getAbsoluteURL(scpdurl)));
        } catch (Exception e11) {
            this.mErrorMsg += " getService failed " + e11.toString();
        }
        if (sCPDNode != null) {
            serviceData.setSCPDNode(sCPDNode);
            return sCPDNode;
        }
        this.mErrorMsg += "get not failed";
        try {
            return getSCPDNode(new File(rootDevice.getDescriptionFilePath() + HTTP.toRelativeURL(scpdurl)));
        } catch (Exception e12) {
            CLog.d(TAG, null, e12);
            return null;
        }
    }

    public boolean loadSCPD(File file) {
        Node parse = UPnP.getXMLParser().parse(file);
        if (parse == null) {
            return false;
        }
        getServiceData().setSCPDNode(parse);
        return true;
    }

    public boolean loadSCPD(InputStream inputStream) {
        Node parse = UPnP.getXMLParser().parse(inputStream);
        if (parse == null) {
            return false;
        }
        getServiceData().setSCPDNode(parse);
        return true;
    }

    public void notify(StateVariable stateVariable) {
        SubscriberList subscriberList = getSubscriberList();
        int size = subscriberList.size();
        Subscriber[] subscriberArr = new Subscriber[size];
        for (int i10 = 0; i10 < size; i10++) {
            subscriberArr[i10] = subscriberList.getSubscriber(i10);
        }
        for (int i11 = 0; i11 < size; i11++) {
            Subscriber subscriber = subscriberArr[i11];
            if (subscriber != null && subscriber.isExpired()) {
                removeSubscriber(subscriber);
            }
        }
        int size2 = subscriberList.size();
        Subscriber[] subscriberArr2 = new Subscriber[size2];
        for (int i12 = 0; i12 < size2; i12++) {
            subscriberArr2[i12] = subscriberList.getSubscriber(i12);
        }
        for (int i13 = 0; i13 < size2; i13++) {
            Subscriber subscriber2 = subscriberArr2[i13];
            if (subscriber2 != null) {
                notify(subscriber2, stateVariable);
            }
        }
    }

    public Service(Node node) {
        this.mutex = new Mutex();
        this.mErrorMsg = "";
        this.userData = null;
        this.serviceNode = node;
    }
}
