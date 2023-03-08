<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>KOSMO_BANK</title>

    <!-- Custom fonts for this template-->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script> <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@0.7.0"></script>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
	 <!-- Page level plugins -->
<%--     <script src="${path }/resources/vendor/chart.js/Chart.min.js" defer></script> --%>
    <!-- Custom styles for this template-->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top" style="color:black">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>
    	
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
			<%@ include file ="/WEB-INF/views/common/sub_menu_admin.jsp" %>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <!-- Content Row -->
                    	<!-- Pie Chart -->
                    	 <div class="row">
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <!-- '#4e73df', '#1cc88a', '#36b9cc' -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">상품별 가입자 비율</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> 예금
                                        </span>
                                         <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> 적금
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-info"></i> 대출
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Area Chart -->
                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">월별 예적금 수익금 </h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area" style="position: relative; height:300px;">
                                        <canvas id="deposit" style="height:350px;"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 대출 -->
                        <div class="col-xl-4 col-lg-6">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">대출 상품 신청 비율 </h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="loans-chart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">대출 상품별 수익금</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="loansChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 펀드 -->
                     <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary"> 펀드 후원  수익금</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="fundChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-4 col-lg-6">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">펀드 상품 신청 비율 </h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="cPieChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
           <%--               <div class="col-xl-4 col-lg-6">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary"> 대출 바 차트 </h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myBarChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div> --%>
                 </div>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Chart script -->
     <script type="text/javascript">
    Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
    Chart.defaults.global.defaultFontColor = '#858796';
 	    var ctx = document.getElementById("myPieChart");
 	    var myPieChart = new Chart(ctx, {
 	      type: 'pie',
 	      data: {
 	        labels: ["예금", "적금","대출"],
 	        datasets: [{
 	          type: 'pie',
 	          data: ['${dto.depositCnt}', '${dto.savingCnt}', '${dto.laonsCnt}'],
 	          backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
 	          hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
 	          hoverBorderColor: "rgba(234, 236, 244, 1)",
 	        }],
 	      },
 	      options: {
 	        maintainAspectRatio: false,
 	        tooltips: {
 	          backgroundColor: "rgb(255,255,255)",
 	          bodyFontColor: "#858796",
 	          borderColor: '#dddfeb',
 	          borderWidth: 1,
 	          xPadding: 15,
 	          yPadding: 15,
 	          displayColors: false,
 	          caretPadding: 10,
 	        },
 	        legend: {
 	          display: false
 	        },
 	        cutoutPercentage: 80,
 	      },
 	    });
 	    
// chart2 : 예/적금
 	  var ctx = document.getElementById('deposit').getContext('2d');  // 1
 	  var deposit = '${deposit}'
 	  console.log(deposit)
 	  // 예금 금액 저장
 	  var depositArray = new Array();
 	  // 날짜 저장
 	  var timeArray = new Array();
 	  // 적금 금액 저장
 	  var savingArray = new Array();
 	  // 예금- json
		var deposit = ${deposit} ;
		for( var i = 0; i < deposit.length; i++){
			console.log(deposit[i].depoistBalance)
			console.log(deposit[i].yymm)
			depositArray.push(deposit[i].depoistBalance);
			timeArray.push(deposit[i].yymm);
		}
		console.log(timeArray)
		console.log(depositArray)
	// 적금 -json
	var saving = ${saving};
	for(var i =0; i<saving.length; i++ ){
		savingArray.push(saving[i].savingBalance);
	}
	console.log(savingArray)
 	  var myChart = new Chart(ctx, {
 	      type: 'bar',
 	      data: {
 	    	  
 	          labels: timeArray, // 2
 	          datasets: [{
 	              label: '예금', // 3
 	              data: depositArray, // 4
 	              backgroundColor: [  // 5
 	                  '#E2C391','#035E7B'
 	              ],
 	              borderColor: [
 	                  '#E2C391','#9BBEC7'
 	              ],
 	              borderWidth: 1
 	          },
 	         {
 	        	  type: 'bar',
 	              label: '적금', // 3
 	              data: savingArray, // 4
 	              backgroundColor: [  // 5
 	                  '#E2C391','#035E7B'
 	              ],
 	              borderColor: [
 	                  '#E2C391','#035E7B'
 	              ],
 	              borderWidth: 1
 	          }
 	          ]
 	      },
 	     options: {
  	        maintainAspectRatio: false,
  	        tooltips: {
  	          backgroundColor: "rgb(255,255,255)",
  	          bodyFontColor: "#858796",
  	          borderColor: '#dddfeb',
  	          borderWidth: 1,
  	          xPadding: 15,
  	          yPadding: 15,
  	          displayColors: false,
  	          caretPadding: 10,
  	        },
  	        legend: {
  	          display: false
  	        },
  	        cutoutPercentage: 80,
  	      },
 	  });
//char3 대출 차트

var loansTotal = ${loan_total}
// 대출 상품 목로
var loansItemList = []
for( var i = 0; i<loansTotal.length; i++ ){
	loansItemList.push(loansTotal[i].d_name)
}
// 대출 신청 횟수
var loansNumber = []
for( var i = 0; i<loansTotal.length; i++ ){
	loansNumber.push(loansTotal[i].total)
}



// chart3. 상품별 등록 비율
new Chart(document.getElementById("loans-chart"), {
    type: 'pie',
    data: {
      labels: loansItemList,
      datasets: [{
        label: "Population (millions)",
        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
        data: loansNumber
      }]
    },
    options: {
        maintainAspectRatio: false,
        tooltips: {
          backgroundColor: "rgb(255,255,255)",
          bodyFontColor: "#858796",
          borderColor: '#dddfeb',
          borderWidth: 1,
          xPadding: 15,
          yPadding: 15,
          displayColors: false,
          caretPadding: 10,
        },
        legend: {
          display: false
        },
        cutoutPercentage: 80,
 	},
});


 // 대출-json
var loansData = ${loans}
console.log('대출 : '+loansData)
let reloansData = loansData.filter((val, idx) => loansData.indexOf(val) === idx );
console.log(reloansData);
 // 대출 데이터 넣기
var loansDataArray = []
var colors = ['yellow','red','black','blue'];
for( var i = 1; i< loansData.length; i++){
	colornum = 0;
	 loansDataes = 
	  	{
		      type: 'line',
		      label: '',
		      lineTension: 0.3,
		      backgroundColor: "rgba(78, 115, 223, 0.05)",
		      borderColor: "rgba(78, 115, 223, 1)",
		      pointRadius: 3,
		      pointBackgroundColor: "rgba(78, 115, 223, 1)",
		      pointBorderColor: "rgba(78, 115, 223, 1)",
		      pointHoverRadius: 3,
		      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
		      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
		      pointHitRadius: 10,
		      pointBorderWidth: 2,
		      data: '',
		    }
	 loansDataes.label = loansData[i].d_name;
	 loansDataes.data = [loansData[i].Jan,loansData[i].Feb,loansData[i].Mar,loansData[i].Apr,loansData[i].May,loansData[i].Jun,loansData[i].Jul,loansData[i].Aug,loansData[i].Sep,loansData[i].Oct,loansData[i].Nov,loansData[i].Dec];
	 loansDataes.borderColor = 'black';
     loansDataes.pointBorderColor = 'black';
	 loansDataArray.push(loansDataes);
	 colornum++;
	 if( colornum >= 3){
		 colornum = 0;
	 }
}
 // 대출
 	var ctx = document.getElementById("loansChart");
 	var myLineChart = new Chart(ctx, {
		  type: 'line',
	 	  data: {
	 		labels: ['2022-01','2022-02','2022-03','2022-04','2022-05','2022-06','2022-07','2022-08','2022-09','2022-10','2022-11','2022-12'],
	 	    datasets: loansDataArray
 	  },
 	  options: {
 	    maintainAspectRatio: false,
 	    layout: {
 	      padding: {
 	        left: 10,
 	        right: 25,
 	        top: 25,
 	        bottom: 0
 	      }
 	    },
 	    scales: {
 	      xAxes: [{
 	        time: {
 	          unit: 'date'
 	        },
 	        gridLines: {
 	          display: false,
 	          drawBorder: false
 	        },
 	        ticks: {
 	          maxTicksLimit: 7
 	        }
 	      }],
 	      yAxes: [{
 	        ticks: {
 	          maxTicksLimit: 5,
 	          padding: 10,
 	          // Include a dollar sign in the ticks
 	          callback: function(value, index, values) {
 	            return '$' + number_format(value);
 	          }
 	        },
 	        gridLines: {
 	          color: "rgb(234, 236, 244)",
 	          zeroLineColor: "rgb(234, 236, 244)",
 	          drawBorder: false,
 	          borderDash: [2],
 	          zeroLineBorderDash: [2]
 	        }
 	      }],
 	    },
 	    legend: {
 	      display: false
 	    },
 	    tooltips: {
 	      backgroundColor: "rgb(255,255,255)",
 	      bodyFontColor: "#858796",
 	      titleMarginBottom: 10,
 	      titleFontColor: '#6e707e',
 	      titleFontSize: 14,
 	      borderColor: '#dddfeb',
 	      borderWidth: 1,
 	      xPadding: 15,
 	      yPadding: 15,
 	      displayColors: false,
 	      intersect: false,
 	      mode: 'index',
 	      caretPadding: 10,
 	      callbacks: {
	 	        label: function(tooltipItem, chart) {
	 	          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
	 	          return datasetLabel +' : '+number_format(tooltipItem.yLabel);
	 	        }
 	 	   }
 	    }
 	  }
 	});
 
 // chart4 펀드
var fund = ${fund}
var colors = ['#EE8434','#C95D63','#AE8799','#AE8799','#496DDB'];
var fundArray = new Array();

// FUND 데이터 추출
var color = 0;
for( var i = 1; i < fund.length; i ++){
	if( color > 4){
		color  = 0;
	}
	fundData = {
		      label: fund[i].f_name,
		      lineTension: 0.3,
		      backgroundColor: "rgba(78, 115, 223, 0.05)",
		      borderColor: "rgba(78, 115, 223, 1)",
		      pointRadius: 3,
		      pointBackgroundColor: "rgba(78, 115, 223, 1)",
		      pointBorderColor: "rgba(78, 115, 223, 1)",
		      pointHoverRadius: 3,
		      pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
		      pointHoverBorderColor: "rgba(78, 115, 223, 1)",
		      pointHitRadius: 10,
		      pointBorderWidth: 2,
		      data: [fund[i].Jan,fund[i].Feb,fund[i].Mar,fund[i].Apr,fund[i].May,fund[i].Jun,fund[i].Jul,fund[i].Aug,fund[i].Sep,fund[i].Oct,fund[i].Nov,fund[i].Dec ]
	  }
	fundData.label = fund[i].f_name;
	fundData.pointBorderColor = colors[color]
	fundData.borderColor = colors[color]
	fundArray.push(fundData)
	color++;
}
// 5. fund_chart
var ctx = document.getElementById("fundChart");
var myLineChart = new Chart(ctx, {
 	  type: 'line',
 	  data: {
	 	labels: ['2022-01','2022-02','2022-03','2022-04','2022-05','2022-06','2022-07','2022-08','2022-09','2022-10','2022-11','2022-12'],
 	    datasets: fundArray,
 	    
 	  },
 	  options: {
 	    maintainAspectRatio: false,
 	    layout: {
 	      padding: {
 	        left: 10,
 	        right: 25,
 	        top: 25,
 	        bottom: 0
 	      }
 	    },
 	    scales: {
 	      xAxes: [{
 	        time: {
 	          unit: 'date'
 	        },
 	        gridLines: {
 	          display: false,
 	          drawBorder: false
 	        },
 	        ticks: {
 	          maxTicksLimit: 7
 	        }
 	      }],
 	      yAxes: [{
 	        ticks: {
 	          maxTicksLimit: 5,
 	          padding: 10,
 	          // Include a dollar sign in the ticks
 	          callback: function(value, index, values) {
 	            return '$' + number_format(value);
 	          }
 	        },
 	        gridLines: {
 	          color: "rgb(234, 236, 244)",
 	          zeroLineColor: "rgb(234, 236, 244)",
 	          drawBorder: false,
 	          borderDash: [2],
 	          zeroLineBorderDash: [2]
 	        }
 	      }],
 	    },
 	    legend: {
 	      display: false
 	    },
 	    tooltips: {
 	      backgroundColor: "rgb(255,255,255)",
 	      bodyFontColor: "#858796",
 	      titleMarginBottom: 10,
 	      titleFontColor: '#6e707e',
 	      titleFontSize: 14,
 	      borderColor: '#dddfeb',
 	      borderWidth: 1,
 	      xPadding: 15,
 	      yPadding: 15,
 	      displayColors: false,
 	      intersect: false,
 	      mode: 'index',
 	      caretPadding: 10,
 	      callbacks: {
 	        label: function(tooltipItem, chart) {
 	          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
 	          return datasetLabel +' : '+number_format(tooltipItem.yLabel);
 	        }
 	      }
 	    }
 	  }
 	});
// 6. 펀드 상품 비율
var PieChart_ctx = document.getElementById('cPieChart').getContext('2d');
// fund 전체 값 total
var fundTotal = ${fund_total}
// 펀드 상품 목록
var funditemlist = []
// 펀드 신청 횟수
var fundaccount = []
for( var i = 0; i < fundTotal.length; i++){
	funditemlist.push(fundTotal[i].f_name);
}
console.log(funditemlist)
// 펀드 상품 신청 횟수
for( var i = 0; i < fundTotal.length; i++){
	fundaccount.push(fundTotal[i].total);
}
new Chart(PieChart_ctx, {
    type: 'pie',
    data: {
      labels: funditemlist,
      datasets: [{
        label: "Population (millions)",
        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
        data: fundaccount
      }]
    },
    options: {
	        maintainAspectRatio: false,
	        tooltips: {
	          backgroundColor: "rgb(255,255,255)",
	          bodyFontColor: "#858796",
	          borderColor: '#dddfeb',
	          borderWidth: 1,
	          xPadding: 15,
	          yPadding: 15,
	          displayColors: false,
	          caretPadding: 10,
	        },
	        legend: {
	          display: false
	        },
	        cutoutPercentage: 80,
	 },
});
var loansbar = ${loansbar}

var loansbarArray = []
//Bar Chart Example
for( var i = 1; i< loansbar.length; i++){
	colornum = 0;
	 barDataes = {
		 label: "Revenue",
		    backgroundColor: "#4e73df",
		    hoverBackgroundColor: "#2e59d9",
		    borderColor: "#4e73df",
		    data: []
		  }
	 barDataes.label = loansbar[i].d_name;
	 barDataes.data = [loansbar[i].Jan,loansbar[i].Feb,loansbar[i].Mar,loansbar[i].Apr,loansbar[i].May,loansbar[i].Jun,loansbar[i].Jul,loansbar[i].Aug,loansbar[i].Sep,loansbar[i].Oct,loansbar[i].Nov,loansbar[i].Dec];
	 barDataes.borderColor = 'black';
	 barDataes.pointBorderColor = 'black';
	 loansbarArray.push(barDataes);
	 colornum++;
	 if( colornum >= 3){
		 colornum = 0;
	 }
}


var ctx = document.getElementById("myBarChart");
var myBarChart = new Chart(ctx, {
  type: 'bar',
  data: {
	labels: ['2022-01','2022-02','2022-03','2022-04','2022-05','2022-06','2022-07','2022-08','2022-09','2022-10','2022-11','2022-12'],
    datasets: loansbarArray,
  },
  options: {
    maintainAspectRatio: false,
    layout: {
      padding: {
        left: 10,
        right: 25,
        top: 25,
        bottom: 0
      }
    },
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false,
          drawBorder: false
        },
        ticks: {
          maxTicksLimit: 6
        },
        maxBarThickness: 25,
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5,
          padding: 10,
          // Include a dollar sign in the ticks
          callback: function(value, index, values) {
            return '$' + number_format(value);
          }
        },
        gridLines: {
          color: "rgb(234, 236, 244)",
          zeroLineColor: "rgb(234, 236, 244)",
          drawBorder: false,
          borderDash: [2],
          zeroLineBorderDash: [2]
        }
      }],
    },
    legend: {
      display: false
    },
    tooltips: {
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
      callbacks: {
        label: function(tooltipItem, chart) {
          var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
          return datasetLabel + ': ' + number_format(tooltipItem.yLabel)+'원';
        }
      }
    },
  }
});

 	</script>
</body>
</html>