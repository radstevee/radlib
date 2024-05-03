package net.radstevee.radlib.text

import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentBuilderApplicable
import net.kyori.adventure.text.LinearComponents
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration

class LinearComponentBuilder {
    val components = mutableListOf<ComponentBuilderApplicable>()
    fun build(): Component {
        return LinearComponents.linear(*components.map { it }.toTypedArray())
    }

    fun add(applicable: ComponentBuilderApplicable) {
        components.add(applicable)
    }

    fun black() = add(NamedTextColor.BLACK)
    fun darkBlue() = add(NamedTextColor.DARK_BLUE)
    fun darkGreen() = add(NamedTextColor.DARK_GREEN)
    fun darkAqua() = add(NamedTextColor.DARK_AQUA)
    fun darkRed() = add(NamedTextColor.DARK_RED)
    fun darkPurple() = add(NamedTextColor.DARK_PURPLE)
    fun gold() = add(NamedTextColor.GOLD)
    fun gray() = add(NamedTextColor.GRAY)
    fun darkGray() = add(NamedTextColor.DARK_GRAY)
    fun blue() = add(NamedTextColor.BLUE)
    fun green() = add(NamedTextColor.GREEN)
    fun aqua() = add(NamedTextColor.AQUA)
    fun red() = add(NamedTextColor.RED)
    fun lightPurple() = add(NamedTextColor.LIGHT_PURPLE)
    fun yellow() = add(NamedTextColor.YELLOW)
    fun white() = add(NamedTextColor.WHITE)
    fun append(text: String?) = add(Component.text(text ?: ""))
    fun italic() = add(TextDecoration.ITALIC)
    fun bold() = add(TextDecoration.BOLD)
    fun appendNegativeSpace(space: Short) {
        if (space !in -8192 .. 8192) {
            error("Spaces can only go from -8192 to 8192!")
        }
        add(Component.translatable("space.$space", "").font(Key.key("minecraft", "default")))
    }

    fun appendTranslatable(translatable: String, fallback: String? = translatable) {
        add(Component.translatable(translatable, fallback))
    }

    fun appendNewline() = add(Component.newline())

    fun colorHex(hex: String) = add(TextColor.fromHexString(hex) ?: error("Invalid HEX Colour!"))

    fun removeTextShadow() {
        colorHex("#4e5c24")
    }
}