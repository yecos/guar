// Xuper TV Monitor - Known Infrastructure Data
// Based on reverse engineering analysis

export interface DomainInfo {
  domain: string;
  service: string;
  role: "primary" | "backup";
  knownIPs: string[];
}

export interface EndpointInfo {
  path: string;
  method: string;
  version: string;
  category: string;
  description: string;
  encrypted: boolean;
}

// Known domains from RE analysis
export const KNOWN_DOMAINS: DomainInfo[] = [
  { domain: "dtgrd.txhnojlbu.com", service: "portal", role: "primary", knownIPs: ["104.18.18.217", "104.18.19.217"] },
  { domain: "c2tgd.izvhrdcjb.com", service: "portal", role: "backup", knownIPs: ["104.21.76.18", "172.67.185.18"] },
  { domain: "cdtgcr.bcjoapser.com", service: "epg", role: "primary", knownIPs: ["104.21.26.118", "172.67.168.69"] },
  { domain: "bktjr.akvndhzgx.com", service: "epg", role: "backup", knownIPs: ["172.67.223.114", "104.21.91.151"] },
  { domain: "g4tc2.irlapchbd.com", service: "notice", role: "primary", knownIPs: [] },
  { domain: "ckfdr.nzxgfvrud.com", service: "notice", role: "backup", knownIPs: ["104.21.65.254", "172.67.196.170"] },
  { domain: "c2tgd3.ewzpuscyv.com", service: "bigbee", role: "primary", knownIPs: ["104.21.82.53", "172.67.196.17"] },
  { domain: "skvbv.hbcpdutka.com", service: "bigbee", role: "backup", knownIPs: [] },
  { domain: "skc2r.plracsimf.com", service: "ads", role: "primary", knownIPs: [] },
  { domain: "jktgk.bxtzwlyan.com", service: "ads", role: "backup", knownIPs: [] },
  { domain: "bg4gr.msfxethyc.com", service: "h5", role: "primary", knownIPs: ["104.18.18.217", "104.18.19.217"] },
  { domain: "jktgr.ludgwoxhe.com", service: "upgrade", role: "primary", knownIPs: [] },
  { domain: "vtgrc.ncimxztfk.com", service: "upgrade", role: "backup", knownIPs: [] },
  { domain: "cftpbe.39114gi1.com", service: "cdn", role: "primary", knownIPs: [] },
  { domain: "www.magistvec.com", service: "download", role: "primary", knownIPs: [] },
];

// Known API endpoints from RE analysis
export const KNOWN_ENDPOINTS: EndpointInfo[] = [
  // Content & Catalog
  { path: "/api/portalCore/getHome", method: "POST", version: "v1", category: "content", description: "Home screen content layout", encrypted: true },
  { path: "/api/portalCore/v3/getColumnContents", method: "POST", version: "v3", category: "content", description: "Channel/category contents", encrypted: true },
  { path: "/api/portalCore/getNextColumns", method: "POST", version: "v1", category: "content", description: "Subcategory navigation", encrypted: true },
  { path: "/api/portalCore/v4/getItemData", method: "POST", version: "v4", category: "content", description: "Detailed item metadata", encrypted: true },
  { path: "/api/portalCore/v3/getProgram", method: "POST", version: "v3", category: "content", description: "Program/EPG data", encrypted: true },
  { path: "/api/portalCore/v3/searchByName", method: "POST", version: "v3", category: "content", description: "Search by name", encrypted: true },
  { path: "/api/portalCore/v3/searchByContent", method: "POST", version: "v3", category: "content", description: "Search by content", encrypted: true },
  { path: "/api/portalCore/blSearchByContent", method: "POST", version: "v1", category: "content", description: "Broad search", encrypted: true },
  { path: "/api/portalCore/v3/filterGenre", method: "POST", version: "v3", category: "content", description: "Filter by genre", encrypted: true },
  { path: "/api/portalCore/v3/filterByContent", method: "POST", version: "v3", category: "content", description: "Filter by content type", encrypted: true },
  { path: "/api/portalCore/v3/getRecommends", method: "POST", version: "v3", category: "content", description: "Content recommendations", encrypted: true },
  { path: "/api/portalCore/getShortVideo", method: "POST", version: "v1", category: "content", description: "Short video content", encrypted: true },
  { path: "/api/portalCore/config/get", method: "POST", version: "v1", category: "content", description: "App configuration", encrypted: false },
  // Streaming
  { path: "/api/portalCore/v10/startPlayVOD", method: "POST", version: "v10", category: "streaming", description: "Start VOD stream", encrypted: true },
  { path: "/api/portalCore/v4/startPlayLive", method: "POST", version: "v4", category: "streaming", description: "Start live stream", encrypted: true },
  { path: "/api/portalCore/v6/getLiveData", method: "POST", version: "v6", category: "streaming", description: "Live channel data", encrypted: true },
  { path: "/api/portalCore/v5/heartbeat", method: "POST", version: "v5", category: "streaming", description: "Playback heartbeat", encrypted: true },
  // Auth
  { path: "/api/portalCore/v8/login", method: "POST", version: "v8", category: "auth", description: "Email/phone login", encrypted: true },
  { path: "/api/portalCore/v7/login/thirdpart", method: "POST", version: "v7", category: "auth", description: "Third-party login", encrypted: true },
  { path: "/api/portalCore/v3/snToken", method: "POST", version: "v3", category: "auth", description: "SN-based token auth", encrypted: true },
  { path: "/api/portalCore/v8/active", method: "POST", version: "v8", category: "auth", description: "Device activation", encrypted: true },
  { path: "/api/portalCore/v5/loginOut", method: "POST", version: "v5", category: "auth", description: "Logout", encrypted: true },
  { path: "/api/portalCore/v9/getAuthInfo", method: "POST", version: "v9", category: "auth", description: "Get auth info", encrypted: true },
  // Account
  { path: "/api/portalCore/bindPhone", method: "POST", version: "v1", category: "account", description: "Bind phone number", encrypted: true },
  { path: "/api/portalCore/v2/bindEmail", method: "POST", version: "v2", category: "account", description: "Bind email", encrypted: true },
  { path: "/api/portalCore/getBindInfo", method: "POST", version: "v1", category: "account", description: "Get bind info", encrypted: true },
  // Subscriptions
  { path: "/api/portalCore/package/getPackageCustomization", method: "POST", version: "v1", category: "subs", description: "Get subscription packages", encrypted: true },
  { path: "/api/portalCore/package/getOrderInfo", method: "POST", version: "v1", category: "subs", description: "Get order info", encrypted: true },
  { path: "/api/portalCore/v5/exchange", method: "POST", version: "v5", category: "subs", description: "Exchange code", encrypted: true },
  { path: "/api/subs/terminal/metadata", method: "POST", version: "v1", category: "subs", description: "Subscription metadata", encrypted: true },
  // Favorites
  { path: "/api/portalCore/v2/addFavorite", method: "POST", version: "v2", category: "favorites", description: "Add to favorites", encrypted: true },
  { path: "/api/portalCore/delFavorite", method: "POST", version: "v1", category: "favorites", description: "Remove from favorites", encrypted: true },
  { path: "/api/portalCore/getFavorite", method: "POST", version: "v1", category: "favorites", description: "Get favorites list", encrypted: true },
  // EPG & Sports
  { path: "/api/portalCore/epg/v2/getShelveMatch", method: "GET", version: "v2", category: "epg", description: "Shelved matches", encrypted: false },
  { path: "/api/portalCore/epg/v2/getAllMatch", method: "GET", version: "v2", category: "epg", description: "All matches", encrypted: false },
  { path: "/api/portalCore/epg/v3/getFootballMatch", method: "GET", version: "v3", category: "epg", description: "Football matches by date", encrypted: false },
  { path: "/api/portalCore/epg/v5/getNearestMatch", method: "GET", version: "v5", category: "epg", description: "Nearest match", encrypted: false },
  // Device
  { path: "/api/portalCore/device-management/getDevice", method: "POST", version: "v1", category: "device", description: "Get device info", encrypted: true },
  { path: "/api/portalCore/device/updateOrInsert", method: "PUT", version: "v1", category: "device", description: "Register/update device", encrypted: true },
  // Feedback
  { path: "/api/portalCore/feedback/getCustomerService", method: "POST", version: "v1", category: "feedback", description: "Get customer service", encrypted: false },
  { path: "/api/portalCore/feedback/userFeedBack", method: "POST", version: "v1", category: "feedback", description: "Submit feedback", encrypted: false },
  // DCS
  { path: "/api/v2/dcs/getAddr", method: "POST", version: "v2", category: "dcs", description: "Get domain addresses", encrypted: true },
  { path: "/api/configCenter/config/get", method: "POST", version: "v1", category: "dcs", description: "Get app config", encrypted: true },
  // Misc
  { path: "/api/portalCore/qr/getResult", method: "POST", version: "v1", category: "misc", description: "Get QR scan result", encrypted: true },
  { path: "/api/portalCore/getTop", method: "POST", version: "v1", category: "misc", description: "Top rankings", encrypted: true },
  { path: "/api/portalCore/v14/getSlbInfo", method: "POST", version: "v14", category: "misc", description: "SLB info v14", encrypted: true },
  { path: "/api/portalCore/v3/getShelveData", method: "POST", version: "v3", category: "misc", description: "Shelve data", encrypted: true },
];

// Service colors for the dashboard
export const SERVICE_COLORS: Record<string, string> = {
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

export const CATEGORY_COLORS: Record<string, string> = {
  content: "#8b5cf6",
  streaming: "#ef4444",
  auth: "#f59e0b",
  account: "#06b6d4",
  subs: "#22c55e",
  favorites: "#ec4899",
  epg: "#3b82f6",
  device: "#f97316",
  feedback: "#6366f1",
  dcs: "#a855f7",
  misc: "#737373",
};
