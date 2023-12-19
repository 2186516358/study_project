package com.example.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class MemberInfo implements Serializable {
    private Integer id;
    private String memUsername;
    private String memPassword;
    private MemberLevel memberLevel;
    private String memName;
    private String memAge;
    private String memSex;
    private String memAddress;
    private String memTel;
    private String memPhone;
    private String memEmail;
    private Date regTime;
    private String cardNo;
    private String status;
    private Float memScore;
    private byte[] memPic;

    public MemberInfo() {
    }

    public MemberInfo(MemberLevel memberLevel, String memName, String memPhone,
                      Date regTime) {
        this.memberLevel = memberLevel;
        this.memName = memName;
        this.memPhone = memPhone;
        this.regTime = regTime;
    }

    public MemberInfo(MemberLevel memberLevel, String memName, String memAge,
                      String memSex, String memAddress, String memTel, String memPhone,
                      String memEmail, Date regTime, String cardNo, String status,
                      Float memScore, byte[] memPic) {
        this.memberLevel = memberLevel;
        this.memName = memName;
        this.memAge = memAge;
        this.memSex = memSex;
        this.memAddress = memAddress;
        this.memTel = memTel;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
        this.regTime = regTime;
        this.cardNo = cardNo;
        this.status = status;
        this.memScore = memScore;
        this.memPic = memPic;
    }
    public MemberInfo(MemberLevel memberLevel, String memName, String memAge,
                      String memSex, String memAddress, String memTel, String memPhone,
                      String memEmail, Date regTime, String cardNo, String status,
                      Float memScore) {
        this.memberLevel = memberLevel;
        this.memName = memName;
        this.memAge = memAge;
        this.memSex = memSex;
        this.memAddress = memAddress;
        this.memTel = memTel;
        this.memPhone = memPhone;
        this.memEmail = memEmail;
        this.regTime = regTime;
        this.cardNo = cardNo;
        this.status = status;
        this.memScore = memScore;
    }

    public String getMemUsername() {
        return memUsername;
    }

    public void setMemUsername(String memUsername) {
        this.memUsername = memUsername;
    }

    public String getMemPassword() {
        return memPassword;
    }

    public void setMemPassword(String memPassword) {
        this.memPassword = memPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberLevel getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(MemberLevel memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemAge() {
        return memAge;
    }

    public void setMemAge(String memAge) {
        this.memAge = memAge;
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex;
    }

    public String getMemAddress() {
        return memAddress;
    }

    public void setMemAddress(String memAddress) {
        this.memAddress = memAddress;
    }

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public java.sql.Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getMemScore() {
        return memScore;
    }

    public void setMemScore(Float memScore) {
        this.memScore = memScore;
    }

    public byte[] getMemPic() {
        return memPic;
    }

    public void setMemPic(byte[] memPic) {
        this.memPic = memPic;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", memUsername='" + memUsername + '\'' +
                ", memPassword='" + memPassword + '\'' +
                ", memberLevel=" + memberLevel +
                ", memName='" + memName + '\'' +
                ", memAge='" + memAge + '\'' +
                ", memSex='" + memSex + '\'' +
                ", memAddress='" + memAddress + '\'' +
                ", memTel='" + memTel + '\'' +
                ", memPhone='" + memPhone + '\'' +
                ", memEmail='" + memEmail + '\'' +
                ", regTime=" + regTime +
                ", cardNo='" + cardNo + '\'' +
                ", status='" + status + '\'' +
                ", memScore=" + memScore +
                ", memPic=" + Arrays.toString(memPic) +
                '}';
    }
}
