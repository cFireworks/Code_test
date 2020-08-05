package com.company.ctrib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 手写枚举
 * @author: cfireworks
 * @create: 2020-06-15 11:50
 **/
public class DataCount {
    public static  final Integer ZORE = 0;

    public enum Month{
        Jan(1, 31),
        Feb(2, 28),
        Mar(3, 31),
        Apr(4, 30),
        May(5, 31),
        Jun(6,30),
        Jul(7,31),
        Aug(8,31),
        Sep(9,30),
        Oct(10, 31),
        Nov(11,30),
        Dec(12,31);

        private int id;
        private int dayCount;
        private Month(int mthId, int mthDay){
            this.id = mthId;
            this.dayCount = mthDay;
        }
        public int getId(){return id;}
        public int getDayCount(){return dayCount;}
    }
    public static void main(String[] args){
        // 日期字符串
        String dateStr1 = "2018-12-27";
        String dateStr2 = "2018-12-31";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(dateStr1);
            date2 = simpleDateFormat.parse(dateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(date2);
        long timeInMillis2 = calendar.getTimeInMillis();

        long betweenDays =  (timeInMillis2 - timeInMillis1) / (1000L*3600L*24L);
        System.out.println(betweenDays);
    }

}
