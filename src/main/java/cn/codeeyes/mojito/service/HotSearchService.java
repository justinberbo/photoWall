package cn.codeeyes.mojito.service;

import cn.codeeyes.mojito.model.entity.HotSearch;
import java.util.List;

/**
 * @author codeeyes.cn
 * @date 2020/7/21 11:10
 */
public interface HotSearchService {

  void save(HotSearch hotSearch);

  void remove(Long id);

  void update(HotSearch hotSearch);

  HotSearch findById(Long id);

  HotSearch findByTitle(String title);

  List<HotSearch> findAll();

  /**
   * 热门搜索
   * @return
   */
  List<String> getHotSearch();

  /**
   * 获取人物图
   * @param id
   * @return
   */
  List<String>getImgList(String id);
}
