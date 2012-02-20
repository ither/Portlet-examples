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

package com.huenei.exolgan.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author prochas
 */
public class ProcessOrderDetailClp extends BaseModelImpl<ProcessOrderDetail>
	implements ProcessOrderDetail {
	public ProcessOrderDetailClp() {
	}

	public long getPrimaryKey() {
		return _processDetailId;
	}

	public void setPrimaryKey(long pk) {
		setProcessDetailId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_processDetailId);
	}

	public long getProcessDetailId() {
		return _processDetailId;
	}

	public void setProcessDetailId(long processDetailId) {
		_processDetailId = processDetailId;
	}

	public long getProcessOrderId() {
		return _processOrderId;
	}

	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;
	}

	public long getProcessDetailAmount() {
		return _processDetailAmount;
	}

	public void setProcessDetailAmount(long processDetailAmount) {
		_processDetailAmount = processDetailAmount;
	}

	public String getBankCheck() {
		return _bankCheck;
	}

	public void setBankCheck(String bankCheck) {
		_bankCheck = bankCheck;
	}

	public String getBankCheckId() {
		return _bankCheckId;
	}

	public void setBankCheckId(String bankCheckId) {
		_bankCheckId = bankCheckId;
	}

	public ProcessOrderDetail toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ProcessOrderDetail)Proxy.newProxyInstance(ProcessOrderDetail.class.getClassLoader(),
				new Class[] { ProcessOrderDetail.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ProcessOrderDetailClp clone = new ProcessOrderDetailClp();

		clone.setProcessDetailId(getProcessDetailId());
		clone.setProcessOrderId(getProcessOrderId());
		clone.setProcessDetailAmount(getProcessDetailAmount());
		clone.setBankCheck(getBankCheck());
		clone.setBankCheckId(getBankCheckId());

		return clone;
	}

	public int compareTo(ProcessOrderDetail processOrderDetail) {
		long pk = processOrderDetail.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProcessOrderDetailClp processOrderDetail = null;

		try {
			processOrderDetail = (ProcessOrderDetailClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = processOrderDetail.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{processDetailId=");
		sb.append(getProcessDetailId());
		sb.append(", processOrderId=");
		sb.append(getProcessOrderId());
		sb.append(", processDetailAmount=");
		sb.append(getProcessDetailAmount());
		sb.append(", bankCheck=");
		sb.append(getBankCheck());
		sb.append(", bankCheckId=");
		sb.append(getBankCheckId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.huenei.exolgan.services.model.ProcessOrderDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processDetailId</column-name><column-value><![CDATA[");
		sb.append(getProcessDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processOrderId</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processDetailAmount</column-name><column-value><![CDATA[");
		sb.append(getProcessDetailAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankCheck</column-name><column-value><![CDATA[");
		sb.append(getBankCheck());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankCheckId</column-name><column-value><![CDATA[");
		sb.append(getBankCheckId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processDetailId;
	private long _processOrderId;
	private long _processDetailAmount;
	private String _bankCheck;
	private String _bankCheckId;
}