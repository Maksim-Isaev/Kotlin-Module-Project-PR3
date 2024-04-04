import java.util.Scanner
class Archive {
    var notes: MutableMap<String, String> = mutableMapOf()

    fun notesRun() { // Меню создания заметки
        val options = listOf("Создать заметку", "Выбрать заметку", "Назад")
        while (true) {
            val selectedOption = getUserChoice("Выберите действие:", options)
            when (selectedOption) {
                0 -> createNote()
                1 -> if (notes.isNotEmpty()) selectNote() else println("Сначала создайте заметку.")
                2 -> return
            }
        }
    }

    private fun createNote() {
        println("Укажите название заметки:")
        val title = readLine().orEmpty().trim()
        println("Укажите текст заметки:")
        val text = readLine().orEmpty().trim()
        if (title.isNotEmpty() && text.isNotEmpty()) {
            notes[title] = text
            println("Заметка \"$title\" создана.")
        } else {
            println("Название и текст не должны быть пустыми.")
        }
    }

    private fun selectNote() { // Выбор заметки
        val noteTitles = notes.keys.toList() + "Назад"
        val selectedNote = getUserChoice("Выберите заметку или вернитесь назад:", noteTitles)
        if (selectedNote == noteTitles.lastIndex) {
            return
        }
        val title = noteTitles[selectedNote]
        println("Текст заметки \"$title\": ${notes[title]}") // Просмотр заметки
    }
}

object Values {

    val mainArr = mutableMapOf<String, Archive>()
}

