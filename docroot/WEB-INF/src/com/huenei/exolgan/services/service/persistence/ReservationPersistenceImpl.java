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

import com.huenei.exolgan.services.NoSuchReservationException;
import com.huenei.exolgan.services.model.Reservation;
import com.huenei.exolgan.services.model.impl.ReservationImpl;
import com.huenei.exolgan.services.model.impl.ReservationModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the Reserva de salas service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ReservationUtil} to access the Reserva de salas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ReservationPersistence
 * @see ReservationUtil
 * @generated
 */
public class ReservationPersistenceImpl extends BasePersistenceImpl<Reservation>
	implements ReservationPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ReservationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_ROOMOCCUPY = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByroomOccupy",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOMOCCUPY = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByroomOccupy",
			new String[] { String.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the Reserva de salas in the entity cache if it is enabled.
	 *
	 * @param reservation the Reserva de salas to cache
	 */
	public void cacheResult(Reservation reservation) {
		EntityCacheUtil.putResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey(), reservation);
	}

	/**
	 * Caches the Reserva de salases in the entity cache if it is enabled.
	 *
	 * @param reservations the Reserva de salases to cache
	 */
	public void cacheResult(List<Reservation> reservations) {
		for (Reservation reservation : reservations) {
			if (EntityCacheUtil.getResult(
						ReservationModelImpl.ENTITY_CACHE_ENABLED,
						ReservationImpl.class, reservation.getPrimaryKey(), this) == null) {
				cacheResult(reservation);
			}
		}
	}

	/**
	 * Clears the cache for all Reserva de salases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ReservationImpl.class.getName());
		EntityCacheUtil.clearCache(ReservationImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the Reserva de salas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Reservation reservation) {
		EntityCacheUtil.removeResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey());
	}

	/**
	 * Creates a new Reserva de salas with the primary key. Does not add the Reserva de salas to the database.
	 *
	 * @param reservationId the primary key for the new Reserva de salas
	 * @return the new Reserva de salas
	 */
	public Reservation create(long reservationId) {
		Reservation reservation = new ReservationImpl();

		reservation.setNew(true);
		reservation.setPrimaryKey(reservationId);

		return reservation;
	}

	/**
	 * Removes the Reserva de salas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Reserva de salas to remove
	 * @return the Reserva de salas that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the Reserva de salas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reservationId the primary key of the Reserva de salas to remove
	 * @return the Reserva de salas that was removed
	 * @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation remove(long reservationId)
		throws NoSuchReservationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Reservation reservation = (Reservation)session.get(ReservationImpl.class,
					new Long(reservationId));

			if (reservation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + reservationId);
				}

				throw new NoSuchReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					reservationId);
			}

			return remove(reservation);
		}
		catch (NoSuchReservationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation removeImpl(Reservation reservation)
		throws SystemException {
		reservation = toUnwrappedModel(reservation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, reservation);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey());

		return reservation;
	}

	public Reservation updateImpl(
		com.huenei.exolgan.services.model.Reservation reservation, boolean merge)
		throws SystemException {
		reservation = toUnwrappedModel(reservation);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, reservation, merge);

			reservation.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
			ReservationImpl.class, reservation.getPrimaryKey(), reservation);

		return reservation;
	}

	protected Reservation toUnwrappedModel(Reservation reservation) {
		if (reservation instanceof ReservationImpl) {
			return reservation;
		}

		ReservationImpl reservationImpl = new ReservationImpl();

		reservationImpl.setNew(reservation.isNew());
		reservationImpl.setPrimaryKey(reservation.getPrimaryKey());

		reservationImpl.setReservationId(reservation.getReservationId());
		reservationImpl.setCompanyId(reservation.getCompanyId());
		reservationImpl.setUserId(reservation.getUserId());
		reservationImpl.setUserName(reservation.getUserName());
		reservationImpl.setCreateDate(reservation.getCreateDate());
		reservationImpl.setModifiedDate(reservation.getModifiedDate());
		reservationImpl.setReservationTimestamp(reservation.getReservationTimestamp());
		reservationImpl.setReservationDurationHour(reservation.getReservationDurationHour());
		reservationImpl.setReservationDurationMinute(reservation.getReservationDurationMinute());
		reservationImpl.setCompanyName(reservation.getCompanyName());
		reservationImpl.setMeetingRoom(reservation.getMeetingRoom());
		reservationImpl.setVisitNames(reservation.getVisitNames());
		reservationImpl.setVisitDocs(reservation.getVisitDocs());

		return reservationImpl;
	}

	/**
	 * Finds the Reserva de salas with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Reserva de salas to find
	 * @return the Reserva de salas
	 * @throws com.liferay.portal.NoSuchModelException if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Reserva de salas with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchReservationException} if it could not be found.
	 *
	 * @param reservationId the primary key of the Reserva de salas to find
	 * @return the Reserva de salas
	 * @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByPrimaryKey(long reservationId)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = fetchByPrimaryKey(reservationId);

		if (reservation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + reservationId);
			}

			throw new NoSuchReservationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				reservationId);
		}

		return reservation;
	}

	/**
	 * Finds the Reserva de salas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Reserva de salas to find
	 * @return the Reserva de salas, or <code>null</code> if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Reserva de salas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reservationId the primary key of the Reserva de salas to find
	 * @return the Reserva de salas, or <code>null</code> if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation fetchByPrimaryKey(long reservationId)
		throws SystemException {
		Reservation reservation = (Reservation)EntityCacheUtil.getResult(ReservationModelImpl.ENTITY_CACHE_ENABLED,
				ReservationImpl.class, reservationId, this);

		if (reservation == null) {
			Session session = null;

			try {
				session = openSession();

				reservation = (Reservation)session.get(ReservationImpl.class,
						new Long(reservationId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (reservation != null) {
					cacheResult(reservation);
				}

				closeSession(session);
			}
		}

		return reservation;
	}

	/**
	 * Finds all the Reserva de salases where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @return the matching Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByroomOccupy(String meetingRoom,
		Date reservationTimestamp) throws SystemException {
		return findByroomOccupy(meetingRoom, reservationTimestamp,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the Reserva de salases where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @param start the lower bound of the range of Reserva de salases to return
	 * @param end the upper bound of the range of Reserva de salases to return (not inclusive)
	 * @return the range of matching Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByroomOccupy(String meetingRoom,
		Date reservationTimestamp, int start, int end)
		throws SystemException {
		return findByroomOccupy(meetingRoom, reservationTimestamp, start, end,
			null);
	}

	/**
	 * Finds an ordered range of all the Reserva de salases where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @param start the lower bound of the range of Reserva de salases to return
	 * @param end the upper bound of the range of Reserva de salases to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findByroomOccupy(String meetingRoom,
		Date reservationTimestamp, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				meetingRoom, reservationTimestamp,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROOMOCCUPY,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_RESERVATION_WHERE);

			if (meetingRoom == null) {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_1);
			}
			else {
				if (meetingRoom.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_2);
				}
			}

			if (reservationTimestamp == null) {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_1);
			}
			else {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ReservationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (meetingRoom != null) {
					qPos.add(meetingRoom);
				}

				if (reservationTimestamp != null) {
					qPos.add(CalendarUtil.getTimestamp(reservationTimestamp));
				}

				list = (List<Reservation>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ROOMOCCUPY,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROOMOCCUPY,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first Reserva de salas in the ordered set where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching Reserva de salas
	 * @throws com.huenei.exolgan.services.NoSuchReservationException if a matching Reserva de salas could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByroomOccupy_First(String meetingRoom,
		Date reservationTimestamp, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		List<Reservation> list = findByroomOccupy(meetingRoom,
				reservationTimestamp, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("meetingRoom=");
			msg.append(meetingRoom);

			msg.append(", reservationTimestamp=");
			msg.append(reservationTimestamp);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last Reserva de salas in the ordered set where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching Reserva de salas
	 * @throws com.huenei.exolgan.services.NoSuchReservationException if a matching Reserva de salas could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation findByroomOccupy_Last(String meetingRoom,
		Date reservationTimestamp, OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		int count = countByroomOccupy(meetingRoom, reservationTimestamp);

		List<Reservation> list = findByroomOccupy(meetingRoom,
				reservationTimestamp, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("meetingRoom=");
			msg.append(meetingRoom);

			msg.append(", reservationTimestamp=");
			msg.append(reservationTimestamp);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchReservationException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the Reserva de salases before and after the current Reserva de salas in the ordered set where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param reservationId the primary key of the current Reserva de salas
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next Reserva de salas
	 * @throws com.huenei.exolgan.services.NoSuchReservationException if a Reserva de salas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Reservation[] findByroomOccupy_PrevAndNext(long reservationId,
		String meetingRoom, Date reservationTimestamp,
		OrderByComparator orderByComparator)
		throws NoSuchReservationException, SystemException {
		Reservation reservation = findByPrimaryKey(reservationId);

		Session session = null;

		try {
			session = openSession();

			Reservation[] array = new ReservationImpl[3];

			array[0] = getByroomOccupy_PrevAndNext(session, reservation,
					meetingRoom, reservationTimestamp, orderByComparator, true);

			array[1] = reservation;

			array[2] = getByroomOccupy_PrevAndNext(session, reservation,
					meetingRoom, reservationTimestamp, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Reservation getByroomOccupy_PrevAndNext(Session session,
		Reservation reservation, String meetingRoom, Date reservationTimestamp,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESERVATION_WHERE);

		if (meetingRoom == null) {
			query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_1);
		}
		else {
			if (meetingRoom.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_3);
			}
			else {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_2);
			}
		}

		if (reservationTimestamp == null) {
			query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_1);
		}
		else {
			query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ReservationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (meetingRoom != null) {
			qPos.add(meetingRoom);
		}

		if (reservationTimestamp != null) {
			qPos.add(CalendarUtil.getTimestamp(reservationTimestamp));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(reservation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Reservation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the Reserva de salases.
	 *
	 * @return the Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public List<Reservation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Reservation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Reservation> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Reservation> list = (List<Reservation>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESERVATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESERVATION.concat(ReservationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Reservation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Reservation>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Reserva de salases where meetingRoom = &#63; and reservationTimestamp LIKE &#63; from the database.
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByroomOccupy(String meetingRoom, Date reservationTimestamp)
		throws SystemException {
		for (Reservation reservation : findByroomOccupy(meetingRoom,
				reservationTimestamp)) {
			remove(reservation);
		}
	}

	/**
	 * Removes all the Reserva de salases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Reservation reservation : findAll()) {
			remove(reservation);
		}
	}

	/**
	 * Counts all the Reserva de salases where meetingRoom = &#63; and reservationTimestamp LIKE &#63;.
	 *
	 * @param meetingRoom the meeting room to search with
	 * @param reservationTimestamp the reservation timestamp to search with
	 * @return the number of matching Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public int countByroomOccupy(String meetingRoom, Date reservationTimestamp)
		throws SystemException {
		Object[] finderArgs = new Object[] { meetingRoom, reservationTimestamp };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROOMOCCUPY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RESERVATION_WHERE);

			if (meetingRoom == null) {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_1);
			}
			else {
				if (meetingRoom.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_2);
				}
			}

			if (reservationTimestamp == null) {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_1);
			}
			else {
				query.append(_FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (meetingRoom != null) {
					qPos.add(meetingRoom);
				}

				if (reservationTimestamp != null) {
					qPos.add(CalendarUtil.getTimestamp(reservationTimestamp));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROOMOCCUPY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the Reserva de salases.
	 *
	 * @return the number of Reserva de salases
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESERVATION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the Reserva de salas persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.huenei.exolgan.services.model.Reservation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Reservation>> listenersList = new ArrayList<ModelListener<Reservation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Reservation>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ReservationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = ReservationPersistence.class)
	protected ReservationPersistence reservationPersistence;
	@BeanReference(type = ProcessOrderPersistence.class)
	protected ProcessOrderPersistence processOrderPersistence;
	@BeanReference(type = ProcessOrderDetailPersistence.class)
	protected ProcessOrderDetailPersistence processOrderDetailPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RESERVATION = "SELECT reservation FROM Reservation reservation";
	private static final String _SQL_SELECT_RESERVATION_WHERE = "SELECT reservation FROM Reservation reservation WHERE ";
	private static final String _SQL_COUNT_RESERVATION = "SELECT COUNT(reservation) FROM Reservation reservation";
	private static final String _SQL_COUNT_RESERVATION_WHERE = "SELECT COUNT(reservation) FROM Reservation reservation WHERE ";
	private static final String _FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_1 = "reservation.meetingRoom IS NULL AND ";
	private static final String _FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_2 = "reservation.meetingRoom = ? AND ";
	private static final String _FINDER_COLUMN_ROOMOCCUPY_MEETINGROOM_3 = "(reservation.meetingRoom IS NULL OR reservation.meetingRoom = ?) AND ";
	private static final String _FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_1 =
		"reservation.reservationTimestamp LIKE NULL";
	private static final String _FINDER_COLUMN_ROOMOCCUPY_RESERVATIONTIMESTAMP_2 =
		"reservation.reservationTimestamp LIKE ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reservation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Reservation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Reservation exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ReservationPersistenceImpl.class);
}