package com.naharamatya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {
	
	@Column(nullable = false)
	private Long customerId;
	
	@Id
	private Long accountNo;
	
	@Column(nullable = false)
	private String account_type;
	
	@Column(nullable = false)
	private String branch_address;

}
