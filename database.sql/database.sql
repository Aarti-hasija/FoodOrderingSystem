CREATE DATABASE FoodOrderingSystem;
use foodOrderingSystem;
CREATE TABLE Customers (customer_id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), email VARCHAR(100), phone VARCHAR(15));
CREATE TABLE Restaurants (restaurant_id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), location VARCHAR(100));
CREATE TABLE Categories (category_id INT PRIMARY KEY AUTO_INCREMENT, category_name VARCHAR(50));
CREATE TABLE Menu_Items (item_id INT PRIMARY KEY AUTO_INCREMENT,
 restaurant_id INT, category_id INT, name VARCHAR(100), price DECIMAL(10,2), FOREIGN KEY (restaurant_id)
 REFERENCES Restaurants(restaurant_id), FOREIGN KEY (category_id) REFERENCES Categories(category_id));
CREATE TABLE Riders (rider_id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), phone VARCHAR(15));
CREATE TABLE Orders (order_id INT PRIMARY KEY AUTO_INCREMENT, customer_id INT, restaurant_id INT, order_date DATETIME, 
total_amount DECIMAL(10,2), FOREIGN KEY (customer_id) REFERENCES Customers(customer_id), FOREIGN KEY (restaurant_id)
 REFERENCES Restaurants(restaurant_id));
CREATE TABLE Order_Items (order_item_id INT PRIMARY KEY AUTO_INCREMENT, order_id INT, item_id INT, quantity INT,
 FOREIGN KEY (order_id) REFERENCES Orders(order_id), FOREIGN KEY (item_id) REFERENCES Menu_Items(item_id));
CREATE TABLE Payments (payment_id INT PRIMARY KEY AUTO_INCREMENT, order_id INT, amount DECIMAL(10,2), payment_status VARCHAR(20), 
FOREIGN KEY (order_id) REFERENCES Orders(order_id));
CREATE TABLE Delivery (delivery_id INT PRIMARY KEY AUTO_INCREMENT, order_id INT, rider_id INT, delivery_status VARCHAR(20), 
FOREIGN KEY (order_id) REFERENCES Orders(order_id), FOREIGN KEY (rider_id) REFERENCES Riders(rider_id));
CREATE TABLE Reviews (review_id INT PRIMARY KEY AUTO_INCREMENT, customer_id INT, restaurant_id INT, rating INT, comment TEXT,
 FOREIGN KEY (customer_id) REFERENCES Customers(customer_id), FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id));
ALTER TABLE Customers ADD address VARCHAR(255);
