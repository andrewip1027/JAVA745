/* Question 1) 
Consider a billing system containing the following entities.
        a)  a simple good, one that has price.
        b) a good that is sold by weight, so its attributes are its weight (in kgs), and its price per kg. 
        c) a good that is stored in bunches. Its attributes are the number of units in the bunch (no partial units are allowed) and the cost per unit.
All goods have a numeric UPC (Universal Product Code) and a name Services can also be purchased.
         a service that is charged at an hourly rate
         a service that has a at fee
All services have a name and an description.
All goods and services objects must have a method which gets the object's name, object's price
before tax, one which indicates whether the product is taxed and one which gives the price after tax.
*/

public class BulkGoods_Q1 extends Item { 
        //declared properties for package good 
        private int unitQuantity; 
        private double unitPrice;

        public BulkGoods(String itemNumber, String itemName, int quantity, double price){
                super(itemNumber, itemName, quantity * price);
                this.unitQuantity = quantity;
                this.unitPrice = price;
        }
        //retrieve package 
        public int getUnitQuantity(){
                return this.unitQuantity;
        }

        //
        public double getUnitPrice(){
                return this.unitPrice;
        }
}