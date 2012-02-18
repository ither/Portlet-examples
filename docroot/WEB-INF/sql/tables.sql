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