#!/bin/bash
# ============================================================
# Xuper TV - Script de Actualización Automática
# ============================================================
# Este script automatiza el proceso de:
# 1. Descargar la última APK de Xuper TV
# 2. Extraer el versionCode y configuración
# 3. Actualizar el monitor Next.js
# 4. Probar las APIs con el nuevo versionCode
# 5. Opcionalmente, conectar con IA para mantenimiento
#
# Uso:
#   ./xuper-update.sh                    # Análisis interactivo
#   ./xuper-update.sh --apk file.apk     # Analizar APK específica
#   ./xuper-update.sh --auto             # Modo automático (descargar + analizar + actualizar)
#   ./xuper-update.sh --test-api         # Solo probar APIs con versionCode actual
#   ./xuper-update.sh --ai-maintain      # Generar prompt para IA maintenance
# ============================================================

set -e

# === CONFIGURACIÓN ===
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
MONITOR_PATH="${SCRIPT_DIR}/../xuper-monitor"
ANALYSIS_OUTPUT="${SCRIPT_DIR}/../xuper-analysis"
APK_DIR="${SCRIPT_DIR}/../apk-downloads"
APKPURE_BASE_URL="https://d.apkpure.net/b/XAPK/"

# Dominios conocidos de Xuper TV para pruebas
KNOWN_DOMAINS=(
    "c2tgd.izvhrdcjb.com"
    "dtgrd.txhnojlbu.com"
    "cftpbe.39114gi1.com"
    "skvbv.hbcpdutka.com"
    "jktgk.bxtzwlyan.com"
)

# Colores
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m'

print_banner() {
    echo -e "${CYAN}${BOLD}"
    echo "╔══════════════════════════════════════════════════════╗"
    echo "║     Xuper TV - Actualización Automática v1.0        ║"
    echo "║     Monitoreo y Extracción de VersionCode            ║"
    echo "╚══════════════════════════════════════════════════════╝"
    echo -e "${NC}"
}

print_step() {
    echo -e "\n${GREEN}${BOLD}[PASO $1]${NC} ${BOLD}$2${NC}"
}

print_info() {
    echo -e "  ${BLUE}[*]${NC} $1"
}

print_success() {
    echo -e "  ${GREEN}[+]${NC} $1"
}

print_warning() {
    echo -e "  ${YELLOW}[!]${NC} $1"
}

print_error() {
    echo -e "  ${RED}[-]${NC} $1"
}

# === FUNCIONES ===

check_dependencies() {
    print_step "0" "Verificando dependencias"
    
    local missing=()
    
    if ! command -v python3 &> /dev/null; then
        missing+=("python3")
    fi
    
    if ! python3 -c "from androguard.core.apk import APK" 2>/dev/null; then
        print_warning "androguard no instalado. Instalando..."
        pip3 install androguard
    fi
    
    if ! command -v curl &> /dev/null; then
        missing+=("curl")
    fi
    
    if ! command -v jq &> /dev/null; then
        print_warning "jq no instalado. Instalando..."
        sudo apt-get install -y jq 2>/dev/null || brew install jq 2>/dev/null || print_warning "No se pudo instalar jq"
    fi
    
    if [ ${#missing[@]} -gt 0 ]; then
        print_error "Dependencias faltantes: ${missing[*]}"
        exit 1
    fi
    
    print_success "Todas las dependencias OK"
}

download_apk() {
    print_step "1" "Descargando última APK de Xuper TV"
    
    mkdir -p "$APK_DIR"
    
    # Intentar descargar desde APKPure
    # Nota: La URL exacta puede cambiar. Actualizar según sea necesario.
    local apk_url="${APKPURE_BASE_URL}com.xuper.tv?version=latest"
    local apk_file="${APK_DIR}/xuper_tv_$(date +%Y%m%d_%H%M%S).apk"
    
    print_info "Intentando descargar desde APKPure..."
    print_info "URL: $apk_url"
    
    # Descargar con curl
    if curl -L -o "$apk_file" "$apk_url" 2>/dev/null; then
        local size=$(stat -f%z "$apk_file" 2>/dev/null || stat -c%s "$apk_file" 2>/dev/null || echo "0")
        if [ "$size" -gt 1000000 ]; then
            print_success "APK descargada: $apk_file (${size} bytes)"
            echo "$apk_file"
            return 0
        fi
    fi
    
    print_warning "Descarga automática fallida."
    echo ""
    echo -e "  ${YELLOW}Por favor, descarga la APK manualmente:${NC}"
    echo "  1. Ve a https://apkpure.com/xuper-tv/com.xuper.tv"
    echo "  2. Descarga la última versión (XAPK o APK)"
    echo "  3. Si es XAPK, renómbralo a .zip y extrae el .apk interior"
    echo "  4. Copia el archivo a: $APK_DIR/"
    echo ""
    echo -e "  ${CYAN}Luego ejecuta:${NC} $0 --apk $APK_DIR/xuper_base.apk"
    
    return 1
}

analyze_apk() {
    local apk_file="$1"
    
    print_step "2" "Analizando APK: $(basename "$apk_file")"
    
    if [ ! -f "$apk_file" ]; then
        print_error "APK no encontrada: $apk_file"
        return 1
    fi
    
    mkdir -p "$ANALYSIS_OUTPUT"
    
    # Ejecutar el analyzer Python
    python3 "${SCRIPT_DIR}/xuper-apk-analyzer.py" "$apk_file" \
        --output "$ANALYSIS_OUTPUT" \
        --update-monitor \
        --monitor-path "$MONITOR_PATH" 2>&1 | tee "${ANALYSIS_OUTPUT}/analysis_$(date +%Y%m%d_%H%M%S).log"
    
    # Extraer versionCode del último reporte JSON
    local latest_report=$(ls -t "${ANALYSIS_OUTPUT}"/xuper_analysis_*.json 2>/dev/null | head -1)
    if [ -n "$latest_report" ]; then
        local version_code=$(python3 -c "import json; d=json.load(open('$latest_report')); print(d['version']['version_code'])" 2>/dev/null)
        if [ -n "$version_code" ]; then
            print_success "Version Code extraído: ${BOLD}${version_code}${NC}"
            
            # Guardar el versionCode para uso posterior
            echo "$version_code" > "${ANALYSIS_OUTPUT}/.current_version_code"
            echo "$apk_file" > "${ANALYSIS_OUTPUT}/.current_apk_path"
            
            return 0
        fi
    fi
    
    print_warning "No se pudo extraer el versionCode automáticamente"
    return 1
}

test_apis() {
    local version_code="$1"
    
    if [ -z "$version_code" ]; then
        # Intentar leer del archivo cache
        if [ -f "${ANALYSIS_OUTPUT}/.current_version_code" ]; then
            version_code=$(cat "${ANALYSIS_OUTPUT}/.current_version_code")
        else
            version_code="60500"  # Default (probablemente obsoleto)
        fi
    fi
    
    print_step "3" "Probando APIs con versionCode: ${BOLD}${version_code}${NC}"
    
    local working=0
    local total=${#KNOWN_DOMAINS[@]}
    
    for domain in "${KNOWN_DOMAINS[@]}"; do
        echo -n "  Probando $domain ... "
        
        response=$(curl -s -m 10 \
            -H "versionCode: ${version_code}" \
            -H "platform: android" \
            -H "Content-Type: application/json" \
            -d '{"appId":"1"}' \
            "https://${domain}/api/v2/dcs/getAddr" 2>/dev/null)
        
        if [ -z "$response" ]; then
            echo -e "${RED}SIN RESPUESTA${NC}"
        elif echo "$response" | grep -q "版本已停止使用"; then
            echo -e "${YELLOW}VERSIÓN OBSOLETA${NC}"
        elif echo "$response" | grep -q "版本"; then
            echo -e "${YELLOW}ERROR DE VERSIÓN${NC}"
            echo "    Respuesta: $(echo "$response" | head -c 200)"
        else
            echo -e "${GREEN}OK!${NC}"
            echo "    Respuesta: $(echo "$response" | head -c 200)"
            working=$((working + 1))
        fi
    done
    
    echo ""
    if [ $working -gt 0 ]; then
        print_success "$working/$total servidores respondieron correctamente!"
    else
        print_warning "0/$total servidores respondieron. El versionCode puede estar obsoleto."
        print_info "Prueba con una APK más reciente."
    fi
}

generate_ai_prompt() {
    print_step "4" "Generando prompt para mantenimiento con IA"
    
    local latest_report=$(ls -t "${ANALYSIS_OUTPUT}"/xuper_analysis_*.json 2>/dev/null | head -1)
    local version_code="desconocido"
    local domains_list=""
    
    if [ -n "$latest_report" ]; then
        version_code=$(python3 -c "import json; d=json.load(open('$latest_report')); print(d['version']['version_code'])" 2>/dev/null || echo "desconocido")
        domains_list=$(python3 -c "import json; d=json.load(open('$latest_report')); print('\n'.join(d.get('xuper_domains', [])))" 2>/dev/null || echo "")
    fi
    
    cat > "${ANALYSIS_OUTPUT}/ai-maintenance-prompt.md" << EOF
# Xuper TV Monitor - Prompt de Mantenimiento con IA

## Contexto
Tengo un sistema de monitoreo de Xuper TV (app IPTV) que necesita actualizaciones periódicas
cuando la app cambia de versión o sus servidores se reconfiguran.

## Estado Actual
- Version Code: ${version_code}
- Fecha de último análisis: $(date -Iseconds)
- Dominios monitoreados: $(echo "$domains_list" | wc -l)

## Instrucciones para la IA
Cuando necesite actualizar el sistema, proporciona:

1. **Nueva APK**: La ruta al archivo APK recién descargado
2. **Este prompt**: Como contexto de lo que necesitas que haga

La IA debe:
1. Ejecutar el script xuper-apk-analyzer.py con la nueva APK
2. Comparar dominios nuevos vs los existentes en el monitor
3. Actualizar src/lib/domains.ts con nuevos dominios
4. Actualizar el versionCode en las peticiones API
5. Probar las APIs para verificar acceso
6. Generar un reporte de cambios

## Archivos Clave del Monitor
- \`${MONITOR_PATH}/src/lib/domains.ts\` - Configuración de dominios
- \`${MONITOR_PATH}/src/lib/version-config.json\` - Version code actual
- \`${SCRIPT_DIR}/xuper-apk-analyzer.py\` - Script de análisis
- \${SCRIPT_DIR}/xuper-update.sh\` - Este script

## Comando para análisis rápido
\`\`\`bash
python3 ${SCRIPT_DIR}/xuper-apk-analyzer.py NUEVA_APK.apk --update-monitor --monitor-path ${MONITOR_PATH}
\`\`\`
EOF
    
    print_success "Prompt generado: ${ANALYSIS_OUTPUT}/ai-maintenance-prompt.md"
    print_info "Copia este prompt cuando inicies una nueva sesión con la IA"
}

interactive_mode() {
    print_banner
    echo -e "  ${CYAN}Modo Interactivo${NC}"
    echo ""
    echo "  Opciones:"
    echo "  1) Analizar APK existente"
    echo "  2) Descargar y analizar última APK"
    echo "  3) Probar APIs con versionCode actual"
    echo "  4) Generar prompt para IA"
    echo "  5) Salir"
    echo ""
    read -p "  Selecciona una opción [1-5]: " choice
    
    case $choice in
        1)
            read -p "  Ruta al archivo APK: " apk_path
            if [ -f "$apk_path" ]; then
                check_dependencies
                analyze_apk "$apk_path"
                local vc=$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "")
                if [ -n "$vc" ]; then
                    test_apis "$vc"
                fi
            else
                print_error "Archivo no encontrado: $apk_path"
            fi
            ;;
        2)
            check_dependencies
            apk_file=$(download_apk)
            if [ -n "$apk_file" ] && [ -f "$apk_file" ]; then
                analyze_apk "$apk_file"
                local vc=$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "")
                if [ -n "$vc" ]; then
                    test_apis "$vc"
                fi
            fi
            ;;
        3)
            local vc=$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "60500")
            test_apis "$vc"
            ;;
        4)
            generate_ai_prompt
            ;;
        5)
            echo -e "\n  ${GREEN}¡Hasta la próxima!${NC}\n"
            exit 0
            ;;
        *)
            print_error "Opción inválida"
            ;;
    esac
}

# === MAIN ===

case "${1:-}" in
    --apk)
        check_dependencies
        analyze_apk "$2"
        vc=$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "")
        if [ -n "$vc" ]; then
            test_apis "$vc"
        fi
        ;;
    --auto)
        check_dependencies
        apk_file=$(download_apk)
        if [ -n "$apk_file" ] && [ -f "$apk_file" ]; then
            analyze_apk "$apk_file"
            vc=$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "")
            if [ -n "$vc" ]; then
                test_apis "$vc"
            fi
            generate_ai_prompt
        fi
        ;;
    --test-api)
        vc="${2:-$(cat "${ANALYSIS_OUTPUT}/.current_version_code" 2>/dev/null || echo "60500")}"
        test_apis "$vc"
        ;;
    --ai-maintain)
        generate_ai_prompt
        ;;
    *)
        interactive_mode
        ;;
esac
