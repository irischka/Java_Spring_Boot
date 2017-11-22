package ua.entity;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment extends AbstractEntity {
	
	private String comment;
	
	@Column(name="sender_id")
	private Integer senderId;
	
	private String senderName;
	
	private String photoUrl;
		
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getComment() {
		return comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
}
