package com.feri.byby.mapper.product;
import com.feri.byby.domain.product.ProductDetail;
public interface ProductDetailMapper {
    int insert(ProductDetail record);
    ProductDetail selectByPid(Integer id);
    int updateByPrimaryKey(ProductDetail record);
}