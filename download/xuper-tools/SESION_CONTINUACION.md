# Xuper TV - Reverse Engineering Project
## Estado del Proyecto - Documento de Traspaso

> **Fecha:** 2026-05-01
> **Propósito:** Permitir que una nueva sesión continúe el trabajo sin pérdida de contexto

---

## 1. RESUMEN EJECUTIVO

Se está haciendo **reverse engineering** de la app IPTV **Xuper TV** para construir una app de streaming propia. El proyecto ha avanzado significativamente pero tiene un **bloqueador crítico**: los servidores rechazan versionCode antiguos con el mensaje "版本已停止使用" (versión descontinuada).

**Estado actual:** ✅ Infraestructura completa | ❌ Bloqueado por versionCode

---

## 2. BLOQUEADOR CRÍTICO - ACCIÓN INMEDIATA REQUERIDA

### Problema
Los servidores de Xuper TV validan el `versionCode` en cada petición API. Versiones antiguas reciben:
```json
{"msg": "版本已停止使用", "code": 403}
```

### versionCodes conocidos
| Versión APK | versionCode | Estado |
|---|---|---|
| 6.2.1 (APK vieja del celular) | 60201 | ❌ RECHAZADO |
| 6.5.0 (extraída del emulador) | 60500 | ❌ RECHAZADO |
| 6.5.4 (APK nueva - pendiente) | ~60504+ | ❓ PENDIENTE DE EXTRACCIÓN |

### Solución - PASO 1 DE LA NUEVA SESIÓN
1. **El usuario debe proporcionar la APK nueva** (v6.5.4 o superior)
2. Ejecutar el analyzer: `python3 /home/z/my-project/download/xuper-tools/xuper-apk-analyzer.py NUEVA_APK.apk --update-monitor`
3. El script extrae automáticamente el versionCode y actualiza la configuración
4. Probar APIs con el nuevo versionCode: `./xuper-update.sh --test-api NUEVO_VERSION_CODE`

### Si la APK nueva también falla
- Probar versionCodes incrementales: 60501, 60502, 60503, 60504, 60505, etc.
- Buscar en la Google Play Store metadata (a veces tienen el versionCode en el HTML)
- Usar APKPure o similar para obtener la última versión

---

## 3. INFRAESTRUCTURA DE DOMINIOS

### 15 Dominios API (detrás de Cloudflare)
Los dominios usan un patrón obfuscado: `XXXXX.YYYYYYY.com` donde XXXXX y YYYYYY son secuencias aleatorias de 5-7 caracteres.

**Dominios confirmados:**
```
c2tgd.izvhrdcjb.com
dtgrd.txhnojlbu.com
cftpbe.39114gi1.com
skvbv.hbcpdutka.com
jktgk.bxtzwlyan.com
mekdw.htvbox.club
```

**Dominios bajo patrón `*.puata.info` (13 subdominios):**
```
kexun.puata.info
lvjian.puata.info
zhipu.puata.info
xingse.puata.info
baoxian.puata.info
zhubao.puata.info
jiaoyu.puata.info
meishi.puata.info
chuanmei.puata.info
youxuan.puata.info
lvxing.puata.info
dianying.puata.info
yumao.puata.info
```

**CDN IP:** `223.109.148.179` (resuelve para todos los dominios puata.info)

### Dominio especial: `yumao.puata.info`
- Endpoint `/api/portalCore/v8/login` respondió (aunque vacío)
- Puede ser un dominio de respaldo o migración

---

## 4. ENDPOINTS API DESCUBIERTOS

### Endpoints principales
| Endpoint | Método | Propósito |
|---|---|---|
| `/api/portalCore/v8/login` | POST | Login principal |
| `/api/portalCore/v6/login` | POST | Login versión anterior |
| `/api/portalCore/pwdCheck` | POST | Verificación de contraseña |
| `/api/portalCore/config/get` | GET | Configuración del portal |
| `/api/v2/dcs/getAddr` | POST | Obtener dirección de servidor |
| `/cc_info` | GET | Info del servidor (requiere GZIP) |
| `/api/portalCore/getAuthInfo` | POST | Info de autenticación |
| `/api/portalCore/getHome` | POST | Home del portal |

### Headers requeridos en las peticiones
```
versionCode: <VERSION_CODE_ACTUAL>
platform: android
Content-Type: application/json  (o application/x-www-form-urlencoded)
User-Agent: Dalvik/2.1.0 (Linux; U; Android 14)
```

---

## 5. CREDENCIALES EXTRADAS

### Cuenta del emulador
```json
{
  "user_id": "888345958",
  "key_sn": "a80ee514a9e56adb67cacd42ea078ae5",
  "device_id": "AtUv_jwdFowZKa7PpDHV6FXyXI_ctblfcvsWAbLhztnt",
  "utdid": "afQpQbwEZ7QDAGwYjrcHaJUO"
}
```

### Umeng (analytics)
```json
{
  "appkey": "68b903e0e563686f429a3a60",
  "push_message_secret": "8cd8a8bfd892266a51cf9332e20381cd",
  "ek_key": "TJjXE2M16KIGKzxsvtvqgw=="
}
```

### 3DES Encryption
- Los valores de `host` en la app están encriptados con 3DES
- La clave 3DES está hardcodeada en el código de la app
- El analyzer (`xuper-apk-analyzer.py`) busca claves automáticamente

---

## 6. HERRAMIENTAS DISPONIBLES

### Scripts principales (`/home/z/my-project/download/xuper-tools/`)

| Archivo | Propósito | Uso |
|---|---|---|
| `xuper-apk-analyzer.py` | Analiza APKs con androguard | `python3 xuper-apk-analyzer.py APK.apk [--full] [--update-monitor]` |
| `xuper-update.sh` | Wrapper interactivo | `./xuper-update.sh --apk APK.apk` o `--auto` o `--test-api` |
| `xuper-api-monitor.sh` | Monitoreo continuo de APIs | `./xuper-api-monitor.sh [VERSION_CODE]` |
| `generate_report.py` | Genera reporte PDF de análisis | `python3 generate_report.py` |
| `generate-guide.js` | Genera guía instructiva | `node generate-guide.js` |

### APK existente
- `/home/z/my-project/download/xuper_celular.apk` — v6.2.1, versionCode 60201 (OBSOLETO)

### Datos extraídos
- `/home/z/my-project/download/xuper_extracted_credentials.json` — Credenciales completas
- `/home/z/my-project/download/xuper_server_discovery.json` — Resultados de descubrimiento
- `/home/z/my-project/download/xuper_api_test_results.json` — Resultados de pruebas API
- `/home/z/my-project/download/xuper_extracted/` — APK decompilada (resources, META-INF, etc.)

---

## 7. REPOSITORIO GITHUB

**URL:** https://github.com/yecos/guar
**Token (¡REVOCAR!):** Ver remote config con `git remote -v` — el token está en la URL del remote. **DEBE ser revocado** inmediatamente en:
https://github.com/settings/tokens

### Estado del repo
- 5 commits en main
- Archivos grandes (jadx.jar, APKs) fueron limpiados del historial con `git-filter-repo`
- Se agregó `.gitignore` para prevenir commits de archivos grandes
- Último push: exitoso (force push después de limpiar historial)

### Archivos en el repo
```
xuper-tools/
├── .gitignore
├── xuper-apk-analyzer.py     # Analyzer principal
├── xuper-update.sh            # Script de automatización
├── xuper-api-monitor.sh       # Monitor de APIs
├── generate_report.py         # Generador de reportes
└── generate-guide.js          # Generador de guía
```

---

## 8. MONITOR DASHBOARD (Next.js)

### Estado: ✅ Funcional (pero no desplegado)

El dashboard de monitoreo fue construido con Next.js + better-sqlite3. Mostraba 15 dominios UP.

**Problemas pendientes para despliegue:**
- better-sqlite3 no funciona en Vercel (necesita Turso/libSQL)
- Mencionado pero NO iniciado: migrar a Turso DB para despliegue en Vercel
- El código del monitor NO está en el repo de GitHub actualmente (estaba en `/home/z/my-project/download/xuper-monitor/` que ya no existe en este entorno)

### Para reconstruir el monitor
```bash
# Si se necesita recrear:
npx create-next-app@latest xuper-monitor
# Agregar better-sqlite3 o @libsql/client
# Los dominios están en el archivo xuper-api-monitor.sh y en este documento
```

---

## 9. COMANDOS LISTOS PARA EJECUTAR

### Cuando el usuario proporcione la APK nueva:
```bash
# 1. Analizar la APK
python3 /home/z/my-project/download/xuper-tools/xuper-apk-analyzer.py /path/to/nueva.apk --update-monitor

# 2. Probar APIs con el nuevo versionCode
cd /home/z/my-project/download/xuper-tools
./xuper-update.sh --test-api NUEVO_VERSION_CODE

# 3. O probar directamente con curl
curl -s -m 10 \
  -X POST "https://yumao.puata.info/api/portalCore/v8/login" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -H "versionCode: NUEVO_VERSION_CODE" \
  -H "platform: android" \
  -H "User-Agent: Dalvik/2.1.0 (Linux; U; Android 14)" \
  -d "username=test&password=test"

# 4. Monitoreo continuo
./xuper-api-monitor.sh NUEVO_VERSION_CODE
```

### Brute-force de versionCodes (si la APK nueva tampoco funciona):
```bash
for vc in $(seq 60504 60520); do
  echo -n "Testing versionCode $vc: "
  resp=$(curl -s -m 5 -X POST "https://yumao.puata.info/api/portalCore/v8/login" \
    -H "Content-Type: application/x-www-form-urlencoded" \
    -H "versionCode: $vc" \
    -H "platform: android" \
    -d "username=test&password=test" 2>/dev/null)
  if echo "$resp" | grep -q "版本已停止使用"; then
    echo "REJECTED"
  elif [ -n "$resp" ]; then
    echo "POSSIBLE HIT! Response: $(echo $resp | head -c 200)"
  else
    echo "NO RESPONSE"
  fi
done
```

---

## 10. FLUJO DE TRABAJO RECOMENDADO PARA LA PRÓXIMA SESIÓN

1. **Pedir la APK nueva al usuario** — Es el bloqueador #1
2. **Ejecutar xuper-apk-analyzer.py** con la APK nueva
3. **Probar APIs** con el versionCode extraído
4. **Si funciona:** 
   - Documentar endpoints funcionales
   - Construir app propia con las APIs descubiertas
   - Actualizar el monitor dashboard
5. **Si no funciona:**
   - Probar versionCodes incrementales (brute force)
   - Buscar versionCode en Google Play / APKPure metadata
   - Considerar MITM proxy con teléfono real (la app funciona ahí)
6. **Revocar el token de GitHub** lo antes posible
7. **Migrar monitor a Turso/Vercel** si se quiere desplegar

---

## 11. LECCIONES APRENDIDAS

- Los servidores usan Cloudflare como proxy — las IPs directas no sirven para bypassear
- El versionCode se valida en TODOS los endpoints, no solo en login
- La app usa 3DES para encriptar los valores de host — las claves están en el código
- El paquete real es `com.msandroid.mobile` (no `com.xuper.tv`)
- Los dominios rotan periódicamente — el monitor debe actualizarse con cada nueva APK
- APKs de más de 100MB no se pueden subir a GitHub sin LFS

---

## 12. ARCHIVOS DE CONTEXTO ADICIONALES

| Archivo | Contenido |
|---|---|
| `/home/z/my-project/download/Xuper_TV_Reverse_Engineering_Report.docx` | Reporte completo de reverse engineering |
| `/home/z/my-project/download/Xuper_TV_Analisis_v654.pdf` | Análisis de la v6.5.4 |
| `/home/z/my-project/download/Xuper_TV_API_Access_Automation_Instructive.pdf` | Instructivo de automatización |
| `/home/z/my-project/download/Xuper_TV_Instructivo_Proxima_Sesion.docx` | Instructivo para próxima sesión |
| `/home/z/my-project/download/github_xuper_releases.json` | Releases de GitHub de Xuper TV |
