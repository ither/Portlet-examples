/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.huenei.exolgan.services.service;

import com.huenei.exolgan.services.model.ProcessOrderClp;
import com.huenei.exolgan.services.model.ProcessOrderDetailClp;
import com.huenei.exolgan.services.model.ReservationClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "Exolgan-features-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ReservationClp.class.getName())) {
			ReservationClp oldCplModel = (ReservationClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.huenei.exolgan.services.model.impl.ReservationImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setReservationId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getReservationId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value3 = oldCplModel.getUserName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreateDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getModifiedDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setReservationTimestamp",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getReservationTimestamp();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setReservationDurationHour",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getReservationDurationHour());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setReservationDurationMinute",
							new Class[] { Long.TYPE });

					Long value8 = new Long(oldCplModel.getReservationDurationMinute());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCompanyName",
							new Class[] { String.class });

					String value9 = oldCplModel.getCompanyName();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setMeetingRoom",
							new Class[] { String.class });

					String value10 = oldCplModel.getMeetingRoom();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setVisitNames",
							new Class[] { String.class });

					String value11 = oldCplModel.getVisitNames();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setVisitDocs",
							new Class[] { String.class });

					String value12 = oldCplModel.getVisitDocs();

					method12.invoke(newModel, value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProcessOrderClp.class.getName())) {
			ProcessOrderClp oldCplModel = (ProcessOrderClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.huenei.exolgan.services.model.impl.ProcessOrderImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProcessOrderId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getProcessOrderId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getCompanyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value3 = oldCplModel.getUserName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreateDate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getModifiedDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCompanyName",
							new Class[] { String.class });

					String value6 = oldCplModel.getCompanyName();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCompanyAddress",
							new Class[] { String.class });

					String value7 = oldCplModel.getCompanyAddress();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCompanyContact",
							new Class[] { String.class });

					String value8 = oldCplModel.getCompanyContact();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setProcessOrderDescription",
							new Class[] { String.class });

					String value9 = oldCplModel.getProcessOrderDescription();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setProcessOrderFailedBy",
							new Class[] { String.class });

					String value10 = oldCplModel.getProcessOrderFailedBy();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProcessOrderDetailClp.class.getName())) {
			ProcessOrderDetailClp oldCplModel = (ProcessOrderDetailClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProcessDetailId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getProcessDetailId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setProcessOrderId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getProcessOrderId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setProcessDetailAmount",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getProcessDetailAmount());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setBankCheck",
							new Class[] { String.class });

					String value3 = oldCplModel.getBankCheck();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBankCheckId",
							new Class[] { String.class });

					String value4 = oldCplModel.getBankCheckId();

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.huenei.exolgan.services.model.impl.ReservationImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ReservationClp newModel = new ReservationClp();

					Method method0 = oldModelClass.getMethod("getReservationId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setReservationId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setUserId(value2);

					Method method3 = oldModelClass.getMethod("getUserName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value3);

					Method method4 = oldModelClass.getMethod("getCreateDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value4);

					Method method5 = oldModelClass.getMethod("getModifiedDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value5);

					Method method6 = oldModelClass.getMethod(
							"getReservationTimestamp");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setReservationTimestamp(value6);

					Method method7 = oldModelClass.getMethod(
							"getReservationDurationHour");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setReservationDurationHour(value7);

					Method method8 = oldModelClass.getMethod(
							"getReservationDurationMinute");

					Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

					newModel.setReservationDurationMinute(value8);

					Method method9 = oldModelClass.getMethod("getCompanyName");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyName(value9);

					Method method10 = oldModelClass.getMethod("getMeetingRoom");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setMeetingRoom(value10);

					Method method11 = oldModelClass.getMethod("getVisitNames");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setVisitNames(value11);

					Method method12 = oldModelClass.getMethod("getVisitDocs");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setVisitDocs(value12);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.huenei.exolgan.services.model.impl.ProcessOrderImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProcessOrderClp newModel = new ProcessOrderClp();

					Method method0 = oldModelClass.getMethod(
							"getProcessOrderId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setProcessOrderId(value0);

					Method method1 = oldModelClass.getMethod("getCompanyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value1);

					Method method2 = oldModelClass.getMethod("getUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setUserId(value2);

					Method method3 = oldModelClass.getMethod("getUserName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value3);

					Method method4 = oldModelClass.getMethod("getCreateDate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value4);

					Method method5 = oldModelClass.getMethod("getModifiedDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value5);

					Method method6 = oldModelClass.getMethod("getCompanyName");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyName(value6);

					Method method7 = oldModelClass.getMethod(
							"getCompanyAddress");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyAddress(value7);

					Method method8 = oldModelClass.getMethod(
							"getCompanyContact");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyContact(value8);

					Method method9 = oldModelClass.getMethod(
							"getProcessOrderDescription");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setProcessOrderDescription(value9);

					Method method10 = oldModelClass.getMethod(
							"getProcessOrderFailedBy");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setProcessOrderFailedBy(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProcessOrderDetailClp newModel = new ProcessOrderDetailClp();

					Method method0 = oldModelClass.getMethod(
							"getProcessDetailId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setProcessDetailId(value0);

					Method method1 = oldModelClass.getMethod(
							"getProcessOrderId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setProcessOrderId(value1);

					Method method2 = oldModelClass.getMethod(
							"getProcessDetailAmount");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setProcessDetailAmount(value2);

					Method method3 = oldModelClass.getMethod("getBankCheck");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setBankCheck(value3);

					Method method4 = oldModelClass.getMethod("getBankCheckId");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setBankCheckId(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}