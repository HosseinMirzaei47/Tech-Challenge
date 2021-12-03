plugins {
    id(BuildPlugins.Apply.androidApplication)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.safeArgsKotlinPlugin)
}
kapt {
    correctErrorTypes = true
    useBuildCache = true

    javacOptions {
        option("-Xmaxerrs", 2000)
    }
}

android {
    compileSdk = AndroidSdk.compile
    buildToolsVersion = AndroidSdk.buildToolsVersion
    defaultConfig {
        applicationId = Config.applicationId
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        versionCode = Config.versionCode
        versionName = Config.versionName
        multiDexEnabled = true
        testInstrumentationRunner = TestLibraries.AndroidJunitRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions.unitTests.isIncludeAndroidResources = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
        freeCompilerArgs += "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi"
        freeCompilerArgs += "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
        freeCompilerArgs += "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi"
    }
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

    flavorDimensions += "version"
    productFlavors {
        create("webApi") {
            dimension = "version"
        }
        create("mock") {
            dimension = "version"
        }
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libraries.AndroidX.Compose.version
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }

}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    implementation(project(Modules.commonAndroid))
    implementation(project(Modules.commonUi))
    implementation(project(Modules.dataModel))
    implementation(project(Modules.model))
    implementation(project(Modules.shared))
    implementation(project(Modules.uiHome))

    testImplementation(project(Modules.android_test_shared))
    addUnitTestDependencies()

    androidTestImplementation(project(Modules.android_test_shared))
    addInstrumentTestDependencies()

    // multidex
    implementation(Libraries.multidex)

    // hilt
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)
    implementation(Libraries.AndroidX.Hilt.work)
    implementation(Libraries.Hilt.navigation)
    kapt(Libraries.AndroidX.Hilt.compiler)

    // firebase
    implementation(Libraries.Firebase.analytics)
    implementation(Libraries.Firebase.crashlytics)
    implementation(Libraries.Firebase.cloudMessaging)
    implementation(platform(Libraries.Firebase.libraryPlatform))

    implementation(Libraries.AndroidX.worker)

}