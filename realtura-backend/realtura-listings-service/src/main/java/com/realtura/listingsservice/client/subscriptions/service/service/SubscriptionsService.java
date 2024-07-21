package com.realtura.listingsservice.client.subscriptions.service.service;//package com.realtura.realturamain.client.subscriptions.service.service;
//
//
//import com.realtura.realturamain.client.subscriptions.ListingClient;
//import com.realtura.realturamain.dto.response.GenericResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//@FeignClient(value = "subscriptions-service", url = "http://localhost:8091/api/v1/listings")
//    public class ListingService {
//    public com.realtura.listingsservice.model.Listing getListingsById(Long listingId) {
//        GenericResponse<com.realtura.listingsservice.model.Listing> response = listingClient.getById(listingId);
//        if (response == null || !HttpStatus.OK.equals(response.getHttpStatus())) {
//            log.error("Error Message: {}", response.getError());
//        }
//        return response.getData();
//    }
//}
//
