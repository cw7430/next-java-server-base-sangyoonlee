package com.next.app.api.user.service;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BusinessService {
    @Autowired
    private final BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
    }

    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }

    public Business updateBusiness(Long id, Business updatedBusiness) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business not found with id: " + id));
        business.setBusinessNumber(updatedBusiness.getBusinessNumber());
        business.setCompanyName(updatedBusiness.getCompanyName());
        business.setRepresentativeName(updatedBusiness.getRepresentativeName());
        business.setContactEmail(updatedBusiness.getContactEmail());
        business.setContactPhone(updatedBusiness.getContactPhone());
        business.setAddress(updatedBusiness.getAddress());
        return businessRepository.save(business);
    }

    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }


}
