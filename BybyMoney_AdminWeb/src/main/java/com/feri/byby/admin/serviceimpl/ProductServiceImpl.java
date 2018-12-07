package com.feri.byby.admin.serviceimpl;

import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.service.ProductService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.domain.product.Product;
import com.feri.byby.mapper.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/12/3 14:58
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public R savePro(Product product) {
        return RUtil.setRes(productMapper.insert(product));
    }
    @Override
    public PageVo<Product> queryByPage(int page, int limit) {
        int index=0;
        if(page>1){
            index=(page-1)*limit;
        }
        return PageVo.createPage(productMapper.selectPage(index,limit),productMapper.selectCount());
    }
}
