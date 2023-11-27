package com.image.imageServer.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File


@Service
class ImageService {
    val directory: String = ""

    @Transactional
    fun uploadImage(file: MultipartFile, name: String?): String {

//        file.transferTo(File())

        return ""

    }

}