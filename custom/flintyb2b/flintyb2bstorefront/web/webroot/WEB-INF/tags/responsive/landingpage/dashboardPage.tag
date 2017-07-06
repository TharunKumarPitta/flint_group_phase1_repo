<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="hideHeaderLinks" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/responsive/common/footer"  %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav"%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script>
  <script type="text/javascript" src="C:/Users/User/Desktop/Flint/canvasjs-1.9.8.1/canvasjs.min.js"></script>
<style>
table th {
    font-weight: 600;
    background-color: #fff;
    }
    .table > thead > tr > th {
    text-align: left;
	}
	a.canvasjs-chart-credit {
    display: none;
	}
.tab-head-history{
	color: white;
	background-color: gray;
	padding: 10px 5px 10px 8px;
}
.table{
	background-color: white;
}
body{
	background-color: #DCDCDC;
}

.order-pro{
	background-color: white;
	height:50px;
	overflow:hidden;
}
.tab-head-history h6{
	margin:0px;

}
@media screen and (max-width: 768px) {
	.order-history-part{
		width: 100%;
	}
	.main-order{
		padding: 0px;
	}
.image-part {
    margin-top: 6px;
}
.chartContainer{
	height: 250px;
}
}
.quick{
	border-right: 1px solid black;
	line-height: 20px;
}
h3.wel-come{
	font-weight: 600;
    font-size: 30px;
    color: #666666;
}
.image-part{
	padding: 0px;
	margin-top: -9px;
}
.order-manage-part{
	margin-top: -2px;
	padding: 0px;
}
.wel-com{
	float:left;
}
.img-icon{
	float:right;
}
.welcome-part{
	height: 80px;
}
span.icon-font-order {
    font-size: 15px;
}
tr.table-cont > td{
	font-size: 12px;
	color: #666666;
}
tr.table-cont > td.status-col{
	color: #008000;
}
.wel-content-mark{
	padding-bottom: 10px;
	padding-top: 40px;
}
.img-head-top{
	padding-top: 10px;
}
th.tab-font{
	padding: 25px 0px 10px 10px;
}
.table-header-history{
	color: #ffffff;
	font-size: 14px;
}
.text-img-flint{
	text-align: center;
	top:20%;
	left:14%;
	z-index: 1;
	position: absolute;
	color: #ffffff;
}
.flint-gp{
	font-size: 30px;
}
.flint-gic{
	font-size: 13px;
}
.bar-height{
	min-height: 220px;
}
.wel-come-mark {
	margin-top: 1.2%;
    color: #666666;
    font-weight: bold;
    font-size: 24px;
}
tr.tab-font > th{
	font-size: 14px;
    font-weight: bold;
    color: #666666;
    �font-family:�Roboto�Condensed,�sans-serif; 
}
.text-img-flint{
		left: 15%;
	}
}
.img-head-top > img{
	width: 20%;
}
a.ancor-ref{
	color: black;
}
a:hover { 
    color: black;
    text-decoration: none;
}
td.table-link > a {
    color: red;
    font-size: 14px;
}
tr.tab-font > th.head-center{
	text-align: center;
}

tr.table-cont > td.txt-cnt{
	text-align: center;
}
@media screen and (max-width: 480px) {
.image-part > img{
	width: 320px;
	}
.cust-img{
	width: 22%;
}
.wel-come-mark{
	font-size: 15px;
}
.img-head-top{
	padding: 0px;
}
.wel-content-mark{
	padding: 8px;
}
.main-order{
	padding: 0px;
}
.text-img-flint{
	left:18%;
	top:70%;
}
.chartContainer{
	width: 100%;
}
.image-part > img {
    width: 414px;
    padding-left: 7px;
}
</style>
	 <div class="container-fluid main-order">
      <div class="col-md-12 col-sm-12 col-xs-12 wel-content-mark">
          <div class="wel-come-mark col-md-4 col-sm-6 col-xs-4"> <spring:theme code="header.welcome" arguments="${user.firstName},${user.lastName}" htmlEscape="true" /></div>
            <div class="col-md-2 col-sm-3 col-xs-4 img-head-top">
              <img class="cust-img" src="${commonResourcePath}/images/dashboard-icon1.png">
                <span class="icon-font-order"><a class="ancor-ref" href="quickOrder"><spring:theme code="quick.order"/></a></span>
            </div>
            <div class="col-md-3 col-sm-3 col-xs-4 img-head-top">
              <img class="cust-img" src="${commonResourcePath}/images/dashboard-icon2.png">
                <span class="icon-font-order"><a class="ancor-ref" href="Product-Catalog/c/flintCategory"><spring:theme code="product.catalog"/></a></span>
            </div>
      </div>
      <div class="main-order col-lg-8 col-sm-8 col-xs-12">
        <div class="col-sm-12 hidden-xs main-order">
<!--           <div id="chartContainer" style="height: 300px;width: 100%;"></div> -->
        </div> 

        <div class="col-sm-12 order-manage-part">
            <div class="col-sm-6 order-history-part">
              <div class="tab-head-history col-sm-12">
                <div class="table-header-history"><spring:theme code="recent.order.history"/></div>
              </div>
              <table class="table">
                <thead>
                  <tr class="tab-font">
                    <th><spring:theme code="order.date"/></th>
                    <th><spring:theme code="order.number"/></th>
                    <th><spring:theme code="status"/></th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${orderList}" var="orderList" varStatus="orderCounter">
    						<c:if test="${orderCounter.count < 6}">
      						<tr class="table-cont">
      						<%-- <c:set var="date" value="${orderList.placed}"></c:set> --%>
        						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${orderList.placed}" /></td>
        						<td>${orderList.code}</td>
        						<td style="text-transform: uppercase">${orderList.statusDisplay}</td>
      						</tr>
      						</c:if>
      						</c:forEach>

                  <tr>
                  <td class="table-link" style="border-top-style: none;"></td>
                  <td class="table-link" style="border-top-style: none;"></td>
                  <td class="table-link" style="border-top-style: none;"><a href="my-account/orders"><spring:theme code="all.order.history"/></a></td></tr>
                </tbody>
              </table>
            </div>
            <div class="col-sm-6 order-history-part">
              <div class="tab-head-history col-sm-12">
              <div class="table-header-history"><spring:theme code="recent.support.tickets"/></div>
            </div>
              <table class="table">
                <thead>
                <tr class="tab-font">
                    <th><spring:theme code="ticket.id"/></th>
                    <th><spring:theme code="subject"/></th>
                    <th><spring:theme code="status"/></th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ticketList}" var="ticketList" varStatus="ticketCounter">
    			<c:if test="${ticketCounter.count < 6}">
                  <tr class="table-cont">
                    <td>${ticketList.id}</td>
                    <td>${ticketList.subject}</td>
                    <td>${ticketList.status.id}</td>              
      			 </tr>
      			 </c:if>
      			 </c:forEach>
                  <!-- <tr class="table-cont">
                    <td>0000001</td>
                    <td>Query on Product Price</td>
                    <td class="status-col">open</td>
                  </tr> -->
                 
                  <tr class="table-cont">
                  <td class="table-link" style="border-top-style: none;"></td>
                  <td class="table-link" style="border-top-style: none;"></td>
                  <td class="table-link" style="border-top-style: none;"><a href="my-account/support-tickets"><spring:theme code="all.support.tickets"/></a></td></tr>
                </tbody>
              </table>

            </div>
          </div>
        </div>
        
      
      <div class="col-sm-4 col-xs-4 image-part">
        <div class="text-img-flint">

       <!--    <cms:pageSlot position="Section1A" var="feature">
         <cms:component component="${feature}" /> -->
	
     </cms:pageSlot>
        </div> 
		<a href="http://www.flintgrp.com/en/company/sustainability-log-in/" target="_blank"> 
        <cms:pageSlot position="Section1" var="feature">
       		 
         <cms:component component="${feature}" /> 
       	   </a> 
     </cms:pageSlot>
      </div>
  </div>
	<script>
window.onload = function () {
    CanvasJS.addColorSet("greenShades",
                [//colorSet Array

                "#ff3333",
                                
                ]);
    var chart = new CanvasJS.Chart("chartContainer",
    {
                  colorSet: "greenShades",
       title: {
       text: "Statistics on Orders placed in the last six month",
       fontWeight: "bold",
       fontSize: 13,
      },
      axisY:{
        title: "Total Amount",
        alueFormatString: " ",
        tickLength: 0,
        titleFontSize: 13,
        titleFontWeight: "bold",
        gridThickness: 0,
        lineThickness: 0,
      },
      axisX:{

        lineThickness: 0,
        tickLength: 0,
        labelFontSize:12,
        labelFontColor: "#333333",
        labelFontFamily: "Roboto",
        labelFontWeight: "regular",



      },
      dataPointMaxWidth: 35,
    
      data: [
      {
        type: "column",
        indexLabel: "{y}",
        indexLabelPlacement: "outside",  
        indexLabelOrientation: "horizontal",
        dataPoints: [

        { y: 120000, label:  "Jan" },
        { y: 100000, label: "Feb" },
        { y: 178999, label: "Mar"},
        { y: 154000, label: "Apr" },
        { y: 340000, label: "May"},
        { y: 250000, label: "Jun"}
      
        ]
      }
      ]
    });

    chart.render();
  }
	</script>
	