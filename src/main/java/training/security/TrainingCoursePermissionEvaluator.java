package training.security;

import training.model.TrainingCourseFeedback;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class TrainingCoursePermissionEvaluator implements PermissionEvaluator {

  @Override
  public boolean hasPermission(Authentication authentication, Object target, Object permission) {
    if (target instanceof TrainingCourseFeedback) {
      TrainingCourseFeedback feedback = (TrainingCourseFeedback) target;

      if (permission.equals("list")) {
        feedback.setDeletable(canDelete(authentication, feedback));
        return canList(authentication, feedback);
      } else if (permission.equals("delete")) {
        return canDelete(authentication, feedback);
      }
    }

    throw new UnsupportedOperationException("hasPermission not supported for object <"+target+"> and permission <"+permission+">");
  }

  @Override
  public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    throw new UnsupportedOperationException("Not supported");
  }

  private boolean hasRole(Authentication authentication, String roleName) {
    for (GrantedAuthority authority : authentication.getAuthorities()) {
      if (authority.getAuthority().equals(roleName)) {
        return true;
      }
    }
    return false;
  }

  private boolean isEntityOwner(Authentication authentication, TrainingCourseFeedback entity) {
    return authentication.getName().equals(entity.getVisitor().getName());
  }

  private boolean canDelete(Authentication authentication, TrainingCourseFeedback entity) {
    boolean isEntityOwner = isEntityOwner(authentication, entity);
    boolean canDeleteAll = hasRole(authentication, "ROLE_RIGHT_DELETE_ALL");
    boolean canDeleteOwn = hasRole(authentication, "ROLE_RIGHT_DELETE_OWN");
    return canDeleteAll || (canDeleteOwn && isEntityOwner);
  }

  private boolean canList(Authentication authentication, TrainingCourseFeedback entity) {
    boolean isEntityOwner = isEntityOwner(authentication, entity);
    boolean canListAll = hasRole(authentication, "ROLE_RIGHT_LIST_ALL");
    boolean canListOwn = hasRole(authentication, "ROLE_RIGHT_LIST_OWN");
    return canListAll || (canListOwn && isEntityOwner);
  }
}
