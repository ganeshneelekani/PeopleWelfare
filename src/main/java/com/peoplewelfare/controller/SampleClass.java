package com.peoplewelfare.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SampleClass {

    public static void main(String[] args) {


        String s1 = "desk";
        String s2 = "345";
        try {
            // Construct data
            String apiKey = "apikey=" + "P230OmN1eEs-im2zdQORmXW9EMEUzxi8EJssURS7Rx";
            String message = "&message=" + "Hi this is your " + s1 + " and otp is " + s2;
            String sender = "&sender=" + "PWADMN";
            String numbers = "&numbers=" + "917829108302";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();


        } catch (Exception e) {
            System.out.println("Error SMS " + e);

        }
    }
}