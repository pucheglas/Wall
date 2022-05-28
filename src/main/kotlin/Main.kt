package ru.netology.data

data class Comments(
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

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 3_600,
    val placeholder: String = "Нет подписок",
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = "all"
)

data class Post(
    val id: Int = 0,
    val idOwner: Int = 1,
    val idAuthor: Int = 1,
    val date: Int = 3600,
    val text: String = "New post",
    val replyOwner: Int = 1,
    val idReplyPost: Int = 1,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
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
    val donut: Donut = Donut(),
    val idPostponed: Boolean = false
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        posts[posts.size - 1] = post.copy(id = posts.size)
        return posts.last()
    }

    fun get(id: Int): Post {
        return posts[id]
    }

    fun update(post: Post): Boolean {

        if (post.id > posts.size) {
            println("Пост ${post.id} не существует")
            return false
        } else {
            val saveIdOwner = posts[post.id].idOwner
            val saveDate = posts[post.id].date
            posts[post.id] = post.copy(id = post.id + 1, idOwner = saveIdOwner, date = saveDate)
            println("Пост ${post.id} успешно изменен")
            return true
        }
    }
}

fun main() {

    WallService.add(Post(copyright = Copyright(link = "Питер"), text = "Первый пост"))
    WallService.add(Post(text = "Второй пост", idOwner = 2))
    WallService.add(Post(text = "Третий пост", date = 72000, idOwner = 33))
    WallService.add(Post(text = "Четвертый пост"))
    WallService.add(Post(text = "Пятый пост"))
    WallService.add(Post(text = "Шестой пост"))

    println("${WallService.get(0).id} ${WallService.get(0).text} ${WallService.get(0).idOwner} ${WallService.get(0).date}")
    println("${WallService.get(1).id} ${WallService.get(1).text} ${WallService.get(1).idOwner} ${WallService.get(1).date}")
    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    println("${WallService.get(3).id} ${WallService.get(3).text} ${WallService.get(3).idOwner} ${WallService.get(3).date}")
    println("${WallService.get(4).id} ${WallService.get(4).text} ${WallService.get(4).idOwner} ${WallService.get(4).date}")
    println("${WallService.get(5).id} ${WallService.get(5).text} ${WallService.get(5).idOwner} ${WallService.get(5).date}")

    WallService.update(Post(id = 2, text = "Вместо третьего поста", idOwner = 11, date = 150000))

    println("${WallService.get(0).id} ${WallService.get(0).text} ${WallService.get(0).idOwner} ${WallService.get(0).date}")
    println("${WallService.get(1).id} ${WallService.get(1).text} ${WallService.get(1).idOwner} ${WallService.get(1).date}")
    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    println("${WallService.get(3).id} ${WallService.get(3).text} ${WallService.get(3).idOwner} ${WallService.get(3).date}")
    println("${WallService.get(4).id} ${WallService.get(4).text} ${WallService.get(4).idOwner} ${WallService.get(4).date}")
    println("${WallService.get(5).id} ${WallService.get(5).text} ${WallService.get(5).idOwner} ${WallService.get(5).date}")
}