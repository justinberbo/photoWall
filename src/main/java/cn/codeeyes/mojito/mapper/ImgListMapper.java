package cn.codeeyes.mojito.mapper;

import cn.codeeyes.mojito.model.entity.ImgListDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codeeyes.cn
 * @date 2020/7/22 14:50
 */
@Mapper
public interface ImgListMapper {

  /**
   * 查询图片
   * @param name
   * @return
   */
  ImgListDO getImgByName(String name);
}
