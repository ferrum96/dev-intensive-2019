package ru.skillbranch.devintensive.utils


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>?
        var firstName: String? = null
        var lastName: String? = null

        if (fullName != null) {
            if (fullName.contains(" ")) {
                parts = fullName.split(" ")
                if ((parts.getOrNull(0) != "") && (parts.getOrNull(0) != " ")) firstName = parts.getOrNull(0) else firstName =
                    null
                if ((parts.getOrNull(0) != "") && (parts.getOrNull(0) != " ")) lastName = parts.getOrNull(1) else lastName = null
            } else {
                if (fullName != "") firstName = fullName else firstName = null
                lastName = null
            }
        }
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val initial1 = firstName?.trimStart()?.firstOrNull()
        val initial2 = lastName?.trimStart()?.firstOrNull()


        return listOfNotNull(initial1, initial2)
            .joinToString("")
            .toUpperCase()
            .takeIf { it.isNotEmpty() }
    }

        fun cyrTolat(ch: Char): String {
            when (ch) {
                'а' -> return "a"
                'б' -> return "b"
                'в' -> return "v"
                'г' -> return "g"
                'д' -> return "d"
                'е' -> return "e"
                'ё' -> return "e"
                'ж' -> return "zh"
                'з' -> return "z"
                'и' -> return "i"
                'й' -> return "i"
                'к' -> return "k"
                'л' -> return "l"
                'м' -> return "m"
                'н' -> return "n"
                'о' -> return "o"
                'п' -> return "p"
                'р' -> return "r"
                'с' -> return "s"
                'т' -> return "t"
                'у' -> return "u"
                'ф' -> return "f"
                'х' -> return "h"
                'ц' -> return "c"
                'ч' -> return "ch"
                'ш' -> return "sh"
                'щ' -> return "sh'"
                'ъ' -> return ""
                'ы' -> return "i"
                'ь' -> return ""
                'э' -> return "e"
                'ю' -> return "yu"
                'я' -> return "ya"
                'А' -> return "A"
                'Б' -> return "B"
                'В' -> return "V"
                'Г' -> return "G"
                'Д' -> return "D"
                'Е' -> return "E"
                'Ё' -> return "E"
                'Ж' -> return "ZH"
                'З' -> return "Z"
                'И' -> return "I"
                'Й' -> return "I"
                'К' -> return "K"
                'Л' -> return "L"
                'М' -> return "M"
                'Н' -> return "N"
                'О' -> return "O"
                'П' -> return "P"
                'Р' -> return "R"
                'С' -> return "S"
                'Т' -> return "T"
                'У' -> return "U"
                'Ф' -> return "F"
                'Х' -> return "H"
                'Ц' -> return "C"
                'Ч' -> return "CH"
                'Ш' -> return "SH"
                'Щ' -> return "SH'"
                'Ъ' -> return ""
                'Ы' -> return "I"
                'Ь' -> return ""
                'Э' -> return "E"
                'Ю' -> return "YU"
                'Я' -> return "YA"
                else -> return ch.toString()
            }
        }


        fun transliteration(payload: String, divider: String = " "): String {

            val sb = StringBuilder(payload.length * 2)
            for (ch in payload.toCharArray()) {
                sb.append(cyrTolat(ch))
            }
            val parts = sb.toString().split(" ")
            return parts.getOrNull(0) + divider + parts.getOrNull(1)
        }
    }