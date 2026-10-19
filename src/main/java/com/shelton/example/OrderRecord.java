package com.shelton.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
