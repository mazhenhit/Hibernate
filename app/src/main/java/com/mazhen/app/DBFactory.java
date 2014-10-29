package com.mazhen.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mazhen.hibernate.Myuser;

//已看
public class DBFactory {
	
	private static final DBFactory _instance = new DBFactory();
	private SessionFactory storeSF;
	private Configuration vConfig;;
	private DBFactory(){
		if (this.vConfig == null){
			this.vConfig = new Configuration();
			vConfig.configure("config/hibernate.cfg.xml");
		}
	}
	public static DBFactory getInstance(){
		return _instance;
	}
	public SessionFactory getStoreSessionFactory(){
		if (this.storeSF == null){
			this.storeSF = vConfig.buildSessionFactory();
		}
		return this.storeSF;
	}
	
	public static void main(String[] args){
		Session sess = DBFactory.getInstance().getStoreSessionFactory().openSession();
		List<Myuser> us = (List<Myuser>)sess.createQuery("from Myuser").list();
		for(Myuser u : us)
		{
			System.out.println(u.getUsername());
		}
	}
}
