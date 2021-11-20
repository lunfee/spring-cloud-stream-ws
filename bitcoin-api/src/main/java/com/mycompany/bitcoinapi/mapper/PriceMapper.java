package com.mycompany.bitcoinapi.mapper;

import com.mycompany.bitcoinapi.model.Price;
import com.mycompany.bitcoinapi.observer.PriceMessage;
import com.mycompany.bitcoinapi.rest.dto.PriceResponse;
import org.mapstruct.Mapper;
//对象关系映射
@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceResponse toPriceResponse(Price price);

    PriceMessage toPriceMessage(Price price);
}
