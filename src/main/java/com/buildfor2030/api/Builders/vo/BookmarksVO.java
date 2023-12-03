package com.buildfor2030.api.Builders.vo;

import com.buildfor2030.api.Builders.model.Bookmark;

import java.util.ArrayList;
import java.util.List;

public class BookmarksVO {

    private Integer ideaBookmarksCount;

    private List<Long> ideaBookmarks = new ArrayList<>();

    private Integer apiBookmarksCount;

    private List<Long> apiBookmarks = new ArrayList<>();

    public Integer getIdeaBookmarksCount() {
        return ideaBookmarksCount;
    }

    public void setIdeaBookmarksCount(Integer ideaBookmarksCount) {
        this.ideaBookmarksCount = ideaBookmarksCount;
    }

    public List<Long> getIdeaBookmarks() {
        return ideaBookmarks;
    }

    public void setIdeaBookmarks(List<Long> ideaBookmarks) {
        this.ideaBookmarks = ideaBookmarks;
    }

    public Integer getAPIBookmarksCount() {
        return apiBookmarksCount;
    }

    public void setAPIBookmarksCount(Integer apiBookmarksCount) {
        this.apiBookmarksCount = apiBookmarksCount;
    }

    public List<Long> getAPIBookmarks() {
        return apiBookmarks;
    }

    public void setAPIBookmarks(List<Long> apiBookmarks) {
        this.apiBookmarks = apiBookmarks;
    }

    public void addIdeaBookmark(Bookmark bookmark) {
        ideaBookmarks.add(bookmark.getBookmarkableId());
        ideaBookmarksCount++;
    }

    public void addAPIBookmark(Bookmark bookmark) {
        apiBookmarks.add(bookmark.getBookmarkableId());
        apiBookmarksCount++;
    }

}
