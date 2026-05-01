# Xuper TV - Reverse Engineering Project
## Estado del Proyecto - Documento de Traspaso ACTUALIZADO

> **Fecha:** 2026-05-01 (Sesión 3)
> **Propósito:** Permitir que una nueva sesión continúe el trabajo sin pérdida de contexto

---

## 1. RESUMEN EJECUTIVO - CAMBIO CRÍTICO

Se está haciendo **reverse engineering** de la app IPTV **Xuper TV** para construir una app de streaming propia.

### ⚠️ HALLAZGO CRÍTICO DE ESTA SESIÓN:
El error "版本已停止使用" **NO es un problema de versionCode**. Es un **CIERRE DEL SERVICIO**. TODOS los versionCodes son rechazados (probamos desde 43400 hasta 70200). El backend portalCore está siendo descontinuado.

**Estado actual:** ✅ Infraestructura completa | ❌ API backend DESCONTINUADO | 🔄 Necesita pivotear a Xup3rTV o nueva fuente

---

## 2. HALLAZGOS DE ESTA SESión (Sesión 3)

### 2.1 APKs analizadas
| APK | Versión | versionCode | Ubicación |
|---|---|---|---|
| xuper_celular.apk | 6.2.1 | 60201 | `/home/z/my-project/download/` |
| Xupertv_latest_version.apk | 6.5.4 | 60504 | `/home/z/my-project/upload/` |
| descargar_Xuper_tv_6_5_5_ultima_version_celular.apk | 6.5.5 | 60505 | `/home/z/my-project/upload/` |
| xuper_base.apk | ? | ? | `/home/z/my-project/upload/` |

### 2.2 Resultados de pruebas API exhaustivas
- **versionCode 60505** (v6.5.5) → RECHAZADO en todos los endpoints
- **versionCode 43404** (esquema v4.34.4, encontrado en ANY.RUN sandbox) → RECHAZADO
- **versionCodes 43400-43510, 49900, 50000, 60000-60520, 70000-70200** → TODOS RECHAZADOS
- **Sin header versionCode** → TAMBIÉN RECHAZADO
- **Con headers alternativos** (app-version-code, verCode, etc.) → RECHAZADO
- **Con credenciales reales** (userId, deviceId) → RECHAZADO
- **Con diferentes Content-Types** → RECHAZADO

### 2.3 Endpoint que NO rechaza por versión
```
/api/portalCore/config/get → {"returnCode":"500","errorMessage":"系统内部错误（未知错误）","data":null}
```
Este endpoint devuelve error 500 del servidor (error interno), NO el error de "versión descontinuada". Esto confirma que el servidor está procesando la petición, pero el servicio portalCore está caído/descontinuado.

### 2.4 Nuevos endpoints descubiertos en el DEX
```
/api/portalCore/getHome
/api/portalCore/v13_1/getSlbInfo
/api/portalCore/v3/getColumnContents
/api/portalCore/v3/getRecommends
/api/portalCore/v3/getShelveData
/api/portalCore/v3/snToken
/api/portalCore/v5/getLiveData
/api/portalCore/v5/login/thirdpart
/api/portalCore/v6/active
/api/portalCore/v6/login
/api/portalCore/v9/startPlayVOD
/api/v1/crashtrack/upload
/api/anti/updateZdata
/api/crashsdk/validate
```
TODOS devuelven "版本已停止使用" (portal200001)

### 2.5 Código de error portal200001
El código `portal200001` es uno de muchos códigos en el sistema:
- portal100058 a portal100079 (otros errores)
- **portal200001** (versión descontinuada - el que siempre recibimos)
- portal400001 (otro tipo de error)

### 2.6 Campo real: apk_versioncode
En el código DEX encontramos que el campo se llama `apk_versioncode` (no solo `versionCode`). Pero usar este header tampoco funciona.

---

## 3. SITUACIÓN ACTUAL DE XUPER TV (investigación web)

### 3.1 Xuper TV está siendo bloqueado/descontinuado
- YouTube: "🚨 URGENT! XUPER TV has been PERMANENTLY BLOCKED" (Abril 2026)
- YouTube: "XUPER TV is down, install the new DEFINITIVE update"
- Amazon ha eliminado Xuper TV de Fire TV
- Usuarios reportan que necesitan VPN para acceder
- Error común: "Due to policy limitation, your area cannot log on to use"

### 3.2 Xup3rTV - El reemplazo/clone
- **Xup3rTV** es un clone de Xuper TV que está funcionando actualmente
- YouTube: "How to Install Xup3rTV (Clone) on Fire TV | Updated Method 2026"
- YouTube: "Nueva versión de XUP3RTV no necesita vincular"
- Xup3rTV parece usar un backend diferente o actualizado

### 3.3 Múltiples variantes de la app
| Paquete | Nombre | Nota |
|---|---|---|
| com.msandroid.mobile | Xuper TV original | NUESTRAS APKs, backend descontinuado |
| my.app.appy.xupertv | Xuper TV (Google Play) | Versión diferente |
| my.blockdeal.xupertv | Xuper TV (Google Play) | Otra variante |
| com.godrejshampoo.xupertv | Xuper TV (APKPure) | Otra variante |
| com.supertv.yapp | SuperTV | Clone diferente |
| com.appxsuper.tvpro | SuperTV PRO | Clone PRO |

### 3.4 Esquema de versiones
Hay DOS esquemas de versionCode:
- **Esquema 6xxxxx**: versionName 6.x.x → versionCode 60201, 60504, 60505 (nuestras APKs)
- **Esquema 434xx**: versionName 4.34.x → versionCode 43404 (encontrado en ANY.RUN sandbox, v4.34.4)
- **Esquema 7xxxx**: versionName 7.1.0 → versionCode ~70100 (mencionado en sitios web)

---

## 4. NUEVA DIRECCIÓN RECOMENDADA

### Opción A: Analizar Xup3rTV (RECOMENDADA)
1. Descargar APK de Xup3rTV desde YouTube/installer links
2. Analizar con nuestro xuper-apk-analyzer.py
3. Probablemente usa un backend diferente o versión más nueva del mismo backend
4. Si funciona, construir app propia basada en esa API

### Opción B: Probar las variantes de Google Play
1. Descargar APK de `my.app.appy.xupertv` desde APKPure
2. Analizar versionCode y endpoints
3. Puede usar un backend diferente al de com.msandroid.mobile

### Opción C: MITM proxy con teléfono real
1. Instalar la app funcional en un teléfono Android
2. Configurar mitmproxy para interceptar tráfico
3. Capturar headers, endpoints y respuestas reales
4. Reproducir las peticiones exactas

### Opción D: Construir app IPTV desde cero
1. Usar listas M3U públicas (hay muchos repositorios)
2. Construir un player IPTV propio (ExoPlayer/Video.js)
3. No depender de APIs de terceros

---

## 5. INFRAESTRUCTURA DE DOMINIOS (sin cambios)

### Dominios API confirmados (detrás de Cloudflare)
```
c2tgd.izvhrdcjb.com    → portal200001 (servicio descontinuado)
dtgrd.txhnojlbu.com    → portal200001
cftpbe.39114gi1.com    → 403 Cloudflare block
skvbv.hbcpdutka.com    → sin respuesta
jktgk.bxtzwlyan.com    → sin respuesta
mekdw.htvbox.club      → 404 Not Found
```

### Dominios *.puata.info (13 subdominios)
```
kexun.puata.info       → sin respuesta / timeout
lvjian.puata.info      → sin respuesta
zhipu.puata.info       → sin respuesta
xingse.puata.info      → sin respuesta
baoxian.puata.info     → sin respuesta
zhubao.puata.info      → sin respuesta
jiaoyu.puata.info      → sin respuesta
meishi.puata.info      → sin respuesta
chuanmei.puata.info    → sin respuesta
youxuan.puata.info     → sin respuesta
lvxing.puata.info      → sin respuesta
dianying.puata.info    → sin respuesta
yumao.puata.info       → HTTP 500 (servidor caído)
```

**CDN IP:** `223.109.148.179` (para puata.info)

---

## 6. ENDPOINTS API COMPLETOS

| Endpoint | Método | Estado actual |
|---|---|---|
| `/api/portalCore/v3/snToken` | POST | portal200001 |
| `/api/portalCore/v3/getColumnContents` | POST | portal200001 |
| `/api/portalCore/v3/getRecommends` | POST | portal200001 |
| `/api/portalCore/v3/getShelveData` | POST | portal200001 |
| `/api/portalCore/v5/getLiveData` | POST | portal200001 |
| `/api/portalCore/v5/login/thirdpart` | POST | portal200001 |
| `/api/portalCore/v6/active` | POST | portal200001 |
| `/api/portalCore/v6/login` | POST | portal200001 |
| `/api/portalCore/v8/login` | POST | portal200001 |
| `/api/portalCore/v9/startPlayVOD` | POST | portal200001 |
| `/api/portalCore/v13_1/getSlbInfo` | POST | portal200001 |
| `/api/portalCore/config/get` | POST | **500 Internal Error** (no check versión) |
| `/api/portalCore/pwdCheck` | POST | portal200001 |
| `/api/portalCore/getAuthInfo` | POST | portal200001 |
| `/api/portalCore/getHome` | POST | portal200001 |
| `/api/v2/dcs/getAddr` | POST | 400 Bad Request |
| `/api/v1/crashtrack/upload` | POST | vacío |
| `/api/anti/updateZdata` | POST | vacío |
| `/api/crashsdk/validate` | POST | vacío |

### Headers que la app envía (del código DEX)
```
versionCode / apk_versioncode: <VERSION_CODE>
platform: android
Content-Type: application/json o application/x-www-form-urlencoded
User-Agent: Dalvik/2.1.0 (Linux; U; Android 14)
app-version-code: <VERSION_CODE>   (encontrado en ANY.RUN sandbox)
art-version: 340090000             (encontrado en ANY.RUN sandbox)
appId: 1
channelId: default
deviceId: <DEVICE_ID>
```

---

## 7. CREDENCIALES EXTRADAS

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
- La clave 3DES está en el código pero ofuscada por iJiami (爱加密) packing
- El archivo `domain_test.json` en la APK tiene todos los valores como "xx" (se cargan en runtime)

---

## 8. HERRAMIENTAS DISPONIBLES

### Scripts (`/home/z/my-project/download/xuper-tools/`)
| Archivo | Propósito |
|---|---|
| `xuper-apk-analyzer.py` | Analiza APKs con androguard |
| `xuper-update.sh` | Wrapper interactivo |
| `xuper-api-monitor.sh` | Monitoreo continuo de APIs |
| `generate_report.py` | Genera reporte PDF |
| `generate-guide.js` | Genera guía instructiva |

### APKs disponibles
| Archivo | Ubicación |
|---|---|
| xuper_celular.apk (v6.2.1) | `/home/z/my-project/download/` |
| Xupertv_latest_version.apk (v6.5.4) | `/home/z/my-project/upload/` |
| descargar_Xuper_tv_6_5_5_ultima_version_celular.apk (v6.5.5) | `/home/z/my-project/upload/` |
| xuper_base.apk | `/home/z/my-project/upload/` |

---

## 9. REPOSITORIO GITHUB

**URL:** https://github.com/yecos/guar
**Token:** Ver `git remote -v` — **DEBE ser revocado** en https://github.com/settings/tokens

---

## 10. FLUJO DE TRABAJO RECOMENDADO PARA LA PRÓXIMA SESIÓN

### ⚠️ NO seguir intentando versionCodes - el servicio está descontinuado

### En su lugar:
1. **Descargar Xup3rTV APK** — Es el reemplazo activo
   - Buscar enlaces en videos de YouTube recientes
   - Probar thexupertv.co o xupertvz.com
2. **Analizar Xup3rTV con nuestro analyzer** — Ver si usa el mismo backend o uno nuevo
3. **Si usa el mismo backend**: Buscar cómo obtiene el versionCode correcto
4. **Si usa backend nuevo**: Mapear los nuevos endpoints y construir la app
5. **Alternativa**: Descargar la variante de Google Play (`my.app.appy.xupertv`) y analizarla
6. **Alternativa MITM**: Usar un teléfono real con la app funcionando + mitmproxy
7. **Revocar token de GitHub**

---

## 11. LECCIONES APRENDIDAS

- "版本已停止使用" significa SERVICIO DESCONTINUADO, no "version vieja"
- El error portal200001 se devuelve para CUALQUIER versionCode (incluso sin header)
- iJiami (爱加密) packing impide la extracción estática de dominios y claves 3DES
- Los dominios están vacíos en domain_test.json ("xx") — se cargan dinámicamente en runtime
- Los servidores detrás de Cloudflare no se pueden bypassear con IP directa
- Xuper TV tiene múltiples variantes con diferentes packages y posiblemente diferentes backends
- La app está siendo activamente bloqueada por Amazon y posiblemente por proveedores de ISP

---

## 12. COMANDOS ÚTILES

### Analizar una APK nueva
```bash
python3 /home/z/my-project/download/xuper-tools/xuper-apk-analyzer.py APK.apk --update-monitor
```

### Extraer versionCode rápido (sin androguard, que es lento)
```python
import zipfile, struct
apk = 'APK.apk'
with zipfile.ZipFile(apk, 'r') as z:
    data = z.read('AndroidManifest.xml')
for offset in range(0, 50000, 4):
    val = struct.unpack('<I', data[offset:offset+4])[0]
    if 60000 <= val <= 99999:
        print(f'versionCode at offset {offset}: {val}')
```

### Probar API endpoint
```bash
curl -s -m 10 -X POST "https://DOMAIN/api/portalCore/v8/login" \
  -H "Content-Type: application/json" \
  -H "versionCode: 60505" \
  -H "platform: android" \
  -d '{"appId":"1"}'
```

### Buscar en web información actualizada
```bash
z-ai function -n web_search -a '{"query": "Xuper TV latest version 2026 working", "num": 10}'
```
