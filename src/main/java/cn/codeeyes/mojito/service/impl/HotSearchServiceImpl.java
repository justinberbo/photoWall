package cn.codeeyes.mojito.service.impl;

import cn.codeeyes.mojito.common.RedisConstant;
import cn.codeeyes.mojito.mapper.ImgListMapper;
import cn.codeeyes.mojito.model.entity.HotSearch;
import cn.codeeyes.mojito.model.entity.ImgListDO;
import cn.codeeyes.mojito.service.HotSearchService;
import cn.codeeyes.mojito.util.RedisUtil;
import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author codeeyes.cn
 * @date 2020/7/21 11:13
 */
@Component
public class HotSearchServiceImpl implements HotSearchService {

  @Resource
  private MongoTemplate mongoTemplate;
  @Resource
  private RedisUtil redisUtil;
  @Resource
   private ImgListMapper imgListMapper;

  @Override
  public void save(HotSearch hotSearch) {
    mongoTemplate.save(hotSearch);
  }

  @Override
  public void remove(Long id) {
    mongoTemplate.remove(id);
  }

  @Override
  public void update(HotSearch hotSearch) {
    Query query = new Query(Criteria.where("id").is(hotSearch.getId()));

    Update update = new Update();
    update.set("title", hotSearch.getTitle());
    update.set("count", hotSearch.getCount());

    mongoTemplate.updateFirst(query, update, HotSearch.class);

  }

  @Override
  public HotSearch findById(Long id) {
    Query query = new Query(Criteria.where("id").is(id));
    HotSearch hotSearch = mongoTemplate.findOne(query, HotSearch.class);
    return hotSearch;

  }

  @Override
  public HotSearch findByTitle(String title) {
    Query query = new Query(Criteria.where("title").is(title));
    HotSearch hotSearch = mongoTemplate.findOne(query, HotSearch.class);
    return hotSearch;
  }

  @Override
  public List<HotSearch> findAll() {
    return mongoTemplate.findAll(HotSearch.class);
  }

  @Override
  public List<String> getHotSearch() {

    List<HotSearch> listHotSearch = this.findAll();

    listHotSearch.sort(new Comparator<HotSearch>() {
      @Override
      //从大到小
      public int compare(HotSearch o1, HotSearch o2) {
        return o2.getCount() - o1.getCount();
      }
    });

    List<String> listHot = new ArrayList<>();
//    listHot.add(listHotSearch.get(0).getTitle());
//    listHot.add(listHotSearch.get(1).getTitle());
//    listHot.add(listHotSearch.get(2).getTitle());
//    listHot.add(listHotSearch.get(3).getTitle());
//    listHot.add(listHotSearch.get(4).getTitle());
//    System.out.println(listHotSearch);
    listHotSearch.forEach(hotSearch -> {

      listHot.add(hotSearch.getTitle());
    });

    return listHot;
  }

  @Override
  public List<String> getImgList(String name) {

    ImgListDO imgListDO=imgListMapper.getImgByName(name);
    List<String>listImg=new ArrayList<>();
    if (null!=imgListDO) {
      if(null!=imgListDO.getUrl1()) {
        listImg.add(imgListDO.getUrl1());
      }
      if(null!=imgListDO.getUrl2()) {
        listImg.add(imgListDO.getUrl2());
      }
      if(null!=imgListDO.getUrl3()) {
        listImg.add(imgListDO.getUrl3());
      }
      if(null!=imgListDO.getUrl4()) {
        listImg.add(imgListDO.getUrl4());
      }
      if(null!=imgListDO.getUrl5()) {
        listImg.add(imgListDO.getUrl5());
      }
    }
    return listImg;
  }
}
