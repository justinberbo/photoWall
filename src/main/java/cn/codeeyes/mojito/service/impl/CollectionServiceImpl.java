package cn.codeeyes.mojito.service.impl;

import cn.codeeyes.mojito.mapper.CollectionMapper;
import cn.codeeyes.mojito.model.dto.CollectionDTO;
import cn.codeeyes.mojito.model.entity.CollectionDO;
import cn.codeeyes.mojito.service.CollectionService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author codeeyes.cn
 * @date 2020/7/20 22:21
 */
@Service
public class CollectionServiceImpl implements CollectionService {

  @Resource
  private CollectionMapper collectionMapper;

  @Override
  public List<CollectionDTO> getCollection() {
    List<CollectionDO> listCollection = collectionMapper.getCollection();

    List<CollectionDTO> listCollectionDTO = new ArrayList<>();

    listCollection.forEach(collectionDO -> {

      CollectionDTO outDto = new CollectionDTO();
      List<String> listImg = new ArrayList<>();

      outDto.setId(collectionDO.getId());
      outDto.setAuthor(collectionDO.getAuthor());
      outDto.setImg_index(collectionDO.getImg_index());

      listImg.add(collectionDO.getImg_url1());
      listImg.add(collectionDO.getImg_url2());
      listImg.add(collectionDO.getImg_url3());
      listImg.add(collectionDO.getImg_url4());
      listImg.add(collectionDO.getImg_url5());
      listImg.add(collectionDO.getImg_url6());
      listImg.add(collectionDO.getImg_url7());
      listImg.add(collectionDO.getImg_url8());
      outDto.setImg_url(listImg);

      listCollectionDTO.add(outDto);

    });
    return listCollectionDTO;
  }
}
