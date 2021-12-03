plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.kotlinParcelize)
    id(BuildPlugins.Apply.kotlinxSerialization)
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
    api(project(Modules.model))

    testImplementation(project((Modules.android_test_shared)))
    addUnitTestDependencies()

    implementation(Libraries.Kotlin.jdk)
    implementation(Libraries.AndroidX.ktxCore)

    implementation(Libraries.Serializable.kotlinxSerialization)

    /* Room */
    api(Libraries.AndroidX.Room.runtime)
    api(Libraries.AndroidX.Room.core)
    kapt(Libraries.AndroidX.Room.compiler)

}