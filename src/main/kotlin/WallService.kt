package ru.netology.data

import java.lang.RuntimeException
import kotlin.jvm.Throws

class PostNotFoundException(message: String): RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var noPost: Post =Post(text = "Пустой пост")

    fun add(post: Post): Post {
        posts += post
        posts[posts.size - 1] = post.copy(id = posts.size)
        return posts.last()
    }

    fun get(id: Int): Post {
        if (posts[id].postDelete) {
            println("Пост ${posts[id].id-1} не доступен, т.к. был удален")
            return noPost
        } else {
            return posts[id]
        }
    }

    fun update(post: Post): Boolean {
        if (post.id > posts.size) {
            println("Пост ${post.id} не существует")
            return false
        } else {
            val saveIdOwner = posts[post.id].idOwner
            val saveDate = posts[post.id].date
            posts[post.id] = post.copy(id = post.id + 1, idOwner = saveIdOwner, date = saveDate)
            println("Пост ${(post.id)+1} успешно изменен")
            return true
        }
    }

    fun delete(post: Post): Boolean {
        if (post.id > posts.size) {
            println("Пост ${post.id} не существует")
            return false
        } else {
            if (posts[post.id].postDelete) {
                println("Пост ${(post.id) } уже был удален ")
                return false
            } else {
                val saveIdOwner = posts[post.id].idOwner
                val saveDate = posts[post.id].date
                posts[post.id] = post.copy(id = post.id + 1, postDelete = true, idOwner = saveIdOwner, date = saveDate)
                println("Пост ${(post.id)} удален")
                return true
            }
        }
    }

    fun undelete (post: Post): Boolean {
        if (post.id > posts.size) {
            println("Пост ${post.id} не существует")
            return false
        } else {
            if (!posts[post.id].postDelete) {
                println("Пост ${(post.id) } не был удален ")
                return false
            } else {
                val saveIdOwner = posts[post.id].idOwner
                val saveDate = posts[post.id].date
                posts[post.id] = post.copy(id = post.id + 1, postDelete = false, idOwner = saveIdOwner, date = saveDate)
                println("Пост ${(post.id)} восстановлен")
                return true
            }
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
