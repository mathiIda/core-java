package com.niumengliang.corejava.four;

import java.time.LocalDate;
import java.util.Date;

/**
 * Date：JDK 1.0 就存在的时间类，用于表示 Unix 时间戳，也可以表示日期，但因为只支持公历（底层的 gcal = GregorianCalendar），
 *     而且开发人员希望时间和日期解耦，就有了 LocalDate，所以不建议使用 Date 中已经 Deprecated 的日期相关功能
 * LocalDate：JDK 1.8 出现的日历类，用于表示日历，针对不同的历法，某个 Unix 时间戳在不同的历法下有不同的日期表示
 *
 * @author niumengliang
 * @version 1.0
 * @since 2022/6/1
 */
public class DateAndLocalDate {

    private void testDate() {

        // 无参构造函数初始化 Date，底层的 Unix 时间戳为当前时间戳
        Date date = new Date();

        // 获取底层存储的 Unix 时间戳，单位 ms
        Long currentTimestamp = date.getTime();
        System.out.println(currentTimestamp);

        // 设置底层存储的 Unix 时间戳，单位 ms
        date.setTime(currentTimestamp - 3600000);
        System.out.println(date.getTime());

        /*
         判断两个 Unix 时间戳的前后：
         date.after(anotherDate);
         date.before();
         date.compareTo();
        */

        /*
         Date 对 toString() 的重写：dow mon dd hh:mm:ss zzz yyyy
         其中的 zzz 是系统当前所在的时区，toString() 会自动将 Unix 时间戳转换为 zzz 时区的日期时间字符串
        */
        System.out.println(date); // Wed Jun 01 23:26:20 CST 2022
    }

    private void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
    }

    public static void main(String[] args) {
        DateAndLocalDate dateAndLocalDate = new DateAndLocalDate();
        dateAndLocalDate.testDate();
        dateAndLocalDate.testLocalDate();
    }

}
