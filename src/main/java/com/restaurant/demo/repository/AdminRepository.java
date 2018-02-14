package com.restaurant.demo.repository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.CrudRepository;

import com.restaurant.demo.domain.TableEntity;

@Api(description = "This AdminRepository, this repository is an interface and will allow you to perform various operations involving Admin objects. It gets these operations by extending the CrudRepository ")
public interface AdminRepository extends CrudRepository <TableEntity, Long> {
	void deleteById(Long id);
	Iterable <TableEntity> findAll();
}
