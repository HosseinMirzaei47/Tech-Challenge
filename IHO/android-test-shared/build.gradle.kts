plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
}

android {
    compileSdk = AndroidSdk.compile
    buildToolsVersion = AndroidSdk.buildToolsVersion
    defaultConfig {
        minSdk = AndroidSdk.min
        targetSdk = AndroidSdk.target
        testInstrumentationRunner = TestLibraries.AndroidJunitRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

}

dependencies {

    implementation(project(Modules.commonAndroid))

    implementation(Libraries.Hilt.core)
    implementation(Libraries.Hilt.testing)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)

    implementation(Libraries.AndroidX.Fragment.test)
    implementation(Libraries.AndroidX.LifeCycle.liveData)
    implementation(Libraries.AndroidX.LifeCycle.viewModel)

    implementation(TestLibraries.Espresso.core)
    implementation(TestLibraries.Mockk.android)
    implementation(TestLibraries.Test.runner)

    implementation(Libraries.Kotlin.Coroutine.test)

    implementation(TestLibraries.barista) { exclude("org.jetbrains.kotlin") }
}