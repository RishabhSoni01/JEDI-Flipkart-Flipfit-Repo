package com.flipkart.bean;
/*
 * @author Khushi Srivastava
 * @params This class does not have any parameters.
 * @throws This class does not throw any exceptions
 */
public class FlipFitRole {
    private Integer roleID;
    private String roleType;

    /* Constructor to initialize a Role object.
     @Parameters:
     roleID: ID of the role.
     roleType: Type of the role.
     */
    public FlipFitRole(Integer roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    // Getter for roleID.
    public Integer getRoleID() {
        return roleID;
    }

    // Setter for roleID.
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    // Getter for roleType.
    public String getRoleType() {
        return roleType;
    }

    // Setter for roleType.
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
