package com.image.imageServer.utils

import com.image.imageServer.config.AWSConfig
import com.amazonaws.services.s3.AmazonS3Client
import org.springframework.stereotype.Component

@Component
class S3Uploader constructor(
    private val awsS3Config: AWSConfig,
) {




}