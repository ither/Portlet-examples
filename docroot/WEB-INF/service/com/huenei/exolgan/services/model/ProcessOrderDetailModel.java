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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ProcessOrderDetail service. Represents a row in the &quot;EXO_ProcessOrderDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a Tramite-Detalle model instance should use the {@link ProcessOrderDetail} interface instead.
 * </p>
 *
 * @author prochas
 * @see ProcessOrderDetail
 * @see com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl
 * @see com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl
 * @generated
 */
public interface ProcessOrderDetailModel extends BaseModel<ProcessOrderDetail> {
	/**
	 * Gets the primary key of this Tramite-Detalle.
	 *
	 * @return the primary key of this Tramite-Detalle
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this Tramite-Detalle
	 *
	 * @param pk the primary key of this Tramite-Detalle
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the process detail id of this Tramite-Detalle.
	 *
	 * @return the process detail id of this Tramite-Detalle
	 */
	public long getProcessDetailId();

	/**
	 * Sets the process detail id of this Tramite-Detalle.
	 *
	 * @param processDetailId the process detail id of this Tramite-Detalle
	 */
	public void setProcessDetailId(long processDetailId);

	/**
	 * Gets the process order id of this Tramite-Detalle.
	 *
	 * @return the process order id of this Tramite-Detalle
	 */
	public long getProcessOrderId();

	/**
	 * Sets the process order id of this Tramite-Detalle.
	 *
	 * @param processOrderId the process order id of this Tramite-Detalle
	 */
	public void setProcessOrderId(long processOrderId);

	/**
	 * Gets the process detail amount of this Tramite-Detalle.
	 *
	 * @return the process detail amount of this Tramite-Detalle
	 */
	public long getProcessDetailAmount();

	/**
	 * Sets the process detail amount of this Tramite-Detalle.
	 *
	 * @param processDetailAmount the process detail amount of this Tramite-Detalle
	 */
	public void setProcessDetailAmount(long processDetailAmount);

	/**
	 * Gets the bank check of this Tramite-Detalle.
	 *
	 * @return the bank check of this Tramite-Detalle
	 */
	@AutoEscape
	public String getBankCheck();

	/**
	 * Sets the bank check of this Tramite-Detalle.
	 *
	 * @param bankCheck the bank check of this Tramite-Detalle
	 */
	public void setBankCheck(String bankCheck);

	/**
	 * Gets the bank check id of this Tramite-Detalle.
	 *
	 * @return the bank check id of this Tramite-Detalle
	 */
	@AutoEscape
	public String getBankCheckId();

	/**
	 * Sets the bank check id of this Tramite-Detalle.
	 *
	 * @param bankCheckId the bank check id of this Tramite-Detalle
	 */
	public void setBankCheckId(String bankCheckId);

	/**
	 * Gets a copy of this Tramite-Detalle as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ProcessOrderDetail toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ProcessOrderDetail processOrderDetail);

	public int hashCode();

	public String toString();

	public String toXmlString();
}