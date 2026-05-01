package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import java.util.Map;

/* loaded from: classes2.dex */
public class AsyncUploadFileParameter {
    public int id;
    private final String TAG = "AsyncUploadFileParameter";
    public In in = new In();
    public Out out = new Out();

    public class In {
        public Map<String, String> headParameter;
        public HttpMethod httpMethod;
        public String id;
        public String[] localPath;
        public Class resultClass = String.class;
        public String url;

        public In() {
        }
    }

    public class Out {
        private Object result;
        public int resultType;

        public Out() {
        }

        public <T> T getResult() {
            try {
                return (T) AsyncUploadFileParameter.this.in.resultClass.cast(this.result);
            } catch (Exception e10) {
                LeLog.w("AsyncUploadFileParameter", e10);
                return null;
            }
        }

        public void setResult(Object obj) {
            this.result = obj;
        }
    }

    public AsyncUploadFileParameter(String str, String[] strArr, Map<String, String> map) {
        In in = this.in;
        in.url = str;
        in.localPath = strArr;
        in.headParameter = map;
        if (TextUtils.isEmpty(str)) {
            LeLog.w("AsyncUploadFileParameter", "savePath can not be null");
        }
    }
}
