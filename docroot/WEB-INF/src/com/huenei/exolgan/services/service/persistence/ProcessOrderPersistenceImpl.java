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

import com.huenei.exolgan.services.NoSuchProcessOrderException;
import com.huenei.exolgan.services.model.ProcessOrder;
import com.huenei.exolgan.services.model.impl.ProcessOrderImpl;
import com.huenei.exolgan.services.model.impl.ProcessOrderModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
 * The persistence implementation for the Tramite service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ProcessOrderUtil} to access the Tramite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ProcessOrderPersistence
 * @see ProcessOrderUtil
 * @generated
 */
public class ProcessOrderPersistenceImpl extends BasePersistenceImpl<ProcessOrder>
	implements ProcessOrderPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProcessOrderImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the Tramite in the entity cache if it is enabled.
	 *
	 * @param processOrder the Tramite to cache
	 */
	public void cacheResult(ProcessOrder processOrder) {
		EntityCacheUtil.putResult(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderImpl.class, processOrder.getPrimaryKey(), processOrder);
	}

	/**
	 * Caches the Tramites in the entity cache if it is enabled.
	 *
	 * @param processOrders the Tramites to cache
	 */
	public void cacheResult(List<ProcessOrder> processOrders) {
		for (ProcessOrder processOrder : processOrders) {
			if (EntityCacheUtil.getResult(
						ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
						ProcessOrderImpl.class, processOrder.getPrimaryKey(),
						this) == null) {
				cacheResult(processOrder);
			}
		}
	}

	/**
	 * Clears the cache for all Tramites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ProcessOrderImpl.class.getName());
		EntityCacheUtil.clearCache(ProcessOrderImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the Tramite.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ProcessOrder processOrder) {
		EntityCacheUtil.removeResult(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderImpl.class, processOrder.getPrimaryKey());
	}

	/**
	 * Creates a new Tramite with the primary key. Does not add the Tramite to the database.
	 *
	 * @param processOrderId the primary key for the new Tramite
	 * @return the new Tramite
	 */
	public ProcessOrder create(long processOrderId) {
		ProcessOrder processOrder = new ProcessOrderImpl();

		processOrder.setNew(true);
		processOrder.setPrimaryKey(processOrderId);

		return processOrder;
	}

	/**
	 * Removes the Tramite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tramite to remove
	 * @return the Tramite that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the Tramite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processOrderId the primary key of the Tramite to remove
	 * @return the Tramite that was removed
	 * @throws com.huenei.exolgan.services.NoSuchProcessOrderException if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder remove(long processOrderId)
		throws NoSuchProcessOrderException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProcessOrder processOrder = (ProcessOrder)session.get(ProcessOrderImpl.class,
					new Long(processOrderId));

			if (processOrder == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						processOrderId);
				}

				throw new NoSuchProcessOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					processOrderId);
			}

			return remove(processOrder);
		}
		catch (NoSuchProcessOrderException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcessOrder removeImpl(ProcessOrder processOrder)
		throws SystemException {
		processOrder = toUnwrappedModel(processOrder);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, processOrder);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderImpl.class, processOrder.getPrimaryKey());

		return processOrder;
	}

	public ProcessOrder updateImpl(
		com.huenei.exolgan.services.model.ProcessOrder processOrder,
		boolean merge) throws SystemException {
		processOrder = toUnwrappedModel(processOrder);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, processOrder, merge);

			processOrder.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderImpl.class, processOrder.getPrimaryKey(), processOrder);

		return processOrder;
	}

	protected ProcessOrder toUnwrappedModel(ProcessOrder processOrder) {
		if (processOrder instanceof ProcessOrderImpl) {
			return processOrder;
		}

		ProcessOrderImpl processOrderImpl = new ProcessOrderImpl();

		processOrderImpl.setNew(processOrder.isNew());
		processOrderImpl.setPrimaryKey(processOrder.getPrimaryKey());

		processOrderImpl.setProcessOrderId(processOrder.getProcessOrderId());
		processOrderImpl.setCompanyId(processOrder.getCompanyId());
		processOrderImpl.setUserId(processOrder.getUserId());
		processOrderImpl.setUserName(processOrder.getUserName());
		processOrderImpl.setCreateDate(processOrder.getCreateDate());
		processOrderImpl.setModifiedDate(processOrder.getModifiedDate());
		processOrderImpl.setCompanyName(processOrder.getCompanyName());
		processOrderImpl.setCompanyAddress(processOrder.getCompanyAddress());
		processOrderImpl.setCompanyContact(processOrder.getCompanyContact());
		processOrderImpl.setProcessOrderDescription(processOrder.getProcessOrderDescription());
		processOrderImpl.setProcessOrderFaliedBy(processOrder.getProcessOrderFaliedBy());

		return processOrderImpl;
	}

	/**
	 * Finds the Tramite with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tramite to find
	 * @return the Tramite
	 * @throws com.liferay.portal.NoSuchModelException if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Tramite with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchProcessOrderException} if it could not be found.
	 *
	 * @param processOrderId the primary key of the Tramite to find
	 * @return the Tramite
	 * @throws com.huenei.exolgan.services.NoSuchProcessOrderException if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder findByPrimaryKey(long processOrderId)
		throws NoSuchProcessOrderException, SystemException {
		ProcessOrder processOrder = fetchByPrimaryKey(processOrderId);

		if (processOrder == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + processOrderId);
			}

			throw new NoSuchProcessOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				processOrderId);
		}

		return processOrder;
	}

	/**
	 * Finds the Tramite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tramite to find
	 * @return the Tramite, or <code>null</code> if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Tramite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processOrderId the primary key of the Tramite to find
	 * @return the Tramite, or <code>null</code> if a Tramite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrder fetchByPrimaryKey(long processOrderId)
		throws SystemException {
		ProcessOrder processOrder = (ProcessOrder)EntityCacheUtil.getResult(ProcessOrderModelImpl.ENTITY_CACHE_ENABLED,
				ProcessOrderImpl.class, processOrderId, this);

		if (processOrder == null) {
			Session session = null;

			try {
				session = openSession();

				processOrder = (ProcessOrder)session.get(ProcessOrderImpl.class,
						new Long(processOrderId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (processOrder != null) {
					cacheResult(processOrder);
				}

				closeSession(session);
			}
		}

		return processOrder;
	}

	/**
	 * Finds all the Tramites.
	 *
	 * @return the Tramites
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProcessOrder> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ProcessOrder> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ProcessOrder> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ProcessOrder> list = (List<ProcessOrder>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROCESSORDER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESSORDER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProcessOrder>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProcessOrder>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Tramites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProcessOrder processOrder : findAll()) {
			remove(processOrder);
		}
	}

	/**
	 * Counts all the Tramites.
	 *
	 * @return the number of Tramites
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

				Query q = session.createQuery(_SQL_COUNT_PROCESSORDER);

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
	 * Gets all the Tramite-Detalles associated with the Tramite.
	 *
	 * @param pk the primary key of the Tramite to get the associated Tramite-Detalles for
	 * @return the Tramite-Detalles associated with the Tramite
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk) throws SystemException {
		return getProcessOrderDetails(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	public List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk, int start, int end) throws SystemException {
		return getProcessOrderDetails(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_PROCESSORDERDETAILS = new FinderPath(com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.FINDER_CACHE_ENABLED,
			com.huenei.exolgan.services.service.persistence.ProcessOrderDetailPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProcessOrderDetails",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

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
	public List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.huenei.exolgan.services.model.ProcessOrderDetail> list = (List<com.huenei.exolgan.services.model.ProcessOrderDetail>)FinderCacheUtil.getResult(FINDER_PATH_GET_PROCESSORDERDETAILS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETPROCESSORDERDETAILS.concat(ORDER_BY_CLAUSE)
													 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETPROCESSORDERDETAILS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("EXO_ProcessOrderDetail",
					com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.huenei.exolgan.services.model.ProcessOrderDetail>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_PROCESSORDERDETAILS,
						finderArgs);
				}
				else {
					processOrderDetailPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_PROCESSORDERDETAILS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_PROCESSORDERDETAILS_SIZE = new FinderPath(com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.FINDER_CACHE_ENABLED,
			com.huenei.exolgan.services.service.persistence.ProcessOrderDetailPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getProcessOrderDetailsSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of Tramite-Detalles associated with the Tramite.
	 *
	 * @param pk the primary key of the Tramite to get the number of associated Tramite-Detalles for
	 * @return the number of Tramite-Detalles associated with the Tramite
	 * @throws SystemException if a system exception occurred
	 */
	public int getProcessOrderDetailsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_PROCESSORDERDETAILS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETPROCESSORDERDETAILSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_PROCESSORDERDETAILS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_PROCESSORDERDETAIL = new FinderPath(com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl.FINDER_CACHE_ENABLED,
			com.huenei.exolgan.services.service.persistence.ProcessOrderDetailPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsProcessOrderDetail",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the Tramite-Detalle is associated with the Tramite.
	 *
	 * @param pk the primary key of the Tramite
	 * @param processOrderDetailPK the primary key of the Tramite-Detalle
	 * @return <code>true</code> if the Tramite-Detalle is associated with the Tramite; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsProcessOrderDetail(long pk, long processOrderDetailPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, processOrderDetailPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_PROCESSORDERDETAIL,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsProcessOrderDetail.contains(
							pk, processOrderDetailPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_PROCESSORDERDETAIL,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the Tramite has any Tramite-Detalles associated with it.
	 *
	 * @param pk the primary key of the Tramite to check for associations with Tramite-Detalles
	 * @return <code>true</code> if the Tramite has any Tramite-Detalles associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsProcessOrderDetails(long pk)
		throws SystemException {
		if (getProcessOrderDetailsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the Tramite persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.huenei.exolgan.services.model.ProcessOrder")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProcessOrder>> listenersList = new ArrayList<ModelListener<ProcessOrder>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProcessOrder>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsProcessOrderDetail = new ContainsProcessOrderDetail(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ProcessOrderImpl.class.getName());
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
	protected ContainsProcessOrderDetail containsProcessOrderDetail;

	protected class ContainsProcessOrderDetail {
		protected ContainsProcessOrderDetail(
			ProcessOrderPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSPROCESSORDERDETAIL,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long processOrderId, long processDetailId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(processOrderId), new Long(processDetailId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_PROCESSORDER = "SELECT processOrder FROM ProcessOrder processOrder";
	private static final String _SQL_COUNT_PROCESSORDER = "SELECT COUNT(processOrder) FROM ProcessOrder processOrder";
	private static final String _SQL_GETPROCESSORDERDETAILS = "SELECT {EXO_ProcessOrderDetail.*} FROM EXO_ProcessOrderDetail INNER JOIN EXO_ProcessOrder ON (EXO_ProcessOrder.processOrderId = EXO_ProcessOrderDetail.processOrderId) WHERE (EXO_ProcessOrder.processOrderId = ?)";
	private static final String _SQL_GETPROCESSORDERDETAILSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM EXO_ProcessOrderDetail WHERE processOrderId = ?";
	private static final String _SQL_CONTAINSPROCESSORDERDETAIL = "SELECT COUNT(*) AS COUNT_VALUE FROM EXO_ProcessOrderDetail WHERE processOrderId = ? AND processDetailId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "processOrder.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProcessOrder exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(ProcessOrderPersistenceImpl.class);
}