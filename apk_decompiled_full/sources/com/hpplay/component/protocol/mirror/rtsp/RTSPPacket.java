package com.hpplay.component.protocol.mirror.rtsp;

import com.hpplay.component.common.utils.CLog;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class RTSPPacket {
    private String rawPacket;
    private String rtspVersion;
    private int contentlenth = 0;
    private Vector<String> headers = new Vector<>();
    private Vector<String> headerContent = new Vector<>();
    private ByteBuffer bf = ByteBuffer.allocate(1024);

    public int getCode() {
        return 200;
    }

    public String getContent() {
        if (this.contentlenth == 0) {
            return null;
        }
        try {
            return new String(this.bf.array(), 0, this.contentlenth);
        } catch (Exception e10) {
            CLog.w("rtspacket", e10);
            return "";
        }
    }

    public String getVersion() {
        return this.rtspVersion;
    }

    public void parseRTSPPacket(String str, byte[] bArr, int i10) {
        this.headers.clear();
        this.headerContent.clear();
        this.rawPacket = str;
        if (bArr == null) {
            this.contentlenth = 0;
        }
        Matcher matcher = Pattern.compile("^(\\w+)\\W(.+)\\WRTSP/(.+)\r\n").matcher(str);
        if (matcher.find()) {
            this.rtspVersion = matcher.group(3).trim();
        }
        Matcher matcher2 = Pattern.compile("^([\\w-]+):\\W(.+)\r\n", 8).matcher(str);
        while (matcher2.find()) {
            this.headers.add(matcher2.group(1));
            this.headerContent.add(matcher2.group(2));
        }
    }

    public String toString() {
        String str = this.rawPacket;
        return str == null ? "" : str.toString();
    }

    public String valueOfHeader(String str) {
        int indexOf = this.headers.indexOf(str);
        if (indexOf == -1) {
            return null;
        }
        return this.headerContent.elementAt(indexOf);
    }
}
