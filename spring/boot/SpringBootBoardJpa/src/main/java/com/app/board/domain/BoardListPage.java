package com.app.board.domain;

import com.app.board.entity.BoardEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardListPage {

    // 페이지당 출력할 게시물의 개수
    private long countPerPage;

    // 현재 페이지 번호
    private int pageNum;

    // 게시글의 리스트
    private List<BoardEntity> list;

    // 전체 게시물의 개수
    private long totalCount;

    // 페이징의 시작 번호 -> 내부 연산 처리
    private int startNum;

    // 페이징의 끝 번호 -> 내부 연산 처리
    private int endNum;

    // 이전 버튼 출력여부 -> 내부 연산 처리
    private boolean prev;

    // 다음 버튼 출력 여부 -> 내부 연산 처리
    private boolean next;

    public BoardListPage(int countPerPage,
                         int pageNum,
                         List<BoardEntity> list,
                         long totalCount) {
        this.countPerPage = countPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {

        // 한 페이지의 끝번호(1~10)
        this.endNum = (int)(Math.ceil((this.pageNum * 1.0) / 10))*10;
        // 1 -> 1.0 / 10 -> 0.1 -> 가장 가까운 정수 1.0 -> int로 변환 = 1 * 10 = 10 (끝번호) 10이 끝번호인 페이지에 속함
        // 11 -> 11.0 / 10 -> 1.1 -> 가장 가까운 정수 2.0 -> int로 변환 = 2 * 10 = 20
        // 35*1.0 = 35.0/10 = 3.5 -> 가까운 정수 4 -> int로 변환 = 4*10 = 40
        this.startNum = this.endNum-9; // 20-19=1

        //this.endNum = (int)((Math.ceil((this.pageNum*1.0)/5)+1))*10;
        //this.startNum = this.endNum-4;

        // 전체 페이지의 끝번호
        int realEndNum = (int)(Math.ceil((this.totalCount * 1.0) / countPerPage));
        // 35*1.0 = 35.0/10 = 3.5 -> 가까운 정수 4 -> int로 변환 = 4
        // 원래 한 페이지에 10개까지 들어가므로 페이지 계산을 위해 10과 비교연산(10개 중 4개밖에 없다면 4를 반환)


        // 실제 마지막 번호가 끝번호(최댓값)보다 작다면 현재 번호, 아니면 끝번호를 반환
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;


        // 이전 페이지 존재 여부
        // 시작하는 숫자가 1보다 크다면 true
        this.prev = this.startNum > 1;


        // 다음 페이지 존재 여부
        // 현재 마지막 숫자가 구간의 마지막 숫자(total)보다 작다면 true, 아니면 false
        this.next = this.endNum < realEndNum;

    }

}
