package com.hpplay.component.common.sonic;

import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.protocol.ProtocolListener;

/* loaded from: classes2.dex */
public interface ISonicController {
    void startSonicBrowse(IBrowseResultListener iBrowseResultListener, int... iArr);

    void startSonicPublish(ProtocolListener protocolListener, String str, int... iArr);

    void stop();
}
