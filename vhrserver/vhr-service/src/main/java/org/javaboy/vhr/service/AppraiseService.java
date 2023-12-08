package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.AppraiseMapper;
import org.javaboy.vhr.model.Appraise;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考评 业务层
 *
 * @author 🍍
 * @date 2023/10/1
 */
@Service
public class AppraiseService {

    @Resource
    private AppraiseMapper appraiseMapper;

    /**
     * 返回所有考评
     *
     * @return 考评集合
     */
    public List<Appraise> selectAll() {
        return appraiseMapper.selectAll();
    }
}
