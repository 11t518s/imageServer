package com.image.imageServer.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.time.LocalDate


@Service
class ImageService {

    @Autowired
    private lateinit var s3Client: AmazonS3

    @Value("\${aws_image_bucket_name}")
    private lateinit var bucketName: String

    fun uploadImage(file: MultipartFile): String {
        val date = LocalDate.now()
        val year = date.year
        val month = date.month
        val day = date.dayOfMonth

        val dateSuffix = "${year}_${month}_${day}"
        val fileName: String = "${file.originalFilename}_(${dateSuffix})"
        println(fileName)
        s3Client.putObject(PutObjectRequest(bucketName, fileName, convertMultiPartToFile(file)))

        return fileName
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