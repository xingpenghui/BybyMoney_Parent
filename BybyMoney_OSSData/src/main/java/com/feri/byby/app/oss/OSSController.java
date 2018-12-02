package com.feri.byby.app.oss;

import com.feri.byby.common.constant.SystemCon;
import com.feri.byby.common.util.OSSUtil;
import com.feri.byby.common.util.ResultUtil;
import com.feri.byby.common.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *@Author feri
 *@Date Created in 2018/12/2 10:10
 */
@RestController
public class OSSController {

    @Autowired
    private OSSUtil ossUtil;
    //文件上传
    @PostMapping("ossupload.do")
    public ResultBean upload(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String path=ossUtil.fileUp(file.getOriginalFilename(),file.getBytes());
            return ResultUtil.setOK("存储成功",path);
        }else{
            return ResultUtil.setError(SystemCon.RERROR1,"请选择上传文件",null);
        }
    }
}
