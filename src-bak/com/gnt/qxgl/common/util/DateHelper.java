/*
 * Created on 2004-8-20
 */
package com.gnt.qxgl.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;



/**
 * 日期处理工具类
 */
public class DateHelper 
{
	public static String getDx(String arg) {
		if (arg == null)
			return null;
		char s[] = { '○', '一', '二', '三', '四', '五', '六','七','八','九'};

		StringBuffer ret = new StringBuffer();

		Pattern pattern = Pattern.compile("([0-9]+)");
		Matcher m = pattern.matcher(arg);
		while (m.find()) {
			StringBuffer sb = new StringBuffer();
			int t = Integer.valueOf(m.group(1)).intValue();
			if (t > 31 || t < 10) {
				for (int i = 0; i < m.group(1).length(); i++) {
					String c = String.valueOf(m.group(1).charAt(i));
					if (StringUtils.isNumeric(String.valueOf(c)))
						sb.append(s[new Integer(c).intValue()]);
					else
						sb.append(c);
				}
			} else {
				String str = String.valueOf(t);
				String si = String.valueOf(str.charAt(0));
				if (str.charAt(0) == '1')
					sb.append("十");
				else
					sb.append(s[new Integer(si).intValue()]).append("十");
				if (str.charAt(1) != '0')
					sb.append(s[new Integer(String.valueOf(str.charAt(1)))
							.intValue()]);
			}
			m.appendReplacement(ret, sb.toString());
		}
		m.appendTail(ret);
		return ret.toString();
	}
	
	public static final String EXT_PRINT_DATE_STYLE="yyyy-MM-dd";
    public static final String PRINT_DATE_STYLE="yyyy/MM/dd";
    
    public static final String PRINT_DATETIME_STYLE="yyyy/MM/dd HH:mm:ss";
    public static final String PRINT_DATETIME_STYLE2="yyyy-MM-dd HH:mm:ss";
    
    public static final String CN_DATE_STYLE="yyyy年M月d日";
    public static final String CN_HOUR_STYLE="yyyy年M月d日HH时";
    public static final String CN_MINUTE_STYLE="yyyy年M月d日HH时mm分";
    public static final String CN_SECOND_STYLE="yyyy年M月d日HH时mm分ss秒";
    public static final String CN_DATE_STYLE_WEEK="yyyy年M月d日 E";
    public static final String CN_SECOND_STYLE_ONLYTIME="HH时mm分ss秒";
    
   
    /**
     * 根据指定的日期字符串和格式返回日期对象
     * @param style
     * @param date
     * @return
     */    
    public static Date toDate(String date, String style) 
    {
        if (style == null || date == null)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(style);
        try {
            return sf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按照指定的格式格式化指定的日期对象
     * @param 日期对象
     * @param 格式
     * @return 格式化好的日期字符串
     */
    public static String formateDate(Date dateValue, String style) 
    {
    	if(dateValue==null) return "";
    	
        if (style == null || dateValue==null)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(style);
        String strDate = sf.format(dateValue);
       
        return strDate;
    }

    /**
     * 去当前时间的格式数据
     * @param style
     * @return
     */
    public static String formateDate(String style) 
    {
        if (style == null)
            return null;
        SimpleDateFormat sf = new SimpleDateFormat(style);
        String strDate = sf.format(Calendar.getInstance().getTime());
        
        return strDate;
    }
    
    public static int getAge(int year) 
    {
        Date today = new Date(System.currentTimeMillis());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        int age = calendar.get(Calendar.YEAR) - year;
        return age;
    }
    

    
    public static Date setYear(Date date, int year)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
    
    /**
     * 用于获取日期比较的开始时间：将指定的时间去掉时，分，秒。
     * @param date
     * @return
     */
    public static Date getStartDate(Date date){
    	if(date==null) return null;
    	
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(date);
		ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DAY_OF_MONTH), 0,0,0);
		return ca.getTime();
    }
    
    /**
     * 获取本月第一天
     * @return
     */
	static public String getMonthStartDate(){
		Calendar cDate = Calendar.getInstance();
		cDate.add(Calendar.DAY_OF_MONTH, -1);
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd") + "0000";
		return s;
	}
	
    
    
    /**
     * 获取昨天0点
     * @return
     */
	static public String getMonthStartDate3(){
		Calendar cDate = Calendar.getInstance();
		cDate.add(Calendar.DAY_OF_MONTH, -1);
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd") + "0000";
		return s;
	}
	
	  /**
     * 获取昨天23点59分
     * @return
     */
	static public String getMonthEndDate3(){
		Calendar cDate = Calendar.getInstance();
		cDate.add(Calendar.DAY_OF_MONTH, -1);
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd") + "2359";
		return s;
	}
	
	/**
	 * 获取本月当前日期
	 * @return
	 */
	static public String getMonthEndDate(){
		Calendar cDate = Calendar.getInstance();
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd") + "2359";
		return s;
	}
	
    /**
     * 获取本月第一天
     * @return
     */
	static public String getMonthStartDate2(){
		Calendar cDate = Calendar.getInstance();
		cDate.add(Calendar.DAY_OF_MONTH, -2);
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd");
		return s;
	}
	
	
	
	/**
	 * 获取本月当前日期
	 * @return
	 */
	static public String getMonthEndDate2(){
		Calendar cDate = Calendar.getInstance();
		String s = DateHelper.formateDate(cDate.getTime(), "yyyyMMdd");
		return s;
	}
	
    /**
     * 用户获取日期比较的结束时间：将指定时间的时，分，秒换算成今天的最后一秒
     * @param date
     * @return
     */
    public static Date getEndDate(Date date){
    	if(date==null) return null;
    	
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(date);
    	ca.set(ca.get(Calendar.YEAR), ca.get(Calendar.MONTH), ca.get(Calendar.DAY_OF_MONTH), 23,59,59);
		return ca.getTime();    	
    }
}