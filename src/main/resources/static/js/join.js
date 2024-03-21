const form = document.forms.item(0);
const joinBtn = document.getElementById('join_btn');
const certBtn = document.getElementById('cert_btn');
const csrfToken = document.getElementsByName('_csrf')[0].value;
const userCIInput = document.getElementById('user-ci');
let userVerified = false;


certBtn.onclick = () => {
    user_certification();
}

var IMP = window.IMP;      // 생략 가능
IMP.init("imp28336054"); // 예: imp00000000
// IMP.certification(param, callback) 호출


// 유저 본인인증
function user_certification(){
    IMP.certification({
        merchant_uid: "1"
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
            get_certification_unique_key(rsp.imp_uid)
        } else {}
    });
}

function get_certification_unique_key(imp_uid) {
    fetch('/user/cert/token')
        .then(resp => resp.text())
        .then(value => {
            console.log("token: ", value)
            fetch(`/user/cert/${imp_uid}`, {
                method: "POST",
                headers: {
                    'X-Csrf-Token': csrfToken,
                    'Content-Type': "application/json"
                },
                body: value,
            })
                .then(resp => {
                    if (!resp.ok) {
                        throw new Error("인증 실패");
                    }
                    return resp.text();
                })
                .then(value => {
                    console.log('성공:', value);
                    userCIInput.value = value;
                    joinBtn.textContent = "가입하기(인증완료)";
                    joinBtn.toggleAttribute('authenticated', true);
                    userVerified = true;
                })
                .catch(error => {
                    userVerified = false;
                    console.log(error);
                });
        });

    joinBtn.onclick = () => {
        // 인증이 완료되었다면 그냥 submit
        if(userVerified){
            form.submit();
        }
        // 인증이 안되었다면 재인증
        else{
            user_certification();
        }
    }
}