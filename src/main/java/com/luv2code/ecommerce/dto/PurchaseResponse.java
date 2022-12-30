package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    // lombok only generate constructor for `final` fields
    private final String trackingNumber;
}
