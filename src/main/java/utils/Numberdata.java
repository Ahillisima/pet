package utils;

import java.time.Duration;

public class Numberdata {
    public static int messageWaitingTime() {
        return 200000;
    }

    public static Duration messageWaitTime() {
        return Duration.ofSeconds(200);
    }

    public static Duration waitingFor() {
        return Duration.ofSeconds(40);
    }

    public static Duration waitingFor80Sec() {
        return Duration.ofSeconds(80);
    }

    public static Duration waitingFor5Sec() {
        return Duration.ofSeconds(5);
    }

    public static Duration waitingFor3Sec() {
        return Duration.ofSeconds(3);
    }

    public static Duration waitingFor1Sec() {
        return Duration.ofSeconds(1);
    }

    public static Duration waitingFor500MillSec() {
        return Duration.ofMillis(500);
    }

    public static int getDefaultNumberOfMessages() {
        return 51;
    }

    public static int fiveSeconds() {
        return 5;
    }

    public static int threeSeconds() {
        return 3;
    }

    public static int tenSeconds() {
        return 10;
    }
}
