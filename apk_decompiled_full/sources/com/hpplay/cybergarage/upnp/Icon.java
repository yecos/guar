package com.hpplay.cybergarage.upnp;

import com.hpplay.cybergarage.xml.Node;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class Icon {
    private static final String DEPTH = "depth";
    public static final String ELEM_NAME = "icon";
    private static final String HEIGHT = "height";
    private static final String MIME_TYPE = "mimetype";
    private static final String URL = "url";
    private static final String WIDTH = "width";
    private byte[] bytes;
    private Node iconNode;
    private Object userData;

    public Icon(Node node) {
        this.userData = null;
        this.bytes = null;
        this.iconNode = node;
    }

    public static boolean isIconNode(Node node) {
        return ELEM_NAME.equals(node.getName());
    }

    public byte[] getBytes() {
        if (this.bytes == null && hasURL()) {
            try {
                InputStream resourceAsStream = Icon.class.getResourceAsStream(getURL());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = resourceAsStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                resourceAsStream.close();
                this.bytes = byteArrayOutputStream.toByteArray();
            } catch (Exception unused) {
            }
        }
        return this.bytes;
    }

    public int getDepth() {
        try {
            return Integer.parseInt(getIconNode().getNodeValue(DEPTH));
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getHeight() {
        try {
            return Integer.parseInt(getIconNode().getNodeValue("height"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public Node getIconNode() {
        return this.iconNode;
    }

    public String getMimeType() {
        return getIconNode().getNodeValue(MIME_TYPE);
    }

    public String getURL() {
        return getIconNode().getNodeValue("url");
    }

    public Object getUserData() {
        return this.userData;
    }

    public int getWidth() {
        try {
            return Integer.parseInt(getIconNode().getNodeValue("width"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean hasBytes() {
        if (this.bytes != null) {
            return true;
        }
        return hasURL() && Icon.class.getResourceAsStream(getURL()) != null;
    }

    public boolean hasMimeType() {
        String mimeType = getMimeType();
        return mimeType != null && mimeType.length() > 0;
    }

    public boolean hasURL() {
        String url = getURL();
        return url != null && url.length() > 0;
    }

    public boolean isURL(String str) {
        String url;
        if (str == null || (url = getURL()) == null) {
            return false;
        }
        return url.equals(str);
    }

    public void setBytes(byte[] bArr) {
        this.bytes = bArr;
    }

    public void setDepth(String str) {
        getIconNode().setNode(DEPTH, str);
    }

    public void setHeight(String str) {
        getIconNode().setNode("height", str);
    }

    public void setMimeType(String str) {
        getIconNode().setNode(MIME_TYPE, str);
    }

    public void setURL(String str) {
        getIconNode().setNode("url", str);
    }

    public void setUserData(Object obj) {
        this.userData = obj;
    }

    public void setWidth(String str) {
        getIconNode().setNode("width", str);
    }

    public void setDepth(int i10) {
        try {
            setDepth(Integer.toString(i10));
        } catch (Exception unused) {
        }
    }

    public void setHeight(int i10) {
        try {
            setHeight(Integer.toString(i10));
        } catch (Exception unused) {
        }
    }

    public void setWidth(int i10) {
        try {
            setWidth(Integer.toString(i10));
        } catch (Exception unused) {
        }
    }

    public Icon() {
        this(new Node(ELEM_NAME));
    }
}
