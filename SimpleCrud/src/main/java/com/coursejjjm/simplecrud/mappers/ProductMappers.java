package com.coursejjjm.simplecrud.mappers;

import com.coursejjjm.simplecrud.model.product.Product;
import com.coursejjjm.simplecrud.model.rdmProduct.RdmProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMappers {

    ProductMappers INSTANCE = Mappers.getMapper(ProductMappers.class);

    @Mapping(source = "title", target = "name")
    Product rdmProductToProduct(RdmProduct product);
}


