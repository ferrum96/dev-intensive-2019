package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    date: Date = Date(),
    isIncoming: Boolean = false,
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} " +
            "${if (isIncoming) " получил " else " отправил "} изображение \"$image\" ${date.humanizeDiff()}"
}