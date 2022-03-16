package fr.erwanx2z.vpncheck.impl;

import fr.erwanx2z.vpncheck.utils.HttpUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.json.JSONObject;

import java.util.Objects;

/**
 * This file is a part of Vpn-Checker, an Open-Source library 
 */

@AllArgsConstructor
@Getter
public class Check {

    private final String ipAddress;

    public boolean isProxy(){
        JSONObject jsonObject = new JSONObject(Objects.requireNonNull(HttpUtils.sendRequest("https://api.xdefcon.com/proxy/check/?ip=" + this.ipAddress)));
        return jsonObject.getBoolean("proxy");
    }

}
