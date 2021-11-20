package com.mycompany.bitcoinapi.observer;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class PriceMessage {

    Long id;
    BigDecimal value;
    LocalDateTime timestamp;
}
