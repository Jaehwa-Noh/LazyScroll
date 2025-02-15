import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.vanniktech.maven.publish") version "0.30.0"
    signing
}

mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            // the published variant
            variant = "release",
            // whether to publish a sources jar
            sourcesJar = true,
            // whether to publish a javadoc jar
            publishJavadocJar = true,
        )
    )

    coordinates(
        groupId = "io.github.jaehwa-noh",
        artifactId = "lazy-scroll",
        version = "0.0.2"
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    pom {
        url = "https://github.com/Jaehwa-Noh/LazyScroll"
        name = "LazyScroll"
        description = "Lazy composable Scrollbar"
        inceptionYear = "2025"

        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "jaehwa-noh"
                name = "Jaehwa Noh"
                email = "shwoghk14@gmail.com"
            }
        }

        scm {
            url = "https://github.com/Jaehwa-Noh/LazyScroll"
            connection = "scm:git:git://github.com/Jaehwa-Noh/LazyScroll.git"
            developerConnection = "scm:git:ssh://git@github.com/Jaehwa-Noh/LazyScroll.git"
        }
    }
}

signing {
    sign(publishing.publications)
}

android {
    namespace = "starlightlab.jaehwa.lazyscrollsdk"
    compileSdk = 35

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 21

        aarMetadata {
            minCompileSdk = 21
        }

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
}
