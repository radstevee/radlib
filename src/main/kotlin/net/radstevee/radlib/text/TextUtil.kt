package net.radstevee.radlib.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent

object TextUtil {
    inline fun buildText(factory: TextBuilder.() -> Unit): TextComponent {
        return TextBuilder().apply(factory).build()
    }

    fun buildText(text: String? = null): TextComponent {
        return Component.text(text ?: "")
    }

    inline fun buildLinearText(factory: LinearComponentBuilder.() -> Unit): Component {
        return LinearComponentBuilder().apply(factory).build()
    }
}