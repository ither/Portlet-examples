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

import com.huenei.exolgan.services.model.ProcessOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the Tramite service. This utility wraps {@link ProcessOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ProcessOrderPersistence
 * @see ProcessOrderPersistenceImpl
 * @generated
 */
public class ProcessOrderUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ProcessOrder processOrder) {
		getPersistence().clearCache(processOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProcessOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ProcessOrder remove(ProcessOrder processOrder)
		throws SystemException {
		return getPersistence().remove(processOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProcessOrder update(ProcessOrder processOrder, boolean merge)
		throws SystemException {
		return getPersistence().update(processOrder, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProcessOrder update(ProcessOrder processOrder, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(processOrder, merge, serviceContext);
	}

	/**
	* Caches the Tramite in the entity cache if it is enabled.
	*
	* @param processOrder the Tramite to cache
	*/
	public static void cacheResult(
		com.huenei.exolgan.services.model.ProcessOrder processOrder) {
		getPersistence().cacheResult(processOrder);
	}

	/**
	* Caches the Tramites in the entity cache if it is enabled.
	*
	* @param processOrders the Tramites to cache
	*/
	public static void cacheResult(
		java.util.List<com.huenei.exolgan.services.model.ProcessOrder> processOrders) {
		getPersistence().cacheResult(processOrders);
	}

	/**
	* Creates a new Tramite with the primary key. Does not add the Tramite to the database.
	*
	* @param processOrderId the primary key for the new Tramite
	* @return the new Tramite
	*/
	public static com.huenei.exolgan.services.model.ProcessOrder create(
		long processOrderId) {
		return getPersistence().create(processOrderId);
	}

	/**
	* Removes the Tramite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderId the primary key of the Tramite to remove
	* @return the Tramite that was removed
	* @throws com.huenei.exolgan.services.NoSuchProcessOrderException if a Tramite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrder remove(
		long processOrderId)
		throws com.huenei.exolgan.services.NoSuchProcessOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(processOrderId);
	}

	public static com.huenei.exolgan.services.model.ProcessOrder updateImpl(
		com.huenei.exolgan.services.model.ProcessOrder processOrder,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(processOrder, merge);
	}

	/**
	* Finds the Tramite with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchProcessOrderException} if it could not be found.
	*
	* @param processOrderId the primary key of the Tramite to find
	* @return the Tramite
	* @throws com.huenei.exolgan.services.NoSuchProcessOrderException if a Tramite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrder findByPrimaryKey(
		long processOrderId)
		throws com.huenei.exolgan.services.NoSuchProcessOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(processOrderId);
	}

	/**
	* Finds the Tramite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param processOrderId the primary key of the Tramite to find
	* @return the Tramite, or <code>null</code> if a Tramite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrder fetchByPrimaryKey(
		long processOrderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(processOrderId);
	}

	/**
	* Finds all the Tramites.
	*
	* @return the Tramites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the Tramites.
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
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the Tramites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Tramites to return
	* @param end the upper bound of the range of Tramites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of Tramites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Tramites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the Tramites.
	*
	* @return the number of Tramites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the Tramite-Detalles associated with the Tramite.
	*
	* @param pk the primary key of the Tramite to get the associated Tramite-Detalles for
	* @return the Tramite-Detalles associated with the Tramite
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getProcessOrderDetails(pk);
	}

	/**
	* Gets a range of all the Tramite-Detalles associated with the Tramite.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the Tramite to get the associated Tramite-Detalles for
	* @param start the lower bound of the range of Tramites to return
	* @param end the upper bound of the range of Tramites to return (not inclusive)
	* @return the range of Tramite-Detalles associated with the Tramite
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getProcessOrderDetails(pk, start, end);
	}

	/**
	* Gets an ordered range of all the Tramite-Detalles associated with the Tramite.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the Tramite to get the associated Tramite-Detalles for
	* @param start the lower bound of the range of Tramites to return
	* @param end the upper bound of the range of Tramites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of Tramite-Detalles associated with the Tramite
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getProcessOrderDetails(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of Tramite-Detalles associated with the Tramite.
	*
	* @param pk the primary key of the Tramite to get the number of associated Tramite-Detalles for
	* @return the number of Tramite-Detalles associated with the Tramite
	* @throws SystemException if a system exception occurred
	*/
	public static int getProcessOrderDetailsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getProcessOrderDetailsSize(pk);
	}

	/**
	* Determines if the Tramite-Detalle is associated with the Tramite.
	*
	* @param pk the primary key of the Tramite
	* @param processOrderDetailPK the primary key of the Tramite-Detalle
	* @return <code>true</code> if the Tramite-Detalle is associated with the Tramite; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsProcessOrderDetail(long pk,
		long processOrderDetailPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .containsProcessOrderDetail(pk, processOrderDetailPK);
	}

	/**
	* Determines if the Tramite has any Tramite-Detalles associated with it.
	*
	* @param pk the primary key of the Tramite to check for associations with Tramite-Detalles
	* @return <code>true</code> if the Tramite has any Tramite-Detalles associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsProcessOrderDetails(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsProcessOrderDetails(pk);
	}

	public static ProcessOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProcessOrderPersistence)PortletBeanLocatorUtil.locate(com.huenei.exolgan.services.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ProcessOrderPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ProcessOrderPersistence persistence) {
		_persistence = persistence;
	}

	private static ProcessOrderPersistence _persistence;
}