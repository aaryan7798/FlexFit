package com.flexfit.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GymOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String gymName;
    private String contactNumber;
    private String address;
    private String subscriptionStatus;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
    private Double subscriptionAmount;
    private String gymFacilities;
    private String gymPhotos;       // store comma-separated file names
    private String trainerPhotos;   // store comma-separated file names
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
	public LocalDate getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setSubscriptionStart(LocalDate subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}
	public void setSubscriptionEnd(LocalDate subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}
	public Double getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public void setSubscriptionAmount(Double subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	public String getGymFacilities() {
		return gymFacilities;
	}
	public void setGymFacilities(String gymFacilities) {
		this.gymFacilities = gymFacilities;
	}
	public String getGymPhotos() {
		return gymPhotos;
	}
	public void setGymPhotos(String gymPhotos) {
		this.gymPhotos = gymPhotos;
	}
	public String getTrainerPhotos() {
		return trainerPhotos;
	}
	public void setTrainerPhotos(String trainerPhotos) {
		this.trainerPhotos = trainerPhotos;
	}

    // Getters and setters for all fields
}
