package com.marketingapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marketingapp.entity.Registration;
import com.marketingapp.repository.RegistrationRepository;

@SpringBootTest
class MarketingappApplicationTests {

	@Autowired
private RegistrationRepository repo;
	
	@Test
	void save() {
		Registration r= new Registration();
		r.setLastName("rr");
		r.setFirstName("kk");
		r.setEmail("hg");
		r.setMobile(555660);
		repo.save(r);
				
		
	}

}
