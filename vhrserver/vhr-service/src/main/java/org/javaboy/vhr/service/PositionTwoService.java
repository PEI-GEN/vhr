package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PositionTwoMapper;
import org.javaboy.vhr.model.InsertPosition;
import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.model.UploadPosition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 职位 业务层
 *
 * @author 🍍
 * @date 2023/10/1
 */
@Service
public class PositionTwoService {

    @Resource
    private PositionTwoMapper positionTwoMapper;

    /**
     * 查询所有职位
     *
     * @return 职位集合
     */
    public List<Position> selectAllPosition() {
        return positionTwoMapper.selectAllPosition();
    }

    /**
     * 查询职位
     *
     * @param id 职位id
     * @return 职位信息
     */
    public Position selectPositionById(Integer id) {
        return positionTwoMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除职位
     *
     * @param id 职位id
     * @return 结果
     */
    public boolean delete(Integer id) {
        return positionTwoMapper.deleteByPrimaryKey(id) == 1;
    }

    /**
     * 新增职位
     *
     * @param insertPosition 职位信息
     * @return 结果
     */
    public boolean insert(InsertPosition insertPosition) {
        return positionTwoMapper.insertPosition(insertPosition) == 1;
    }

    /**
     * 批量删除
     *
     * @param ids 职位id数组
     * @return 结果
     */
    public boolean deleteMany(Integer[] ids) {
        return positionTwoMapper.deleteMany(ids) == ids.length;
    }

    /**
     * 修改职位
     *
     * @param uploadPosition 职位信息
     * @return 结果
     */
    public boolean update(UploadPosition uploadPosition) {
        return positionTwoMapper.updateByPrimaryKey(uploadPosition) == 1;
    }

    public Position findByName(String name) {
        return positionTwoMapper.findByName(name);
    }
}
