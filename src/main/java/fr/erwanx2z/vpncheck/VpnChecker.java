package fr.erwanx2z.vpncheck;

import fr.erwanx2z.vpncheck.impl.CacheChecker;
import fr.erwanx2z.vpncheck.impl.Check;
import lombok.Getter;

/**
 * This file is a part of Vpn-Checker, an Open-Source library 
 */

@Getter
public class VpnChecker {

    private final static VpnChecker vpnChecker = new VpnChecker();
    public static VpnChecker getInstance() {
        return vpnChecker;
    }

    private final CacheChecker cacheChecker = new CacheChecker();

    public Check checkIp(String ipAddress){
        getCacheChecker().getStringCheckMap().putIfAbsent(ipAddress, new Check(ipAddress));
        return getCacheChecker().getStringCheckMap().get(ipAddress);
    }

}
