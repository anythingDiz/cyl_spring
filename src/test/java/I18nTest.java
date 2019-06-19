import org.junit.Test;

import javax.print.attribute.standard.NumberUp;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class I18nTest {
    /**
     * 一些语言和地区的标准代码
     * zh:中文
     * en:英文
     * fr:法语
     * de:德语
     * ja:日语
     * ko:韩语
     *
     *
     * CN:中国大陆
     * TW:中国台湾
     * HK:中国香港
     * EN: 英国
     * US:美国
     * CA:加拿大
     *
     */


    /**
     * java.util中提供了几个支持本地的格式化操作工具类, NumberFormat,DateFormat,MessageFormat
     */
    @Test
    public void testJdkI18n(){
        Locale cn = Locale.CHINA;;
        Locale us = Locale.US;

        double amt = 123456.78;

        NumberFormat format = NumberFormat.getCurrencyInstance(cn);
        NumberFormat format1 = NumberFormat.getCurrencyInstance(us);

        System.out.println(format.format(amt));
        System.out.println(format1.format(amt));


        //格式化信息单
        String pattern1 = "{0}, 你好! 你于{1}在工商银行存入{2}元";
        String pattern2 = "At {1,time,short} On {1,date,long}, {0} paid {2, number, currency}.";

        //用于动态替换占位符的参数
        Object[] params = {"Jhon", new GregorianCalendar().getTime(), 1.0E3};

        //默认使用本地化对象格式化信息
        String msg1 = MessageFormat.format(pattern1,params);
        System.out.println(msg1);

        //使用指定的本地化对象格式化信息
        MessageFormat format2 = new MessageFormat(pattern2,us);
        String format3 = format2.format(params);
        System.out.println(format3);
    }
}
