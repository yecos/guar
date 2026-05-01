package com.hpplay.sdk.source.mdns.xbill.dns;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class ResolverConfig {
    private static final String TAG = "ResolverConfig";
    private static ResolverConfig currentConfig;
    private String[] servers = null;
    private Name[] searchlist = null;
    private int ndots = -1;

    static {
        refresh();
    }

    public ResolverConfig() {
        findAndroid();
    }

    private void addSearch(String str, List list) {
        if (Options.check("verbose")) {
            System.out.println("adding search " + str);
        }
        try {
            Name fromString = Name.fromString(str, Name.root);
            if (list.contains(fromString)) {
                return;
            }
            list.add(fromString);
        } catch (Exception unused) {
        }
    }

    private void addServer(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        if (Options.check("verbose")) {
            System.out.println("adding server " + str);
        }
        list.add(str);
    }

    private void configureFromLists(List list, List list2) {
        if (this.servers == null && list.size() > 0) {
            this.servers = (String[]) list.toArray(new String[0]);
        }
        if (this.searchlist != null || list2.size() <= 0) {
            return;
        }
        this.searchlist = (Name[]) list2.toArray(new Name[0]);
    }

    private void configureNdots(int i10) {
        if (this.ndots >= 0 || i10 <= 0) {
            return;
        }
        this.ndots = i10;
    }

    private void findAndroid() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i10 = 0; i10 < 4; i10++) {
                String str = (String) method.invoke(null, strArr[i10]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("config + ");
            sb.append(e10.toString());
        }
        configureFromLists(arrayList, arrayList2);
    }

    private boolean findProperty() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                addServer(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                addSearch(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        configureFromLists(arrayList, arrayList2);
        return (this.servers == null || this.searchlist == null) ? false : true;
    }

    public static synchronized ResolverConfig getCurrentConfig() {
        ResolverConfig resolverConfig;
        synchronized (ResolverConfig.class) {
            resolverConfig = currentConfig;
        }
        return resolverConfig;
    }

    public static void refresh() {
        ResolverConfig resolverConfig = new ResolverConfig();
        synchronized (ResolverConfig.class) {
            currentConfig = resolverConfig;
        }
    }

    public int ndots() {
        int i10 = this.ndots;
        if (i10 < 0) {
            return 1;
        }
        return i10;
    }

    public Name[] searchPath() {
        return this.searchlist;
    }

    public String server() {
        String[] strArr = this.servers;
        if (strArr == null) {
            return null;
        }
        return strArr[0];
    }

    public String[] servers() {
        return this.servers;
    }
}
