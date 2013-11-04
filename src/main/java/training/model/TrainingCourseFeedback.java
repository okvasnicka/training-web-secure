package training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "TRAINING_COURSE_FEEDBACK")
public class TrainingCourseFeedback {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_FEEDBACK_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "VISITOR_ID", nullable = false)
  private Visitor visitor;

  @ManyToOne
  @JoinColumn(name = "TRAINING_COURSE_ID", nullable = false)
  private TrainingCourse course;

  @Temporal(TemporalType.DATE)
  @Column(name = "TRAINING_COURSE_DATE", nullable = false)
  private Date date;

  @ManyToOne
  @JoinColumn(name = "FAVORITE_SECTION_ID", nullable = false)
  private TrainingCourseSection favoriteSection;

  @Column(name = "RATING", nullable = false)
  private Integer rating;

  @Column(name = "COMMENT")
  private String comment;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Visitor getVisitor() {
    return visitor;
  }

  public void setVisitor(Visitor visitor) {
    this.visitor = visitor;
  }

  public TrainingCourse getCourse() {
    return course;
  }

  public void setCourse(TrainingCourse course) {
    this.course = course;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public TrainingCourseSection getFavoriteSection() {
    return favoriteSection;
  }

  public void setFavoriteSection(TrainingCourseSection favoriteSection) {
    this.favoriteSection = favoriteSection;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
