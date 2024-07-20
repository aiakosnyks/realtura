package com.realtura.listingsservice.service;

import com.realtura.listingsservice.converter.AddressConverter;
import com.realtura.listingsservice.dto.request.AddressSaveRequest;
import com.realtura.listingsservice.exception.ExceptionMessages;
import com.realtura.listingsservice.model.Address;
import com.realtura.listingsservice.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    private void save(AddressSaveRequest request)
    {
        Address address = AddressConverter.toAddress(request);
        addressRepository.save(address);
    }

    public void saveAsList(List<AddressSaveRequest> request) {
        request.forEach(item -> save(item));
    }

//    public List<Address> getByCity(String city) {
//        List<Address> foundAddress = addressRepository.findByCity(city);
//        if (foundAddress.isEmpty()) {
//            log.error(ExceptionMessages.ADDRESS_NOT_FOUND);
//            throw new RuntimeException(ExceptionMessages.ADDRESS_NOT_FOUND);
//        }
//        return foundAddress;
//    }
//
//    public List<Address> getByZipCode(String zipCode) {
//        List<Address> foundAddress = addressRepository.findByZipCode(zipCode);
//        if (foundAddress.isEmpty()) {
//            log.error(ExceptionMessages.ADDRESS_NOT_FOUND);
//            throw new RuntimeException(ExceptionMessages.ADDRESS_NOT_FOUND);
//        }
//        return foundAddress;
//    }
//
//    public List<Address> getByState(String state) {
//        List<Address> foundAddress = addressRepository.findByState(state);
//        if (foundAddress.isEmpty()) {
//            log.error(ExceptionMessages.ADDRESS_NOT_FOUND);
//            throw new RuntimeException(ExceptionMessages.ADDRESS_NOT_FOUND);
//        }
//        return foundAddress;
//    }
//
//    public List<Address> getByCountry(String country) {
//        List<Address> foundAddress = addressRepository.findByCountry(country);
//        if (foundAddress.isEmpty()) {
//            log.error(ExceptionMessages.ADDRESS_NOT_FOUND);
//            throw new RuntimeException(ExceptionMessages.ADDRESS_NOT_FOUND);
//        }
//        return foundAddress;
//    }
}
