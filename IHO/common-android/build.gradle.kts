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
            isMinifyEnabled = false
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

    api(project(Modules.shared))

    testImplementation(project((Modules.android_test_shared)))
    addUnitTestDependencies()

    /* Retrofit */
    api(Libraries.Network.Retrofit.core)
    api(Libraries.Network.OkHttp.core)
    api(Libraries.Network.OkHttp.logger)

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)

    /* DataStore */
    implementation(Libraries.AndroidX.DataStore.dataStore)
    implementation(Libraries.AndroidX.DataStore.dataStoreCore)
    implementation(Libraries.AndroidX.DataStore.javaLite)
    implementation(Libraries.AndroidX.DataStore.dataStoreProtoArtifact)

    /* Flipper */
    debugApi(DebugLibraries.flipper)
    debugApi(DebugLibraries.soLoader)
    debugApi(DebugLibraries.flipperNetwork)
    releaseApi(DebugLibraries.flipperNoop)

    implementation(Libraries.Serializable.kotlinxSerialization)
    implementation(Libraries.Network.Retrofit.retrofitKotlinXSerializationConvertor)

}