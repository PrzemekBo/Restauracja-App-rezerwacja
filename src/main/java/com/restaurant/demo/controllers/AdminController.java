package com.restaurant.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.demo.domain.TableEntity;
import com.restaurant.demo.repository.AdminRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "This is my Admin Controller ")
@RestController
@RequestMapping(value ="/admin")
public class AdminController {
    
    @Autowired
    private AdminRepository adminRepository;

    @ApiOperation(value = "Delete reservation by id",
            notes = "Please indicate the appropriate IP address of the table (booking) to be removed")
    @GetMapping({"/delete/{id}"})
    public void deleteReservationById(@PathVariable Long id){
    	 adminRepository.deleteById(id);
    }

    @ApiOperation(value = "Find all tables",
    notes = "Returns a list of all reservations")
    @GetMapping({"/getAll"})
    public List<TableEntity> findAllReservations(){
    	return (List<TableEntity>) adminRepository.findAll();
    }
}


