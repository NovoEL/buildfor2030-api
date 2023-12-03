package com.buildfor2030.api.Builders.api;

import com.buildfor2030.api.Builders.vo.BuilderProfileVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.Builders.dto.BuilderProfileDTO;
import com.buildfor2030.api.Builders.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/builders")
public class BuilderController {

    @Autowired
    private BuilderService builderService;

    @GetMapping
    public ResponseEntity<List<BuilderVO>> getAllBuilders() {
        List<BuilderVO> users = builderService.retrieveAllBuilders();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{username}/profile")
    public ResponseEntity<BuilderProfileVO> getBuilderProfile(@PathVariable String username) {
        BuilderProfileVO profile = builderService.retrieveBuilderProfile(username);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PutMapping("/me/profile")
    public ResponseEntity<BuilderProfileVO> editBuilderProfile(@RequestBody BuilderProfileDTO request) {
        //TODO check permission
        BuilderProfileVO profile = builderService.updateBuilderProfile(request);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/{username}/followers")
    public ResponseEntity<Void> follow(@PathVariable String username) {
        builderService.follow(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
