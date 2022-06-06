package ru.netology.data




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

    WallService.update(Post(id = 4, text = "Вместо пятого поста", idOwner = 11, date = 150000))
    WallService.update(Post(id = 2, text = "Вместо третьего поста", idOwner = 22, date = 1500))

    println("${WallService.get(0).id} ${WallService.get(0).text} ${WallService.get(0).idOwner} ${WallService.get(0).date}")
    println("${WallService.get(1).id} ${WallService.get(1).text} ${WallService.get(1).idOwner} ${WallService.get(1).date}")
    println("${WallService.get(2).id} ${WallService.get(2).text} ${WallService.get(2).idOwner} ${WallService.get(2).date}")
    println("${WallService.get(3).id} ${WallService.get(3).text} ${WallService.get(3).idOwner} ${WallService.get(3).date}")
    println("${WallService.get(4).id} ${WallService.get(4).text} ${WallService.get(4).idOwner} ${WallService.get(4).date}")
    println("${WallService.get(5).id} ${WallService.get(5).text} ${WallService.get(5).idOwner} ${WallService.get(5).date}")

    println(AudioAttachment(audio = Audio()).typeAttachment)
    println(PresentAttachment(present = Present(thumb256 = "", thumb96 = "", thumb48 = "")).typeAttachment)
    println(PhotoAttachment(photo = Photo()).typeAttachment)

    val comment1 = WallService.creatComment(postId = 2, Comment(textComment = "Комментарий к посту"))
    println("comment id = ${comment1.idComment}, text = ${comment1.textComment} ${comment1.idPostComment}")

    val comment2 = WallService.creatComment(postId = 5, Comment(textComment = "Комментарий к посту"))
    println("comment id = ${comment2.idComment}, text = ${comment2.textComment} ${comment2.idPostComment}")

    val comment3 = WallService.creatComment(postId = 10, Comment(textComment = "Комментарий к посту"))

}

