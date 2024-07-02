package com.example.BlogAppication.repository;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.BlogAppication.entity.Blog;

@Repository
public class BlogRepository {
@Autowired
SessionFactory factory;
	public String save(Blog blog) {
	Session session=factory.openSession();
	Transaction tr=session.beginTransaction();
	 try {
		 session.save(blog);
		 tr.commit();
		 return "saves successfuly";
	} catch (Exception e) {
		return "failed to save";
	}
	
		
	}
	public Map<String, Blog> update(Blog blog, int id) {
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		Map<String, Blog> map=new HashMap<>();
		 try {Blog blog1=session.get(Blog.class, id);
		 if(blog1!=null) {
			blog1.setAuthor(blog.getAuthor());
			blog1.setBlogTitle(blog.getBlogTitle());
			blog1.setDescription(blog.getDescription());
			 session.save(blog1);
			 tr.commit();
			map.put("updated successfuly", blog1);}else {
				map.put("failed to update", null);
			}
		
		} catch (Exception e) {
				e.printStackTrace();
		}
		return map;
	}
	public String delete(int id) {
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		Blog blog=session.get(Blog.class, id);
		if(blog!=null) {
			try {
				session.delete(blog);
				tr.commit();
				return "deleted succssfully";
			} catch (Exception e) {
				e.printStackTrace();
				return "Something went wrong";
			}
			
		}else {
			return "Id is not correct";
		}
		
	}
	public List<Blog> getAll() {
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Blog.class);
		List<Blog> list=criteria.list();
		return list;
		
		
	}

}
