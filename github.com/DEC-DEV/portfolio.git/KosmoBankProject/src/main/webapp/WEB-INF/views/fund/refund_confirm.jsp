<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<meta charset="UTF-8">
 <link href="${path}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
 <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${path}/resources/css/sb-admin-2.min.css" rel="stylesheet">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
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
                    <span>계좌정보</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="#">비밀번호 변경</a>
                        <a class="collapse-item" href="#">계좌상태변경</a>
                        <a class="collapse-item" href="#">회원별 계좌이체내역</a>
                        <a class="collapse-item" href="#">회원별 계좌리스트</a>
                        <a class="collapse-item" href="#">한도 변경 승인 거절 </a>
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
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>예금 상품</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="#">등록</a>
                        <a class="collapse-item" href="#">삭제</a>
                        <a class="collapse-item" href="#">조회</a>
                        <a class="collapse-item" href="#">수정</a>
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
                        <h6 class="collapse-header">대출상품</h6>
                        <a class="collapse-item" href="#">등록</a>
                        <a class="collapse-item" href="#">삭제</a>
                        <a class="collapse-item" href="#">조회</a>
                        <a class="collapse-item" href="#">수정</a>
                    </div>
                </div>
              </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>회원 대출 내역 조회</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>결산</span>
                </a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                 적금
            </div>
              <li class="nav-item">
               	<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse1"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>적금 상품</span>
                </a>
               <div id="collapse1" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">적금상품</h6>
                        <a class="collapse-item" href="#">등록</a>
                        <a class="collapse-item" href="#">삭제</a>
                        <a class="collapse-item" href="#">조회</a>
                        <a class="collapse-item" href="#">수정</a>
                    </div>
                </div>
                </li>
            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
               펀드
            </div>
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse2"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>펀드승인리스트</span>
                </a>
                 <div id="collapse2" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">펀드</h6>
                        <a class="collapse-item" href="#">승인거절</a>
                        <a class="collapse-item" href="#">펀드내용 보기</a>
                    </div>
                </div>
             </li>
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
                        <h6 class="collapse-header">공지사항</h6>
                        <a class="collapse-item" href="#">글 등록</a>
                        <a class="collapse-item" href="#">글 삭제</a>
                        <a class="collapse-item" href="#">글 수정</a>
                        <a class="collapse-item" href="#">글 조회</a>
                    </div>
                </div>
             </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>채팅 상담</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>고객 상담</span>
                </a>
            </li>
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#bootstrap"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>BootStrap íì¸ íì´ì§</span>
                </a>
                <div id="bootstrap" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Login Screens:</h6>
                        <a class="collapse-item" href="${path}/bootstrap.do?key=1">Login</a>
                        <a class="collapse-item" href="${path}/bootstrap.do?key=2">Register</a>
                        <a class="collapse-item" href="${path}/bootstrap.do?key=3">Forgot Password</a>
                        <div class="collapse-divider"></div>
                        <h6 class="collapse-header">Other Pages:</h6>
                        <a class="collapse-item" href="${path}/bootstrap.do?key=4">404 Page</a>
                        <a class="collapse-item" href="${path}/boostrap.do?key=5">Blank Page</a>
                        <h6 class="collapse-driver"> others:</h6>
                        <a class="collapse-item" href="${path}/bootstrap.do?key=6">chart Page</a>
                         <a class="collapse-item" href="${path}/bootstrap.do?key=7">cards</a>
                         <a class="collapse-item" href="${path}/bootstrap.do?key=8">tables</a>
                    </div>
                </div>
            </li>         

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->
            <div class="sidebar-card d-none d-lg-flex">
                <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">
                <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
            </div>

        </ul>
        <!-- End of Sidebar -->