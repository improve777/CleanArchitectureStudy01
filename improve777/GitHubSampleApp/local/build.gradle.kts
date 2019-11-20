plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Libraries.kotlin)
    implementation(Libraries.ktxCore)

    // test
    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidJunit)
    androidTestImplementation(Libraries.espresso)

    // rxJava
    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

    // timber
    implementation(Libraries.timber)

    // room
    api(Libraries.room)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)
    implementation(Libraries.roomRxJava)
}