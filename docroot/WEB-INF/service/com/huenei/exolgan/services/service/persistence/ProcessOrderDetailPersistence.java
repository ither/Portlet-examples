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

package com.huenei.exolgan.services.service.persistence;

import com.huenei.exolgan.services.model.ProcessOrderDetail;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the Tramite-Detalle service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ProcessOrderDetailUtil} to access the Tramite-Detalle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ProcessOrderDetailPersistenceImpl
 * @see ProcessOrderDetailUtil
 * @generated
 */
public interface ProcessOrderDetailPersistence extends BasePersistence<ProcessOrderDetail> {
	/**
	* Caches the Tramite-Detalle in the entity cache if it is enabled.
	*
	* @param processOrderDetail the Tramite-Detalle to cache
	*/
	public void cacheResult(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail);

	/**
	* Caches the Tramite-Detalles in the entity cache if it is enabled.
	*
	* @param processOrderDetails the Tramite-Detalles to cache
	*/
	public void cacheResult(
		java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> processOrderDetails);

	/**
	* Creates a new Tramite-Detalle with the primary key. Does not add the Tramite-Detalle to the database.
	*
	* @param processDetailId the primary key for the new Tramite-Detalle
	* @return the new Tramite-Detalle
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail create(
		long processDetailId);

	/**
	* Removes the Tramite-Detalle with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to remove
	* @return the Tramite-Detalle that was removed
	* @throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail remove(
		long processDetailId)
		throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.huenei.exolgan.services.model.ProcessOrderDetail updateImpl(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the Tramite-Detalle with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchProcessOrderDetailException} if it could not be found.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to find
	* @return the Tramite-Detalle
	* @throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail findByPrimaryKey(
		long processDetailId)
		throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the Tramite-Detalle with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to find
	* @return the Tramite-Detalle, or <code>null</code> if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.ProcessOrderDetail fetchByPrimaryKey(
		long processDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the Tramite-Detalles.
	*
	* @return the Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the Tramite-Detalles.
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
	public java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the Tramite-Detalles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Tramite-Detalles to return
	* @param end the upper bound of the range of Tramite-Detalles to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Tramite-Detalles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the Tramite-Detalles.
	*
	* @return the number of Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}