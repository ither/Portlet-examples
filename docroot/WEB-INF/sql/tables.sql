create table EXO_ProcessOrder (
	processOrderId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	companyName VARCHAR(75) null,
	companyAddress VARCHAR(75) null,
	companyContact VARCHAR(75) null,
	processOrderDescription VARCHAR(75) null,
	processOrderFailedBy VARCHAR(75) null
);

create table EXO_ProcessOrderDetail (
	processDetailId LONG not null primary key,
	processOrderId LONG,
	processDetailAmount LONG,
	bankCheck VARCHAR(75) null,
	bankCheckId VARCHAR(75) null
);

create table EXO_Reservation (
	reservationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	reservationTimestamp DATE null,
	reservationDurationHour LONG,
	reservationDurationMinute LONG,
	companyName VARCHAR(75) null,
	meetingRoom VARCHAR(75) null,
	visitNames VARCHAR(75) null,
	visitDocs VARCHAR(75) null
);