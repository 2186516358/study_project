package com.example.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemberLevel implements Serializable {

    private Integer id;
    private String levelTitle;
    private String levelDetail;
    private byte[] levelPic;
    private Set<MemberInfo> memberInfos = new HashSet<>(0);


    public MemberLevel() {
    }
    public MemberLevel(Integer id) {
        this.id = id;
    }

    public MemberLevel(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public MemberLevel(String levelTitle, String levelDetail, byte[] levelPic,
                       Set<MemberInfo> memberInfos) {
        this.levelTitle = levelTitle;
        this.levelDetail = levelDetail;
        this.levelPic = levelPic;
        this.memberInfos = memberInfos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }

    public String getLevelDetail() {
        return levelDetail;
    }

    public void setLevelDetail(String levelDetail) {
        this.levelDetail = levelDetail;
    }

    public byte[] getLevelPic() {
        return levelPic;
    }

    public void setLevelPic(byte[] levelPic) {
        this.levelPic = levelPic;
    }

    public Set<MemberInfo> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(Set<MemberInfo> memberInfos) {
        this.memberInfos = memberInfos;
    }

    @Override
    public String toString() {
        return "MemberLevel{" +
                "id=" + id +
                ", levelTitle='" + levelTitle + '\'' +
                ", levelDetail='" + levelDetail + '\'' +
                ", levelPic=" + Arrays.toString(levelPic) +
                ", memberInfos=" + memberInfos +
                '}';
    }
}
