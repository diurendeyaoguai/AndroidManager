package com.frame.saeasyandroids.db.dao.aonntation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解类辅助实现数据库的操作
 * 
 * @author zhangshun
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
	/**
	 * 指定实体与数据库列的对应关系
	 * 
	 * @return
	 */
	String value();
}
