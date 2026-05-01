package com.hpplay.component.browse;

import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.browse.IBrowser;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrowseController implements IBrowser {
    private static final String TAG = "BrowseController";
    private static int mType = 3;
    private IBrowseResultListener mBrowseResultListener;
    private DLNABrowse mDlnaBrowse;
    private LelinkBrowse mLelinkBrowse = new LelinkBrowse();
    private WifiManager.MulticastLock mLock;
    private MDNSBrowse mMdnsBrowse;

    public BrowseController() {
        CLog.w(TAG, "create BrowseController");
        try {
            this.mBrowseResultListener = (IBrowseResultListener) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DEVICEADJUSTER_GETBROWSERESULTLISTENER, new Object[0]);
        } catch (Exception unused) {
            CLog.w(TAG, "BROWSE INFOS POOL MANAGER load failed");
        }
    }

    private void createMulticastLock() {
        try {
            WifiManager wifiManager = (WifiManager) ModuleLinker.getInstance().getContext().getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                WifiManager.MulticastLock createMulticastLock = wifiManager.createMulticastLock(TAG);
                this.mLock = createMulticastLock;
                createMulticastLock.setReferenceCounted(false);
                this.mLock.acquire();
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    private void release() {
        try {
            WifiManager.MulticastLock multicastLock = this.mLock;
            if (multicastLock == null || !multicastLock.isHeld()) {
                return;
            }
            this.mLock.release();
            this.mLock = null;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void createNewBrowse(int i10, IBrowseResultListener iBrowseResultListener) {
        if (i10 == 2) {
            DLNABrowse dLNABrowse = new DLNABrowse();
            this.mDlnaBrowse = dLNABrowse;
            dLNABrowse.startBrowse(iBrowseResultListener);
            return;
        }
        if (i10 == 1) {
            MDNSBrowse mDNSBrowse = new MDNSBrowse();
            this.mMdnsBrowse = mDNSBrowse;
            mDNSBrowse.startBrowse(iBrowseResultListener);
            LelinkBrowse lelinkBrowse = this.mLelinkBrowse;
            if (lelinkBrowse != null) {
                lelinkBrowse.release();
            }
            LelinkBrowse lelinkBrowse2 = this.mLelinkBrowse;
            if (lelinkBrowse2 != null) {
                lelinkBrowse2.startBrowse(iBrowseResultListener);
                return;
            }
            return;
        }
        DLNABrowse dLNABrowse2 = new DLNABrowse();
        this.mDlnaBrowse = dLNABrowse2;
        dLNABrowse2.startBrowse(iBrowseResultListener);
        MDNSBrowse mDNSBrowse2 = new MDNSBrowse();
        this.mMdnsBrowse = mDNSBrowse2;
        mDNSBrowse2.startBrowse(iBrowseResultListener);
        LelinkBrowse lelinkBrowse3 = this.mLelinkBrowse;
        if (lelinkBrowse3 != null) {
            lelinkBrowse3.release();
        }
        LelinkBrowse lelinkBrowse4 = this.mLelinkBrowse;
        if (lelinkBrowse4 != null) {
            lelinkBrowse4.startBrowse(iBrowseResultListener);
        }
    }

    @Override // com.hpplay.component.common.browse.IBrowser
    public String getBrowseErrorMsg() {
        boolean z10;
        JSONObject jSONObject = new JSONObject();
        DLNABrowse dLNABrowse = this.mDlnaBrowse;
        boolean z11 = true;
        if (dLNABrowse == null || TextUtils.isEmpty(dLNABrowse.getErrorMsg())) {
            z10 = false;
        } else {
            try {
                CLog.i(TAG, this.mDlnaBrowse.getErrorMsg());
                jSONObject.put("dlna", this.mDlnaBrowse.getErrorMsg());
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
            z10 = true;
        }
        MDNSBrowse mDNSBrowse = this.mMdnsBrowse;
        if (mDNSBrowse == null || TextUtils.isEmpty(mDNSBrowse.getErrorMsg())) {
            z11 = z10;
        } else {
            try {
                CLog.i(TAG, this.mMdnsBrowse.getErrorMsg());
                jSONObject.put("mdns", this.mMdnsBrowse.getErrorMsg());
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
        if (z11) {
            return jSONObject.toString();
        }
        return null;
    }

    @Override // com.hpplay.component.common.browse.IBrowser
    public void startBrowse(int i10, IBrowseResultListener iBrowseResultListener) {
        createMulticastLock();
        mType = i10;
        IBrowseResultListener iBrowseResultListener2 = this.mBrowseResultListener;
        if (iBrowseResultListener2 != null) {
            try {
                ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DEVICEADJUSTER_SETBROWSEINFOSPOOLLISTENER, iBrowseResultListener);
            } catch (Exception unused) {
                CLog.w(TAG, "BROWSE INFOS POOL set browse listener failed");
            }
            iBrowseResultListener = iBrowseResultListener2;
        }
        createNewBrowse(i10, iBrowseResultListener);
    }

    @Override // com.hpplay.component.common.browse.IBrowser
    public void stopBrowse() {
        release();
        if (this.mDlnaBrowse != null) {
            CLog.i(TAG, " ============ > stop browse ");
            this.mDlnaBrowse.release();
        }
        if (this.mLelinkBrowse != null) {
            CLog.i(TAG, " ============ > stop  LelinkBrowse ");
            this.mLelinkBrowse.release();
        }
        MDNSBrowse mDNSBrowse = this.mMdnsBrowse;
        if (mDNSBrowse != null) {
            mDNSBrowse.release();
        }
        CLog.i(TAG, " ============ > stopped ");
    }

    @Override // com.hpplay.component.common.browse.IBrowser
    public void startBrowse(int i10) {
        createNewBrowse(i10, this.mBrowseResultListener);
    }
}
