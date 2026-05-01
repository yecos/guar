# Xuper TV Monitor

Dashboard de monitoreo en tiempo real de la infraestructura de Xuper TV.

## Funcionalidades

- **Monitoreo DNS** — Resuelve los 15 dominios conocidos usando DNS-over-HTTPS (Cloudflare + Google)
- **Deteccion de cambios de IP** — Compara snapshots anteriores y genera alertas si un dominio cambio su IP
- **Chequeo DCS** — Monitorea el endpoint `/api/v2/dcs/getAddr` que distribuye los dominios de la app
- **Panel de alertas** — Alertas automaticas cuando hay cambios en la infraestructura
- **Auto-refresh** — Chequeo automatico configurable (1-60 minutos)
- **Base de datos SQLite** — Historial completo de snapshots y alertas

## Stack

- **Next.js 16** (App Router)
- **TypeScript**
- **Tailwind CSS 4**
- **better-sqlite3** (base de datos local)
- **Lucide React** (iconos)

## Instalacion

```bash
npm install
```

## Uso local

```bash
# Desarrollo
npm run dev

# Produccion
npm run build
npm start
```

Abre [http://localhost:3000](http://localhost:3000) en tu navegador.

## Estructura del proyecto

```
src/
  app/
    page.tsx              # Dashboard principal
    layout.tsx            # Layout con metadata
    globals.css           # Estilos globales
    api/
      monitor/route.ts    # API: ejecutar chequeo de dominios
      domains/route.ts    # API: obtener estado actual
      alerts/route.ts     # API: gestionar alertas
  lib/
    domain-checker.ts     # Logica de resolucion DNS y chequeo HTTP
    db-sqlite.ts          # Base de datos SQLite (better-sqlite3)
    monitor-data.ts       # Dominios y endpoints conocidos (del RE)
prisma/
  schema.prisma           # Schema de la base de datos
```

## Dominios monitoreados

| Servicio | Dominio | Rol |
|----------|---------|-----|
| Portal API | dtgrd.txhnojlbu.com | Primary |
| Portal API | c2tgd.izvhrdcjb.com | Backup |
| EPG | cdtgcr.bcjoapser.com | Primary |
| EPG | bktjr.akvndhzgx.com | Backup |
| Notificaciones | g4tc2.irlapchbd.com | Primary |
| Notificaciones | ckfdr.nzxgfvrud.com | Backup |
| Analytics | c2tgd3.ewzpuscyv.com | Primary |
| Analytics | skvbv.hbcpdutka.com | Backup |
| Ads | skc2r.plracsimf.com | Primary |
| Ads | jktgk.bxtzwlyan.com | Backup |
| Web H5 | bg4gr.msfxethyc.com | Primary |
| Updates | jktgr.ludgwoxhe.com | Primary |
| Updates | vtgrc.ncimxztfk.com | Backup |
| CDN Imagenes | cftpbe.39114gi1.com | Primary |
| Download | www.magistvec.com | Primary |

## Deploy en Vercel

Para deployar en Vercel, necesitas cambiar SQLite por Turso (SQLite en la nube):

1. Crear cuenta en [Turso](https://turso.tech)
2. Obtener la URL y token de la base de datos
3. Configurar variables de entorno: `TURSO_URL` y `TURSO_AUTH_TOKEN`
4. Modificar `src/lib/db-sqlite.ts` para usar Turso en produccion

## Licencia

Uso privado — Proyecto de investigacion.
