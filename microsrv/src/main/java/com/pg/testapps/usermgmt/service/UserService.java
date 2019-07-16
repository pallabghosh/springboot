package com.pg.testapps.usermgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;

import com.pg.testapps.usermgmt.domain.User;

@Service
public class UserService {
	private static Integer counter = 3;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "angelina", "jully", "Angelina", "Jully", new Date()));
		users.add(new User(2, "harry", "porter", "Harry", "Porter", new Date()));
		users.add(new User(3, "jonny", "deep", "Jonny", "Deep", new Date()));
	}
	
	public List<User> getAllUser() {
		return users;
	}
	
	public User saveUser(User user) {
		if(null == user.getId()) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id) {
		for(User user: users) {
			if(id == user.getId()) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
