package com.team_3.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	 // 파일을 저장할 경로
    private static String UPLOAD_DIR = "/path/to/upload/directory";

    public String saveFile(MultipartFile file) {
        try {
            // 파일을 저장하는 로직
            // 예를 들어, 업로드 디렉토리에 파일을 저장하고 저장된 파일의 경로를 반환할 수 있습니다.
            String fileName = file.getOriginalFilename();
            String filePath = "C:\\Users\\user\\Documents\\jcFile" + File.separator + fileName;
            file.transferTo(new File(filePath));
            return filePath; // 저장된 파일의 경로 반환
        } catch (IOException e) {
            // 파일 저장 중 오류가 발생한 경우 처리
            e.printStackTrace();
            return null; // 오류 발생 시 null 반환 또는 예외 처리
        }
    }

}
