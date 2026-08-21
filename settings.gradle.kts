pluginManagement {
    operator fun Settings.get(property: String): String {
        return org.gradle.api.internal.plugins.DslObject(this).asDynamicObject.getProperty(property) as String
    }

    repositories {
        gradlePluginPortal()
        exclusiveContent {
            forRepository {
                maven {
                    name = "Max Henkel"
                    url = uri("https://maven.maxhenkel.de/releases")
                }
            }
            filter { includeGroupAndSubgroups("de.maxhenkel") }
        }
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        mavenLocal()
    }

    plugins {
        id ("fabric-loom") version settings["loom_version"]
        id ("org.ajoberstar.grgit") version settings["grgit_version"]
        id ("de.maxhenkel.cursegradle") version settings["cursegradle_version"]
        id ("com.modrinth.minotaur") version settings["modrinth_version"]
    }
}