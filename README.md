# Shop-Terminal
The task includes modeling and implementation of the loading process
and selling goods in a store

This project is a simulation of a store that sells goods. Each commodity is identified by an identification number, name, unit delivery price, and category (food and non-food goods). Additionally, each product has an expiration date. The selling price of the goods is determined by a markup percentage that is different for food and non-food goods and is set by the store. If a product is approaching its expiration date, the selling price is reduced by a certain percentage. The number of days until the expiration date and the percentage discount are different for each store. Expired goods cannot be sold.

The store is staffed by cashiers who have a name, an ID number, and a specific monthly salary. Each cashier works at a checkout, and there can only be one cashier at each checkout. When a customer wants to buy goods, the cashier marks the items. If the customer has enough money to buy the goods, the cashier sells them and issues a receipt.

If there is not enough quantity of a product available, an exception is thrown to indicate what commodity is missing to complete the purchase.

The receipt must contain the serial number, cashier who issues the receipt, date and time of issuance of the receipt, list of goods that are included in the receipt including their price and quantity, and the total value to be paid by the customer. The total number of receipts issued to date and the total amount that is generated as turnover on issuance are stored. Additionally, the receipt's contents are displayed and saved to a file. Each receipt should be kept in a separate file with a filename that contains the sequence number of the issued receipt. It is possible to check how many receipts have been issued at any given time, and the information in the file where the receipt is recorded must be readable.

For every store, it should be possible to calculate how much the costs are for salaries of cashiers and for the delivery of goods and how much revenue comes from goods sold. It is necessary to calculate the store's profit.

This project uses exception handling approaches and implements unit tests. It is developed in Java and fulfills the requirements described above.
