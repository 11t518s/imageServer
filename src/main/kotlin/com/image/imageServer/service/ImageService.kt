package com.image.imageServer.service

import AWSConfig
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.services.s3.model.ObjectCannedACL
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.time.LocalDate


@Service
class ImageService {


    @Value("\${aws_image_bucket_name}")
    private lateinit var bucketName: String

    fun testaa() {

    }

    fun uploadImage(file: MultipartFile): PutObjectRequest {
        val date = LocalDate.now()
        val year = date.year
        val month = date.month
        val day = date.dayOfMonth

        val dateSuffix = "${year}_${month}_${day}"
        val fileName: String = "${file.originalFilename}_(${dateSuffix})"
        val putObjectRequest: PutObjectRequest = PutObjectRequest.builder().bucket("MerakiplaceImages").key("").acl(ObjectCannedACL.BUCKET_OWNER_FULL_CONTROL).build()


         AWSConfig().s3Client().putObject(putObjectRequest)
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