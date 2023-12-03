package com.buildfor2030.api.Builders.repository;

import com.buildfor2030.api.Builders.model.Bookmark;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.common.enumeration.BookmarkableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark findFirstByBookmarkableTypeAndBookmarkableIdAndBuilder(BookmarkableType bookmarkableType, Long bookmarkableId, Builder builder);
}
