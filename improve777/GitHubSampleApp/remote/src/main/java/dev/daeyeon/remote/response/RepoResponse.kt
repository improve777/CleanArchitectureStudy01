package dev.daeyeon.remote.response


import com.google.gson.annotations.SerializedName

data class RepoResponse(
    @SerializedName("private")
    val `private`: Boolean,
    @SerializedName("archive_url")
    val archiveUrl: String,
    @SerializedName("archived")
    val archived: Boolean,
    @SerializedName("assignees_url")
    val assigneesUrl: String,
    @SerializedName("blobs_url")
    val blobsUrl: String,
    @SerializedName("branches_url")
    val branchesUrl: String,
    @SerializedName("clone_url")
    val cloneUrl: String,
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    @SerializedName("commits_url")
    val commitsUrl: String,
    @SerializedName("compare_url")
    val compareUrl: String,
    @SerializedName("contents_url")
    val contentsUrl: String,
    @SerializedName("contributors_url")
    val contributorsUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("default_branch")
    val defaultBranch: String,
    @SerializedName("deployments_url")
    val deploymentsUrl: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("downloads_url")
    val downloadsUrl: String,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("fork")
    val fork: Boolean,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("forks_url")
    val forksUrl: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String,
    @SerializedName("git_refs_url")
    val gitRefsUrl: String,
    @SerializedName("git_tags_url")
    val gitTagsUrl: String,
    @SerializedName("git_url")
    val gitUrl: String,
    @SerializedName("has_downloads")
    val hasDownloads: Boolean,
    @SerializedName("has_issues")
    val hasIssues: Boolean,
    @SerializedName("has_pages")
    val hasPages: Boolean,
    @SerializedName("has_projects")
    val hasProjects: Boolean,
    @SerializedName("has_wiki")
    val hasWiki: Boolean,
    @SerializedName("homepage")
    val homepage: Any,
    @SerializedName("hooks_url")
    val hooksUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String,
    @SerializedName("issue_events_url")
    val issueEventsUrl: String,
    @SerializedName("issues_url")
    val issuesUrl: String,
    @SerializedName("keys_url")
    val keysUrl: String,
    @SerializedName("labels_url")
    val labelsUrl: String,
    @SerializedName("language")
    val language: String?,
    @SerializedName("languages_url")
    val languagesUrl: String,
    @SerializedName("license")
    val license: LicenseResponse?,
    @SerializedName("merges_url")
    val mergesUrl: String,
    @SerializedName("milestones_url")
    val milestonesUrl: String,
    @SerializedName("mirror_url")
    val mirrorUrl: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("notifications_url")
    val notificationsUrl: String,
    @SerializedName("open_issues")
    val openIssues: Int,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int,
    @SerializedName("owner")
    val owner: OwnerResponse,
    @SerializedName("pulls_url")
    val pullsUrl: String,
    @SerializedName("pushed_at")
    val pushedAt: String,
    @SerializedName("releases_url")
    val releasesUrl: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("ssh_url")
    val sshUrl: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("stargazers_url")
    val stargazersUrl: String,
    @SerializedName("statuses_url")
    val statusesUrl: String,
    @SerializedName("subscribers_url")
    val subscribersUrl: String,
    @SerializedName("subscription_url")
    val subscriptionUrl: String,
    @SerializedName("svn_url")
    val svnUrl: String,
    @SerializedName("tags_url")
    val tagsUrl: String,
    @SerializedName("teams_url")
    val teamsUrl: String,
    @SerializedName("trees_url")
    val treesUrl: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("watchers")
    val watchers: Int,
    @SerializedName("watchers_count")
    val watchersCount: Int
) {
    data class OwnerResponse(
        @SerializedName("avatar_url")
        val avatarUrl: String,
        @SerializedName("events_url")
        val eventsUrl: String,
        @SerializedName("followers_url")
        val followersUrl: String,
        @SerializedName("following_url")
        val followingUrl: String,
        @SerializedName("gists_url")
        val gistsUrl: String,
        @SerializedName("gravatar_id")
        val grAvatarId: String,
        @SerializedName("html_url")
        val htmlUrl: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("login")
        val login: String,
        @SerializedName("node_id")
        val nodeId: String,
        @SerializedName("organizations_url")
        val organizationsUrl: String,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String,
        @SerializedName("repos_url")
        val reposUrl: String,
        @SerializedName("site_admin")
        val siteAdmin: Boolean,
        @SerializedName("starred_url")
        val starredUrl: String,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("url")
        val url: String
    )

    data class LicenseResponse(
        @SerializedName("key")
        val key: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("node_id")
        val nodeId: String,
        @SerializedName("spdx_id")
        val spdxId: String,
        @SerializedName("url")
        val url: String
    )
}