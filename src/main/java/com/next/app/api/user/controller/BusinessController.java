package com.next.app.api.user.controller;

import com.next.app.api.user.entity.Business;
import com.next.app.api.user.service.BusinessService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/business")
@Tag(name = "Business Controller", description = "사업 관리 API")
@CrossOrigin(origins = "http://localhost")
public class BusinessController {
    @Autowired
    private final BusinessService businessService;

    @GetMapping
    public List<Business> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public Business getBusinessById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }

    @PostMapping
    public Business createBusiness(@RequestBody Business business) {
        return businessService.createBusiness(business);
    }

    @PutMapping("/{id}")
    public Business updateBusiness(@PathVariable Long id, @RequestBody Business updatedBusiness) {
        return businessService.updateBusiness(id, updatedBusiness);
    }

    @DeleteMapping("/{id}")
    public void deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
    }
}
