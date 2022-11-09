package org.jclg.ems.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFileOss(MultipartFile file);
}
