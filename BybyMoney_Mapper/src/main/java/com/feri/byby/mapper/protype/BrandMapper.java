package com.feri.byby.mapper.protype;
import com.feri.byby.domain.protype.Brand;

import java.util.List;

public interface BrandMapper {
    int insert(Brand record);

    List<Brand> selectAll();
}