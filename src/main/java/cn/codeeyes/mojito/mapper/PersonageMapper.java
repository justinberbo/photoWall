package cn.codeeyes.mojito.mapper;

import cn.codeeyes.mojito.model.dto.PersonDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author codeeyes.cn
 * @date 2020/7/18 16:44
 */
@Mapper
public interface PersonageMapper {

  /**
   * 搜索
   * @param condition
   * @return
   */
  List<PersonDTO> selectByCondition(String condition);
}
