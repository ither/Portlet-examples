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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the Reserva de salas local service. This utility wraps {@link com.huenei.exolgan.services.service.impl.ReservationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.huenei.exolgan.services.service.impl.ReservationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author prochas
 * @see ReservationLocalService
 * @see com.huenei.exolgan.services.service.base.ReservationLocalServiceBaseImpl
 * @see com.huenei.exolgan.services.service.impl.ReservationLocalServiceImpl
 * @generated
 */
public class ReservationLocalServiceUtil {
	/**
	* Adds the Reserva de salas to the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the Reserva de salas to add
	* @return the Reserva de salas that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation addReservation(
		com.huenei.exolgan.services.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addReservation(reservation);
	}

	/**
	* Creates a new Reserva de salas with the primary key. Does not add the Reserva de salas to the database.
	*
	* @param reservationId the primary key for the new Reserva de salas
	* @return the new Reserva de salas
	*/
	public static com.huenei.exolgan.services.model.Reservation createReservation(
		long reservationId) {
		return getService().createReservation(reservationId);
	}

	/**
	* Deletes the Reserva de salas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reservationId the primary key of the Reserva de salas to delete
	* @throws PortalException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteReservation(long reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteReservation(reservationId);
	}

	/**
	* Deletes the Reserva de salas from the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the Reserva de salas to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteReservation(
		com.huenei.exolgan.services.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteReservation(reservation);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the Reserva de salas with the primary key.
	*
	* @param reservationId the primary key of the Reserva de salas to get
	* @return the Reserva de salas
	* @throws PortalException if a Reserva de salas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation getReservation(
		long reservationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservation(reservationId);
	}

	/**
	* Gets a range of all the Reserva de salases.
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
	public static java.util.List<com.huenei.exolgan.services.model.Reservation> getReservations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservations(start, end);
	}

	/**
	* Gets the number of Reserva de salases.
	*
	* @return the number of Reserva de salases
	* @throws SystemException if a system exception occurred
	*/
	public static int getReservationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getReservationsCount();
	}

	/**
	* Updates the Reserva de salas in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the Reserva de salas to update
	* @return the Reserva de salas that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation updateReservation(
		com.huenei.exolgan.services.model.Reservation reservation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateReservation(reservation);
	}

	/**
	* Updates the Reserva de salas in the database. Also notifies the appropriate model listeners.
	*
	* @param reservation the Reserva de salas to update
	* @param merge whether to merge the Reserva de salas with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Reserva de salas that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.Reservation updateReservation(
		com.huenei.exolgan.services.model.Reservation reservation, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateReservation(reservation, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ReservationLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ReservationLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ReservationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ReservationLocalService service) {
		_service = service;
	}

	private static ReservationLocalService _service;
}