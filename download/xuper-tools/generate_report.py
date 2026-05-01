#!/usr/bin/env python3
"""Generate PDF report for Xuper TV APK v6.5.4 analysis"""
import sys, os
sys.path.insert(0, '/home/z/my-project/skills/pdf/scripts')
from reportlab.lib.pagesizes import A4
from reportlab.lib.units import inch, cm
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.enums import TA_LEFT, TA_CENTER, TA_JUSTIFY
from reportlab.lib import colors
from reportlab.platypus import (SimpleDocTemplate, Paragraph, Spacer, Table,
                                 TableStyle, PageBreak, Image, KeepTogether)
from reportlab.pdfbase import pdfmetrics
from reportlab.pdfbase.ttfonts import TTFont
from reportlab.pdfbase.pdfmetrics import registerFontFamily

# --- Font Registration ---
# NotoSansSC variable font skipped
pdfmetrics.registerFont(TTFont('SarasaMonoSC', '/usr/share/fonts/truetype/chinese/SarasaMonoSC-Regular.ttf'))
pdfmetrics.registerFont(TTFont('SarasaMonoSCBold', '/usr/share/fonts/truetype/chinese/SarasaMonoSC-Bold.ttf'))
pdfmetrics.registerFont(TTFont('DejaVuSans', '/usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf'))
registerFontFamily('SarasaMonoSC', normal='SarasaMonoSC', bold='SarasaMonoSCBold')
registerFontFamily('SarasaMonoSC', normal='SarasaMonoSC', bold='SarasaMonoSCBold')

# --- Color Palette ---
ACCENT       = colors.HexColor('#4821bc')
TEXT_PRIMARY  = colors.HexColor('#1e1c1b')
TEXT_MUTED    = colors.HexColor('#8d8981')
BG_SURFACE   = colors.HexColor('#e5e2dd')
BG_PAGE      = colors.HexColor('#eeebe8')
TABLE_HEADER_COLOR = ACCENT
TABLE_HEADER_TEXT  = colors.white
TABLE_ROW_EVEN     = colors.white
TABLE_ROW_ODD      = BG_SURFACE

# --- Styles ---
body_en = ParagraphStyle(name='BodyEN', fontName='SarasaMonoSC', fontSize=10.5, leading=18,
                         alignment=TA_JUSTIFY, spaceAfter=6)
body_es = ParagraphStyle(name='BodyES', fontName='SarasaMonoSC', fontSize=10.5, leading=18,
                         alignment=TA_JUSTIFY, spaceAfter=6)
body_cn = ParagraphStyle(name='BodyCN', fontName='SarasaMonoSC', fontSize=10.5, leading=18,
                         alignment=TA_LEFT, wordWrap='CJK', spaceAfter=6)
h1_style = ParagraphStyle(name='H1', fontName='SarasaMonoSC', fontSize=20, leading=28,
                          textColor=ACCENT, spaceBefore=18, spaceAfter=12)
h2_style = ParagraphStyle(name='H2', fontName='SarasaMonoSC', fontSize=15, leading=22,
                          textColor=ACCENT, spaceBefore=14, spaceAfter=8)
h3_style = ParagraphStyle(name='H3', fontName='SarasaMonoSC', fontSize=12, leading=18,
                          textColor=TEXT_PRIMARY, spaceBefore=10, spaceAfter=6)
header_cell = ParagraphStyle(name='HeaderCell', fontName='SarasaMonoSC', fontSize=10,
                             textColor=colors.white, alignment=TA_CENTER)
cell_style = ParagraphStyle(name='Cell', fontName='SarasaMonoSC', fontSize=9.5,
                            textColor=TEXT_PRIMARY, alignment=TA_CENTER)
cell_left = ParagraphStyle(name='CellLeft', fontName='SarasaMonoSC', fontSize=9.5,
                           textColor=TEXT_PRIMARY, alignment=TA_LEFT)
code_style = ParagraphStyle(name='Code', fontName='DejaVuSans', fontSize=8.5, leading=14,
                            textColor=TEXT_PRIMARY, backColor=BG_SURFACE, leftIndent=12,
                            spaceAfter=6, spaceBefore=4)

def P(text, style=body_es):
    return Paragraph(text, style)

def make_table(data, col_widths, has_header=True):
    t = Table(data, colWidths=col_widths, hAlign='CENTER')
    style_cmds = [
        ('GRID', (0,0), (-1,-1), 0.5, TEXT_MUTED),
        ('VALIGN', (0,0), (-1,-1), 'MIDDLE'),
        ('LEFTPADDING', (0,0), (-1,-1), 8),
        ('RIGHTPADDING', (0,0), (-1,-1), 8),
        ('TOPPADDING', (0,0), (-1,-1), 5),
        ('BOTTOMPADDING', (0,0), (-1,-1), 5),
    ]
    if has_header:
        style_cmds.append(('BACKGROUND', (0,0), (-1,0), TABLE_HEADER_COLOR))
        style_cmds.append(('TEXTCOLOR', (0,0), (-1,0), TABLE_HEADER_TEXT))
        for i in range(1, len(data)):
            bg = TABLE_ROW_EVEN if i % 2 == 1 else TABLE_ROW_ODD
            style_cmds.append(('BACKGROUND', (0,i), (-1,i), bg))
    t.setStyle(TableStyle(style_cmds))
    return t

# --- Document ---
output = '/home/z/my-project/download/Xuper_TV_Analisis_v654.pdf'
doc = SimpleDocTemplate(output, pagesize=A4,
                       leftMargin=1.0*inch, rightMargin=1.0*inch,
                       topMargin=0.8*inch, bottomMargin=0.8*inch)

story = []
W = A4[0] - 2.0*inch  # available width

# ============ COVER ============
story.append(Spacer(1, 80))
story.append(P('<b>Xuper TV APK v6.5.4</b>', ParagraphStyle(name='CoverTitle', fontName='SarasaMonoSC',
              fontSize=36, leading=44, textColor=ACCENT, alignment=TA_CENTER)))
story.append(Spacer(1, 20))
story.append(P('Analisis Completo de Ingenieria Inversa', ParagraphStyle(name='CoverSub',
              fontName='SarasaMonoSC', fontSize=18, leading=24, textColor=TEXT_MUTED, alignment=TA_CENTER)))
story.append(Spacer(1, 40))
story.append(P('Fecha: 1 de mayo de 2026', ParagraphStyle(name='CoverDate',
              fontName='SarasaMonoSC', fontSize=13, leading=18, textColor=TEXT_PRIMARY, alignment=TA_CENTER)))
story.append(Spacer(1, 10))
story.append(P('APK: Xupertv_latest_version.apk (38 MB)', ParagraphStyle(name='CoverFile',
              fontName='SarasaMonoSC', fontSize=12, leading=16, textColor=TEXT_MUTED, alignment=TA_CENTER)))
story.append(Spacer(1, 10))
story.append(P('Analista: Super Z AI Assistant', ParagraphStyle(name='CoverAuthor',
              fontName='SarasaMonoSC', fontSize=12, leading=16, textColor=TEXT_MUTED, alignment=TA_CENTER)))
story.append(Spacer(1, 60))
story.append(P('Hallazgo Principal: <b>versionCode 60504</b> extraido exitosamente de la APK v6.5.4. Los servidores API estan temporalmente caidos (HTTP 500), impidiendo la validacion inmediata del versionCode.', ParagraphStyle(name='CoverSummary',
              fontName='SarasaMonoSC', fontSize=11, leading=17, textColor=TEXT_PRIMARY, alignment=TA_CENTER)))

story.append(PageBreak())

# ============ SECTION 1: Package Info ============
story.append(P('<b>1. Informacion del Paquete</b>', h1_style))
story.append(Spacer(1, 6))

info_data = [
    [P('<b>Campo</b>', header_cell), P('<b>Valor</b>', header_cell)],
    [P('Package Name', cell_left), P('com.msandroid.mobile', cell_left)],
    [P('Version Name', cell_left), P('6.5.4', cell_left)],
    [P('Version Code', cell_left), P('<b>60504</b>', cell_left)],
    [P('Min SDK', cell_left), P('19 (Android 4.4 KitKat)', cell_left)],
    [P('Target SDK', cell_left), P('33 (Android 13)', cell_left)],
    [P('Compile SDK', cell_left), P('34 (Android 14)', cell_left)],
]
story.append(make_table(info_data, [W*0.35, W*0.65]))
story.append(Spacer(1, 18))

story.append(P('<b>1.1 Comparacion de Versiones</b>', h2_style))
ver_data = [
    [P('<b>APK</b>', header_cell), P('<b>Version Name</b>', header_cell),
     P('<b>Version Code</b>', header_cell), P('<b>Estado API</b>', header_cell)],
    [P('xuper_celular.apk', cell_left), P('6.2.1', cell_style), P('60201', cell_style),
     P('Rechazado', cell_style)],
    [P('(version previa)', cell_left), P('6.0.5', cell_style), P('60500', cell_style),
     P('Rechazado', cell_style)],
    [P('Xupertv_latest_version.apk', cell_left), P('6.5.4', cell_style), P('<b>60504</b>', cell_style),
     P('Pendiente (servers down)', cell_style)],
]
story.append(make_table(ver_data, [W*0.30, W*0.22, W*0.22, W*0.26]))
story.append(Spacer(1, 12))
story.append(P('El servidor rechaza versiones antiguas con el mensaje "Version descontinuada" (en chino: ban ben yi ting zhi shi yong). La version 60504 es la version mas reciente disponible y es altamente probable que sea aceptada una vez que los servidores se restauren. El patron numerico sigue la convencion XXYYZ donde XX es la version mayor (6.0, 6.2, 6.5), YY es la version menor, y Z es el patch.'))

# ============ SECTION 2: APK Structure ============
story.append(Spacer(1, 18))
story.append(P('<b>2. Estructura de la APK y Proteccion Anti-Reversing</b>', h1_style))
story.append(Spacer(1, 6))

story.append(P('<b>2.1 Proteccion iJiami (AiJiaMi)</b>', h2_style))
story.append(P('La APK utiliza el sistema de empaquetado <b>iJiami</b> (ai jia mi, en chino: "amor加密"), un packer comercial chino que ofusca y cifra el codigo de la aplicacion. Este sistema funciona reemplazando el DEX original con un stub de carga que descifra el codigo real en tiempo de ejecucion utilizando bibliotecas nativas. El proceso completo de carga funciona de la siguiente manera: cuando Android inicia la app, carga el classes.dex que solo contiene el loader de iJiami. Este loader invoca la clase com.ijm.dataencryption.DETool, que a su vez carga la biblioteca nativa libexecmain.so desde la carpeta assets. La biblioteca nativa descifra ijiami.dat para obtener el DEX real con toda la logica de negocio, y este DEX se carga dinamicamente en la maquina virtual.'))

story.append(Spacer(1, 10))
story.append(P('<b>2.2 Archivos del Packer</b>', h2_style))
packer_data = [
    [P('<b>Archivo</b>', header_cell), P('<b>Tamano</b>', header_cell), P('<b>Proposito</b>', header_cell)],
    [P('assets/ijiami.dat', cell_left), P('6.97 MB', cell_style), P('DEX cifrado con logica real', cell_left)],
    [P('assets/ijiami.ajm', cell_left), P('2.76 MB', cell_style), P('Datos adicionales del packer', cell_left)],
    [P('assets/IJMDal.Data', cell_left), P('50 KB', cell_style), P('Datos cifrados (completamente ofuscados)', cell_left)],
    [P('assets/ijm_lib/arm64-v8a/libexec.so', cell_left), P('636 KB', cell_style), P('Biblioteca nativa ARM64', cell_left)],
    [P('assets/ijm_lib/x86_64/libexec.so', cell_left), P('667 KB', cell_style), P('Biblioteca nativa x86_64 (header UPX falso)', cell_left)],
    [P('classes.dex', cell_left), P('1.98 MB', cell_style), P('Stub de carga iJiami (no codigo real)', cell_left)],
]
story.append(make_table(packer_data, [W*0.40, W*0.15, W*0.45]))
story.append(Spacer(1, 12))

story.append(P('<b>2.3 Archivo domain_test.json</b>', h2_style))
story.append(P('Se extrajo el archivo de configuracion de dominios assets/domain_test.json. Este archivo contiene el mapa de servicios de la aplicacion con todos los valores configurados como "xx", lo que indica que los dominios reales se cargan o descifran en tiempo de ejecucion. El archivo define 11 servicios con sus respectivos servidores principales (main) y de respaldo (backup):'))
story.append(Spacer(1, 6))

services_data = [
    [P('<b>Servicio</b>', header_cell), P('<b>Funcion</b>', header_cell)],
    [P('upgrade', cell_left), P('Actualizaciones de la app', cell_left)],
    [P('portal', cell_left), P('Autenticacion y portal principal', cell_left)],
    [P('epg', cell_left), P('Guia de programacion electronica (EPG)', cell_left)],
    [P('epg4b_sn/data', cell_left), P('EPG para decodificadores (set-top boxes)', cell_left)],
    [P('market', cell_left), P('Tienda y mercado de contenido', cell_left)],
    [P('diamond', cell_left), P('Sistema de pagos y moneda virtual', cell_left)],
    [P('notice', cell_left), P('Notificaciones push al usuario', cell_left)],
    [P('dccore', cell_left), P('Core del sistema de contenido', cell_left)],
    [P('datacollect', cell_left), P('Recopilacion de datos y analitica', cell_left)],
    [P('ad', cell_left), P('Publicidad y anuncios', cell_left)],
]
story.append(make_table(services_data, [W*0.30, W*0.70]))
story.append(Spacer(1, 8))
story.append(P('Cada servicio tiene un par main/backup, indicando alta disponibilidad con failover automatico. Los dominios reales probablemente se obtienen del servidor en el primer inicio y se almacenan encriptados con 3DES en SharedPreferences, como se descubrio en sesiones anteriores.'))

# ============ SECTION 3: Domains ============
story.append(Spacer(1, 18))
story.append(P('<b>3. Dominios API e Infraestructura</b>', h1_style))

story.append(P('<b>3.1 Dominios Conocidos</b>', h2_style))
story.append(P('Se identificaron 13 subdominios bajo puata.info, todos con certificado SSL wildcard emitido por GlobalSign para Alibaba (China) Technology Co., Ltd. Los dominios principales apuntan a un servidor en Hangzhou (110.75.96.12) que bloquea conexiones desde IPs de datacenter, mientras que el dominio yumao resuelve a un pool de IPs de Alibaba CDN (223.109.148.x) que permite conexiones pero actualmente retorna error 500.'))
story.append(Spacer(1, 6))

domains_data = [
    [P('<b>Dominio</b>', header_cell), P('<b>IP</b>', header_cell), P('<b>CDN</b>', header_cell), P('<b>Estado</b>', header_cell)],
]
for d in ['kexun','lvjian','zhipu','xingse','baoxian','zhubao','jiaoyu','meishi','chuanmei','youxuan','lvxing','dianying']:
    domains_data.append([P(f'{d}.puata.info', cell_left), P('110.75.96.12', cell_style),
                         P('Alibaba Cloud', cell_style), P('Timeout desde DC', cell_style)])
domains_data.append([P('yumao.puata.info', cell_left), P('223.109.148.x', cell_style),
                     P('Alibaba CDN', cell_style), P('TLS OK, origen caido', cell_style)])
story.append(make_table(domains_data, [W*0.28, W*0.20, W*0.22, W*0.30]))

story.append(Spacer(1, 12))
story.append(P('<b>3.2 Infraestructura CDN</b>', h2_style))
cdn_data = [
    [P('<b>Componente</b>', header_cell), P('<b>Detalle</b>', header_cell)],
    [P('Servidor CDN', cell_left), P('Tengine (Alibaba)', cell_left)],
    [P('Certificado SSL', cell_left), P('*.puata.info - GlobalSign GCC R3 OV TLS CA 2024', cell_left)],
    [P('Validez certificado', cell_left), P('Agosto 2025 - Septiembre 2026', cell_left)],
    [P('TLS Version', cell_left), P('1.2 - ECDHE-ECDSA-CHACHA20-POLY1305', cell_left)],
    [P('DNS', cell_left), P('Alibaba DNS (aliyun.com / alibabadns.com)', cell_left)],
    [P('Organizacion', cell_left), P('Alibaba (China) Technology Co., Ltd. - HangZhou, ZheJiang', cell_left)],
]
story.append(make_table(cdn_data, [W*0.30, W*0.70]))

story.append(Spacer(1, 12))
story.append(P('<b>3.3 Estado Actual del Servidor</b>', h2_style))
story.append(P('Al momento del analisis, todos los endpoints API retornan HTTP 500 (Internal Server Error) con cuerpo de respuesta vacio. El edge CDN de Alibaba (Tengine) funciona correctamente y acepta conexiones TLS, pero no puede comunicarse con el servidor origen que esta detras del CDN. Esto se confirma porque: (1) el certificado SSL es valido y la conexion TLS se establece correctamente, (2) el servidor Tengine responde con el header "Content-Type: application/json", y (3) todas las rutas, incluso las inexistentes, retornan 500 con body vacio. Se probaron variaciones incluyendo diferentes versionCodes (60504, 60500, ninguno), diferentes Content-Types (form-urlencoded, JSON), versionCode como header vs campo POST, y multiples dominios e IPs de CDN. En todos los casos el resultado fue identico: HTTP 500 con Content-Length: 0.'))

# ============ SECTION 4: API Endpoints ============
story.append(Spacer(1, 18))
story.append(P('<b>4. Endpoints API Conocidos</b>', h1_style))

ep_data = [
    [P('<b>Endpoint</b>', header_cell), P('<b>Metodo</b>', header_cell), P('<b>Proposito</b>', header_cell)],
    [P('/api/portalCore/v8/login', cell_left), P('POST', cell_style), P('Login version 8', cell_left)],
    [P('/api/portalCore/v6/login', cell_left), P('POST', cell_style), P('Login version 6', cell_left)],
    [P('/api/portalCore/pwdCheck', cell_left), P('POST', cell_style), P('Verificacion de contrasena', cell_left)],
]
story.append(make_table(ep_data, [W*0.40, W*0.15, W*0.45]))
story.append(Spacer(1, 10))

story.append(P('<b>Headers Requeridos</b>', h2_style))
headers_data = [
    [P('<b>Header</b>', header_cell), P('<b>Valor</b>', header_cell)],
    [P('Content-Type', cell_left), P('application/x-www-form-urlencoded', cell_left)],
    [P('versionCode', cell_left), P('60504 (nuevo) / 60201, 60500 (antiguo, rechazado)', cell_left)],
    [P('User-Agent', cell_left), P('Dalvik/2.1.0 (Linux; U; Android 14; ...)', cell_left)],
]
story.append(make_table(headers_data, [W*0.30, W*0.70]))

# ============ SECTION 5: Encryption ============
story.append(Spacer(1, 18))
story.append(P('<b>5. Cifrado y Seguridad</b>', h1_style))

story.append(P('<b>5.1 Encriptacion 3DES</b>', h2_style))
story.append(P('La aplicacion utiliza la clase com.ijm.dataencryption.DETool para cifrado, que internamente emplea el algoritmo 3DES (DESede). Del analisis previo de la APK v6.2.1 (que no tenia proteccion iJiami), se encontro que la clave 3DES utilizada es "2022@Mslive!" con el algoritmo DESede/ECB/PKCS5Padding. Esta clave se usa para cifrar los valores de host almacenados en SharedPreferences de la aplicacion. Es probable que esta clave no haya cambiado en la v6.5.4 ya que el mecanismo de proteccion iJiami es independiente del cifrado de datos de la aplicacion.'))
story.append(Spacer(1, 10))

story.append(P('<b>5.2 Hashes en Resources</b>', h2_style))
story.append(P('Se encontraron hashes MDX de 32 caracteres hexadecimales en los recursos de ambas versiones de la APK. En la version v6.5.4 se encontro el hash e9a76ec0b33f48e08178935c76b82816, mientras que la v6.2.1 contiene 08797293894441e2b0f9b54fe2cb7176. Estos hashes podrian ser claves API para autenticacion con el servidor, tokens de verificacion de integridad, o identificadores de version para el mecanismo de actualizacion. La diferencia entre ambos hashes sugiere que se rotan con cada version de la aplicacion.'))
story.append(Spacer(1, 10))

story.append(P('<b>5.3 Mecanismo de Control de Version</b>', h2_style))
story.append(P('El mecanismo de control de version funciona en tres niveles: primero, la app envia versionCode como header HTTP en cada request al servidor. Segundo, el servidor verifica si el versionCode esta vigente comparandolo contra una lista de versiones aceptadas. Tercero, si la version esta descontinuada, el servidor retorna un error con el mensaje "ban ben yi ting zhi shi yong" (version descontinuada). La app entonces muestra un dialogo de actualizacion forzada (version_forbidden) que impide el uso de la aplicacion hasta que el usuario actualice. Los strings de recursos revelan que existen dos tipos de dialogos: normal_upgrade para actualizaciones opcionales y force_upgrade para actualizaciones obligatorias, ademas del dialogo version_forbidden que bloquea completamente la app.'))

# ============ SECTION 6: Changes ============
story.append(Spacer(1, 18))
story.append(P('<b>6. Cambios entre v6.2.1 y v6.5.4</b>', h1_style))

story.append(P('<b>6.1 Nuevas Caracteristicas (v6.5.4)</b>', h2_style))
story.append(P('La comparacion de recursos entre ambas versiones revela varias caracteristicas nuevas: sistema de vinculacion de cuenta por email con dias de prueba gratis como incentivo ("Binding your account now, you will get a free %s days trial"), un sistema de codigos de canje (exchange codes) para obener dias VIP gratuitos, funcionalidad de restablecimiento de contrasena, notificaciones de red deficiente con recomendacion de cambiar de red, soporte mejorado para Chromecast con selector de dispositivos, y dialogos de actualizacion mas detallados con URL de descarga directa y version actual mostrada. Tambien se anadio un mensaje de bienvenida para miembros ("Dear member, welcome to use Xuper") y mejoras en el flujo de compra de suscripciones.'))
story.append(Spacer(1, 10))

story.append(P('<b>6.2 Caracteristicas Eliminadas</b>', h2_style))
story.append(P('Se eliminaron varios elementos de la interfaz: los componentes de codigo QR (mIvQrCode, mTvQrDesc), el sistema visual de recompensas (mIvReward), la opcion de registro por email (you_email, mViewMail), y se simplificaron algunos strings en portugues. La eliminacion del QR code sugiere que la funcionalidad de escaneo fue removida o rediseada completamente en esta version.'))

# ============ SECTION 7: Next Steps ============
story.append(Spacer(1, 18))
story.append(P('<b>7. Proximos Pasos</b>', h1_style))

story.append(P('<b>7.1 Acciones Inmediatas (cuando los servidores vuelvan)</b>', h2_style))
steps1 = [
    'Ejecutar el script de monitoreo para detectar cuando los servidores vuelvan a estar operativos',
    'Probar versionCode 60504 contra los endpoints /api/portalCore/v8/login y /v6/login',
    'Si es aceptado, documentar la respuesta completa del API incluyendo estructura JSON y campos',
    'Si es rechazado, sera necesario obtener un APK mas reciente de Xuper TV',
    'Mapear todos los endpoints adicionales: canales, EPG, VOD, configuracion',
]
for i, step in enumerate(steps1, 1):
    story.append(P(f'{i}. {step}'))
story.append(Spacer(1, 10))

story.append(P('<b>7.2 Analisis Profundo (requiere dispositivo Android)</b>', h2_style))
story.append(P('Para extraer informacion que no se puede obtener estaticamente debido a la proteccion iJiami, se recomienda usar Frida para hookear la clase DETool y capturar la clave 3DES actualizada, los dominios descifrados en runtime, y los tokens de autenticacion. Tambien se puede interceptar el trafico HTTP con mitmproxy para ver las requests completas, o crear un modulo Xposed para loggear todas las llamadas HTTP. Otra opcion es realizar un dump del DEX en runtime para obtener el codigo desempaquetado directamente desde la memoria del proceso.'))
story.append(Spacer(1, 10))

story.append(P('<b>7.3 Construccion de la App Propia</b>', h2_style))
story.append(P('Una vez que se tenga acceso validado a las APIs con versionCode 60504, el siguiente paso es descubrir los endpoints de canales (getChannel, getLive), la guia de programacion (getEpg), el contenido VOD, y la configuracion del reproductor. Con esta informacion se puede construir una aplicacion propia que replique las llamadas API de Xuper TV, implementando un sistema de autenticacion propio y una interfaz de usuario moderna.'))

# ============ SECTION 8: Tools ============
story.append(Spacer(1, 18))
story.append(P('<b>8. Herramientas Creadas</b>', h1_style))
tools_data = [
    [P('<b>Archivo</b>', header_cell), P('<b>Proposito</b>', header_cell)],
    [P('xuper-tools/xuper-apk-analyzer.py', cell_left), P('Analiza APKs con androguard, extrae versionCode/dominios/endpoints', cell_left)],
    [P('xuper-tools/xuper-update.sh', cell_left), P('Script de actualizacion con modos interactivo, APK, auto, test-api', cell_left)],
    [P('xuper-tools/xuper-api-monitor.sh', cell_left), P('Monitorea APIs periodicamente y detecta cuando vuelven online', cell_left)],
    [P('Xuper_TV_Instructivo_Proxima_Sesion.docx', cell_left), P('Guia detallada para continuar el trabajo en la proxima sesion', cell_left)],
]
story.append(make_table(tools_data, [W*0.40, W*0.60]))

# ============ Build ============
doc.build(story)
print(f"PDF generated: {output}")
print(f"Size: {os.path.getsize(output)} bytes")
