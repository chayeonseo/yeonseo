const addDetailsBtn = document.getElementById('add-details');
const detailList = document.createElement('div');
const detailImg = document.getElementById('image-input');
const detailText = document.getElementById('detail-text');
const detailContainer = document.querySelector('.details-list');
const detailDeleteBtn = document.createElement('button');
const reader = new FileReader();
const detailImgObjList = [];
let selectedFileObj = null; // 현재 선택한 파일 obj

detailImg.onchange = (e) => {
    const file = e.target.files[0];
    selectedFileObj = {
        name: file.name,
        type: file.type,
    };
    reader.readAsDataURL(file);
}

reader.onload = (value) => {
    // 해당 img의 base64 인코딩 결과
    selectedFileObj.detail = value.currentTarget.result;
}


addDetailsBtn.onclick = () => {
    if(selectedFileObj !== null) {
        detailImgObjList.push(selectedFileObj);
        detailContainer.insertAdjacentHTML("beforeend",  `<div className="details-list" style="display: flex ">
            <div>파일명 : ${detailImg.value}</div>
            <button class="detailDeleteBtn" onclick="delete_obj(this)">삭제</button>
        </div>`);
        detailDeleteBtn.innerText = "삭제";
    }

    if(detailText.value.trim() !== ''){
        const detailTextObj = {
            detail: detailText.value
        };
        detailImgObjList.push(detailTextObj);
        detailContainer.insertAdjacentHTML("beforeend",  `<div className="details-list" style="display: flex " >
            <div>상세내용 :  ${detailText.value}</div>
            <button class="detailDeleteBtn" onclick="delete_obj(this)">삭제</button>
        </div>`);
        detailDeleteBtn.innerText = "삭제";
    }

    detailText.value = "";
    detailImg.value = null;
    selectedFileObj = null;

    console.log(detailImgObjList)
}

function delete_obj(button){
    button.parentElement.remove()
}