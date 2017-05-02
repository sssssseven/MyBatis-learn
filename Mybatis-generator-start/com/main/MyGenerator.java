package com.main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyGenerator {

	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		String resource = "generatorConfig.xml";
		InputStream in;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			in = Resources.getResourceAsStream(resource);
			config = cp.parseConfiguration(in);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
