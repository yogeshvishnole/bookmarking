package com.yogeshvishnole.bookmarking.dao;

import com.yogeshvishnole.bookmarking.DataStore;
import com.yogeshvishnole.bookmarking.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
