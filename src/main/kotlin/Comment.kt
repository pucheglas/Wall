package ru.netology.data

data class DonutComment(
    val isDonutComment: Boolean = true,
    val placeholder: String = ""
)

data class ThreadComment(
    val canPostComment: Boolean = true,
    val showReplyButton: Boolean = true,
    val canGroupPost: Boolean = true
)

data class Comment(
    val idComment: Int = 0,
    val commentDelete: Boolean = false,
    val idPostComment: Int = 0,
    val idFromAutor: Int = 0,
    val dateComment: Int = 0,
    val textComment: String = "New Comment",
//    val donatComment: DonutComment = DonutComment(),
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
//    val attachmentsComment: Array<Attachment>? = emptyArray(),
//    val parentsStack: Array<Int>? = emptyArray(),
//    val thread: ThreadComment = ThreadComment()
)
