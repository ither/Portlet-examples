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

/**
 * <p>
 * This class is a wrapper for {@link ProcessOrder}.
 * </p>
 *
 * @author    prochas
 * @see       ProcessOrder
 * @generated
 */
public class ProcessOrderWrapper implements ProcessOrder {
	public ProcessOrderWrapper(ProcessOrder processOrder) {
		_processOrder = processOrder;
	}

	public long getPrimaryKey() {
		return _processOrder.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_processOrder.setPrimaryKey(pk);
	}

	public long getProcessOrderId() {
		return _processOrder.getProcessOrderId();
	}

	public void setProcessOrderId(long processOrderId) {
		_processOrder.setProcessOrderId(processOrderId);
	}

	public long getCompanyId() {
		return _processOrder.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_processOrder.setCompanyId(companyId);
	}

	public long getUserId() {
		return _processOrder.getUserId();
	}

	public void setUserId(long userId) {
		_processOrder.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrder.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_processOrder.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _processOrder.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_processOrder.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _processOrder.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_processOrder.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _processOrder.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_processOrder.setModifiedDate(modifiedDate);
	}

	public java.lang.String getCompanyName() {
		return _processOrder.getCompanyName();
	}

	public void setCompanyName(java.lang.String companyName) {
		_processOrder.setCompanyName(companyName);
	}

	public java.lang.String getCompanyAddress() {
		return _processOrder.getCompanyAddress();
	}

	public void setCompanyAddress(java.lang.String companyAddress) {
		_processOrder.setCompanyAddress(companyAddress);
	}

	public java.lang.String getCompanyContact() {
		return _processOrder.getCompanyContact();
	}

	public void setCompanyContact(java.lang.String companyContact) {
		_processOrder.setCompanyContact(companyContact);
	}

	public java.lang.String getProcessOrderDescription() {
		return _processOrder.getProcessOrderDescription();
	}

	public void setProcessOrderDescription(
		java.lang.String processOrderDescription) {
		_processOrder.setProcessOrderDescription(processOrderDescription);
	}

	public java.lang.String getProcessOrderFailedBy() {
		return _processOrder.getProcessOrderFailedBy();
	}

	public void setProcessOrderFailedBy(java.lang.String processOrderFailedBy) {
		_processOrder.setProcessOrderFailedBy(processOrderFailedBy);
	}

	public com.huenei.exolgan.services.model.ProcessOrder toEscapedModel() {
		return _processOrder.toEscapedModel();
	}

	public boolean isNew() {
		return _processOrder.isNew();
	}

	public void setNew(boolean n) {
		_processOrder.setNew(n);
	}

	public boolean isCachedModel() {
		return _processOrder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_processOrder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _processOrder.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_processOrder.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _processOrder.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processOrder.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _processOrder.clone();
	}

	public int compareTo(
		com.huenei.exolgan.services.model.ProcessOrder processOrder) {
		return _processOrder.compareTo(processOrder);
	}

	public int hashCode() {
		return _processOrder.hashCode();
	}

	public java.lang.String toString() {
		return _processOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _processOrder.toXmlString();
	}

	public java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails() {
		return _processOrder.getProcessOrderDetails();
	}

	public void setProcessOrderDetails(
		java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> poDetails) {
		_processOrder.setProcessOrderDetails(poDetails);
	}

	public ProcessOrder getWrappedProcessOrder() {
		return _processOrder;
	}

	private ProcessOrder _processOrder;
}