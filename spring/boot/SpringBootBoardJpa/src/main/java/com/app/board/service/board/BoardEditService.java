package com.app.board.service.board;

import com.app.board.domain.BoardEditRequest;
import com.app.board.entity.BoardEntity;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Log4j2
@Service
public class BoardEditService {

    @Autowired
    private BoardRepository boardRepository;

    public int edit(BoardEditRequest boardEditRequest){

        MultipartFile file = boardEditRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;

        if(file!=null && !file.isEmpty()){

            // 수정시 새로운 파일을 저장
            String absolutePath = new File("").getAbsolutePath();
            log.info(absolutePath);

            String path = "photo";
            saveDir = new File(absolutePath, path); // 새 경로

            // 폴더가 존재하지 않으면 생성
            if(!saveDir.exists()){
                saveDir.mkdir(); // make directory
                log.info(" >>>>>> photo 디렉토리 생성! ");
            }

                // 난수 입력 발생 ->
                String uuid = UUID.randomUUID().toString();
                // 게시물에 종속시키기 위해 이름 따로 저장 : 새 파일의 이름을 생성
                newFileName = uuid+file.getOriginalFilename();

                // 새로운 저장 파일의 경로(생성한 폴더에 저장됨)
                File newFile = new File(saveDir, newFileName);

                try {
                    // 파일 저장
                    file.transferTo(newFile);
                    log.info(" >>>>> newFileName >>>>>" + newFileName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        BoardEntity boardEntity = boardEditRequest.toBoardEntity();
        boardEntity.setUpdateDate(LocalDate.now());
        if(newFileName != null){
            boardEntity.setPhoto(newFileName);
        }/* else {
            boardEntity.setPhoto(null);
        }*/

        log.info(" >>>> DB에 저장 >>>>" + boardEntity);

        int result = 0;

        try {

            // DB upadate
            result = boardRepository.save(boardEntity) != null ? 1: 0;

            // 새로운 파일 저장된 후 이전 파일 존재시 -> 해당 파일 삭제 처리
            // 삭제 시점은 DB저장 및 정상처리가 끝난 이후!!
            String oldFileName = boardEditRequest.getOldFile();
            if(newFileName!=null && oldFileName!=null && !oldFileName.isEmpty()){
                // 삭제할 파일의 경로
                File delOldFile = new File(saveDir, oldFileName);
                if(delOldFile.exists()){
                    // 파일 삭제
                    delOldFile.delete();
                    log.info(oldFileName = "파일 삭제");
                }
            }

        } catch (Exception e){

            log.info("Ecxeption >>>>>>>> " + newFileName);
            // 새롭게 저장된 파일 삭제
            if(newFileName!=null){
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()){
                    delFile.delete();
                }
            }

        }

        return result;
    }
}
