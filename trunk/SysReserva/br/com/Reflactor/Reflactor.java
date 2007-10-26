package br.com.Reflactor;

import br.com.annotation.GetValue;
import br.com.annotation.GoDepper;
import br.com.annotation.Persistent;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflactor {
        
    public static Map getMapFields(Object obj){
        Map map = new HashMap();
        setMapFields(obj, map);
        return map;
    }
    
    private static void setMapFields(Object obj, Map map){
      for(Class classe=obj.getClass(); classe != null; classe=classe.getSuperclass()){
        for(Field field:classe.getDeclaredFields()){
          try {
            if((field.isAnnotationPresent(Persistent.class))||
               (field.isAnnotationPresent(GoDepper.class))){
              field.setAccessible(true);
              String name = field.getName();
              Object value = field.get(obj);
              if(field.isAnnotationPresent(Persistent.class)){
                map.put(name, value);
              }else if(field.isAnnotationPresent(GoDepper.class)){
                setMapFields(value, map);
              }
            }//if
          } catch (IllegalAccessException ex) {
            Logger.getLogger(Reflactor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalArgumentException ex) {
            Logger.getLogger(Reflactor.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SecurityException ex) {
            Logger.getLogger(Reflactor.class.getName()).log(Level.SEVERE, null, ex);
          }
        }//for        
      }//for
    }
    
    public static void setEntidade(Object obj, Map map){
      Object value = null;
      try {
        for(Class classe=obj.getClass(); classe != null; classe=classe.getSuperclass()){
          for(Field field:classe.getDeclaredFields()){
            if((field.isAnnotationPresent(Persistent.class))||
               (field.isAnnotationPresent(GoDepper.class))||
               (field.isAnnotationPresent(GetValue.class))){
              field.setAccessible(true);
              if((field.isAnnotationPresent(Persistent.class))||
                ((field.isAnnotationPresent(GetValue.class)))){
                if(map.containsKey(field.getName().toLowerCase())){
                   value = map.get(field.getName().toLowerCase());
                }//if
                field.set(obj, value);        
              }else if(field.isAnnotationPresent(GoDepper.class)){
                value = field.get(obj);
                setEntidade(value, map);
              }//else-if
            }//if
          }//for        
        }//for
      } catch (IllegalAccessException ex) {
        Logger.getLogger(Reflactor.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalArgumentException ex) {
        Logger.getLogger(Reflactor.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

}
