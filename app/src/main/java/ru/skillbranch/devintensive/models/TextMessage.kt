package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isInocming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isInocming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if (isInocming) " получил " else " отправил "} сообщение \"$text\" ${date.humanizeDiff()}"
}

