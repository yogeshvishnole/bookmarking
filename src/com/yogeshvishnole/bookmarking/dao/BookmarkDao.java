package com.yogeshvishnole.bookmarking.dao;

import com.yogeshvishnole.bookmarking.DataStore;
import com.yogeshvishnole.bookmarking.entities.Bookmark;
import com.yogeshvishnole.bookmarking.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);

	}
}
