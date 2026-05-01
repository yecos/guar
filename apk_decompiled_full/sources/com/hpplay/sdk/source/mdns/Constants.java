package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Name;

/* loaded from: classes3.dex */
public interface Constants {
    public static final String BROWSE_DOMAIN_NAME = "b._dns-sd._udp";
    public static final int CACHE_FLUSH = 32768;
    public static final long DEFAULT_A_TTL = 120;
    public static final String DEFAULT_BROWSE_DOMAIN_NAME = "db._dns-sd._udp";
    public static final String DEFAULT_IPv4_ADDRESS = "224.0.0.251";
    public static final String DEFAULT_IPv6_ADDRESS = "FF02::FB";
    public static final long DEFAULT_OTHER_TTL = 4500;
    public static final int DEFAULT_PORT = 5353;
    public static final long DEFAULT_PTR_TTL = 4500;
    public static final String DEFAULT_REGISTRATION_DOMAIN_NAME = "dr._dns-sd._udp";
    public static final long DEFAULT_RR_WITHOUT_HOST_TTL = 4500;
    public static final long DEFAULT_RR_WITH_HOST_TTL = 120;
    public static final long DEFAULT_SRV_TTL = 120;
    public static final long DEFAULT_TXT_TTL = 4500;
    public static final String LEGACY_BROWSE_DOMAIN_NAME = "lb._dns-sd._udp";
    public static final String REGISTRATION_DOMAIN_NAME = "r._dns-sd._udp";
    public static final String SERVICES_NAME = "_services._dns-sd._udp";
    public static final String LINK_LOCAL_DOMAIN = "local.";
    public static final Name[] ALL_MULTICAST_DNS_DOMAINS = {Name.fromConstantString(LINK_LOCAL_DOMAIN), Name.fromConstantString("254.169.in-addr.arpa."), Name.fromConstantString("8.e.f.ip6.arpa."), Name.fromConstantString("9.e.f.ip6.arpa."), Name.fromConstantString("a.e.f.ip6.arpa."), Name.fromConstantString("b.e.f.ip6.arpa.")};
    public static final Name[] IPv4_MULTICAST_DOMAINS = {Name.fromConstantString(LINK_LOCAL_DOMAIN), Name.fromConstantString("254.169.in-addr.arpa.")};
    public static final Name[] IPv6_MULTICAST_DOMAINS = {Name.fromConstantString(LINK_LOCAL_DOMAIN), Name.fromConstantString("8.e.f.ip6.arpa."), Name.fromConstantString("9.e.f.ip6.arpa."), Name.fromConstantString("a.e.f.ip6.arpa."), Name.fromConstantString("b.e.f.ip6.arpa.")};
}
