package com.yogeshvishnole.bookmarking;

import com.yogeshvishnole.bookmarking.constants.KidFriendlyStatus;
import com.yogeshvishnole.bookmarking.constants.UserType;
import com.yogeshvishnole.bookmarking.controllers.BookmarkController;
import com.yogeshvishnole.bookmarking.entities.Bookmark;
import com.yogeshvishnole.bookmarking.entities.User;
import com.yogeshvishnole.bookmarking.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {

				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New item bookmarked -- " + bookmark);
					}
				}

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					// mark as kid friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
							System.out.println("Kid friendly status : " + kidFriendlyStatus + ", MarkedBy : "
									+ user.getEmail() + " , " + bookmark);
						}
					}

					// Sharing!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
                        boolean isShared =  getShareDecision();
                        if(isShared) {
                        	BookmarkController.getInstance().share(user,bookmark);
                        }
					}
				}
			}
		}

	}
	
	// TODO Below methods simulate user methods , after IO we take input from console

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {

		return Math.random() < 0.5 ? true : false;
	}

}
