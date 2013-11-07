package training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TRAINING_COURSE")
public class TrainingCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRAINING_COURSE_ID")
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @OneToMany(mappedBy = "course")
  private List<TrainingCourseSection> sections;

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

  public List<TrainingCourseSection> getSections() {
    return sections;
  }

  public void setSections(List<TrainingCourseSection> sections) {
    this.sections = sections;
  }
}
