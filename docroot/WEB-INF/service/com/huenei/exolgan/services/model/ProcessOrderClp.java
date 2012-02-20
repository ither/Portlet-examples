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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author prochas
 */
public class ProcessOrderClp extends BaseModelImpl<ProcessOrder>
	implements ProcessOrder {
	public ProcessOrderClp() {
	}

	public long getPrimaryKey() {
		return _processOrderId;
	}

	public void setPrimaryKey(long pk) {
		setProcessOrderId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_processOrderId);
	}

	public long getProcessOrderId() {
		return _processOrderId;
	}

	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getCompanyAddress() {
		return _companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		_companyAddress = companyAddress;
	}

	public String getCompanyContact() {
		return _companyContact;
	}

	public void setCompanyContact(String companyContact) {
		_companyContact = companyContact;
	}

	public String getProcessOrderDescription() {
		return _processOrderDescription;
	}

	public void setProcessOrderDescription(String processOrderDescription) {
		_processOrderDescription = processOrderDescription;
	}

	public String getProcessOrderFailedBy() {
		return _processOrderFailedBy;
	}

	public void setProcessOrderFailedBy(String processOrderFailedBy) {
		_processOrderFailedBy = processOrderFailedBy;
	}

	public ProcessOrder toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ProcessOrder)Proxy.newProxyInstance(ProcessOrder.class.getClassLoader(),
				new Class[] { ProcessOrder.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ProcessOrderClp clone = new ProcessOrderClp();

		clone.setProcessOrderId(getProcessOrderId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyName(getCompanyName());
		clone.setCompanyAddress(getCompanyAddress());
		clone.setCompanyContact(getCompanyContact());
		clone.setProcessOrderDescription(getProcessOrderDescription());
		clone.setProcessOrderFailedBy(getProcessOrderFailedBy());

		return clone;
	}

	public int compareTo(ProcessOrder processOrder) {
		long pk = processOrder.getPrimaryKey();

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

		ProcessOrderClp processOrder = null;

		try {
			processOrder = (ProcessOrderClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = processOrder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{processOrderId=");
		sb.append(getProcessOrderId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", companyAddress=");
		sb.append(getCompanyAddress());
		sb.append(", companyContact=");
		sb.append(getCompanyContact());
		sb.append(", processOrderDescription=");
		sb.append(getProcessOrderDescription());
		sb.append(", processOrderFailedBy=");
		sb.append(getProcessOrderFailedBy());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.huenei.exolgan.services.model.ProcessOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processOrderId</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyAddress</column-name><column-value><![CDATA[");
		sb.append(getCompanyAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyContact</column-name><column-value><![CDATA[");
		sb.append(getCompanyContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processOrderDescription</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processOrderFailedBy</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderFailedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processOrderId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _companyName;
	private String _companyAddress;
	private String _companyContact;
	private String _processOrderDescription;
	private String _processOrderFailedBy;
}