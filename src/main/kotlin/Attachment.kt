package ru.netology.data

sealed class Attachment(
    val typeAttachment: String,
)

data class Photo(
    val idPhoto: Int = 0,
    val idAlbumPhoto: Int = 0,
    val idOwnerPhoto: Int = 0,
    val idUserPhoto: Int = 0,
    val textPhoto: String = "New photo",
    val datePhoto: Int = 0,
    val widthPhoto: Int = 16,
    val heightPhoto: Int = 16
)

data class PhotoAttachment(val photo: Photo) : Attachment("photo")

data class Audio(
    val idAudio: Int = 0,
    val idOwnerAudio: Int = 0,
    val artistAudio: String = "New artist",
    val titleAudio: String = "New title",
    val durationAudio: Int = 0,
    val urlMP3Audio: String = "",
    val idLyricsAudio: Int = 0,
    val idAlbumAudio: Int = 0,
    val idGenreAudio: Int = 0,
    val dateAudio: Int = 0,
    val noSearchAudio: Boolean = true,
    val isHQAudio: Boolean = true
)

data class AudioAttachment(val audio: Audio): Attachment("audio")

data class Present(
    val idPresent: Int = 0,
    val thumb256: String?,
    val thumb96: String?,
    val thumb48: String?
)

data class PresentAttachment(val present: Present): Attachment("present")

data class Files(
    val idFiles: Int = 0,
    val idOwnerFiles: Int = 0,
    val titleFiles: String = "New File",
    val sizeFiles: Int = 0,
    val extFiles: String = "",
    val urlFiles: String = "",
    val dateFiles: Int = 0,
    val typeFiles: Int = 8
)

data class FilesAttachment(val files: Files): Attachment("files")

data class Graffiti(
    val idGraffiti: Int = 0,
    val idOwnerGraffiti: Int = 0,
    val urlGraffiti: String = "",
    val widthGraffiti: Int = 16,
    val heightGraffiti: Int = 16
)

data class GraffitiAttachment(val graffiti: Graffiti): Attachment("graffiti")
