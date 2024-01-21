<%@page import="com.example.demo.bean.Register"%>
<%@page import="com.example.demo.bean.booking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Font Awesome Link -->
<%Register reg=(Register)session.getAttribute("user");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
		.popup {
			position: fixed;
			z-index: 1;
			left: 0;
			top: 0;
			width: 100%;
			height: 100%;
			overflow: auto;
			background-color: rgba(0, 0, 0, 0.4);
			display: none;
		}
		.popup-content {
			background-color: white;
			margin: 10% auto;
			padding: 20px;
			border: 1px solid #888888;
			width: 30%;
			font-weight: bolder;
		}
		.popup-content button {
			display: block;
			margin: 0 auto;
		}
		.show {
			display: block;
		}
		h1 {
			color: green;
		}
	</style>
</head>
<body>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/check.css">


<div class="modal clearfix">
    <div class="modal-product">
      <div class="product">
<%booking b=(booking)session.getAttribute("book"); %>
        <!-- Slideshow container -->
        <div class="product-slideshow">

          <!-- Full-width images with number and caption text -->
          <div>
          	<img style="height: 347px;width: 295px;margin-top: 16px;margin-left: 9px;margin-bottom: 16px;" src="<%=b.getImage()%>">
          </div>

          

          <br>

          <!-- The dots/circles -->
          <div style="text-align:center">
            
          </div>

        </div>

        <h1 class="product-name">
          <%=b.getDestination() %>
        </h1>
       
        <p class="product-price">
          <%=b.getPrice() %>
        </p>

      </div>

      <div class="round-shape"></div>
    </div>
    <div class="modal-info">
      <div class="info">
        <h2>Payment Information</h2>
        <form action="#">
          <ul class="form-list">
            <li class="form-list-row">
              <div class="user" style="margin-top: 25px;">
                <label for="#">Name</label><br>
                <i class="fas fa-user"></i></i><input type="text" required style="margin-left: 10px;">
              </div>
            </li>
            <li class="form-list-row">
              <div class="number" style="margin-top: 25px;">
                <label for="#">Card Number</label><br>
                <i class="far fa-credit-card"></i><input type="text" required style="margin-left: 10px;">
              </div>
            </li>
            <li class="form-list-row clearfix">
              <div class="date" style="margin-top: 25px;">
                <label for="#">Expiration Date</label><br>
                <input class="month" type="text" required placeholder="MM" style="margin-left: 10px;">
                <input class="year" type="text" required placeholder="YY" style="margin-left: 10px;">
              </div>
              <div class="cvc" style="margin-top: 25px;">
                <label for="#">CVC</label><i class="fas fa-question-circle"></i><br>
                <input type="text" required placeholder="123" style="margin-left: 10px;">
              </div>
            </li>
            <li class="form-list-row">
              <div class="checkbox" style="margin-top: 25px;">
                <label for="checkbox">
                  <input id="checkbox" type="checkbox" style="margin-left: 10px;">
                  <span>Remember My Information</span>
                </label>
              </div>
            </li>
          </ul>
          <button id="myButton"style="margin-top: 20px;height: 50px;width: 150px;"><a href="sendemail?email=<%=reg.getEmail()%>">Pay Now</a></button>
        </form>
      </div>
    </div>
  </div>
  <div id="myPopup" class="popup">
  <div class="popup-content">
   <svg style="margin-left: 119px;" id='icon-paid' xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" x="0px" y="0px" viewBox="0 0 310.277 310.277" style="enable-background:new 0 0 310.277 310.277;" xml:space="preserve" width="180px" height="180px">
  <g>	<path d="M155.139,0C69.598,0,0,69.598,0,155.139c0,85.547,69.598,155.139,155.139,155.139   c85.547,0,155.139-69.592,155.139-155.139C310.277,69.598,240.686,0,155.139,0z M144.177,196.567L90.571,142.96l8.437-8.437   l45.169,45.169l81.34-81.34l8.437,8.437L144.177,196.567z" fill="#3ac569"/>
  </g></svg>
    <h1 style="color:green;margin-left: 24px">
      Hello, <%=reg.getFirstname()%> Your tour Has been Booked
    </h1>
    <p style="margin-left: 15px">Please Check your email for details Thank you!</p>
    <button id="closePopup">
      Close
    </button>
  </div>
</div>
  <script>
		myButton.addEventListener("click", function () {
			myPopup.classList.add("show");
		});
		closePopup.addEventListener("click", function () {
			myPopup.classList.remove("show");
		});
		window.addEventListener("click", function (event) {
			if (event.target == myPopup) {
				myPopup.classList.remove("show");
			}
		});
	</script>
  <script src="assest/js/check.js"></script>
</body>
</html>