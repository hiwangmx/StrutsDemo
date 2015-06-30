package com.chinac.chs.core.task;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import com.chinac.chs.uitls.DateUtils;

public class A {

   public static void main(String[] args) throws ParseException, NotFoundException{
      
      
      /*String time = "2015-06-25 09:20:00";
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
      System.out.println(sdf.parse(time));
      
      System.out.println(637917184 / 1024 );*/
      
      
      
      ClassPool pool = ClassPool.getDefault();  
      CtClass cc = pool.getCtClass("com.chinac.chs.core.bussiness.validate.impl.InstanceValidateImpl");  
      CtClass[] interfaces = cc.getInterfaces();
      String[] paramNames = null;
      for(CtClass inter : interfaces){
         if(cc.getSimpleName().indexOf(inter.getSimpleName()) >= 0){
            CtMethod cm = inter.getDeclaredMethod("modifyInstanceValidate");  
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            paramNames = new String[cm.getParameterTypes().length];
            for (int i = 0; i < paramNames.length; i++) {
              paramNames[i] = attr.variableName(i + pos);
            }
         }
      }
      
      System.out.println(cc.getClass().getClassLoader().getResource(""));
      System.out.println(cc.getName());
   }
   
   public static String[] getParaterNames(Class<?> clazz, Method method) throws Exception{
      ClassPool pool = ClassPool.getDefault(); 
      pool.appendClassPath(new ClassClassPath(clazz));  
      CtClass cc = pool.get(clazz.getName());
      CtClass[] interfaces = cc.getInterfaces();
      String[] paramNames = null;
      for(CtClass inter : interfaces){
         if(cc.getSimpleName().indexOf(inter.getSimpleName()) >= 0){
            CtMethod cm = inter.getDeclaredMethod(method.getName());  
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            paramNames = new String[cm.getParameterTypes().length];
            for (int i = 0; i < paramNames.length; i++) {
              paramNames[i] = attr.variableName(i + pos);
            }
         }
      }
      return paramNames;
   }

}
