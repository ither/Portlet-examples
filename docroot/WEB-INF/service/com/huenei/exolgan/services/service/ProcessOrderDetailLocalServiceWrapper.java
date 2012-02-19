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

/**
 * <p>
 * This class is a wrapper for {@link ProcessOrderDetailLocalService}.
 * </p>
 *
 * @author    prochas
 * @see       ProcessOrderDetailLocalService
 * @generated
 */
public class ProcessOrderDetailLocalServiceWrapper
	implements ProcessOrderDetailLocalService {
	public ProcessOrderDetailLocalServiceWrapper(
		ProcessOrderDetailLocalService processOrderDetailLocalService) {
		_processOrderDetailLocalService = processOrderDetailLocalService;
	}

	/**
	* Adds the Tramite-Detalle to the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to add
	* @return the Tramite-Detalle that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail addProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.addProcessOrderDetail(processOrderDetail);
	}

	/**
	* Creates a new Tramite-Detalle with the primary key. Does not add the Tramite-Detalle to the database.
	*
	* @param processDetailId the primary key for the new Tramite-Detalle
	* @return the new Tramite-Detalle
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail createProcessOrderDetail(
		long processDetailId) {
		return _processOrderDetailLocalService.createProcessOrderDetail(processDetailId);
	}

	/**
	* Deletes the Tramite-Detalle with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to delete
	* @throws PortalException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProcessOrderDetail(long processDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_processOrderDetailLocalService.deleteProcessOrderDetail(processDetailId);
	}

	/**
	* Deletes the Tramite-Detalle from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		_processOrderDetailLocalService.deleteProcessOrderDetail(processOrderDetail);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the Tramite-Detalle with the primary key.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to get
	* @return the Tramite-Detalle
	* @throws PortalException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail getProcessOrderDetail(
		long processDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.getProcessOrderDetail(processDetailId);
	}

	/**
	* Gets a range of all the Tramite-Detalles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Tramite-Detalles to return
	* @param end the upper bound of the range of Tramite-Detalles to return (not inclusive)
	* @return the range of Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.getProcessOrderDetails(start, end);
	}

	/**
	* Gets the number of Tramite-Detalles.
	*
	* @return the number of Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public int getProcessOrderDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.getProcessOrderDetailsCount();
	}

	/**
	* Updates the Tramite-Detalle in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to update
	* @return the Tramite-Detalle that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail updateProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.updateProcessOrderDetail(processOrderDetail);
	}

	/**
	* Updates the Tramite-Detalle in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to update
	* @param merge whether to merge the Tramite-Detalle with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Tramite-Detalle that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail updateProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrderDetailLocalService.updateProcessOrderDetail(processOrderDetail,
			merge);
	}

	public ProcessOrderDetailLocalService getWrappedProcessOrderDetailLocalService() {
		return _processOrderDetailLocalService;
	}

	private ProcessOrderDetailLocalService _processOrderDetailLocalService;
}