package com.hpplay.common.asyncmanager;

import android.text.TextUtils;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class AsyncFileParameter {
    public int id;
    public In in = new In();
    public Out out = new Out();

    public class In {
        public String fileUrl;
        public String id;
        public String savePath;

        public In() {
        }
    }

    public class Out {
        public long currentSize;
        public String result;
        public int resultType;
        public long totalSize;

        public Out() {
        }
    }

    public AsyncFileParameter(String str, String str2) {
        In in = this.in;
        in.fileUrl = str;
        in.savePath = str2;
        if (TextUtils.isEmpty(str2)) {
            LeLog.w("AsyncFileParameter", "savePath can not be null");
        }
    }
}
