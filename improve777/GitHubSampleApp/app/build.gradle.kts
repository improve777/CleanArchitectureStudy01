plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Modules.data))
    implementation(project(Modules.local))
    implementation(project(Modules.remote))
    implementation(project(Modules.domain))
    implementation(project(Modules.common))

    implementation(Libraries.kotlin)
    implementation(Libraries.appcompat)
    implementation(Libraries.material)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)

    // navigation
    implementation(Libraries.navigationUiKtx)
    implementation(Libraries.navigationFragmentKtx)

    // test
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidJunit)
    androidTestImplementation(Libraries.espresso)

    // koin
    implementation(Libraries.koinCore)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinViewModel)

    // retrofit
    implementation(Libraries.retrofit)

    // rxJava
    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)

    // timber
    implementation(Libraries.timber)

    // glide
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // anko
    implementation(Libraries.anko)

    // tedPermission
    implementation(Libraries.tedPermission)

    // kakao
    implementation(Libraries.kakaoUserMgmt)
    implementation(Libraries.kakaoTalk)
}