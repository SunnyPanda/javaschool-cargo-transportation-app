package com.katekozlova.cargo;

import org.joda.time.DateTime;
import org.joda.time.Hours;

public class Temp {
    public static void main(final String[] args) {
        final DateTime now = new DateTime();
        System.out.println("now = " + now);
        final DateTime endOfMonth = now.dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue();
        System.out.println("endOfMonth = " + endOfMonth);
        final long hoursBetween = Hours.hoursBetween(now, endOfMonth).getHours();
        System.out.println("hoursBetween = " + hoursBetween);
    }
}
