package com.fasterxml.jackson.databind.ser.std;

import com.hpplay.cybergarage.soap.SOAP;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* loaded from: classes.dex */
public class q extends h0 {
    public q() {
        super(InetSocketAddress.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(InetSocketAddress inetSocketAddress, c3.h hVar, k3.c0 c0Var) {
        String substring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int indexOf = hostName.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                if (address instanceof Inet6Address) {
                    substring = "[" + hostName.substring(1) + "]";
                } else {
                    substring = hostName.substring(1);
                }
                hostName = substring;
            } else {
                hostName = hostName.substring(0, indexOf);
            }
        }
        hVar.z0(hostName + SOAP.DELIM + inetSocketAddress.getPort());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(InetSocketAddress inetSocketAddress, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.f(inetSocketAddress, InetSocketAddress.class, c3.n.VALUE_STRING));
        serialize(inetSocketAddress, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
