package com.example.http_lib.response;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/8/12
 */
public class UserInfoBean {


    /**
     * userScore : 0.0
     * userId : 6629
     * userHeadPortrait : http://media.mxingm.com/default/9.png
     * userWeight : 0
     * userPassword : e10adc3949ba59abbe56e057f20f883e
     * userNimToken :
     * userHeight : 0
     * userSn : U15662722
     * userBirthday : 1565609317799
     * userSex : 0
     * userTel : 15711962025
     * userBrowseNum : 0
     * userIdentification : 0
     * key : 952ad48a9420ca34
     * userIdentificationTime : 0
     * userAccount : 15711962025
     * createTime : 1565609317803
     * userConstellation : 狮子座
     * userInfomationId : 0
     * userNickName : 157****2025
     * userIdentifying : 1
     */

    private double userScore;
    private long userId;
    private String userHeadPortrait;
    private float userWeight;
    private String userPassword;
    private String userNimToken;
    private float userHeight;
    private String userSn;
    private long userBirthday;
    private int userSex;
    private String userTel;
    private float userBrowseNum;
    private int userIdentification;
    private String key;
    private long userIdentificationTime;
    private String userAccount;
    private long createTime;
    private String userConstellation;
    private long userInfomationId;
    private String userNickName;
    private int userIdentifying;

    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(double userScore) {
        this.userScore = userScore;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    public float getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(float userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNimToken() {
        return userNimToken;
    }

    public void setUserNimToken(String userNimToken) {
        this.userNimToken = userNimToken;
    }

    public float getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(float userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn;
    }

    public long getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(long userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public float getUserBrowseNum() {
        return userBrowseNum;
    }

    public void setUserBrowseNum(float userBrowseNum) {
        this.userBrowseNum = userBrowseNum;
    }

    public int getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(int userIdentification) {
        this.userIdentification = userIdentification;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getUserIdentificationTime() {
        return userIdentificationTime;
    }

    public void setUserIdentificationTime(long userIdentificationTime) {
        this.userIdentificationTime = userIdentificationTime;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getUserConstellation() {
        return userConstellation;
    }

    public void setUserConstellation(String userConstellation) {
        this.userConstellation = userConstellation;
    }

    public long getUserInfomationId() {
        return userInfomationId;
    }

    public void setUserInfomationId(long userInfomationId) {
        this.userInfomationId = userInfomationId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public int getUserIdentifying() {
        return userIdentifying;
    }

    public void setUserIdentifying(int userIdentifying) {
        this.userIdentifying = userIdentifying;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "userScore=" + userScore +
                ", userId=" + userId +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", userWeight=" + userWeight +
                ", userPassword='" + userPassword + '\'' +
                ", userNimToken='" + userNimToken + '\'' +
                ", userHeight=" + userHeight +
                ", userSn='" + userSn + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex=" + userSex +
                ", userTel='" + userTel + '\'' +
                ", userBrowseNum=" + userBrowseNum +
                ", userIdentification=" + userIdentification +
                ", key='" + key + '\'' +
                ", userIdentificationTime=" + userIdentificationTime +
                ", userAccount='" + userAccount + '\'' +
                ", createTime=" + createTime +
                ", userConstellation='" + userConstellation + '\'' +
                ", userInfomationId=" + userInfomationId +
                ", userNickName='" + userNickName + '\'' +
                ", userIdentifying=" + userIdentifying +
                '}';
    }
}
