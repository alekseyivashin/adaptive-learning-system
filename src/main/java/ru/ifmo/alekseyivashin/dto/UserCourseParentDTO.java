package ru.ifmo.alekseyivashin.dto;

import java.util.List;

/**
 * Creator: aleks
 * Date:    26.05.17
 */
public class UserCourseParentDTO {

    private Integer userId;

    private List<UserCourseDTO> courses;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<UserCourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<UserCourseDTO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "UserCourseParentDTO{" +
                "userId=" + userId +
                ", courses=" + courses +
                '}';
    }
}
