package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Cache;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.mobile.brasiltv.view.dialog.DialogManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ElementHelper {
    private WeakReference<Cache> cache;
    private Class clazz;
    private Method compareCredibility;
    private Field credibilityField;
    private WeakReference<Object> element;
    private Field expireField;
    private Method expired;
    private Method getTTL;
    private Method getType;

    public ElementHelper(Cache cache, Object obj) {
        this.cache = null;
        this.element = null;
        this.clazz = null;
        this.expired = null;
        this.compareCredibility = null;
        this.getType = null;
        this.getTTL = null;
        this.expireField = null;
        this.credibilityField = null;
        this.cache = new WeakReference<>(cache);
        this.element = new WeakReference<>(obj);
        Class<?> cls = obj.getClass();
        this.clazz = cls;
        this.expireField = findField(cls, "expire");
        this.credibilityField = findField(this.clazz, "credibility");
        this.expired = findMethod(this.clazz, DialogManager.DIALOG_EXPIRED, new Class[0]);
        this.compareCredibility = findMethod(this.clazz, "compareCredibility", new Class[]{Integer.TYPE});
        this.getType = findMethod(this.clazz, "getType", new Class[0]);
        this.getTTL = findMethod(this.clazz, "getTTL", new Class[0]);
        AccessibleObject.setAccessible(new AccessibleObject[]{this.expireField, this.credibilityField}, true);
        AccessibleObject.setAccessible(new AccessibleObject[]{this.expired, this.compareCredibility, this.getType, this.getTTL, this.expireField, this.credibilityField}, true);
    }

    public static Field findField(Class cls, String str) {
        Field field = null;
        for (Class cls2 = cls; cls2 != null && field == null; cls2 = cls2.getSuperclass()) {
            try {
                field = cls2.getDeclaredField(str);
            } catch (NoSuchFieldException | SecurityException unused) {
            }
            if (field != null) {
                return field;
            }
        }
        throw new NoSuchFieldException("Field \"" + str + "\" does not exist in class \"" + cls.getName() + "\".");
    }

    public static Method findMethod(Class cls, String str, Class[] clsArr) {
        Method method = null;
        for (Class cls2 = cls; cls2 != null && method == null; cls2 = cls2.getSuperclass()) {
            try {
                method = cls2.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException | SecurityException unused) {
            }
            if (method != null) {
                return method;
            }
        }
        throw new NoSuchMethodException("Method \"" + str + "\" does not exist in class \"" + cls.getName() + "\".");
    }

    public static int limitExpire(long j10, long j11) {
        if (j11 >= 0 && j11 < j10) {
            j10 = j11;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j10;
        if (currentTimeMillis < 0 || currentTimeMillis > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }

    public int compareCredibility(int i10) {
        return ((Integer) this.compareCredibility.invoke(this.element, Integer.valueOf(i10))).intValue();
    }

    public boolean expired() {
        return ((Boolean) this.expired.invoke(this.element, new Object[0])).booleanValue();
    }

    public int getCredibility() {
        return this.credibilityField.getInt(this.element);
    }

    public Object getElement() {
        return this.element;
    }

    public int getExpire() {
        return this.expireField.getInt(this.element);
    }

    public int getExpiresIn() {
        return getExpire() - ((int) (System.currentTimeMillis() / 1000));
    }

    public long getTTL() {
        Long l10;
        Method method = this.getTTL;
        if (method == null || (l10 = (Long) method.invoke(this.element, new Object[0])) == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public int getType() {
        return ((Integer) this.getType.invoke(this.element, new Object[0])).intValue();
    }

    public void resetExpire() {
        if (this.cache.get() != null) {
            this.expireField.setInt(this.element, limitExpire(getTTL(), this.cache.get().getMaxCache()));
        }
    }
}
