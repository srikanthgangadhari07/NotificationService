package com.mybank.NotificationService.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notification {
	@Id
	@GeneratedValue
	private Long notificationId;
	
	@Column
	private String notifyTo;
	
	@Column
	private String status;
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotifyTo() {
		return notifyTo;
	}
	public void setNotifyTo(String notifyTo) {
		this.notifyTo = notifyTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", notifyTo=" + notifyTo + ", status=" + status + "]";
	}

}
