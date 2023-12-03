package com.buildfor2030.api.Builders.dto;

import com.buildfor2030.api.common.enumeration.BookmarkableType;

public class BookmarkDTO {

    private BookmarkableType bookmarkableType;

    private Long bookmarkableId;

    public BookmarkableType getBookmarkableType() {
        return bookmarkableType;
    }

    public void setBookmarkableType(BookmarkableType bookmarkableType) {
        this.bookmarkableType = bookmarkableType;
    }

    public Long getBookmarkableId() {
        return bookmarkableId;
    }

    public void setBookmarkableId(Long bookmarkableId) {
        this.bookmarkableId = bookmarkableId;
    }
}
