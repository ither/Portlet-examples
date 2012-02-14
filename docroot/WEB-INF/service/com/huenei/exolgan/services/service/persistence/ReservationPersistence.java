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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the Reserva de salas service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ReservationUtil} to access the Reserva de salas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ReservationPersistenceImpl
 * @see ReservationUtil
 * @generated
 */
public interface ReservationPersistence extends BasePersistence<Reservation> {
	/**
	* Caches the Reserva de salas in the entity cache if it is enabled.
	*
	* @param reservation the Reserva de salas to cache
	*/
	public void cacheResult(
		com.huenei.exolgan.services.model.Reservation reservation);

	/**
	* Caches the Reserva de salases in the entity cache if it is enabled.
	*
	* @param reservations the Reserva de salases to cache
	*/
	public void cacheResult(
		java.util.List<com.huenei.exolgan.services.model.Reservation> reservations);

	/**
	* Creates a new Reserva de salas with the primary key. Does not add the Reserva de salas to the database.
	*
	* @param reservationId the primary key for the new Reserva de salas
	* @return the new Reserva de salas
	*/
	public com.huenei.exolgan.services.model.Reservation create(
		long reservationId);

	/**
	* Removes the Reserva de salas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the Reserva de salas to remove
	* @return the Reserva de salas that was removed
	* @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.Reservation remove(
		long reservationId)
		throws com.huenei.exolgan.services.NoSuchReservationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.huenei.exolgan.services.model.Reservation updateImpl(
		com.huenei.exolgan.services.model.Reservation reservation, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the Reserva de salas with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchReservationException} if it could not be found.
	*
	* @param reservationId the primary key of the Reserva de salas to find
	* @return the Reserva de salas
	* @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.Reservation findByPrimaryKey(
		long reservationId)
		throws com.huenei.exolgan.services.NoSuchReservationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the Reserva de salas with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reservationId the primary key of the Reserva de salas to find
	* @return the Reserva de salas, or <code>null</code> if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.huenei.exolgan.services.model.Reservation fetchByPrimaryKey(
		long reservationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the Reserva de salases.
	*
	* @return the Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.huenei.exolgan.services.model.Reservation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.huenei.exolgan.services.model.Reservation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.huenei.exolgan.services.model.Reservation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Reserva de salases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the Reserva de salases.
	*
	* @return the number of Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}