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

  /**
   * 通过email查找用户
   * @param email
   * @return
   */
  UserDO findByEmail(String email);

  /**
   * 更新用户信息
   * @param userDO
   */
  void update(UserDO userDO);
}
