package io.github.egorshramko.cbs.service;

public interface S3PresignedUrlService {

    String getPresignedUrl(String bucket, String objectKey);

}
