const { Document, Packer, Paragraph, TextRun, Header, Footer,
        AlignmentType, HeadingLevel, PageNumber, PageBreak,
        Table, TableRow, TableCell, WidthType, BorderStyle,
        ShadingType, NumberFormat, SectionType } = require("docx");
const fs = require("fs");

// Tech/Digital palette (Cool + Light + Active)
const P = {
  primary: "#0A1628",
  body: "#1A2B40",
  secondary: "#6878A0",
  accent: "#5B8DB8",
  surface: "#F4F8FC",
};
const c = (hex) => hex.replace("#", "");

// Helper functions
function safeText(value, placeholder) {
  if (value === undefined || value === null || value === "" || String(value) === "NaN") {
    return placeholder || "【Fill in】";
  }
  return String(value);
}

function heading(text, level = HeadingLevel.HEADING_1) {
  return new Paragraph({
    heading: level,
    spacing: { before: level === HeadingLevel.HEADING_1 ? 360 : 240, after: 120 },
    children: [new TextRun({
      text,
      bold: true,
      color: c(P.primary),
      font: { ascii: "Calibri", eastAsia: "SimHei" },
      size: level === HeadingLevel.HEADING_1 ? 32 : level === HeadingLevel.HEADING_2 ? 28 : 26,
    })]
  });
}

function body(text) {
  return new Paragraph({
    alignment: AlignmentType.JUSTIFIED,
    indent: { firstLine: 480 },
    spacing: { line: 312, after: 80 },
    children: [new TextRun({
      text,
      size: 24,
      color: c(P.body),
      font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
    })],
  });
}

function bodyNoIndent(text) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 312, after: 80 },
    children: [new TextRun({
      text,
      size: 24,
      color: c(P.body),
      font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
    })],
  });
}

function codeBlock(text) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 276, after: 40 },
    indent: { left: 360 },
    children: [new TextRun({
      text,
      size: 20,
      color: c(P.accent),
      font: { ascii: "Consolas", eastAsia: "Consolas" },
    })],
  });
}

function bulletItem(text, level = 0) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 312, after: 40 },
    indent: { left: 720 + (level * 360), hanging: 240 },
    children: [new TextRun({
      text: "\u2022 " + text,
      size: 24,
      color: c(P.body),
      font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
    })],
  });
}

function numberedItem(num, text) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 312, after: 40 },
    indent: { left: 720, hanging: 360 },
    children: [
      new TextRun({
        text: `${num}. `,
        bold: true,
        size: 24,
        color: c(P.accent),
        font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
      }),
      new TextRun({
        text,
        size: 24,
        color: c(P.body),
        font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
      }),
    ],
  });
}

function warningBox(text) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 312, after: 80, before: 120 },
    indent: { left: 360, right: 360 },
    border: {
      left: { style: BorderStyle.SINGLE, size: 18, color: c(P.accent), space: 10 },
    },
    children: [new TextRun({
      text: "\u26A0 " + text,
      size: 24,
      color: c(P.accent),
      bold: true,
      font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
    })],
  });
}

function tipBox(text) {
  return new Paragraph({
    alignment: AlignmentType.LEFT,
    spacing: { line: 312, after: 80, before: 120 },
    indent: { left: 360, right: 360 },
    border: {
      left: { style: BorderStyle.SINGLE, size: 18, color: "2A7A3A", space: 10 },
    },
    children: [new TextRun({
      text: "\u2713 " + text,
      size: 24,
      color: "2A7A3A",
      font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
    })],
  });
}

// Build Cover using R1 recipe (left-aligned, dark bg)
const P_cover = {
  bg: "0B1C2C",
  titleColor: "FFFFFF",
  subtitleColor: "B0B8C0",
  metaColor: "90989F",
  footerColor: "687078",
  accent: "529286",
};

const NB = { style: BorderStyle.NONE, size: 0, color: "FFFFFF" };
const allNoBorders = { top: NB, bottom: NB, left: NB, right: NB, insideHorizontal: NB, insideVertical: NB };

function buildCover() {
  return [
    new Table({
      width: { size: 100, type: WidthType.PERCENTAGE },
      borders: allNoBorders,
      rows: [new TableRow({
        height: { value: 16838, rule: "exact" },
        children: [new TableCell({
          width: { size: 100, type: WidthType.PERCENTAGE },
          borders: allNoBorders,
          shading: { type: ShadingType.CLEAR, fill: P_cover.bg },
          verticalAlign: "top",
          children: [
            new Paragraph({ spacing: { before: 3600 }, children: [] }),
            new Paragraph({
              spacing: { before: 800, line: 900, lineRule: "atLeast" },
              indent: { left: 1200, right: 1200 },
              children: [new TextRun({
                text: "Xuper TV",
                color: P_cover.titleColor,
                font: { ascii: "Calibri", eastAsia: "SimHei" },
                size: 80,
                bold: true,
              })],
            }),
            new Paragraph({
              spacing: { before: 200, line: 600, lineRule: "atLeast" },
              indent: { left: 1200, right: 1200 },
              children: [new TextRun({
                text: "Reverse Engineering",
                color: P_cover.titleColor,
                font: { ascii: "Calibri", eastAsia: "SimHei" },
                size: 56,
              })],
            }),
            new Paragraph({
              spacing: { before: 600, line: 400 },
              indent: { left: 1200, right: 1200 },
              border: { top: { style: BorderStyle.SINGLE, size: 8, color: P_cover.accent, space: 20 } },
              children: [new TextRun({
                text: "Instructivo para Proxima Sesion y Automatizacion",
                color: P_cover.subtitleColor,
                font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
                size: 28,
              })],
            }),
            new Paragraph({
              spacing: { before: 800, line: 360 },
              indent: { left: 1200, right: 1200 },
              children: [new TextRun({
                text: "Guia de Continuacion - Extraccion de VersionCode y Monitoreo de APIs",
                color: P_cover.metaColor,
                font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
                size: 22,
              })],
            }),
            new Paragraph({
              spacing: { before: 400, line: 360 },
              indent: { left: 1200, right: 1200 },
              children: [new TextRun({
                text: "Fecha: Mayo 2026  |  Version: 1.0",
                color: P_cover.footerColor,
                font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
                size: 20,
              })],
            }),
          ],
        })],
      })],
    }),
  ];
}

// Build TOC section
function buildTOC() {
  return [
    new Paragraph({
      heading: HeadingLevel.HEADING_1,
      spacing: { before: 200, after: 200 },
      alignment: AlignmentType.CENTER,
      children: [new TextRun({
        text: "Tabla de Contenidos",
        bold: true,
        color: c(P.primary),
        font: { ascii: "Calibri", eastAsia: "SimHei" },
        size: 32,
      })],
    }),
  ];
}

// Build body content
function buildBody() {
  const content = [];

  // Section 1: Contexto Actual
  content.push(heading("1. Contexto Actual del Proyecto"));
  content.push(body("Este documento sirve como guia de continuacion para la sesion de ingenieria inversa de la aplicacion Xuper TV (IPTV). A lo largo de las sesiones anteriores, se ha logrado un progreso significativo en la descompilacion, analisis y monitoreo de la infraestructura de la aplicacion, pero se ha identificado un bloqueador critico que impide el acceso completo a las APIs del servidor."));
  
  content.push(heading("1.1 Progreso Alcanzado", HeadingLevel.HEADING_2));
  content.push(body("Se ha completado exitosamente la ingenieria inversa basica de la aplicacion Xuper TV, incluyendo la extraccion de todas las URLs de SharedPreferences, la identificacion de 6 dominios API ofuscados (que luego se expandieron a 15 con el monitor), el descubrimiento del servidor CDN de imagenes (cftpbe.39114gi1.com), el analisis del sistema de encriptacion 3DES para valores de host, y la construccion de una aplicacion Next.js de monitoreo completa con dashboard, alertas y base de datos SQLite. Esta aplicacion fue desplegada exitosamente en GitHub en el repositorio https://github.com/yecos/guar y verificada localmente mostrando los 15 dominios activos y respondiendo correctamente."));
  
  content.push(heading("1.2 Bloqueador Critico Identificado", HeadingLevel.HEADING_2));
  content.push(body("Al intentar acceder a los endpoints API de los servidores de Xuper TV, se descubre que todos rechazan las peticiones con el error: {\"msg\":\"\u7248\u672C\u5DF2\u505C\u6B62\u4F7F\u7528\",\"code\":400}, lo que se traduce como \"Version descontinuada\". Esto significa que los servidores validan el versionCode enviado en los headers de la peticion HTTP, y el versionCode antiguo (60500) que se extrajo de la APK analizada ya no es aceptado. Se probaron versiones desde 60500 hasta 70100 sin exito, lo que indica que el versionCode valido debe estar en la APK mas reciente disponible (v7.1.1 o superior)."));
  content.push(warningBox("Sin el versionCode actual, es imposible acceder a las APIs de Xuper TV. Esta es la prioridad numero uno para la proxima sesion."));

  content.push(heading("1.3 Infraestructura Descubierta", HeadingLevel.HEADING_2));
  content.push(body("El sistema de monitoreo ha confirmado que los 15 dominios identificados estan activos y resolviendo a traves de Cloudflare (IPs 104.21.x.x y 172.67.x.x), con la excepcion de www.magistvec.com que resuelve a 103.224.182.251 (fuera de Cloudflare). Los dominios estan organizados en 9 categorias funcionales: ads (publicidad), bigbee (servicio principal), cdn (contenido estatico), download (descargas), epg (guia de programacion), h5 (interfaz web), notice (notificaciones), portal (acceso principal) y upgrade (actualizaciones). El endpoint DCS (/api/v2/dcs/getAddr) responde correctamente en 298ms, lo que indica que los servidores estan operativos y solo falta el versionCode correcto."));

  // Section 2: Objetivo de la Proxima Sesion
  content.push(heading("2. Objetivo Principal de la Proxima Sesion"));
  content.push(body("El objetivo primordial de la proxima sesion es obtener acceso completo a las APIs de Xuper TV extrayendo el versionCode valido de la APK mas reciente. Una vez obtenido el versionCode, se podra validar el acceso a todos los endpoints, extraer la configuracion completa de dominios, y eventualmente construir la aplicacion de streaming propia. Los pasos a seguir estan organizados en orden de prioridad y dependencia."));

  content.push(heading("2.1 Paso 1: Obtener la APK Actualizada", HeadingLevel.HEADING_2));
  content.push(body("Descargar la ultima version de Xuper TV desde APKPure (https://apkpure.com/xuper-tv/com.xuper.tv). Si la descarga directa falla, se puede usar el navegador del emulador Android para descargar la APK desde dentro del emulador. Si el formato descargado es XAPK, se debe renombrar a .zip y extraer el archivo .apk que contiene en su interior. El archivo APK no necesita ser instalado en el emulador para el analisis, solo necesitamos el archivo para procesarlo con las herramientas de extraccion."));
  content.push(tipBox("No necesitas instalar la APK en el emulador. Solo necesitas el archivo .apk para analizarlo con androguard o apktool."));

  content.push(heading("2.2 Paso 2: Extraer el VersionCode", HeadingLevel.HEADING_2));
  content.push(body("El versionCode se puede extraer de multiples formas sin necesidad de ejecutar la aplicacion. La forma mas facil es subir el archivo APK a este entorno (copiarlo al directorio del proyecto) y ejecutar el script de automatizacion que se creo en esta sesion. El script xuper-apk-analyzer.py utiliza la libreria androguard para abrir el APK y extraer toda la informacion relevante de forma automatica, incluyendo versionCode, versionName, dominios, endpoints, claves de encriptacion y headers HTTP personalizados."));
  content.push(body("Comandos para ejecutar el analisis:"));
  content.push(codeBlock("python3 /home/z/my-project/download/xuper-tools/xuper-apk-analyzer.py APK_FILE.apk --update-monitor"));
  content.push(codeBlock("bash /home/z/my-project/download/xuper-tools/xuper-update.sh --apk APK_FILE.apk"));
  content.push(body("Alternativamente, si prefieres un metodo manual, puedes usar las siguientes herramientas: aapt dump badging app.apk (muestra versionCode y versionName), apktool d app.apk (decompila completamente la APK), o simplemente descomprimir el APK con unzip y buscar en AndroidManifest.xml."));

  content.push(heading("2.3 Paso 3: Probar las APIs con el Nuevo VersionCode", HeadingLevel.HEADING_2));
  content.push(body("Una vez obtenido el versionCode, se debe probar inmediatamente contra los servidores API. El comando basico para probar es:"));
  content.push(codeBlock("curl -s https://c2tgd.izvhrdcjb.com/api/v2/dcs/getAddr \\"));
  content.push(codeBlock("  -H 'versionCode: NUEVO_CODE' \\"));
  content.push(codeBlock("  -H 'platform: android' \\"));
  content.push(codeBlock("  -H 'Content-Type: application/json' \\"));
  content.push(codeBlock("  -d '{\"appId\":\"1\"}'"));
  content.push(body("Si el servidor responde con algo diferente a \"版本已停止使用\", significa que el versionCode es valido. El endpoint DCS (/api/v2/dcs/getAddr) es el mas importante ya que devuelve la configuracion actualizada de dominios y URLs que la aplicacion utiliza para conectarse. Otros endpoints importantes para probar incluyen /api/v2/upgrade/check (verificacion de actualizaciones) y /api/v2/notice/getList (lista de notificaciones)."));

  content.push(heading("2.4 Paso 4: Actualizar el Monitor", HeadingLevel.HEADING_2));
  content.push(body("Si el script se ejecuto con la bandera --update-monitor, la configuracion del monitor Next.js se actualizara automaticamente. De lo contrario, se debe actualizar manualmente el archivo src/lib/domains.ts en el proyecto del monitor con cualquier dominio nuevo descubierto, y actualizar el versionCode en las peticiones API. Despues de los cambios, reconstruir y desplegar el monitor con npm run build && npx next start -p 3000."));

  // Section 3: Herramientas y Scripts Creados
  content.push(heading("3. Herramientas y Scripts de Automatizacion"));
  content.push(body("En esta sesion se han creado dos herramientas principales de automatizacion que simplifican enormemente el proceso de analisis de nuevas versiones de la APK. Estas herramientas estan disenadas para ser reutilizadas cada vez que Xuper TV actualice su aplicacion, permitiendo mantener el sistema de monitoreo actualizado con el minimo esfuerzo manual."));

  content.push(heading("3.1 Script de Analisis de APK (xuper-apk-analyzer.py)", HeadingLevel.HEADING_2));
  content.push(body("Este script en Python es la herramienta principal de automatizacion. Utiliza la libreria androguard para abrir y analizar cualquier APK de Xuper TV de forma automatica. Extrae: informacion de version (versionCode, versionName, package name), todos los dominios y URLs en el codigo (incluyendo dominios ofuscados), endpoints API (/api/v2/...), posibles claves de encriptacion (3DES, AES), headers HTTP personalizados (versionCode, platform, appId, etc.), strings relacionadas con control de versiones, y claves de SharedPreferences. El script genera reportes en formato JSON y Markdown, y opcionalmente actualiza la configuracion del monitor Next.js."));
  content.push(body("Ubicacion: /home/z/my-project/download/xuper-tools/xuper-apk-analyzer.py"));
  content.push(body("Uso basico:"));
  content.push(codeBlock("python3 xuper-apk-analyzer.py archivo.apk"));
  content.push(body("Uso con actualizacion del monitor:"));
  content.push(codeBlock("python3 xuper-apk-analyzer.py archivo.apk --update-monitor --monitor-path /path/to/xuper-monitor"));

  content.push(heading("3.2 Script de Actualizacion (xuper-update.sh)", HeadingLevel.HEADING_2));
  content.push(body("Este script Bash es un wrapper interactivo que orquesta todo el flujo de actualizacion. Ofrece un menu interactivo con opciones para: analizar una APK existente, descargar y analizar la ultima APK, probar las APIs con el versionCode actual, y generar un prompt para mantenimiento con IA. El script verifica dependencias automaticamente, gestiona la descarga desde APKPure, ejecuta el analisis con xuper-apk-analyzer.py, prueba las APIs automaticamente con el nuevo versionCode, y genera un prompt contextualizado para que la IA pueda continuar el trabajo en futuras sesiones."));
  content.push(body("Ubicacion: /home/z/my-project/download/xuper-tools/xuper-update.sh"));
  content.push(body("Modos de uso:"));
  content.push(codeBlock("./xuper-update.sh                    # Modo interactivo"));
  content.push(codeBlock("./xuper-update.sh --apk file.apk     # Analizar APK especifica"));
  content.push(codeBlock("./xuper-update.sh --auto             # Descargar + analizar + actualizar"));
  content.push(codeBlock("./xuper-update.sh --test-api         # Solo probar APIs"));
  content.push(codeBlock("./xuper-update.sh --ai-maintain      # Generar prompt para IA"));

  // Section 4: Conectar con IA para Mantenimiento
  content.push(heading("4. Conexion con IA para Mantenimiento Continuo"));
  content.push(body("Una de las solicitudes originales era poder conectar el script con una IA (como este asistente) para que mantenga el sistema actualizado automaticamente. Aunque no es posible establecer una conexion directa y permanente entre un script local y la IA, existen varias estrategias para lograr un flujo de trabajo semiautomatico eficiente que minimiza la intervencion manual."));

  content.push(heading("4.1 Estrategia: Prompt Contextualizado", HeadingLevel.HEADING_2));
  content.push(body("La estrategia mas practica consiste en generar un prompt contextualizado que contenga toda la informacion necesaria para que la IA pueda continuar el trabajo sin perder contexto. El script xuper-update.sh incluye la opcion --ai-maintain que genera automaticamente un archivo markdown con el estado actual del sistema, los archivos clave, los comandos necesarios, y las instrucciones paso a paso. Cuando inicies una nueva sesion con la IA, simplemente copia y pega este prompt contextualizado junto con la ruta a la nueva APK, y la IA podra ejecutar el analisis, comparar cambios, actualizar el monitor y probar las APIs de forma autonoma."));

  content.push(heading("4.2 Ejemplo de Flujo de Trabajo", HeadingLevel.HEADING_2));
  content.push(numberedItem(1, "Descargas la nueva APK de Xuper TV cuando se actualice"));
  content.push(numberedItem(2, "Ejecutas: ./xuper-update.sh --apk nueva_version.apk --ai-maintain"));
  content.push(numberedItem(3, "El script analiza la APK y genera el prompt en xuper-analysis/ai-maintenance-prompt.md"));
  content.push(numberedItem(4, "Copias el contenido de ese archivo y lo pegas al iniciar una nueva sesion con la IA"));
  content.push(numberedItem(5, "La IA lee el contexto, ejecuta los comandos necesarios y actualiza todo automaticamente"));
  content.push(body("Este flujo permite mantener el sistema actualizado con solo unos minutos de interaccion cada vez que Xuper TV lanza una actualizacion."));

  content.push(heading("4.3 Opcion Avanzada: Webhook con n8n o Zapier", HeadingLevel.HEADING_2));
  content.push(body("Para una automatizacion mas avanzada, se podria configurar un flujo en n8n (open source) o Zapier que monitorice periodicamente la pagina de APKPure para detectar nuevas versiones de Xuper TV. Cuando se detecte una actualizacion, el flujo podria descargar automaticamente la APK, ejecutar el script de analisis, y enviar los resultados por correo electronico o notificacion de Telegram. Esta opcion requiere un servidor VPS donde ejecutar n8n y almacenar las APKs, pero proporcionaria un monitoreo completamente automatico sin intervencion manual. El costo de un VPS basico para este proposito seria de aproximadamente 5-10 USD mensuales."));

  // Section 5: Troubleshooting
  content.push(heading("5. Solucion de Problemas Comunes"));

  content.push(heading("5.1 APK No Compatible con el Emulador", HeadingLevel.HEADING_2));
  content.push(body("Si la APK descargada no es compatible con LDPlayer u otro emulador, no es necesario instalarla. Solo necesitas el archivo APK para analizarlo. Las posibles causas de incompatibilidad incluyen: la APK requiere una version de Android superior a la del emulador (verificar minSdkVersion en el manifest), la APK es para arquitectura ARM64 y el emulador solo soporta x86 (configurar el emulador para ARM compatibility), o la APK tiene proteccion anti-emulador. En cualquier caso, el analisis con androguard no requiere ejecutar la APK, solo leer el archivo."));

  content.push(heading("5.2 VersionCode Rechazado", HeadingLevel.HEADING_2));
  content.push(body("Si el versionCode extraido sigue siendo rechazado por los servidores, puede significar que: la APK descargada no es la version mas reciente (verificar en APKPure la fecha de la ultima actualizacion), los servidores requieren un token adicional ademas del versionCode (revisar los headers que envia la app real con un proxy MITM), o los servidores validan otros parametros como el deviceId o appId. En este caso, se necesitaria configurar un proxy MITM (como mitmproxy) para capturar las peticiones reales de la aplicacion y ver exactamente que headers y parametros envia."));

  content.push(heading("5.3 Dominios Nuevos No Detectados", HeadingLevel.HEADING_2));
  content.push(body("Si despues de actualizar el monitor aparecen dominios nuevos que no estaban en la APK, es probable que estos se distribuyan a traves del endpoint DCS. La aplicacion consulta /api/v2/dcs/getAddr al iniciarse y recibe una lista actualizada de dominios y URLs. Para capturar estos dominios dinamicos, se podria modificar el monitor para que consulte periodicamente el endpoint DCS y compare los dominios devueltos con los ya conocidos, generando una alerta cuando se detecten cambios. Esta funcionalidad ya esta parcialmente implementada en src/lib/dcs-monitor.ts del proyecto del monitor."));

  content.push(heading("5.4 Proceso del Servidor Muere", HeadingLevel.HEADING_2));
  content.push(body("En el entorno de contenedor donde se ejecuta este sistema, los procesos en segundo plano pueden ser terminados entre comandos. Para evitar esto, se recomienda ejecutar el servidor del monitor con un comando unico que incluya la build y el inicio: npm run build && npx next start -p 3000. Para uso a largo plazo, se recomienda desplegar el monitor en Vercel (requiere migrar SQLite a Turso DB) o en un VPS con PM2 como gestor de procesos, lo que garantizaria que el servidor se reinicie automaticamente si se cae."));

  // Section 6: Estructura de Archivos
  content.push(heading("6. Estructura de Archivos del Proyecto"));
  content.push(body("A continuacion se detalla la estructura completa del proyecto con todos los archivos creados hasta ahora, sus ubicaciones y propositos. Esta referencia es esencial para la proxima sesion, ya que permite localizar rapidamente cualquier componente del sistema."));

  // Files table
  const fileData = [
    ["xuper-tools/xuper-apk-analyzer.py", "Script principal de analisis de APK con androguard"],
    ["xuper-tools/xuper-update.sh", "Script wrapper interactivo para flujo completo"],
    ["xuper-monitor/", "Proyecto Next.js del dashboard de monitoreo"],
    ["xuper-monitor/src/lib/domains.ts", "Configuracion de los 15 dominios monitoreados"],
    ["xuper-monitor/src/lib/db-sqlite.ts", "Capa de base de datos SQLite"],
    ["xuper-monitor/src/lib/dcs-monitor.ts", "Monitor del endpoint DCS para dominios dinamicos"],
    ["xuper-monitor/src/app/page.tsx", "Dashboard principal con tema oscuro"],
    ["xuper-monitor/src/app/api/monitor/route.ts", "API de monitoreo (DNS + HTTP ping)"],
    ["xuper-monitor/src/app/api/domains/route.ts", "API de estado de dominios"],
    ["xuper-monitor/src/app/api/alerts/route.ts", "API de alertas de cambios"],
    ["Xuper_TV_Reverse_Engineering_Report.docx", "Reporte completo de ingenieria inversa"],
  ];

  const headerCellStyle = {
    bold: true,
    size: 22,
    color: "FFFFFF",
    font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
  };
  const dataCellStyle = {
    size: 20,
    color: c(P.body),
    font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
  };

  const tableRows = [
    new TableRow({
      tableHeader: true,
      children: [
        new TableCell({
          width: { size: 40, type: WidthType.PERCENTAGE },
          shading: { type: ShadingType.CLEAR, fill: c(P.accent) },
          margins: { top: 60, bottom: 60, left: 120, right: 120 },
          children: [new Paragraph({ children: [new TextRun({ text: "Archivo", ...headerCellStyle })] })],
        }),
        new TableCell({
          width: { size: 60, type: WidthType.PERCENTAGE },
          shading: { type: ShadingType.CLEAR, fill: c(P.accent) },
          margins: { top: 60, bottom: 60, left: 120, right: 120 },
          children: [new Paragraph({ children: [new TextRun({ text: "Descripcion", ...headerCellStyle })] })],
        }),
      ],
    }),
  ];

  fileData.forEach(([file, desc], idx) => {
    tableRows.push(new TableRow({
      children: [
        new TableCell({
          width: { size: 40, type: WidthType.PERCENTAGE },
          shading: { type: ShadingType.CLEAR, fill: idx % 2 === 0 ? c(P.surface) : "FFFFFF" },
          margins: { top: 40, bottom: 40, left: 120, right: 120 },
          children: [new Paragraph({ children: [new TextRun({ text: file, ...dataCellStyle, font: { ascii: "Consolas", eastAsia: "Consolas" } })] })],
        }),
        new TableCell({
          width: { size: 60, type: WidthType.PERCENTAGE },
          shading: { type: ShadingType.CLEAR, fill: idx % 2 === 0 ? c(P.surface) : "FFFFFF" },
          margins: { top: 40, bottom: 40, left: 120, right: 120 },
          children: [new Paragraph({ children: [new TextRun({ text: desc, ...dataCellStyle })] })],
        }),
      ],
    }));
  });

  content.push(new Table({
    width: { size: 100, type: WidthType.PERCENTAGE },
    rows: tableRows,
  }));

  // Section 7: Dominios Monitoreados
  content.push(heading("7. Dominios Monitoreados (15 Total)"));
  content.push(body("Los siguientes 15 dominios estan actualmente siendo monitoreados por el sistema. Todos responden a peticiones HTTPS a traves de Cloudflare, con la excepcion de www.magistvec.com que usa un servidor independiente. Estos dominios fueron identificados durante la ingenieria inversa de la APK y verificados como activos durante las sesiones de prueba."));

  const domainCategories = [
    ["ads (Publicidad)", "jktgk.bxtzwlyan.com, skc2r.plracsimf.com"],
    ["bigbee (Servicio Principal)", "skvbv.hbcpdutka.com, c2tgd3.ewzpuscyv.com"],
    ["cdn (Contenido Estatico)", "cftpbe.39114gi1.com"],
    ["download (Descargas)", "www.magistvec.com"],
    ["epg (Guia de Programacion)", "bktjr.akvndhzgx.com, cdtgcr.bcjoapser.com"],
    ["h5 (Interfaz Web)", "bg4gr.msfxethyc.com"],
    ["notice (Notificaciones)", "ckfdr.nzxgfvrud.com, g4tc2.irlapchbd.com"],
    ["portal (Acceso Principal)", "c2tgd.izvhrdcjb.com, dtgrd.txhnojlbu.com"],
    ["upgrade (Actualizaciones)", "vtgrc.ncimxztfk.com, jktgr.ludgwoxhe.com"],
  ];

  domainCategories.forEach(([cat, domains]) => {
    content.push(new Paragraph({
      spacing: { before: 120, after: 40 },
      children: [
        new TextRun({
          text: cat + ": ",
          bold: true,
          size: 22,
          color: c(P.accent),
          font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
        }),
        new TextRun({
          text: domains,
          size: 22,
          color: c(P.body),
          font: { ascii: "Consolas", eastAsia: "Consolas" },
        }),
      ],
    }));
  });

  // Section 8: Checklist para la Proxima Sesion
  content.push(heading("8. Checklist para la Proxima Sesion"));
  content.push(body("Esta checklist resume los pasos exactos a seguir al inicio de la proxima sesion. Se recomienda imprimirla o tenerla visible durante la sesion para asegurar que no se omite ningun paso critico."));

  const checklistItems = [
    "Descargar la APK mas reciente de Xuper TV desde APKPure",
    "Copiar el archivo APK al entorno (directorio /home/z/my-project/download/)",
    "Ejecutar: python3 xuper-tools/xuper-apk-analyzer.py APK_FILE.apk --update-monitor",
    "Verificar que el versionCode extraido sea diferente de 60500",
    "Probar las APIs con el nuevo versionCode usando curl",
    "Si las APIs responden correctamente, consultar el endpoint DCS para obtener dominios actualizados",
    "Comparar dominios del DCS con los del monitor y actualizar si es necesario",
    "Reconstruir y desplegar el monitor: npm run build && npx next start -p 3000",
    "Verificar que el monitor muestra los 15+ dominios como activos",
    "Si el versionCode funciona, documentar todos los endpoints accesibles y sus respuestas",
    "Generar el prompt para IA con: ./xuper-update.sh --ai-maintain",
    "Hacer push de los cambios a GitHub: git add . && git commit -m 'update' && git push",
  ];

  checklistItems.forEach((item, idx) => {
    content.push(new Paragraph({
      spacing: { line: 312, after: 40 },
      indent: { left: 360 },
      children: [
        new TextRun({
          text: "\u2610 ",
          size: 24,
          color: c(P.accent),
          font: { ascii: "Calibri" },
        }),
        new TextRun({
          text: `${idx + 1}. ${item}`,
          size: 24,
          color: c(P.body),
          font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
        }),
      ],
    }));
  });

  content.push(warningBox("PRIORIDAD: Los pasos 1-5 son criticos. Sin el versionCode correcto, ningun otro avance es posible."));

  // Section 9: Comandos de Referencia Rapida
  content.push(heading("9. Comandos de Referencia Rapida"));
  content.push(body("A continuacion se presentan los comandos mas utilizados durante el proyecto, organizados por categoria, para facilitar su ejecucion rapida durante la proxima sesion."));

  content.push(heading("9.1 Analisis de APK", HeadingLevel.HEADING_2));
  content.push(codeBlock("python3 xuper-tools/xuper-apk-analyzer.py APK_FILE.apk --update-monitor"));
  content.push(codeBlock("bash xuper-tools/xuper-update.sh --apk APK_FILE.apk"));
  content.push(codeBlock("aapt dump badging APK_FILE.apk | head -5"));

  content.push(heading("9.2 Prueba de APIs", HeadingLevel.HEADING_2));
  content.push(codeBlock("curl -s https://c2tgd.izvhrdcjb.com/api/v2/dcs/getAddr \\"));
  content.push(codeBlock("  -H 'versionCode: NUEVO_CODE' -H 'platform: android' \\"));
  content.push(codeBlock("  -H 'Content-Type: application/json' -d '{\"appId\":\"1\"}'"));
  content.push(codeBlock("bash xuper-tools/xuper-update.sh --test-api"));

  content.push(heading("9.3 Monitor Next.js", HeadingLevel.HEADING_2));
  content.push(codeBlock("cd xuper-monitor && npm run build && npx next start -p 3000"));
  content.push(codeBlock("curl -s http://localhost:3000/api/monitor | python3 -m json.tool"));
  content.push(codeBlock("curl -s http://localhost:3000/api/domains | python3 -m json.tool"));

  content.push(heading("9.4 Git y Despliegue", HeadingLevel.HEADING_2));
  content.push(codeBlock("cd xuper-monitor && git add . && git commit -m 'update version' && git push"));

  return content;
}

// Build the document
const doc = new Document({
  styles: {
    default: {
      document: {
        run: {
          font: { ascii: "Calibri", eastAsia: "Microsoft YaHei" },
          size: 24,
          color: c(P.body),
        },
        paragraph: {
          spacing: { line: 312 },
        },
      },
    },
    heading1: {
      run: {
        font: { ascii: "Calibri", eastAsia: "SimHei" },
        size: 32,
        bold: true,
        color: c(P.primary),
      },
    },
    heading2: {
      run: {
        font: { ascii: "Calibri", eastAsia: "SimHei" },
        size: 28,
        bold: true,
        color: c(P.primary),
      },
    },
  },
  sections: [
    // Cover section
    {
      properties: {
        page: {
          margin: { top: 0, bottom: 0, left: 0, right: 0 },
        },
      },
      children: buildCover(),
    },
    // Body section
    {
      properties: {
        page: {
          size: { width: 11906, height: 16838, orientation: "portrait" },
          margin: { top: 1440, bottom: 1440, left: 1701, right: 1417 },
          pageNumbers: { start: 1, formatType: NumberFormat.DECIMAL },
        },
      },
      footers: {
        default: new Footer({
          children: [new Paragraph({
            alignment: AlignmentType.CENTER,
            children: [new TextRun({ children: [PageNumber.CURRENT], size: 18, color: c(P.secondary) })],
          })],
        }),
      },
      children: buildBody(),
    },
  ],
});

// Generate
const outputPath = "/home/z/my-project/download/Xuper_TV_Instructivo_Proxima_Sesion.docx";
Packer.toBuffer(doc).then(buf => {
  fs.writeFileSync(outputPath, buf);
  console.log("Document generated: " + outputPath);
});
