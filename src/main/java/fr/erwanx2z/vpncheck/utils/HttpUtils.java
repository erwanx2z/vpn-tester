package fr.erwanx2z.vpncheck.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * This file is a part of Vpn-Checker, an Open-Source library 
 */
public class HttpUtils {

    public static String sendRequest(String link) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(link).openConnection();
            connection.setDoOutput(false);
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            connection.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            connection.addRequestProperty("Pragma", "no-cache");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String f = br.readLine();
            while(f != null) {
                result.append(f).append("\n");
                f = br.readLine();
            }
            br.close();

            connection.disconnect();
            return result.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
