package com.image.imageServer.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.time.LocalDate
import java.util.Date


@Service
class ImageService {
    val directory: String = ""

    @Transactional
    fun uploadImage(file: MultipartFile): String {
        val date = LocalDate.now()
        val year = date.year
        val month = date.month
        val day = date.dayOfMonth

        val dateSuffix = "${year}_${month}_${day}"
        val fileName: String = "${file.originalFilename}_(${dateSuffix})"


//        file.transferTo(File())

        return ""

    }

}