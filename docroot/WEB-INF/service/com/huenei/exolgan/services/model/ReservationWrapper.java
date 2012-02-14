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

package com.huenei.exolgan.services.model;

/**
 * <p>
 * This class is a wrapper for {@link Reservation}.
 * </p>
 *
 * @author    prochas
 * @see       Reservation
 * @generated
 */
public class ReservationWrapper implements Reservation {
	public ReservationWrapper(Reservation reservation) {
		_reservation = reservation;
	}

	public long getPrimaryKey() {
		return _reservation.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_reservation.setPrimaryKey(pk);
	}

	public long getReservationId() {
		return _reservation.getReservationId();
	}

	public void setReservationId(long reservationId) {
		_reservation.setReservationId(reservationId);
	}

	public long getCompanyId() {
		return _reservation.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_reservation.setCompanyId(companyId);
	}

	public long getUserId() {
		return _reservation.getUserId();
	}

	public void setUserId(long userId) {
		_reservation.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reservation.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_reservation.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _reservation.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_reservation.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _reservation.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_reservation.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _reservation.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_reservation.setModifiedDate(modifiedDate);
	}

	public java.util.Date getReservationTimestamp() {
		return _reservation.getReservationTimestamp();
	}

	public void setReservationTimestamp(java.util.Date reservationTimestamp) {
		_reservation.setReservationTimestamp(reservationTimestamp);
	}

	public long getReservationDuration() {
		return _reservation.getReservationDuration();
	}

	public void setReservationDuration(long reservationDuration) {
		_reservation.setReservationDuration(reservationDuration);
	}

	public java.lang.String getCompanyName() {
		return _reservation.getCompanyName();
	}

	public void setCompanyName(java.lang.String companyName) {
		_reservation.setCompanyName(companyName);
	}

	public java.lang.String getMeetingRoom() {
		return _reservation.getMeetingRoom();
	}

	public void setMeetingRoom(java.lang.String meetingRoom) {
		_reservation.setMeetingRoom(meetingRoom);
	}

	public java.lang.String getVisitNames() {
		return _reservation.getVisitNames();
	}

	public void setVisitNames(java.lang.String visitNames) {
		_reservation.setVisitNames(visitNames);
	}

	public java.lang.String getVisitDocs() {
		return _reservation.getVisitDocs();
	}

	public void setVisitDocs(java.lang.String visitDocs) {
		_reservation.setVisitDocs(visitDocs);
	}

	public Reservation toEscapedModel() {
		return _reservation.toEscapedModel();
	}

	public boolean isNew() {
		return _reservation.isNew();
	}

	public void setNew(boolean n) {
		_reservation.setNew(n);
	}

	public boolean isCachedModel() {
		return _reservation.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_reservation.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _reservation.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_reservation.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _reservation.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reservation.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reservation.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _reservation.clone();
	}

	public int compareTo(Reservation reservation) {
		return _reservation.compareTo(reservation);
	}

	public int hashCode() {
		return _reservation.hashCode();
	}

	public java.lang.String toString() {
		return _reservation.toString();
	}

	public java.lang.String toXmlString() {
		return _reservation.toXmlString();
	}

	public Reservation getWrappedReservation() {
		return _reservation;
	}

	private Reservation _reservation;
}