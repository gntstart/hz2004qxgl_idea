package com.gnt.qxgl.common.base;

import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.gnt.qxgl.base.BaseContext;
import com.gnt.qxgl.common.BaseUser;
import com.gnt.qxgl.common.SystemConfig;
import com.gnt.qxgl.common.util.CommonUtil;
import com.gnt.qxgl.common.util.DateHelper;
import com.gnt.qxgl.hz2004.entity.XtYh;
import com.gnt.qxgl.hz2004.entity.XtYhxxb;


/**
 * 用于VIEW层的数据处理，现主要用于数据模板处理 这里的名字尽量短小
 * 
 * @author memphis.guo
 */
public class TemplateUtil {
	static Logger logger = Logger.getLogger(TemplateUtil.class);
	
	/**
	 * 街路巷、居委会数据范围查询条件
	 * @return
	 */
	public static String linkSjfw(){
   		//and ((1 = 0) or (c.DWDM = '340702003') or (substr(c.DWDM, 0, 6) = '340720'))
		BaseUser u = BaseContext.getBaseUser();
		if(u.isAdmin()) return "";
		
		String where = " and ( (0=1) ";
		if(CommonUtil.isNotEmpty(u.getSjfw())){
			Set<String> set = new HashSet<String>();
			
			String sjfw[] = u.getSjfw().split("\\|");
			for(String bm:sjfw){
				bm = bm.trim();
				
				if(CommonUtil.isEmpty(bm) || set.contains(bm))
					continue;
				
				if(bm.length()==6)
					where += " or substr(c.dwdm, 0, 6) = '" + bm.substring(0, 6) + "'";
				else if(bm.length()==9)
					where += " or c.dwdm = '" + bm + "'";
				
				set.add(bm);
			}
		}
		where += ")";
		//340702|340702003|||340720||||
		return where;
	}
	
	/**
	 * 判断当前用户是否存在指定的角色
	 * @param roleBm
	 * @return
	 */
	public static boolean existRole(String roleBm){
		BaseUser currentUser = (BaseUser) BaseContext.getBaseUser();
		
		return currentUser.getRolesMap().containsKey(roleBm);
	}
	
	/**
	 * 获取数据范围
	 * @param roleBm
	 * @return
	 */
	public static String getSjfw(){
		BaseUser currentUser = (BaseUser) BaseContext.getBaseUser();
		if(currentUser==null)
			return "null";
		
		String sjfw = currentUser.getSjfw();
		if(CommonUtil.isEmpty(sjfw))
			return "null";
		
		return sjfw;
	}
	
	/**
	 * 判断是否是超级管理员
	 * @return
	 */
	public static boolean isAdmin(){
		BaseUser currentUser = (BaseUser) BaseContext.getBaseUser();
		if(currentUser==null)
			return false;
		
		XtYh u = currentUser.getUser();
		
		return ("," + SystemConfig.getSystemConfig("admin", "admin,root") + ",")
					.indexOf("," + u.getDlm() + ",")>=0?true:false;
	}
	
	/**
	 * 模板对象值替换
	 * 
	 * @param 模板字符串
	 * @param 模板里需要的对象列表
	 * @return
	 */
	public static String replace(String str, Map objs) {
		try {
			Velocity.init();
			VelocityContext velocityContext = new VelocityContext();
			velocityContext.put("ut", new TemplateUtil());
			Iterator it = objs.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				velocityContext.put(key, objs.get(key));
			}
			StringWriter sw = new StringWriter();
			Velocity.evaluate(velocityContext, sw, "LOG", str);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("生成文书内容出错!", e);
		}
	}

	/**
	 * 自动为指定的字符串变量增加rt方法
	 * 
	 * @return
	 */
	public static String art(String str) {
		if (str == null || str.indexOf('{') < 0)
			return str;
		Pattern p = Pattern.compile("\\$\\!?\\{([a-zA-Z_0-9\\.]+)\\}");
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			if ("tfr".equalsIgnoreCase(m.group(1)))
				m.appendReplacement(sb, "\\$" + m.group(1));
			else
				m.appendReplacement(sb, "\\$!{ut.rt(\\$" + m.group(1) + ")}");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 替换指定的字符串中的tab符为空格
	 * 
	 * @param str
	 * @return
	 */
	public Object rt(Object str) {
		if (str == null)
			return null;
		if (str instanceof String)
			return str.toString().replaceAll("\\t", "    ").replaceAll(
					"\\r\\n", "\n").replaceAll("\\r", "\n").replaceAll("\\n",
					"@r@");
		return str;
	}

	/**
	 * 返回格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public String sd(Date date) {
		if (date == null)
			return null;
		return DateHelper.formateDate(date, DateHelper.PRINT_DATE_STYLE);
	}

	/**
	 * 返回格式化日期时间
	 * 
	 * @param date
	 * @return
	 */
	public String sdt(Date date) {
		if (date == null)
			return null;
		return DateHelper.formateDate(date, DateHelper.PRINT_DATETIME_STYLE);
	}

	/**
	 * 返回小数点后两位的代码
	 * 
	 * @param dnum
	 * @return
	 */
	public String dltstr(Double dnum) {
		if (dnum == null)
			return null;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		return decimalFormat.format(dnum);
	}

	/**
	 * 根据身份证号获取出生日期
	 * 
	 * @param sfzh
	 * @return
	 */
	public String csrqBySfzh(String sfzh) {
		if (sfzh == null)
			return "";
		sfzh = sfzh.trim();
		if (sfzh.length() == 18) {
			return sfzh.substring(6, 10) + "年" + riYue(sfzh, 10, 12) + "月"
					+ riYue(sfzh, 12, 14) + "日";
		} else if (sfzh.length() == 15) {
			return "19" + sfzh.substring(6, 8) + "年" + riYue(sfzh, 8, 10) + "月"
					+ riYue(sfzh, 10, 12) + "日";
		}
		return "";
	}

	private int riYue(String str, int b, int e) {
		return Integer.parseInt(str.substring(b, e));
	}

	/**
	 * 根据出生日期获取当年年龄
	 * 
	 * @param date
	 *            出生日期
	 * @return
	 */
	public String nl(Date date) {
		if (date == null)
			return "";
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int intAge = DateHelper.getAge(calendar.get(Calendar.YEAR));

		// Added by Albert on 200801-21
		Date today = new Date(System.currentTimeMillis());
		GregorianCalendar calToday = new GregorianCalendar();
		calToday.setTime(today);
		if (!isFebruaryLastDay(calendar) || !isFebruaryLastDay(calToday)) {// 都是二月底则年龄不减1
			calToday.set(Calendar.YEAR, calendar.get(Calendar.YEAR));// 将当前日期的年号设为出生日期的年号，便于比较。
			if (calendar.after(calToday)) {// 在忽略年号的情况下，如果出生日期在当前日期之前，则当前年龄减 1
				// 岁
				intAge--;
			}
		}

		// End of addition
		return String.valueOf(intAge);
	}

	// Added by Albert on 200801-21
	private boolean isFebruaryLastDay(GregorianCalendar calendar) {
		boolean blnFlag = false;
		if (1 == calendar.get(Calendar.MONTH)) {
			calendar.roll(Calendar.DATE, 1);
			if (2 == calendar.get(Calendar.MONTH)) {
				blnFlag = true;
			}
			calendar.roll(Calendar.DATE, -1);
		}
		return blnFlag;
	}

	// End of addition

	// Added by Albert on 2008-03-14

	/**
	 * 获取指定日期的中国日期格式(精确到时)：如：2004年5月4日21时
	 */
	public String cnHour(Date date) {
		return DateHelper.formateDate(date, DateHelper.CN_HOUR_STYLE);
	}

	/**
	 * 获取指定日期的中国日期格式(精确到分)：如：2004年5月4日21时04分
	 */
	public String cnMinute(Date date) {
		return DateHelper.formateDate(date, DateHelper.CN_MINUTE_STYLE);
	}

	// End of addition

	public String cnSecond(Date date) {
		return DateHelper.formateDate(date, DateHelper.CN_SECOND_STYLE);
	}

	/**
	 * style=yyyy年M月d日/yyyy年M月d日HH时mm分 获取指定日期的中国日期格式：如：2004年5月4号
	 */
	public String cnrqByStyle(Date date, String style) {
		return DateHelper.formateDate(date, style);
	}

	/**
	 * 获取指定日期的中国日期格式：如：2004年5月4号
	 * 
	 * @param date
	 * @return
	 */
	public String cnrq(Date date) {
		String rs = DateHelper.formateDate(date, DateHelper.CN_DATE_STYLE);
		if (date == null)
			return "";
		return rs;
	}

	public String cnrq() {
		return DateHelper.formateDate(new Date(), DateHelper.CN_DATE_STYLE);
	}

	/**
	 * 获取指定日期的中国日期大写格式：如：二00四年五月四号
	 * 
	 * @param date
	 * @return
	 */
	public String cndxrq(Date date) {
		return DateHelper.getDx(cnrq(date));
	}

	public String cndxrq() {
		return DateHelper.getDx(cnrq());
	}

	/**
	 * 将小写RMB转化为大写格式（精确到分）
	 */
	public static String UpInt(Object ob) {
		char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		String value = "0";
		if (ob != null) {
			value = ob.toString(); // 传入参数由object转化为string类型
		}

		double value1 = Double.parseDouble(value); // String转为double
		long midVal = (long) (value1 * 100); // double转为long
		String valStr = String.valueOf(midVal); // 转化成字符串
		String head = "0"; // 取整数部分
		String rail = "0"; // 取小数部分
		if (!valStr.equals("0")) {
			head = valStr.substring(0, valStr.length() - 2);
			rail = valStr.substring(valStr.length() - 2);
		}

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果
		// 处理小数点后面的数
		if (rail.equals("00")) {
			// 如果小数部分为0
			suffix = "整";
		} else if (rail.equals("0")) {
			suffix = "";
		} else {
			if ((rail.charAt(1) - '0') == 0) {
				suffix = digit[rail.charAt(0) - '0'] + "角";
			} else {
				suffix = digit[rail.charAt(0) - '0'] + "角"
						+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
			} // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) {
			// 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4;
			// 取段内位置
			int vidx = (chDig.length - i - 1) / 4;
			// 取段位置
			if (chDig[i] == '0') {
				// 如果当前字符是0
				zeroSerNum++;
				// 连续0次数递增
				if (zero == '0') {
					// 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0; // 连续0次数清零
			if (zero != '0') {
				// 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0'];
			// 转化该数字表示
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		if (prefix.length() > 0)
			prefix += '元';
		// 如果整数部分存在,则有圆的字样
		return prefix + suffix; // 返回正确表示
	}

	/**
	 * 将long型的整数转化为中文大写的数字
	 * 
	 * @param srjyqx
	 * @return
	 */
	public String numToUpCase(Long srjyqx) {
		if (srjyqx == null) {
			return "";
		}
		String strresult = ""; // 最终的返回字符串
		char[] uUnit = { '拾', '佰', '仟' };
		char[] hUnit = { '万', '亿' };
		char[] digitUnit = { '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		String strsryj = srjyqx.toString();
		char[] chDig = strsryj.toCharArray(); // 将整数整理为字符串数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeronum = 0; // 连续零出现的次数
		for (int i = 0; i < strsryj.length(); i++) {
			// 处理每个整数数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int videx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') {
				zeronum++;
				if (zero == '0') {
					zero = digitUnit[0];
				} else if (idx == 0 && videx > 0 && zeronum < 4) { // 取超过个位0的数
					strresult += hUnit[videx - 1];
					zero = '0';
				}
				continue;
			}
			zeronum = 0; // 连续0清零
			if (zero != '0') {
				strresult += zero;
				zero = '0';
			}
			strresult += digitUnit[chDig[i] - '0'];
			if (idx > 0)
				strresult += uUnit[idx - 1];
			if (idx == 0 && videx > 0) {
				strresult += hUnit[videx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		return strresult;
	}

	/**
	 * 将long型的整数转化为中文大写的数字
	 * 
	 * @param srjyqx
	 * @return
	 */
	public String numToUpCase2(Long srjyqx) {
		if (srjyqx == null) {
			return "";
		}
		String strresult = ""; // 最终的返回字符串
		char[] uUnit = { '拾', '佰', '仟' };
		char[] hUnit = { '万', '亿' };
		char[] digitUnit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		String strsryj = srjyqx.toString();
		char[] chDig = strsryj.toCharArray(); // 将整数整理为字符串数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeronum = 0; // 连续零出现的次数
		for (int i = 0; i < strsryj.length(); i++) {
			// 处理每个整数数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int videx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') {
				zeronum++;
				if (zero == '0') {
					zero = digitUnit[0];
				} else if (idx == 0 && videx > 0 && zeronum < 4) { // 取超过个位0的数
					strresult += hUnit[videx - 1];
					zero = '0';
				}
				continue;
			}
			zeronum = 0; // 连续0清零
			if (zero != '0') {
				strresult += zero;
				zero = '0';
			}
			strresult += digitUnit[chDig[i] - '0'];
			if (idx > 0)
				strresult += uUnit[idx - 1];
			if (idx == 0 && videx > 0) {
				strresult += hUnit[videx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		return strresult;
	}

	/**
	 * 将String型的整型数字转化为中文大写的数字
	 * 
	 * @param srjyqx
	 * @return
	 */
	public String numToUpCase(String srjyqx) {
		if (srjyqx == null || srjyqx.trim().length() == 0) {
			return "";
		}
		String strresult = ""; // 最终的返回字符串
		char[] uUnit = { '拾', '佰', '仟' };
		char[] hUnit = { '万', '亿' };
		char[] digitUnit = { '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		String strsryj = srjyqx.toString();
		char[] chDig = strsryj.toCharArray(); // 将整数整理为字符串数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeronum = 0; // 连续零出现的次数
		for (int i = 0; i < strsryj.length(); i++) {
			// 处理每个整数数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int videx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') {
				zeronum++;
				if (zero == '0') {
					zero = digitUnit[0];
				} else if (idx == 0 && videx > 0 && zeronum < 4) { // 取超过个位0的数
					strresult += hUnit[videx - 1];
					zero = '0';
				}
				continue;
			}
			zeronum = 0; // 连续0清零
			if (zero != '0') {
				strresult += zero;
				zero = '0';
			}
			strresult += digitUnit[chDig[i] - '0'];
			if (idx > 0)
				strresult += uUnit[idx - 1];
			if (idx == 0 && videx > 0) {
				strresult += hUnit[videx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		return strresult;
	}

	/**
	 * 将long型的整数转化为中文大写的数字
	 * 
	 * @param srjyqx
	 * @return
	 */
	public String numToUpCase(Integer srjyqx) {
		if (srjyqx == null) {
			return "";
		}
		String strresult = ""; // 最终的返回字符串
		char[] uUnit = { '拾', '佰', '仟' };
		char[] hUnit = { '万', '亿' };
		char[] digitUnit = { '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		String strsryj = srjyqx.toString();
		char[] chDig = strsryj.toCharArray(); // 将整数整理为字符串数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeronum = 0; // 连续零出现的次数
		for (int i = 0; i < strsryj.length(); i++) {
			// 处理每个整数数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int videx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') {
				zeronum++;
				if (zero == '0') {
					zero = digitUnit[0];
				} else if (idx == 0 && videx > 0 && zeronum < 4) { // 取超过个位0的数
					strresult += hUnit[videx - 1];
					zero = '0';
				}
				continue;
			}
			zeronum = 0; // 连续0清零
			if (zero != '0') {
				strresult += zero;
				zero = '0';
			}
			strresult += digitUnit[chDig[i] - '0'];
			if (idx > 0)
				strresult += uUnit[idx - 1];
			if (idx == 0 && videx > 0) {
				strresult += hUnit[videx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		return strresult;
	}

	/**
	 * 功能描述：删除空格
	 * 
	 * @param str
	 * @return
	 * @author zgd
	 */
	public static String trim(String str) {
		if (str == null)
			str = "";
		String returnValue = str.trim();
		while (returnValue.startsWith("　")) {
			returnValue = returnValue.substring(1);
		}
		return returnValue;
	}

	/**
	 * 功能描述：为空被替换
	 * 
	 * @param str
	 * @return
	 * @author zgd
	 */
	public static String nullToTag(String str, String tag) {
		if (str == null || "".equals(str))
			str = tag;
		return str;
	}

	/**
	 * 对于科学计算法的浮点性的转换
	 * 
	 * @param num
	 * @return
	 * @zap
	 */
	public static String dts(Double num) {
		String str = null;
		if (num == null)
			return str = "";
		DecimalFormat df = new DecimalFormat("#.00");
		// double dd = Double.parseDouble(num);
		str = df.format(num);
		return str;
	}
	
	public static boolean isns(Object str){
		if(str==null)
			return true;
		
		return CommonUtil.isEmpty(str.toString());
	}

	public static String getSDate(String str){
		return str + "0000";
	}
	
	public static String getEDate(String str){
		return str + "2359";
	}

	public static String toU(String str){
		if(str==null)
			return null;
		
		return str.toUpperCase();
	}
	
	public static String toL(String str){
		if(str==null)
			return null;
		
		return str.toLowerCase();
	}
	
	public static Long toLong(String str){
		if(str==null)
			return null;
		
		return Long.parseLong(str);
	}
	
	/**
	 * 将字符串转换成SQL in函数所需格式
	 * a,b,c -> 'a','b','c'
	 * @param str
	 * @return
	 */
	public static String getInStr(String str){
		
		String result = "";
		String[] srr = str.split(",");
		for (int i = 0; i < srr.length; i++) {
			String string = srr[i];
			result += "'" + string + "',";
		}
		result = result.substring(0, result.length() - 1);
		
		return result;
	}
	
}