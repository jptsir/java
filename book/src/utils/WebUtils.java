package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author jingpengtao
 * @create 2021-09-29 22:32
 */
public class WebUtils {
    public static <T> T copyParamtoBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       return bean;
    }
public static int parser(String str,int defaultvalue){
    int i=0;
        try {
         i = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      //  e.printStackTrace();
    }
      if(str==null){
          return defaultvalue;
      }else{
         return i;
      }
}
}
