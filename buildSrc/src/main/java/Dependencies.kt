object DefaultConfig {
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29
    const val buildTools = "29.0.3"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    val presentation = ":presentation"
    val domain = ":domain"
    val data = ":data"
}

object Versions {
    const val gradle = "3.5.0"
    const val kotlin = "1.3.72"
    const val KtxCore = "1.2.0"
    const val appCompact = "1.1.0"
    const val cardView = "1.0.0"
    const val recyclerView = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val lifecycle = "2.2.0"
    const val okhttp3 = "4.5.0"
    const val gson = "2.8.6"
    const val stetho = "1.5.1"
    const val retrofit = "2.8.1"
    const val coroutine = "1.3.5"
    const val timber = "4.7.1"
    const val dagger = "2.27"
//    const val koin = "2.0.1"
//    const val koinArchitecture = "0.8.2"
    const val googleMaterial = "1.1.0"
    const val coil = "0.11.0"
    const val securityCrypto = "1.0.0-rc02"
    const val junit = "4.13"
    const val testCoreRunner = "1.2.0"
    const val espresso = "3.2.0"
    const val mockWebServer = "4.2.1"
    const val googleTruth = "1.0"
    const val coreTesting = "1.1.1"
    const val barista = "3.5.0"
    const val androidxJunit = "1.1.1"
    const val fragmentTesting = "1.2.5"
}

object Libs {
    //kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //UI
    const val appCompact = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val ktx = "androidx.core:core-ktx:${Versions.KtxCore}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialDesign = "com.google.android.material:material:${Versions.googleMaterial}"

    //Retrofit2
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //Okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"

    //Stetho interceptor
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

    //dagger
    const val dagger  = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    //Koin
//    const val koinCore = "org.koin:koin-core:${Versions.koin}"
//    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
//    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
//    const val koinArchitecture = "org.koin:koin-android-architecture:${Versions.koinArchitecture}"

    //lifecycle
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    //Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Coil
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val securityEncryption = "androidx.security:security-crypto:${Versions.securityCrypto}"

}

object TestLibs {
    //Unit tests
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidxJunitExtension = "androidx.test.ext:junit-ktx:${Versions.androidxJunit}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
    const val coreTesting = "android.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"

    //UI Android Test
    const val testRunner = "androidx.test:runner:${Versions.testCoreRunner}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val barista = "com.schibsted.spain:barista:${Versions.barista}"
    const val excludeKotlin = "org.jetbrains.kotlin"
    const val fragmentTests = "androidx.fragment:fragment-testing:${Versions.fragmentTesting}"
}