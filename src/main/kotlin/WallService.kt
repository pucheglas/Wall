package ru.netology.data

import java.lang.RuntimeException
import kotlin.jvm.Throws

class PostNotFoundException(message: String): RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var noPost: Post = Post(text = "Пустой пост")
    private var noComment: Comment = Comment(textComment = "Пустой коммент")


    fun printAllPost (){
        var ind: Int = 0
        var indEnd = posts.size-1
        while(ind <= indEnd){
            if (posts[ind].postDelete) println("Пост удален")
            else {println("${get(ind).id} ${get(ind).text} ${get(ind).idOwner} ${get(ind).date}")
            }
        ind++
        }
    }

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
                posts[post.id] = post.copy(id = post.id - 1, postDelete = true, idOwner = saveIdOwner, date = saveDate)
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
    fun creatComment( comment: Comment): Comment {
        if (comment.idPostComment > posts.size) {
            println("Пост ${comment.idPostComment} не существует") // без исключения
            throw PostNotFoundException("Пост ${comment.idPostComment} не существует или удален")
        } else {
            if (posts[comment.idPostComment].postDelete){
                println("Пост удален. Доступа к комментариям нет")
                return noComment
            } else {
                comments += comment
                comments[comments.size - 1] = comment.copy(idComment = comments.size, idPostComment = comment.idPostComment)
                return comments.last()
            }
        }
    }

    fun getComment(idComment: Int): Comment {
        if (posts[comments[idComment].idPostComment].postDelete) {
            println("Пост ${posts[comments[idComment].idPostComment].id-1} не доступен, т.к. был удален")
            return noComment
        } else {
            return comments[idComment]
        }
    }

    fun updateComment(comment: Comment): Boolean {
        if (comment.idComment > comments.size) {
            println("Пост ${comment.idComment} не существует")
            return false
        } else {
            val saveIdAutor = comments[comment.idComment].idFromAutor
            val savePost = comments[comment.idComment].idPostComment
            comments[comment.idComment] = comment.copy(idComment = comment.idComment + 1,
                                            idPostComment = savePost, idFromAutor = saveIdAutor)
            println("Коммент ${(comment.idComment)+1} успешно изменен")
            return true
        }
    }

    fun deleteComment(comment: Comment): Boolean{
        if (comment.idComment >= comments.size) {
            println("Пост ${comment.idComment} не существует")
            return false
        } else {
            if (comments[comment.idComment].commentDelete) {
                println("Пост ${(comment.idComment) } уже был удален ")
                return false
            } else {
                val saveIdAutor = comments[comment.idComment].idFromAutor
                val savePost = comments[comment.idComment].idPostComment
                comments[comment.idComment] = comment.copy(idComment = comment.idComment,
                    commentDelete = true, idFromAutor = saveIdAutor, idPostComment = savePost)
                println("Коммент ${(comment.idComment)} удален")
                return true
            }
        }
    }

    fun unDeleteComment (comment: Comment): Boolean {
        if (comment.idComment > comments.size) {
            println("Коммент ${comment.idComment} не существует")
            return false
        } else {
            if (!comments[comment.idComment].commentDelete) {
                println("Коммент ${(comment.idComment) } не был удален ")
                return false
            } else {
                val saveIdAutor = comments[comment.idComment].idFromAutor
                val savePost = comments[comment.idComment].idPostComment
                comments[comment.idComment] = comment.copy(idComment = comment.idComment + 0,
                    commentDelete = false, idFromAutor = saveIdAutor, idPostComment = savePost)
                println("Коммент ${(comment.idComment)} восстановлен")
                return true
            }
        }
    }
}
