class RunLogics {
    private val archive = Archive()

    fun archiveStart() { // Архивы
        val options = listOf("Создать архив", "Выбрать архив", "Выход")
        while (true) {
            val selectedOption = getUserChoice("Выберите дальнейшее действие:", options)
            when (selectedOption) {
                0 -> createArchive() // Создание архива
                1 -> if (Values.mainArr.isNotEmpty()) selectArchive() else println("Сначала создайте архив.") // Выбор необходимого архива
                2 -> {
                    println("Благодарим вас за использование приложения 'Заметки'! Хорошего дня:)\n       __|__\n *---o--(_)--o---*\n *Это типо самолетик:)")
                    break // Выход из программы
                }
            }
        }
    }

    private fun createArchive() { //Создать архив
        println("Укажите название архива:")
        val name = readLine().orEmpty().trim()
        if (name.isNotEmpty()) {
            Values.mainArr[name] = Archive()
            println("Архив $name создан.")
        } else {
            println("Название не должно быть пустым.")
        }
    }

    private fun selectArchive() { // Выбор архива
        val archives = Values.mainArr.keys.toList() + "Назад"
        val selectedArchive = getUserChoice("Выберите архив или вернитесь назад:", archives)
        if (selectedArchive == archives.lastIndex) {
            return
        }
        Values.mainArr[archives[selectedArchive]]?.notesRun()
    }
}
fun getUserChoice(prompt: String, options: List<String>): Int {
    println(prompt)
    options.forEachIndexed { index, option ->
        println("${index + 1}. $option") // Правильная нумерация для пользователя, чтобы пункты меню начинались с 1. и далее 2. 3. 4....
    }
    var choice: Int? = null
    while (choice == null || choice !in 1..options.size) {
        println("Введите номер опции:")
        choice = readLine()?.toIntOrNull()
        if (choice == null || choice !in 1..options.size) {
            println("Пожалуйста, введите корректный номер опции.")
        }
    }
    return choice - 1 // Возврат индекса на основе нумерации, начинающейся с 1
}