package training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING_COURSE_SECTION")
public class TrainingCourseSection {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_SECTION_ID")
  Long id;

  @Column(name = "NAME", nullable = false)
  String name;

  @ManyToOne
  @JoinColumn(name = "TRAINING_COURSE_ID", nullable = false)
  private TrainingCourse course;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TrainingCourse getCourse() {
    return course;
  }

  public void setCourse(TrainingCourse course) {
    this.course = course;
  }
}
