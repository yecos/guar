package org.simpleframework.xml.stream;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
class HyphenBuilder implements Style {

    public class Parser extends Splitter {
        @Override // org.simpleframework.xml.stream.Splitter
        public void commit(char[] cArr, int i10, int i11) {
            this.builder.append(cArr, i10, i11);
            if (i10 + i11 < this.count) {
                this.builder.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            }
        }

        @Override // org.simpleframework.xml.stream.Splitter
        public void parse(char[] cArr, int i10, int i11) {
            cArr[i10] = toLower(cArr[i10]);
        }

        private Parser(String str) {
            super(str);
        }
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }
}
