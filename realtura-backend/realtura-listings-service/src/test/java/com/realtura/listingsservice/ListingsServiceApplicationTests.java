package com.realtura.listingsservice;

import com.realtura.listingsservice.dto.request.ListingDeleteRequest;
import com.realtura.listingsservice.dto.request.ListingSaveRequest;
import com.realtura.listingsservice.dto.request.ListingSearchRequest;
import com.realtura.listingsservice.dto.response.CreateResponse;
import com.realtura.listingsservice.dto.response.GenericResponse;
import com.realtura.listingsservice.dto.response.ListingResponse;
import com.realtura.listingsservice.model.Listing;
import com.realtura.listingsservice.repository.ListingRepository;
import com.realtura.listingsservice.service.ListingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ListingsServiceApplicationTests {
    @Mock
    private ListingRepository listingRepository;

    @InjectMocks
    private ListingService listingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        ListingSaveRequest request = new ListingSaveRequest();
        Listing listing = new Listing();
        listing.setId(1L);

        when(listingRepository.save(any(Listing.class))).thenReturn(listing);

        GenericResponse<CreateResponse> response = listingService.save(request);

        assertNotNull(response);
        assertTrue(response.getStatus().equals("SUCCESS"));
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals(1L, response.getData().getId());
    }

    @Test
    void getAllByFilter() {
        ListingSearchRequest request = new ListingSearchRequest();
        request.setPage(0);  // Set a valid page number
        request.setSize(10); // Set a valid page size
        PageRequest pageRequest = PageRequest.of(0, 10);
        Listing listing = new Listing();
        Page<Listing> listingPage = new PageImpl<>(List.of(listing));

        when(listingRepository.findAll(any(Specification.class), any(PageRequest.class))).thenReturn(listingPage);

        List<ListingResponse> responses = listingService.getAllByFilter(request);

        assertNotNull(responses);
        assertEquals(1, responses.size());
    }

    @Test
    void update() {
        Long id = 1L;
        ListingSaveRequest request = new ListingSaveRequest();
        Listing listing = new Listing();
        listing.setId(id);

        when(listingRepository.findById(id)).thenReturn(Optional.of(listing));
        when(listingRepository.save(any(Listing.class))).thenReturn(listing);

        GenericResponse<?> response = listingService.update(id, request);

        assertNotNull(response);
        assertTrue(response.getStatus().equals("SUCCESS"));
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals("listing updated", response.getMessage());
    }

    @Test
    void delete() {
        ListingDeleteRequest request = new ListingDeleteRequest();
        request.setId(1L);
        Listing listing = new Listing();

        when(listingRepository.findAll(any(Specification.class))).thenReturn(List.of(listing));

        GenericResponse<?> response = listingService.delete(request);

        verify(listingRepository, times(1)).deleteById(request.getId());
        assertTrue(response.getStatus().equals("SUCCESS"));
        assertEquals(HttpStatus.OK, response.getHttpStatus());
        assertEquals("listing deleted", response.getMessage());
    }
}
