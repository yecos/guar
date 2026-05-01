package com.hpplay.cybergarage.upnp;

import java.util.Vector;

/* loaded from: classes2.dex */
public class ArgumentList extends Vector {
    public static final String ELEM_NAME = "argumentList";

    /* JADX WARN: Multi-variable type inference failed */
    public Argument getArgument(int i10) {
        return (Argument) get(i10);
    }

    public void set(ArgumentList argumentList) {
        int size = argumentList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = argumentList.getArgument(i10);
            Argument argument2 = getArgument(argument.getName());
            if (argument2 != null) {
                argument2.setValue(argument.getValue());
            }
        }
    }

    public void setReqArgs(ArgumentList argumentList) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = getArgument(i10);
            if (argument.isInDirection()) {
                String name = argument.getName();
                Argument argument2 = argumentList.getArgument(name);
                if (argument2 == null) {
                    throw new IllegalArgumentException("Argument \"" + name + "\" missing.");
                }
                argument.setValue(argument2.getValue());
            }
        }
    }

    public void setResArgs(ArgumentList argumentList) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = getArgument(i10);
            if (argument.isOutDirection()) {
                String name = argument.getName();
                Argument argument2 = argumentList.getArgument(name);
                if (argument2 == null) {
                    throw new IllegalArgumentException("Argument \"" + name + "\" missing.");
                }
                argument.setValue(argument2.getValue());
            }
        }
    }

    public Argument getArgument(String str) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            Argument argument = getArgument(i10);
            String name = argument.getName();
            if (name != null && name.equals(str)) {
                return argument;
            }
        }
        return null;
    }
}
