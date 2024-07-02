package com.example.BlogAppication.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int blogId;
    private String blogTitle;
    private String description;
    private String author;
   @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
   @Temporal(TemporalType.TIMESTAMP)//use when you want initialise it auto
    private Date updatedDate;
    @PrePersist
    protected void initialiseDate() {
        
        if (this.addedDate == null) {
            this.addedDate = new Date();
        }
      
        this.updatedDate = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
       
        this.updatedDate = new Date();
    }
    public Blog() {
    	
    }
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", description=" + description + ", author="
				+ author + ", addedDate=" + addedDate + ", updatedDate=" + updatedDate + "]";
	}
	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Blog(int blogId, String blogTitle, String description, String author) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.description = description;
		this.author = author;
	}
    
}
