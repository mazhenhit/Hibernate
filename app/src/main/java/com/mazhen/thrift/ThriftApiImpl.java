package com.mazhen.thrift;

import java.util.List;

import org.apache.thrift.TException;
import org.hibernate.Session;

import com.mazhen.app.DBFactory;
import com.mazhen.hibernate.Myuser;
import com.mazhen.thrift.service2.Iface;

public class ThriftApiImpl implements Iface {

	public boolean login(User user) throws TException {
		Session sess = DBFactory.getInstance().getStoreSessionFactory().openSession();
		Myuser u = (Myuser)sess.createQuery("from Myuser where username=?").setString(0, user.name).uniqueResult();
		if(u != null && u.getPassword().equals(user.password)) {
			return true;
		}
		return false;
	}
}
