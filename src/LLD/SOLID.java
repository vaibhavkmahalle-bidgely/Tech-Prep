package LLD;

public class SOLID {
    // S - Single Responsibility Principle : A class should have only one reason to change.
    // O - Open for Extension but closed for Modification
    // Don't modify Already tested classes if needed extend them.

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
        Invoice invoice;

        public InvoiceTotal(Invoice invoice){
            this.invoice = invoice;
        }

        public int calulateTotal(){
            int price = ((invoice.marker.price)*invoice.quantity);
            return price;
        }

    }

    static class DBInvoiceDAO implements InvoiceDAO{
        Invoice invoice;

        public DBInvoiceDAO(Invoice invoice){
            this.invoice = invoice;
        }

        public void save(Invoice invoice){
            // save to DB
        }

        // Adding new method to InvoiceDao is not recommended
        public void saveToFile(){
            // PRONE TO ERRORS
        }
    }

    static class FileInvoiceDAO implements InvoiceDAO{
        Invoice invoice;

        public FileInvoiceDAO(Invoice invoice){
            this.invoice = invoice;
        }

        public void save(Invoice invoice){
            // save to File
        }


    }

    interface InvoiceDAO{
        public void save(Invoice invoice);
    }

    static class PrintInvoiceTotal{
        Invoice invoice;

        public PrintInvoiceTotal(Invoice invoice){
            this.invoice = invoice;
        }

        public void printTotal(){
            System.out.println("total is "+ ((invoice.marker).price)* invoice.quantity);
        }
    }

    public static void main(String[] args) {
        Invoice inv = new Invoice(new Marker("vaibhav","green",2025,25), 2);

        inv.printTotal();
    }

}
