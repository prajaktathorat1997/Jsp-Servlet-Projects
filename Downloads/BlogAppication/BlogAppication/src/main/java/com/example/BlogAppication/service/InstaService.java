package com.example.BlogAppication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAppication.entity.Instagram;
import com.example.BlogAppication.repository.InstaRepository;
@Service
public class InstaService {
	@Autowired
InstaRepository repo;
	@Transactional
	public Instagram save(Instagram insta) {
		Instagram instagram = repo.save(insta);
		return instagram;
	}
	
	@Transactional
	public Map<Instagram, String> update(Instagram insta, long id) {
		Map<Instagram, String> map=new HashMap<>();
		
		try {Instagram insta1=repo.getById(id);
			if(insta1.getUsername()!=null) {
				insta1.setCaption(insta.getCaption());
				insta1.setLocation(insta.getLocation());
				insta1.setHashtags(insta.getHashtags());
				insta1.setMentions(insta.getMentions());
				insta1.setUserId(insta.getUserId());
				insta1.setUsername(insta.getUsername());
				Instagram insta2=repo.save(insta1);
				map.put(insta2, "updated succssfully");
				}
				
		} catch (Exception e) {
			System.err.println("id not valid");
			map.put(null, "id is not valid");
		}
		return map;
	}

	public List<Instagram> getAll() {
		List<Instagram> list = repo.findAll();
		
		return list;
	}

	public String delete(Long id) {
		String msg=null;
		try {
			Instagram byId = repo.getOne(id);
			if(byId.getUsername()!=null) {
				repo.delete(byId);
				msg= "deleted successfully";
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg= "Id is not valid ";
		}
	
		return msg;
	}

}
