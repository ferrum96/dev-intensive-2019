package ru.skillbranch.devintensive

import junit.framework.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.*

import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instanse() {
        val user = User("1")
        val user2 = User("2", "John", "Cena")
        val user3 = User("3", "Jack", "Jonson", null, lastVisit = Date(), isOnline = true)

        /*user.printMe()
        user2.printMe()
        user3.printMe()


        println("$user $user2 $user3")*/
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Vasya Pupkin")
        val user2 = user.copy(id = "2", firstName = "Djon", lastName = "Zalupkin")
//        var user2 = User.Factory.MakeUser("Egor Zalupkin")
//        var user3 = User.Factory.MakeUser("Djon Wick")
//        var user4 = User.Factory.MakeUser(null)

        print("$user\n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Vasya Pupkin")

        fun getUserInfo() = user

        val (id, firstname, lastname) = getUserInfo()

        println("$id, $firstname, $lastname")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("Djon Wick")
        val user2 = user.copy(lastVisit = Date().add(3, TimeUnits.MINUTE))
        val user3 = user.copy(lastName = "Borov", lastVisit = Date())

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent()
        )
    }

    @Test
    fun data_mapping() {
        val user = User.makeUser("Салов Константин")
        println(user)
        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun abstract_factory() {

    }

    @Test
    fun parse_full_name() {
        print(
            """
        ${Utils.parseFullName(null)/*null null*/} 
        ${Utils.parseFullName("")/*null null*/} 
        ${Utils.parseFullName(" ")/*null null*/} 
        ${Utils.parseFullName("John") /*John null*/}
        """.trimIndent()
        )
    }

    @Test
    fun initials() {
        println(Utils.toInitials("das", "hghk"))
        println(Utils.toInitials("das", null))
        println(Utils.toInitials(null, null))
        println(Utils.toInitials(" ", ""))
    }


    @Test
    fun trans() {
        print(Utils.transliteration("Вася Хуяся", "$$"))
    }

    @Test
    fun truncate() {
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        println("A     ".truncate(3))
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())
    }

    @Test
    fun test_transliteration() {
        assertEquals("Ivan Stereotipov", Utils.transliteration("Иван Стереотипов"))
        assertEquals("Amazing_Petr", Utils.transliteration("Amazing Петр", "_"))
        assertEquals("Privet mir", Utils.transliteration("Привет мир"))
        assertEquals("    Privet    mir   ", Utils.transliteration("    Привет    мир   "))
        assertEquals("pRIvet mir", Utils.transliteration("pRIвет мир"))
        assertEquals("PRIvet Mir", Utils.transliteration("PRIвет Mир"))
        assertEquals("PRIvet1345 Mir", Utils.transliteration("PRIвет1345 Mир"))
        assertEquals("[]{}PRIvet Mir/", Utils.transliteration("[]{}PRIвет Mир/"))
        assertEquals("[]{}PRIvet____Mir/", Utils.transliteration("[]{}PRIвет    Mир/", "_"))
        assertEquals(
            "[_444__444__444__444_]{}PRIvet_444__444_Mir/",
            Utils.transliteration("[    ]{}PRIвет  Mир/", "_444_")
        )
    }


    @Test
    fun plural() {
        println(TimeUnits.SECOND.plural(1))
        println(TimeUnits.MINUTE.plural(4))
        println(TimeUnits.HOUR.plural(19))
        println(TimeUnits.DAY.plural(222))
    }

    @Test
    fun build() {
        val date = Date()
        val expectedUser = User("1", "Михаил", "Макеев", "anyUrl", 10, 10, date, true)
        val user = User.Builder()
            .id("1")
            .firstName("Михаил")
            .lastName("Макеев")
            .avatar("anyUrl")
            .rating(10)
            .respect(10)
            .lastVisit(date)
            .isOnline(true)
            .build()

        assertEquals(expectedUser, user)

    }
}




