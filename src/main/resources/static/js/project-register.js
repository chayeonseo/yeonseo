const addDetailsBtn = document.getElementById('add-details');
const detailList = document.createElement('div');
const detailImg = document.getElementById('image-input');
const detailText = document.getElementById('detail-text');
const detailContainer = document.querySelector('.details-list');
const detailDeleteBtn = document.createElement('button');
const listCon = document.getElementById('list-container');
const form = document.getElementById('form');

const detailImgObjList = [];
let selectedFileObj = null; // 현재 선택한 파일 obj
let thumbFileObject = null;

const projectTitle = document.getElementById('title');
const projectThumbImage = document.getElementById('thumbImage');
const projectCategory = document.getElementById('category');
const projectGoal = document.getElementById('goal');
const projectCreateUser = document.getElementById('createUser');
const projectSummary = document.getElementById('summary');
const projectPrice = document.getElementById('price');
const projectDelivery = document.getElementById('delivery');
const projectStartDate = document.getElementById('startDate');
const projectEndDate = document.getElementById('endDate');
const today = new Date();
const tY = today.getFullYear();
const tM = today.getMonth() + 1;
const tD = today.getDate();

projectStartDate.setAttribute("min", today.toISOString().substring(0,10));
projectStartDate.onchange = () => {
    projectEndDate.value = projectStartDate.value;
    projectEndDate.setAttribute("min", projectStartDate.value);
}


projectThumbImage.onchange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    thumbFileObject = {
        name: file.name,
        type: file.type,
    }
    reader.readAsDataURL(file);
    reader.onload = (value) => {
        // 해당 img의 base64 인코딩 결과
        thumbFileObject.detail = value.currentTarget.result;
    }
}

detailImg.onchange = (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();
    selectedFileObj = {
        name: file.name,
        type: file.type,
    };
    reader.readAsDataURL(file);
    reader.onload = (value) => {
        // 해당 img의 base64 인코딩 결과
        selectedFileObj.detail = value.currentTarget.result;
    }
}
function submit_data(){
    let projectStatus = 2;
    if (today.toISOString().substring(0,10) === projectStartDate.value){
        projectStatus = 1;
    }

    detailImgObjList.forEach((detailImgObj, index) => {
        detailImgObj.order = index;
    });

    let data = {
        title: projectTitle.value,
        thumbImage: thumbFileObject,
        category: {id: projectCategory.value},
        goal: projectGoal.value,
        summary: projectSummary.value,
        price: projectPrice.value,
        delivery: projectDelivery.value,
        startDate: projectStartDate.value,
        endDate: projectEndDate.value,
        details: detailImgObjList,
        status: projectStatus
    }

    fetch('/project/insert', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
        .then(res => {
            if(res.status === 201){
                alert('등록이 완료되었습니다!');
                location.href = '/home';
            }else{
                alert('문제가 발생했습니다 ㅠㅠ');
            }
        });
}


let num = 0;

addDetailsBtn.onclick = () => {
    if(selectedFileObj !== null) {
        detailImgObjList.push(selectedFileObj);
        detailContainer.insertAdjacentHTML("beforeend",  `<div className="details-list" id="${detailImgObjList.length}" style="display: flex;, margin-top: 15px;">
            <div class="index-num" style="margin-right: 10px;, margin-left: 5px;">${detailImgObjList.length}</div>
            <div style="margin-right: 10px;">파일명 :  ${detailImg.value}</div>
            <button class="detailDeleteBtn" onclick="delete_obj(this)" style="border: none; color: red">삭제</button>
        </div>`);
        detailDeleteBtn.innerText = "삭제";
    }

    if(detailText.value.trim() !== ''){
        const detailTextObj = {
            detail: detailText.value,
            type: "text/plain"
        };
        detailImgObjList.push(detailTextObj);
        detailContainer.insertAdjacentHTML("beforeend", `
        <div className="details-list" id="${detailImgObjList.length}" style="display: flex;, margin-top: 15px;">
            <div class="index-num" style="margin-right: 10px;, margin-left: 5px;">${detailImgObjList.length}</div>
            <div style="margin-right: 10px;">상세내용 :  ${detailText.value}</div>
            <button class="detailDeleteBtn" onclick="delete_obj(this)" style="border: none; color: red">삭제</button>
        </div>`);
        detailDeleteBtn.innerText = "삭제";
    }
    detailText.value = "";
    detailImg.value = null;
    selectedFileObj = null;

    console.log(detailImgObjList)
}

function delete_obj(button){
    const id = button.parentElement.id;
    const detailListDivs = listCon.children;
    detailImgObjList.splice(id-1, 1);
    button.parentElement.remove();
    for( let i = 0; i < detailListDivs.length; i++){
        detailListDivs[i].id = i + 1;
        const numberDiv = detailListDivs[i].querySelector('.index-num');
        numberDiv.textContent = i + 1;
    }

    console.log(detailImgObjList)
}

