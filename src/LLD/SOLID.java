package LLD;

public class SOLID {
    // S - Single Responsibility Principle : A class should have only one reason to change.

    static class Marker{
        String name;
        String color;
        int year;
        int price;

       public Marker (String name, String color,int year, int price){
           this.name = name;
           this.color = color;
           this.year = year;
           this.price = price;
       }
    }

    // Here Invoice class needs to be changed each time any of the calulateTotal, printTotal, saveToDB is changed so that class does not follow single Responsibility principle.
    // Break the current class in three subclasses InvoiceDao , printTotal, calculateTotal then it will follow single responsibility
    static class Invoice{
        private  Marker marker;
        private int quantity;

        public Invoice(Marker marker, int quantity){
            this.marker = marker;
            this.quantity = quantity;
        }

        public int calulateTotal(){
            int price = ((marker.price)*this.quantity);
            return price;
        }

        public void printTotal(){
            System.out.println("total is "+ ((marker.price)*this.quantity));
        }

        public void saveToDB(){

        }
    }

    static class InvoiceTotal{
        private  Marker marker;
        private int quantity;

        public InvoiceTotal(Marker marker, int quantity){
            this.marker = marker;
            this.quantity = quantity;
        }

        public int calulateTotal(){
            int price = ((marker.price)*this.quantity);
            return price;
        }

    }

    static class InvoiceDAO{
        private  Marker marker;
        private int quantity;

        public InvoiceDAO(Marker marker, int quantity){
            this.marker = marker;
            this.quantity = quantity;
        }

        public void saveToDB(){

        }
    }

    static class PrintInvoiceTotal{
        private  Marker marker;
        private int quantity;

        public PrintInvoiceTotal(Marker marker, int quantity){
            this.marker = marker;
            this.quantity = quantity;
        }

        public void printTotal(){
            System.out.println("total is "+ ((marker.price)*this.quantity));
        }
    }


    public static void main(String[] args) {
        Invoice inv = new Invoice(new Marker("vaibhav","green",2025,25), 2);

        inv.printTotal();
    }

}
