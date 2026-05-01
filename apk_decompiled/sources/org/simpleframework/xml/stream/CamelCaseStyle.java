package org.simpleframework.xml.stream;

/* loaded from: classes2.dex */
public class CamelCaseStyle implements Style {
    private final Builder builder;
    private final Style style;

    public CamelCaseStyle() {
        this(true, false);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        return this.builder.getAttribute(str);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        return this.builder.getElement(str);
    }

    public void setAttribute(String str, String str2) {
        this.builder.setAttribute(str, str2);
    }

    public void setElement(String str, String str2) {
        this.builder.setElement(str, str2);
    }

    public CamelCaseStyle(boolean z10) {
        this(z10, false);
    }

    public CamelCaseStyle(boolean z10, boolean z11) {
        CamelCaseBuilder camelCaseBuilder = new CamelCaseBuilder(z10, z11);
        this.style = camelCaseBuilder;
        this.builder = new Builder(camelCaseBuilder);
    }
}
