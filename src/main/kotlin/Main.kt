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
    val id: Int = 1,
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
    private var idWS = 0

    fun add(post: Post): Post {
        posts += post
        posts[posts.size - 1] = post.copy(id = posts.size)
        return posts.last()
    }

//    fun addSize(): Int {
//        return posts.size + 1
//    }

    fun get(id: Int): Post {
        return posts[id]
    }

    fun update(post: Post): Boolean {
        val saveIdOwner = posts[post.id + 1].idOwner
        val saveDate = posts[post.id + 1].date
        if (post.id > posts.size) {
            println(post.id)
            return false
        } else {
            posts[post.id + 1] = post.copy(idOwner = saveIdOwner, date = saveDate)
            return true
        }
    }


}


fun main() {

    WallService.add(Post(copyright = Copyright(link = "Питер"), text = "Первый"))
    WallService.add(Post(text = "Второй"))
    WallService.add(Post(text = "Третий", ))
    WallService.add(Post(text = "Четвертый"))
    WallService.add(Post(text = "Пятый"))
    WallService.add(Post(text = "Шестой"))
//    WallService.add()

//    val post1 = Post(id = WallService.addSize(), copyright = Copyright(link = "Питер"), text = "Ты квас допил?")
//    WallService.add(post1)
//    val post2 = Post(id = WallService.addSize(), text = "Сам ты квасдопил!", date = 7200)
//    WallService.add(post2)

    println("${WallService.get(0).id} ${WallService.get(0).text}")
    println("${WallService.get(1).id} ${WallService.get(1).text}")
    println("${WallService.get(2).id} ${WallService.get(2).text}")
    println("${WallService.get(3).id} ${WallService.get(3).text}")
    println("${WallService.get(4).id} ${WallService.get(4).text}")
    println("${WallService.get(5).id} ${WallService.get(5).text}")

//    val post3 = Post(id = 2, text = "Вместо третьего", date = 150000)
    WallService.update(Post(id = 2, text = "Вместо третьего", date = 150000))

    println("${WallService.get(0).id} ${WallService.get(0).text}")
    println("${WallService.get(1).id} ${WallService.get(1).text}")
    println("${WallService.get(2).id} ${WallService.get(2).text}")
    println("${WallService.get(3).id} ${WallService.get(3).text}")
    println("${WallService.get(4).id} ${WallService.get(4).text}")
    println("${WallService.get(5).id} ${WallService.get(5).text}")

    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).date}")

}