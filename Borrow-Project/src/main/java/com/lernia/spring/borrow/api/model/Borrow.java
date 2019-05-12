package com.lernia.spring.borrow.api.model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "borrow_requests")
@DynamicUpdate
public class Borrow {

	@Id
	@Column(name = "borrow_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int borrowId;

	// @NotNull
	@Column(name = "user_id")
	private int userId;

	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Column(name = "requested_amount")
	private int requestedAmount;

	@NotNull
	@Column(name = "period")
	private int period;

	@NotNull
	@Column(name = "requested_date")
	private LocalDate requestedDate;

	@NotNull
	@Column(name = "requested_time")
	private Instant requestedTime;

	@NotNull
	@Column(name = "eligible")
	private Boolean eligible;

	@NotNull
	@Column(name = "reason")
	private String reason;

	public enum Status {
		PENDING, REJECTED, APPROVED
	}

	@NotNull
	@Column(name = "status")
	private String status;

	public Borrow(@NotNull int requested_amount, @NotNull int period, @NotNull String reason) {
		super();
		this.requestedAmount = requested_amount;
		this.period = period;
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Borrow [borrow_id=" + borrowId + ", user_id=" + userId + ", user_name=" + userName
				+ ", requested_amount=" + requestedAmount + ", period=" + period + ", requested_date=" + requestedDate
				+ ", requested_time=" + requestedTime + ", eligible=" + eligible + ", reason=" + reason + ", status="
				+ status + "]";
	}

}
