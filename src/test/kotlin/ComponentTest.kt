import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.radstevee.radlib.text.TextUtil.buildText
import kotlin.test.Test
import kotlin.test.assertEquals

class ComponentTest {
    @Test
    fun componentTest() {
        val component = buildText {
            append("Hello, world!")
            appendNewline()
            green()
            buildLinearText {
                blue()
                append("I am blue\n")
                red()
                append("I am red\n")
                bold()
                lightPurple()
                append("I am pink bold")
            }
        }
        val expected = """
            {"color":"green","extra":["Hello, world!","\n",{"extra":[{"color":"blue","text":"I am blue\n"},{"color":"red","text":"I am red\n"},{"bold":true,"color":"light_purple","text":"I am pink bold"}],"text":""}],"text":""}
        """.trimIndent()
        assertEquals(expected, GsonComponentSerializer.gson().serialize(component))
    }
}