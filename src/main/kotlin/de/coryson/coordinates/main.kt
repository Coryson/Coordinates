package de.coryson.coordinates

import org.bukkit.plugin.java.JavaPlugin

class main : JavaPlugin() {

    override fun onEnable() {
        logger.info("${pluginMeta.displayName} ${pluginMeta.version} aktiviert.")
    }

    override fun onDisable() {
        logger.info("${pluginMeta.displayName} ${pluginMeta.version} deaktiviert.")
    }
}
