package com.buildfor2030.api.Builders.api;

import com.buildfor2030.api.Builders.dto.BookmarkDTO;
import com.buildfor2030.api.Builders.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<Void> bookmark(@RequestBody BookmarkDTO request) {
        bookmarkService.bookmark(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
