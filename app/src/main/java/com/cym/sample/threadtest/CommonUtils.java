package com.cym.sample.threadtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by caoj on 2024/2/4.
 */
public class CommonUtils {

    public static void log(Object msg) {
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        String time = y + "-" + m + "-" + d + " " + h + ":" + minute + ":" + s + "." + ms;
        System.out.println(time  + " ==> " + msg);
    }
    public static void readBooks(int times) {
        readBooks(times, "-");
    }
    public static void readBooks(int times, String content) {
        if (times > 200) {
            times = 200;
        }
        if (times < 1) {
            times = 1;
        }
        for (int i = 0; i < times; i++) {
            readABook(content);
        }
    }
    private static void readABook(String content) {
        String path = "H:\\git\\ABaseSample\\app\\src\\main\\java\\com\\cym\\sample\\threadtest\\ThreadJoinTest.kt";
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.print(content);
            }
            bufferedReader.close();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
