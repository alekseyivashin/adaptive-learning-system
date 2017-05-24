package ru.ifmo.alekseyivashin.dto;

import java.util.Date;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

public class UserCourseDTO {

    private Integer userId;
    private Integer courseId;
    private Date startDate;
    private Date endDate;
    private Double startScore;
    private Double endScore;
    private Integer rating;
    private Double progress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getStartScore() {
        return startScore;
    }

    public void setStartScore(Double startScore) {
        this.startScore = startScore;
    }

    public Double getEndScore() {
        return endScore;
    }

    public void setEndScore(Double endScore) {
        this.endScore = endScore;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "UserCourseDTO{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startScore=" + startScore +
                ", endScore=" + endScore +
                ", rating=" + rating +
                ", progress=" + progress +
                '}';
    }
}
