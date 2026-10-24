plugins {
    id("com.android.application")
}

android {
    namespace = "com.mawedi.sa"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.mawedi.sa"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }
}

val syncWebsiteAssets by tasks.registering(Sync::class) {
    val websiteRoot = rootProject.projectDir.parentFile
    from(websiteRoot) {
        include("index.html", "manifest.webmanifest", "service-worker.js", "icon-192.png", "icon-512.png")
    }
    into(layout.projectDirectory.dir("src/main/assets/site"))
}

tasks.named("preBuild") {
    dependsOn(syncWebsiteAssets)
}
