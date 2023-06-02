plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.usecases"
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = BuildTypes.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.material)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.AnroidX.junit)
    androidTestImplementation(Libs.Test.AnroidX.espresso)

    // Javax Inject
    implementation(Libs.Javax.inject)

    implementation(project(":models"))

    implementation(project(":data:musicgenres"))
    implementation(project(":data:artist"))
    implementation(project(":data:artistdetail"))
    implementation(project(":data:albumdetail"))
    implementation(project(":data:favoritesongs"))
}