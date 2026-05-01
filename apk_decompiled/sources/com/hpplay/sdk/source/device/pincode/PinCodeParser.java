package com.hpplay.sdk.source.device.pincode;

import android.content.Context;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.Feature;

/* loaded from: classes3.dex */
public class PinCodeParser implements CodeParser {
    private final String TAG = "PinCodeParser";
    private CodeParser mCodeParser;

    public PinCodeParser(Context context) {
        if (this.mCodeParser != null) {
            SourceLog.i("PinCodeParser", "PinCodeParser is initiated");
        } else if (Feature.isConferenceSDK()) {
            this.mCodeParser = new ConferenceCodeParser();
        } else {
            this.mCodeParser = new LelinkCodeParser(context);
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void parsePinCode(PinCodeInfo pinCodeInfo) {
        CodeParser codeParser = this.mCodeParser;
        if (codeParser != null) {
            codeParser.parsePinCode(pinCodeInfo);
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void release() {
        CodeParser codeParser = this.mCodeParser;
        if (codeParser != null) {
            codeParser.release();
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void setCodeCallback(IServiceInfoParseListener iServiceInfoParseListener) {
        CodeParser codeParser = this.mCodeParser;
        if (codeParser != null) {
            codeParser.setCodeCallback(iServiceInfoParseListener);
        }
    }

    @Override // com.hpplay.sdk.source.device.pincode.CodeParser
    public void setConferenceFuzzyMatchingPinCodeCallback(IConferenceFuzzyMatchingPinCodeListener iConferenceFuzzyMatchingPinCodeListener) {
        CodeParser codeParser = this.mCodeParser;
        if (codeParser != null) {
            codeParser.setConferenceFuzzyMatchingPinCodeCallback(iConferenceFuzzyMatchingPinCodeListener);
        }
    }
}
