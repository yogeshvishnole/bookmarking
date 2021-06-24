package com.yogeshvishnole.bookmarking.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.yogeshvishnole.bookmarking.constants.MovieGenre;
import com.yogeshvishnole.bookmarking.manager.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// test 1 genre is horror --> return false

		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("For movie with genre horror -- isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// test 2 genre is thriller --> return false
		
		 movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("For movie with genre thriller -- isKidFriendlyEligible() must return false", isKidFriendlyEligible);

	}

}
