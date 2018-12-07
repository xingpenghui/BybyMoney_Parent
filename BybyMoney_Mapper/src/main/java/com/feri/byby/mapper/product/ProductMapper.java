package com.feri.byby.mapper.product;

import com.feri.byby.domain.product.Product;
import com.feri.byby.domain.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    int insert(Product record);

    Product selectById(Integer id);

    int updateById(Product record);

    long selectCount();

    List<Product> selectPage(@Param("index") int index, @Param("count") int count);

}