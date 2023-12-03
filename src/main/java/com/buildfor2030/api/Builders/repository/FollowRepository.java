package com.buildfor2030.api.Builders.repository;

import com.buildfor2030.api.Builders.model.Follow;
import com.buildfor2030.api.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findFirstByFollowingAndFollower(Builder following, Builder follower);
}
