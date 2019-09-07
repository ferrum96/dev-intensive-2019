package ru.skillbranch.devintensive.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import ru.skillbranch.devintensive.extensions.TimeUnits


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        val parts: List<String>?
        var firstName: String? = null
        var lastName: String? = null

        if (fullName != null) {
            if (fullName.contains(" ")) {
                parts = fullName.split(" ")
                if ((parts.getOrNull(0) != "") && (parts.getOrNull(0) != " ")) firstName =
                    parts.getOrNull(0) else firstName =
                    null
                if ((parts.getOrNull(0) != "") && (parts.getOrNull(0) != " ")) lastName =
                    parts.getOrNull(1) else lastName = null
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

    fun transliteration(payload: String, divider: String = " "): String {
        return payload.toCharArray().map { character ->
            if (character.isUpperCase()) transliterateCharacter(character.toLowerCase()).capitalize() else transliterateCharacter(
                character
            )
        }.joinToString("").replace(" ", divider)
    }

    private fun transliterateCharacter(character: Char): String = when (character) {
        'а' -> "a"
        'б' -> "b"
        'в' -> "v"
        'г' -> "g"
        'д' -> "d"
        'е' -> "e"
        'ё' -> "e"
        'ж' -> "zh"
        'з' -> "z"
        'и' -> "i"
        'й' -> "i"
        'к' -> "k"
        'л' -> "l"
        'м' -> "m"
        'н' -> "n"
        'о' -> "o"
        'п' -> "p"
        'р' -> "r"
        'с' -> "s"
        'т' -> "t"
        'у' -> "u"
        'ф' -> "f"
        'х' -> "h"
        'ц' -> "c"
        'ч' -> "ch"
        'ш' -> "sh"
        'щ' -> "sh'"
        'ъ' -> ""
        'ы' -> "i"
        'ь' -> ""
        'э' -> "e"
        'ю' -> "yu"
        'я' -> "ya"
        else -> character.toString()
    }

    fun plurals(i: Int, timeunit: TimeUnits): String {

        val j = i % 10

        return if (j in 1..1) {
            when (timeunit) {
                TimeUnits.SECOND -> "$i секунду"
                TimeUnits.MINUTE -> "$i минуту"
                TimeUnits.HOUR -> "$i час"
                TimeUnits.DAY -> "$i день"
            }
        } else if (j in 2..4) {
            when (timeunit) {
                TimeUnits.SECOND -> "$i секунды"
                TimeUnits.MINUTE -> "$i минуты"
                TimeUnits.HOUR -> "$i часа"
                TimeUnits.DAY -> "$i дня"
            }
        } else {
            when (timeunit) {
                TimeUnits.SECOND -> "$i секунд"
                TimeUnits.MINUTE -> "$i минут"
                TimeUnits.HOUR -> "$i часов"
                TimeUnits.DAY -> "$i дней"
            }
        }
    }


    fun convertPxToDp(px: Int): Int {
        return Math.round(px / (Resources.getSystem().displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun convertDpToPx(dp: Float): Int {
        val metrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return Math.round(px)
    }

}