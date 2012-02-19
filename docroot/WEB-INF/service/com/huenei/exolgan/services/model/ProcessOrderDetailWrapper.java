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
 * This class is a wrapper for {@link ProcessOrderDetail}.
 * </p>
 *
 * @author    prochas
 * @see       ProcessOrderDetail
 * @generated
 */
public class ProcessOrderDetailWrapper implements ProcessOrderDetail {
	public ProcessOrderDetailWrapper(ProcessOrderDetail processOrderDetail) {
		_processOrderDetail = processOrderDetail;
	}

	public long getPrimaryKey() {
		return _processOrderDetail.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_processOrderDetail.setPrimaryKey(pk);
	}

	public long getProcessDetailId() {
		return _processOrderDetail.getProcessDetailId();
	}

	public void setProcessDetailId(long processDetailId) {
		_processOrderDetail.setProcessDetailId(processDetailId);
	}

	public long getProcessDetailAmount() {
		return _processOrderDetail.getProcessDetailAmount();
	}

	public void setProcessDetailAmount(long processDetailAmount) {
		_processOrderDetail.setProcessDetailAmount(processDetailAmount);
	}

	public java.lang.String getBankCheck() {
		return _processOrderDetail.getBankCheck();
	}

	public void setBankCheck(java.lang.String bankCheck) {
		_processOrderDetail.setBankCheck(bankCheck);
	}

	public java.lang.String getBankCheckId() {
		return _processOrderDetail.getBankCheckId();
	}

	public void setBankCheckId(java.lang.String bankCheckId) {
		_processOrderDetail.setBankCheckId(bankCheckId);
	}

	public com.huenei.exolgan.services.model.ProcessOrderDetail toEscapedModel() {
		return _processOrderDetail.toEscapedModel();
	}

	public boolean isNew() {
		return _processOrderDetail.isNew();
	}

	public void setNew(boolean n) {
		_processOrderDetail.setNew(n);
	}

	public boolean isCachedModel() {
		return _processOrderDetail.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_processOrderDetail.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _processOrderDetail.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_processOrderDetail.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _processOrderDetail.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processOrderDetail.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processOrderDetail.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _processOrderDetail.clone();
	}

	public int compareTo(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail) {
		return _processOrderDetail.compareTo(processOrderDetail);
	}

	public int hashCode() {
		return _processOrderDetail.hashCode();
	}

	public java.lang.String toString() {
		return _processOrderDetail.toString();
	}

	public java.lang.String toXmlString() {
		return _processOrderDetail.toXmlString();
	}

	public ProcessOrderDetail getWrappedProcessOrderDetail() {
		return _processOrderDetail;
	}

	private ProcessOrderDetail _processOrderDetail;
}