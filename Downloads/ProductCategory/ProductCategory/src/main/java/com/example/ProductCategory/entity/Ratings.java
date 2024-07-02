package com.example.ProductCategory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ratings {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private String userId;
	    private int rating;
	    public Ratings(String userId, int rating, String comment) {
			super();
			this.userId = userId;
			this.rating = rating;
			this.comment = comment;
		}

		private String comment;
	    
	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

	public Ratings(Long id, String userId, int rating, String comment) {
			super();
			this.id = id;
			this.userId = userId;
			this.rating = rating;
			this.comment = comment;
		}

	@Override
		public String toString() {
			return "Ratings [id=" + id + ", userId=" + userId + ", rating=" + rating + ", comment=" + comment + "]";
		}

	public Ratings() {
		
	}

}
