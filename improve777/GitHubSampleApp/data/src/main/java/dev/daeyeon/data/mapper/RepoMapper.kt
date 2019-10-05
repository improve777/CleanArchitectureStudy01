package dev.daeyeon.data.mapper

import dev.daeyeon.data.local.entity.RepoEntity
import dev.daeyeon.domain.entity.Repo

class RepoMapper {

    fun toRepo(repoEntity: RepoEntity) =
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
            RepoEntity(
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

