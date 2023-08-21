package com.huytvb.car.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMovement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private int vehicleid;
	
	@ManyToOne
	@JoinColumn(name="locationid1", insertable=false, updatable=false)
	private Location location1;
	private int locationid1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date date1;
	
	@ManyToOne
	@JoinColumn(name="locationid2", insertable=false, updatable=false)
	private Location location2;
	private int locationid2;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")		
	private Date date2;

	private String remarks;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the vehicleid
	 */
	public int getVehicleid() {
		return vehicleid;
	}

	/**
	 * @param vehicleid the vehicleid to set
	 */
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	/**
	 * @return the location1
	 */
	public Location getLocation1() {
		return location1;
	}

	/**
	 * @param location1 the location1 to set
	 */
	public void setLocation1(Location location1) {
		this.location1 = location1;
	}

	/**
	 * @return the locationid1
	 */
	public int getLocationid1() {
		return locationid1;
	}

	/**
	 * @param locationid1 the locationid1 to set
	 */
	public void setLocationid1(int locationid1) {
		this.locationid1 = locationid1;
	}

	/**
	 * @return the date1
	 */
	public Date getDate1() {
		return date1;
	}

	/**
	 * @param date1 the date1 to set
	 */
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	/**
	 * @return the location2
	 */
	public Location getLocation2() {
		return location2;
	}

	/**
	 * @param location2 the location2 to set
	 */
	public void setLocation2(Location location2) {
		this.location2 = location2;
	}

	/**
	 * @return the locationid2
	 */
	public int getLocationid2() {
		return locationid2;
	}

	/**
	 * @param locationid2 the locationid2 to set
	 */
	public void setLocationid2(int locationid2) {
		this.locationid2 = locationid2;
	}

	/**
	 * @return the date2
	 */
	public Date getDate2() {
		return date2;
	}

	/**
	 * @param date2 the date2 to set
	 */
	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
