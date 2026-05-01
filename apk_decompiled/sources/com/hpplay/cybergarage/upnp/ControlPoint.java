package com.hpplay.cybergarage.upnp;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.http.HTTPRequestListener;
import com.hpplay.cybergarage.http.HTTPServerList;
import com.hpplay.cybergarage.net.HostInterface;
import com.hpplay.cybergarage.upnp.control.RenewSubscriber;
import com.hpplay.cybergarage.upnp.device.DeviceChangeListener;
import com.hpplay.cybergarage.upnp.device.Disposer;
import com.hpplay.cybergarage.upnp.device.NotifyListener;
import com.hpplay.cybergarage.upnp.device.ST;
import com.hpplay.cybergarage.upnp.device.SearchResponseListener;
import com.hpplay.cybergarage.upnp.device.USN;
import com.hpplay.cybergarage.upnp.event.EventListener;
import com.hpplay.cybergarage.upnp.event.NotifyRequest;
import com.hpplay.cybergarage.upnp.event.Property;
import com.hpplay.cybergarage.upnp.event.PropertyList;
import com.hpplay.cybergarage.upnp.event.SubscriptionRequest;
import com.hpplay.cybergarage.upnp.event.SubscriptionResponse;
import com.hpplay.cybergarage.upnp.ssdp.SSDPNotifySocketList;
import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;
import com.hpplay.cybergarage.upnp.ssdp.SSDPPacketHandleTask;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchRequest;
import com.hpplay.cybergarage.upnp.ssdp.SSDPSearchResponseSocketList;
import com.hpplay.cybergarage.util.ListenerList;
import com.hpplay.cybergarage.util.Mutex;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.NodeList;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class ControlPoint implements HTTPRequestListener {
    private static final int DEFAULT_EVENTSUB_PORT = 8058;
    private static final String DEFAULT_EVENTSUB_URI = "/evetSub";
    private static final int DEFAULT_EXPIRED_DEVICE_MONITORING_INTERVAL = 60;
    private static final int DEFAULT_SSDP_PORT = 8008;
    public static final int RESULT_CODE_SEND_SEARCH_DATA_FAILED = 4;
    public static final int RESULT_CODE_SEND_SEARCH_INIT_FAILED = 5;
    public static final int SUBSCIBE_SERVER_RETRY_COUNT = 10;
    private static final String TAG = "Cyber-ControlPoint";
    private String cuid;
    private final NodeList devNodeList;
    private final ReentrantReadWriteLock devNodeListLock;
    ListenerList deviceChangeListenerList;
    private Disposer deviceDisposer;
    private ListenerList deviceNotifyListenerList;
    private ListenerList deviceSearchResponseListenerList;
    private final ListenerList eventListenerList;
    private String eventSubURI;
    private long expiredDeviceMonitoringInterval;
    private int httpPort;
    private HTTPServerList httpServerList;
    private SSDPPacketHandleTask mSsdpPacketHandleTasker;
    private Mutex mutex;
    private boolean nmprMode;
    private RenewSubscriber renewSubscriber;
    private int searchMx;
    private SSDPNotifySocketList ssdpNotifySocketList;
    private int ssdpPort;
    private SSDPSearchResponseSocketList ssdpSearchResponseSocketList;
    private HashSet<String> ssdpSet;
    private Object userData;

    static {
        UPnP.initialize();
    }

    public ControlPoint(int i10, int i11, InetAddress[] inetAddressArr) {
        this.ssdpSet = new HashSet<>();
        this.mutex = new Mutex();
        this.ssdpPort = 0;
        this.httpPort = 0;
        this.devNodeList = new NodeList();
        this.devNodeListLock = new ReentrantReadWriteLock();
        this.deviceNotifyListenerList = new ListenerList();
        this.deviceSearchResponseListenerList = new ListenerList();
        this.deviceChangeListenerList = new ListenerList();
        this.searchMx = 3;
        this.httpServerList = new HTTPServerList();
        this.eventListenerList = new ListenerList();
        this.eventSubURI = DEFAULT_EVENTSUB_URI;
        this.userData = null;
        this.ssdpNotifySocketList = new SSDPNotifySocketList(inetAddressArr);
        this.ssdpSearchResponseSocketList = new SSDPSearchResponseSocketList(inetAddressArr);
        setSSDPPort(i10);
        setHTTPPort(i11);
        setDeviceDisposer(null);
        setExpiredDeviceMonitoringInterval(60L);
        setRenewSubscriber(null);
        setNMPRMode(false);
        setRenewSubscriber(null);
        UPnP.setEnable(9);
    }

    private boolean createSearchList() {
        int sSDPPort = getSSDPPort();
        SSDPSearchResponseSocketList sSDPSearchResponseSocketList = getSSDPSearchResponseSocketList();
        int nextInt = sSDPPort + new Random().nextInt(10000);
        int i10 = 0;
        while (!sSDPSearchResponseSocketList.open(nextInt)) {
            i10++;
            if (100 < i10) {
                return false;
            }
            setSSDPPort(nextInt + 1);
            nextInt = getSSDPPort();
        }
        sSDPSearchResponseSocketList.setControlPoint(this);
        sSDPSearchResponseSocketList.start();
        return true;
    }

    private String getEventSubCallbackURL(String str) {
        return HostInterface.getHostURL(str, getHTTPPort(), getEventSubURI());
    }

    private HTTPServerList getHTTPServerList() {
        return this.httpServerList;
    }

    private SSDPNotifySocketList getSSDPNotifySocketList() {
        return this.ssdpNotifySocketList;
    }

    private SSDPSearchResponseSocketList getSSDPSearchResponseSocketList() {
        return this.ssdpSearchResponseSocketList;
    }

    private void removeDevice(Node node) {
        Device device = getDevice(node);
        if (device != null && device.isRootDevice()) {
            performRemoveDeviceListener(device);
        }
        this.devNodeListLock.writeLock().lock();
        try {
            this.devNodeList.remove(node);
        } finally {
            this.devNodeListLock.writeLock().unlock();
        }
    }

    private void startSSDPPacketHandleTask() {
        SSDPPacketHandleTask sSDPPacketHandleTask = new SSDPPacketHandleTask(this);
        this.mSsdpPacketHandleTasker = sSDPPacketHandleTask;
        sSDPPacketHandleTask.start();
    }

    public void addDevice(Node node) {
        this.devNodeListLock.writeLock().lock();
        try {
            this.devNodeList.add(node);
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.devNodeListLock.writeLock().unlock();
            throw th;
        }
        this.devNodeListLock.writeLock().unlock();
    }

    public void addDeviceChangeListener(DeviceChangeListener deviceChangeListener) {
        this.deviceChangeListenerList.add(deviceChangeListener);
    }

    public void addEventListener(EventListener eventListener) {
        this.eventListenerList.add(eventListener);
    }

    public void addNotifyListener(NotifyListener notifyListener) {
        this.deviceNotifyListenerList.add(notifyListener);
    }

    public void addSearchResponseListener(SearchResponseListener searchResponseListener) {
        this.deviceSearchResponseListenerList.add(searchResponseListener);
    }

    public void callbackResultCode(int i10) {
        for (int i11 = 0; i11 < this.deviceChangeListenerList.size(); i11++) {
            try {
                ((DeviceChangeListener) this.deviceChangeListenerList.get(i11)).deviceAdded(i10, null);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
                return;
            }
        }
    }

    public void finalize() {
        stop();
    }

    public Device getDevice(Node node) {
        Node node2;
        if (node == null || (node2 = node.getNode(Device.ELEM_NAME)) == null) {
            return null;
        }
        Device device = new Device(node, node2);
        if (device.getService(ST.AV_TRANSPORT_1) == null) {
            return null;
        }
        return device;
    }

    public Disposer getDeviceDisposer() {
        return this.deviceDisposer;
    }

    public DeviceList getDeviceList() {
        this.devNodeListLock.readLock().lock();
        try {
            DeviceList deviceList = new DeviceList();
            int size = this.devNodeList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Device device = getDevice(this.devNodeList.getNode(i10));
                if (device != null) {
                    deviceList.add(device);
                }
            }
            return deviceList;
        } finally {
            this.devNodeListLock.readLock().unlock();
        }
    }

    public String getEventSubURI() {
        return this.eventSubURI;
    }

    public long getExpiredDeviceMonitoringInterval() {
        return this.expiredDeviceMonitoringInterval;
    }

    public int getHTTPPort() {
        return this.httpPort;
    }

    public RenewSubscriber getRenewSubscriber() {
        return this.renewSubscriber;
    }

    public int getSSDPPort() {
        return this.ssdpPort;
    }

    public int getSearchMx() {
        return this.searchMx;
    }

    public HashSet<String> getSsdps() {
        return this.ssdpSet;
    }

    public Service getSubscriberService(String str) {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service subscriberService = deviceList.getDevice(i10).getSubscriberService(str);
            if (subscriberService != null) {
                return subscriberService;
            }
        }
        return null;
    }

    public Object getUserData() {
        return this.userData;
    }

    public boolean hasDevice(String str) {
        return getDevice(str) != null;
    }

    @Override // com.hpplay.cybergarage.http.HTTPRequestListener
    public void httpRequestRecieved(HTTPRequest hTTPRequest) {
        try {
            hTTPRequest.print();
            if (!hTTPRequest.isNotifyRequest()) {
                hTTPRequest.returnBadRequest();
                return;
            }
            NotifyRequest notifyRequest = new NotifyRequest(hTTPRequest);
            String sid = notifyRequest.getSID();
            long seq = notifyRequest.getSEQ();
            PropertyList propertyList = notifyRequest.getPropertyList();
            if (propertyList == null) {
                hTTPRequest.returnBadRequest();
                return;
            }
            int size = propertyList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Property property = propertyList.getProperty(i10);
                performEventListener(sid, seq, property.getName(), property.getValue());
            }
            hTTPRequest.returnOK();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public boolean isNMPRMode() {
        return this.nmprMode;
    }

    public boolean isSubscribed(Service service) {
        if (service == null) {
            return false;
        }
        return service.isSubscribed();
    }

    public void lock() {
        this.mutex.lock();
    }

    public void notifyReceived(SSDPPacket sSDPPacket) {
        if (sSDPPacket.isRootDevice()) {
            if (sSDPPacket.isAlive()) {
                addDevice(sSDPPacket);
            } else if (sSDPPacket.isByeBye()) {
                removeDevice(sSDPPacket);
            }
        }
        performNotifyListener(sSDPPacket);
    }

    public void performAddDeviceListener(Device device) {
        int size = this.deviceChangeListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((DeviceChangeListener) this.deviceChangeListenerList.get(i10)).deviceAdded(device);
        }
    }

    public void performEventListener(String str, long j10, String str2, String str3) {
        try {
            int size = this.eventListenerList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((EventListener) this.eventListenerList.get(i10)).eventNotifyReceived(str, j10, str2, str3);
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void performNotifyListener(SSDPPacket sSDPPacket) {
        int size = this.deviceNotifyListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((NotifyListener) this.deviceNotifyListenerList.get(i10)).deviceNotifyReceived(sSDPPacket);
            } catch (Exception e10) {
                CLog.d(TAG, "NotifyListener returned an error:", e10);
            }
        }
    }

    public void performRemoveDeviceListener(Device device) {
        int size = this.deviceChangeListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((DeviceChangeListener) this.deviceChangeListenerList.get(i10)).deviceRemoved(device);
        }
    }

    public void performSearchResponseListener(SSDPPacket sSDPPacket) {
        int size = this.deviceSearchResponseListenerList.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ((SearchResponseListener) this.deviceSearchResponseListenerList.get(i10)).deviceSearchResponseReceived(sSDPPacket);
            } catch (Exception e10) {
                CLog.d(TAG, "SearchResponseListener returned an error:", e10);
            }
        }
    }

    public void print() {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        CLog.d(TAG, "Device Num = " + size);
        for (int i10 = 0; i10 < size; i10++) {
            Device device = deviceList.getDevice(i10);
            CLog.d(TAG, "[" + i10 + "] " + device.getFriendlyName() + ", " + device.getLeaseTime() + ", " + device.getElapsedTime());
        }
    }

    public synchronized void release() {
        stop();
    }

    public void removeDeviceChangeListener(DeviceChangeListener deviceChangeListener) {
        this.deviceChangeListenerList.remove(deviceChangeListener);
    }

    public void removeEventListener(EventListener eventListener) {
        this.eventListenerList.remove(eventListener);
        if (this.eventListenerList.size() > 1) {
            this.eventListenerList.clear();
        }
    }

    public void removeExpiredDevices() {
        stopNotifySocket();
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        Device[] deviceArr = new Device[size];
        for (int i10 = 0; i10 < size; i10++) {
            deviceArr[i10] = deviceList.getDevice(i10);
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (deviceArr[i11].isExpired()) {
                CLog.d(TAG, "Expired device = " + deviceArr[i11].getFriendlyName());
                removeDevice(deviceArr[i11]);
            }
        }
    }

    public void removeNotifyListener(NotifyListener notifyListener) {
        this.deviceNotifyListenerList.remove(notifyListener);
    }

    public void removeSearchResponseListener(SearchResponseListener searchResponseListener) {
        this.deviceSearchResponseListenerList.remove(searchResponseListener);
    }

    public void renewSubscriberService(Device device, long j10) {
        ServiceList serviceList = device.getServiceList();
        int size = serviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Service service = serviceList.getService(i10);
            if (service.isSubscribed() && !subscribe(service, service.getSID(), j10)) {
                subscribe(service, j10);
            }
        }
        DeviceList deviceList = device.getDeviceList();
        int size2 = deviceList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            renewSubscriberService(deviceList.getDevice(i11), j10);
        }
    }

    public void search(String str, int i10) {
        SSDPSearchRequest sSDPSearchRequest = new SSDPSearchRequest(str, i10, this.cuid);
        sSDPSearchRequest.print();
        SSDPSearchResponseSocketList sSDPSearchResponseSocketList = getSSDPSearchResponseSocketList();
        if (!sSDPSearchResponseSocketList.post(sSDPSearchRequest) && this.deviceChangeListenerList != null) {
            callbackResultCode(4);
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        SSDPSearchRequest sSDPSearchRequest2 = new SSDPSearchRequest(ST.MEDIA_RENDER, i10, this.cuid);
        sSDPSearchRequest2.print();
        sSDPSearchResponseSocketList.post(sSDPSearchRequest2);
    }

    public void searchResponseReceived(SSDPPacket sSDPPacket) {
        if (sSDPPacket.isRootDevice()) {
            addDevice(sSDPPacket);
        }
        performSearchResponseListener(sSDPPacket);
    }

    public void setDeviceDisposer(Disposer disposer) {
        this.deviceDisposer = disposer;
    }

    public void setEventSubURI(String str) {
        this.eventSubURI = str;
    }

    public void setExpiredDeviceMonitoringInterval(long j10) {
        this.expiredDeviceMonitoringInterval = j10;
    }

    public void setHTTPPort(int i10) {
        this.httpPort = i10;
    }

    public void setNMPRMode(boolean z10) {
        this.nmprMode = z10;
    }

    public void setRenewSubscriber(RenewSubscriber renewSubscriber) {
        this.renewSubscriber = renewSubscriber;
    }

    public void setSSDPPort(int i10) {
        this.ssdpPort = i10;
    }

    public void setSearchMx(int i10) {
        this.searchMx = i10;
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public boolean start(String str, int i10) {
        stop();
        startSSDPPacketHandleTask();
        SSDPNotifySocketList sSDPNotifySocketList = getSSDPNotifySocketList();
        if (!sSDPNotifySocketList.open()) {
            return false;
        }
        sSDPNotifySocketList.setControlPoint(this);
        sSDPNotifySocketList.start();
        createSearchList();
        search(str, i10);
        Disposer disposer = new Disposer(this);
        setDeviceDisposer(disposer);
        disposer.start();
        if (!isNMPRMode()) {
            return true;
        }
        RenewSubscriber renewSubscriber = new RenewSubscriber(this);
        setRenewSubscriber(renewSubscriber);
        renewSubscriber.start();
        return true;
    }

    public boolean startSucribeServ() {
        HTTPServerList hTTPServerList = getHTTPServerList();
        if (hTTPServerList.isRuning()) {
            CLog.d(TAG, "server is started");
            return true;
        }
        int hTTPPort = getHTTPPort();
        int i10 = 0;
        while (!hTTPServerList.open(hTTPPort)) {
            i10++;
            if (10 < i10) {
                return false;
            }
            setHTTPPort(hTTPPort + 1);
            hTTPPort = getHTTPPort();
        }
        hTTPServerList.addRequestListener(this);
        hTTPServerList.start();
        return true;
    }

    public boolean stop() {
        SSDPPacketHandleTask sSDPPacketHandleTask = this.mSsdpPacketHandleTasker;
        if (sSDPPacketHandleTask != null) {
            sSDPPacketHandleTask.release();
            this.mSsdpPacketHandleTasker = null;
        }
        unsubscribe();
        stopNotifySocket();
        SSDPSearchResponseSocketList sSDPSearchResponseSocketList = getSSDPSearchResponseSocketList();
        sSDPSearchResponseSocketList.stop();
        sSDPSearchResponseSocketList.close();
        sSDPSearchResponseSocketList.clear();
        HTTPServerList hTTPServerList = getHTTPServerList();
        hTTPServerList.stop();
        hTTPServerList.close();
        hTTPServerList.clear();
        Disposer deviceDisposer = getDeviceDisposer();
        if (deviceDisposer != null) {
            deviceDisposer.stop();
            setDeviceDisposer(null);
        }
        RenewSubscriber renewSubscriber = getRenewSubscriber();
        if (renewSubscriber == null) {
            return true;
        }
        renewSubscriber.stop();
        setRenewSubscriber(null);
        return true;
    }

    public void stopNotifySocket() {
        SSDPNotifySocketList sSDPNotifySocketList = getSSDPNotifySocketList();
        if (sSDPNotifySocketList.isRuning()) {
            sSDPNotifySocketList.stop();
            sSDPNotifySocketList.close();
            sSDPNotifySocketList.clear();
        }
    }

    public boolean stopSearch() {
        SSDPNotifySocketList sSDPNotifySocketList = getSSDPNotifySocketList();
        sSDPNotifySocketList.stop();
        sSDPNotifySocketList.close();
        sSDPNotifySocketList.clear();
        SSDPSearchResponseSocketList sSDPSearchResponseSocketList = getSSDPSearchResponseSocketList();
        sSDPSearchResponseSocketList.stop();
        sSDPSearchResponseSocketList.close();
        sSDPSearchResponseSocketList.clear();
        Disposer deviceDisposer = getDeviceDisposer();
        if (deviceDisposer == null) {
            return true;
        }
        deviceDisposer.stop();
        setDeviceDisposer(null);
        return true;
    }

    public boolean subscribe(Service service, long j10) {
        if (service.isSubscribed()) {
            return subscribe(service, service.getSID(), j10);
        }
        Device rootDevice = service.getRootDevice();
        if (rootDevice == null) {
            return false;
        }
        rootDevice.getInterfaceAddress();
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        subscriptionRequest.setSubscribeRequest(service, getEventSubCallbackURL(HostInterface.getIPv4Address()), j10);
        SubscriptionResponse post = subscriptionRequest.post();
        if (!post.isSuccessful()) {
            service.clearSID();
            return false;
        }
        service.setSID(post.getSID());
        service.setTimeout(post.getTimeout());
        return true;
    }

    public void unlock() {
        this.mutex.unlock();
    }

    public boolean unsubscribe(Service service) {
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        subscriptionRequest.setUnsubscribeRequest(service);
        if (!subscriptionRequest.post().isSuccessful()) {
            return false;
        }
        service.clearSID();
        return true;
    }

    public Device getDevice(String str) {
        this.devNodeListLock.readLock().lock();
        try {
            int size = this.devNodeList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Device device = getDevice(this.devNodeList.getNode(i10));
                if (device != null && (device.isDevice(str) || (device = device.getDevice(str)) != null)) {
                    return device;
                }
            }
            return null;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return null;
        } finally {
            this.devNodeListLock.readLock().unlock();
        }
    }

    private synchronized void addDevice(SSDPPacket sSDPPacket) {
        SSDPPacketHandleTask sSDPPacketHandleTask = this.mSsdpPacketHandleTasker;
        if (sSDPPacketHandleTask != null && !sSDPPacketHandleTask.isQuit()) {
            this.mSsdpPacketHandleTasker.updateSSDPPacket(sSDPPacket);
        } else {
            startSSDPPacketHandleTask();
            SSDPPacketHandleTask sSDPPacketHandleTask2 = this.mSsdpPacketHandleTasker;
            if (sSDPPacketHandleTask2 != null) {
                sSDPPacketHandleTask2.updateSSDPPacket(sSDPPacket);
            }
        }
        this.ssdpSet.add(sSDPPacket.toString());
    }

    public void unsubscribe(Device device) {
        if (device != null) {
            try {
                ServiceList serviceList = device.getServiceList();
                int size = serviceList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Service service = serviceList.getService(i10);
                    if (service.hasSID()) {
                        unsubscribe(service);
                    }
                }
                DeviceList deviceList = device.getDeviceList();
                int size2 = deviceList.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    unsubscribe(deviceList.getDevice(i11));
                }
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
    }

    public void removeDevice(Device device) {
        if (device == null) {
            return;
        }
        removeDevice(device.getRootNode());
    }

    public void removeDevice(String str) {
        removeDevice(getDevice(str));
    }

    private void removeDevice(SSDPPacket sSDPPacket) {
        if (sSDPPacket.isByeBye()) {
            removeDevice(USN.getUDN(sSDPPacket.getUSN()));
        }
    }

    public void renewSubscriberService(long j10) {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            renewSubscriberService(deviceList.getDevice(i10), j10);
        }
    }

    public void search(String str) {
        search(str, 3);
    }

    public void search() {
        search("upnp:rootdevice", 3);
    }

    public boolean subscribe(Service service) {
        if (!subscribe(service, -1L)) {
            return false;
        }
        startSucribeServ();
        return true;
    }

    public boolean subscribe(Service service, String str, long j10) {
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        subscriptionRequest.setRenewRequest(service, str, j10);
        subscriptionRequest.print();
        SubscriptionResponse post = subscriptionRequest.post();
        post.print();
        if (post.isSuccessful()) {
            service.setSID(post.getSID());
            service.setTimeout(post.getTimeout());
            return true;
        }
        service.clearSID();
        return false;
    }

    public void renewSubscriberService() {
        renewSubscriberService(-1L);
    }

    public boolean start(String str) {
        return start(str, 3);
    }

    public void unsubscribe() {
        DeviceList deviceList = getDeviceList();
        int size = deviceList.size();
        for (int i10 = 0; i10 < size; i10++) {
            unsubscribe(deviceList.getDevice(i10));
        }
    }

    public boolean start() {
        return start("upnp:rootdevice", 3);
    }

    public boolean subscribe(Service service, String str) {
        return subscribe(service, str, -1L);
    }

    public ControlPoint(int i10, int i11) {
        this(i10, i11, null);
    }

    public ControlPoint(String str) {
        this(DEFAULT_SSDP_PORT, DEFAULT_EVENTSUB_PORT);
        this.cuid = str;
    }
}
