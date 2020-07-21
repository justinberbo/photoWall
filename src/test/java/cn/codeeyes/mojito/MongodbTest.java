package cn.codeeyes.mojito;

import cn.codeeyes.mojito.model.entity.HotSearch;
import cn.codeeyes.mojito.service.HotSearchService;
import cn.codeeyes.mojito.util.RandomUtil;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author codeeyes.cn
 * @date 2020/7/21 11:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MojitoApplication.class)
public class MongodbTest {

  @Resource
  private HotSearchService hotSearchService;

  @Test
  public void saveTest() {
    HotSearch hotSearch = new HotSearch();
    hotSearch.setId(RandomUtil.uid());
    hotSearch.setTitle("nba");
    hotSearch.setCount(7);
    hotSearchService.save(hotSearch);
  }

  @Test
  public void removeTest() {
    hotSearchService.remove(1L);
  }

  @Test
  public void updateTest() {

    HotSearch hotSearch = new HotSearch();
    hotSearch.setId(RandomUtil.uid());
    hotSearch.setTitle("search");
    hotSearch.setCount(1);
    ;
    hotSearchService.update(hotSearch);
  }

  @Test
  public void findByIdTest() {
    HotSearch hotSearch = hotSearchService.findById(1l);
    System.out.println(hotSearch);
  }

  @Test
  public void findByTitle() {
    HotSearch hotSearch = hotSearchService.findByTitle("12345");
    System.out.println(hotSearch);
  }

  @Test
  public void findALL() {
    List<HotSearch> list = hotSearchService.findAll();
    list.forEach(hotSearch -> {
      System.out.println(hotSearch);
    });
  }

  @Test
  public void test() {
    System.out.println(RandomUtil.uid());
    System.out.println(RandomUtil.uid());
    System.out.println(RandomUtil.uid());
    System.out.println(RandomUtil.uid());
    System.out.println(RandomUtil.uid());
    System.out.println(RandomUtil.uid());
  }
}
