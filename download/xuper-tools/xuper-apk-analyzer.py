#!/usr/bin/env python3
"""
Xuper TV APK Analyzer - Script de Automatización
=================================================
Extrae automáticamente toda la información relevante de un APK de Xuper TV:
- versionCode y versionName
- Dominios y URLs en el código
- Endpoints API
- Claves de encriptación
- Headers HTTP personalizados
- Configuración de red
- Permisos requeridos
- Servicios y receivers

Uso:
  python3 xuper-apk-analyzer.py <archivo.apk> [--full] [--update-monitor] [--monitor-path PATH]

Opciones:
  --full             Análisis completo (incluye decompilación - más lento)
  --update-monitor   Actualiza automáticamente la config del monitor Next.js
  --monitor-path     Ruta al proyecto monitor (default: ./xuper-monitor)

Ejemplos:
  python3 xuper-apk-analyzer.py xuper_base.apk
  python3 xuper-apk-analyzer.py xuper_base.apk --full --update-monitor
  python3 xuper-apk-analyzer.py xuper_base.apk --update-monitor --monitor-path /home/z/my-project/download/xuper-monitor
"""

import sys
import os
import re
import json
import hashlib
import argparse
from datetime import datetime
from pathlib import Path

# Verificar dependencias
try:
    from androguard.core.apk import APK
    from androguard.core.dex import DEX
except ImportError:
    print("[-] Error: androguard no está instalado")
    print("    Instala con: pip3 install androguard")
    sys.exit(1)


# Colores para terminal
class Colors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'


def print_header(text):
    print(f"\n{Colors.HEADER}{Colors.BOLD}{'='*60}{Colors.ENDC}")
    print(f"{Colors.HEADER}{Colors.BOLD}  {text}{Colors.ENDC}")
    print(f"{Colors.HEADER}{Colors.BOLD}{'='*60}{Colors.ENDC}\n")


def print_section(text):
    print(f"\n{Colors.OKCYAN}{Colors.BOLD}[>] {text}{Colors.ENDC}")


def print_success(text):
    print(f"  {Colors.OKGREEN}[+]{Colors.ENDC} {text}")


def print_warning(text):
    print(f"  {Colors.WARNING}[!]{Colors.ENDC} {text}")


def print_error(text):
    print(f"  {Colors.FAIL}[-]{Colors.ENDC} {text}")


def print_info(text):
    print(f"  {Colors.OKBLUE}[*]{Colors.ENDC} {text}")


def extract_domains_from_strings(strings):
    """Extrae dominios y URLs de las strings del APK"""
    domains = set()
    urls = set()
    
    # Patrones de dominio
    domain_patterns = [
        r'(?:https?://)?([a-z0-9]{5,}\.[a-z0-9]{5,}\.[a-z]{2,})',  # sub.domain.tld (obfuscated style)
        r'(?:https?://)?([a-z0-9][-a-z0-9]*\.)+[a-z]{2,}(?:/[^\s"]*)?',  # standard domains
    ]
    
    url_pattern = r'https?://[^\s"\'<>]+'
    
    for s in strings:
        # Buscar URLs completas
        found_urls = re.findall(url_pattern, s)
        for u in found_urls:
            urls.add(u)
            # Extraer dominio de la URL
            domain_match = re.search(r'://([^/]+)', u)
            if domain_match:
                domains.add(domain_match.group(1))
        
        # Buscar dominios sin protocolo
        for pattern in domain_patterns:
            matches = re.findall(pattern, s)
            for m in matches:
                if isinstance(m, tuple):
                    m = m[0] if m[0] else m[1] if len(m) > 1 else m[0]
                if '.' in str(m) and len(str(m)) > 5:
                    domains.add(str(m))
    
    return domains, urls


def extract_api_endpoints(strings):
    """Extrae endpoints API del código"""
    endpoints = set()
    
    api_patterns = [
        r'/api/v\d+/[a-zA-Z0-9_/]+',
        r'/api/[a-zA-Z0-9_/]+',
    ]
    
    for s in strings:
        for pattern in api_patterns:
            matches = re.findall(pattern, s)
            for m in matches:
                if len(m) > 5 and not m.endswith('.js') and not m.endswith('.css'):
                    endpoints.add(m)
    
    return endpoints


def extract_encryption_keys(strings):
    """Busca posibles claves de encriptación (3DES, AES, etc.)"""
    keys = set()
    
    # Patrones de claves comunes en apps Android
    key_patterns = [
        r'(?:3des|3DES|des|DES|aes|AES|key|KEY|secret|SECRET|encrypt|ENCRYPT)[_\-:]?\s*[=:]\s*["\']([A-Za-z0-9+/=]{8,32})["\']',
        r'["\']([A-Za-z0-9+/=]{24})["\']',  # 3DES keys are typically 24 bytes base64
    ]
    
    # Buscar strings que parezcan claves
    for s in strings:
        if any(kw in s.lower() for kw in ['3des', 'deskey', 'des_key', 'encrypt_key', 'secret_key', 'aes_key']):
            # Buscar base64-like strings cercanas
            b64_match = re.search(r'[A-Za-z0-9+/=]{16,32}', s)
            if b64_match:
                keys.add((s[:80], b64_match.group(0)))
    
    return keys


def extract_custom_headers(strings):
    """Busca headers HTTP personalizados usados por la app"""
    headers = {}
    
    header_keywords = [
        'versionCode', 'versionName', 'verCode', 'verName',
        'appId', 'app_id', 'channelId', 'channel_id',
        'deviceId', 'device_id', 'token', 'Authorization',
        'User-Agent', 'X-', 'platform', 'Platform',
        'appVersion', 'app_version', 'package_name',
        'lang', 'language', 'Content-Type',
    ]
    
    for s in strings:
        for kw in header_keywords:
            if kw in s and len(s) < 200:
                # Intentar extraer key:value
                kv_match = re.match(r'([A-Za-z][A-Za-z0-9\-_]*)\s*[:=]\s*(.+)', s)
                if kv_match:
                    headers[kv_match.group(1)] = kv_match.group(2)[:100]
                elif s == kw or s.lower() == kw.lower():
                    headers[kw] = '<dynamic>'
    
    return headers


def extract_version_from_apk(apk_path):
    """Extrae información de versión del APK"""
    print_header("XUPER TV APK ANALYZER v1.0")
    
    if not os.path.exists(apk_path):
        print_error(f"Archivo no encontrado: {apk_path}")
        return None
    
    # Hash del archivo
    print_section("Información del Archivo")
    file_size = os.path.getsize(apk_path)
    print_info(f"Archivo: {apk_path}")
    print_info(f"Tamaño: {file_size:,} bytes ({file_size/1024/1024:.1f} MB)")
    
    md5 = hashlib.md5(open(apk_path, 'rb').read()).hexdigest()
    sha256 = hashlib.sha256(open(apk_path, 'rb').read()).hexdigest()
    print_info(f"MD5: {md5}")
    print_info(f"SHA256: {sha256}")
    
    # Cargar APK con androguard
    print_section("Analizando APK con Androguard...")
    try:
        a = APK(apk_path)
    except Exception as e:
        print_error(f"Error al cargar APK: {e}")
        return None
    
    result = {
        'analysis_date': datetime.now().isoformat(),
        'file_info': {
            'path': apk_path,
            'size': file_size,
            'md5': md5,
            'sha256': sha256,
        }
    }
    
    # === VERSION INFO ===
    print_section("Información de Versión")
    version_code = a.get_androidversion_code()
    version_name = a.get_androidversion_name()
    package_name = a.get_package()
    min_sdk = a.get_min_sdk_version()
    target_sdk = a.get_target_sdk_version()
    max_sdk = a.get_max_sdk_version()
    
    print_success(f"Package: {package_name}")
    print_success(f"Version Code: {Colors.BOLD}{version_code}{Colors.ENDC}")
    print_success(f"Version Name: {Colors.BOLD}{version_name}{Colors.ENDC}")
    print_info(f"Min SDK: {min_sdk}")
    print_info(f"Target SDK: {target_sdk}")
    print_info(f"Max SDK: {max_sdk}")
    
    result['version'] = {
        'package_name': package_name,
        'version_code': version_code,
        'version_name': version_name,
        'min_sdk': min_sdk,
        'target_sdk': target_sdk,
        'max_sdk': max_sdk,
    }
    
    # === PERMISOS ===
    print_section("Permisos")
    permissions = a.get_permissions()
    interesting_perms = []
    for p in sorted(permissions):
        short_name = p.split('.')[-1]
        if any(kw in short_name.lower() for kw in ['internet', 'network', 'phone', 'wifi', 'boot', 'install', 'overlay', 'system']):
            print_warning(f"  {short_name} ← INTERESANTE")
            interesting_perms.append(p)
        else:
            print_info(f"  {short_name}")
    result['permissions'] = permissions
    result['interesting_permissions'] = interesting_perms
    
    # === ACTIVITIES, SERVICES, RECEIVERS ===
    print_section("Componentes (Activities, Services, Receivers)")
    activities = a.get_activities()
    services = a.get_services()
    receivers = a.get_receivers()
    
    print_info(f"Activities: {len(activities)}")
    for act in activities:
        if 'xuper' in act.lower() or 'main' in act.lower() or 'splash' in act.lower() or 'login' in act.lower():
            print_success(f"  {act} ← KEY ACTIVITY")
        elif 'player' in act.lower() or 'video' in act.lower() or 'stream' in act.lower():
            print_success(f"  {act} ← PLAYER")
    
    print_info(f"Services: {len(services)}")
    for svc in services:
        if any(kw in svc.lower() for kw in ['update', 'download', 'push', 'notify', 'player', 'media', 'stream']):
            print_warning(f"  {svc}")
    
    print_info(f"Receivers: {len(receivers)}")
    for rcv in receivers:
        if any(kw in rcv.lower() for kw in ['boot', 'update', 'install', 'network', 'connect']):
            print_warning(f"  {rcv}")
    
    result['activities'] = activities
    result['services'] = services
    result['receivers'] = receivers
    
    # === STRINGS ANALYSIS ===
    print_section("Análisis de Strings (Dominios, URLs, Endpoints)")
    
    all_strings = []
    try:
        # Extraer strings de todos los DEX files
        for dex in a.get_all_dex():
            try:
                d = DEX(dex)
                all_strings.extend(d.get_strings())
            except:
                pass
    except Exception as e:
        print_warning(f"Error extrayendo strings de DEX: {e}")
        # Fallback: extraer strings raw del APK
        import zipfile
        with zipfile.ZipFile(apk_path, 'r') as z:
            for name in z.namelist():
                if name.endswith('.dex'):
                    data = z.read(name)
                    # Extraer strings UTF-8 del DEX
                    found = re.findall(rb'[\x20-\x7e]{6,}', data)
                    all_strings.extend([s.decode('ascii', errors='ignore') for s in found])
    
    all_strings = list(set(all_strings))
    print_info(f"Total de strings únicas extraídas: {len(all_strings)}")
    
    # Dominios y URLs
    domains, urls = extract_domains_from_strings(all_strings)
    
    # Filtrar dominios relevantes (los de Xuper TV son obfuscados con patrón específico)
    xuper_domains = set()
    other_domains = set()
    
    for d in sorted(domains):
        # Dominios obfuscados de Xuper TV: 5-6 chars.5-6 chars.tld
        if re.match(r'^[a-z0-9]{4,8}\.[a-z0-9]{4,10}\.[a-z]{2,}$', d):
            xuper_domains.add(d)
        elif 'xuper' in d.lower() or 'magist' in d.lower() or '39114' in d:
            xuper_domains.add(d)
        elif not any(exclude in d for exclude in ['google', 'android', 'java.', 'javax.', 'kotlin', 'github', 'apache', 'mozilla', 'w3.org', 'xmlpull']):
            other_domains.add(d)
    
    print_info(f"Dominios de Xuper TV encontrados: {len(xuper_domains)}")
    for d in sorted(xuper_domains):
        print_success(f"  {d}")
    
    if other_domains:
        print_info(f"Otros dominios relevantes: {len(other_domains)}")
        for d in sorted(other_domains)[:30]:
            print_info(f"  {d}")
    
    result['xuper_domains'] = sorted(xuper_domains)
    result['other_domains'] = sorted(other_domains)
    result['urls'] = sorted(urls)
    
    # Endpoints API
    endpoints = extract_api_endpoints(all_strings)
    print_info(f"Endpoints API encontrados: {len(endpoints)}")
    for ep in sorted(endpoints):
        print_success(f"  {ep}")
    
    result['api_endpoints'] = sorted(endpoints)
    
    # Claves de encriptación
    enc_keys = extract_encryption_keys(all_strings)
    if enc_keys:
        print_section("Posibles Claves de Encriptación")
        for ctx, key in enc_keys:
            print_warning(f"  Contexto: {ctx}")
            print_success(f"  Clave: {key}")
    result['encryption_keys'] = [(ctx, key) for ctx, key in enc_keys]
    
    # Headers personalizados
    headers = extract_custom_headers(all_strings)
    if headers:
        print_section("Headers HTTP Personalizados")
        for k, v in sorted(headers.items()):
            print_success(f"  {k}: {v}")
    result['custom_headers'] = headers
    
    # Buscar strings con "版本" (versión en chino) - clave para el problema actual
    print_section("Strings Relacionadas con Versiones")
    version_strings = []
    for s in all_strings:
        if any(kw in s for kw in ['版本', 'version', 'Version', 'VERSION', 'verCode', 'verName', 'versionCode', 'versionName', '版本已停止使用', '升级', '更新']):
            version_strings.append(s)
            if '停止' in s or '升级' in s or '更新' in s:
                print_warning(f"  {s}")
            else:
                print_info(f"  {s}")
    result['version_strings'] = version_strings
    
    # Buscar SharedPreferences keys
    print_section("SharedPreferences Keys")
    sp_keys = []
    for s in all_strings:
        if any(kw in s for kw in ['SharedPreferences', 'SP_', 'sp_', 'pref_', 'PREF_', 'host_', 'hosturl', 'HOST']):
            sp_keys.append(s)
            print_info(f"  {s}")
    result['shared_prefs_keys'] = sp_keys
    
    # === RESUMEN ===
    print_header("RESUMEN - DATOS CLAVE")
    print(f"  {Colors.BOLD}Version Code:{Colors.ENDC} {version_code}")
    print(f"  {Colors.BOLD}Version Name:{Colors.ENDC} {version_name}")
    print(f"  {Colors.BOLD}Package:{Colors.ENDC} {package_name}")
    print(f"  {Colors.BOLD}Dominios Xuper TV:{Colors.ENDC} {len(xuper_domains)}")
    print(f"  {Colors.BOLD}Endpoints API:{Colors.ENDC} {len(endpoints)}")
    
    # Verificar si el versionCode es nuevo
    old_version_code = "60500"
    if str(version_code) != old_version_code:
        print(f"\n  {Colors.OKGREEN}{Colors.BOLD}★★★ NUEVO VERSION CODE DETECTADO ★★★{Colors.ENDC}")
        print(f"  {Colors.OKGREEN}Anterior: {old_version_code} → Nuevo: {version_code}{Colors.ENDC}")
        print(f"  {Colors.OKGREEN}¡Este versionCode debería permitir acceso a las APIs!{Colors.ENDC}")
    
    return result


def update_monitor_config(result, monitor_path):
    """Actualiza la configuración del monitor Next.js con los nuevos datos"""
    print_section(f"Actualizando Monitor en: {monitor_path}")
    
    domains_file = os.path.join(monitor_path, 'src', 'lib', 'domains.ts')
    
    if not os.path.exists(domains_file):
        print_error(f"No se encontró el archivo de dominios: {domains_file}")
        print_info("Asegúrate de que el path del monitor sea correcto")
        return False
    
    # Leer el archivo actual
    with open(domains_file, 'r') as f:
        content = f.read()
    
    # Actualizar versionCode en el archivo si existe
    version_code = result['version']['version_code']
    
    # Buscar y actualizar versionCode
    if 'VERSION_CODE' in content:
        old_vc_match = re.search(r"VERSION_CODE\s*=\s*['\"]?(\d+)['\"]?", content)
        if old_vc_match:
            old_vc = old_vc_match.group(1)
            content = content.replace(
                f"VERSION_CODE = '{old_vc}'",
                f"VERSION_CODE = '{version_code}'"
            )
            content = content.replace(
                f'VERSION_CODE = "{old_vc}"',
                f'VERSION_CODE = "{version_code}"'
            )
            print_success(f"Version Code actualizado: {old_vc} → {version_code}")
    
    # Agregar nuevos dominios si se encontraron
    new_domains = result.get('xuper_domains', [])
    if new_domains:
        print_info(f"Dominios Xuper TV encontrados en APK: {len(new_domains)}")
        for d in new_domains:
            if d not in content:
                print_warning(f"  Nuevo dominio no en monitor: {d}")
                print_info(f"  → Agregar manualmente o actualizar el archivo domains.ts")
    
    # Guardar archivo actualizado
    with open(domains_file, 'w') as f:
        f.write(content)
    
    print_success("Archivo domains.ts actualizado")
    
    # También actualizar/crear archivo de config de versión
    version_config = {
        'version_code': str(version_code),
        'version_name': result['version']['version_name'],
        'package_name': result['version']['package_name'],
        'last_updated': result['analysis_date'],
        'apk_hash': result['file_info']['sha256'],
    }
    
    version_file = os.path.join(monitor_path, 'src', 'lib', 'version-config.json')
    with open(version_file, 'w') as f:
        json.dump(version_config, f, indent=2)
    
    print_success(f"Config de versión guardada en: {version_file}")
    
    return True


def save_report(result, output_dir):
    """Guarda el reporte completo en JSON"""
    os.makedirs(output_dir, exist_ok=True)
    
    # Convertir tuplas a listas para JSON
    json_result = {}
    for k, v in result.items():
        if isinstance(v, list):
            json_result[k] = [list(item) if isinstance(item, tuple) else item for item in v]
        elif isinstance(v, dict):
            json_result[k] = v
        else:
            json_result[k] = v
    
    timestamp = datetime.now().strftime('%Y%m%d_%H%M%S')
    report_file = os.path.join(output_dir, f'xuper_analysis_{timestamp}.json')
    
    with open(report_file, 'w', encoding='utf-8') as f:
        json.dump(json_result, f, indent=2, ensure_ascii=False, default=str)
    
    print_success(f"Reporte guardado: {report_file}")
    
    # También generar un resumen markdown
    md_file = os.path.join(output_dir, f'xuper_analysis_{timestamp}.md')
    with open(md_file, 'w', encoding='utf-8') as f:
        f.write(f"# Xuper TV APK Analysis Report\n\n")
        f.write(f"**Fecha:** {result['analysis_date']}\n\n")
        f.write(f"## Información de Versión\n\n")
        f.write(f"| Campo | Valor |\n")
        f.write(f"|-------|-------|\n")
        f.write(f"| Package | `{result['version']['package_name']}` |\n")
        f.write(f"| Version Code | **`{result['version']['version_code']}`** |\n")
        f.write(f"| Version Name | `{result['version']['version_name']}` |\n")
        f.write(f"| Min SDK | {result['version']['min_sdk']} |\n")
        f.write(f"| Target SDK | {result['version']['target_sdk']} |\n")
        f.write(f"| APK SHA256 | `{result['file_info']['sha256']}` |\n\n")
        
        f.write(f"## Dominios Xuper TV ({len(result['xuper_domains'])})\n\n")
        for d in result['xuper_domains']:
            f.write(f"- `{d}`\n")
        
        f.write(f"\n## Endpoints API ({len(result['api_endpoints'])})\n\n")
        for ep in result['api_endpoints']:
            f.write(f"- `{ep}`\n")
        
        if result.get('version_strings'):
            f.write(f"\n## Strings de Versión\n\n")
            for s in result['version_strings'][:20]:
                f.write(f"- `{s}`\n")
    
    print_success(f"Reporte Markdown: {md_file}")
    
    return report_file, md_file


def main():
    parser = argparse.ArgumentParser(
        description='Xuper TV APK Analyzer - Extrae información de versión y configuración',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Ejemplos:
  %(prog)s xuper_base.apk
  %(prog)s xuper_base.apk --full --update-monitor
  %(prog)s xuper_base.apk --update-monitor --monitor-path /path/to/xuper-monitor
        """
    )
    parser.add_argument('apk', help='Ruta al archivo APK')
    parser.add_argument('--full', action='store_true', help='Análisis completo (más lento)')
    parser.add_argument('--update-monitor', action='store_true', help='Actualizar config del monitor Next.js')
    parser.add_argument('--monitor-path', default='./xuper-monitor', help='Ruta al proyecto monitor')
    parser.add_argument('--output', default='./xuper-analysis', help='Directorio de salida para reportes')
    
    args = parser.parse_args()
    
    # Ejecutar análisis
    result = extract_version_from_apk(args.apk)
    
    if result is None:
        print_error("Análisis fallido")
        sys.exit(1)
    
    # Guardar reportes
    print_section("Guardando Reportes")
    report_file, md_file = save_report(result, args.output)
    
    # Actualizar monitor si se solicitó
    if args.update_monitor:
        update_monitor_config(result, args.monitor_path)
    
    # Mostrar comandos para probar las APIs con el nuevo versionCode
    if result and result['version']['version_code']:
        vc = result['version']['version_code']
        print_header("COMANDOS PARA PROBAR APIs")
        print(f"  Usa el nuevo versionCode {Colors.BOLD}{vc}{Colors.ENDC} en las peticiones:\n")
        
        for domain in result.get('xuper_domains', [])[:3]:
            print(f"  curl -s https://{domain}/api/v2/dcs/getAddr \\")
            print(f"    -H 'versionCode: {vc}' \\")
            print(f"    -H 'platform: android' \\")
            print(f"    -H 'Content-Type: application/json' \\")
            print(f"    -d '{{\"appId\":\"1\"}}'\n")
    
    print_header("ANÁLISIS COMPLETADO")
    return result


if __name__ == '__main__':
    main()
