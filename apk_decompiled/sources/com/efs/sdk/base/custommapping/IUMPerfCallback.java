package com.efs.sdk.base.custommapping;

/* loaded from: classes.dex */
public interface IUMPerfCallback {

    public enum PerfType {
        PERF_TYPE_START(1),
        PERF_TYPE_POWER(2);

        int mType;

        PerfType(int i10) {
            this.mType = i10;
        }

        public final int getType() {
            return this.mType;
        }
    }

    void onCallback(PerfType perfType);
}
