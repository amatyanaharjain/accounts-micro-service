package com.naharamatya.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@Column(updatable = false)
	private String createdBy;
	@Column(insertable = false)
	private LocalDateTime updatedAt;
	@Column(insertable = false)
	private String updatedBy;
}
