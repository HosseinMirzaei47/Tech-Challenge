plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.safeArgsKotlinPlugin)
    id(BuildPlugins.Apply.kotlinKapt)
}

kapt {
    correctErrorTypes = true
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

    implementation(project(Modules.commonUi))
    implementation(project(Modules.commonAndroid))

    testImplementation(project((Modules.android_test_shared)))
    addUnitTestDependencies()

    androidTestImplementation(project((Modules.android_test_shared)))
    addInstrumentTestDependencies()

    /* Hilt */
    implementation(Libraries.Hilt.core)
    implementation(Libraries.Hilt.navigation)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)

    implementation(Libraries.ImageUtils.coilCompose)

    implementation(Libraries.AndroidX.browser)

    implementation("com.google.android.exoplayer:exoplayer:2.16.1")

}