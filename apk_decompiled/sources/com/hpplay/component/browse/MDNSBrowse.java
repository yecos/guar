package com.hpplay.component.browse;

import com.hpplay.component.adjuster.DeviceAdjuster;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.sdk.source.mdns.Browse;
import com.hpplay.sdk.source.mdns.DNSSDListener;
import com.hpplay.sdk.source.mdns.ServiceInstance;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MDNSBrowse {
    private static final String LELINK_DNS_TYPE = "_leboremote._tcp.local.";
    public static final String TAG = "MDNSBrowse";
    private Browse mBrowse;
    private IBrowseResultListener mListener;

    public class MDNSListener implements DNSSDListener {
        private IBrowseResultListener mListener;

        @Override // com.hpplay.sdk.source.mdns.DNSSDListener
        public void handleException(Object obj, Exception exc) {
            if ((exc instanceof IOException) && "no route to host".equalsIgnoreCase(exc.getMessage())) {
                return;
            }
            CLog.w("MDNSBrowse", exc);
            MDNSBrowse.this.release();
        }

        @Override // com.hpplay.sdk.source.mdns.DNSSDListener
        public void receiveMessage(Object obj, Message message) {
        }

        @Override // com.hpplay.sdk.source.mdns.DNSSDListener
        public void serviceDiscovered(Object obj, ServiceInstance serviceInstance) {
            Map textAttributes = serviceInstance.getTextAttributes();
            if (textAttributes == null || this.mListener == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(textAttributes);
                jSONObject.put(DeviceAdjuster.KEY_DEVICE_NAME, serviceInstance.getName().getInstance());
                jSONObject.put(DeviceAdjuster.KEY_DEVICE_IP, serviceInstance.getAddresses()[0].getHostAddress());
                CLog.i("MDNSBrowse", serviceInstance.getName().getInstance());
                this.mListener.onBrowseResultCallback(2, jSONObject);
            } catch (Exception e10) {
                CLog.w("MDNSBrowse", e10);
            }
        }

        @Override // com.hpplay.sdk.source.mdns.DNSSDListener
        public void serviceRemoved(Object obj, ServiceInstance serviceInstance) {
            CLog.d("MDNSBrowse", "Service Removed - " + serviceInstance);
        }

        private MDNSListener(IBrowseResultListener iBrowseResultListener) {
            this.mListener = iBrowseResultListener;
        }
    }

    private void mdnsClose() {
        try {
            Browse browse = this.mBrowse;
            if (browse != null) {
                browse.close();
            }
        } catch (Exception e10) {
            CLog.w("MDNSBrowse", e10);
        }
        this.mBrowse = null;
    }

    public String getErrorMsg() {
        Browse browse = this.mBrowse;
        if (browse != null) {
            return browse.getErrorMsg();
        }
        return null;
    }

    public void release() {
        mdnsClose();
        if (this.mListener != null) {
            this.mListener = null;
        }
    }

    public void startBrowse(IBrowseResultListener iBrowseResultListener) {
        try {
            this.mListener = iBrowseResultListener;
            if (this.mBrowse == null) {
                CLog.i("MDNSBrowse", "create new mdns service");
                this.mBrowse = new Browse(LELINK_DNS_TYPE);
            } else {
                CLog.i("MDNSBrowse", "use old mdns service");
            }
            this.mBrowse.start(new MDNSListener(this.mListener));
        } catch (Exception e10) {
            CLog.w("MDNSBrowse", e10);
        }
    }
}
