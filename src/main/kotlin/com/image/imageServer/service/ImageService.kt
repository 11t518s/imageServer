package com.image.imageServer.service

import AWSConfig
import com.amazonaws.services.s3.AmazonS3Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


@Service
@ComponentScan("com.image.imageServer.config.AWSConfig")
class ImageService (

     private val amazonS3Client: AmazonS3Client,

){


    @Value("\${aws_image_bucket_name}")
    private lateinit var bucketName: String

    fun testaa() {

    }

    fun uploadImage(file: MultipartFile) {
//        val date = LocalDate.now()
//        val year = date.year
//        val month = date.month
//        val day = date.dayOfMonth
//
//        val dateSuffix = "${year}_${month}_${day}"
//        val fileName: String = "${file.originalFilename}_(${dateSuffix})"
//        val putObjectRequest: PutObjectRequest = PutObjectRequest.builder().bucket("MerakiplaceImages").key("").acl(ObjectCannedACL.BUCKET_OWNER_FULL_CONTROL).build()
//
//
//         AWSConfig().s3Client().putObject(putObjectRequest)
    }

    @Throws(IOException::class)
    private fun convertMultiPartToFile(file: MultipartFile): File {
        val convFile = File(file.originalFilename)
        val fos = FileOutputStream(convFile)
        fos.write(file.bytes)
        fos.close()
        return convFile
    }

}