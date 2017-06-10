package ru.ifmo.alekseyivashin.dto;

/**
 * Creator: aleks
 * Date:    10.06.17
 */
public class RecommendationDTO {
    private Integer courseId;
    private Double rating;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
