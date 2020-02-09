package org.aoju.bus.core.date;

import org.aoju.bus.core.lang.Fields;
import org.aoju.bus.core.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateModifierTest {

    @Test
    public void truncateTest() {
        String dateStr = "2017-03-01 22:33:23.123";
        Date date = DateUtils.parse(dateStr);

        // 毫秒
        DateTime begin = DateUtils.truncate(date, Fields.DateField.MILLISECOND);
        Assertions.assertEquals(dateStr, begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 秒
        begin = DateUtils.truncate(date, Fields.DateField.SECOND);
        Assertions.assertEquals("2017-03-01 22:33:23.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 分
        begin = DateUtils.truncate(date, Fields.DateField.MINUTE);
        Assertions.assertEquals("2017-03-01 22:33:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 小时
        begin = DateUtils.truncate(date, Fields.DateField.HOUR);
        Assertions.assertEquals("2017-03-01 22:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.truncate(date, Fields.DateField.HOUR_OF_DAY);
        Assertions.assertEquals("2017-03-01 22:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 上下午，原始日期是22点，上下午的起始就是12点
        begin = DateUtils.truncate(date, Fields.DateField.AM_PM);
        Assertions.assertEquals("2017-03-01 12:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 天，day of xxx按照day处理
        begin = DateUtils.truncate(date, Fields.DateField.DAY_OF_WEEK_IN_MONTH);
        Assertions.assertEquals("2017-03-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.truncate(date, Fields.DateField.DAY_OF_WEEK);
        Assertions.assertEquals("2017-03-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.truncate(date, Fields.DateField.DAY_OF_MONTH);
        Assertions.assertEquals("2017-03-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 星期
        begin = DateUtils.truncate(date, Fields.DateField.WEEK_OF_MONTH);
        Assertions.assertEquals("2017-02-27 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.truncate(date, Fields.DateField.WEEK_OF_YEAR);
        Assertions.assertEquals("2017-02-27 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 月
        begin = DateUtils.truncate(date, Fields.DateField.MONTH);
        Assertions.assertEquals("2017-03-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 年
        begin = DateUtils.truncate(date, Fields.DateField.YEAR);
        Assertions.assertEquals("2017-01-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
    }

    @Test
    public void truncateDayOfWeekInMonthTest() {
        String dateStr = "2017-03-01 22:33:23.123";
        Date date = DateUtils.parse(dateStr);

        // 天，day of xxx按照day处理
        DateTime begin = DateUtils.truncate(date, Fields.DateField.DAY_OF_WEEK_IN_MONTH);
        Assertions.assertEquals("2017-03-01 00:00:00.000", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
    }

    @Test
    public void ceilingTest() {
        String dateStr = "2017-03-01 22:33:23.123";
        Date date = DateUtils.parse(dateStr);

        // 毫秒
        DateTime begin = DateUtils.ceiling(date, Fields.DateField.MILLISECOND);
        Assertions.assertEquals(dateStr, begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 秒
        begin = DateUtils.ceiling(date, Fields.DateField.SECOND);
        Assertions.assertEquals("2017-03-01 22:33:23.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 分
        begin = DateUtils.ceiling(date, Fields.DateField.MINUTE);
        Assertions.assertEquals("2017-03-01 22:33:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 小时
        begin = DateUtils.ceiling(date, Fields.DateField.HOUR);
        Assertions.assertEquals("2017-03-01 22:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.ceiling(date, Fields.DateField.HOUR_OF_DAY);
        Assertions.assertEquals("2017-03-01 22:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 上下午，原始日期是22点，上下午的结束就是23点
        begin = DateUtils.ceiling(date, Fields.DateField.AM_PM);
        Assertions.assertEquals("2017-03-01 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 天，day of xxx按照day处理
        begin = DateUtils.ceiling(date, Fields.DateField.DAY_OF_WEEK_IN_MONTH);
        Assertions.assertEquals("2017-03-01 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.ceiling(date, Fields.DateField.DAY_OF_WEEK);
        Assertions.assertEquals("2017-03-01 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.ceiling(date, Fields.DateField.DAY_OF_MONTH);
        Assertions.assertEquals("2017-03-01 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 星期
        begin = DateUtils.ceiling(date, Fields.DateField.WEEK_OF_MONTH);
        Assertions.assertEquals("2017-03-05 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
        begin = DateUtils.ceiling(date, Fields.DateField.WEEK_OF_YEAR);
        Assertions.assertEquals("2017-03-05 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 月
        begin = DateUtils.ceiling(date, Fields.DateField.MONTH);
        Assertions.assertEquals("2017-03-31 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));

        // 年
        begin = DateUtils.ceiling(date, Fields.DateField.YEAR);
        Assertions.assertEquals("2017-12-31 23:59:59.999", begin.toString(Fields.NORM_DATETIME_MS_PATTERN));
    }
}