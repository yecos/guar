package com.hpplay.component.protocol.plist;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class NSDictionary extends NSObject implements Map<String, NSObject> {
    private final HashMap<String, NSObject> dict = new LinkedHashMap();

    public String[] allKeys() {
        return (String[]) this.dict.keySet().toArray(new String[count()]);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.assignIDs(binaryPropertyListWriter);
        Iterator<Map.Entry<String, NSObject>> it = this.dict.entrySet().iterator();
        while (it.hasNext()) {
            new NSString(it.next().getKey()).assignIDs(binaryPropertyListWriter);
        }
        Iterator<Map.Entry<String, NSObject>> it2 = this.dict.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().assignIDs(binaryPropertyListWriter);
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.dict.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.dict.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.dict.containsValue(NSObject.fromJavaObject(obj));
    }

    public int count() {
        return this.dict.size();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, NSObject>> entrySet() {
        return this.dict.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((NSDictionary) obj).dict.equals(this.dict);
    }

    public HashMap<String, NSObject> getHashMap() {
        return this.dict;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 581 + this.dict.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.dict.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.dict.keySet();
    }

    public NSObject objectForKey(String str) {
        return this.dict.get(str);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends NSObject> map) {
        for (Map.Entry<? extends String, ? extends NSObject> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public int size() {
        return this.dict.size();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        sb.append(NSObject.NEWLINE);
        for (String str : allKeys()) {
            NSObject objectForKey = objectForKey(str);
            indent(sb, i10 + 1);
            sb.append('\"');
            sb.append(NSString.escapeStringForASCII(str));
            sb.append("\" =");
            Class<?> cls = objectForKey.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.NEWLINE);
                objectForKey.toASCII(sb, i10 + 2);
            } else {
                sb.append(' ');
                objectForKey.toASCII(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        sb.append(NSObject.NEWLINE);
        for (String str : (String[]) this.dict.keySet().toArray(new String[this.dict.size()])) {
            NSObject objectForKey = objectForKey(str);
            indent(sb, i10 + 1);
            sb.append('\"');
            sb.append(NSString.escapeStringForASCII(str));
            sb.append("\" =");
            Class<?> cls = objectForKey.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.NEWLINE);
                objectForKey.toASCIIGnuStep(sb, i10 + 2);
            } else {
                sb.append(' ');
                objectForKey.toASCIIGnuStep(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    public String toASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCII(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.writeIntHeader(13, this.dict.size());
        Set<Map.Entry<String, NSObject>> entrySet = this.dict.entrySet();
        Iterator<Map.Entry<String, NSObject>> it = entrySet.iterator();
        while (it.hasNext()) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(new NSString(it.next().getKey())));
        }
        Iterator<Map.Entry<String, NSObject>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(it2.next().getValue()));
        }
    }

    public String toGnuStepASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCIIGnuStep(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<dict>");
        sb.append(NSObject.NEWLINE);
        for (String str : this.dict.keySet()) {
            NSObject objectForKey = objectForKey(str);
            int i11 = i10 + 1;
            indent(sb, i11);
            sb.append("<key>");
            if (str.contains(DispatchConstants.SIGN_SPLIT_SYMBOL) || str.contains(Operator.Operation.LESS_THAN) || str.contains(Operator.Operation.GREATER_THAN)) {
                sb.append("<![CDATA[");
                sb.append(str.replaceAll("]]>", "]]]]><![CDATA[>"));
                sb.append("]]>");
            } else {
                sb.append(str);
            }
            sb.append("</key>");
            String str2 = NSObject.NEWLINE;
            sb.append(str2);
            objectForKey.toXML(sb, i11);
            sb.append(str2);
        }
        indent(sb, i10);
        sb.append("</dict>");
    }

    @Override // java.util.Map
    public Collection<NSObject> values() {
        return this.dict.values();
    }

    public boolean containsKey(String str) {
        return this.dict.containsKey(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public NSObject get(Object obj) {
        return this.dict.get(obj);
    }

    @Override // java.util.Map
    public NSObject put(String str, NSObject nSObject) {
        if (str == null) {
            return null;
        }
        return nSObject == null ? this.dict.get(str) : this.dict.put(str, nSObject);
    }

    public NSObject remove(String str) {
        return this.dict.remove(str);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public NSDictionary mo35clone() {
        NSDictionary nSDictionary = new NSDictionary();
        for (Map.Entry<String, NSObject> entry : this.dict.entrySet()) {
            nSDictionary.dict.put(entry.getKey(), entry.getValue() != null ? entry.getValue().mo35clone() : null);
        }
        return nSDictionary;
    }

    public boolean containsValue(NSObject nSObject) {
        return nSObject != null && this.dict.containsValue(nSObject);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public NSObject remove(Object obj) {
        return this.dict.remove(obj);
    }

    public boolean containsValue(String str) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSString.class) && ((NSString) nSObject).getContent().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public NSObject put(String str, Object obj) {
        return put(str, NSObject.fromJavaObject(obj));
    }

    public boolean containsValue(long j10) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSNumber.class)) {
                if (((NSNumber) nSObject).isInteger() && r1.intValue() == j10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(double d10) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) nSObject;
                if (nSNumber.isReal() && nSNumber.doubleValue() == d10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(boolean z10) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) nSObject;
                if (nSNumber.isBoolean() && nSNumber.boolValue() == z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Date date) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSDate.class) && ((NSDate) nSObject).getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(byte[] bArr) {
        for (NSObject nSObject : this.dict.values()) {
            if (nSObject.getClass().equals(NSData.class) && Arrays.equals(((NSData) nSObject).bytes(), bArr)) {
                return true;
            }
        }
        return false;
    }
}
