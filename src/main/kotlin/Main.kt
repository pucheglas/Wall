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
    WallService.printAllPost()

    println("\n*** Изменение постов")
    WallService.update(Post(id = 4, text = "Вместо пятого поста", idOwner = 11, date = 150000))
    WallService.update(Post(id = 1, text = "Вместо второго поста", idOwner = 22, date = 1500))

    println("\n*** Вывод измененных постов")
    WallService.printAllPost()

//    println("\n*** Attachment ")
//    println(AudioAttachment(audio = Audio()).typeAttachment)
//    println(PresentAttachment(present = Present(thumb256 = "", thumb96 = "", thumb48 = "")).typeAttachment)
//    println(PhotoAttachment(photo = Photo()).typeAttachment)

    println("\n*** Комментарии ")
    WallService.creatComment(Comment(idPostComment = 2, textComment = "Комментарий к посту 2"))
    println("Коммент ${WallService.getComment(0).idComment}" +
            " к посту ${WallService.getComment(0).idPostComment}" +
            " ${WallService.getComment(0).textComment}")
    WallService.creatComment(Comment(idPostComment = 5, textComment = "Комментарий к посту 5"))
    println("Коммент ${WallService.getComment(1).idComment}" +
            " к посту ${WallService.getComment(1).idPostComment}" +
            " ${WallService.getComment(1).textComment}")
    WallService.creatComment(Comment(idPostComment = 2, textComment = "Второй комментарий к посту 2"))
    println("Коммент ${WallService.getComment(2).idComment}" +
            " к посту ${WallService.getComment(2).idPostComment}" +
            " ${WallService.getComment(2).textComment}")

//    println("Обработка исключения")
//    val comment3 = WallService.creatComment(postId = 10, Comment(textComment = "Комментарий к посту"))

    println("\n*** Удаление постов ")
    WallService.delete(Post(id = 3))
    WallService.delete(Post(id = 3))
    WallService.delete(Post(id = 12))
    WallService.printAllPost()

    println("\nВосстановление поста")
    WallService.undelete(Post(id = 3))
    WallService.undelete(Post(id = 5))
    WallService.undelete(Post(id = 11))

    WallService.getComment(0)
    println("Коммент ${WallService.getComment(0).idComment}" +
            " к посту ${WallService.getComment(0).idPostComment}" +
            " ${WallService.getComment(0).commentDelete}" +
            " ${WallService.getComment(0).textComment}")

    WallService.updateComment(Comment(2, textComment = "Вместо второго коммента"))
    println("Коммент ${WallService.getComment(2).idComment}" +
            " к посту ${WallService.getComment(2).idPostComment}" +
            " ${WallService.getComment(2).textComment}")

    println("\n*** Удаление комментов ")
    WallService.deleteComment(Comment(idComment = 1))

    WallService.unDeleteComment(Comment(idComment = 1))
    println("Коммент ${WallService.getComment(0).idComment}" +
            " к посту ${WallService.getComment(0).idPostComment}" +
            " ${WallService.getComment(0).textComment}")
}
