package com.sc.chris.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtility {
	
	private static SessionFactory sf;

	static{
		//一定要有.configure(),才能加载hibernate.cfg.xml文件！
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}

	public static void setSf(SessionFactory sf) {
		HibernateUtility.sf = sf;
	}
	
	
}
