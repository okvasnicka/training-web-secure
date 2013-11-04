package training.security;

import javax.persistence.Transient;

public aspect SecureEntityAspect {

  // no need for entity classes to implement SecureEntity explicitly, this
  // line will do it from here
  declare parents : training.model.TrainingCourseFeedback implements SecureEntity;

  @Transient
  private transient boolean SecureEntity.deletable = false;

  public boolean SecureEntity.isDeletable() {
    return deletable;
  }

  public void SecureEntity.setDeletable(boolean deletable) {
    this.deletable = deletable;
  }

}
