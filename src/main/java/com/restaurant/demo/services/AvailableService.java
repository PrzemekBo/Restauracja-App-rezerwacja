package com.restaurant.demo.services;

import com.restaurant.demo.domain.Guest;
import com.restaurant.demo.domain.TableEntity;
import com.restaurant.demo.domain.TableType;
import com.restaurant.demo.repository.TableRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Api(description = "This is AvailableService class")
public class AvailableService {
	
	private final Integer DOUBLE_TABLE_AMMOUNT = 5;
	private final Integer QUADRIPLE_TABLE_AMMOUNT = 3;
	private final Integer FAMILY_TABLE_AMMOUNT = 2;
	
	@Autowired
	private TableRepository tableRepository;

	@ApiOperation(value = "Checking the availability of the table",
			notes ="The process consists of several stages\n" +
					"Getting all reservation entity from database\n" +
					"If size of table type list from database is greater than table ammount then throw 					exception\t.\n" +
					"Iterating over all tableEntities\n" +
					"Checking if guest have booked table already\n" +
					"Lterating over all tableEntity with type TABLE_TYPE\n" +
					"Checking if table isin't booked" )

	public void check(TableEntity tableEntity, Guest guest) {
		
		TableType TABLE_TYPE = tableEntity.getTableType();
		
// 	Getting all reservation  entity from database
		List<TableEntity> listOfAllGuests = (List) tableRepository.findAll();
		List<TableEntity> listOfTableType = tableRepository.findByTableType(TABLE_TYPE);
		
// If size of table type list from database is greater than table ammount then throw exception		
		if(listOfTableType.size() >= switchTableType(TABLE_TYPE)) throw new IllegalArgumentException();
			
		
// Iterating over all tableEntities
// Checking if guest have booked table already			
		for(TableEntity i : listOfAllGuests) 
			if(i.getGuest().getSurname().equals(guest.getSurname())) throw new IllegalStateException(); 
	
// Iterating over all tableEntity with type TABLE_TYPE
// Checking if table isin't booked		
		for(TableEntity i : listOfTableType) {
			
			Long beginningReservation = tableEntity.getDate().getTime(); 
			Long endReservation = tableEntity.getTimestamp().getTime(); 
			
			Long beginningReservationDB = i.getDate().getTime();
			Long endReservationDB = i.getTimestamp().getTime();
			 
			if(!(beginningReservation > endReservationDB || endReservation < beginningReservationDB)) 
				throw new RuntimeException();
				
		}
	}
	@ApiOperation(value = "Changes the type of table",
	notes ="Returns the number of available table types" )
	private Integer switchTableType(TableType tableType) {
			switch (tableType.toString()) {
		    case "DOUBLE":
		        return DOUBLE_TABLE_AMMOUNT;
		    case "QUADRIPLE":
		        return QUADRIPLE_TABLE_AMMOUNT;   
		    case "FAMILY":
		        return FAMILY_TABLE_AMMOUNT;
		    default: return null;
		}
			
	}
}
