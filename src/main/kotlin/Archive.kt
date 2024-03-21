import java.util.Scanner
class Archive (var notes: MutableMap<String, String> = mutableMapOf()) {
    fun notesRun() {
        while (true) {
            val command = if (notes.isEmpty()) "создать заметку" else "создать заметку, выбрать заметку"
            println("Напишите \"$command\" для соответствующих действий или \"назад\" для возврата.")
            val choice = Values.scan.nextLine().lowercase().trim()

            when (choice) {
                "создать заметку" -> createNote()
                "выбрать заметку" -> if (notes.isNotEmpty()) selectNote() else println("Сначала создайте заметку.")
                "назад" -> break
                else -> println("Неверная команда. Попробуйте ещё раз.")
            }
        }
    }

    private fun createNote() {
        println("Укажите название заметки:")
        val title = Values.scan.nextLine().trim()
        if (title.isEmpty()) {
            println("Название не должно быть пустым.")
            return
        }
        println("Укажите текст заметки:")
        val text = Values.scan.nextLine().trim()
        if (text.isEmpty()) {
            println("Текст не должен быть пустым.")
            return
        }
        notes[title] = text
        println("Заметка \"$title\" создана.")
    }

    private fun selectNote() {
        println("Доступные заметки: ${notes.keys.joinToString(", ")}")
        val title = Values.scan.nextLine().trim()
        val note = notes[title]
        if (note != null) {
            println("Текст заметки \"$title\": $note")
        } else {
            println("Заметка с названием \"$title\" не найдена.")
        }
    }
}

    object Values {
        val scan = Scanner(System.`in`)
        val mainArr = mutableMapOf<String, Archive>()
    }
