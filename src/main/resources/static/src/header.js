'use strict';

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


// top button
const quick = document.querySelector('#quick');
quick.addEventListener('click', () => {
    window.scroll({
        top: 0,
        behavior: 'smooth',
    })
});

