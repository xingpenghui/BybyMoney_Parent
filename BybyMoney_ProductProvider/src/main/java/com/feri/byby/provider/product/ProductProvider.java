package com.feri.byby.provider.product;

import com.feri.byby.common.vo.ProductVo;
import com.feri.byby.mapper.product.ProductMapper;
import com.feri.byby.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/12/7 11:37
 */
@Service("productprovider")
public class ProductProvider implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductVo> queryNew() {
        return productMapper.selectNew();
    }

    @Override
    public List<ProductVo> queryCx() {
        return productMapper.selectCx();
    }

    @Override
    public List<ProductVo> queryRx() {
        return productMapper.selectRx();
    }
}