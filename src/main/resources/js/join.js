// 비밀번호 변경 유효성 검사
import {password_validation} from './check_password.js';
document.getElementById('pw').addEventListener('keyup', password_validation);
document.getElementById('pw2').addEventListener('keyup', password_validation);

// 닉네임 중복 확인
import {check_btn, animation_end, input_keyup} from './setting.js';
let input = document.querySelector('#input_nickname');
let nickname_check = document.querySelector('.check_btn');
let check_p = document.querySelector('.nickname_check');

input.addEventListener('keyup', input_keyup);
nickname_check.addEventListener('click', check_btn);
check_p.addEventListener('animationend', animation_end);

var join = {
    init : function () {
        var _this = this;
        $('#change_pw_btn').on('click',function () {
            _this.save();
        });
    },
    save : function (){
        var data = {
            user_name : $('#user_name').val(),
            user_email : $('#user_email').val(),
            nickname: $('#nickname').val()
            pw2: $('#pw2').val()
        };

        window.print(user_name, user_email, nickname, pw2)
        $.ajax({
            type: 'POST',
            url: '/api/v1/users',
            dataType: 'json',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            window.location.href = '/login';
        }).fail(function(error){
            alert(JSON.stringify(error));
        })
}
join.init();