<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    
    <style>
        /* Basic Reset and Styling */
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
        }

        .navbar {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
            font-size: 24px;
        }

        .container {
            display: flex;
        }

        .sidebar {
            width: 200px;
            background-color: #444;
            color: #fff;
            padding: 15px;
            height: 100vh;
            position: sticky;
            top: 0;
        }

        .sidebar ul {
            list-style-type: none;
        }

        .sidebar li {
            margin: 15px 0;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            display: block;
            padding: 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .sidebar a:hover {
            background-color: #555;
        }

        .main-content {
            flex-grow: 1;
            padding: 20px;
            background-color: #fff;
            min-height: 100vh;
        }

        .dashboard-cards {
            display: flex;
            gap: 20px;
            margin-bottom: 30px;
        }

        .card {
            flex: 1;
            padding: 20px;
            border-radius: 10px;
            color: #fff;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        /* Different colors for each card */
        .restaurants-card {
            background-color: #28a745;
        }
        
        .menus-card {
            background-color: #17a2b8;
        }
        
        .orders-card {
            background-color: #ffc107;
        }
        
        .users-card {
            background-color: #dc3545;
        }

    </style>
</head>
<body>
    <nav class="navbar">
        Admin Dashboard
    </nav>

    <div class="container">
        <!-- Sidebar with updated links -->
        <aside class="sidebar">
            <ul>
                <li><a href="GetRestaurant?source=admin">View Restaurants</a></li>
                <li><a href="viewOrders.jsp">View Orders</a></li>
                <li><a href="viewUsers.jsp">View Users</a></li>
                <li><a href="Logout">Logout</a></li>
            </ul>
        </aside>

        <main class="main-content">
            <!-- Dashboard cards with placeholder data -->
            <section class="dashboard-cards">
                <div class="card restaurants-card">
                    Total Restaurants
                    <div>12</div>
                </div>
                <div class="card menus-card">
                    Total Menus
                    <div>35</div>
                </div>
                <div class="card orders-card">
                    Total Orders
                    <div>150</div>
                </div>
                <div class="card users-card">
                    Total Users
                    <div>45</div>
                </div>
            </section>

            <!-- Optional: Additional welcome or summary content -->
            <section>
                <h3>Welcome to the Admin Dashboard</h3>
                <p>Click on any option in the sidebar to manage the corresponding section.</p>
            </section>
        </main>
    </div>
</body>
</html>
