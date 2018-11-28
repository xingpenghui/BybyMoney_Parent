package com.feri.app;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
/**
 *@Author feri
 *@Date Created in 2018/11/28 15:25
 */
@Api(value = "欢迎使用Swagger")
@RestController
public class HelloController {

    @ApiOperation(value = "列表方法",notes = "测试在线接口生成")
    @GetMapping("/helloList.do")
    public List<String> list(){
        List<String> list=new ArrayList<>();
        for(int i=1;i<10;i++){
            list.add("第"+i+"名");
        }
        return list;
    }

}
