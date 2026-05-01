package org.simpleframework.xml.stream;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.BufferedWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
class Formatter {
    private OutputBuffer buffer = new OutputBuffer();
    private Indenter indenter;
    private Tag last;
    private String prolog;
    private Writer result;
    private static final char[] NAMESPACE = {'x', 'm', 'l', 'n', 's'};
    private static final char[] LESS = {'&', 'l', 't', ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN};
    private static final char[] GREATER = {'&', 'g', 't', ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN};
    private static final char[] DOUBLE = {'&', 'q', 'u', 'o', 't', ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN};
    private static final char[] SINGLE = {'&', 'a', 'p', 'o', 's', ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN};
    private static final char[] AND = {'&', 'a', 'm', 'p', ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN};
    private static final char[] OPEN = {ASCIIPropertyListParser.DATA_BEGIN_TOKEN, '!', ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER, ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER, ' '};
    private static final char[] CLOSE = {' ', ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER, ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER, ASCIIPropertyListParser.DATA_END_TOKEN};

    public enum Tag {
        COMMENT,
        START,
        TEXT,
        END
    }

    public Formatter(Writer writer, Format format) {
        this.result = new BufferedWriter(writer, 1024);
        this.indenter = new Indenter(format);
        this.prolog = format.getProlog();
    }

    private void append(char c10) {
        this.buffer.append(c10);
    }

    private void data(String str) {
        write("<![CDATA[");
        write(str);
        write("]]>");
    }

    private void escape(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            escape(str.charAt(i10));
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private boolean isText(char c10) {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r' || c10 == ' ') {
            return true;
        }
        return c10 > ' ' && c10 <= '~' && c10 != 247;
    }

    private char[] symbol(char c10) {
        if (c10 == '\"') {
            return DOUBLE;
        }
        if (c10 == '<') {
            return LESS;
        }
        if (c10 == '>') {
            return GREATER;
        }
        if (c10 == '&') {
            return AND;
        }
        if (c10 != '\'') {
            return null;
        }
        return SINGLE;
    }

    private String unicode(char c10) {
        return Integer.toString(c10);
    }

    private void write(char c10) {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(c10);
    }

    public void flush() {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.flush();
    }

    public void writeAttribute(String str, String str2, String str3) {
        if (this.last != Tag.START) {
            throw new NodeException("Start element required");
        }
        write(' ');
        write(str, str3);
        write(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        write('\"');
        escape(str2);
        write('\"');
    }

    public void writeComment(String str) {
        String pVar = this.indenter.top();
        if (this.last == Tag.START) {
            append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        if (pVar != null) {
            append(pVar);
            append(OPEN);
            append(str);
            append(CLOSE);
        }
        this.last = Tag.COMMENT;
    }

    public void writeEnd(String str, String str2) {
        String pop = this.indenter.pop();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag == tag2) {
            write('/');
            write(ASCIIPropertyListParser.DATA_END_TOKEN);
        } else {
            if (tag != Tag.TEXT) {
                write(pop);
            }
            if (this.last != tag2) {
                write(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
                write('/');
                write(str, str2);
                write(ASCIIPropertyListParser.DATA_END_TOKEN);
            }
        }
        this.last = Tag.END;
    }

    public void writeNamespace(String str, String str2) {
        if (this.last != Tag.START) {
            throw new NodeException("Start element required");
        }
        write(' ');
        write(NAMESPACE);
        if (!isEmpty(str2)) {
            write(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            write(str2);
        }
        write(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        write('\"');
        escape(str);
        write('\"');
    }

    public void writeProlog() {
        String str = this.prolog;
        if (str != null) {
            write(str);
            write("\n");
        }
    }

    public void writeStart(String str, String str2) {
        String push = this.indenter.push();
        Tag tag = this.last;
        Tag tag2 = Tag.START;
        if (tag == tag2) {
            append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        flush();
        append(push);
        append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        if (!isEmpty(str2)) {
            append(str2);
            append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        }
        append(str);
        this.last = tag2;
    }

    public void writeText(String str) {
        writeText(str, Mode.ESCAPE);
    }

    private void append(char[] cArr) {
        this.buffer.append(cArr);
    }

    public void writeText(String str, Mode mode) {
        if (this.last == Tag.START) {
            write(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        if (mode == Mode.DATA) {
            data(str);
        } else {
            escape(str);
        }
        this.last = Tag.TEXT;
    }

    private void append(String str) {
        this.buffer.append(str);
    }

    private void escape(char c10) {
        char[] symbol = symbol(c10);
        if (symbol != null) {
            write(symbol);
        } else {
            write(c10);
        }
    }

    private void write(char[] cArr) {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(cArr);
    }

    private void write(String str) {
        this.buffer.write(this.result);
        this.buffer.clear();
        this.result.write(str);
    }

    private void write(String str, String str2) {
        this.buffer.write(this.result);
        this.buffer.clear();
        if (!isEmpty(str2)) {
            this.result.write(str2);
            this.result.write(58);
        }
        this.result.write(str);
    }
}
