package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes.dex */
class StrategyList implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private List<IPConnStrategy> f4164a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, ConnHistoryItem> f4165b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4166c;

    /* renamed from: d, reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f4167d;

    public interface Predicate<T> {
        boolean apply(T t10);
    }

    public StrategyList() {
        this.f4164a = new ArrayList();
        this.f4165b = new SerialLruCache(40);
        this.f4166c = false;
        this.f4167d = null;
    }

    public void checkInit() {
        if (this.f4164a == null) {
            this.f4164a = new ArrayList();
        }
        if (this.f4165b == null) {
            this.f4165b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f4165b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.f4164a) {
            if (!this.f4165b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.f4165b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f4164a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f4164a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.f4164a) {
            ConnHistoryItem connHistoryItem = this.f4165b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.i("awcn.StrategyList", "strategy ban!", null, Constants.KEY_STRATEGY, iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(iConnStrategy instanceof IPConnStrategy) || this.f4164a.indexOf(iConnStrategy) == -1) {
            return;
        }
        this.f4165b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
        Collections.sort(this.f4164a, this.f4167d);
    }

    public boolean shouldRefresh() {
        boolean z10 = true;
        boolean z11 = true;
        for (IPConnStrategy iPConnStrategy : this.f4164a) {
            if (!this.f4165b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).b()) {
                if (iPConnStrategy.f4144a == 0) {
                    z10 = false;
                }
                z11 = false;
            }
        }
        return (this.f4166c && z10) || z11;
    }

    public String toString() {
        return new ArrayList(this.f4164a).toString();
    }

    public void update(l.b bVar) {
        Iterator<IPConnStrategy> it = this.f4164a.iterator();
        while (it.hasNext()) {
            it.next().f4146c = true;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bVar.f4229h.length; i11++) {
            int i12 = 0;
            while (true) {
                String[] strArr = bVar.f4227f;
                if (i12 >= strArr.length) {
                    break;
                }
                a(strArr[i12], 1, bVar.f4229h[i11]);
                i12++;
            }
            if (bVar.f4228g != null) {
                this.f4166c = true;
                int i13 = 0;
                while (true) {
                    String[] strArr2 = bVar.f4228g;
                    if (i13 < strArr2.length) {
                        a(strArr2[i13], 0, bVar.f4229h[i11]);
                        i13++;
                    }
                }
            } else {
                this.f4166c = false;
            }
        }
        if (bVar.f4230i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f4230i;
                if (i10 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i10];
                String str = eVar.f4244a;
                a(str, anet.channel.strategy.utils.d.c(str) ? -1 : 1, eVar.f4245b);
                i10++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f4164a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f4146c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f4164a, a());
    }

    private void a(String str, int i10, l.a aVar) {
        int a10 = a(this.f4164a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (a10 != -1) {
            IPConnStrategy iPConnStrategy = this.f4164a.get(a10);
            iPConnStrategy.cto = aVar.f4216c;
            iPConnStrategy.rto = aVar.f4217d;
            iPConnStrategy.heartbeat = aVar.f4219f;
            iPConnStrategy.f4144a = i10;
            iPConnStrategy.f4145b = 0;
            iPConnStrategy.f4146c = false;
            return;
        }
        IPConnStrategy a11 = IPConnStrategy.a(str, aVar);
        if (a11 != null) {
            a11.f4144a = i10;
            a11.f4145b = 0;
            if (!this.f4165b.containsKey(Integer.valueOf(a11.getUniqueId()))) {
                this.f4165b.put(Integer.valueOf(a11.getUniqueId()), new ConnHistoryItem());
            }
            this.f4164a.add(a11);
        }
    }

    public StrategyList(List<IPConnStrategy> list) {
        this.f4164a = new ArrayList();
        this.f4165b = new SerialLruCache(40);
        this.f4166c = false;
        this.f4167d = null;
        this.f4164a = list;
    }

    private Comparator a() {
        if (this.f4167d == null) {
            this.f4167d = new k(this);
        }
        return this.f4167d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        Iterator<T> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext() && !predicate.apply(it.next())) {
            i10++;
        }
        if (i10 == collection.size()) {
            return -1;
        }
        return i10;
    }
}
