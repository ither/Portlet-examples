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

import com.huenei.exolgan.services.NoSuchProcessOrderDetailException;
import com.huenei.exolgan.services.model.ProcessOrderDetail;
import com.huenei.exolgan.services.model.impl.ProcessOrderDetailImpl;
import com.huenei.exolgan.services.model.impl.ProcessOrderDetailModelImpl;

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
 * The persistence implementation for the Tramite-Detalle service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ProcessOrderDetailUtil} to access the Tramite-Detalle persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author prochas
 * @see ProcessOrderDetailPersistence
 * @see ProcessOrderDetailUtil
 * @generated
 */
public class ProcessOrderDetailPersistenceImpl extends BasePersistenceImpl<ProcessOrderDetail>
	implements ProcessOrderDetailPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ProcessOrderDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the Tramite-Detalle in the entity cache if it is enabled.
	 *
	 * @param processOrderDetail the Tramite-Detalle to cache
	 */
	public void cacheResult(ProcessOrderDetail processOrderDetail) {
		EntityCacheUtil.putResult(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailImpl.class, processOrderDetail.getPrimaryKey(),
			processOrderDetail);
	}

	/**
	 * Caches the Tramite-Detalles in the entity cache if it is enabled.
	 *
	 * @param processOrderDetails the Tramite-Detalles to cache
	 */
	public void cacheResult(List<ProcessOrderDetail> processOrderDetails) {
		for (ProcessOrderDetail processOrderDetail : processOrderDetails) {
			if (EntityCacheUtil.getResult(
						ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
						ProcessOrderDetailImpl.class,
						processOrderDetail.getPrimaryKey(), this) == null) {
				cacheResult(processOrderDetail);
			}
		}
	}

	/**
	 * Clears the cache for all Tramite-Detalles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ProcessOrderDetailImpl.class.getName());
		EntityCacheUtil.clearCache(ProcessOrderDetailImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the Tramite-Detalle.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ProcessOrderDetail processOrderDetail) {
		EntityCacheUtil.removeResult(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailImpl.class, processOrderDetail.getPrimaryKey());
	}

	/**
	 * Creates a new Tramite-Detalle with the primary key. Does not add the Tramite-Detalle to the database.
	 *
	 * @param processDetailId the primary key for the new Tramite-Detalle
	 * @return the new Tramite-Detalle
	 */
	public ProcessOrderDetail create(long processDetailId) {
		ProcessOrderDetail processOrderDetail = new ProcessOrderDetailImpl();

		processOrderDetail.setNew(true);
		processOrderDetail.setPrimaryKey(processDetailId);

		return processOrderDetail;
	}

	/**
	 * Removes the Tramite-Detalle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Tramite-Detalle to remove
	 * @return the Tramite-Detalle that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the Tramite-Detalle with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param processDetailId the primary key of the Tramite-Detalle to remove
	 * @return the Tramite-Detalle that was removed
	 * @throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail remove(long processDetailId)
		throws NoSuchProcessOrderDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProcessOrderDetail processOrderDetail = (ProcessOrderDetail)session.get(ProcessOrderDetailImpl.class,
					new Long(processDetailId));

			if (processOrderDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						processDetailId);
				}

				throw new NoSuchProcessOrderDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					processDetailId);
			}

			return remove(processOrderDetail);
		}
		catch (NoSuchProcessOrderDetailException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProcessOrderDetail removeImpl(
		ProcessOrderDetail processOrderDetail) throws SystemException {
		processOrderDetail = toUnwrappedModel(processOrderDetail);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, processOrderDetail);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailImpl.class, processOrderDetail.getPrimaryKey());

		return processOrderDetail;
	}

	public ProcessOrderDetail updateImpl(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail,
		boolean merge) throws SystemException {
		processOrderDetail = toUnwrappedModel(processOrderDetail);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, processOrderDetail, merge);

			processOrderDetail.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
			ProcessOrderDetailImpl.class, processOrderDetail.getPrimaryKey(),
			processOrderDetail);

		return processOrderDetail;
	}

	protected ProcessOrderDetail toUnwrappedModel(
		ProcessOrderDetail processOrderDetail) {
		if (processOrderDetail instanceof ProcessOrderDetailImpl) {
			return processOrderDetail;
		}

		ProcessOrderDetailImpl processOrderDetailImpl = new ProcessOrderDetailImpl();

		processOrderDetailImpl.setNew(processOrderDetail.isNew());
		processOrderDetailImpl.setPrimaryKey(processOrderDetail.getPrimaryKey());

		processOrderDetailImpl.setProcessDetailId(processOrderDetail.getProcessDetailId());
		processOrderDetailImpl.setProcessDetailAmount(processOrderDetail.getProcessDetailAmount());
		processOrderDetailImpl.setBankCheck(processOrderDetail.getBankCheck());
		processOrderDetailImpl.setBankCheckId(processOrderDetail.getBankCheckId());

		return processOrderDetailImpl;
	}

	/**
	 * Finds the Tramite-Detalle with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tramite-Detalle to find
	 * @return the Tramite-Detalle
	 * @throws com.liferay.portal.NoSuchModelException if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Tramite-Detalle with the primary key or throws a {@link com.huenei.exolgan.services.NoSuchProcessOrderDetailException} if it could not be found.
	 *
	 * @param processDetailId the primary key of the Tramite-Detalle to find
	 * @return the Tramite-Detalle
	 * @throws com.huenei.exolgan.services.NoSuchProcessOrderDetailException if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail findByPrimaryKey(long processDetailId)
		throws NoSuchProcessOrderDetailException, SystemException {
		ProcessOrderDetail processOrderDetail = fetchByPrimaryKey(processDetailId);

		if (processOrderDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + processDetailId);
			}

			throw new NoSuchProcessOrderDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				processDetailId);
		}

		return processOrderDetail;
	}

	/**
	 * Finds the Tramite-Detalle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Tramite-Detalle to find
	 * @return the Tramite-Detalle, or <code>null</code> if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the Tramite-Detalle with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param processDetailId the primary key of the Tramite-Detalle to find
	 * @return the Tramite-Detalle, or <code>null</code> if a Tramite-Detalle with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProcessOrderDetail fetchByPrimaryKey(long processDetailId)
		throws SystemException {
		ProcessOrderDetail processOrderDetail = (ProcessOrderDetail)EntityCacheUtil.getResult(ProcessOrderDetailModelImpl.ENTITY_CACHE_ENABLED,
				ProcessOrderDetailImpl.class, processDetailId, this);

		if (processOrderDetail == null) {
			Session session = null;

			try {
				session = openSession();

				processOrderDetail = (ProcessOrderDetail)session.get(ProcessOrderDetailImpl.class,
						new Long(processDetailId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (processOrderDetail != null) {
					cacheResult(processOrderDetail);
				}

				closeSession(session);
			}
		}

		return processOrderDetail;
	}

	/**
	 * Finds all the Tramite-Detalles.
	 *
	 * @return the Tramite-Detalles
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProcessOrderDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<ProcessOrderDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<ProcessOrderDetail> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ProcessOrderDetail> list = (List<ProcessOrderDetail>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROCESSORDERDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROCESSORDERDETAIL;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProcessOrderDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProcessOrderDetail>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the Tramite-Detalles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProcessOrderDetail processOrderDetail : findAll()) {
			remove(processOrderDetail);
		}
	}

	/**
	 * Counts all the Tramite-Detalles.
	 *
	 * @return the number of Tramite-Detalles
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

				Query q = session.createQuery(_SQL_COUNT_PROCESSORDERDETAIL);

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
	 * Initializes the Tramite-Detalle persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.huenei.exolgan.services.model.ProcessOrderDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProcessOrderDetail>> listenersList = new ArrayList<ModelListener<ProcessOrderDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProcessOrderDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProcessOrderDetailImpl.class.getName());
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
	private static final String _SQL_SELECT_PROCESSORDERDETAIL = "SELECT processOrderDetail FROM ProcessOrderDetail processOrderDetail";
	private static final String _SQL_COUNT_PROCESSORDERDETAIL = "SELECT COUNT(processOrderDetail) FROM ProcessOrderDetail processOrderDetail";
	private static final String _ORDER_BY_ENTITY_ALIAS = "processOrderDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProcessOrderDetail exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(ProcessOrderDetailPersistenceImpl.class);
}