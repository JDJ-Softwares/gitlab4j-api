package org.gitlab4j.api.models;

import org.gitlab4j.api.GitLabApiForm;

public class GroupParams {

    private String name;
    private String path;
    private String description;
    private String visibility;
    private Boolean shareWithGroupLock;
    private Boolean requireTwoFactorAuthentication;
    private Integer twoFactorGracePeriod;
    private AccessLevel projectCreationLevel;
    private Boolean autoDevopsEnabled;
    private AccessLevel subgroupCreationLevel;
    private Boolean emailsDisabled;
    private Boolean lfsEnabled;
    private Boolean requestAccessEnabled;
    private Integer parentId;
    private Integer sharedRunnersMinutesLimit;
    private Integer extraSharedRunnersMinutesLimit;

    private Boolean membershipLock;
    private Integer fileTemplateProjectId;

    /**
     * The parent group ID for creating nested group. For create only.
     *
     * @param parentId the parent group ID for creating nested group
     * @return this GroupParms instance
     */
    public GroupParams withParentId(Integer parentId) {
	this.parentId = parentId;
	return (this);
    }

    /**
     * Prevent adding new members to project membership within this group.  For update only.
     *
     * @param membershipLock if true, prevent adding new members to project membership within this group
     * @return this GroupParms instance
     */
    public GroupParams withMembershipLock(Boolean membershipLock) {
	this.membershipLock = membershipLock;
	return (this);
    }

    /**
     * The ID of a project to load custom file templates from.  For update only.
     *
     * @param fileTemplateProjectId the ID of a project to load custom file templates from
     * @return this GroupParms instance
     */
    public GroupParams withFileTemplateProjectId(Integer fileTemplateProjectId) {
	this.fileTemplateProjectId = fileTemplateProjectId;
	return (this);
    }

    public GroupParams withName(String name) {
	this.name = name;
	return (this);
    }

    public GroupParams withPath(String path) {
	this.path = path;
	return (this);
    }

    public GroupParams withDescription(String description) {
	this.description = description;
	return (this);
    }

    public GroupParams withVisibility(String visibility) {
	this.visibility = visibility;
	return (this);
    }

    public GroupParams withShareWithGroupLock(Boolean shareWithGroupLock) {
	this.shareWithGroupLock = shareWithGroupLock;
	return (this);
    }

    public GroupParams withRequireTwoFactorAuthentication(Boolean requireTwoFactorAuthentication) {
	this.requireTwoFactorAuthentication = requireTwoFactorAuthentication;
	return (this);
    }

    public GroupParams withTwoFactorGracePeriod(Integer twoFactorGracePeriod) {
	this.twoFactorGracePeriod = twoFactorGracePeriod;
	return (this);
    }

    public GroupParams withProjectCreationLevel(AccessLevel projectCreationLevel) {
	this.projectCreationLevel = projectCreationLevel;
	return (this);
    }

    public GroupParams withAutoDevopsEnabled(Boolean autoDevopsEnabled) {
	this.autoDevopsEnabled = autoDevopsEnabled;
	return (this);
    }

    public GroupParams withSubgroupCreationLevel(AccessLevel subgroupCreationLevel) {
	this.subgroupCreationLevel = subgroupCreationLevel;
	return (this);
    }

    public GroupParams withEmailsDisabled(Boolean emailsDisabled) {
	this.emailsDisabled = emailsDisabled;
	return (this);
    }

    public GroupParams withLfsEnabled(Boolean lfsEnabled) {
	this.lfsEnabled = lfsEnabled;
	return (this);
    }

    public GroupParams withRequestAccessEnabled(Boolean requestAccessEnabled) {
	this.requestAccessEnabled = requestAccessEnabled;
	return (this);
    }

    public GroupParams withSharedRunnersMinutesLimit(Integer sharedRunnersMinutesLimit) {
	this.sharedRunnersMinutesLimit = sharedRunnersMinutesLimit;
	return (this);
    }

    public GroupParams withExtraSharedRunnersMinutesLimit(Integer extraSharedRunnersMinutesLimit) {
	this.extraSharedRunnersMinutesLimit = extraSharedRunnersMinutesLimit;
	return (this);
    }

    /**
     * Get the form params for a group create oir update call.
     *
     * @param isCreate set to true for a create group call, false for update
     * @return a GitLabApiForm instance holding the parameters for the group create or update operation
     * @throws RuntimeException if required parameters are missing
     */
    public GitLabApiForm getForm(boolean isCreate) {

	GitLabApiForm form = new GitLabApiForm()
	    .withParam("name", name, isCreate)
            .withParam("path", path, isCreate)
            .withParam("description", description)
            .withParam("visibility", visibility)
            .withParam("share_with_group_lock", shareWithGroupLock)
            .withParam("require_two_factor_authentication", requireTwoFactorAuthentication)
            .withParam("two_factor_grace_period", twoFactorGracePeriod)
            .withParam("project_creation_level", projectCreationLevel)
            .withParam("auto_devops_enabled", autoDevopsEnabled)
            .withParam("subgroup_creation_level", subgroupCreationLevel)
            .withParam("emails_disabled", emailsDisabled)
            .withParam("lfs_enabled", lfsEnabled)
            .withParam("request_access_enabled", requestAccessEnabled)
            .withParam("shared_runners_minutes_limit", sharedRunnersMinutesLimit)
            .withParam("extra_shared_runners_minutes_limit", extraSharedRunnersMinutesLimit);

        if (isCreate) {
            form.withParam("parent_id", parentId);
        } else {
            form.withParam("membership_lock", membershipLock)
                .withParam("file_template_project_id", fileTemplateProjectId);
        }

        return (form);
    }
}