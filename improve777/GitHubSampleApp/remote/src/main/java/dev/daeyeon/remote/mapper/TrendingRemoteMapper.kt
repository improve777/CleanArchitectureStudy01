package dev.daeyeon.remote.mapper

import dev.daeyeon.domain.entity.Language
import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.remote.response.LanguageResponse
import dev.daeyeon.remote.response.TrendingDeveloperResponse
import dev.daeyeon.remote.response.TrendingRepoResponse

class TrendingRemoteMapper {

    fun toLanguage(languageResponse: LanguageResponse) =
        with(languageResponse) {
            Language(
                id = urlParam,
                name = name
            )
        }

    fun toTrendingRepo(trendingRepoResponse: TrendingRepoResponse) =
        with(trendingRepoResponse) {
            TrendingRepo(
                author = author,
                avatar = avatar,
                currentPeriodStars = currentPeriodStars,
                description = description,
                forks = forks,
                language = language,
                languageColor = languageColor,
                name = name,
                stars = stars,
                url = url
            )
        }

    fun toTrendingDeveloper(trendingDeveloperResponse: TrendingDeveloperResponse) =
        with(trendingDeveloperResponse) {
            TrendingDeveloper(
                avatar = avatar,
                name = name,
                type = type,
                url = url,
                username = username
            )
        }
}
