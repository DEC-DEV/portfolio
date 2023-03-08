/**
 * 
 */

// 필수항목 체크
function signInCheck() {
	// 아이디 체크
	if (!document.joinform.id.value) {
		swal("아이디를 입력하세요.",{
			icon: "warning"
		});
		document.joinform.id.focus();
		return false;	
	} else if(!document.joinform.password.value) { //비밀번호 체크
		swal("비빌번호를 입력하세요.",{
			icon: "warning"
		});
		document.joinform.password.focus();
		return false;
	} else if(!document.joinform.repassword.value) { //비밀번호확인 체크
		swal("비밀번호(확인)을 입력하세요.",{
			icon: "warning"
		});
		document.joinform.repassword.focus();
		return false;
	} else if(document.joinform.password.value != document.joinform.repassword.value) { //비밀번호 일치 체크
		swal("입력하신 비밀번호가 서로 일치하지 않습니다",{
			icon: "warning"
		});
		document.joinform.repassword.value = "";
		document.joinform.repassword.focus();
		return false;
	} else if(!document.joinform.name.value) { // 이름 체크
		swal("이름을 입력하세요.",{
			icon: "warning"
		});
		document.joinform.name.focus();
		return false;
	} else if(!document.joinform.birthday.value) { // 생년월일 체크
		swal("생년월일을 입력하세요.",{
			icon: "warning"
		});
		document.joinform.birthday.focus();
		return false;
	} else if(!document.joinform.address.value) { // 주소 체크
		swal("주소를 입력하세요.",{
			icon: "warning"
		});
		document.joinform.address.focus();
		return false;
	} else if(!document.joinform.email1.value) { // 이메일 체크
		swal("이메일을 입력하세요.",{
			icon: "warning"
		});
		document.joinform.email1.focus();
		return false;
	} else if(document.joinform.email3.value == "0" && !document.joinform.email2.value) { // 이메일 체크
		swal("이메일 형식을 입력하세요.",{
			icon: "warning"
		});
		document.joinform.email2.focus();
		return false;
		
	// 2-1. join.jsp 폼바로 아래 추가
	// <input type="hidden" name="hiddenId" value="0">
	// hiddenId는 중복확인 버튼 클릭 여부 체크(0:클릭안함 1:클릭함)	
		
	// 2-2. 중복확인 버튼 클릭하지 않는 경우 "중복확인 해주세요."
	} else if(document.joinform.hiddenId.value == "0") { // 이메일 체크
		swal("중복확인 해주세요.",{
			icon: "warning"
		});
		document.joinform.dupChk.focus();
		return false;
		
	
		
	} 
}

// 아이디 중복 확인
// 1. 중복확인 페이지 open
function confirmId() {
	if(!document.joinform.id.value) {
		swal("아이디를 입력하세요.",{
			icon: "warning"
		});
		document.joinform.id.focus();
		return false;
	}
	
	
	var url = "/bank/confirmIdAction.do?id=" + document.joinform.id.value;
	window.open(url, "confirm", "menubar=no, height=500, width=500");	// window.open(url, "별칭", size);
}


// 3. 중복확인창 포커스
function confirmIdFocus() {
	document.confirmform.id.focus();
	
}

function confirmIdChk() {
	if(!document.confirmform.id.value) {
		swal("아이디를 입력하세요.",{
			icon: "warning"
		});
		document.confirmform.id.focus();
		return false;
	}
	
}

// 4. 자식창에서 부모창으로 값 전달
// opener = 부모창, window 객체의 open() 메서드로 열린 새창(=중복확인창)에서 부모창(=회원가입폼)에 접근할 때 사용
function setId(id) {
	opener.document.joinform.id.value = id;
	opener.document.joinform.hiddenId.value = "1";
	self.close();	
}


// 이메일 주소를 select 박스로 선택 - 회원가입용
function selectEmailChk() {
	if(document.joinform.email3.value != "0") {
		document.joinform.email2.value = document.joinform.email3.value;
	} else {
		document.joinform.email2.value = "";
		document.joinform.email2.focus();
	}
	
}

// 이메일 주소를 select 박스로 선택 -회원정보수정용
function selectEmailChkm() {
	if(document.modifyform.email3.value != "0") {
		document.modifyform.email2.value = document.modifyform.email3.value;
	} else {
		document.modifyform.email2.value = "";
		document.modifyform.email2.focus();
	}
}


