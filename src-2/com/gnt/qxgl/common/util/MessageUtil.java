package com.gnt.qxgl.common.util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 消息传递工具，此类用于保存action和service之间传递的消息
 * 
 * @author Administrator
 * 
 */
public class MessageUtil {
	// 保存错误消息用
	private static final ThreadLocal errorMsgLocal = new ThreadLocal();

	// 保存普通消息用
	private static final ThreadLocal generalMsgLocal = new ThreadLocal();

	// 保存成功标志
	private static final ThreadLocal successLocal = new ThreadLocal();

	// 保存出错标志
	private static final ThreadLocal errorLocal = new ThreadLocal();

	private MessageUtil() {

	}

	/**
	 * 清空
	 * 
	 */
	public static void reset() {
		errorMsgLocal.set(null);
		generalMsgLocal.set(null);
		successLocal.set(null);
		errorLocal.set(null);
	}

	/**
	 * 添加一条错误消息
	 * 
	 * @param errorMsg
	 */
	public static void addErrorMsg(String errorMsg) {
		Set msgSet = (Set) errorMsgLocal.get();
		if (msgSet == null) {
			msgSet = new LinkedHashSet();
			errorMsgLocal.set(msgSet);
		}

		msgSet.add(errorMsg);
	}

	/**
	 * 返回错误消息集合
	 * 
	 * @return 已添加的错误消息集合
	 */
	public static Collection getErrorMsg() {
		Set msgSet = (Set) errorMsgLocal.get();
		if (msgSet == null) {
			msgSet = new LinkedHashSet();
		}

		return msgSet;
	}

	/**
	 * 添加一条普通消息
	 * 
	 * @param msg
	 */
	public static void addGeneralMsg(String msg) {
		Set msgSet = (Set) generalMsgLocal.get();
		if (msgSet == null) {
			msgSet = new LinkedHashSet();
			generalMsgLocal.set(msgSet);
		}

		msgSet.add(msg);
	}

	/**
	 * 返回普通消息的集合
	 * 
	 * @return 已添加的普通消息集合
	 */
	public static Collection getGeneralMsg() {
		Set msgSet = (Set) generalMsgLocal.get();
		if (msgSet == null) {
			msgSet = new LinkedHashSet();
		}

		return msgSet;
	}

	/**
	 * 设置操作成功标志
	 * 
	 * @param isSuccess
	 */
	public static void setSueecess(boolean isSuccess) {
		successLocal.set(new Boolean(isSuccess));
	}

	/**
	 * 取操作成功标志
	 * 
	 * @return
	 */
	public static boolean isSuccess() {
		boolean isSuccess = false;

		if (successLocal.get() != null) {
			isSuccess = ((Boolean) successLocal.get()).booleanValue();
		}

		return isSuccess;
	}

	/**
	 * 设置出错标志
	 * 
	 * @param isError
	 */
	public static void setError(boolean isError) {
		errorLocal.set(new Boolean(isError));
	}

	/**
	 * 取出错标志
	 * 
	 * @return
	 */
	public static boolean isError() {
		boolean isError = false;

		if (errorLocal.get() != null) {
			isError = ((Boolean) errorLocal.get()).booleanValue();
		}

		return isError;
	}
}
