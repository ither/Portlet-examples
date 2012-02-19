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
 * The utility for the Tramite-Detalle local service. This utility wraps {@link com.huenei.exolgan.services.service.impl.ProcessOrderDetailLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.huenei.exolgan.services.service.impl.ProcessOrderDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author prochas
 * @see ProcessOrderDetailLocalService
 * @see com.huenei.exolgan.services.service.base.ProcessOrderDetailLocalServiceBaseImpl
 * @see com.huenei.exolgan.services.service.impl.ProcessOrderDetailLocalServiceImpl
 * @generated
 */
public class ProcessOrderDetailLocalServiceUtil {
	/**
	* Adds the Tramite-Detalle to the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to add
	* @return the Tramite-Detalle that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrderDetail addProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProcessOrderDetail(processOrderDetail);
	}

	/**
	* Creates a new Tramite-Detalle with the primary key. Does not add the Tramite-Detalle to the database.
	*
	* @param processDetailId the primary key for the new Tramite-Detalle
	* @return the new Tramite-Detalle
	*/
	public static com.huenei.exolgan.services.model.ProcessOrderDetail createProcessOrderDetail(
		long processDetailId) {
		return getService().createProcessOrderDetail(processDetailId);
	}

	/**
	* Deletes the Tramite-Detalle with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to delete
	* @throws PortalException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteProcessOrderDetail(long processDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProcessOrderDetail(processDetailId);
	}

	/**
	* Deletes the Tramite-Detalle from the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProcessOrderDetail(processOrderDetail);
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
	* Gets the Tramite-Detalle with the primary key.
	*
	* @param processDetailId the primary key of the Tramite-Detalle to get
	* @return the Tramite-Detalle
	* @throws PortalException if a Tramite-Detalle with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrderDetail getProcessOrderDetail(
		long processDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessOrderDetail(processDetailId);
	}

	/**
	* Gets a range of all the Tramite-Detalles.
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
	public static java.util.List<com.huenei.exolgan.services.model.ProcessOrderDetail> getProcessOrderDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessOrderDetails(start, end);
	}

	/**
	* Gets the number of Tramite-Detalles.
	*
	* @return the number of Tramite-Detalles
	* @throws SystemException if a system exception occurred
	*/
	public static int getProcessOrderDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProcessOrderDetailsCount();
	}

	/**
	* Updates the Tramite-Detalle in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to update
	* @return the Tramite-Detalle that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrderDetail updateProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProcessOrderDetail(processOrderDetail);
	}

	/**
	* Updates the Tramite-Detalle in the database. Also notifies the appropriate model listeners.
	*
	* @param processOrderDetail the Tramite-Detalle to update
	* @param merge whether to merge the Tramite-Detalle with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the Tramite-Detalle that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.huenei.exolgan.services.model.ProcessOrderDetail updateProcessOrderDetail(
		com.huenei.exolgan.services.model.ProcessOrderDetail processOrderDetail,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProcessOrderDetail(processOrderDetail, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static ProcessOrderDetailLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ProcessOrderDetailLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ProcessOrderDetailLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ProcessOrderDetailLocalService service) {
		_service = service;
	}

	private static ProcessOrderDetailLocalService _service;
}