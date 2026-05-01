package u3;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum d {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL,
    ANY;


    /* renamed from: i, reason: collision with root package name */
    public static final Map f19031i = new HashMap();

    static {
        for (d dVar : values()) {
            f19031i.put(dVar.name().toLowerCase(), dVar);
        }
    }
}
