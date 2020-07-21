package cn.codeeyes.mojito.service;

import cn.codeeyes.mojito.model.dto.PersonDTO;
import cn.codeeyes.mojito.model.dto.PersonSearchDTO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:30
 */

public interface PersonageService {

  /**
   * 搜索人物
   *
   * @param searchDTO
   * @return
   */
  List<PersonDTO> findPersonage(PersonSearchDTO searchDTO);
}
