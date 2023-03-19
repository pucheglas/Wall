package ru.netology.data




fun main() {

//    println("*** Ввод данных")
    WallService.add(Post(copyright = Copyright(link = "Питер"), text = "Первый пост"))
    WallService.add(Post(text = "Второй пост", idOwner = 2))
    WallService.add(Post(text = "Третий пост", date = 72000, idOwner = 33))
    WallService.add(Post(text = "Четвертый пост"))
    WallService.add(Post(text = "Пятый пост"))
    WallService.add(Post(text = "Шестой пост"))

    println("\n*** Вывод постов")
    println("${WallService.get(0).id} ${WallService.get(0).text} ${WallService.get(0).idOwner} ${WallService.get(0).date}")
    println("${WallService.get(1).id} ${WallService.get(1).text} ${WallService.get(1).idOwner} ${WallService.get(1).date}")
    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    println("${WallService.get(3).id} ${WallService.get(3).text} ${WallService.get(3).idOwner} ${WallService.get(3).date}")
    println("${WallService.get(4).id} ${WallService.get(4).text} ${WallService.get(4).idOwner} ${WallService.get(4).date}")
    println("${WallService.get(5).id} ${WallService.get(5).text} ${WallService.get(5).idOwner} ${WallService.get(5).date}")

    println("\n*** Изменение постов")
    WallService.update(Post(id = 4, text = "Вместо пятого поста", idOwner = 11, date = 150000))
    WallService.update(Post(id = 2, text = "Вместо третьего поста", idOwner = 22, date = 1500))

    println("\n*** Вывод измененных постов")
    println("${WallService.get(0).id} ${WallService.get(0).text} ${WallService.get(0).idOwner} ${WallService.get(0).date}")
    println("${WallService.get(1).id} ${WallService.get(1).text} ${WallService.get(1).idOwner} ${WallService.get(1).date}")
    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    println("${WallService.get(3).id} ${WallService.get(3).text} ${WallService.get(3).idOwner} ${WallService.get(3).date}")
    println("${WallService.get(4).id} ${WallService.get(4).text} ${WallService.get(4).idOwner} ${WallService.get(4).date}")
    println("${WallService.get(5).id} ${WallService.get(5).text} ${WallService.get(5).idOwner} ${WallService.get(5).date}")


    println("\n*** Attachment ")
    println(AudioAttachment(audio = Audio()).typeAttachment)
    println(PresentAttachment(present = Present(thumb256 = "", thumb96 = "", thumb48 = "")).typeAttachment)
    println(PhotoAttachment(photo = Photo()).typeAttachment)

    println("\n*** Комментарии ")
    WallService.creatComment(Comment(idPostComment = 2, textComment = "Комментарий к посту 2"))
    println("Коммент ${WallService.getComment(0).idComment}" +
            " к посту ${WallService.getComment(0).idPostComment}" +
            " ${WallService.getComment(0).commentDelete}")
    WallService.creatComment(Comment(idPostComment = 5, textComment = "Комментарий к посту 5"))
    println("Коммент ${WallService.getComment(1).idComment}" +
            " к посту ${WallService.getComment(1).idPostComment}" +
            " ${WallService.getComment(1).commentDelete}")

//    println("Обработка исключения")
//    val comment3 = WallService.creatComment(postId = 10, Comment(textComment = "Комментарий к посту"))

    println("\n*** Удаление постов ")
//    println("${WallService.get(2).id} ${WallService.get(2).postDelete} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    WallService.delete(Post(id = 2))
//    println("${WallService.get(2).id} ${WallService.get(2).postDelete} ${WallService.get(2).text}")
    WallService.delete(Post(id = 2))
    WallService.delete(Post(id = 12))

    WallService.getComment(0)
//    println("comment id = ${comment4.idComment}, text = ${comment4.textComment} ${comment4.idPostComment}")


    println("\nВосстановление поста")
    WallService.undelete(Post(id = 2))
    WallService.undelete(Post(id = 5))
    WallService.undelete(Post(id = 11))

    WallService.getComment(0)
    println("Коммент ${WallService.getComment(0).idComment}" +
            " к посту ${WallService.getComment(0).idPostComment}" +
            " ${WallService.getComment(0).commentDelete}")

    println("\n*** Удаление комментов ")
//    WallService.deleteComment(comment2)
//    println("comment id = ${comment2.idComment}, text = ${comment2.textComment} ${comment2.idPostComment} ${comment2.commentDelete}")
}
