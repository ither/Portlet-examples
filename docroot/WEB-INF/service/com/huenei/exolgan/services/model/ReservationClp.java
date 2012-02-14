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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author prochas
 */
public class ReservationClp extends BaseModelImpl<Reservation>
	implements Reservation {
	public ReservationClp() {
	}

	public long getPrimaryKey() {
		return _reservationId;
	}

	public void setPrimaryKey(long pk) {
		setReservationId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_reservationId);
	}

	public long getReservationId() {
		return _reservationId;
	}

	public void setReservationId(long reservationId) {
		_reservationId = reservationId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getReservationTimestamp() {
		return _reservationTimestamp;
	}

	public void setReservationTimestamp(Date reservationTimestamp) {
		_reservationTimestamp = reservationTimestamp;
	}

	public long getReservationDuration() {
		return _reservationDuration;
	}

	public void setReservationDuration(long reservationDuration) {
		_reservationDuration = reservationDuration;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getMeetingRoom() {
		return _meetingRoom;
	}

	public void setMeetingRoom(String meetingRoom) {
		_meetingRoom = meetingRoom;
	}

	public String getVisitNames() {
		return _visitNames;
	}

	public void setVisitNames(String visitNames) {
		_visitNames = visitNames;
	}

	public String getVisitDocs() {
		return _visitDocs;
	}

	public void setVisitDocs(String visitDocs) {
		_visitDocs = visitDocs;
	}

	public Reservation toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Reservation)Proxy.newProxyInstance(Reservation.class.getClassLoader(),
				new Class[] { Reservation.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ReservationClp clone = new ReservationClp();

		clone.setReservationId(getReservationId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setReservationTimestamp(getReservationTimestamp());
		clone.setReservationDuration(getReservationDuration());
		clone.setCompanyName(getCompanyName());
		clone.setMeetingRoom(getMeetingRoom());
		clone.setVisitNames(getVisitNames());
		clone.setVisitDocs(getVisitDocs());

		return clone;
	}

	public int compareTo(Reservation reservation) {
		int value = 0;

		value = DateUtil.compareTo(getReservationTimestamp(),
				reservation.getReservationTimestamp());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ReservationClp reservation = null;

		try {
			reservation = (ReservationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = reservation.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{reservationId=");
		sb.append(getReservationId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", reservationTimestamp=");
		sb.append(getReservationTimestamp());
		sb.append(", reservationDuration=");
		sb.append(getReservationDuration());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", meetingRoom=");
		sb.append(getMeetingRoom());
		sb.append(", visitNames=");
		sb.append(getVisitNames());
		sb.append(", visitDocs=");
		sb.append(getVisitDocs());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.huenei.exolgan.services.model.Reservation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reservationId</column-name><column-value><![CDATA[");
		sb.append(getReservationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservationTimestamp</column-name><column-value><![CDATA[");
		sb.append(getReservationTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reservationDuration</column-name><column-value><![CDATA[");
		sb.append(getReservationDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>meetingRoom</column-name><column-value><![CDATA[");
		sb.append(getMeetingRoom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitNames</column-name><column-value><![CDATA[");
		sb.append(getVisitNames());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visitDocs</column-name><column-value><![CDATA[");
		sb.append(getVisitDocs());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _reservationId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _reservationTimestamp;
	private long _reservationDuration;
	private String _companyName;
	private String _meetingRoom;
	private String _visitNames;
	private String _visitDocs;
}