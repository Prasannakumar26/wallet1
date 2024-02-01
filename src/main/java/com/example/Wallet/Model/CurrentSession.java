package com.example.Wallet.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="currentsession")
public class CurrentSession {

	
	@Override
	public String toString() {
		return "CurrentSession [userId=" + userId + ", uuid=" + uuid + ", localDateTIme=" + localDateTIme + "]";
	}
	public CurrentSession(Integer userId, String uuid, LocalDateTime localDateTIme) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDateTIme = localDateTIme;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public LocalDateTime getLocalDateTIme() {
		return localDateTIme;
	}
	public void setLocalDateTIme(LocalDateTime localDateTIme) {
		this.localDateTIme = localDateTIme;
	}
	@Id
	@Column(unique = true)
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTIme;
	
	
	public CurrentSession() {};
}
