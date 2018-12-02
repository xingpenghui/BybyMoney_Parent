package com.feri.byby.es.dao;
import com.feri.byby.es.domain.JavaProject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
/**
 *@Author feri
 *@Date Created in 2018/12/2 16:15
 */
public interface JavaProjectDao extends ElasticsearchRepository<JavaProject,Integer> {
}
