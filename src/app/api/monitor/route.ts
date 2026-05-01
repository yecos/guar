import { NextResponse } from "next/server";
import { checkAllDomains, checkDCS } from "@/lib/domain-checker";
import { getDb, generateId } from "@/lib/db-sqlite";

export const dynamic = "force-dynamic";
export const maxDuration = 300; // 5 minute timeout for this route

export async function GET() {
  try {
    const db = getDb();

    // Get previous IPs from latest snapshot for change detection
    const latestSnapshots = db.prepare(
      "SELECT domain, ip_addresses FROM domain_snapshot WHERE id IN (SELECT MAX(id) FROM domain_snapshot GROUP BY domain)"
    ).all() as { domain: string; ip_addresses: string }[];

    const previousIPs: Record<string, string[]> = {};
    for (const snap of latestSnapshots) {
      try {
        previousIPs[snap.domain] = JSON.parse(snap.ip_addresses);
      } catch {
        previousIPs[snap.domain] = [];
      }
    }

    // Run domain checks (DNS only, fast)
    const results = await checkAllDomains(previousIPs);
    const newAlerts: string[] = [];
    const now = new Date().toISOString();

    const insertDomain = db.prepare(
      "INSERT INTO domain_snapshot (id, domain, service, role, ip_addresses, is_up, response_ms, checked_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
    );
    const insertAlert = db.prepare(
      "INSERT INTO alert (id, type, severity, title, description, created_at) VALUES (?, ?, ?, ?, ?, ?)"
    );

    for (const result of results) {
      insertDomain.run(
        generateId(),
        result.domain,
        result.service,
        result.role,
        JSON.stringify(result.ips),
        result.isUp ? 1 : 0,
        result.responseMs,
        now
      );

      if (result.changed) {
        insertAlert.run(
          generateId(), "domain_change", "warning",
          `IP changed: ${result.domain}`,
          `${result.service} (${result.role}) IP changed from ${result.previousIPs.join(", ")} to ${result.ips.join(", ")}`,
          now
        );
        newAlerts.push(`${result.domain}: IP changed`);
      }

      if (!result.isUp && result.previousIPs.length > 0) {
        insertAlert.run(
          generateId(), "endpoint_down", "critical",
          `Domain down: ${result.domain}`,
          `${result.service} (${result.role}) is not responding`,
          now
        );
        newAlerts.push(`${result.domain}: DOWN`);
      }
    }

    // Check DCS (skip if all domain checks failed)
    let dcsResult: { success: boolean; data: string | null; responseMs: number; domain: string } = { success: false, data: null, responseMs: 0, domain: "" };
    try {
      dcsResult = await checkDCS();
    } catch {
      // DCS check failed, continue
    }

    if (dcsResult.success && dcsResult.data) {
      const lastDCS = db.prepare(
        "SELECT raw_data FROM dcs_response ORDER BY fetched_at DESC LIMIT 1"
      ).get() as { raw_data: string } | undefined;

      const changed = lastDCS ? lastDCS.raw_data !== dcsResult.data : false;

      db.prepare(
        "INSERT INTO dcs_response (id, raw_data, domain_count, changed, diff_summary, fetched_at) VALUES (?, ?, ?, ?, ?, ?)"
      ).run(
        generateId(), dcsResult.data, dcsResult.data.length,
        changed ? 1 : 0,
        changed ? "DCS response differs from previous snapshot" : null,
        now
      );

      if (changed) {
        insertAlert.run(
          generateId(), "dcs_change", "warning",
          "DCS response changed",
          "The Domain Configuration Service returned different data. Domains may have been rotated.",
          now
        );
        newAlerts.push("DCS: Response changed");
      }
    }

    return NextResponse.json({
      success: true,
      checkedAt: now,
      domains: results,
      dcs: dcsResult,
      newAlerts,
    });
  } catch (error: unknown) {
    const msg = error instanceof Error ? error.message : "Unknown error";
    return NextResponse.json({ success: false, error: msg }, { status: 500 });
  }
}
