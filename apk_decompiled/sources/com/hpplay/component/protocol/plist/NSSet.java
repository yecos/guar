package com.hpplay.component.protocol.plist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public class NSSet extends NSObject {
    private boolean ordered;
    private Set<NSObject> set;

    public NSSet() {
        this.ordered = false;
        this.set = new LinkedHashSet();
    }

    public synchronized void addObject(NSObject nSObject) {
        this.set.add(nSObject);
    }

    public synchronized NSObject[] allObjects() {
        return (NSObject[]) this.set.toArray(new NSObject[count()]);
    }

    public synchronized NSObject anyObject() {
        if (this.set.isEmpty()) {
            return null;
        }
        return this.set.iterator().next();
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.assignIDs(binaryPropertyListWriter);
        Iterator<NSObject> it = this.set.iterator();
        while (it.hasNext()) {
            it.next().assignIDs(binaryPropertyListWriter);
        }
    }

    public boolean containsObject(NSObject nSObject) {
        return this.set.contains(nSObject);
    }

    public synchronized int count() {
        return this.set.size();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Set<NSObject> set = this.set;
        Set<NSObject> set2 = ((NSSet) obj).set;
        return set == set2 || (set != null && set.equals(set2));
    }

    public Set<NSObject> getSet() {
        return this.set;
    }

    public int hashCode() {
        Set<NSObject> set = this.set;
        return 203 + (set != null ? set.hashCode() : 0);
    }

    public synchronized boolean intersectsSet(NSSet nSSet) {
        Iterator<NSObject> it = this.set.iterator();
        while (it.hasNext()) {
            if (nSSet.containsObject(it.next())) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isSubsetOfSet(NSSet nSSet) {
        Iterator<NSObject> it = this.set.iterator();
        while (it.hasNext()) {
            if (!nSSet.containsObject(it.next())) {
                return false;
            }
        }
        return true;
    }

    public synchronized NSObject member(NSObject nSObject) {
        for (NSObject nSObject2 : this.set) {
            if (nSObject2.equals(nSObject)) {
                return nSObject2;
            }
        }
        return null;
    }

    public synchronized Iterator<NSObject> objectIterator() {
        return this.set.iterator();
    }

    public synchronized void removeObject(NSObject nSObject) {
        this.set.remove(nSObject);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        NSObject[] allObjects = allObjects();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        for (int i11 = 0; i11 < allObjects.length; i11++) {
            Class<?> cls = allObjects[i11].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
                allObjects[i11].toASCII(sb, i10 + 1);
            } else {
                if (i11 != 0) {
                    sb.append(' ');
                }
                allObjects[i11].toASCII(sb, 0);
            }
            if (i11 != allObjects.length - 1) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        NSObject[] allObjects = allObjects();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        for (int i11 = 0; i11 < allObjects.length; i11++) {
            Class<?> cls = allObjects[i11].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
                allObjects[i11].toASCIIGnuStep(sb, i10 + 1);
            } else {
                if (i11 != 0) {
                    sb.append(' ');
                }
                allObjects[i11].toASCIIGnuStep(sb, 0);
            }
            if (i11 != allObjects.length - 1) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        if (this.ordered) {
            binaryPropertyListWriter.writeIntHeader(11, this.set.size());
        } else {
            binaryPropertyListWriter.writeIntHeader(12, this.set.size());
        }
        Iterator<NSObject> it = this.set.iterator();
        while (it.hasNext()) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(it.next()));
        }
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<array>");
        sb.append(NSObject.NEWLINE);
        Iterator<NSObject> it = this.set.iterator();
        while (it.hasNext()) {
            it.next().toXML(sb, i10 + 1);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append("</array>");
    }

    @Override // com.hpplay.component.protocol.plist.NSObject
    /* renamed from: clone */
    public NSSet mo35clone() {
        NSObject[] nSObjectArr = new NSObject[this.set.size()];
        Iterator<NSObject> it = this.set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            NSObject next = it.next();
            int i11 = i10 + 1;
            nSObjectArr[i10] = next != null ? next.mo35clone() : null;
            i10 = i11;
        }
        return new NSSet(this.ordered, nSObjectArr);
    }

    public NSSet(boolean z10) {
        this.ordered = z10;
        if (!z10) {
            this.set = new LinkedHashSet();
        } else {
            this.set = new TreeSet();
        }
    }

    public NSSet(NSObject... nSObjectArr) {
        this.ordered = false;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.set = linkedHashSet;
        linkedHashSet.addAll(Arrays.asList(nSObjectArr));
    }

    public NSSet(boolean z10, NSObject... nSObjectArr) {
        this.ordered = z10;
        if (!z10) {
            this.set = new LinkedHashSet();
        } else {
            this.set = new TreeSet();
        }
        this.set.addAll(Arrays.asList(nSObjectArr));
    }
}
