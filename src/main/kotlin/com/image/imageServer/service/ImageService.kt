package com.image.imageServer.service

import com.image.imageServer.config.AWSConfig
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.time.LocalDate


@Service
class ImageService (
     private val awsS3Config: AWSConfig,
){
    @Value("\${aws_image_bucket_name}")
    private lateinit var bucketName: String

    fun uploadImage(file: MultipartFile): String {
        val date = LocalDate.now()
        val year = date.year
        val month = date.month
        val day = date.dayOfMonth

        val dateSuffix = "${year}_${month}_${day}"
        val fileName: String = "${file.originalFilename}_(${dateSuffix})"

        val objectMetaData = ObjectMetadata()

        return try {
            awsS3Config.amazonS3Client().putObject(bucketName, fileName, file.inputStream, objectMetaData)
            "success"
        } catch (e: IOException) {
            "fail"
        }
    }
}