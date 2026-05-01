package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.TSIG;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ZoneTransferIn {
    private static final int AXFR = 6;
    private static final int END = 7;
    private static final int FIRSTDATA = 1;
    private static final int INITIALSOA = 0;
    private static final int IXFR_ADD = 5;
    private static final int IXFR_ADDSOA = 4;
    private static final int IXFR_DEL = 3;
    private static final int IXFR_DELSOA = 2;
    private SocketAddress address;
    private TCPClient client;
    private long current_serial;
    private int dclass;
    private long end_serial;
    private ZoneTransferHandler handler;
    private Record initialsoa;
    private long ixfr_serial;
    private SocketAddress localAddress;
    private int qtype;
    private int rtype;
    private int state;
    private long timeout = 900000;
    private TSIG tsig;
    private TSIG.StreamVerifier verifier;
    private boolean want_fallback;
    private Name zname;

    public static class BasicHandler implements ZoneTransferHandler {
        private List axfr;
        private List ixfr;

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ZoneTransferIn.ZoneTransferHandler
        public void handleRecord(Record record) {
            List list;
            List list2 = this.ixfr;
            if (list2 != null) {
                Delta delta = (Delta) list2.get(list2.size() - 1);
                list = delta.adds.size() > 0 ? delta.adds : delta.deletes;
            } else {
                list = this.axfr;
            }
            list.add(record);
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ZoneTransferIn.ZoneTransferHandler
        public void startAXFR() {
            this.axfr = new ArrayList();
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ZoneTransferIn.ZoneTransferHandler
        public void startIXFR() {
            this.ixfr = new ArrayList();
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRAdds(Record record) {
            Delta delta = (Delta) this.ixfr.get(r0.size() - 1);
            delta.adds.add(record);
            delta.end = ZoneTransferIn.getSOASerial(record);
        }

        @Override // com.hpplay.sdk.source.mdns.xbill.dns.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRDeletes(Record record) {
            Delta delta = new Delta();
            delta.deletes.add(record);
            delta.start = ZoneTransferIn.getSOASerial(record);
            this.ixfr.add(delta);
        }

        private BasicHandler() {
        }
    }

    public static class Delta {
        public List adds;
        public List deletes;
        public long end;
        public long start;

        private Delta() {
            this.adds = new ArrayList();
            this.deletes = new ArrayList();
        }
    }

    public interface ZoneTransferHandler {
        void handleRecord(Record record);

        void startAXFR();

        void startIXFR();

        void startIXFRAdds(Record record);

        void startIXFRDeletes(Record record);
    }

    private ZoneTransferIn() {
    }

    private void closeConnection() {
        try {
            TCPClient tCPClient = this.client;
            if (tCPClient != null) {
                tCPClient.cleanup();
            }
        } catch (IOException unused) {
        }
    }

    private void doxfr() {
        sendQuery();
        while (this.state != 7) {
            byte[] recv = this.client.recv();
            Message parseMessage = parseMessage(recv);
            if (parseMessage.getHeader().getRcode() == 0 && this.verifier != null) {
                parseMessage.getTSIG();
                if (this.verifier.verify(parseMessage, recv) != 0) {
                    fail("TSIG failure");
                }
            }
            Record[] sectionArray = parseMessage.getSectionArray(1);
            if (this.state == 0) {
                int rcode = parseMessage.getRcode();
                if (rcode != 0) {
                    if (this.qtype == 251 && rcode == 4) {
                        fallback();
                        doxfr();
                        return;
                    }
                    fail(Rcode.string(rcode));
                }
                Record question = parseMessage.getQuestion();
                if (question != null && question.getType() != this.qtype) {
                    fail("invalid question section");
                }
                if (sectionArray.length == 0 && this.qtype == 251) {
                    fallback();
                    doxfr();
                    return;
                }
            }
            for (Record record : sectionArray) {
                parseRR(record);
            }
            if (this.state == 7 && this.verifier != null && !parseMessage.isVerified()) {
                fail("last message must be signed");
            }
        }
    }

    private void fail(String str) {
        throw new Exception(str);
    }

    private void fallback() {
        if (!this.want_fallback) {
            fail("server doesn't support IXFR");
        }
        logxfr("falling back to AXFR");
        this.qtype = Type.AXFR;
        this.state = 0;
    }

    private BasicHandler getBasicHandler() {
        ZoneTransferHandler zoneTransferHandler = this.handler;
        if (zoneTransferHandler instanceof BasicHandler) {
            return (BasicHandler) zoneTransferHandler;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getSOASerial(Record record) {
        return ((SOARecord) record).getSerial();
    }

    private void logxfr(String str) {
        if (Options.check("verbose")) {
            System.out.println(this.zname + ": " + str);
        }
    }

    public static ZoneTransferIn newAXFR(Name name, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, Type.AXFR, 0L, false, socketAddress, tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j10, boolean z10, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, Type.IXFR, j10, z10, socketAddress, tsig);
    }

    private void openConnection() {
        TCPClient tCPClient = new TCPClient(System.currentTimeMillis() + this.timeout);
        this.client = tCPClient;
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            tCPClient.bind(socketAddress);
        }
        this.client.connect(this.address);
    }

    private Message parseMessage(byte[] bArr) {
        return new Message(bArr);
    }

    private void parseRR(Record record) {
        int type = record.getType();
        switch (this.state) {
            case 0:
                if (type != 6) {
                    fail("missing initial SOA");
                }
                this.initialsoa = record;
                long sOASerial = getSOASerial(record);
                this.end_serial = sOASerial;
                if (this.qtype == 251 && Serial.compare(sOASerial, this.ixfr_serial) <= 0) {
                    logxfr("up to date");
                    this.state = 7;
                    break;
                } else {
                    this.state = 1;
                    break;
                }
                break;
            case 1:
                if (this.qtype == 251 && type == 6 && getSOASerial(record) == this.ixfr_serial) {
                    this.rtype = Type.IXFR;
                    this.handler.startIXFR();
                    logxfr("got incremental response");
                    this.state = 2;
                } else {
                    this.rtype = Type.AXFR;
                    this.handler.startAXFR();
                    this.handler.handleRecord(this.initialsoa);
                    logxfr("got nonincremental response");
                    this.state = 6;
                }
                parseRR(record);
                break;
            case 2:
                this.handler.startIXFRDeletes(record);
                this.state = 3;
                break;
            case 3:
                if (type != 6) {
                    this.handler.handleRecord(record);
                    break;
                } else {
                    this.current_serial = getSOASerial(record);
                    this.state = 4;
                    parseRR(record);
                    break;
                }
            case 4:
                this.handler.startIXFRAdds(record);
                this.state = 5;
                break;
            case 5:
                if (type == 6) {
                    long sOASerial2 = getSOASerial(record);
                    if (sOASerial2 == this.end_serial) {
                        this.state = 7;
                        break;
                    } else if (sOASerial2 == this.current_serial) {
                        this.state = 2;
                        parseRR(record);
                        break;
                    } else {
                        fail("IXFR out of sync: expected serial " + this.current_serial + " , got " + sOASerial2);
                    }
                }
                this.handler.handleRecord(record);
                break;
            case 6:
                if (type != 1 || record.getDClass() == this.dclass) {
                    this.handler.handleRecord(record);
                    if (type == 6) {
                        this.state = 7;
                        break;
                    }
                }
                break;
            case 7:
                fail("extra data");
                break;
            default:
                fail("invalid state");
                break;
        }
    }

    private void sendQuery() {
        Record newRecord = Record.newRecord(this.zname, this.qtype, this.dclass);
        Message message = new Message();
        message.getHeader().setOpcode(0);
        message.addRecord(newRecord, 0);
        if (this.qtype == 251) {
            Name name = this.zname;
            int i10 = this.dclass;
            Name name2 = Name.root;
            message.addRecord(new SOARecord(name, i10, 0L, name2, name2, this.ixfr_serial, 0L, 0L, 0L, 0L), 2);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(message, null);
            this.verifier = new TSIG.StreamVerifier(this.tsig, message.getTSIG());
        }
        this.client.send(message.toWire(Message.MAXLENGTH));
    }

    public List getAXFR() {
        return getBasicHandler().axfr;
    }

    public List getIXFR() {
        return getBasicHandler().ixfr;
    }

    public Name getName() {
        return this.zname;
    }

    public int getType() {
        return this.qtype;
    }

    public boolean isAXFR() {
        return this.rtype == 252;
    }

    public boolean isCurrent() {
        BasicHandler basicHandler = getBasicHandler();
        return basicHandler.axfr == null && basicHandler.ixfr == null;
    }

    public boolean isIXFR() {
        return this.rtype == 251;
    }

    public void run(ZoneTransferHandler zoneTransferHandler) {
        this.handler = zoneTransferHandler;
        try {
            openConnection();
            doxfr();
        } finally {
            closeConnection();
        }
    }

    public void setDClass(int i10) {
        DClass.check(i10);
        this.dclass = i10;
    }

    public void setLocalAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
    }

    public void setTimeout(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.timeout = i10 * 1000;
    }

    public static ZoneTransferIn newAXFR(Name name, String str, int i10, TSIG tsig) {
        if (i10 == 0) {
            i10 = 53;
        }
        return newAXFR(name, new InetSocketAddress(str, i10), tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j10, boolean z10, String str, int i10, TSIG tsig) {
        if (i10 == 0) {
            i10 = 53;
        }
        return newIXFR(name, j10, z10, new InetSocketAddress(str, i10), tsig);
    }

    private ZoneTransferIn(Name name, int i10, long j10, boolean z10, SocketAddress socketAddress, TSIG tsig) {
        this.address = socketAddress;
        this.tsig = tsig;
        if (name.isAbsolute()) {
            this.zname = name;
        } else {
            try {
                this.zname = Name.concatenate(name, Name.root);
            } catch (Exception unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.qtype = i10;
        this.dclass = 1;
        this.ixfr_serial = j10;
        this.want_fallback = z10;
        this.state = 0;
    }

    public static ZoneTransferIn newIXFR(Name name, long j10, boolean z10, String str, TSIG tsig) {
        return newIXFR(name, j10, z10, str, 0, tsig);
    }

    public List run() {
        BasicHandler basicHandler = new BasicHandler();
        run(basicHandler);
        return basicHandler.axfr != null ? basicHandler.axfr : basicHandler.ixfr;
    }
}
