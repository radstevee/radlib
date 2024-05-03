package net.radstevee.radlib.scheduler

import net.radstevee.radlib.RadLib
import org.bukkit.Bukkit

object SchedulerUtil {
    inline fun runTask(crossinline task: () -> Unit) = Bukkit.getScheduler().runTask(RadLib.plugin, Runnable { task() })

    inline fun runTask(delay: Long, crossinline task: () -> Unit) = Bukkit.getScheduler().runTaskLater(RadLib.plugin, Runnable { task() }, delay)
}