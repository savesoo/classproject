import React from 'react';
import Header from "./Header";
import Wrapper from "./Wrapper";
import Nav from "./Nav";

const blogData = {

    header : {
        title : 'Soo make blog by React!',
        description : '공부 아카이빙 블로그'
    },
    nav : {

        taps : [
            {name : 'HTML5', linkUrl: '#'},
            {name : 'CSS', linkUrl: '#'},
            {name: 'JavaScript', linkUrl: '#'},
            {name: 'React', linkUrl: '#'}
        ]

    },
    aside : {

        category : [
            {name : '문법', linkUrl: '#'},
            {name : '오류', linkUrl: '#'},
            {name : '참고사항', linkUrl: '#'},
            {name :  'data', linkUrl: '#'}
        ],
        recentPost : [
            {name : '제목1', linkUrl: '#'},
            {name : '제목2', linkUrl: '#'},
            {name : '제목3', linkUrl: '#'},
            {name : '제목4', linkUrl: '#'}
        ]

    },
    postList : [
        {title : 'html', postdate: '2022-01-01', imgUrl: "http://ticketimage.interpark.com/Play/image/large/21/21010169_p.gif",
            contents: '뮤지컬 <팬레터>는 1930년대 자유를 억압하던 일제강점기 시절, 한국 문단을 대표하는 문인인 이상과 김유정 등과 순수문학단체 구인회의 에피소드를 모티브 삼아 역사적 사실과 상상을 더해 만들어진 모던 팩션(Faction) 뮤지컬이다.'},
        {title : 'javascript', postdate: '2022-03-20', imgUrl: 'https://pbs.twimg.com/media/FCBGhp7UcAMSncO.jpg',
            contents: '천재 소설가 김해진과 그를 동경하는 소설가 지망생 정세훈, 비밀에 싸인 천재 여류작가 히카루까지 세 인물을 주축으로 순수 문학을 향한 문인들의 예술혼과 사랑을 매혹적으로 그려냈다.'},
        {title : 'bootstrap', postdate: '2022-07-08', imgUrl: 'https://pbs.twimg.com/media/FCBGZVjUYAEquiL.jpg',
            contents: '2016년 초연이래 매 시즌마다 공연예매 사이트 랭킹 1위와 매진 행렬로 가히 ‘팬레터 열풍’이라는 진귀 현상을 만들어 낸 뮤지컬 <팬레터>는 2018년 한국 창작뮤지컬 최초로 대만에 진출해 국내는 물론 해외 시장에 이르기까지 콘텐츠의 우수성을 인정받았다.'},
        {title : 'java', postdate: '2022-12-25', imgUrl: "https://pbs.twimg.com/media/FCBGN5lVIAYt_0F.jpg",
            contents: '작품성과 대중성, 화제성까지 흥행 3박자를 모두 갖춘 대표 창작 뮤지컬 <팬레터>의 네번째 시즌에는 실력파 배우 김경수, 윤나무, 백형훈, 려욱, 문성일, 박준휘, 김진욱, 소정화, 강혜인, 허혜진 등이 출연하며 오는 12월 10일부터 내년 3월 20일까지 코엑스아티움에서 공연된다. 출처 : 서울문화투데이(http://www.sctoday.co.kr)'},
        {title: 'react', postdate: '2022-12-31', imgUrl: "https://pbs.twimg.com/media/FCBGexpUYAUv7zK.jpg",
            contents: '대한민국의 창작 뮤지컬. 2015 우수 크리에이터 발굴 지원 사업의 최우수 선정작. 1930년대를 배경으로 천재 작가 ‘이상‘과 ‘김유정‘, 그리고 경성 문인들의 모임인 ‘구인회‘의 일화를 모티브로 하여 당시 문인들의 사랑과 예술을 그린 작품이다.'}
    ]

}


function MainView(props) {
    return (
        <>
           <Header header={blogData.header}/>
            <Nav nav={blogData.nav}/>
            <Wrapper postList={blogData.postList}
                     category={blogData.aside.category}
                     recentPost={blogData.aside.recentPost}/>
            <footer>
                Create by Soo
            </footer>
        </>
    );
}

export default MainView;