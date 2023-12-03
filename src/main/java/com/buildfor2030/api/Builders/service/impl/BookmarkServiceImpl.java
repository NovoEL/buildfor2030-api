package com.buildfor2030.api.Builders.service.impl;

import com.buildfor2030.api.Builders.dto.BookmarkDTO;
import com.buildfor2030.api.Builders.model.Bookmark;
import com.buildfor2030.api.Builders.model.Builder;
import com.buildfor2030.api.Builders.repository.BookmarkRepository;
import com.buildfor2030.api.Builders.service.BookmarkService;
import com.buildfor2030.api.Builders.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private BuilderService builderService;

    public void bookmark(BookmarkDTO dto) {
        Builder builder = builderService.getCurrentBuilder();
        Optional<Bookmark> bookmarkOptional = Optional.ofNullable(bookmarkRepository.findFirstByBookmarkableTypeAndBookmarkableIdAndBuilder(dto.getBookmarkableType(), dto.getBookmarkableId(), builder));
        if (bookmarkOptional.isEmpty()) {
            Bookmark bookmark = new Bookmark(dto.getBookmarkableType(), dto.getBookmarkableId(), builder);
            bookmark.setCreatedAt(new Date());
            bookmarkRepository.save(bookmark);
            builder.addBookmark(bookmark);
            return;
        }
        Bookmark bookmark = bookmarkOptional.get();
        builder.removeBookmark(bookmark);
        bookmarkRepository.delete(bookmark);
    }
}
