package cn.codeeyes.mojito.service;

import cn.codeeyes.mojito.model.dto.CollectionDTO;
import java.util.List;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 22:21
 */
public interface CollectionService {

  /**
   * 图集
   * @return
   */
  List<CollectionDTO> getCollection();
}
