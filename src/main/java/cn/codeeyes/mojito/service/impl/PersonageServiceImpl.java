package cn.codeeyes.mojito.service.impl;

import cn.codeeyes.mojito.mapper.PersonageMapper;
import cn.codeeyes.mojito.model.dto.PersonDTO;
import cn.codeeyes.mojito.model.dto.PersonSearchDTO;
import cn.codeeyes.mojito.model.entity.HotSearch;
import cn.codeeyes.mojito.service.HotSearchService;
import cn.codeeyes.mojito.service.PersonageService;
import cn.codeeyes.mojito.util.RandomUtil;
import cn.codeeyes.mojito.util.RedisUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:30
 */
@Service
public class PersonageServiceImpl implements PersonageService {

  @Resource
  private HotSearchService hotSearchService;
  @Resource
  private PersonageMapper personageMapper;
  private RedisUtil redisUtil;

  @Override
  public List<PersonDTO> findPersonage(PersonSearchDTO searchDTO) {
    String search = searchDTO.getCondition();

    HotSearch hotSearch = hotSearchService.findByTitle(search);

    if (null == hotSearch) {
      hotSearch.setId(RandomUtil.uid());
      hotSearch.setTitle(search);
      hotSearch.setCount(1);
      hotSearchService.save(hotSearch);
    } else {

      Integer count = hotSearch.getCount();
      hotSearch.setCount(count + 1);
      hotSearchService.update(hotSearch);
    }
    return personageMapper.selectByCondition(searchDTO.getCondition());

  }
}
