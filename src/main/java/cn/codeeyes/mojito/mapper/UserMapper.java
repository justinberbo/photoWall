package cn.codeeyes.mojito.mapper;

import cn.codeeyes.mojito.model.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codeeyes.cn
 * @date 2020/7/11 16:43
 */
@Mapper
public interface UserMapper {

  /**
   * 添加用户
   * @param userDO
   */
  void insert(UserDO userDO);

  UserDO findByEamil(String email);
}
