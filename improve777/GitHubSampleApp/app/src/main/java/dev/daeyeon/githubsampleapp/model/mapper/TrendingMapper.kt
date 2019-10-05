package dev.daeyeon.githubsampleapp.model.mapper

import dev.daeyeon.domain.entity.TrendingDeveloper
import dev.daeyeon.domain.entity.TrendingRepo
import dev.daeyeon.githubsampleapp.model.TrendingDeveloperModel
import dev.daeyeon.githubsampleapp.model.TrendingRepoModel

fun TrendingRepo.toPresentation() =
    TrendingRepoModel(
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

fun TrendingDeveloper.toPresentation() =
    TrendingDeveloperModel(
        avatar = avatar,
        name = name,
        type = type,
        url = url,
        username = username
    )