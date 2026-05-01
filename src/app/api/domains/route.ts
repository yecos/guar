import { NextResponse } from "next/server";
import { getDb } from "@/lib/db-sqlite";

export const dynamic = "force-dynamic";

export async function GET() {
  try {
    const db = getDb();

    // Get latest snapshot per domain
    const latestSnapshots = db.prepare(
      `SELECT ds.* FROM domain_snapshot ds
       INNER JOIN (
         SELECT domain, MAX(checked_at) as max_checked
         FROM domain_snapshot
         GROUP BY domain
       ) latest ON ds.domain = latest.domain AND ds.checked_at = latest.max_checked
       ORDER BY ds.service, ds.role`
    ).all() as Array<{
      id: string; domain: string; service: string; role: string;
      ip_addresses: string; is_up: number; response_ms: number;
      checked_at: string; created_at: string;
    }>;

    const alerts = db.prepare(
      "SELECT * FROM alert ORDER BY created_at DESC LIMIT 50"
    ).all() as Array<{
      id: string; type: string; severity: string; title: string;
      description: string; is_read: number; created_at: string;
    }>;

    const dcsHistory = db.prepare(
      "SELECT id, changed, diff_summary, fetched_at FROM dcs_response ORDER BY fetched_at DESC LIMIT 10"
    ).all();

    const domainStatus = latestSnapshots.map((s) => ({
      ...s,
      ipAddresses: JSON.parse(s.ip_addresses),
      isUp: s.is_up === 1,
      responseMs: s.response_ms,
    }));

    const totalDomains = domainStatus.length;
    const upDomains = domainStatus.filter((d) => d.isUp).length;
    const downDomains = totalDomains - upDomains;
    const unreadAlerts = alerts.filter((a) => a.is_read === 0).length;

    return NextResponse.json({
      domains: domainStatus,
      alerts: alerts.map((a) => ({ ...a, isRead: a.is_read === 1 })),
      dcsHistory,
      stats: {
        totalDomains,
        upDomains,
        downDomains,
        unreadAlerts,
        lastCheck: latestSnapshots[0]?.checked_at || null,
      },
    });
  } catch (error: unknown) {
    const msg = error instanceof Error ? error.message : "Unknown error";
    return NextResponse.json({ error: msg }, { status: 500 });
  }
}
