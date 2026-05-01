"use client";

import { useEffect, useState, useCallback } from "react";
import {
  Activity,
  AlertTriangle,
  CheckCircle,
  XCircle,
  RefreshCw,
  Globe,
  Shield,
  Clock,
  Zap,
  Eye,
  EyeOff,
  ChevronDown,
  ChevronUp,
  Bell,
  Server,
  Wifi,
  WifiOff,
} from "lucide-react";

// Types
interface DomainStatus {
  id: string;
  domain: string;
  service: string;
  role: string;
  ipAddresses: string[];
  isUp: boolean;
  responseMs: number;
  checkedAt: string;
}

interface AlertItem {
  id: string;
  type: string;
  severity: string;
  title: string;
  description: string;
  isRead: boolean;
  createdAt: string;
}

interface DashboardData {
  domains: DomainStatus[];
  alerts: AlertItem[];
  dcsHistory: { id: string; changed: boolean; diffSummary: string | null; fetchedAt: string }[];
  stats: {
    totalDomains: number;
    upDomains: number;
    downDomains: number;
    unreadAlerts: number;
    lastCheck: string | null;
  };
}

interface MonitorResult {
  success: boolean;
  checkedAt: string;
  domains: {
    domain: string;
    service: string;
    role: string;
    ips: string[];
    isUp: boolean;
    responseMs: number;
    changed: boolean;
    previousIPs: string[];
  }[];
  dcs: { success: boolean; responseMs: number; domain: string };
  newAlerts: string[];
}

const SERVICE_COLORS: Record<string, string> = {
  portal: "#8b5cf6",
  epg: "#06b6d4",
  notice: "#f59e0b",
  bigbee: "#ec4899",
  ads: "#ef4444",
  h5: "#22c55e",
  upgrade: "#f97316",
  cdn: "#3b82f6",
  download: "#6366f1",
};

const SERVICE_LABELS: Record<string, string> = {
  portal: "Portal API",
  epg: "EPG",
  notice: "Notificaciones",
  bigbee: "Analytics",
  ads: "Ads",
  h5: "Web H5",
  upgrade: "Updates",
  cdn: "CDN Imagenes",
  download: "Download",
};

export default function Dashboard() {
  const [data, setData] = useState<DashboardData | null>(null);
  const [monitoring, setMonitoring] = useState(false);
  const [lastRun, setLastRun] = useState<string | null>(null);
  const [monitorResult, setMonitorResult] = useState<MonitorResult | null>(null);
  const [expandedDomain, setExpandedDomain] = useState<string | null>(null);
  const [showAlerts, setShowAlerts] = useState(true);
  const [autoRefresh, setAutoRefresh] = useState(false);
  const [refreshInterval, setRefreshInterval] = useState(5); // minutes
  const [loading, setLoading] = useState(true);

  // Fetch current data
  const fetchData = useCallback(async () => {
    try {
      const res = await fetch("/api/domains");
      if (res.ok) {
        const json = await res.json();
        setData(json);
      }
    } catch (e) {
      console.error("Fetch error:", e);
    } finally {
      setLoading(false);
    }
  }, []);

  // Run monitoring check
  const runCheck = useCallback(async () => {
    setMonitoring(true);
    try {
      const res = await fetch("/api/monitor");
      if (res.ok) {
        const json = await res.json();
        setMonitorResult(json);
        setLastRun(json.checkedAt);
      }
    } catch (e) {
      console.error("Monitor error:", e);
    } finally {
      setMonitoring(false);
      fetchData(); // Refresh data after check
    }
  }, [fetchData]);

  // Mark all alerts as read
  const markAllRead = async () => {
    await fetch("/api/alerts", { method: "POST" });
    fetchData();
  };

  // Auto-refresh
  useEffect(() => {
    fetchData();
    // Run initial check
    runCheck();
  }, [fetchData, runCheck]);

  useEffect(() => {
    if (!autoRefresh) return;
    const interval = setInterval(() => {
      runCheck();
    }, refreshInterval * 60 * 1000);
    return () => clearInterval(interval);
  }, [autoRefresh, refreshInterval, runCheck]);

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-center">
          <RefreshCw className="w-8 h-8 animate-spin mx-auto mb-4 text-purple-500" />
          <p className="text-gray-400">Cargando monitor...</p>
        </div>
      </div>
    );
  }

  const stats = data?.stats || { totalDomains: 0, upDomains: 0, downDomains: 0, unreadAlerts: 0, lastCheck: null };
  const alerts = data?.alerts || [];
  const domains = data?.domains || [];
  const dcsHistory = data?.dcsHistory || [];

  // Group domains by service
  const groupedDomains: Record<string, DomainStatus[]> = {};
  for (const d of domains) {
    if (!groupedDomains[d.service]) groupedDomains[d.service] = [];
    groupedDomains[d.service].push(d);
  }

  return (
    <div className="min-h-screen bg-[#0a0a0f] text-gray-100">
      {/* Header */}
      <header className="border-b border-gray-800 bg-[#0e0e16]">
        <div className="max-w-7xl mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <div className="w-10 h-10 rounded-lg bg-purple-600 flex items-center justify-center">
                <Shield className="w-5 h-5 text-white" />
              </div>
              <div>
                <h1 className="text-xl font-bold text-white">Xuper TV Monitor</h1>
                <p className="text-xs text-gray-500">
                  Monitoreo de infraestructura en tiempo real
                </p>
              </div>
            </div>
            <div className="flex items-center gap-3">
              {/* Auto-refresh toggle */}
              <div className="flex items-center gap-2 bg-[#1a1a28] rounded-lg px-3 py-2">
                <span className="text-xs text-gray-400">Auto:</span>
                <button
                  onClick={() => setAutoRefresh(!autoRefresh)}
                  className={`px-2 py-1 rounded text-xs font-medium ${
                    autoRefresh
                      ? "bg-green-600 text-white"
                      : "bg-gray-700 text-gray-400"
                  }`}
                >
                  {autoRefresh ? `ON (${refreshInterval}m)` : "OFF"}
                </button>
                <select
                  value={refreshInterval}
                  onChange={(e) => setRefreshInterval(Number(e.target.value))}
                  className="bg-gray-800 text-xs text-gray-300 rounded px-1 py-0.5 border border-gray-700"
                >
                  <option value={1}>1m</option>
                  <option value={5}>5m</option>
                  <option value={15}>15m</option>
                  <option value={30}>30m</option>
                  <option value={60}>60m</option>
                </select>
              </div>
              {/* Run check button */}
              <button
                onClick={runCheck}
                disabled={monitoring}
                className="flex items-center gap-2 bg-purple-600 hover:bg-purple-700 disabled:opacity-50 text-white px-4 py-2 rounded-lg text-sm font-medium transition-colors"
              >
                <RefreshCw className={`w-4 h-4 ${monitoring ? "animate-spin" : ""}`} />
                {monitoring ? "Chequeando..." : "Chequear Ahora"}
              </button>
            </div>
          </div>
        </div>
      </header>

      <main className="max-w-7xl mx-auto px-4 py-6 space-y-6">
        {/* Stats Cards */}
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
          <StatCard
            icon={<Globe className="w-5 h-5" />}
            label="Dominios Totales"
            value={stats.totalDomains}
            color="text-purple-400"
            bgColor="bg-purple-900/30"
          />
          <StatCard
            icon={<CheckCircle className="w-5 h-5" />}
            label="En Linea"
            value={stats.upDomains}
            color="text-green-400"
            bgColor="bg-green-900/30"
          />
          <StatCard
            icon={<XCircle className="w-5 h-5" />}
            label="Caidos"
            value={stats.downDomains}
            color="text-red-400"
            bgColor="bg-red-900/30"
          />
          <StatCard
            icon={<Bell className="w-5 h-5" />}
            label="Alertas"
            value={stats.unreadAlerts}
            color="text-yellow-400"
            bgColor="bg-yellow-900/30"
          />
        </div>

        {/* Last check info */}
        {lastRun && (
          <div className="flex items-center gap-2 text-xs text-gray-500">
            <Clock className="w-3 h-3" />
            Ultimo chequeo: {new Date(lastRun).toLocaleString("es")}
            {monitorResult?.newAlerts?.length ? (
              <span className="text-yellow-400 ml-2">
                +{monitorResult.newAlerts.length} alertas nuevas
              </span>
            ) : (
              <span className="text-green-500 ml-2">Sin cambios</span>
            )}
          </div>
        )}

        {/* Monitor result - live check feedback */}
        {monitorResult && (
          <div className="bg-[#12121a] border border-gray-800 rounded-xl p-4">
            <div className="flex items-center gap-2 mb-3">
              <Activity className="w-4 h-4 text-purple-400" />
              <h3 className="text-sm font-semibold">Resultado del Chequeo</h3>
              <span className="text-xs text-gray-500">
                {new Date(monitorResult.checkedAt).toLocaleString("es")}
              </span>
            </div>
            <div className="grid grid-cols-2 md:grid-cols-4 gap-3">
              <div className="text-center p-2 bg-[#1a1a28] rounded-lg">
                <div className="text-lg font-bold text-white">{monitorResult.domains.length}</div>
                <div className="text-xs text-gray-500">Dominios</div>
              </div>
              <div className="text-center p-2 bg-[#1a1a28] rounded-lg">
                <div className="text-lg font-bold text-green-400">
                  {monitorResult.domains.filter((d) => d.isUp).length}
                </div>
                <div className="text-xs text-gray-500">En Linea</div>
              </div>
              <div className="text-center p-2 bg-[#1a1a28] rounded-lg">
                <div className="text-lg font-bold text-red-400">
                  {monitorResult.domains.filter((d) => !d.isUp).length}
                </div>
                <div className="text-xs text-gray-500">Caidos</div>
              </div>
              <div className="text-center p-2 bg-[#1a1a28] rounded-lg">
                <div className="text-lg font-bold text-yellow-400">
                  {monitorResult.domains.filter((d) => d.changed).length}
                </div>
                <div className="text-xs text-gray-500">IPs Cambiadas</div>
              </div>
            </div>
            {monitorResult.dcs.success && (
              <div className="mt-3 flex items-center gap-2 text-xs">
                <Zap className="w-3 h-3 text-cyan-400" />
                <span className="text-cyan-400">DCS respondiendo</span>
                <span className="text-gray-600">via {monitorResult.dcs.domain}</span>
                <span className="text-gray-600">{monitorResult.dcs.responseMs}ms</span>
              </div>
            )}
            {monitorResult.newAlerts.length > 0 && (
              <div className="mt-3 space-y-1">
                {monitorResult.newAlerts.map((a, i) => (
                  <div key={i} className="flex items-center gap-2 text-xs text-yellow-400">
                    <AlertTriangle className="w-3 h-3" />
                    {a}
                  </div>
                ))}
              </div>
            )}
          </div>
        )}

        <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
          {/* Domain Status - 2 columns */}
          <div className="lg:col-span-2 space-y-4">
            <div className="flex items-center justify-between">
              <h2 className="text-lg font-semibold flex items-center gap-2">
                <Server className="w-5 h-5 text-purple-400" />
                Estado de Dominios
              </h2>
            </div>

            {Object.entries(groupedDomains).map(([service, domains]) => (
              <div
                key={service}
                className="bg-[#12121a] border border-gray-800 rounded-xl overflow-hidden"
              >
                <div
                  className="flex items-center gap-3 p-4 cursor-pointer hover:bg-[#1a1a28] transition-colors"
                  onClick={() =>
                    setExpandedDomain(expandedDomain === service ? null : service)
                  }
                >
                  <div
                    className="w-3 h-3 rounded-full"
                    style={{
                      backgroundColor: SERVICE_COLORS[service] || "#737373",
                    }}
                  />
                  <span className="font-medium text-sm">
                    {SERVICE_LABELS[service] || service}
                  </span>
                  <div className="flex items-center gap-1 ml-auto">
                    {domains.map((d, i) =>
                      d.isUp ? (
                        <Wifi key={i} className="w-3 h-3 text-green-400" />
                      ) : (
                        <WifiOff key={i} className="w-3 h-3 text-red-400" />
                      )
                    )}
                  </div>
                  <span className="text-xs text-gray-500">
                    {domains.filter((d) => d.isUp).length}/{domains.length} up
                  </span>
                  {expandedDomain === service ? (
                    <ChevronUp className="w-4 h-4 text-gray-600" />
                  ) : (
                    <ChevronDown className="w-4 h-4 text-gray-600" />
                  )}
                </div>

                {expandedDomain === service && (
                  <div className="border-t border-gray-800 p-3 space-y-2">
                    {domains.map((d) => (
                      <div
                        key={d.id}
                        className="flex items-start gap-3 p-2 rounded-lg bg-[#1a1a28]"
                      >
                        <div className="mt-0.5">
                          {d.isUp ? (
                            <CheckCircle className="w-4 h-4 text-green-400" />
                          ) : (
                            <XCircle className="w-4 h-4 text-red-400" />
                          )}
                        </div>
                        <div className="flex-1 min-w-0">
                          <div className="flex items-center gap-2">
                            <span className="text-xs font-mono text-gray-300 truncate">
                              {d.domain}
                            </span>
                            <span
                              className="text-[10px] px-1.5 py-0.5 rounded"
                              style={{
                                backgroundColor: `${SERVICE_COLORS[d.service] || "#737373"}20`,
                                color: SERVICE_COLORS[d.service] || "#737373",
                              }}
                            >
                              {d.role}
                            </span>
                          </div>
                          <div className="flex items-center gap-3 mt-1">
                            <span className="text-[10px] text-gray-600">
                              IPs: {d.ipAddresses.length > 0 ? d.ipAddresses.join(", ") : "N/A"}
                            </span>
                            {d.responseMs > 0 && (
                              <span className="text-[10px] text-gray-600">
                                {d.responseMs}ms
                              </span>
                            )}
                          </div>
                        </div>
                      </div>
                    ))}
                  </div>
                )}
              </div>
            ))}
          </div>

          {/* Alerts & DCS - 1 column */}
          <div className="space-y-4">
            {/* Alerts */}
            <div className="bg-[#12121a] border border-gray-800 rounded-xl">
              <div className="flex items-center justify-between p-4 border-b border-gray-800">
                <h3 className="text-sm font-semibold flex items-center gap-2">
                  <Bell className="w-4 h-4 text-yellow-400" />
                  Alertas
                  {stats.unreadAlerts > 0 && (
                    <span className="bg-red-600 text-white text-[10px] px-1.5 py-0.5 rounded-full">
                      {stats.unreadAlerts}
                    </span>
                  )}
                </h3>
                <div className="flex items-center gap-2">
                  <button
                    onClick={() => setShowAlerts(!showAlerts)}
                    className="text-gray-500 hover:text-gray-300"
                  >
                    {showAlerts ? (
                      <EyeOff className="w-4 h-4" />
                    ) : (
                      <Eye className="w-4 h-4" />
                    )}
                  </button>
                  {stats.unreadAlerts > 0 && (
                    <button
                      onClick={markAllRead}
                      className="text-[10px] text-purple-400 hover:text-purple-300"
                    >
                      Marcar leidas
                    </button>
                  )}
                </div>
              </div>
              {showAlerts && (
                <div className="max-h-96 overflow-y-auto p-2">
                  {alerts.length === 0 ? (
                    <p className="text-xs text-gray-600 text-center py-4">
                      Sin alertas aun. Ejecuta un chequeo.
                    </p>
                  ) : (
                    alerts.map((alert) => (
                      <div
                        key={alert.id}
                        className={`p-3 rounded-lg mb-1 ${
                          alert.isRead ? "bg-[#1a1a28]" : "bg-[#1a1a28] border-l-2"
                        }`}
                        style={{
                          borderLeftColor:
                            alert.severity === "critical"
                              ? "#ef4444"
                              : alert.severity === "warning"
                              ? "#f59e0b"
                              : "#3b82f6",
                        }}
                      >
                        <div className="flex items-start gap-2">
                          {alert.severity === "critical" ? (
                            <XCircle className="w-3.5 h-3.5 text-red-400 mt-0.5 shrink-0" />
                          ) : alert.severity === "warning" ? (
                            <AlertTriangle className="w-3.5 h-3.5 text-yellow-400 mt-0.5 shrink-0" />
                          ) : (
                            <Zap className="w-3.5 h-3.5 text-blue-400 mt-0.5 shrink-0" />
                          )}
                          <div>
                            <p className="text-xs font-medium text-gray-300">
                              {alert.title}
                            </p>
                            <p className="text-[10px] text-gray-600 mt-0.5">
                              {alert.description}
                            </p>
                            <p className="text-[10px] text-gray-700 mt-1">
                              {new Date(alert.createdAt).toLocaleString("es")}
                            </p>
                          </div>
                        </div>
                      </div>
                    ))
                  )}
                </div>
              )}
            </div>

            {/* DCS History */}
            <div className="bg-[#12121a] border border-gray-800 rounded-xl">
              <div className="p-4 border-b border-gray-800">
                <h3 className="text-sm font-semibold flex items-center gap-2">
                  <Zap className="w-4 h-4 text-cyan-400" />
                  Historial DCS
                </h3>
              </div>
              <div className="max-h-48 overflow-y-auto p-2">
                {dcsHistory.length === 0 ? (
                  <p className="text-xs text-gray-600 text-center py-4">
                    Sin datos DCS aun.
                  </p>
                ) : (
                  dcsHistory.map((dcs) => (
                    <div
                      key={dcs.id}
                      className="flex items-center gap-2 p-2 rounded-lg bg-[#1a1a28] mb-1"
                    >
                      {dcs.changed ? (
                        <AlertTriangle className="w-3.5 h-3.5 text-yellow-400" />
                      ) : (
                        <CheckCircle className="w-3.5 h-3.5 text-green-400" />
                      )}
                      <div className="flex-1">
                        <span className="text-xs text-gray-300">
                          {dcs.changed ? "Cambiado" : "Sin cambios"}
                        </span>
                        {dcs.diffSummary && (
                          <p className="text-[10px] text-gray-600">{dcs.diffSummary}</p>
                        )}
                      </div>
                      <span className="text-[10px] text-gray-700">
                        {new Date(dcs.fetchedAt).toLocaleString("es")}
                      </span>
                    </div>
                  ))
                )}
              </div>
            </div>

            {/* Infrastructure Map */}
            <div className="bg-[#12121a] border border-gray-800 rounded-xl p-4">
              <h3 className="text-sm font-semibold flex items-center gap-2 mb-3">
                <Globe className="w-4 h-4 text-purple-400" />
                Mapa de Infraestructura
              </h3>
              <div className="space-y-2">
                {Object.entries(SERVICE_LABELS).map(([key, label]) => {
                  const serviceDomains = groupedDomains[key] || [];
                  const up = serviceDomains.filter((d) => d.isUp).length;
                  const total = serviceDomains.length;
                  const pct = total > 0 ? (up / total) * 100 : 0;
                  return (
                    <div key={key} className="flex items-center gap-2">
                      <div
                        className="w-2 h-2 rounded-full shrink-0"
                        style={{ backgroundColor: SERVICE_COLORS[key] || "#737373" }}
                      />
                      <span className="text-xs text-gray-400 w-24 truncate">{label}</span>
                      <div className="flex-1 h-1.5 bg-gray-800 rounded-full overflow-hidden">
                        <div
                          className="h-full rounded-full transition-all"
                          style={{
                            width: `${pct}%`,
                            backgroundColor:
                              pct === 100
                                ? "#22c55e"
                                : pct > 0
                                ? "#f59e0b"
                                : "#ef4444",
                          }}
                        />
                      </div>
                      <span className="text-[10px] text-gray-600 w-8 text-right">
                        {up}/{total}
                      </span>
                    </div>
                  );
                })}
              </div>
            </div>

            {/* Quick Reference */}
            <div className="bg-[#12121a] border border-gray-800 rounded-xl p-4">
              <h3 className="text-sm font-semibold flex items-center gap-2 mb-3">
                <Shield className="w-4 h-4 text-green-400" />
                Info de Referencia
              </h3>
              <div className="space-y-2 text-xs text-gray-500">
                <div className="flex justify-between">
                  <span>Encriptacion</span>
                  <span className="text-gray-300">3DES/ECB/PKCS5</span>
                </div>
                <div className="flex justify-between">
                  <span>Protocolo</span>
                  <span className="text-gray-300">HTTP (no HTTPS)</span>
                </div>
                <div className="flex justify-between">
                  <span>DNS</span>
                  <span className="text-gray-300">DoH (8.8.8.8)</span>
                </div>
                <div className="flex justify-between">
                  <span>CDN</span>
                  <span className="text-gray-300">Cloudflare</span>
                </div>
                <div className="flex justify-between">
                  <span>API Endpoints</span>
                  <span className="text-gray-300">60+</span>
                </div>
                <div className="flex justify-between">
                  <span>Dominios conocidos</span>
                  <span className="text-gray-300">15</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>

      {/* Footer */}
      <footer className="border-t border-gray-800 mt-8 py-4 text-center">
        <p className="text-xs text-gray-700">
          Xuper TV Infrastructure Monitor - Basado en analisis RE v6.5.0
        </p>
      </footer>
    </div>
  );
}

// Stat Card Component
function StatCard({
  icon,
  label,
  value,
  color,
  bgColor,
}: {
  icon: React.ReactNode;
  label: string;
  value: number;
  color: string;
  bgColor: string;
}) {
  return (
    <div className={`${bgColor} border border-gray-800 rounded-xl p-4`}>
      <div className="flex items-center gap-2 mb-2">
        <span className={color}>{icon}</span>
        <span className="text-xs text-gray-500">{label}</span>
      </div>
      <div className={`text-2xl font-bold ${color}`}>{value}</div>
    </div>
  );
}
