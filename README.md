0.本项目使用MySql数据库

1. 本项目部署在tomcat下，默认端口为：8080

2.访问URL：http://localhost:8080/core/

3.请用管理员账户登录：用户名：admin	
					  密  码：admin

4.功能名为：销售订单管理

5.第一个页面是销售订单汇总（orderSummary.html）

6.销售订单明细页面（addOrder.html）的入口为销售订单汇总页面grid上的 “新建” 按钮

7.在销售订单头信息表hap_om_order_headers中插入一条数据：
	insert into hap_om_order_headers (HEADER_ID,ORDER_NUMBER,COMPANY_ID,ORDER_DATE,ORDER_STATUS,CUSTOMER_ID) 
							values (1001,'1001',101,'2016-8-27 10:26:43','新建',201);


8.在销售订单行信息表hap_om_order_lines中插入一条数据：
	insert into hap_om_order_lines (LINE_ID,HEADER_ID,LINE_NUMBER,INVENTORY_ITEM_ID,ORDERD_QUANTITY,ORDER_QUANTITY_UOM,UNIT_SELLING_PRICE,DESCRIPTION,COMPANY_ID) values (1000,1001,1001,1001,103,'个',100,'橘子',101);


