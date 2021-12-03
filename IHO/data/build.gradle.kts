import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id(BuildPlugins.Apply.androidLibrary)
    id(BuildPlugins.Apply.kotlinAndroid)
    id(BuildPlugins.Apply.kotlinKapt)
    id(BuildPlugins.Apply.daggerHiltPlugin)
    id(BuildPlugins.Apply.protoBufPlugin) version BuildPlugins.Apply.protoBufVersion
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

    flavorDimensions += "version"
    productFlavors {
        create("webApi") {
            dimension = "version"
        }
        create("mock") {
            dimension = "version"
        }
    }
}

dependencies {

    api(project(Modules.commonAndroid))
    implementation(project(Modules.dataModel))
    implementation(project(Modules.domain))

    testImplementation(project((Modules.android_test_shared)))
    addUnitTestDependencies()

    /* Retrofit */
    implementation(Libraries.Network.Retrofit.core)
    implementation(Libraries.Network.OkHttp.core)
    implementation(Libraries.Network.OkHttp.logger)

    /* Hilt */
    implementation(Libraries.Hilt.core)
    kapt(Libraries.Hilt.compiler)
    kapt(Libraries.Hilt.androidCompiler)

    /* Room - Annotation processor. model:android module apis other dependencies */
    kapt(Libraries.AndroidX.Room.compiler)

    /* DataStore */
    implementation(Libraries.AndroidX.DataStore.dataStore)
    implementation(Libraries.AndroidX.DataStore.dataStoreCore)
    implementation(Libraries.AndroidX.DataStore.javaLite)
    implementation(Libraries.AndroidX.DataStore.dataStoreProtoArtifact)

    implementation(Libraries.Serializable.kotlinxSerialization)

    implementation(Libraries.AndroidX.ktxCore)

    implementation(Libraries.faker)
}

protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = Libraries.AndroidX.DataStore.dataStoreProtoArtifact
    }
    generateProtoTasks {
        // all() returns the collection of all protoc tasks
        all().forEach { task ->
            // Here you can configure the task
            task.plugins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}
