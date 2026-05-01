package com.hpplay.component.protocol.plist;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class ASCIIPropertyListParser {
    public static final char ARRAY_BEGIN_TOKEN = '(';
    public static final char ARRAY_END_TOKEN = ')';
    public static final char ARRAY_ITEM_DELIMITER_TOKEN = ',';
    public static final char COMMENT_BEGIN_TOKEN = '/';
    public static final char DATA_BEGIN_TOKEN = '<';
    public static final char DATA_END_TOKEN = '>';
    public static final char DATA_GSBOOL_BEGIN_TOKEN = 'B';
    public static final char DATA_GSBOOL_FALSE_TOKEN = 'N';
    public static final char DATA_GSBOOL_TRUE_TOKEN = 'Y';
    public static final char DATA_GSDATE_BEGIN_TOKEN = 'D';
    public static final char DATA_GSINT_BEGIN_TOKEN = 'I';
    public static final char DATA_GSOBJECT_BEGIN_TOKEN = '*';
    public static final char DATA_GSREAL_BEGIN_TOKEN = 'R';
    public static final char DATE_APPLE_DATE_TIME_DELIMITER = 'T';
    public static final char DATE_APPLE_END_TOKEN = 'Z';
    public static final char DATE_DATE_FIELD_DELIMITER = '-';
    public static final char DATE_GS_DATE_TIME_DELIMITER = ' ';
    public static final char DATE_TIME_FIELD_DELIMITER = ':';
    public static final char DICTIONARY_ASSIGN_TOKEN = '=';
    public static final char DICTIONARY_BEGIN_TOKEN = '{';
    public static final char DICTIONARY_END_TOKEN = '}';
    public static final char DICTIONARY_ITEM_DELIMITER_TOKEN = ';';
    public static final char MULTILINE_COMMENT_END_TOKEN = '/';
    public static final char MULTILINE_COMMENT_SECOND_TOKEN = '*';
    public static final char QUOTEDSTRING_BEGIN_TOKEN = '\"';
    public static final char QUOTEDSTRING_END_TOKEN = '\"';
    public static final char QUOTEDSTRING_ESCAPE_TOKEN = '\\';
    public static final char SINGLELINE_COMMENT_SECOND_TOKEN = '/';
    public static final char WHITESPACE_CARRIAGE_RETURN = '\r';
    public static final char WHITESPACE_NEWLINE = '\n';
    public static final char WHITESPACE_SPACE = ' ';
    public static final char WHITESPACE_TAB = '\t';
    private final char[] data;
    private int index;

    private ASCIIPropertyListParser(byte[] bArr, String str) {
        this.data = new String(bArr, str).toCharArray();
    }

    private boolean accept(char... cArr) {
        boolean z10 = false;
        for (char c10 : cArr) {
            if (this.data[this.index] == c10) {
                z10 = true;
            }
        }
        return z10;
    }

    private boolean acceptSequence(char... cArr) {
        for (int i10 = 0; i10 < cArr.length; i10++) {
            if (this.data[this.index + i10] != cArr[i10]) {
                return false;
            }
        }
        return true;
    }

    private void expect(char... cArr) {
        if (accept(cArr)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected '");
        sb.append(cArr[0]);
        sb.append("'");
        for (int i10 = 1; i10 < cArr.length; i10++) {
            sb.append(" or '");
            sb.append(cArr[i10]);
            sb.append("'");
        }
        sb.append(" but found '");
        sb.append(this.data[this.index]);
        sb.append("'");
        throw new ParseException(sb.toString(), this.index);
    }

    public static NSObject parse(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private NSArray parseArray() {
        skip();
        skipWhitespacesAndComments();
        LinkedList linkedList = new LinkedList();
        while (!accept(ARRAY_END_TOKEN)) {
            linkedList.add(parseObject());
            skipWhitespacesAndComments();
            if (!accept(ARRAY_ITEM_DELIMITER_TOKEN)) {
                break;
            }
            skip();
            skipWhitespacesAndComments();
        }
        read(ARRAY_END_TOKEN);
        return new NSArray((NSObject[]) linkedList.toArray(new NSObject[linkedList.size()]));
    }

    private NSObject parseData() {
        NSObject nSObject;
        NSObject nSNumber;
        skip();
        if (!accept('*')) {
            String replaceAll = readInputUntil(DATA_END_TOKEN).replaceAll("\\s+", "");
            int length = replaceAll.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) Integer.parseInt(replaceAll.substring(i11, i11 + 2), 16);
            }
            NSData nSData = new NSData(bArr);
            skip();
            return nSData;
        }
        skip();
        expect(DATA_GSBOOL_BEGIN_TOKEN, DATA_GSDATE_BEGIN_TOKEN, DATA_GSINT_BEGIN_TOKEN, DATA_GSREAL_BEGIN_TOKEN);
        if (accept(DATA_GSBOOL_BEGIN_TOKEN)) {
            skip();
            expect(DATA_GSBOOL_TRUE_TOKEN, DATA_GSBOOL_FALSE_TOKEN);
            nSObject = accept(DATA_GSBOOL_TRUE_TOKEN) ? new NSNumber(true) : new NSNumber(false);
            skip();
        } else {
            if (accept(DATA_GSDATE_BEGIN_TOKEN)) {
                skip();
                nSNumber = new NSDate(readInputUntil(DATA_END_TOKEN));
            } else if (accept(DATA_GSINT_BEGIN_TOKEN, DATA_GSREAL_BEGIN_TOKEN)) {
                skip();
                nSNumber = new NSNumber(readInputUntil(DATA_END_TOKEN));
            } else {
                nSObject = null;
            }
            nSObject = nSNumber;
        }
        read(DATA_END_TOKEN);
        return nSObject;
    }

    private NSObject parseDateString() {
        String parseString = parseString();
        if (parseString.length() > 4 && parseString.charAt(4) == '-') {
            try {
                return new NSDate(parseString);
            } catch (Exception unused) {
            }
        }
        return new NSString(parseString);
    }

    private NSDictionary parseDictionary() {
        skip();
        skipWhitespacesAndComments();
        NSDictionary nSDictionary = new NSDictionary();
        while (!accept(DICTIONARY_END_TOKEN)) {
            String parseQuotedString = accept('\"') ? parseQuotedString() : parseString();
            skipWhitespacesAndComments();
            read(DICTIONARY_ASSIGN_TOKEN);
            skipWhitespacesAndComments();
            nSDictionary.put(parseQuotedString, parseObject());
            skipWhitespacesAndComments();
            read(DICTIONARY_ITEM_DELIMITER_TOKEN);
            skipWhitespacesAndComments();
        }
        skip();
        return nSDictionary;
    }

    private static char parseEscapedSequence(StringCharacterIterator stringCharacterIterator) {
        char next = stringCharacterIterator.next();
        if (next != '\"' && next != '\'') {
            if (next != 'U') {
                if (next != '\\') {
                    if (next == 'b') {
                        return '\b';
                    }
                    if (next == 'n') {
                        return '\n';
                    }
                    if (next == 'r') {
                        return WHITESPACE_CARRIAGE_RETURN;
                    }
                    if (next == 't') {
                        return '\t';
                    }
                    if (next != 'u') {
                        switch (next) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                                String str = new String(new char[]{next, stringCharacterIterator.next(), stringCharacterIterator.next()});
                                try {
                                    return (char) Integer.parseInt(str, 8);
                                } catch (NumberFormatException unused) {
                                    throw new ParseException("The property list contains a string with an invalid escape sequence: \\" + str, stringCharacterIterator.getIndex() - 2);
                                }
                            default:
                                throw new ParseException("The property list contains a string with an invalid escape sequence: \\" + next, stringCharacterIterator.getIndex());
                        }
                    }
                }
            }
            String str2 = new String(new char[]{stringCharacterIterator.next(), stringCharacterIterator.next(), stringCharacterIterator.next(), stringCharacterIterator.next()});
            try {
                return (char) Integer.parseInt(str2, 16);
            } catch (NumberFormatException unused2) {
                throw new ParseException("The property list contains a string with an invalid escape sequence: \\" + next + str2, stringCharacterIterator.getIndex() - 4);
            }
        }
        return next;
    }

    private NSObject parseObject() {
        char c10 = this.data[this.index];
        if (c10 != '\"') {
            return c10 != '(' ? c10 != '<' ? c10 != '{' ? (c10 < '0' || c10 > '9') ? new NSString(parseString()) : parseDateString() : parseDictionary() : parseData() : parseArray();
        }
        String parseQuotedString = parseQuotedString();
        if (parseQuotedString.length() != 20 || parseQuotedString.charAt(4) != '-') {
            return new NSString(parseQuotedString);
        }
        try {
            return new NSDate(parseQuotedString);
        } catch (Exception unused) {
            return new NSString(parseQuotedString);
        }
    }

    private String parseQuotedString() {
        skip();
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        while (true) {
            char[] cArr = this.data;
            int i10 = this.index;
            char c10 = cArr[i10];
            if (c10 == '\"' && (cArr[i10 - 1] != '\\' || !z10)) {
                try {
                    String parseQuotedString = parseQuotedString(sb.toString());
                    skip();
                    return parseQuotedString;
                } catch (ParseException e10) {
                    throw new ParseException(e10.getMessage(), this.index + e10.getErrorOffset());
                } catch (Exception unused) {
                    throw new ParseException("A quoted string could not be parsed.", this.index);
                }
            }
            sb.append(c10);
            if (accept(QUOTEDSTRING_ESCAPE_TOKEN)) {
                z10 = (this.data[this.index - 1] == '\\' && z10) ? false : true;
            }
            skip();
        }
    }

    private String parseString() {
        return readInputUntil(' ', '\t', '\n', WHITESPACE_CARRIAGE_RETURN, ARRAY_ITEM_DELIMITER_TOKEN, DICTIONARY_ITEM_DELIMITER_TOKEN, DICTIONARY_ASSIGN_TOKEN, ARRAY_END_TOKEN);
    }

    private void read(char c10) {
        expect(c10);
        this.index++;
    }

    private String readInputUntil(char... cArr) {
        StringBuilder sb = new StringBuilder();
        while (!accept(cArr)) {
            sb.append(this.data[this.index]);
            skip();
        }
        return sb.toString();
    }

    private void skip() {
        this.index++;
    }

    private void skipWhitespacesAndComments() {
        while (true) {
            if (accept(WHITESPACE_CARRIAGE_RETURN, '\n', ' ', '\t')) {
                skip();
            } else {
                boolean z10 = true;
                if (acceptSequence('/', '/')) {
                    skip(2);
                    readInputUntil(WHITESPACE_CARRIAGE_RETURN, '\n');
                } else if (acceptSequence('/', '*')) {
                    skip(2);
                    while (!acceptSequence('*', '/')) {
                        skip();
                    }
                    skip(2);
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return;
                }
            }
        }
    }

    private void skip(int i10) {
        this.index += i10;
    }

    private boolean accept(char c10) {
        return this.data[this.index] == c10;
    }

    public static NSObject parse(File file, String str) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, str);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private String readInputUntil(char c10) {
        StringBuilder sb = new StringBuilder();
        while (!accept(c10)) {
            sb.append(this.data[this.index]);
            skip();
        }
        return sb.toString();
    }

    private void expect(char c10) {
        if (accept(c10)) {
            return;
        }
        throw new ParseException("Expected '" + c10 + "' but found '" + this.data[this.index] + "'", this.index);
    }

    public static NSObject parse(InputStream inputStream) {
        return parse(PropertyListParser.readAll(inputStream));
    }

    public static NSObject parse(InputStream inputStream, String str) {
        return parse(PropertyListParser.readAll(inputStream), str);
    }

    public static NSObject parse(byte[] bArr) {
        try {
            if (bArr.length > 2) {
                byte b10 = bArr[0];
                if (b10 == -2 && bArr[1] == -1) {
                    return parse(bArr, "UTF-16");
                }
                if (b10 == -1 && bArr[1] == -2) {
                    if (bArr.length > 4 && bArr[2] == 0 && bArr[3] == 0) {
                        return parse(bArr, "UTF-32");
                    }
                    return parse(bArr, "UTF-16");
                }
                if (bArr.length > 3) {
                    if (b10 == -17 && bArr[1] == -69 && bArr[2] == -65) {
                        return parse(bArr, "UTF-8");
                    }
                    if (bArr.length > 4 && b10 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) {
                        return parse(bArr, "UTF-32");
                    }
                }
            }
            return parse(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Unsupported property list encoding: " + e10.getMessage());
        }
    }

    private static synchronized String parseQuotedString(String str) {
        String sb;
        synchronized (ASCIIPropertyListParser.class) {
            StringBuilder sb2 = new StringBuilder();
            StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
            char current = stringCharacterIterator.current();
            while (stringCharacterIterator.getIndex() < stringCharacterIterator.getEndIndex()) {
                if (current != '\\') {
                    sb2.append(current);
                } else {
                    sb2.append(parseEscapedSequence(stringCharacterIterator));
                }
                current = stringCharacterIterator.next();
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static NSObject parse(byte[] bArr, String str) {
        return new ASCIIPropertyListParser(bArr, str).parse();
    }

    public NSObject parse() {
        this.index = 0;
        char[] cArr = this.data;
        if (cArr.length != 0) {
            if (cArr[0] == 65279) {
                skip(1);
            }
            skipWhitespacesAndComments();
            expect(DICTIONARY_BEGIN_TOKEN, ARRAY_BEGIN_TOKEN, '/');
            try {
                return parseObject();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParseException("Reached end of input unexpectedly.", this.index);
            }
        }
        throw new ParseException("The property list is empty.", 0);
    }
}
