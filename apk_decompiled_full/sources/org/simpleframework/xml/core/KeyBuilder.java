package org.simpleframework.xml.core;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;

/* loaded from: classes2.dex */
class KeyBuilder {
    private final Label label;

    public enum KeyType {
        TEXT,
        ATTRIBUTE,
        ELEMENT
    }

    public KeyBuilder(Label label) {
        this.label = label;
    }

    public Object getKey() {
        return this.label.isAttribute() ? getKey(KeyType.ATTRIBUTE) : getKey(KeyType.ELEMENT);
    }

    public static class Key {
        private final KeyType type;
        private final String value;

        public Key(KeyType keyType, String str) {
            this.value = str;
            this.type = keyType;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return equals((Key) obj);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return this.value;
        }

        public boolean equals(Key key) {
            if (this.type == key.type) {
                return key.value.equals(this.value);
            }
            return false;
        }
    }

    private Object getKey(KeyType keyType) {
        String key = getKey(this.label.getPaths());
        return keyType == null ? key : new Key(keyType, key);
    }

    private String getKey(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr.length > 0) {
            Arrays.sort(strArr);
            for (String str : strArr) {
                sb.append(str);
                sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
            }
        }
        return sb.toString();
    }
}
