package com.image.imageServer.controller

import com.image.imageServer.service.ImageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
class ImageController constructor(
    private val imageService: ImageService,
) {
    @PostMapping("/api/upload")
    fun uploadImage(
        @RequestPart(required = true) file: MultipartFile,
    ): String {
        println("api/upload")
        return imageService.uploadImage(file)
    }
}