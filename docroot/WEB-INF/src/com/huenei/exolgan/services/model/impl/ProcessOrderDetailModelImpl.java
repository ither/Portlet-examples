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

package com.huenei.exolgan.services.model.impl;

import com.huenei.exolgan.services.model.ProcessOrderDetail;
import com.huenei.exolgan.services.model.ProcessOrderDetailModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the ProcessOrderDetail service. Represents a row in the &quot;EXO_ProcessOrderDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.huenei.exolgan.services.model.ProcessOrderDetailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProcessOrderDetailImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a Tramite-Detalle model instance should use the {@link com.huenei.exolgan.services.model.ProcessOrderDetail} interface instead.
 * </p>
 *
 * @author prochas
 * @see ProcessOrderDetailImpl
 * @see com.huenei.exolgan.services.model.ProcessOrderDetail
 * @see com.huenei.exolgan.services.model.ProcessOrderDetailModel
 * @generated
 */
public class ProcessOrderDetailModelImpl extends BaseModelImpl<ProcessOrderDetail>
	implements ProcessOrderDetailModel {
	public static final String TABLE_NAME = "EXO_ProcessOrderDetail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "processDetailId", new Integer(Types.BIGINT) },
			{ "processDetailAmount", new Integer(Types.BIGINT) },
			{ "bankCheck", new Integer(Types.VARCHAR) },
			{ "bankCheckId", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table EXO_ProcessOrderDetail (processDetailId LONG not null primary key,processDetailAmount LONG,bankCheck VARCHAR(75) null,bankCheckId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table EXO_ProcessOrderDetail";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.huenei.exolgan.services.model.ProcessOrderDetail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.huenei.exolgan.services.model.ProcessOrderDetail"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.huenei.exolgan.services.model.ProcessOrderDetail"));

	public ProcessOrderDetailModelImpl() {
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

	public long getProcessDetailAmount() {
		return _processDetailAmount;
	}

	public void setProcessDetailAmount(long processDetailAmount) {
		_processDetailAmount = processDetailAmount;
	}

	public String getBankCheck() {
		if (_bankCheck == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankCheck;
		}
	}

	public void setBankCheck(String bankCheck) {
		_bankCheck = bankCheck;
	}

	public String getBankCheckId() {
		if (_bankCheckId == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankCheckId;
		}
	}

	public void setBankCheckId(String bankCheckId) {
		_bankCheckId = bankCheckId;
	}

	public ProcessOrderDetail toEscapedModel() {
		if (isEscapedModel()) {
			return (ProcessOrderDetail)this;
		}
		else {
			return (ProcessOrderDetail)Proxy.newProxyInstance(ProcessOrderDetail.class.getClassLoader(),
				new Class[] { ProcessOrderDetail.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					ProcessOrderDetail.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		ProcessOrderDetailImpl processOrderDetailImpl = new ProcessOrderDetailImpl();

		processOrderDetailImpl.setProcessDetailId(getProcessDetailId());

		processOrderDetailImpl.setProcessDetailAmount(getProcessDetailAmount());

		processOrderDetailImpl.setBankCheck(getBankCheck());

		processOrderDetailImpl.setBankCheckId(getBankCheckId());

		return processOrderDetailImpl;
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

		ProcessOrderDetail processOrderDetail = null;

		try {
			processOrderDetail = (ProcessOrderDetail)obj;
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
		StringBundler sb = new StringBundler(9);

		sb.append("{processDetailId=");
		sb.append(getProcessDetailId());
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
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.huenei.exolgan.services.model.ProcessOrderDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processDetailId</column-name><column-value><![CDATA[");
		sb.append(getProcessDetailId());
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
	private long _processDetailAmount;
	private String _bankCheck;
	private String _bankCheckId;
	private transient ExpandoBridge _expandoBridge;
}