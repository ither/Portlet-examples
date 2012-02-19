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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the Tramite local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ProcessOrderLocalServiceUtil} to access the Tramite local service. Add custom service methods to {@link com.huenei.exolgan.services.service.impl.ProcessOrderLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author prochas
 * @see ProcessOrderLocalServiceUtil
 * @see com.huenei.exolgan.services.service.base.ProcessOrderLocalServiceBaseImpl
 * @see com.huenei.exolgan.services.service.impl.ProcessOrderLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProcessOrderLocalService {
	/**
	* Adds the Tramite to the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the Tramite to add
	* @return the Tramite that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrder addProcessOrder(
		com.huenei.exolgan.services.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new Tramite with the primary key. Does not add the Tramite to the database.
	*
	* @param processOrderId the primary key for the new Tramite
	* @return the new Tramite
	*/
	public com.huenei.exolgan.services.model.ProcessOrder createProcessOrder(
		long processOrderId);

	/**
	* Deletes the Tramite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderId the primary key of the Tramite to delete
	* @throws PortalException if a Tramite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProcessOrder(long processOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the Tramite from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the Tramite to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteProcessOrder(
		com.huenei.exolgan.services.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the Tramite with the primary key.
	*
	* @param processOrderId the primary key of the Tramite to get
	* @return the Tramite
	* @throws PortalException if a Tramite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.huenei.exolgan.services.model.ProcessOrder getProcessOrder(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the Tramites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Tramites to return
	* @param end the upper bound of the range of Tramites to return (not inclusive)
	* @return the range of Tramites
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.huenei.exolgan.services.model.ProcessOrder> getProcessOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of Tramites.
	*
	* @return the number of Tramites
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProcessOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the Tramite in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the Tramite to update
	* @return the Tramite that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrder updateProcessOrder(
		com.huenei.exolgan.services.model.ProcessOrder processOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the Tramite in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrder the Tramite to update
	* @param merge whether to merge the Tramite with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Tramite that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrder updateProcessOrder(
		com.huenei.exolgan.services.model.ProcessOrder processOrder,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;
}