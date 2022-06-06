package ru.netology

import org.junit.Assert
import org.junit.Test
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.data.PostNotFoundException
import ru.netology.data.WallService

class WallServiceTest {

    @Test
    fun add_Normal() {
        val post = Post(id = 1)
        val result = WallService.add(post)
        Assert.assertEquals(true, result.id != 0)
    }

    @Test
    fun update_Normal() {

        WallService.add(Post(text = "Первый пост"))
        WallService.add(Post(text = "Второй пост"))
        WallService.add(Post(text = "Третий пост", date = 72000, idOwner = 33))

        val post = Post(id = 2, text = "Вместо третьего поста", idOwner = 11, date = 150000)

        println(post)
        Assert.assertEquals(true, WallService.update(post))
    }

    @Test
    fun update_No() {

        WallService.add(Post(text = "Первый пост"))
        WallService.add(Post(text = "Второй пост"))
        WallService.add(Post(text = "Третий пост", date = 72000, idOwner = 33))

        val post = Post(id = 12, text = "Вместо третьего поста", idOwner = 11, date = 150000)

        println(post)
        Assert.assertEquals(false, WallService.update(post))
    }

    @Test
    fun creatComment_Post_Normal() {
        WallService.add(Post(text = "Первый пост"))
        WallService.add(Post(text = "Второй пост"))
        WallService.add(Post(text = "Третий пост"))

        val comment = Comment(idPostComment = 1 )
        val result = WallService.creatComment(2, Comment())
        Assert.assertEquals("New Comment", result.textComment)
    }

    @Test
    fun creatComment_Post_Error() {
        WallService.add(Post(text = "Первый пост"))
        WallService.add(Post(text = "Второй пост"))
        WallService.add(Post(text = "Третий пост"))

        val comment = Comment(idPostComment = 10 )
        val result = WallService.creatComment(2, Comment())
        Assert.assertEquals("New Comment", result.textComment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        WallService.creatComment(postId = 10, Comment(textComment = "Комментарий к посту"))
    }
}