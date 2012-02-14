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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
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
		reservationImpl.setReservationDuration(reservation.getReservationDuration());
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
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_RESERVATION = "SELECT reservation FROM Reservation reservation";
	private static final String _SQL_COUNT_RESERVATION = "SELECT COUNT(reservation) FROM Reservation reservation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reservation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Reservation exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(ReservationPersistenceImpl.class);
}