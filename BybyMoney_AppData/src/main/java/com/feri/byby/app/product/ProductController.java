package com.feri.byby.app.product;

import com.feri.byby.common.vo.ProductVo;
import com.feri.byby.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/12/7 15:31
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    //新品上市
    @GetMapping("productnew.do")
    public List<ProductVo> newindex(){
        return productService.queryNew();
    }
    //促销商品
    @GetMapping("productpromotion.do")
    public List<ProductVo> proindex(){
        return productService.queryCx();
    }
    //热销商品
    @GetMapping("producthot.do")
    public List<ProductVo> hotindex(){
        return productService.queryRx();
    }
}
