const idInput = document.getElementById('id-input');
const pwInput = document.getElementById('pw-input');
const pwCheck = document.getElementById('pw-check-input');
const emailInput = document.getElementById('pw-check-input');
const imageInput = document.getElementById('image-input');
const joinBtn = document.getElementById('join_btn');

// 6-20자 이내 아이디 정규표현식
const REGID = /^[a-z]+[a-z0-9]{5,19}$/g;
// 8-20자 이내 문자, 숫자, 특수문자 확인 비밀번호
const REGPASSSWORD = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,20}$/;



