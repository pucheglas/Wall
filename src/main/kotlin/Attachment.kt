package ru.netology.data

abstract class Attachment(
    val typeAttachment: String,
)

class Photo(
    val idPhoto: Int = 0,
    val idAlbumPhoto: Int = 0,
    val idOwnerPhoto: Int = 0,
    val idUserPhoto: Int = 0,
    val textPhoto: String = "New photo",
    val datePhoto: Int = 0,
    val widthPhoto: Int = 16,
    val heightPhoto: Int = 16
)

class PhotoAttachment(val photo: Photo) : Attachment("photo") {

}

class Audio(
    val idAudio: Int = 0,
    val idOwnerAudio: Int = 0,
    val artistAudio: String = "New artist",
    val titleAudio: String = "New title",
    val durationAudio: Int = 0,
    val urlMP3Audio: String = "",
    val idLyricsAudio: Int?,
    val idAlbumAudio: Int?,
    val idGenreAudio: Int = 0,
    val dateAudio: Int = 0,
    val noSearchAudio: Boolean = true,
    val isHQAudio: Boolean = true
)

class AudioAttachment(val audio: Audio): Attachment("audio")

class Gift(
    val idGift: Int = 0,
    val thumb256: String?,
    val thumb96: String?,
    val thumb48: String?
)

class GiftAttachment(val gift: Gift): Attachment("gift")

class Files(
    val idFiles: Int = 0,
    val idOwnerFiles: Int = 0,
    val titleFiles: String = "New File",
    val sizeFiles: Int = 0,
    val extFiles: String = "",
    val urlFiles: String = "",
    val dateFiles: Int = 0,
    val typeFiles: Int = 8
)

class FilesAttachment(val files: Files): Attachment("files")

class Graffiti(
    val idGraffiti: Int = 0,
    val idOwnerGraffiti: Int = 0,
    val urlGraffiti: String = "",
    val widthGraffiti: Int = 16,
    val heightGraffiti: Int = 16
)

class GraffitiAttachment(val graffiti: Graffiti): Attachment("graffiti")