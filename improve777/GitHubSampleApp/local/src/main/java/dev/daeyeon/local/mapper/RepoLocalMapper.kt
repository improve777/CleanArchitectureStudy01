package dev.daeyeon.local.mapper

import dev.daeyeon.domain.entity.Repo

class RepoLocalMapper {

    fun toRepo(repoEntity: dev.daeyeon.local.entity.RepoEntity) =
        with(repoEntity) {
            Repo(
                id = id,
                repoName = repoName,
                ownerName = ownerName,
                repoUrl = repoUrl,
                starCount = starCount,
                watchersCount = watchersCount,
                language = language,
                licenseName = licenseName,
                forksCount = forksCount
            )
        }


    fun toRepoEntity(repo: Repo) =
        with(repo) {
            dev.daeyeon.local.entity.RepoEntity(
                id = id,
                repoName = repoName,
                ownerName = ownerName,
                repoUrl = repoUrl,
                starCount = starCount,
                watchersCount = watchersCount,
                language = language,
                licenseName = licenseName,
                forksCount = forksCount
            )
        }
}

