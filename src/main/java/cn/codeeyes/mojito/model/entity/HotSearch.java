package cn.codeeyes.mojito.model.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author codeeyes.cn
 * @date 2020/7/21 11:05
 */
@Document(collection = "hotSearch")
@Data
public class HotSearch {
  @Id
  private Long id;
  private String title;
  private Integer count;

}
