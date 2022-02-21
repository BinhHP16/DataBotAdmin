package com.saltlux.botadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BotAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotAdminApplication.class, args);
        System.out.println(new java.util.Date());
        System.out.println("Hello World");
        String dateStart = "11/03/14 09:29:58";
        String dateStop = "08:50:00";

        System.out.println(new java.util.Date());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date=new java.util.Date();
       String x= "08:00:00";

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(x);
            d2 = format.parse(dateStop);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Get msec from each, and subtract.
        long diff = d2.getTime() - d1.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time in hours: " + diffHours + " hours.");

    }

}
