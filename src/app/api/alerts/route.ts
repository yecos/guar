import { NextResponse } from "next/server";
import { getDb } from "@/lib/db-sqlite";

export const dynamic = "force-dynamic";

export async function PATCH(request: Request) {
  try {
    const { id } = await request.json();
    const db = getDb();
    db.prepare("UPDATE alert SET is_read = 1 WHERE id = ?").run(id);
    return NextResponse.json({ success: true });
  } catch (error: unknown) {
    const msg = error instanceof Error ? error.message : "Unknown error";
    return NextResponse.json({ error: msg }, { status: 500 });
  }
}

export async function POST() {
  try {
    const db = getDb();
    db.prepare("UPDATE alert SET is_read = 1 WHERE is_read = 0").run();
    return NextResponse.json({ success: true });
  } catch (error: unknown) {
    const msg = error instanceof Error ? error.message : "Unknown error";
    return NextResponse.json({ error: msg }, { status: 500 });
  }
}
