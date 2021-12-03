object Config {
    const val applicationId = "com.example.app"
    const val versionCode = 3
    const val versionName = "1.2.0"
}

object BuildPlugins {

    object GradleClassPath {
        const val kotlinVersion = "1.5.31"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

        const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"

        const val hiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Libraries.Hilt.version}"


        const val navSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Libraries.AndroidX.Navigation.version}"

        const val kotlinSerialization =
            "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
    }

    object Apply {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val javaLibrary = "java-library"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinParcelize = "kotlin-parcelize"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlin = "kotlin"
        const val kotlinxSerialization = "kotlinx-serialization"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val daggerHiltPlugin = "dagger.hilt.android.plugin"
        const val safeArgsKotlinPlugin = "androidx.navigation.safeargs.kotlin"
        const val safeArgsPlugin = "androidx.navigation.safeargs"
        const val protoBufPlugin = "com.google.protobuf"
        const val protoBufVersion = "0.8.15"
    }
}

object AndroidSdk {
    const val min = 21
    const val compile = 31
    const val target = compile
    const val buildToolsVersion = "31.0.0"
}

object Libraries {
    const val multidex = "com.android.support:multidex:1.0.3"
    const val material = "com.google.android.material:material:1.4.0"
    const val mpchart = "com.github.PhilJay:MPAndroidChart:v3.1.0"
    const val aachart = "com.github.AAChartModel:AAChartCore-Kotlin:-SNAPSHOT"
    const val faker = "com.github.blocoio:faker:1.2.8"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
        const val ktxCore = "androidx.core:core-ktx:1.6.0"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val worker = "androidx.work:work-runtime-ktx:2.7.0"
        const val browser = "androidx.browser:browser:1.3.0"
        const val startup = "androidx.startup:startup-runtime:1.1.0"

        object Arch {
            private const val version = "2.1.0"
            const val core = "androidx.arch.core:core-common:$version"
            const val runtime = "androidx.arch.core:core-runtime:$version"
            const val test = "androidx.arch.core:core-testing:$version"
        }

        object Navigation {
            const val version = "2.3.5"
            const val core = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val test = "androidx.navigation:navigation-testing:$version"
        }

        object Fragment {
            private const val version = "1.3.6"
            const val core = "androidx.fragment:fragment-ktx:$version"
            const val test = "androidx.fragment:fragment-testing:$version"
        }

        object Hilt {
            private const val version = "1.0.0"
            const val work = "androidx.hilt:hilt-work:$version"
            const val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object DataStore {
            const val version = "1.0.0"
            const val dataStore = "androidx.datastore:datastore-preferences:$version"
            const val dataStoreCore = "androidx.datastore:datastore-core:$version"
            const val dataStoreProtoArtifact = "com.google.protobuf:protoc:3.18.1"
            const val javaLite = "com.google.protobuf:protobuf-javalite:3.18.1"
        }

        object Room {
            private const val version = "2.3.0"
            const val common = "androidx.room:room-common:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val core = "androidx.room:room-ktx:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val test = "androidx.room:room-testing:$version"
            const val sqlcipher = "net.zetetic:android-database-sqlcipher:4.4.2@aar"
            const val sqlite = "androidx.sqlite:sqlite:2.1.0"
        }

        object LifeCycle {
            private const val version = "2.2.0"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Compose {
            const val version = "1.1.0-alpha06"

            const val compiler = "androidx.compose.compiler:compiler:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val animations = "androidx.compose.animation:animation:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val activity = "androidx.activity:activity-compose:1.3.1"


            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
        }

    }

    object Accompanist {
        const val version = "0.20.0"

        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$version"
        const val navigationMaterial =
            "com.google.accompanist:accompanist-navigation-material:$version"
        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val permission = "com.google.accompanist:accompanist-permissions:$version"
        const val system = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
    }

    object Hilt {
        const val version = "2.39.1"
        const val hiltNavigationVersion = "1.0.0-alpha03"
        const val core = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion"
    }

    object Kotlin {
        const val jdk =
            "org.jetbrains.kotlin:kotlin-stdlib:${BuildPlugins.GradleClassPath.kotlinVersion}"

        object Coroutine {
            private const val version = "1.5.2"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val core =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Network {
        const val okio = "com.squareup.okio:okio:2.10.0"

        object OkHttp {
            private const val version = "4.9.2"
            const val core = "com.squareup.okhttp3:okhttp:$version"
            const val logger = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object Retrofit {
            private const val version = "2.9.0"
            private const val retrofitSerializationConverterVersion = "0.8.0"
            const val core = "com.squareup.retrofit2:retrofit:$version"
            const val retrofitKotlinXSerializationConvertor =
                "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitSerializationConverterVersion"
        }
    }

    object Serializable {
        private const val kotlinxSerializationVersion = "1.3.0"
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion"
    }

    object Epoxy {
        private const val version = "4.6.4"
        const val core = "com.airbnb.android:epoxy:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
        const val paging = "com.airbnb.android:epoxy-paging:$version"
    }

    object Scale {
        private const val version = "1.0.6"
        const val ssp = "com.intuit.ssp:ssp-android:$version"
        const val sdp = "com.intuit.sdp:sdp-android:$version"
    }

    object ImageUtils {
        const val coil = "io.coil-kt:coil:1.4.0"
        const val coilCompose = "io.coil-kt:coil-compose:1.4.0"
        const val glide = "com.github.bumptech.glide:glide:4.12.0"
        const val glideCompiler = "com.github.bumptech.glide:compiler:4.12.0"
        const val lottie = "com.airbnb.android:lottie:4.2.0"
    }

    object Firebase {
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val messaging = "com.google.firebase:firebase-messaging-ktx:21.0.1"
        const val cloudMessaging =
            "com.google.firebase:firebase-messaging:22.0.0"
        const val libraryPlatform =
            "com.google.firebase:firebase-bom:28.0.1"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"

    }

    object GoogleCloud {
        private const val googleApiVersion = "1.30.10"
        const val auth = "com.google.android.gms:play-services-auth:19.2.0"
        const val clientGson = "com.google.http-client:google-http-client-gson:1.36.0"
        const val client = "com.google.api-client:google-api-client-android:$googleApiVersion"
        const val drive =
            "com.google.apis:google-api-services-drive:v3-rev20200719-$googleApiVersion"

        const val excludedGroup = "org.apache.httpcomponents"
    }
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
    const val model = ":model"
    const val dataModel = ":data-model"
    const val shared = ":shared"
    const val android_test_shared = ":android-test-shared"
    const val commonAndroid = ":common-android"
    const val commonUi = ":common-ui"
    const val uiHome = ":ui-home"
}

object TestLibraries {

    private object Versions {
        const val junit4 = "4.13.1"
        const val testRunner = "1.1.2"
        const val espresso = "3.3.0"
        const val mockk = "1.11.0"
        const val truth = "1.1"
        const val barista = "3.9.0"
        const val test = "1.2.0"
    }

    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val jUnit = "junit:junit:${Versions.junit4}"
    const val json = "org.json:json:20180813"
    const val truth = "com.google.truth:truth:${Versions.truth}"
    const val barista = "com.schibsted.spain:barista:${Versions.barista}"

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test.ext:junit:${Versions.testRunner}"

    object Espresso {
        const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
        const val idlingResource =
            "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
    }

    object Mockk {
        const val android = "io.mockk:mockk-android:${Versions.mockk}"
        const val core = "io.mockk:mockk:${Versions.mockk}"
    }

    object Test {
        const val core = "androidx.test:core-ktx:${Versions.test}"
        const val junit = "androidx.test.ext:junit-ktx:1.1.1"
        const val runner = "androidx.test:runner:${Versions.test}"
        const val rules = "androidx.test:rules:${Versions.test}"
        const val truth = "androidx.test.ext:truth:${Versions.test}"
    }

    object Compose {
        const val junit = "androidx.compose.ui:ui-test-junit4:${Libraries.AndroidX.Compose.version}"
        const val manifest =
            "androidx.compose.ui:ui-test-manifest:${Libraries.AndroidX.Compose.version}"
        const val core = "androidx.compose.test:test-core:${Libraries.AndroidX.Compose.version}"
        const val ui = "androidx.compose.ui:ui-test:${Libraries.AndroidX.Compose.version}"
    }

}

object DebugLibraries {

    object Versions {
        const val soLoader = "0.9.0"
        const val flipper = "0.105.0"
        const val leakcanary = "2.7"
    }

    const val flipper = "com.facebook.flipper:flipper:${Versions.flipper}"
    const val flipperNetwork = "com.facebook.flipper:flipper-network-plugin:${Versions.flipper}"
    const val flipperNoop = "com.facebook.flipper:flipper-noop:${Versions.flipper}"
    const val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
}