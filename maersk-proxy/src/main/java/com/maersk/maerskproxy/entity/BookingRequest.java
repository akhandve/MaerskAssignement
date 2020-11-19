package com.maersk.maerskproxy.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookingRequest {

    private Integer id;
    private Integer bookContainerSpace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookContainerSpace() {
        return bookContainerSpace;
    }

    public void setBookContainerSpace(Integer bookContainerSpace) {
        this.bookContainerSpace = bookContainerSpace;
    }
}
