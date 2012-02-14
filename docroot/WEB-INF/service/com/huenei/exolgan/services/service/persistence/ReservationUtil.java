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

import com.huenei.exolgan.services.model.Reservation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the Reserva de salas service. This utility wraps {@link ReservationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see ReservationPersistence
 * @see ReservationPersistenceImpl
 * @generated
 */
public class ReservationUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Reservation reservation) {
		getPersistence().clearCache(reservation);
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
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Reservation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Reservation remove(Reservation reservation)
		throws SystemException {
		return getPersistence().remove(reservation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Reservation update(Reservation reservation, boolean merge)
		throws SystemException {
		return getPersistence().update(reservation, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Reservation update(Reservation reservation, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(reservation, merge, serviceContext);
	}

	/**
	* Caches the Reserva de salas in the entity cache if it is enabled.
	*
	* @param reservation the Reserva de salas to cache
	*/
	public static void cacheResult(
		com.huenei.exolgan.services.model.Reservation reservation) {
		getPersistence().cacheResult(reservation);
	}

	/**
	* Caches the Reserva de salases in the entity cache if it is enabled.
	*
	* @param reservations the Reserva de salases to cache
	*/
	public static void cacheResult(
		java.util.List<com.huenei.exolgan.services.model.Reservation> reservations) {
		getPersistence().cacheResult(reservations);
	}

	/**
	* Creates a new Reserva de salas with the primary key. Does not add the Reserva de salas to the database.
	*
	* @param reservationId the primary key for the new Reserva de salas
	* @return the new Reserva de salas
	*/
	public static com.huenei.exolgan.services.model.Reservation create(
		long reservationId) {
		return getPersistence().create(reservationId);
	}

	/**
	* Removes the Reserva de salas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the Reserva de salas to remove
	* @return the Reserva de salas that was removed
	* @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation remove(
		long reservationId)
		throws com.huenei.exolgan.services.NoSuchReservationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(reservationId);
	}

	public static com.huenei.exolgan.services.model.Reservation updateImpl(
		com.huenei.exolgan.services.model.Reservation reservation, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(reservation, merge);
	}

	/**
	* Finds the Reserva de salas with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchReservationException} if it could not be found.
	*
	* @param reservationId the primary key of the Reserva de salas to find
	* @return the Reserva de salas
	* @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation findByPrimaryKey(
		long reservationId)
		throws com.huenei.exolgan.services.NoSuchReservationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(reservationId);
	}

	/**
	* Finds the Reserva de salas with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reservationId the primary key of the Reserva de salas to find
	* @return the Reserva de salas, or <code>null</code> if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation fetchByPrimaryKey(
		long reservationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reservationId);
	}

	/**
	* Finds all the Reserva de salases.
	*
	* @return the Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.Reservation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the Reserva de salases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Reserva de salases to return
	* @param end the upper bound of the range of Reserva de salases to return (not inclusive)
	* @return the range of Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.Reservation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the Reserva de salases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of Reserva de salases to return
	* @param end the upper bound of the range of Reserva de salases to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.huenei.exolgan.services.model.Reservation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the Reserva de salases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the Reserva de salases.
	*
	* @return the number of Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ReservationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ReservationPersistence)PortletBeanLocatorUtil.locate(com.huenei.exolgan.services.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ReservationPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ReservationPersistence persistence) {
		_persistence = persistence;
	}

	private static ReservationPersistence _persistence;
}