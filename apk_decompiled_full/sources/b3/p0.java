package b3;

/* loaded from: classes.dex */
public enum p0 {
    TRUE,
    FALSE,
    DEFAULT;

    public static boolean b(Boolean bool, Boolean bool2) {
        return bool == null ? bool2 == null : bool.equals(bool2);
    }

    public Boolean a() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }
}
