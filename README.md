# READ ME
* This project can be use to upload, download, delete file from AWS S3 bucket
* After uploading to s3 send an email using sns service
* You can subscribe you email id using **/api/v1/notify/subscription/{email}** endpoint
* Need to confirm the subcription request send in the email id
* In [StorageConfig.java](src%2Fmain%2Fjava%2Fcom%2Fsample%2Fcloud%2Fstorage%2Fconfig%2FStorageConfig.java) beans are available to connect to the aws S3 and SNS

### Prerequisite
* A S3 bucket
* Put the bucket name in application.yaml under bucket.name
* Create a topic into SNS service
* Take the topic arn and put in application.yaml under topic.name
* Under username in aws console - go to Security Credentials - there create aws key and secret
