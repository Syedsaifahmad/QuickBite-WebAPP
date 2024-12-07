<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.foodapp.model.pojo.CartItem"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Cart Items</title>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOMyPZ+XzMfdw3iFF1s5mDPCsP5xyiufuhNEWHKZ"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
@import url('https://fonts.googleapis.com/css2?family=Protest+Revolution&display=swap');

#logo {
    font-family: "Protest Revolution", sans-serif;
    font-weight: 400;
    font-style: normal;
}
.navbar {
	position: sticky;
	top: 0;
	z-index: 1000; /* Ensures it stays on top of other content */
}
.cart-table th, .cart-table td {
	text-align: center;
	vertical-align: middle;
}

.cart-table th {
	background-color: #f8f9fa;
}

.cart-table td {
	background-color: #e9ecef;
}
</style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="home.jsp">
            <h1 id="logo">QUICKBITE</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
            <div class="d-flex">
                <a href="cartItem.jsp" class="btn btn-outline-danger active me-2">Cart</a>
                <a href="profile.jsp" class="btn btn-outline-success">Profile</a>
            </div>
    </div>
</nav>
	<!-- Cart Content -->
	<div class="container my-4">
		<%
		Map<Integer, CartItem> cartMap = (Map<Integer, CartItem>) session.getAttribute("cart");
		double totalPrice = 0.0;
		if (cartMap != null && !cartMap.isEmpty()) {
		%>
		<form method="POST" action="UpdateCart">
			<table class="table table-bordered cart-table">
				<thead>
					<tr>
						<th>Restaurant Name</th>
						<th>Item Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (CartItem c : cartMap.values()) {
						double itemTotal = c.getPrice() * c.getQuantity();
						totalPrice += itemTotal;
					%>
					<tr>
						<td><%=c.getRestaurantId()%></td>
						<td><%=c.getName()%></td>
						<td>₹ <%=c.getPrice()%></td>
						<td>
							<form method="POST" action="UpdateCart" style="display: inline;">
								<!-- Decrement Button -->
								<input type="hidden" name="itemId" value="<%=c.getItemId()%>">
								<input type="hidden" name="quantity"
									value="<%=c.getQuantity() - 1%>">
								<button type="submit" class="btn btn-outline-secondary btn-sm"
									<%=c.getQuantity() == 1 ? "disabled" : ""%>>-</button>
							</form> <span><%=c.getQuantity()%></span>

							<form method="POST" action="UpdateCart" style="display: inline;">
								<!-- Increment Button -->
								<input type="hidden" name="itemId" value="<%=c.getItemId()%>">
								<input type="hidden" name="quantity"
									value="<%=c.getQuantity() + 1%>">
								<button type="submit" class="btn btn-outline-secondary btn-sm">+</button>
							</form>
						</td>
						<td>₹ <%=itemTotal%></td>
						<td><a href="removeItem?itemId=<%=c.getItemId()%>"
							class="btn btn-danger btn-sm">Remove</a></td>
					</tr>
					<%
							}
							%>
				</tbody>
			</table>
		</form>
		<%
		} else {
		%>
		<p class="text-center">No items in cart</p>
		<%
		}
		%>

		<!-- Total Price Section -->
		<form method="POST" action="confirmOrder.jsp">
			<div class="cart-total text-center my-4">
				<h4>
					Total: ₹ <span id="total-price"><%=totalPrice%></span>
				</h4>
				<!-- Hidden input to pass the total price -->
				<input type="hidden" name="totalPrice" value="<%=totalPrice%>">
				<button type="submit" class="btn btn-success mt-3">Place
					Order</button>
			</div>
		</form>


	</div>
</body>
</html>
