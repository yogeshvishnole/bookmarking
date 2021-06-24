package com.yogeshvishnole.bookmarking.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yogeshvishnole.bookmarking.constants.BookGenre;
import com.yogeshvishnole.bookmarking.manager.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// test 1 book with genre philosophy return false

		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For genre of book philosophy - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test 2 book with genre self help return false

		book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
		isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For genre of book self help - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

	}

}
