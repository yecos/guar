import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "Xuper TV Monitor - Infrastructure Dashboard",
  description: "Real-time monitoring of Xuper TV streaming platform infrastructure",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="es">
      <body>{children}</body>
    </html>
  );
}
