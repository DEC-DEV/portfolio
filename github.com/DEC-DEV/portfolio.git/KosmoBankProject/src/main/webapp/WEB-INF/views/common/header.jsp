<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
 <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
 <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <!-- Custom styles for this template-->
  <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
  <!-- font-awosome cdn사이트 -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Work+Sans&display=swap" rel="stylesheet">


  
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" style="font-family: 'Noto Sans KR', sans-serif;">

            <!-- Sidebar - Brand -->
            <!--  임시로 admin.do로 연결 (시큐리티 적용할 때는 admin.ad로 변경해야함 ) -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${path }/admin.ad">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3"> KOSMOS_BANK </div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

     
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                고객관리
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>계좌 정보</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="${path}/account_info.ad">회원별 계좌 관리 </a>
                        <a class="collapse-item" href="${path}/account_transfer_history.ad">회원별 계좌이체 내역</a>
                    </div>
                </div>
            </li>
			 <hr class="sidebar-divider">
            <!-- Nav Item - Utilities Collapse Menu -->
            <!-- Heading -->
            <div class="sidebar-heading">
                예금 관리
            </div>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>예금 상품</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
             
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="${path}/deposit_add.ad">등록</a>
                        <a class="collapse-item" href="${path}/deposit_list.ad">조회</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                대출 관리
            </div>
			 <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>대출</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">대출</h6>
                        <a class="collapse-item" href="${path }/loan_list.ad">대출신청자 리스트</a>
                        <a class="collapse-item" href="${path }/loan_pro_list_2.ad">대출상품 리스트</a>
                        <a class="collapse-item" href="${path }/loan_pro_add.ad">대출상품 등록</a>
                    </div>
                </div>
              </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                적금
            </div>
              <li class="nav-item">
               	<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse1"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>적금 상품</span>
                </a>
 				<div id="collapse1" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">적금상품</h6>
                        <a class="collapse-item" href="${path}/savings_add.ad">등록</a>
                        <a class="collapse-item" href="${path}/savingsList.ad">조회</a>
                    </div>
                </div>
                </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                펀드
            </div>
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse2"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>펀드 상품 </span>
                </a>
                 <div id="collapse2" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">펀드</h6>
                        <a class="collapse-item" href="${path }/fund_approve.ad">펀드내용 보기</a>
                    </div>
                </div>
             </li>
             <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                고객센터
            </div>
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse3"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>고객센터</span>
                </a>
                 <div id="collapse3" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                       <h6 class="collapse-header">채팅상담</h6>
                        <a class="collapse-item" href="${path}/chat.ad">1대1 채팅</a>
                       <h6 class="collapse-header">고객상담</h6>
                        <a class="collapse-item" href="${path}/counsel_list_search.ad">고객상담 목록</a>
                        <h6 class="collapse-header">공지사항</h6>
                        <a class="collapse-item" href="${path}/notice_list_search.ad">공지사항 목록</a>
                        <a class="collapse-item" href="${path}/notice_insert.ad">공지사항 등록</a>
                    </div>
                </div>
            <!-- Divider -->
             </li>
             <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            <li class="nav-item">
                <a class="nav-link" href="${path }/logout.do">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>로그아웃</span>
                </a>
            </li>
              <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
       
		</ul>
          
