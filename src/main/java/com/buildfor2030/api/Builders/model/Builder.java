package com.buildfor2030.api.Builders.model;

import com.buildfor2030.api.BigIdeas.model.BigIdeaFollow;
import com.buildfor2030.api.BigIdeas.vo.BigIdeaVO;
import com.buildfor2030.api.Builders.vo.BookmarksVO;
import com.buildfor2030.api.Builders.vo.BuilderVO;
import com.buildfor2030.api.SolutionIdeas.model.SolutionIdea;
import com.buildfor2030.api.SolutionIdeas.model.Support;
import com.buildfor2030.api.SolutionIdeas.vo.SolutionIdeaVO;
import com.buildfor2030.api.common.BaseEntityA;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "builders")
public class Builder extends BaseEntityA {

    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String username;

    private String avatarUrl;

    private String bio;

    @OneToMany(mappedBy = "builder")
    private List<SolutionIdea> ideas = new ArrayList<>();

    @OneToMany(mappedBy = "following")
    private List<Follow> followers = new ArrayList<>();

    @OneToMany(mappedBy = "follower")
    private List<Follow> following = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<BigIdeaFollow> bigIdeaFollowing = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<Support> supporting = new ArrayList<>();

    @OneToMany(mappedBy = "builder")
    private List<Bookmark> bookmarks = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<SolutionIdea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<SolutionIdea> ideas) {
        this.ideas = ideas;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public List<BigIdeaFollow> getBigIdeaFollowing() {
        return bigIdeaFollowing;
    }

    public void setBigIdeaFollowing(List<BigIdeaFollow> bigIdeaFollowing) {
        this.bigIdeaFollowing = bigIdeaFollowing;
    }

    public List<Support> getSupporting() {
        return supporting;
    }

    public void setSupporting(List<Support> supporting) {
        this.supporting = supporting;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void addIdea(SolutionIdea idea) {
        ideas.add(idea);
        idea.setBuilder(this);
    }
    public void removeIdea(SolutionIdea idea)  {
        ideas.remove(idea);
    }

    public Integer getIdeasCount() {
        return ideas.size();
    }

    public List<SolutionIdeaVO> getIdeaList() {
        List<SolutionIdeaVO> ideaList = new ArrayList<>();
        for (SolutionIdea idea : ideas) {
            ideaList.add(new SolutionIdeaVO(idea));
        }
        return ideaList;
    }

    public void addFollower(Follow follow) {
        followers.add(follow);
        follow.setFollowing(this);
    }
    public void removeFollower(Follow follow)  {
        followers.remove(follow);
    }

    public Integer getFollowersCount() {
        return followers.size();
    }

    public List<BuilderVO> getFollowerList() {
        List<BuilderVO> followerList = new ArrayList<>();
        for (Follow follow : followers) {
            followerList.add(follow.getFollowerVO());
        }
        return followerList;
    }

    public void addFollowing(Follow follow) {
        following.add(follow);
        follow.setFollowing(this);
    }
    public void removeFollowing(Follow follow)  {
        following.remove(follow);
    }

    public Integer getFollowingCount() {
        return following.size();
    }

    public List<BuilderVO> getFollowingList() {
        List<BuilderVO> followingList = new ArrayList<>();
        for (Follow follow : following) {
            followingList.add(follow.getFollowingVO());
        }
        return followingList;
    }

    public void addBigIdeaFollowing(BigIdeaFollow follow) {
        bigIdeaFollowing.add(follow);
        follow.setBuilder(this);
    }
    public void removeBigIdeaFollowing(BigIdeaFollow follow)  {
        bigIdeaFollowing.remove(follow);
    }
    public Integer getBigIdeaFollowingCount() {
        return bigIdeaFollowing.size();
    }

    public List<BigIdeaVO> getBigIdeaFollowingList() {
        List<BigIdeaVO> bigIdeaList = new ArrayList<>();
        for (BigIdeaFollow follow : bigIdeaFollowing) {
            bigIdeaList.add(follow.getBigIdeaVO());
        }
        return bigIdeaList;
    }

    public void addSupporting(Support support) {
        this.supporting.add(support);
        support.setBuilder(this);
    }

    public void removeSupporting(Support support) {
        supporting.remove(support);
    }

    public Integer getSupportingCount() {
        return supporting.size();
    }

    public List<SolutionIdeaVO> getSupportingList() {
        List<SolutionIdeaVO> supportingList = new ArrayList<>();
        for (Support support : supporting) {
            supportingList.add(new SolutionIdeaVO(support.getIdea()));
        }
        return supportingList;
    }

    public void addBookmark(Bookmark bookmark) {
        this.bookmarks.add(bookmark);
        bookmark.setUser(this);
    }

    public void removeBookmark(Bookmark bookmark) {
        bookmarks.remove(bookmark);
    }

    public Integer getBookmarksCount() {
        return bookmarks.size();
    }

    public BookmarksVO getBookmarksVO() {
        BookmarksVO bookmarksVO = new BookmarksVO();
        for (Bookmark bookmark : bookmarks) {
            switch (bookmark.getBookmarkableType()) {
                case SOLUTION_IDEA:
                    bookmarksVO.addIdeaBookmark(bookmark);
                    break;
                case API:
                    bookmarksVO.addAPIBookmark(bookmark);
                    break;
            }
        }
        return bookmarksVO;
    }

}
