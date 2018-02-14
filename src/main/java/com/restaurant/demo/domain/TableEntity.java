package com.restaurant.demo.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;


@Api(description = "This is EntityTable class.")
@Entity
@Table(name = "table_entity")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="table_id")
    @ApiModelProperty(value = "This is id of Table", required = true)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id", referencedColumnName = "guest_id")
    @ApiModelProperty(value = "This is Guest class(for marking the relationship)", required = true)
    private Guest guest;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tableType")
    @ApiModelProperty(value = "This is a table type class",required = true)
    private TableType tableType;

    @Column(name = "isAvailable")
    @ApiModelProperty(value = "This is available class",required = true)
    private boolean isAvailable;

    @Column(name = "reservation_start_time")
    @ApiModelProperty(value = "This is start reservation class",required = true)
    private Date date;

    @Column(name = "reservation_expires_time")
    @ApiModelProperty(value = "This is time stamp class",required = true)
    private Date timestamp;

    public TableEntity() {};

    public TableEntity(Guest guest, TableType tableType, boolean isAvailable, Date date, Date timestamp) {
        this.guest = guest;
        this.tableType = tableType;
        this.isAvailable = isAvailable;
        this.date = date;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
