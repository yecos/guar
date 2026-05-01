package com.hpplay.common.asyncmanager;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpResult {
    public Map<String, List<String>> headers;
    public int responseCode;
    public String result;
    public int resultType;

    public String toString() {
        return "HttpResult{resultType=" + this.resultType + ", responseCode=" + this.responseCode + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
