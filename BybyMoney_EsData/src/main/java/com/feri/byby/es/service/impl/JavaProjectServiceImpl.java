package com.feri.byby.es.service.impl;

import com.feri.byby.es.domain.JavaProject;
import com.feri.byby.es.dao.JavaProjectDao;
import com.feri.byby.es.service.JavaProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/12/2 16:17
 */
@Service
public class JavaProjectServiceImpl implements JavaProjectService {
    @Autowired
    private JavaProjectDao dao;
    @Override
    public JavaProject save(JavaProject project) {
        return dao.save(project);
    }
}
