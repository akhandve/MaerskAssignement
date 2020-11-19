package com.maersk.maerskproxy.service;

import com.maersk.maerskproxy.entity.BookingRequest;
import com.maersk.maerskproxy.entity.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WrapperService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  WebClient.Builder webClientBuilder;

    public boolean getContainerSpace(BookingRequest bookingRequest){


        /* Using RestTemplate */
         BookingResponse response = restTemplate
        .postForObject("http://localhost:8086/api/bookings/checkAvailable", bookingRequest,BookingResponse.class);

        /* Using WebFlux
        BookingResponse response = (BookingResponse) webClientBuilder.build()
                .post()
                .uri("http://localhost:8081/api/bookings/checkAvailable")
                .body(Mono.just(bookingRequest), BookingRequest.class)
                .retrieve();
         */

        if(response != null){
            return (response.getAvailable() != 0 ) ? true : false;
        }else {
            return false;
        }
    }
}
