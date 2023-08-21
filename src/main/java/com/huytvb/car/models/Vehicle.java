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
public class Vehicle {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	@ManyToOne
	@JoinColumn(name="vehicletypeid", insertable=false, updatable=false)
	private VehicleType vehicleType;
	private Integer vehicletypeid;	
	
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="vehiclemakeid", insertable=false, updatable=false)
	private VehicleMake vehicleMake;
	private Integer vehiclemakeid;
	
	private String power;
	private String fuelCapacity;
	@ManyToOne
	@JoinColumn(name="vehiclestatusid", insertable=false, updatable=false)
	private VehicleStatus vehicleStatus;
	private Integer vehiclestatusid;	
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the vehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the vehicletypeid
	 */
	public Integer getVehicletypeid() {
		return vehicletypeid;
	}

	/**
	 * @param vehicletypeid the vehicletypeid to set
	 */
	public void setVehicletypeid(Integer vehicletypeid) {
		this.vehicletypeid = vehicletypeid;
	}

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the acquisitionDate
	 */
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	/**
	 * @param acquisitionDate the acquisitionDate to set
	 */
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the vehicleMake
	 */
	public VehicleMake getVehicleMake() {
		return vehicleMake;
	}

	/**
	 * @param vehicleMake the vehicleMake to set
	 */
	public void setVehicleMake(VehicleMake vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	/**
	 * @return the vehiclemakeid
	 */
	public Integer getVehiclemakeid() {
		return vehiclemakeid;
	}

	/**
	 * @param vehiclemakeid the vehiclemakeid to set
	 */
	public void setVehiclemakeid(Integer vehiclemakeid) {
		this.vehiclemakeid = vehiclemakeid;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}

	/**
	 * @return the fuelCapacity
	 */
	public String getFuelCapacity() {
		return fuelCapacity;
	}

	/**
	 * @param fuelCapacity the fuelCapacity to set
	 */
	public void setFuelCapacity(String fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * @return the vehicleStatus
	 */
	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	/**
	 * @param vehicleStatus the vehicleStatus to set
	 */
	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	/**
	 * @return the vehiclestatusid
	 */
	public Integer getVehiclestatusid() {
		return vehiclestatusid;
	}

	/**
	 * @param vehiclestatusid the vehiclestatusid to set
	 */
	public void setVehiclestatusid(Integer vehiclestatusid) {
		this.vehiclestatusid = vehiclestatusid;
	}

	/**
	 * @return the netWeight
	 */
	public String getNetWeight() {
		return netWeight;
	}

	/**
	 * @param netWeight the netWeight to set
	 */
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	/**
	 * @return the inCharge
	 */
	public Employee getInCharge() {
		return inCharge;
	}

	/**
	 * @param inCharge the inCharge to set
	 */
	public void setInCharge(Employee inCharge) {
		this.inCharge = inCharge;
	}

	/**
	 * @return the employeeid
	 */
	public Integer getEmployeeid() {
		return employeeid;
	}

	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @return the vehicleModel
	 */
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	/**
	 * @param vehicleModel the vehicleModel to set
	 */
	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * @return the vehiclemodelid
	 */
	public Integer getVehiclemodelid() {
		return vehiclemodelid;
	}

	/**
	 * @param vehiclemodelid the vehiclemodelid to set
	 */
	public void setVehiclemodelid(Integer vehiclemodelid) {
		this.vehiclemodelid = vehiclemodelid;
	}

	/**
	 * @return the currentLocation
	 */
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * @return the locationid
	 */
	public Integer getLocationid() {
		return locationid;
	}

	/**
	 * @param locationid the locationid to set
	 */
	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
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

	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee inCharge;
	private Integer employeeid;
	
	@ManyToOne
	@JoinColumn(name="vehiclemodelid", insertable=false, updatable=false)
	private VehicleModel vehicleModel;	
	private Integer vehiclemodelid;

	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Integer locationid;
	
	private String remarks;	
}
