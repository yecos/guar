package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class PosterList implements Serializable {
    private String channelCode;
    private String fileType;
    private String fileUrl;
    private String name;
    private String size;

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String toString() {
        return "PosterList{name='" + this.name + "', fileType='" + this.fileType + "', fileUrl='" + this.fileUrl + "', size='" + this.size + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
