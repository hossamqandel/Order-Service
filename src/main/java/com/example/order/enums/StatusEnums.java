package com.example.order.enums;

public enum StatusEnums {

    PAID("Paid"),
    COMPLETED("Completed"),
    PENDING("Pending"),
    CANCELLED("Cancelled");

    private final String value;

    StatusEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
