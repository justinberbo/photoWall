package cn.codeeyes.mojito.util;

import java.util.UUID;

/**
 * @author zhuang 生成随机数
 */
public class RandomUtil {

  /**
   * 获取随机的string
   *
   * @param bit
   * @return
   */
  public static String getString(int bit) {

    char[] num = new char[bit];
    short start = '0';
    short end = 'z' + 1;
    for (int i = 0; i < num.length; i++) {
      while (true) {
        char c = (char) ((Math.random() * (end - start)) + start);
        if (Character.isLetter(c) || Character.isDigit(c)) {
          num[i] = c;
          break;
        }
      }
    }
    return new String(num);
  }

  public static Long uid() {
    String uid = UUID.randomUUID().toString().replace("-", "").replaceAll("[a-zA-Z]", "");
    return Long.parseLong(uid.substring(2, 8));

  }

}
