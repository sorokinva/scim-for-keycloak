package de.captaingoldfish.scim.sdk.keycloak.scim.handler.filtering.filtersetup;

import org.keycloak.models.jpa.entities.UserEntity;

import de.captaingoldfish.scim.sdk.keycloak.entities.ScimEmailsEntity;
import de.captaingoldfish.scim.sdk.keycloak.entities.ScimUserAttributesEntity;
import lombok.Getter;


/**
 * This class is used to make sure that the same shortcuts for JPQL entity references are used in different
 * places
 * 
 * @author Pascal Knueppel
 * @since 12.12.2022
 */
public enum JpqlTableShortcuts
{

  USER_ENTITY("u", null, UserEntity.class),
  SCIM_USER_ATTRIBUTES("ua", "userEntity", ScimUserAttributesEntity.class),
  SCIM_EMAILS("ue", "userAttributes", ScimEmailsEntity.class);

  /**
   * the JPQL identifier that should identify a specific entity
   */
  @Getter
  private String identifier;

  /**
   * the entity attribute-reference to this tables parent
   */
  @Getter
  private String parentReference;

  /**
   * the JPA entity class type
   */
  private Class entityType;

  JpqlTableShortcuts(String identifier, String parentReference, Class entityType)
  {
    this.identifier = identifier;
    this.parentReference = parentReference;
    this.entityType = entityType;
  }

  /**
   * @return the name of the JPA entity as it must be added into a JPQL query
   */
  public String getTableName()
  {
    return entityType.getSimpleName();
  }
}
