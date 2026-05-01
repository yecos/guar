package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class ServiceRecodSorter implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (!(obj instanceof Record) || !(obj2 instanceof Record)) {
            return -1;
        }
        int type = ((Record) obj).getType();
        int type2 = ((Record) obj2).getType();
        if (type != 1) {
            if (type == 12) {
                if (type2 != 12) {
                    return type2 != 33 ? -1 : 1;
                }
                return 0;
            }
            if (type == 16) {
                if (type2 != 12) {
                    if (type2 == 16) {
                        return 0;
                    }
                    if (type2 != 33) {
                        return -1;
                    }
                }
                return 1;
            }
            if (type != 28) {
                if (type == 33) {
                    return type2 == 33 ? 0 : -1;
                }
                if (type != 47) {
                    return -1;
                }
                if (type2 == 1 || type2 == 12 || type2 == 16 || type2 == 28 || type2 == 33) {
                    return 1;
                }
                return type2 != 47 ? -1 : 0;
            }
        }
        if (type2 != 1) {
            if (type2 != 12 && type2 != 16) {
                if (type2 != 28) {
                    if (type2 != 33) {
                        return -1;
                    }
                }
            }
            return 1;
        }
        return 0;
    }
}
