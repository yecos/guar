// Domain DNS resolution and health checker
// Runs in the server-side API routes

import { KNOWN_DOMAINS, type DomainInfo } from "./monitor-data";

export interface CheckResult {
  domain: string;
  service: string;
  role: "primary" | "backup";
  ips: string[];
  isUp: boolean;
  responseMs: number;
  changed: boolean; // IP change detected
  previousIPs: string[];
}

// Resolve DNS using public DoH (DNS-over-HTTPS) 
async function resolveDNS(domain: string): Promise<string[]> {
  const ips: string[] = [];
  try {
    // Use Cloudflare DoH
    const res = await fetch(
      `https://cloudflare-dns.com/dns-query?name=${domain}&type=A`,
      { headers: { accept: "application/dns-json" } }
    );
    const data = await res.json();
    if (data.Answer) {
      for (const answer of data.Answer) {
        if (answer.type === 1 && answer.data) {
          ips.push(answer.data);
        }
      }
    }
  } catch {
    // Fallback to Google DoH
    try {
      const res = await fetch(
        `https://dns.google/resolve?name=${domain}&type=A`
      );
      const data = await res.json();
      if (data.Answer) {
        for (const answer of data.Answer) {
          if (answer.type === 1 && answer.data) {
            ips.push(answer.data);
          }
        }
      }
    } catch {
      // DNS resolution failed
    }
  }
  return ips;
}

// Check if a domain responds to HTTP
async function checkHTTP(domain: string): Promise<{ isUp: boolean; responseMs: number }> {
  const start = Date.now();
  try {
    const controller = new AbortController();
    const timeout = setTimeout(() => controller.abort(), 10000);
    const res = await fetch(`http://${domain}/`, {
      method: "HEAD",
      signal: controller.signal,
      redirect: "manual",
    });
    clearTimeout(timeout);
    return { isUp: res.status < 500, responseMs: Date.now() - start };
  } catch {
    return { isUp: false, responseMs: Date.now() - start };
  }
}

// Check all known domains
export async function checkAllDomains(knownPreviousIPs?: Record<string, string[]>): Promise<CheckResult[]> {
  const results: CheckResult[] = [];
  
  // Run checks in parallel batches of 5
  for (let i = 0; i < KNOWN_DOMAINS.length; i += 5) {
    const batch = KNOWN_DOMAINS.slice(i, i + 5);
    const batchResults = await Promise.all(
      batch.map(async (d: DomainInfo) => {
        const [ips, httpCheck] = await Promise.all([
          resolveDNS(d.domain),
          checkHTTP(d.domain),
        ]);
        const prevIPs = knownPreviousIPs?.[d.domain] || d.knownIPs;
        const changed = prevIPs.length > 0 && 
          ips.length > 0 && 
          JSON.stringify(ips.sort()) !== JSON.stringify(prevIPs.sort());
        
        return {
          domain: d.domain,
          service: d.service,
          role: d.role,
          ips,
          isUp: httpCheck.isUp || ips.length > 0,
          responseMs: httpCheck.responseMs,
          changed,
          previousIPs: prevIPs,
        };
      })
    );
    results.push(...batchResults);
  }
  
  return results;
}

// Check DCS endpoint
export async function checkDCS(): Promise<{
  success: boolean;
  data: string | null;
  responseMs: number;
  domain: string;
}> {
  // Try to reach DCS through known domains
  const dcsDomains = ["dtgrd.txhnojlbu.com", "c2tgd.izvhrdcjb.com"];
  
  for (const domain of dcsDomains) {
    const start = Date.now();
    try {
      const controller = new AbortController();
      const timeout = setTimeout(() => controller.abort(), 15000);
      const res = await fetch(`http://${domain}/api/v2/dcs/getAddr`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json;charset=utf-8",
          "apk": "com.msandroid.mobile",
          "apkVer": "60500",
        },
        body: JSON.stringify({ appId: "3" }),
        signal: controller.signal,
      });
      clearTimeout(timeout);
      const text = await res.text();
      return {
        success: res.status < 500,
        data: text,
        responseMs: Date.now() - start,
        domain,
      };
    } catch {
      continue;
    }
  }
  
  return { success: false, data: null, responseMs: 0, domain: "" };
}
