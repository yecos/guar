#!/bin/bash
# ============================================================
# Xuper TV API Monitor & VersionCode Tester
# Tests API endpoints and reports when servers come back online
# ============================================================

VERSION_CODE="${1:-60504}"
CDN_IP="223.109.148.179"
DOMAINS=("kexun" "lvjian" "zhipu" "xingse" "baoxian" "zhubao" "jiaoyu" "meishi" "chuanmei" "youxuan" "lvxing" "dianying" "yumao")
ENDPOINTS=("/api/portalCore/v8/login" "/api/portalCore/v6/login" "/api/portalCore/pwdCheck")
INTERVAL=60
LOG_FILE="/home/z/my-project/download/xuper-tools/api-monitor.log"

echo "============================================" | tee -a "$LOG_FILE"
echo "Xuper TV API Monitor Started" | tee -a "$LOG_FILE"
echo "VersionCode: $VERSION_CODE" | tee -a "$LOG_FILE"
echo "Date: $(date -u)" | tee -a "$LOG_FILE"
echo "============================================" | tee -a "$LOG_FILE"

test_api() {
    local domain=$1
    local endpoint=$2
    local result
    
    result=$(curl -s -m 10 --resolve "${domain}.puata.info:443:${CDN_IP}" \
        -X POST "https://${domain}.puata.info${endpoint}" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -H "versionCode: ${VERSION_CODE}" \
        -H "User-Agent: Dalvik/2.1.0 (Linux; U; Android 14)" \
        -d "username=test&password=test" \
        -o /tmp/api_response.txt -w "%{http_code}" --compressed 2>/dev/null)
    
    local http_code=$result
    local body=""
    if [ -f /tmp/api_response.txt ]; then
        body=$(cat /tmp/api_response.txt 2>/dev/null | head -c 500)
    fi
    
    echo "$http_code|$body"
}

attempt=1
while true; do
    echo "" | tee -a "$LOG_FILE"
    echo "--- Attempt $attempt @ $(date -u) ---" | tee -a "$LOG_FILE"
    
    found_working=false
    found_version_error=false
    
    # Test primary domain with v8/login
    for domain in "${DOMAINS[@]}"; do
        result=$(test_api "$domain" "/api/portalCore/v8/login")
        http_code=$(echo "$result" | cut -d'|' -f1)
        body=$(echo "$result" | cut -d'|' -f2-)
        
        if [ "$http_code" = "200" ]; then
            echo "✅ SUCCESS! ${domain}.puata.info → HTTP 200" | tee -a "$LOG_FILE"
            echo "   Response: $body" | tee -a "$LOG_FILE"
            found_working=true
        elif [ "$http_code" = "500" ]; then
            echo "❌ ${domain}.puata.info → HTTP 500 (origin down)" | tee -a "$LOG_FILE"
        elif [ "$http_code" = "000" ]; then
            echo "⏱️ ${domain}.puata.info → timeout" | tee -a "$LOG_FILE"
        else
            echo "🔄 ${domain}.puata.info → HTTP $http_code" | tee -a "$LOG_FILE"
            if echo "$body" | grep -q "版本已停止使用"; then
                echo "   ⚠️ VERSION REJECTED! Need newer versionCode" | tee -a "$LOG_FILE"
                found_version_error=true
            elif [ -n "$body" ]; then
                echo "   Response: $body" | tee -a "$LOG_FILE"
                found_working=true
            fi
        fi
    done
    
    if $found_working; then
        echo "" | tee -a "$LOG_FILE"
        echo "🎉 SERVER IS UP! APIs are responding!" | tee -a "$LOG_FILE"
        echo "   VersionCode $VERSION_CODE appears to be working." | tee -a "$LOG_FILE"
        break
    fi
    
    if $found_version_error; then
        echo "" | tee -a "$LOG_FILE"  
        echo "⚠️ SERVER IS UP but versionCode $VERSION_CODE is rejected!" | tee -a "$LOG_FILE"
        echo "   Need to extract a newer versionCode from a newer APK." | tee -a "$LOG_FILE"
        break
    fi
    
    echo "   All servers down. Waiting ${INTERVAL}s before retry..." | tee -a "$LOG_FILE"
    sleep $INTERVAL
    attempt=$((attempt + 1))
done

echo "" | tee -a "$LOG_FILE"
echo "Monitor finished at $(date -u)" | tee -a "$LOG_FILE"
