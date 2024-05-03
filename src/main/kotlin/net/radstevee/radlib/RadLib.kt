package net.radstevee.radlib

import org.bukkit.plugin.java.JavaPlugin

object RadLib {
    lateinit var plugin: JavaPlugin

    fun initialize(plugin: JavaPlugin) {
        this.plugin = plugin
    }
}