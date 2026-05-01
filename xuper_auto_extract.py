#!/usr/bin/env python3
"""
Xuper TV API Access Automation Script
======================================
Extrae informacion de un APK nuevo de Xuper TV y prueba endpoints automaticamente.

Uso:
    python3 xuper_auto_extract.py --apk /path/to/xuper.apk
    python3 xuper_auto_extract.py --apk xuper.apk --test-endpoints
    python3 xuper_auto_extract.py --apk xuper.apk --output report.json

Requisitos:
    - apktool (para descompilar)
    - aapt (para extraer metadata)
    - strings (binutils)
    - Python 3.8+
    - requests (pip install requests)
"""

import argparse
import json
import os
import re
import subprocess
import sys
import tempfile
import time
from pathlib import Path
from datetime import datetime

# ============================================================
# CONFIGURATION
# ============================================================

KNOWN_DOMAINS = [
    {"domain": "dtgrd.txhnojlbu.com", "service": "portal", "role": "primary"},
    {"domain": "c2tgd.izvhrdcjb.com", "service": "portal", "role": "backup"},
    {"domain": "cdtgcr.bcjoapser.com", "service": "epg", "role": "primary"},
    {"domain": "bktjr.akvndhzgx.com", "service": "epg", "role": "backup"},
    {"domain": "g4tc2.irlapchbd.com", "service": "notice", "role": "primary"},
    {"domain": "ckfdr.nzxgfvrud.com", "service": "notice", "role": "backup"},
    {"domain": "c2tgd3.ewzpuscyv.com", "service": "bigbee", "role": "primary"},
    {"domain": "skvbv.hbcpdutka.com", "service": "bigbee", "role": "backup"},
    {"domain": "skc2r.plracsimf.com", "service": "ads", "role": "primary"},
    {"domain": "jktgk.bxtzwlyan.com", "service": "ads", "role": "backup"},
    {"domain": "bg4gr.msfxethyc.com", "service": "h5", "role": "primary"},
    {"domain": "jktgr.ludgwoxhe.com", "service": "upgrade", "role": "primary"},
    {"domain": "vtgrc.ncimxztfk.com", "service": "upgrade", "role": "backup"},
    {"domain": "cftpbe.39114gi1.com", "service": "cdn", "role": "primary"},
    {"domain": "www.magistvec.com", "service": "download", "role": "primary"},
]

TEST_ENDPOINTS = [
    {"path": "/api/portalCore/getHome", "method": "POST", "body": '{"appId":"3"}'},
    {"path": "/api/portalCore/config/get", "method": "POST", "body": '{"appId":"3"}'},
    {"path": "/api/v2/dcs/getAddr", "method": "POST", "body": '{"appId":"3"}'},
    {"path": "/api/portalCore/v3/snToken", "method": "POST", "body": '{"appId":"3","sn":"888345958"}'},
]

# ============================================================
# EXTRACTION FUNCTIONS
# ============================================================

def extract_version(apk_path):
    """Extract versionCode and versionName from APK using aapt."""
    result = {"versionCode": None, "versionName": None, "packageName": None}
    
    try:
        output = subprocess.check_output(
            ["aapt", "dump", "badging", apk_path],
            stderr=subprocess.STDOUT, text=True, timeout=30
        )
        for line in output.split("\n"):
            if "package:" in line:
                # package: name='com.msandroid.mobile' versionCode='60500' versionName='6.5.0'
                m = re.search(r"name='([^']+)'", line)
                if m: result["packageName"] = m.group(1)
                m = re.search(r"versionCode='([^']+)'", line)
                if m: result["versionCode"] = m.group(1)
                m = re.search(r"versionName='([^']+)'", line)
                if m: result["versionName"] = m.group(1)
    except (subprocess.CalledProcessError, FileNotFoundError) as e:
        result["error"] = str(e)
    
    return result


def decompile_apk(apk_path, output_dir):
    """Decompile APK using apktool."""
    try:
        subprocess.check_output(
            ["apktool", "d", apk_path, "-o", output_dir, "-f"],
            stderr=subprocess.STDOUT, text=True, timeout=120
        )
        return True
    except (subprocess.CalledProcessError, FileNotFoundError) as e:
        print(f"  [!] apktool failed: {e}")
        return False


def extract_http_headers(decompiled_dir):
    """Search for OkHttp interceptors and custom headers in decompiled code."""
    headers = {}
    
    # Search in smali files
    for root, dirs, files in os.walk(decompiled_dir):
        for f in files:
            if f.endswith((".smali", ".java", ".xml")):
                filepath = os.path.join(root, f)
                try:
                    with open(filepath, 'r', errors='ignore') as fh:
                        content = fh.read()
                        # Look for addHeader calls
                        for match in re.finditer(r'addHeader\(["\']([^"\']+)["\']\s*,\s*["\']([^"\']+)["\']\)', content):
                            key, value = match.group(1), match.group(2)
                            if key not in headers:
                                headers[key] = []
                            headers[key].append({"value": value, "file": filepath.replace(decompiled_dir, "")})
                        
                        # Look for header constants
                        for match in re.finditer(r'["\'](apk|apkVer|sn|userId|token|deviceModel|platform)["\']\s*[=:]\s*["\']([^"\']+)["\']', content, re.IGNORECASE):
                            key, value = match.group(1), match.group(2)
                            if key not in headers:
                                headers[key] = []
                            headers[key].append({"value": value, "file": filepath.replace(decompiled_dir, "")})
                except:
                    pass
    
    return headers


def extract_encryption_keys(decompiled_dir):
    """Search for 3DES, AES, or other encryption keys."""
    crypto_info = {"algorithms": [], "keys": []}
    
    patterns = [
        (r'DESede|3DES|TripleDES|Blowfish|AES', "algorithm"),
        (r'ECB|CBC|CFB|OFB|CTR', "mode"),
        (r'PKCS5|PKCS7|NoPadding', "padding"),
    ]
    
    for root, dirs, files in os.walk(decompiled_dir):
        for f in files:
            if f.endswith((".smali", ".java")):
                filepath = os.path.join(root, f)
                try:
                    with open(filepath, 'r', errors='ignore') as fh:
                        content = fh.read()
                        for pattern, info_type in patterns:
                            for match in re.finditer(pattern, content):
                                crypto_info["algorithms"].append({
                                    "type": info_type,
                                    "value": match.group(0),
                                    "file": filepath.replace(decompiled_dir, "")
                                })
                        # Look for hardcoded keys (16/24 byte hex strings for 3DES)
                        for match in re.finditer(r'"([0-9a-fA-F]{16,32})"', content):
                            key = match.group(1)
                            if len(key) in (16, 24, 32, 48):
                                crypto_info["keys"].append({
                                    "key": key,
                                    "length": len(key),
                                    "file": filepath.replace(decompiled_dir, "")
                                })
                except:
                    pass
    
    return crypto_info


def extract_domains_from_strings(apk_path):
    """Extract potential domain strings from APK binary."""
    domains = []
    
    try:
        output = subprocess.check_output(
            ["strings", apk_path],
            stderr=subprocess.STDOUT, text=True, timeout=60
        )
        for line in output.split("\n"):
            line = line.strip()
            # Match domain patterns
            if re.match(r'^[a-z0-9]{4,10}\.[a-z0-9]{6,15}\.[a-z]{2,4}$', line):
                domains.append({"domain": line, "source": "strings", "type": "obfuscated"})
            elif re.match(r'^[a-z0-9][a-z0-9-]*\.[a-z]{2,10}\.(com|net|org|io|club|me)$', line):
                domains.append({"domain": line, "source": "strings", "type": "standard"})
    except FileNotFoundError:
        pass
    
    return domains


def extract_shared_prefs_config(decompiled_dir):
    """Extract SharedPreferences XML files for domain configuration."""
    configs = []
    
    shared_prefs_dir = os.path.join(decompiled_dir, "shared_prefs")
    if not os.path.exists(shared_prefs_dir):
        # Try in res/xml or assets
        for search_dir in ["res/xml", "assets"]:
            sd = os.path.join(decompiled_dir, search_dir)
            if os.path.exists(sd):
                for f in os.listdir(sd):
                    if f.endswith((".xml", ".json")):
                        filepath = os.path.join(sd, f)
                        try:
                            with open(filepath, 'r', errors='ignore') as fh:
                                configs.append({
                                    "file": f,
                                    "content": fh.read()[:5000]
                                })
                        except:
                            pass
        return configs
    
    for f in os.listdir(shared_prefs_dir):
        if f.endswith(".xml"):
            filepath = os.path.join(shared_prefs_dir, f)
            try:
                with open(filepath, 'r', errors='ignore') as fh:
                    configs.append({"file": f, "content": fh.read()[:5000]})
            except:
                pass
    
    return configs


# ============================================================
# ENDPOINT TESTING
# ============================================================

def test_endpoints(version_info, headers, domains=None):
    """Test API endpoints with extracted version and headers."""
    results = []
    
    try:
        import requests
    except ImportError:
        print("  [!] 'requests' not installed. Install with: pip install requests")
        return results
    
    test_domains = domains or [d["domain"] for d in KNOWN_DOMAINS[:3]]  # Test first 3 domains
    
    # Build headers dict
    req_headers = {
        "Content-Type": "application/json;charset=utf-8",
    }
    
    # Add extracted headers
    if version_info.get("packageName"):
        req_headers["apk"] = version_info["packageName"]
    if version_info.get("versionCode"):
        req_headers["apkVer"] = version_info["versionCode"]
    
    # Add any custom headers found
    for key, entries in headers.items():
        if key.lower() in ("apk", "apkver", "sn", "userid", "token", "platform", "devicemodel"):
            req_headers[key] = entries[0]["value"]
    
    # Also try with different version codes
    version_codes_to_try = [version_info.get("versionCode", "60500")]
    vc = version_info.get("versionCode")
    if vc:
        version_codes_to_try.extend([
            str(int(vc) + 100), str(int(vc) + 1000),
            vc[:1] + "0" + vc[1:],  # Try different format
        ])
    
    for domain in test_domains:
        for endpoint in TEST_ENDPOINTS:
            for vcode in set(version_codes_to_try):
                test_headers = dict(req_headers)
                test_headers["apkVer"] = vcode
                
                url = f"http://{domain}{endpoint['path']}"
                try:
                    resp = requests.post(
                        url, data=endpoint["body"],
                        headers=test_headers, timeout=10
                    )
                    result = {
                        "url": url,
                        "apkVer": vcode,
                        "status": resp.status_code,
                        "response": resp.text[:500],
                        "success": False
                    }
                    
                    # Check if we got past version check
                    try:
                        data = resp.json()
                        if data.get("returnCode") != "portal200001":
                            result["success"] = True
                            result["data"] = data
                    except:
                        if resp.status_code == 200 and len(resp.text) > 100:
                            result["success"] = True
                    
                    results.append(result)
                    
                    # If successful, no need to try more version codes
                    if result["success"]:
                        break
                        
                except Exception as e:
                    results.append({
                        "url": url,
                        "apkVer": vcode,
                        "error": str(e),
                        "success": False
                    })
    
    return results


# ============================================================
# MAIN
# ============================================================

def main():
    parser = argparse.ArgumentParser(description="Xuper TV API Access Automation")
    parser.add_argument("--apk", required=True, help="Path to Xuper TV APK file")
    parser.add_argument("--test-endpoints", action="store_true", help="Test endpoints with extracted data")
    parser.add_argument("--output", "-o", default=None, help="Output JSON file path")
    args = parser.parse_args()
    
    apk_path = os.path.abspath(args.apk)
    if not os.path.exists(apk_path):
        print(f"[!] APK not found: {apk_path}")
        sys.exit(1)
    
    print("=" * 60)
    print("  Xuper TV API Access Automation")
    print("=" * 60)
    print(f"\n[*] APK: {apk_path}")
    print(f"[*] Size: {os.path.getsize(apk_path) / 1024 / 1024:.1f} MB")
    
    report = {
        "timestamp": datetime.now().isoformat(),
        "apk_path": apk_path,
        "apk_size_mb": round(os.path.getsize(apk_path) / 1024 / 1024, 1),
    }
    
    # Step 1: Extract version info
    print("\n[1/6] Extracting version info...")
    version_info = extract_version(apk_path)
    report["version"] = version_info
    print(f"  Package: {version_info.get('packageName', 'N/A')}")
    print(f"  Version: {version_info.get('versionName', 'N/A')} ({version_info.get('versionCode', 'N/A')})")
    
    # Step 2: Decompile
    print("\n[2/6] Decompiling APK...")
    decompiled_dir = tempfile.mkdtemp(prefix="xuper_dec_")
    if decompile_apk(apk_path, decompiled_dir):
        print(f"  Decompiled to: {decompiled_dir}")
        report["decompiled"] = True
    else:
        print("  [!] Decompilation failed, trying strings-only extraction")
        report["decompiled"] = False
    
    # Step 3: Extract HTTP headers
    print("\n[3/6] Searching for HTTP headers...")
    headers = extract_http_headers(decompiled_dir) if os.path.exists(decompiled_dir) else {}
    report["http_headers"] = headers
    print(f"  Found {len(headers)} header keys")
    for k, v in headers.items():
        print(f"    {k}: {v[0]['value']} (in {v[0]['file'][:50]})")
    
    # Step 4: Extract encryption info
    print("\n[4/6] Searching for encryption keys...")
    crypto = extract_encryption_keys(decompiled_dir) if os.path.exists(decompiled_dir) else {"algorithms": [], "keys": []}
    report["crypto"] = crypto
    print(f"  Algorithms: {len(crypto['algorithms'])} found")
    print(f"  Keys: {len(crypto['keys'])} found")
    
    # Step 5: Extract domains
    print("\n[5/6] Extracting domains from strings...")
    domains = extract_domains_from_strings(apk_path)
    report["extracted_domains"] = domains
    print(f"  Found {len(domains)} potential domains")
    
    # Step 6: Test endpoints (optional)
    if args.test_endpoints:
        print("\n[6/6] Testing endpoints...")
        endpoint_results = test_endpoints(version_info, headers)
        report["endpoint_tests"] = endpoint_results
        
        successful = [r for r in endpoint_results if r.get("success")]
        print(f"  Tested {len(endpoint_results)} combinations")
        print(f"  Successful: {len(successful)}")
        
        if successful:
            print("\n  *** ACCESS GRANTED! ***")
            for r in successful:
                print(f"    {r['url']} (apkVer={r['apkVer']}) -> {r.get('response', '')[:100]}")
        else:
            print("  [!] No successful connections. Need to try alternative strategies.")
    else:
        print("\n[6/6] Skipping endpoint tests (use --test-endpoints to enable)")
    
    # Add known domains for reference
    report["known_domains"] = KNOWN_DOMAINS
    
    # Save report
    output_path = args.output or f"xuper_extract_report_{datetime.now().strftime('%Y%m%d_%H%M%S')}.json"
    with open(output_path, 'w') as f:
        json.dump(report, f, indent=2, ensure_ascii=False)
    
    print(f"\n{'=' * 60}")
    print(f"  Report saved: {output_path}")
    print(f"{'=' * 60}")
    
    # Cleanup
    import shutil
    if os.path.exists(decompiled_dir):
        shutil.rmtree(decompiled_dir, ignore_errors=True)
    
    return 0 if report.get("endpoint_tests") and any(r.get("success") for r in report["endpoint_tests"]) else 1


if __name__ == "__main__":
    sys.exit(main())
