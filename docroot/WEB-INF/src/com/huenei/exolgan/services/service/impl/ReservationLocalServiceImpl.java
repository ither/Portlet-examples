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

package com.huenei.exolgan.services.service.impl;

import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.service.base.ReservationLocalServiceBaseImpl;
import com.huenei.exolgan.services.service.persistence.ReservationPersistence;
import com.huenei.exolgan.services.service.persistence.ReservationPersistenceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the Reserva de salas local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.huenei.exolgan.services.service.ReservationLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.huenei.exolgan.services.service.ReservationLocalServiceUtil} to access the Reserva de salas local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author prochas
 * @see com.huenei.exolgan.services.service.base.ReservationLocalServiceBaseImpl
 * @see com.huenei.exolgan.services.service.ReservationLocalServiceUtil
 */
public class ReservationLocalServiceImpl extends ReservationLocalServiceBaseImpl 
{
    public Reservation addReservation(Reservation newRes, long userId) throws SystemException, PortalException
    {
        Reservation reservation = reservationPersistence.create(counterLocalService.increment(Reservation.class.getName()));
        
        return reservation;        
    }
}