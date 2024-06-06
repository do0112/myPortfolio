'use strict';

// top button
const quick = document.querySelector('#quick');
quick.addEventListener('click', () => {
    window.scroll({
        top: 0,
        behavior: 'smooth',
    })
});

//네비게이션바에 '전체' hover 시 메뉴 생성
const all = document.querySelector('.all');
const sub = document.querySelector('#sub_menu');

all.addEventListener('mouseenter',() => {
    sub.addEventListener('mouseenter',() => {
        sub.style.display = 'block';
    });
    sub.style.display = 'block';
});
all.addEventListener('mouseleave',() => {
    sub.addEventListener('mouseleave',() => {
        sub.style.display = 'none';
    });
    sub.style.display = 'none';
});



// 페이지 아래로 스크롤 시 header 배경색 변경
const header = document.querySelector('.header');
const headerHeight = header.getBoundingClientRect().height;
document.addEventListener('scroll',() => {
    if(window.scrollY > headerHeight){
        header.classList.add('header--border');
    }else{
        header.classList.remove('header--border');
    }
});

//스크롤 시 banner 이미지 투명하게
const banner = document.querySelector('#banner');
const bannerHeight = banner.getBoundingClientRect().height;
const arrowUp = document.querySelector('.aside');
document.addEventListener('scroll', () => {
    banner.style.opacity = 1 - window.scrollY / bannerHeight;
//banner 절반까지 스크롤 시 top 버튼 나타냄
    if(window.scrollY > bannerHeight / 2){
        arrowUp.style.opacity = 1;
    }else{
        arrowUp.style.opacity = 0;
    } 
});

// 오늘의 TOP 마우스휠
function drage(event){
    event.preventDefault();

    trans += event.deltaY * -3.0;
    drage_width += event.deltaY * 3.0;
    trans = Math.min(Math.max(-1140, trans), 0);
    drage_width = Math.min(Math.max(0, drage_width), 1140);
    
    top_items.style.transform = `translateX(${trans}px)`;
    scrollbar_drag.style.transform = `translateX(${drage_width}px)`;

}
const top_items = document.querySelector('#top_items');
const scrollbar_drag = document.querySelector('#scrollbar_drag');
let trans = 0;
let drage_width = 0;
top_items.onwheel = drage;


//game answer
const answer = document.querySelector('#answer');
answer.addEventListener('click',() => {
    answer.style.display = 'none';
})




