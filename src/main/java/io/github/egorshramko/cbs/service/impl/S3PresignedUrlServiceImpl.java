package io.github.egorshramko.cbs.service.impl;

import java.net.URL;
import java.time.Duration;

import org.springframework.stereotype.Service;

import io.awspring.cloud.s3.S3Template;
import io.github.egorshramko.cbs.service.S3PresignedUrlService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class S3PresignedUrlServiceImpl implements S3PresignedUrlService {

    private final S3Template s3Template;

    @Override
    public String getPresignedUrl(String bucket, String objectKey) {
        
        URL presignedUrl = s3Template.createSignedGetURL(bucket, objectKey, Duration.ofMinutes(5));

        return presignedUrl.toString();

    }

}
