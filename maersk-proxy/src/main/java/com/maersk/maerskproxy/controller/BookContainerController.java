package com.maersk.maerskproxy.controller;

import com.maersk.maerskproxy.entity.BookingRequest;
import com.maersk.maerskproxy.entity.Container;
import com.maersk.maerskproxy.service.WrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/container")


public class BookContainerController {

    @Autowired
    private WrapperService wrapperService;

    @PostMapping("/bookContainer")
    public Boolean bookContainer(@RequestBody BookingRequest request){
        return wrapperService.getContainerSpace(request);
    }
}
