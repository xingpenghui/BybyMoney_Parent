package com.feri.byby.mapper.product;
import com.feri.byby.domain.product.ProMedia;
import java.util.List;
public interface ProMediaMapper {
    int insert(ProMedia record);
    List<ProMedia> selectByPid(Integer id);
}