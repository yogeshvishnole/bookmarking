package com.yogeshvishnole.bookmarking.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yogeshvishnole.bookmarking.manager.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// test 1 porn in url --> false

		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test 2 porn in title --> false

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test 3 adult in host --> false

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test 4 adult in url but not in host --> true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming tiger,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult-part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertTrue("For adult in url , but not in host part - isKidFriendlyEligible() must return true",
				isKidFriendlyEligible);

		// test 5 adult in title only --> true

		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult,Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		assertTrue("For adult in title , but not in host part - isKidFriendlyEligible() must return true",
				isKidFriendlyEligible);
	}

}
