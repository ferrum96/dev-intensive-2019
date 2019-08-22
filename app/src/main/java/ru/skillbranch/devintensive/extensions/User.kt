package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

fun User.toUserView(): UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials("$firstName", "$lastName")
    val status =
        if (lastVisit == null) "Еще не разу не был" else if (isOnline == true) "Online" else "в последний раз был ${lastVisit.add(
            -5,
            TimeUnits.DAY
        ).humanizeDiff()}"

    return UserView(
        id = id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        avatar = avatar,
        status = status,
        initials = initials
    )
}

