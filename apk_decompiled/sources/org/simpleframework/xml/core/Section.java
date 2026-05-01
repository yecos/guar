package org.simpleframework.xml.core;

/* loaded from: classes2.dex */
interface Section extends Iterable<String> {
    String getAttribute(String str);

    LabelMap getAttributes();

    Label getElement(String str);

    LabelMap getElements();

    String getName();

    String getPath(String str);

    String getPrefix();

    Section getSection(String str);

    Label getText();

    boolean isSection(String str);
}
