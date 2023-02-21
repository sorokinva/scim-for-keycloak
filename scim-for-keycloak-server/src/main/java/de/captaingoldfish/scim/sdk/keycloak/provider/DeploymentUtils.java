// LIGHTRUN SCIM POC CHANGES START
package de.captaingoldfish.scim.sdk.keycloak.provider;

public class DeploymentUtils
{

  public static final String DEPLOYMENT_PROPERTY = "INFO_DEPLOYMENT";

  public static final String SAAS_DEPLOYMENT = "SaaS";

  public static final String SIGNEL_TENANT_DEPLOYMENT = "single-tenant";

  public static final String ON_PREM_DEPLOYMENT = "on-prem";

  public static final String AUTO_JOIN_COMPANY_FLAG = "auto-join-company";

  public boolean isSaasDeployment()
  {
    return SAAS_DEPLOYMENT.equals(getDeploymentType());
  }

  public String getDeploymentType()
  {
    return System.getenv(DEPLOYMENT_PROPERTY);
  }

  public String getAutoJoinCompany()
  {
    return isSaasDeployment() ? null : System.getProperty(AUTO_JOIN_COMPANY_FLAG, "DefaultCompany");
  }
}
// LIGHTRUN SCIM POC CHANGES END
