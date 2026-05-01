package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import com.umeng.analytics.pro.by;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AsyncHttpParameter {
    public static final int DEFAULT_SPACE = 0;
    public static final int DEFAULT_TRY_COUNT = 3;
    private final String TAG;
    public int id;
    public In in;
    public Out out;

    public class In {
        public String id;
        public Map<String, String> requestHeaders;
        public String requestUrl;
        public String params = "";
        public int requestMethod = 0;
        public int connectTimeout = by.f10132b;
        public int readTimeout = by.f10132b;
        public int tryCount = 3;
        public int trySpace = 0;

        public In() {
        }
    }

    public class Out {
        public Map<String, List<String>> headers;
        public int requestTryCount;
        public int responseCode = -1;
        public String result;
        public int resultType;

        public Out() {
        }
    }

    public AsyncHttpParameter(String str, String str2) {
        this(str, str2, 3);
    }

    public AsyncHttpParameter(String str, String str2, int i10) {
        this.TAG = "AsyncHttpParameter";
        if (i10 <= 0) {
            LeLog.w("AsyncHttpParameter", "tryCount must bigger than 0,use default value");
            i10 = 3;
        }
        this.in = new In();
        this.out = new Out();
        In in = this.in;
        in.requestUrl = str;
        in.tryCount = i10;
        if (TextUtils.isEmpty(str2)) {
            this.in.params = "";
        } else {
            this.in.params = str2;
        }
    }
}
