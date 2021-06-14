/*
 ************* Users *************
 */
INSERT INTO users(user_id,user_name,user_password) 
VALUES(1,'Sankalp','SSS');

INSERT INTO users(user_id,user_name,user_password) 
VALUES(2,'Apurva','AAA');

INSERT INTO users(user_id,user_name,user_password) 
VALUES(3,'Namrata','NNN');

INSERT INTO users(user_id,user_name,user_password) 
VALUES(4,'Rishabh','RRR');

INSERT INTO users(user_id,user_name,user_password) 
VALUES(5,'Sattya','SSS');

INSERT INTO users(user_id,user_name,user_password) 
VALUES(6,'Vijaya','VVV');

/*
 * ************* CUSTOMERS *************
 */
INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(11,'Malhar',9684151254,'malhar@gmail.com','Mumbai');

INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(12,'Meenakshi',8956445235,'meenakshi@gmail.com','Kota');

INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(13,'Milind',989689587,'milind@gmail.com','Mumbai');

INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(14,'Apurva',7569862451,'apurva@gmail.com','Ahmednagar');

INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(15,'Sanskar',8562664166,'sanskar@gmail.com','Aurangabad');

INSERT INTO customers(customer_id,customer_name,customer_mobile,customer_email,customer_address) 
VALUES(16,'Kalpesh',9586425312,'kalpesh@gmail.com','Mathura');

/*
 * ************* PIZZA ORDER *************
 */
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(101,'Home Delivery','Cash',0,0,0,'2021-08-12');
 
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(102,'Home Delivery','PhonePay',0,0,0,'2021-08-13');
 
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(103,'Home Delivery','NetBanking',0,0,0,'2021-08-14');
 
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(104,'Dine In','Credit Card',0,0,0,'2021-08-15');
 
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(105,'Dine In','Debit Card',0,0,0,'2021-08-16');
 
INSERT INTO pizzaorder(b_Id,order_type,t_Mode,t_cost,pizza_cost_After_Coupan,disc_cent,order_date) 
VALUES(106,'Dine In','Cash',0,0,0,'2021-08-17');

/*
 * ************* PIZZA  *************  
 */


INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(501,'Veg','Margherita','Classic delight with 100% real mozzarella cheese !','string',0,199);

INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(502,'Veg','Farmhouse','Delightful combination of onion, capsicum, tomato & grilled mushroom!','string',0,395);

INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(503,'Veg','Veg Extravaganza','Black olives, capsicum, onion, grilled mushroom, corn, tomato, jalapeno & extra cheese!','string',0,405);

INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(504,'Non-Veg','Moroccan Spice Pasta Pizza','A pizza loaded with a spicy combination of Harissa sauce, Peri Peri chicken chunks and delicious pasta!','string',0,335);

INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(505,'Non-Veg','Chicken Fiesta','Grilled chicken rashers, peri-peri chicken, onion & capsicum, a complete fiesta!','string',0,450);

INSERT INTO pizza(pizza_id,pizza_type,pizza_name,pizza_description,sz,ordered_quant,pizza_cost)
VALUES(506,'Non-Veg','Non Veg Supreme','Supreme combination of black olives, onion, capsicum, grilled mushroom, pepper barbecue chicken, peri-peri chicken & grilled chicken rashers!','string',0,570);

/*
 * ************* COUPON  ************* 
 */

INSERT INTO coupan(coupan_id,coupan_name,coupan_type,coupan_description) 
VALUES(1001,'ZOMSAFETY','Zomato','Get 10%off using Zomato');
 
INSERT INTO coupan(coupan_id,coupan_name,coupan_type,coupan_description)  
VALUES(1002,'PAYTM15','Paytm','Get 15%off using Paytm');
 
INSERT INTO coupan(coupan_id,coupan_name,coupan_type,coupan_description) 
VALUES(1003,'SIMPLWEEKEND','Simpl','Get 20%off using Simpl');