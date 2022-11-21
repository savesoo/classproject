package com.firstcoding.mvc.springmvc.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Report {

    // 파라미터 이름과 일치시킴
    private String snum;
    private String sname;
    private MultipartFile report;

}
