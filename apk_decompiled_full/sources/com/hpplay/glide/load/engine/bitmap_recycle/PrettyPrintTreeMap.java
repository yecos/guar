package com.hpplay.glide.load.engine.bitmap_recycle;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
            sb.append(entry.getKey());
            sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
