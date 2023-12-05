import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AWSConfig {

    @Value("\${cloud.aws.credentials.accessKey}")
    private lateinit var accessKey: String

    @Value("\${cloud.aws.credentials.secretKey}")
    private lateinit var secretKey: String

    @Value("\${cloud.aws.region.static}")
    private lateinit var region: String


    @Bean
    fun amazonS3Client(): AmazonS3Client {
        val basicAWSCredentials: BasicAWSCredentials = BasicAWSCredentials(accessKey,secretKey)
        return AmazonS3ClientBuilder
            .standard()
            .withRegion(region)
            .withCredentials(AWSStaticCredentialsProvider(basicAWSCredentials))
            .build()
                as AmazonS3Client
    }
}
