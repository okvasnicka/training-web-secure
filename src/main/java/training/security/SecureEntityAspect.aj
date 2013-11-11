package training.security;

import javax.persistence.Transient;

// DONE 13: Default SecureEntity implementation mixin
// (makes TrainingCourseFeedback contain the default implementation of SecureEntity interface)

public aspect SecureEntityAspect {

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
