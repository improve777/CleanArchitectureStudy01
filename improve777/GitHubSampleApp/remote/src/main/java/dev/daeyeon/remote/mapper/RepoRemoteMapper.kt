package dev.daeyeon.remote.mapper

import dev.daeyeon.domain.entity.Repo
import dev.daeyeon.remote.response.RepoResponse

class RepoRemoteMapper {
    fun toRepo(repoResponse: RepoResponse) =
        with(repoResponse) {
            Repo(
                id = id.toLong(),
                repoName = name,
                ownerName = owner.login,
                repoUrl = htmlUrl,
                starCount = stargazersCount,
                watchersCount = watchersCount,
                language = language,
                licenseName = license?.name,
                forksCount = forks
            )
        }
}
