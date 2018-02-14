package com.restaurant.demo.repository;


import com.restaurant.demo.domain.TableEntity;
import com.restaurant.demo.domain.TableType;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Api(description = "This TableRepository, this repository is an interface and will allow you to perform various operations involving Table objects. It gets these operations by extending the CrudRepository ")
public interface TableRepository extends CrudRepository<TableEntity, Long> {
	public List<TableEntity> findByTableType(TableType quadriple);
}
