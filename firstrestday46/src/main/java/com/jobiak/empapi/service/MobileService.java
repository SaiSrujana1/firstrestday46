package com.jobiak.empapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobiak.empapi.model.Mobile;
import com.jobiak.empapi.repository.MobileRepository;

@Service
public class MobileService {

	@Autowired
	MobileRepository repo;
	
	public Mobile addMobile(Mobile mobile) {
		Mobile ref = repo.save(mobile);
		return ref;
	}

	public Mobile modifyMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeProduct(Long mobileid) {
		// TODO Auto-generated method stub
		
	}
}
