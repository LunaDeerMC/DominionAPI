import groovy.xml.XmlParser
import groovy.xml.XmlUtil

plugins {
    id("java")
    id("maven-publish")
    id("signing")
    id("io.github.jeadyx.sonatype-uploader") version "1.0"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withJavadocJar()
    withSourcesJar()
}

group = "cn.lunadeer"
version = "4.9.4" // << The main version should keep consistent with the core module

// utf-8
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/groups/public")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "DominionAPI"
            artifact(tasks.named("jar"))
            artifact(tasks.named("sourcesJar"))
            artifact(tasks.named("javadocJar"))

            pom {
                name = "DominionAPI"
                description = "Minecraft Bukkit Server Dominion Plugin API"
                url = "https://dominion.lunadeer.cn/"
                licenses {
                    license {
                        name = "MIT"
                        url = "https://opensource.org/license/mit"
                    }
                }
                developers {
                    developer {
                        id = "zhangyuheng"
                        name = "zhangyuheng"
                        email = "zhangyuheng@lunadeer.cn"
                    }
                }
                scm {
                    connection = "https://github.com/LunaDeerMC/Dominion.git"
                    developerConnection = "scm:git@github.com:LunaDeerMC/Dominion.git"
                    url = "https://github.com/LunaDeerMC/Dominion"
                }
                dependencies {

                }
            }
        }
    }
    repositories {
        maven {
            name = "project"
            url = uri(layout.buildDirectory.dir("repo")) // 将要发布的文件夹生成到这个目录
        }
    }
}

signing { // 文件签名
    val hasGpgCmdConfig = listOf(
        "signing.gnupg.keyName",
        "signing.gnupg.executable",
        "signing.gnupg.homeDir",
        "signing.gnupg.optionsFile"
    ).any { !providers.gradleProperty(it).orNull.isNullOrBlank() }
    val inMemorySigningKey = providers.gradleProperty("signingKey").orNull
    val inMemorySigningPassword =
        providers.gradleProperty("signingPassword").orNull
            ?: providers.gradleProperty("signing.password").orNull

    when {
        hasGpgCmdConfig -> useGpgCmd()
        !inMemorySigningKey.isNullOrBlank() -> useInMemoryPgpKeys(
            inMemorySigningKey,
            inMemorySigningPassword
        )
    }

    sign(publishing.publications["mavenJava"])
}

// remove subproject dependencies from pom file
tasks.named("generatePomFileForMavenJavaPublication") {
    finalizedBy("removePomDependenciesWithGroupIdDominionAPI")
}
// remove subproject dependencies from pom file
tasks.register("removePomDependenciesWithGroupIdDominionAPI") {
    doLast {
        val pomFile =
            layout.buildDirectory.file("publications/mavenJava/pom-default.xml")
                .get().asFile
        val pom = XmlParser().parse(pomFile)
        val nodes = pom.children()
        nodes.forEach { n ->
            val node = n as groovy.util.Node
            val name = node.name().toString().substringAfter("{http://maven.apache.org/POM/4.0.0}")
            if (name == "dependencies") {
                val depsToRemove = mutableListOf<groovy.util.Node>()
                node.children().forEach {
                    val dependency = it as groovy.util.Node
                    if (dependency.text().contains("DominionAPI")) {
                        depsToRemove.add(dependency)
                    }
                }
                depsToRemove.forEach {
                    node.children().remove(it)
                }
            }
        }
        pomFile.writeText(XmlUtil.serialize(pom))
    }
}

sonatypeUploader {
    dir = layout.buildDirectory.dir("repo/cn").get().asFile.path
    tokenName = project.findProperty("centralUsername")?.toString()
    tokenPasswd = project.findProperty("centralPassword")?.toString()
}

tasks.register("uploadToCentral") { // <<<<<<<<< 上传到 Maven 中央仓库
    // 1. clean
    dependsOn("clean")
    // 2. publishMavenJavaPublicationToProjectRepository
    dependsOn("publishMavenJavaPublicationToProjectRepository")
    // 3. upload
    dependsOn("1.upload deployment dir")
}

tasks.register("uploadToLocal") { // <<<<<<<<< 上传到本地仓库
    // 1. clean
    dependsOn("clean")
    // 2. publishMavenJavaPublicationToProjectRepository
    dependsOn("publishMavenJavaPublicationToMavenLocal")
}
