package com.realtura.listingsservice.controller;

import com.realtura.listingsservice.dto.request.AddressSaveRequest;
import com.realtura.listingsservice.dto.request.ListingSaveRequest;
import com.realtura.listingsservice.dto.request.ListingSearchRequest;
import com.realtura.listingsservice.dto.response.GenericResponse;
import com.realtura.listingsservice.dto.response.ListingResponse;
import com.realtura.listingsservice.service.AddressService;
import com.realtura.listingsservice.service.ListingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController("/api/v1/address")
public class AddressController {

//    private final AddressService addressService;
//
//    @PostMapping
//    public void save(@RequestBody AddressSaveRequest request) {
//        addressService.save(request);
//        log.info("New listing saved: {}", request);
//    }
//
//    @GetMapping
//    public List<AddressSaveRequest> getAll() {
//        return addressService.getAll();
//    }

}
