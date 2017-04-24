package com.learn.day1.main;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learn.day1.mapper.PojoMapper;
import com.learn.day1.pojo.Pojo;

public class Main {
	public static void main(String[] args){
		SqlSession ss = null;
		try {
			SqlSessionFactory ssf = 
					new SqlSessionFactoryBuilder().build(Resources.
							getResourceAsStream("mybatis-config.xml"));
			ss = ssf.openSession();
			PojoMapper mapper = ss.getMapper(PojoMapper.class);
			Pojo pojo = mapper.selectPojo(1L);
			System.out.println(pojo.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(ss != null){
				ss.close();
			}
		}
	}
}
