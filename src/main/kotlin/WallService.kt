package ru.netology.data

import java.lang.RuntimeException
import kotlin.jvm.Throws

class PostNotFoundException(message: String): RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

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

    @Throws(PostNotFoundException::class)
    fun creatComment(postId: Int, comment: Comment): Comment {
        if (postId > posts.size) {
//            println("Пост $postId не существует") // без исключения
            throw PostNotFoundException("Пост $postId не существует")
        } else {
            comments += comment
            comments[comments.size - 1] = comment.copy(idComment = comments.size, idPostComment = postId)
            return comments.last()
        }
    }
}