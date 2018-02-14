package com.restaurant.demo.domain;

import io.swagger.annotations.Api;

@Api(description = "This is TableType class, which offer to choose 3 types of tables")
public enum TableType {
    DOUBLE, QUADRIPLE, FAMILY;
}
