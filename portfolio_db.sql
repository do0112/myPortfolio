create database portfolio_db;
use portfolio_db;

-- member
insert into 
member(address,enroll_date,mail,mbti,phone,user_id,user_name,user_pw)
values('경기도 성남시',now(),'user1@naver.com','ENFP','01011112222','qwerty','user1','jjjK123!');

select * from member;

-- =============================================================================================

-- item_list
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','new',10,'korea','01.png','팔도 어라어라어묵라면(115g*4)',4320,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','best',20,'korea','02.png','로제 불닭볶음면(140g*4)',4080,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',30,'korea','03.png','순하군안성탕면(125g*5)',3960,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','best',10,'korea','04.png','신볶게티큰사발면(107g)',1650,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','best',30,'korea','05.png','팔도 비빔면딸기 봄에디션(135g*5)',4675,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('비폰','best',6,'vietnam','06.jpg','비폰 컵 쌀국수 소고기(120g)',1791,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('닛신','best',10,'japan','07.png','닛신호빵맨 컵라멘 우동(32g)',1620,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('캉스푸','best',10,'china','08.png','캉스푸 향라우육라면(104g*5)',5450,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','new',50,'korea','09.png','간짬뽕 엑스 큰컵(115g)',1550,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',8,'korea','10.jpg','먹태깡 큰사발면 청양마요맛(118g)',1760,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','new',50,'korea','11.png','맵탱흑후추소고기(110g*4)',4560,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','best',80,'korea','12.png','앵그리 너구리(121g*5)',3961,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','new',20,'korea','13.png','팔도 마라왕비빔면(135g*4) 2팩',13000,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',80,'korea','14.png','배홍동쫄쫄면(챌린지에디션)(129g*4)',4620,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('캉스푸','new',10,'china','15.png','캉스푸 쌍무소고기 컵라면(110g)*5',6350,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','',10,'korea','16.jpg','멸치칼국수 2종세트 8입',9680,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',50,'korea','17.jpg','푸팟퐁구리큰사발면(104g*1)',1760,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','',80,'korea','18.png','삼양라면 120g x 20입',1760,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','new',60,'korea','19.png','4가지치즈 불닭볶음면 145g x 16입',19040,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','',20,'korea','20.png','삼양 작은컵 베스트 3종 (컵삼양5,컵불닭볶음면5,컵까르보5)',16900,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','',30,'korea','21.png','짜짜로니 140g x 10입',8960,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','',8,'korea','22.png','나가사끼짬뽕 (115g*5)',5230,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','best',10,'korea','23.png','신라면더레드(123g*4)',4230,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','best',80,'korea','24.png','누들핏 어묵탕맛(36.2g*1)',1320,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',30,'korea','26.png','사천짜파게티큰사발(115g*16)',24640,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','',30,'korea','27.png','짜파게티큰사발(123g*6)',7590,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','',90,'korea','28.png','김치사발면(86g*1)',1100,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','best',90,'korea','29.png','불닭볶음면 140g X 10입',9980,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','',20,'korea','30.png','간짬뽕 (140g*5)',4950,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('삼양','new',10,'korea','31.png','보글보글부대찌개면(127g*4)',5500,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','new',10,'korea','32.png','팔도 짜장왕뚜껑 5개+우동왕뚜껑 5개 105g',9820,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('팔도','new',10,'korea','33.jpg','팔도 비빔면 매운맛, 20개',14200,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('캉스푸','best',10,'china','34.png','캉스푸 우육면 BIG 5개입',5050,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('닛신','best',10,'japan','35.jpg','닛신 컵누들 컵라면 3개',3800,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('마루짱','',10,'japan','36.jpg','마루짱 세이멘 컵라면 곱배기 2개',3200,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('마마','',10,'thailand','37.jpg','마마 크리미돔냥 55g 3봉지',2560,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('와이와이','',10,'thailand','38.jpg','와이와이 팟차베이비클램 60g 3봉지',2060,'spicy','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('비폰','',10,'vietnam','39.png','비폰 쌀국수(60g*5)',3790,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('바이샹','',10,'china','40.png','바이샹 사골맛(127g*5)',2090,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('탕달인','new',20,'china','41.png','탕달인 매운우육면',1100,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('마루타이','best',20,'japan','42.jpg','마루타이 지역별 인스턴트 2인분 라면',4200,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('오라이시','',10,'vietnam','43.jpg','오라이시 포보컵 70g',1490,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('하오하오','',10,'vietnam','44.jpg','하오하오 미톰새우 77g 3봉지',2300,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('바이샹','',10,'china','45.png','바이샹 4가지맛 컵라면',2560,'spicy','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('닛신','best',10,'japan','46.jpg','닛신 UFO 야끼소바 컵라면',2850,'mild','cup');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('마마','',10,'thailand','47.jpg','마마 크리미 봉지 55g 2봉지',1020,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('캉스푸','new',30,'china','48.png','캉스푸 토마토계란우육면(126*5)',5060,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','best',50,'korea','49.jpg','파스타랑알리오올리오(128g*1)',3240,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',30,'korea','50.jpg','파스타랑볼로네제(180g*1)',3080,'mild','bag');
insert into
item_list(item_brand,item_category,item_count,item_country,item_img,item_name,item_price,item_taste,item_type)
values('농심','new',30,'korea','51.png','누들핏 육개장사발면맛(35.5g*8)',10230,'mild','cup');

select * from item_list;

-- ============================================================================================

-- member_cart
insert into
member_cart(user_Id)
values('qwerty');

-- ============================================================================================


select * from member;
select * from item_list;
select * from member_cart;
select * from cart;



