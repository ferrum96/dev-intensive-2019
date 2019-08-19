package ru.skillbranch.devintensive

import junit.framework.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
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
        val user = User.makeUser("Салов Константин")

        var imgMessage = BaseMessage.makeMessage(user, Chat(id = "0"), payload = "какойто url", type = "image")
        var txtMessage = BaseMessage.makeMessage(user, Chat(id = "0"), payload = "какойто текстовое сообщение", type = "text")


        println(imgMessage.formatMessage())
        println(txtMessage.formatMessage())

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
}



