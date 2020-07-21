package cn.codeeyes.mojito.mapper;

import cn.codeeyes.mojito.model.entity.CollectionDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codeeyes.cn
 * @date 2020/7/21 10:00
 */
@Mapper
public interface CollectionMapper {

  /**
   * 获取图集
   * @return
   */
  List<CollectionDO> getCollection();
}
