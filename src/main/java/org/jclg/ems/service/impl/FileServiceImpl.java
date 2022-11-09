package org.jclg.ems.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.jclg.ems.service.FileService;
import org.jclg.ems.utils.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileServiceImpl  implements FileService {
    @Override
    public String uploadFileOss(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat time = new SimpleDateFormat("HHmmss");
        String format = sdf.format(new Date());
        String format2 = time.format(new Date());
        String split = fileName.substring(fileName.length()-4);
        String newName = format+format2+split.toLowerCase();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            fileName = newName;
        InputStream inputStream = file.getInputStream();
        ossClient.putObject(bucketName,fileName,inputStream);
        ossClient.shutdown();
        String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
        return  url;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
