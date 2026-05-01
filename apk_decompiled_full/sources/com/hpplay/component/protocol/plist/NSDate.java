package com.hpplay.component.protocol.plist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class NSDate extends NSObject {
    private static final long EPOCH = 978307200000L;
    private static final SimpleDateFormat sdfDefault;
    private static final SimpleDateFormat sdfGnuStep;
    private Date date;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdfDefault = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        sdfGnuStep = simpleDateFormat2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public NSDate(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static synchronized String makeDateString(Date date) {
        String format;
        synchronized (NSDate.class) {
            format = sdfDefault.format(date);
        }
        return format;
    }

    private static synchronized String makeDateStringGnuStep(Date date) {
        String format;
        synchronized (NSDate.class) {
            format = sdfGnuStep.format(date);
        }
        return format;
    }

    private static synchronized Date parseDateString(String str) {
        Date parse;
        synchronized (NSDate.class) {
            try {
                parse = sdfDefault.parse(str);
            } catch (ParseException unused) {
                return sdfGnuStep.parse(str);
            }
        }
        return parse;
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && this.date.equals(((NSDate) obj).getDate());
    }

    public Date getDate() {
        return this.date;
    }

    public int hashCode() {
        return this.date.hashCode();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append('\"');
        sb.append(makeDateString(this.date));
        sb.append('\"');
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<*D");
        sb.append(makeDateStringGnuStep(this.date));
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.write(51);
        double time = this.date.getTime() - EPOCH;
        Double.isNaN(time);
        binaryPropertyListWriter.writeDouble(time / 1000.0d);
    }

    public String toString() {
        return this.date.toString();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<date>");
        sb.append(makeDateString(this.date));
        sb.append("</date>");
    }

    public NSDate(byte[] bArr, int i10, int i11) {
        this.date = new Date(((long) (BinaryPropertyListParser.parseDouble(bArr, i10, i11) * 1000.0d)) + EPOCH);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public NSDate mo35clone() {
        return new NSDate((Date) getDate().clone());
    }

    public NSDate(String str) {
        this.date = parseDateString(str);
    }

    public NSDate(Date date) {
        if (date != null) {
            this.date = date;
            return;
        }
        throw new IllegalArgumentException("Date cannot be null");
    }
}
