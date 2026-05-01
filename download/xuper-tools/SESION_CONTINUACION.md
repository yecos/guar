# Xuper TV - Reverse Engineering Project
## Estado del Proyecto - Documento de Traspaso ACTUALIZADO (Sesión 4)

> **Fecha:** 2026-05-01 (Sesión 4)
> **Propósito:** Permitir que una nueva sesión continúe el trabajo sin pérdida de contexto

---

## 1. RESUMEN EJECUTIVO

Se está haciendo **reverse engineering** de la app IPTV **Xuper TV** para construir una app de streaming propia.

### HALLAZGOS CRÍTICOS DE SESIÓN 4:
1. **CLAVE 3DES EXTRAÍDA**: `7JJ8qaJ2A4kJPEJBiMRtANnJ6OC7sPev` (24 bytes, base64)
2. **13 DOMINIOS API** encontrados en resources.arsc (9 NUEVOS no reportados antes)
3. **Xuper TV = BrasilIPTV**: La app base es `com.interactive.brasiliptv.app.AppWrapper`
4. **Google App Engine backend**: `magis-mobile-7abeb.appspot.com`
5. **Todos los backends portalCore están MUERTOS** (portal200001, 500, o 404)

**Estado actual:** ✅ Clave 3DES extraída | ✅ Dominios mapeados | ❌ Backend muerto | 🔄 Necesita MITM con app funcional

---

## 2. HALLAZGOS DE SESIÓN 4

### 2.1 APKs analizadas en esta sesión
| APK | Paquete | Versión | versionCode | Signing | Tamaño DEX | Nota |
|---|---|---|---|---|---|---|
| xuper_tv_v711.apk | com.msandroid.mobile | 6.2.2 | 60202 | MAGISOTT | 34.8 MB | SIN iJiami packing! |
| xuper_tv_2026_v2.apk | com.android.mgstv | 4.34.4 | 43404 | SGM | 13.6 KB | iJiami packed, shell APK |

### 2.2 Clave de encriptación EXTRAÍDA
```
3DES Key (base64): 7JJ8qaJ2A4kJPEJBiMRtANnJ6OC7sPev
3DES Key (hex):    ec927ca9a2760389093c424188c46d00d9c9e8e0bbb0f7af
3DES Key (bytes):  24
Algoritmo:         DESede/ECB/PKCS5Padding

AES Key (base64):  7JJ8qaJ2A4kJPEJB  (12 bytes, clave parcial?)
AES Algoritmos:    AES/CBC/NOPADDING, AES/ECB/PKCS5Padding
```
La clave se encontró cerca de `SecretKeySpec` en el DEX no empaquetado (v6.2.2).

### 2.3 Dominios API COMPLETOS (de resources.arsc)
Los dominios están en TEXTRO PLANO en resources.arsc, NO encriptados:

| Dominio | Estado | Detalle |
|---|---|---|
| `bg4gr.msfxethyc.com` | portal200001 | Servicio descontinuado |
| `bktjr.akvndhzgx.com` | 403 | Cloudflare block |
| `c2tgd.izvhrdcjb.com` | portal200001 | Servicio descontinuado |
| `c2tgd3.ewzpuscyv.com` | 404 | openresty/1.27.1.1 - SIN version gate |
| `cdtgcr.bcjoapser.com` | 403 | Cloudflare block |
| `ckfdr.nzxgfvrud.com` | 500 | Servidor completamente roto |
| `dtgrd.txhnojlbu.com` | portal200001 | Servicio descontinuado |
| `g4tc2.irlapchbd.com` | 404 | nginx - SIN version gate |
| `jktgk.bxtzwlyan.com` | 404 | Go server - SIN version gate |
| `jktgr.ludgwoxhe.com` | 404 | Spring Boot - SIN version gate |
| `skc2r.plracsimf.com` | 404 | Go server - SIN version gate |
| `skvbv.hbcpdutka.com` | 404 | openresty - SIN version gate |
| `vtgrc.ncimxztfk.com` | 404 | Spring Boot - SIN version gate |
| `magis-mobile-7abeb.appspot.com` | 404 | Google App Engine |
| `mekdw.htvbox.club` | 404 | openresty (sesión anterior) |

### 2.4 IPs de Alibaba Cloud (encontradas en DEX)
```
119.23.108.135
120.25.130.190  → Spring Boot (devuelve 404 JSON en portalCore)
120.77.74.81
120.78.18.241
120.78.185.110
120.78.85.189
47.106.59.179
47.106.75.170
47.112.113.131
47.113.57.59
```
Todas son instancias Alibaba Cloud (Aliyun). Solo 120.25.130.190 respondió con Spring Boot.

### 2.5 yumao.puata.info - Endpoints VIVOS
```
/anti_logs → {"resp_code": 1,"msg": "http header缺少appkey"}  (vivo, necesita appkey + GZIP)
/cc_info   → {"resp_code": 1,"msg": "http header缺少appkey"}  (vivo, necesita appkey + GZIP)
/api/portalCore/* → HTTP 500 (servidor crashea, SIN version gate!)
```
yumao.puata.info NO tiene el check de versión portal200001. Los endpoints crashean pero están procesando las peticiones.

### 2.6 Google OAuth Client ID
```
18767524675-b07kvgssnv757te063qbqel15b48s0ig.apps.googleusercontent.com
```

### 2.7 Otros hallazgos del DEX
- `www.magistvec.com/download` — URL de descarga de Magis TV
- `www.oi1lgew.com` — Dominio de contenido/test con archivos multimedia
- `Xupermobservicio@outlook.com` — Email de soporte
- Recursos: `domain_is_security`, `isEncrypt`, `portal_main`, `portal_backup`, `mTvOfficialDownloadUrl`, `mTvPlaylistUrl`
- Contacto: `@bol.com.br`, `@globomail.com`, etc. (emails brasileños - confirma origen BrasilIPTV)

### 2.8 Certificados de firma
| APK | Certificado | Significado |
|---|---|---|
| v6.2.2 (com.msandroid.mobile) | MAGISOTT | Magis TV / Xuper TV |
| v4.34.4 (com.android.mgstv) | SGM | MGS TV / Magis TV |
| v6.2.1 original | (original) | Xuper TV original |

---

## 3. RELACIÓN ENTRE APPS (DESCUBIERTA)

```
BrasilIPTV (com.interactive.brasiliptv.app.AppWrapper)
  └── Xuper TV (com.msandroid.mobile) - rebrand con iJiami packing
  └── MGS TV / Xuper TV 2026 (com.android.mgstv) - rebrand con iJiami packing
  └── Magis TV - mismo backend, diferentes dominios
```

Todas estas apps comparten:
- Mismo backend portalCore
- Mismos dominios en resources.arsc
- Mismo domain_test.json con "xx" valores
- Mismo sistema de encriptación 3DES
- Diferentes certificados de firma (re-firmadas)

---

## 4. VARIANTES DE LA APP CONOCIDAS

| Paquete | Nombre | Estado | Nota |
|---|---|---|---|
| com.msandroid.mobile | Xuper TV original | ❌ Muerto | Backend descontinuado |
| com.android.mgstv | Xuper TV 2026 / MGS TV | ❌ Muerto | iJiami packed, mismo backend |
| com.series.one.xupertv | Xuper TV 2026 (Google Play) | ❓ No analizada | 38 MB, v1.0 - DIFERENTE app |
| my.app.appy.xupertv | Xuper TV (Google Play) | ❓ No analizada | |
| my.blockdeal.xupertv | Xuper TV (Google Play) | ❓ No analizada | |
| com.godrejshampoo.xupertv | Xuper TV (APKPure) | ❓ No analizada | |
| com.blcksparrow.xupertv | Xuper TV Pro | Solo informativa | No streaming |
| my.blacksparrow.tv.xupertv | Xuper TV Global | ❓ No analizada | Por Black Sparrow, 34.7 MB |
| com.interactive.brasiliptv | BrasilIPTV | ❓ App base original | Sin iJiami = fácil de analizar |

---

## 5. ENDPOINTS API COMPLETOS

### Portal Core (todos en dominios Cloudflare)
| Endpoint | Estado en Cloudflare | Estado en yumao.puata.info |
|---|---|---|
| `/api/portalCore/v3/snToken` | portal200001 | 500 |
| `/api/portalCore/v3/getColumnContents` | portal200001 | 500 |
| `/api/portalCore/v3/getRecommends` | portal200001 | 500 |
| `/api/portalCore/v3/getShelveData` | portal200001 | 500 |
| `/api/portalCore/v5/getLiveData` | portal200001 | 500 |
| `/api/portalCore/v5/login/thirdpart` | portal200001 | 500 |
| `/api/portalCore/v6/active` | portal200001 | 500 |
| `/api/portalCore/v6/login` | portal200001 | 500 |
| `/api/portalCore/v8/login` | portal200001 | 500 |
| `/api/portalCore/v9/startPlayVOD` | portal200001 | 500 |
| `/api/portalCore/v13_1/getSlbInfo` | portal200001 | 500 |
| `/api/portalCore/config/get` | **500** (no check) | 500 |
| `/api/portalCore/pwdCheck` | portal200001 | 500 |
| `/api/portalCore/getAuthInfo` | portal200001 | 500 |
| `/api/portalCore/getHome` | portal200001 | 500 |

### Otros endpoints
| Endpoint | Estado |
|---|---|
| `/api/v2/dcs/getAddr` | 400 Bad Request |
| `/api/v1/crashtrack/upload` | vacío |
| `/api/v1/mix/upload` | vacío |
| `/api/v1/raw/upload` | vacío |
| `/api/anti/updateZdata` | vacío |
| `/api/crashsdk/validate` | vacío |
| `/api/get_notice` | 500 (en yumao) |
| `/api/adserver/v3/get_content` | 500 (en yumao) |

### yumao.puata.info (anti-fraud SDK - Taobao ACCS)
| Endpoint | Estado |
|---|---|
| `/anti_logs` | Vivo - necesita appkey + GZIP body |
| `/cc_info` | Vivo - necesita appkey + GZIP body |

---

## 6. CREDENCIALES Y CLAVES

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

### Encriptación (EXTRAÍDA)
```
3DES Key (base64): 7JJ8qaJ2A4kJPEJBiMRtANnJ6OC7sPev
3DES Key (hex):    ec927ca9a2760389093c424188c46d00d9c9e8e0bbb0f7af
Algoritmo:         DESede/ECB/PKCS5Padding
Clase Java:        javax.crypto.spec.DESedeKeySpec

AES Key (base64):  7JJ8qaJ2A4kJPEJB  (posible IV o clave parcial)
Algoritmos AES:    AES/CBC/NOPADDING, AES/ECB/PKCS5Padding

NOTA: Los dominios en domain_test.json están como "xx" (se cargan dinámicamente).
Los dominios reales están en resources.arsc en TEXTO PLANO, no encriptados.
La clave 3DES probablemente se usa para desencriptar las respuestas del servidor
o para encriptar datos enviados, NO para desencriptar dominios almacenados localmente.
```

### Google OAuth
```
Client ID: 18767524675-b07kvgssnv757te063qbqel15b48s0ig.apps.googleusercontent.com
```

---

## 7. HERRAMIENTAS Y APKs DISPONIBLES

### Scripts (`/home/z/my-project/download/xuper-tools/`)
| Archivo | Propósito |
|---|---|
| `xuper-apk-analyzer.py` | Analiza APKs con androguard |
| `xuper-update.sh` | Wrapper interactivo |
| `xuper-api-monitor.sh` | Monitoreo continuo de APIs |
| `generate_report.py` | Genera reporte PDF |
| `generate-guide.js` | Genera guía instructiva |

### APKs en disco
| Archivo | Ubicación | Nota |
|---|---|---|
| xuper_tv_v711.apk (v6.2.2) | `/home/z/my-project/download/` | SIN iJiami, DEX de 34.8 MB |
| xuper_tv_2026_v2.apk (v4.34.4) | `/home/z/my-project/download/` | iJiami packed, shell APK |

---

## 8. FLUJO DE TRABAJO RECOMENDADO PARA LA PRÓXIMA SESIÓN

### ⚠️ El backend portalCore está MUERTO en TODAS las variantes analizadas

### Opción A: MITM proxy con app funcional (RECOMENDADA)
1. Instalar Xup3rTV o Xuper TV que FUNCIONE en un teléfono Android
2. Configurar mitmproxy para interceptar tráfico
3. Capturar headers, endpoints y respuestas reales
4. La app funcional DEBE usar un backend diferente o actualizado
5. Con los endpoints capturados, construir la app propia

### Opción B: Analizar BrasilIPTV original
1. Buscar y descargar `com.interactive.brasiliptv` APK
2. Al ser la app base SIN iJiami, es más fácil de analizar
3. Puede tener endpoints diferentes o actualizados

### Opción C: Analizar Xuper TV Global
1. Descargar `my.blacksparrow.tv.xupertv` de mi9.com
2. Es una variante diferente (34.7 MB, actualizada Abril 2026)
3. Puede usar un backend diferente

### Opción D: Probar los dominios 404 sin version gate
1. Los dominios `c2tgd3.ewzpuscyv.com`, `jktgr.ludgwoxhe.com`, `vtgrc.ncimxztfk.com` etc. NO tienen el check de versión
2. Necesitan los endpoints correctos (no portalCore)
3. Podrían ser microservicios diferentes (upgrade, epg, dcs, etc.)
4. Probar rutas como `/api/upgrade/check`, `/api/epg/get`, `/api/dccore/get`

### Opción E: Construir app IPTV desde cero
1. Usar listas M3U públicas
2. Construir player IPTV propio
3. No depender de APIs de terceros

---

## 9. LECCIONES APRENDIDAS (TODAS LAS SESIONES)

- "版本已停止使用" significa SERVICIO DESCONTINUADO, no "version vieja"
- El error portal200001 se devuelve para CUALQUIER versionCode
- iJiami (爱加密) packing solo protege el código Java, los recursos están accesibles
- Los dominios están en TEXTO PLANO en resources.arsc, NO encriptados
- La clave 3DES se usa para datos en tránsito, no para dominios almacenados
- La app original es BrasilIPTV (com.interactive.brasiliptv.app.AppWrapper)
- Xuper TV, Magis TV y MGS TV son el mismo producto rebrandeado
- yumao.puata.info NO tiene el version gate pero el backend crashea
- Los dominios que devuelven 404 (no portal200001) son SERVIDORES DIFERENTES sin version check
- Los servidores Spring Boot en Aliyun responden pero no tienen los endpoints portalCore
- Google App Engine tiene un proyecto activo (magis-mobile-7abeb.appspot.com) pero devuelve 404 en todo

---

## 10. COMANDOS ÚTILES

### Descifrar datos con la clave 3DES
```python
from Crypto.Cipher import DES3
from Crypto.Util.Padding import unpad
import base64

key = base64.b64decode("7JJ8qaJ2A4kJPEJBiMRtANnJ6OC7sPev")
cipher = DES3.new(key, DES3.MODE_ECB)
encrypted = base64.b64decode("ENCRYPTED_DATA_HERE")
decrypted = unpad(cipher.decrypt(encrypted), 8)
print(decrypted.decode('utf-8'))
```

### Probar endpoint sin version gate
```bash
curl -s -m 10 -X POST "https://yumao.puata.info/api/portalCore/config/get" \
  -H "Content-Type: application/json" \
  -H "versionCode: 60202" \
  -H "platform: android" \
  -d '{"appId":"1"}'
```

### Probar yumao anti-fraud endpoints
```bash
curl -s -m 10 -X POST "https://yumao.puata.info/anti_logs" \
  -H "Content-Type: application/json" \
  -H "appkey: 68b903e0e563686f429a3a60" \
  -d '{}'
```

### Buscar en web
```bash
z-ai function -n web_search -a '{"query": "Xuper TV working 2026", "num": 10}'
```
