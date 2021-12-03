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

    api(project(Modules.model))
    api(project(Modules.domain))
    api(project(Modules.commonAndroid))

    testImplementation(project((Modules.android_test_shared)))
    addUnitTestDependencies()

    implementation(Libraries.Kotlin.jdk)
    api(Libraries.AndroidX.appCompat)
    api(Libraries.material)
    api(Libraries.AndroidX.constraintLayout)
    api(Libraries.AndroidX.Fragment.core)
    api(Libraries.Scale.ssp)
    api(Libraries.Scale.sdp)
    api(Libraries.AndroidX.Room.sqlite)

    /* Navigation */
    api(Libraries.AndroidX.Navigation.ui)
    api(Libraries.AndroidX.Navigation.core)

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)

    /*coil*/
    implementation(Libraries.ImageUtils.glide)
    annotationProcessor(Libraries.ImageUtils.glideCompiler)

    /*Compose*/
    api(Libraries.AndroidX.Compose.compiler)
    api(Libraries.AndroidX.Compose.foundation)
    api(Libraries.AndroidX.Compose.material)
    api(Libraries.AndroidX.Compose.runtime)
    api(Libraries.AndroidX.Compose.runtimeLivedata)
    debugApi(Libraries.AndroidX.Compose.tooling)
    api(Libraries.AndroidX.Compose.ui)
    api(Libraries.AndroidX.Compose.uiUtil)
    api(Libraries.AndroidX.Compose.preview)
    api(Libraries.AndroidX.Compose.animations)
    api(Libraries.AndroidX.Compose.activity)
    api(Libraries.Accompanist.insets)
    api(Libraries.Accompanist.navigationMaterial)
    api(Libraries.Accompanist.system)

    api(Libraries.AndroidX.LifeCycle.runtime)
}