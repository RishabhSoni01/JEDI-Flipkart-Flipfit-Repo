package com.flipkart.bean;

/**
 * Represents a role within the FlipFit application.
 * This class encapsulates the details of a user's role, including its ID and type.
 *
 * @author Komal
 */
public class FlipFitRole {
    // Unique identifier for the role.
    private Integer roleID;

    // Type of the role (e.g., ADMIN, GYM_OWNER, CUSTOMER).
    private String roleType;

    /**
     * Constructs a FlipFitRole object with the specified role ID and type.
     *
     * @param roleID,roleType
     */
    public FlipFitRole(Integer roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    /**
     * Gets the unique identifier for the role.
     *
     * @return the roleID of the role.
     */
    public Integer getRoleID() {
        return roleID;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param roleID
     */
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     * Gets the type of the role.
     *
     * @return the roleType of the role.
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the type of the role.
     *
     * @param roleType
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
