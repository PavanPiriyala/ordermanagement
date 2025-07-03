create database oms_db_f;

use oms_db_f;
go


CREATE TABLE orders (
    id INT PRIMARY KEY IDENTITY,
    user_id INT NOT NULL,
    order_date DATETIME,
    order_status VARCHAR(50),          --   "Pending", "Shipped", "Delivered"
	promo_discount DECIMAL(10,2),
    order_total DECIMAL(10, 2)
);


CREATE TABLE order_items (
    id INT PRIMARY KEY IDENTITY,
    order_id INT,
    product_id INT NOT NULL,
    sku VARCHAR(50),
    quantity INT,
    unit_price DECIMAL(10,2),
    discount DECIMAL(10,2),
    final_price DECIMAL(10,2),
    size VARCHAR(20),
    color VARCHAR(30),
    status VARCHAR(50),  -- e.g., Ordered, Cancelled, Returned
	seller_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
);





CREATE TABLE order_invoice (
    id INT PRIMARY KEY IDENTITY,
    order_id INT,
    invoice_number VARCHAR(100),
    invoice_date DATETIME,
    payment_mode VARCHAR(50),         --  "Credit Card", "UPI", "COD"
    invoice_amount DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);


CREATE TABLE shipments (
    id INT PRIMARY KEY IDENTITY,
    order_id INT,
    shipment_status VARCHAR(50),       -- e.g., "In Transit", "Delivered"
    shipment_tracking_id VARCHAR(100),
    shipment_date DATETIME,
    delivered_date DATETIME,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE shipment_items (	
    id INT PRIMARY KEY IDENTITY,
    shipment_id INT,
    order_item_id INT,
    item_status VARCHAR(50),           -- e.g., "In Transit", "Delivered"
    FOREIGN KEY (shipment_id) REFERENCES shipments(id),
    FOREIGN KEY (order_item_id) REFERENCES order_items(id)
);


CREATE TABLE order_returns (
    id INT PRIMARY KEY IDENTITY,
    order_item_id INT,
    return_date DATETIME,
    return_reason VARCHAR(255),
    return_status VARCHAR(50), -- e.g., Requested, Approved, Rejected, Completed
    refund_amount DECIMAL(10,2), 
    FOREIGN KEY (order_item_id) REFERENCES order_items(id)
);