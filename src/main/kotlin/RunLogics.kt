class RunLogics {
    private val archive = Archive()

    fun archiveStart() {
        while (true) {

            val command = if (Values.mainArr.isEmpty()) "создать архив" else "создать архив, выбрать архив"
            println("Напишите \"$command\" для соответствующих действий или \"выход\" для выхода из программы.")
            val res = Values.scan.nextLine().lowercase().trim()

            when (res) {
                "создать архив" -> createArchive()
                "выбрать архив" -> if (Values.mainArr.isNotEmpty()) selectArchive() else println("Сначала создайте архив.")
                "выход" -> {
                    println("Благодарим вас за использование приложения 'Заметки'! Хорошего дня:)\n       __|__\n *---o--(_)--o---*\n *Это типо самолетик:)")
                    break
                }
                else -> println("Неверная команда. Попробуйте ещё раз.")
            }
        }
    }

    private fun createArchive() {
        while (true) {
            println("Укажите название архива или напишите \"назад\" для возврата в меню.")
            val name = Values.scan.nextLine().trim()
            if (name.isEmpty()) {
                println("Название не должно быть пустым. Попробуйте ещё раз.")
            } else if (name.lowercase() == "назад") {
                break
            } else {
                Values.mainArr[name] = Archive()
                println("Архив $name создан.")
                break
            }
        }
    }

    private fun selectArchive() {
        while (true) {
            println("Для выбора архива укажите его название или напишите \"назад\" для возврата в меню. Сейчас есть архивы: ${Values.mainArr.keys.joinToString(", ")}")
            val name = Values.scan.nextLine().trim()
            when {
                name.lowercase() == "назад" -> break
                Values.mainArr.containsKey(name) -> Values.mainArr[name]?.notesRun()
                else -> println("Архив с именем \"$name\" не найден.")
            }
        }
    }
}
