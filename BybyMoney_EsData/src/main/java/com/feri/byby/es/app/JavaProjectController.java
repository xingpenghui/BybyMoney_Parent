package com.feri.byby.es.app;

import com.feri.byby.common.util.ResultUtil;
import com.feri.byby.common.vo.ResultBean;
import com.feri.byby.es.domain.JavaProject;
import com.feri.byby.es.service.JavaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2018/12/2 16:18
 */
@RestController
public class JavaProjectController {
    @Autowired
    private JavaProjectService service;

    //新增
    @RequestMapping("projectadd.do")
    public ResultBean save(JavaProject project){
        service.save(project);
        return ResultUtil.setOK("新增成功",null);
    }
}
