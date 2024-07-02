package com.example.BlogAppication.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.parsing.Location;

@Entity
public class Instagram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	private String userId;
	private String username;
	private String caption;
	private String location;
	@ElementCollection
	private List<String> hashtags;
	@ElementCollection
	private List<String> mentions;
	 
	private LocalDateTime addedDate;

	private LocalDateTime updatedDate;
	@PrePersist
	protected void onCreate() {

		if (this.addedDate == null) {
			this.addedDate = LocalDateTime.now();
		}

		this.updatedDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {

		this.updatedDate = LocalDateTime.now();
	}
	public Instagram() {
		
	}
	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}

	public List<String> getMentions() {
		return mentions;
	}

	public void setMentions(List<String> mentions) {
		this.mentions = mentions;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	@Override
	public String toString() {
		return "Instagram [postId=" + postId + ", userId=" + userId + ", username=" + username + ", caption=" + caption
				+ ", location=" + location + ", hashtags=" + hashtags + ", mentions=" + mentions + ", addedDate="
				+ addedDate + ", updatedDate=" + updatedDate + "]";
	}
}
