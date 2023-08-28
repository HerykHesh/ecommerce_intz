package com.test.ecommerce.model.mapper;

import com.test.ecommerce.model.Product;
import com.test.ecommerce.model.vo.ProductVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapToProduct(Product products);

    List<Product> convert(List<ProductVO> productVos);
    ProductVO convert(Product product);
}

