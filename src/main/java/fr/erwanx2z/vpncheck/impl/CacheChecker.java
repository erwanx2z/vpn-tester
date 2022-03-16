package fr.erwanx2z.vpncheck.impl;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * This file is a part of Vpn-Checker, an Open-Source library 
 */

@Getter
public class CacheChecker {

    private final Map<String, Check> stringCheckMap = new HashMap<>();

}
