package com.restaurant.demo.controllers;

import com.restaurant.demo.repository.TableRepository;
import com.restaurant.demo.services.GuestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(description = "This is Booking Controller")
@RequestMapping("/restaurant")
@RestController
public class BookingController {

	@Autowired
	TableRepository guestRepositorty;

	@Autowired
	GuestService guestService;
	@ApiOperation(value = "Give json",
			notes = "It transmits information from the frontend to the guest service")
	@PostMapping("/bookTable")
	public ResponseEntity <?> bookTable(@RequestBody final String json) {
		return guestService.bookTable(json);
	}
}







