#!/system/bin/sh
# Extract strings from the APK and find API endpoints
APK=/data/app/com.msandroid.mobile-ySoNZuRN2qhnqck_C12UUQ==/base.apk

echo "=== Looking for API URLs ==="
strings $APK | grep -iE "https?://" | sort -u

echo ""
echo "=== Looking for API paths ==="
strings $APK | grep -iE "^/api/|^/v[0-9]/|^/mobile/" | sort -u

echo ""
echo "=== Looking for host patterns ==="
strings $APK | grep -iE "\.com|\.info|\.club|\.net|\.io" | grep -v "google\|android\|apache\|java\|github" | sort -u | head -50

echo ""
echo "=== Looking for DES/AES keys ==="
strings $APK | grep -iE "DES|AES|encrypt|decrypt|cipher" | head -20

echo ""
echo "=== Looking for API method names ==="
strings $APK | grep -iE "getColumn|getChannel|getVod|getLive|getProgram|login|register|auth" | sort -u | head -30
