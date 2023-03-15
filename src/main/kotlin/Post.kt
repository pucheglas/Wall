package ru.netology.data

data class CommentsInPost(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id: Int = 1,
    val link: String = "Москва",
    val name: String = "Просвещение",
    val type: String = "Автор"
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLikes: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(
    val count: Int = 0,
    val userReposted: Boolean = false
)

data class Views(
    val count: Int = 0
)

data class PostType(
    val postType: String = "post"
)

data class DonutPost(
    val isDonutPost: Boolean = false,
    val paidDuration: Int = 3_600,
    val placeholder: String = "Нет подписок",
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = "all"
)

data class Post(
    val id: Int = 0,
    var postDelete: Boolean = false,
    val idOwner: Int = 1,
    val idAuthor: Int = 1,
    val date: Int = 3600,
    val text: String = "New post",
    val replyOwner: Int = 1,
    val idReplyPost: Int = 1,
    val friendsOnly: Boolean = false,
    val comments: CommentsInPost? = CommentsInPost(),
    val copyright: Copyright? = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: PostType = PostType(),
    val idSigner: Int = 1,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donutPost: DonutPost? = DonutPost(),
    val idPostponed: Boolean = false,
    val attachmentsPost: Array<Attachment>? = emptyArray()
)
