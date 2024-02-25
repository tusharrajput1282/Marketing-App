package com.marketingapp.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entity.Registration;
import com.marketingapp.repository.RegistrationRepository;

@Service
public class RegistrationService {
		
		@Autowired
		private RegistrationRepository registrationRepo;
		
		public void saveRegistration(Registration reg) {
			registrationRepo.save(reg);
		}
		
		
		public List<Registration> getAllRegistrations() {
			List<Registration> registrations = registrationRepo.findAll();
			return registrations;
		}


		public void deleteById(long id) {
			registrationRepo.deleteById(id);
		}


		public Registration getRegistrationById(long id) {						//return type is Registration cause single value in return
			Optional<Registration> findById = registrationRepo.findById(id);
			return findById.get();                                           //we used .get() here cause it's returning Registration type object
		}


		public void saveUpdatedRegistration(Registration reg) {
			registrationRepo.save(reg);
		}
		
}
