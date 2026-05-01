package com.hpplay.component.protocol.plist;

import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.umeng.analytics.pro.bt;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public abstract class NSObject implements Cloneable {
    static final int ASCII_LINE_LENGTH = 80;
    private static final String INDENT = "\t";
    static final String NEWLINE = System.getProperty("line.separator");

    private Object[] deserializeArray() {
        NSObject[] array = ((NSArray) this).getArray();
        Object[] objArr = new Object[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            objArr[i10] = array[i10].toJavaObject();
        }
        return objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object deserializeCollection(NSObject nSObject, Class<?> cls, Type[] typeArr) {
        Collection hashSet;
        Class<?> cls2;
        Class<?> cls3;
        Type[] typeArr2;
        if (!cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
            hashSet = (Collection) getInstance(cls);
        } else if (List.class.isAssignableFrom(cls)) {
            hashSet = new ArrayList();
        } else {
            if (!Set.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Could not find a proper implementation for " + cls.getSimpleName());
            }
            hashSet = new HashSet();
        }
        if (typeArr == null || typeArr.length <= 0) {
            cls2 = Object.class;
        } else {
            Type type = typeArr[0];
            if (type instanceof ParameterizedType) {
                cls3 = getClassForName(((ParameterizedType) type).getRawType().toString());
                typeArr2 = ((ParameterizedType) typeArr[0]).getActualTypeArguments();
                if (!(nSObject instanceof NSArray)) {
                    for (NSObject nSObject2 : ((NSArray) nSObject).getArray()) {
                        hashSet.add(toJavaObject(nSObject2, cls3, typeArr2));
                    }
                    return hashSet;
                }
                if (nSObject instanceof NSSet) {
                    Iterator<NSObject> it = ((NSSet) nSObject).getSet().iterator();
                    while (it.hasNext()) {
                        hashSet.add(toJavaObject(it.next(), cls3, typeArr2));
                    }
                    return hashSet;
                }
                throw new IllegalArgumentException("Unknown NS* type " + nSObject.getClass().getSimpleName());
            }
            cls2 = getClassForName(type.toString());
        }
        cls3 = cls2;
        typeArr2 = null;
        if (!(nSObject instanceof NSArray)) {
        }
    }

    private static Object deserializeData(NSData nSData, Class<?> cls) {
        if (cls == Byte.TYPE) {
            return nSData.bytes();
        }
        if (cls != Byte.class) {
            throw new IllegalArgumentException("NSData can only be mapped to byte[] or Byte[].");
        }
        byte[] bytes = nSData.bytes();
        Object newInstance = Array.newInstance(cls, bytes.length);
        for (int i10 = 0; i10 < bytes.length; i10++) {
            Array.set(newInstance, i10, Byte.valueOf(bytes[i10]));
        }
        return newInstance;
    }

    private static Date deserializeDate(NSDate nSDate, Class<?> cls) {
        if (cls == Date.class) {
            return nSDate.getDate();
        }
        if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            return nSDate.getDate();
        }
        Date date = (Date) getInstance(cls);
        date.setTime(nSDate.getDate().getTime());
        return date;
    }

    private HashMap<String, Object> deserializeMap() {
        HashMap<String, NSObject> hashMap = ((NSDictionary) this).getHashMap();
        HashMap<String, Object> hashMap2 = new HashMap<>(hashMap.size());
        for (String str : hashMap.keySet()) {
            hashMap2.put(str, hashMap.get(str).toJavaObject());
        }
        return hashMap2;
    }

    private Object deserializeNumber() {
        NSNumber nSNumber = (NSNumber) this;
        int type = nSNumber.type();
        if (type != 0) {
            return type != 1 ? type != 2 ? Double.valueOf(nSNumber.doubleValue()) : Boolean.valueOf(nSNumber.boolValue()) : Double.valueOf(nSNumber.doubleValue());
        }
        long longValue = nSNumber.longValue();
        return (longValue > TTL.MAX_VALUE || longValue < -2147483648L) ? Long.valueOf(longValue) : Integer.valueOf(nSNumber.intValue());
    }

    private Object deserializeObject(NSDictionary nSDictionary, Class<?> cls, Type[] typeArr) {
        HashMap<String, NSObject> hashMap = nSDictionary.getHashMap();
        if (Map.class.isAssignableFrom(cls)) {
            return deserializeMap(cls, typeArr, hashMap);
        }
        Object nSObject = getInstance(cls);
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (name.startsWith("get")) {
                hashMap2.put(makeFirstCharLowercase(name.substring(3)), method);
            } else if (name.startsWith("set")) {
                hashMap3.put(makeFirstCharLowercase(name.substring(3)), method);
            } else if (name.startsWith(bt.ae)) {
                hashMap2.put(makeFirstCharLowercase(name.substring(2)), method);
            }
        }
        for (Map.Entry<String, NSObject> entry : hashMap.entrySet()) {
            Method method2 = (Method) hashMap3.get(makeFirstCharLowercase(entry.getKey()));
            Method method3 = (Method) hashMap2.get(makeFirstCharLowercase(entry.getKey()));
            if (method2 != null && method3 != null) {
                Class<?> returnType = method3.getReturnType();
                Type genericReturnType = method3.getGenericReturnType();
                try {
                    method2.invoke(nSObject, toJavaObject(entry.getValue(), returnType, genericReturnType instanceof ParameterizedType ? ((ParameterizedType) genericReturnType).getActualTypeArguments() : null));
                } catch (IllegalAccessException unused) {
                    throw new IllegalArgumentException("Could not access setter " + method2);
                } catch (InvocationTargetException unused2) {
                    throw new IllegalArgumentException("Could not invoke setter " + method2);
                }
            }
        }
        return nSObject;
    }

    private Set<Object> deserializeSet() {
        Set<NSObject> set = ((NSSet) this).getSet();
        Set<Object> linkedHashSet = set instanceof LinkedHashSet ? new LinkedHashSet<>(set.size()) : new TreeSet<>();
        Iterator<NSObject> it = set.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().toJavaObject());
        }
        return linkedHashSet;
    }

    private static Object deserializeSimple(NSObject nSObject, Class<?> cls) {
        if (nSObject instanceof NSNumber) {
            return deserializeNumber((NSNumber) nSObject, cls);
        }
        if (nSObject instanceof NSDate) {
            return deserializeDate((NSDate) nSObject, cls);
        }
        if (nSObject instanceof NSString) {
            return ((NSString) nSObject).getContent();
        }
        throw new IllegalArgumentException("Cannot map " + nSObject.getClass().getSimpleName() + " to " + cls.getSimpleName());
    }

    private static NSObject fromArray(Object obj, Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType == Byte.TYPE || componentType == Byte.class) {
            return fromData(obj);
        }
        int length = Array.getLength(obj);
        NSObject[] nSObjectArr = new NSObject[length];
        for (int i10 = 0; i10 < length; i10++) {
            nSObjectArr[i10] = fromJavaObject(Array.get(obj, i10));
        }
        return new NSArray(nSObjectArr);
    }

    private static NSArray fromCollection(Collection<?> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(fromJavaObject(it.next()));
        }
        return new NSArray((NSObject[]) arrayList.toArray(new NSObject[arrayList.size()]));
    }

    private static NSData fromData(Object obj) {
        int length = Array.getLength(obj);
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = ((Byte) Array.get(obj, i10)).byteValue();
        }
        return new NSData(bArr);
    }

    public static NSObject fromJavaObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof NSObject) {
            return (NSObject) obj;
        }
        Class<?> cls = obj.getClass();
        return cls.isArray() ? fromArray(obj, cls) : isSimple(cls) ? fromSimple(obj, cls) : Set.class.isAssignableFrom(cls) ? fromSet((Set) obj) : Map.class.isAssignableFrom(cls) ? fromMap((Map) obj) : Collection.class.isAssignableFrom(cls) ? fromCollection((Collection) obj) : fromPojo(obj, cls);
    }

    private static NSDictionary fromMap(Map<?, ?> map) {
        NSDictionary nSDictionary = new NSDictionary();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Maps need a String key for mapping to NSDictionary.");
            }
            nSDictionary.put((String) entry.getKey(), fromJavaObject(entry.getValue()));
        }
        return nSDictionary;
    }

    private static NSDictionary fromPojo(Object obj, Class<?> cls) {
        String makeFirstCharLowercase;
        NSDictionary nSDictionary = new NSDictionary();
        for (Method method : cls.getMethods()) {
            if (!Modifier.isNative(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length == 0) {
                String name = method.getName();
                if (name.startsWith("get")) {
                    makeFirstCharLowercase = makeFirstCharLowercase(name.substring(3));
                } else if (name.startsWith(bt.ae)) {
                    makeFirstCharLowercase = makeFirstCharLowercase(name.substring(2));
                } else {
                    continue;
                }
                try {
                    nSDictionary.put(makeFirstCharLowercase, fromJavaObject(method.invoke(obj, new Object[0])));
                } catch (IllegalAccessException unused) {
                    throw new IllegalArgumentException("Could not access getter " + method.getName());
                } catch (InvocationTargetException unused2) {
                    throw new IllegalArgumentException("Could not invoke getter " + method.getName());
                }
            }
        }
        for (Field field : cls.getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    nSDictionary.put(field.getName(), fromJavaObject(field.get(obj)));
                } catch (IllegalAccessException unused3) {
                    throw new IllegalArgumentException("Could not access field " + field.getName());
                }
            }
        }
        return nSDictionary;
    }

    private static NSSet fromSet(Set<?> set) {
        NSSet nSSet = new NSSet();
        Iterator<?> it = set.iterator();
        while (it.hasNext()) {
            nSSet.addObject(fromJavaObject(it.next()));
        }
        return nSSet;
    }

    private static NSObject fromSimple(Object obj, Class<?> cls) {
        if ((obj instanceof Long) || cls == Long.TYPE) {
            return new NSNumber(((Long) obj).longValue());
        }
        if ((obj instanceof Integer) || cls == Integer.TYPE) {
            return new NSNumber(((Integer) obj).intValue());
        }
        if ((obj instanceof Short) || cls == Short.TYPE) {
            return new NSNumber((int) ((Short) obj).shortValue());
        }
        if ((obj instanceof Byte) || cls == Byte.TYPE) {
            return new NSNumber((int) ((Byte) obj).byteValue());
        }
        if ((obj instanceof Double) || cls == Double.TYPE) {
            return new NSNumber(((Double) obj).doubleValue());
        }
        if ((obj instanceof Float) || cls == Float.TYPE) {
            return new NSNumber(((Float) obj).floatValue());
        }
        if ((obj instanceof Boolean) || cls == Boolean.TYPE) {
            return new NSNumber(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Date) {
            return new NSDate((Date) obj);
        }
        if (cls == String.class) {
            return new NSString((String) obj);
        }
        throw new IllegalArgumentException("Cannot map " + cls.getSimpleName() + " as a simple type.");
    }

    private static Class<?> getClassForName(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        if ("double".equals(str)) {
            return Double.TYPE;
        }
        if ("float".equals(str)) {
            return Float.TYPE;
        }
        if ("int".equals(str)) {
            return Integer.TYPE;
        }
        if ("long".equals(str)) {
            return Long.TYPE;
        }
        if ("short".equals(str)) {
            return Short.TYPE;
        }
        if ("boolean".equals(str)) {
            return Boolean.TYPE;
        }
        if ("byte".equals(str)) {
            return Byte.TYPE;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new IllegalArgumentException("Could not load class " + str, e10);
        }
    }

    private static Object getInstance(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException unused) {
            throw new IllegalArgumentException("Could not instantiate class " + cls.getSimpleName());
        } catch (InstantiationException unused2) {
            throw new IllegalArgumentException("Could not instantiate class " + cls.getSimpleName());
        }
    }

    private static boolean isSimple(Class<?> cls) {
        return cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || cls == String.class || Date.class.isAssignableFrom(cls);
    }

    private static String makeFirstCharLowercase(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.assignID(this);
    }

    @Override // 
    /* renamed from: clone */
    public abstract NSObject mo35clone();

    public void indent(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("\t");
        }
    }

    public abstract void toASCII(StringBuilder sb, int i10);

    public abstract void toASCIIGnuStep(StringBuilder sb, int i10);

    public abstract void toBinary(BinaryPropertyListWriter binaryPropertyListWriter);

    public Object toJavaObject() {
        return this instanceof NSArray ? deserializeArray() : this instanceof NSDictionary ? deserializeMap() : this instanceof NSSet ? deserializeSet() : this instanceof NSNumber ? deserializeNumber() : this instanceof NSString ? ((NSString) this).getContent() : this instanceof NSData ? ((NSData) this).bytes() : this instanceof NSDate ? ((NSDate) this).getDate() : this instanceof UID ? ((UID) this).getBytes() : this;
    }

    public abstract void toXML(StringBuilder sb, int i10);

    public String toXMLPropertyList() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        String str = NEWLINE;
        sb.append(str);
        sb.append("<!DOCTYPE plist PUBLIC \"-//Lebo//DTD PLIST 1.0//EN\" \"https://www.lebo.cn/DTDs/PropertyList-1.0.dtd\">");
        sb.append(str);
        sb.append("<plist version=\"1.0\">");
        sb.append(str);
        toXML(sb, 0);
        sb.append(str);
        sb.append("</plist>");
        return sb.toString();
    }

    private Object deserializeArray(NSObject nSObject, Class<?> cls) {
        Class<?> classForName = getClassForName(cls.getComponentType().getName());
        int i10 = 0;
        if (nSObject instanceof NSArray) {
            NSObject[] array = ((NSArray) nSObject).getArray();
            Object newInstance = Array.newInstance(classForName, array.length);
            while (i10 < array.length) {
                Array.set(newInstance, i10, toJavaObject(array[i10], classForName, null));
                i10++;
            }
            return newInstance;
        }
        if (nSObject instanceof NSSet) {
            Set<NSObject> set = ((NSSet) nSObject).getSet();
            Object newInstance2 = Array.newInstance(classForName, set.size());
            Iterator<NSObject> it = set.iterator();
            while (it.hasNext()) {
                Array.set(newInstance2, i10, toJavaObject(it.next(), classForName, null));
                i10++;
            }
            return newInstance2;
        }
        if (nSObject instanceof NSData) {
            return deserializeData((NSData) nSObject, classForName);
        }
        throw new IllegalArgumentException("Unable to map " + nSObject.getClass().getSimpleName() + " to " + cls.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[LOOP:0: B:14:0x0053->B:16:0x0059, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object deserializeMap(Class<?> cls, Type[] typeArr, Map<String, NSObject> map) {
        Map hashMap;
        Class<?> cls2;
        Class<?> cls3;
        Type[] typeArr2;
        if (!cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
            hashMap = (Map) getInstance(cls);
        } else {
            hashMap = new HashMap();
        }
        if (typeArr != null && typeArr.length > 1) {
            Type type = typeArr[1];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls3 = getClassForName(parameterizedType.getRawType().toString());
                typeArr2 = parameterizedType.getActualTypeArguments();
                for (Map.Entry<String, NSObject> entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), toJavaObject(entry.getValue(), cls3, typeArr2));
                }
                return hashMap;
            }
            cls2 = getClassForName(type.toString());
        } else {
            cls2 = Object.class;
        }
        cls3 = cls2;
        typeArr2 = null;
        while (r7.hasNext()) {
        }
        return hashMap;
    }

    private static Object deserializeNumber(NSNumber nSNumber, Class<?> cls) {
        if (nSNumber.isInteger()) {
            if (cls != Long.TYPE && cls != Long.class) {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Short.TYPE && cls != Short.class) {
                        if (cls == Byte.TYPE || cls == Byte.class) {
                            return Byte.valueOf((byte) nSNumber.intValue());
                        }
                    } else {
                        return Short.valueOf((short) nSNumber.intValue());
                    }
                } else {
                    return Integer.valueOf(nSNumber.intValue());
                }
            } else {
                return Long.valueOf(nSNumber.longValue());
            }
        }
        if (nSNumber.isInteger() || nSNumber.isReal()) {
            if (cls != Double.TYPE && cls != Double.class) {
                if (cls == Float.TYPE || cls == Float.class) {
                    return Float.valueOf(nSNumber.floatValue());
                }
            } else {
                return Double.valueOf(nSNumber.doubleValue());
            }
        }
        if (nSNumber.isBoolean() && (cls == Boolean.TYPE || cls == Boolean.class)) {
            return Boolean.valueOf(nSNumber.boolValue());
        }
        throw new IllegalArgumentException("Cannot map NSNumber to " + cls.getSimpleName());
    }

    public <T> T toJavaObject(Class<T> cls) {
        return (T) toJavaObject(this, cls, null);
    }

    private Object toJavaObject(NSObject nSObject, Class<?> cls, Type[] typeArr) {
        if (cls.isArray()) {
            return deserializeArray(nSObject, cls);
        }
        if (isSimple(cls)) {
            return deserializeSimple(nSObject, cls);
        }
        if (cls == Object.class && !(nSObject instanceof NSSet) && !(nSObject instanceof NSArray)) {
            return deserializeSimple(nSObject, cls);
        }
        if ((nSObject instanceof NSSet) && Collection.class.isAssignableFrom(cls)) {
            return deserializeCollection(nSObject, cls, typeArr);
        }
        if ((nSObject instanceof NSArray) && Collection.class.isAssignableFrom(cls)) {
            return deserializeCollection(nSObject, cls, typeArr);
        }
        if (nSObject instanceof NSDictionary) {
            return deserializeObject((NSDictionary) nSObject, cls, typeArr);
        }
        throw new IllegalArgumentException("Cannot process " + cls.getSimpleName());
    }
}
