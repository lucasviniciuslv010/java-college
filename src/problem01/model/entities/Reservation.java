package problem01.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import problem01.model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {}
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (!checkIn.isAfter(now)) {
			throw new DomainException("The reservation date must be a future date");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("The check-out date must be after the check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		int days = 0;
		if (checkIn.getYear() == checkOut.getYear()) {
			days = checkOut.getDayOfYear() - checkIn.getDayOfYear();
		} else {
			LocalDate lastDayOfTheYear = LocalDate.of(checkIn.getYear(), 12, 31);
			days = (lastDayOfTheYear.getDayOfYear() - checkIn.getDayOfYear()) + checkOut.getDayOfYear();
		}
		return days;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate now = LocalDate.now();
		if (!checkIn.isAfter(now)) {
			throw new DomainException("The reservation date must be a future date");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("The check-out date must be after the check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ formatter.format(checkIn)
				+ ", check-out: "
				+ formatter.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}

}